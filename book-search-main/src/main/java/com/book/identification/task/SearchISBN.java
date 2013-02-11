// Copyright 2013 fernando.hernandez

// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at

//   http://www.apache.org/licenses/LICENSE-2.0

// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.book.identification.task;

import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.BookFile;
import com.book.identification.task.base.ProducerThread;

public abstract class SearchISBN extends ProducerThread<BookFile> {
	Logger logger = LogManager.getLogger(SearchISBN.class);
	/**
	 * 
	 */
	protected BookFile file;
	protected BlockingQueue<BookFile> fileISBNs;

	SearchISBN(BookFile filePdf, BlockingQueue<BookFile> fileISBNs) {
		this.file = filePdf;
		this.fileISBNs = fileISBNs;
	}

	protected abstract BookFile searchISBN(BookFile take);

	protected String findIsbn(String page) {
		String result = null;
		if (StringUtils.containsIgnoreCase(page, "ISBN")) {
			String isbn = extractISBN(page);
			if (isbn.isEmpty()) {
				result = null;
			} else {
				result = isbn;
			}
		}
		return result;
	}

	private String extractISBN(String pageText) {
		String result = executePattern(
				pageText,
				"ISBN(-1(?:(0)|3))?:?\\x20(\\s)*[0-9]+[- ][0-9]+[- ][0-9]+[- ][0-9]*[- ]*[xX0-9]");
		if (StringUtils.isEmpty(result))
			result = executePattern(
					pageText,
					"ISBN(?:-13)?:?\\x20*(?=.{17}$)97(?:8|9)([ -])\\d{1,5}\\1\\d{1,7}\\1\\d{1,6}\\1\\d$");
		if (StringUtils.isEmpty(result))
			result = executePattern(
					pageText,
					"/((978[\\--\u2013 ])?[0-9][0-9\\--\u2013 ]{10}[\\--\u2013 ][0-9xX])|((978)?[0-9]{9}[0-9Xx])/");
		if (StringUtils.isEmpty(result))
			result = executePattern(pageText, "^(97(8|9))?\\d{9}(\\d|X)$");
		if (StringUtils.isEmpty(result))
			result = executePattern(pageText,
					"ISBN\\x20(?=.{13}$)\\d{1,5}([- ])\\d{1,7}\\1\\d{1,6}\\1(\\d|X)$");
		if (StringUtils.isEmpty(result))
			result = executePattern(pageText,
					"^ISBN\\s(?=[-0-9xX ]{13}$)(?:[0-9]+[- ]){3}[0-9]*[xX0-9]$");
		if (StringUtils.isEmpty(result))
			result = executePattern(pageText, "^\\d{9}[\\d|X]$");
		if (StringUtils.isEmpty(result))
			result = extractZETAISBN(pageText);
		return result;
	}

	private String extractZETAISBN(String pageText) {
		int indexISBN = StringUtils.indexOfIgnoreCase(pageText, "ISBN");
		int indexOf = StringUtils.indexOf(pageText, " ", indexISBN + 15);
		if (indexOf > -1 && indexOf > indexISBN) {
			return StringUtils.substring(pageText, indexISBN, indexOf);
		}
		return "";

	}

	private String executePattern(String pageText, String regex) {
		String result = "";
		try {
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(pageText);
			while (matcher.find()) {
				result = matcher.group();
				if (!result.isEmpty()) {
					break;
				}
			}
		} catch (Exception e) {
			logger.error("Error in regex " + regex);
		}
		return result;

	}

	@Override
	public void run() {
		BookFile fileISBN = searchISBN(file);
		if( fileISBN.hasISBN()){
			 try {
				fileISBNs.put(fileISBN);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
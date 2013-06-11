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

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.BookFile;
import com.book.identification.task.base.Work;
import com.book.identification.volumes.ISBNExtract;
import com.book.identification.volumes.ISBNExtractorFactory;

public class SearchISBN extends Work<BookFile> {
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

	@Override
	public void run() {
		ISBNExtract isbnExtractor = ISBNExtractorFactory.getIsbnExtractor(file.getFileType());
		String isbn = isbnExtractor.searchISBN(file);
		file.setIsbn(isbn);
		if( file.hasISBN()){
			 try {
				fileISBNs.put(file);
			} catch (InterruptedException e) {
				logger.error(e);
			}
		}
	}

}
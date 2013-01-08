package com.book.identification.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.FileISBN;
import com.book.identification.task.base.ProducerThread;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;

public class SearchISBN extends ProducerThread<FileISBN> {
	Logger logger = LogManager.getLogger(SearchISBN.class);
	/**
	 * 
	 */
	private File file;
	private BlockingQueue<FileISBN> fileISBNs;

	SearchISBN(File file, BlockingQueue<FileISBN> fileISBNs) {
		this.file = file;
		this.fileISBNs = fileISBNs;
	}

	private void searchISBN(File take) {
		PdfReader reader;
		String result = "";
		try {
			logger.info("Openning: " + take.getName());
			reader = new PdfReader(new FileInputStream(take));
			int numberOfPages = reader.getNumberOfPages();
			logger.debug(take.getName() + " is open and contains "
					+ numberOfPages + " pages");
			PdfTextExtractor pdfTextExtractor = new PdfTextExtractor(reader);

			int middle = numberOfPages / 2;
			for (int page = 1; page <= middle; page++) {
				String firstPage = "";
				String lastPage = "";
				firstPage = pdfTextExtractor.getTextFromPage(page);
				lastPage = pdfTextExtractor.getTextFromPage(numberOfPages
						- page + 1);

				result = findIsbn(take, page, firstPage);
				if (StringUtils.isBlank(result)) {
					result = findIsbn(take, page, lastPage);
				}
				if (!StringUtils.isBlank(result)) {
					fileISBNs.put(new FileISBN(file, result));
					break;
				}
			}
		} catch (FileNotFoundException e1) {
			logger.error("can't open pdf: " + take.getName());
		} catch (IOException e1) {
			logger.error("can't open pdf: " + take.getName());
		} catch (Exception e1) {
			logger.error("can't open pdf: " + take.getName());
		} catch (Throwable e) {
			logger.error("can't open pdf: " + take.getName());
		}
	}

	private String findIsbn(File take, int page, String firstPage) {
		String result = null;
		if (StringUtils.containsIgnoreCase(firstPage, "ISBN")) {
			logger.info(take.getName() + ": isbn found on page " + page);
			String isbn = extractISBN(firstPage);
			if (isbn.isEmpty()) {
				logger.info(take.getName() + " isbn not match");
				result = null;
			} else {
				logger.debug(isbn);
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
		searchISBN(file);
	}

}
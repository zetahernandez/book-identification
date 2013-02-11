package com.book.identification.task;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.BookFile;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;

public class PDFSearchISBN extends SearchISBN {
	
	Logger logger = LogManager.getLogger(PDFSearchISBN.class);
	
	public PDFSearchISBN(BookFile filePdf, BlockingQueue<BookFile> fileISBNs) {
		super(filePdf, fileISBNs);
	}

	@Override
	protected BookFile searchISBN(BookFile take) {
		PdfReader reader;
		String result = "";
		try {
			logger.info("Openning: " + take.getFile().getName());
			reader = new PdfReader(new FileInputStream(take.getFile()));
			int numberOfPages = reader.getNumberOfPages();
			logger.debug(take.getFile().getName() + " is open and contains "
					+ numberOfPages + " pages");
			PdfTextExtractor pdfTextExtractor = new PdfTextExtractor(reader);

			int middle = numberOfPages / 2;
			for (int page = 1; page <= middle; page++) {
				String firstPage = "";
				String lastPage = "";
				firstPage = pdfTextExtractor.getTextFromPage(page);
				lastPage = pdfTextExtractor.getTextFromPage(numberOfPages
						- page + 1);

				result = findIsbn(firstPage);
				if (StringUtils.isBlank(result)) {
					result = findIsbn(lastPage);
				}
				if (!StringUtils.isBlank(result)) {
					take.setIsbn(result);
					break;
				}
			}
		} catch (FileNotFoundException e1) {
			logger.error("can't open pdf: " + take.getFile().getName());
		} catch (IOException e1) {
			logger.error("can't open pdf: " + take.getFile().getName());
		} catch (Exception e1) {
			logger.error("can't open pdf: " + take.getFile().getName());
		} catch (Throwable e) {
			logger.error("can't open pdf: " + take.getFile().getName());
		}
		return take;
	}

}

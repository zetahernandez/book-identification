package com.book.identification.work;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.work.exceptions.CantOpenFileException;
import com.book.identification.work.exceptions.ISBNNotFoundExecption;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;

public class PDFISBNExtractor extends ISBNExtractor {
	
	Logger logger = LogManager.getLogger(PDFISBNExtractor.class);
	
	@Override
	public String foundISBN(File take) throws CantOpenFileException, ISBNNotFoundExecption {
		PdfReader reader;
		String result = "";
		try {
			logger.info("Openning: " + take.getName());
			reader = new PdfReader(new BufferedInputStream(new  FileInputStream(take)));
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

				result = findIsbn(firstPage);
				if (StringUtils.isBlank(result)) {
					result = findIsbn(lastPage);
				}
				if(StringUtils.isNotBlank(result)){
					break;
				}
			}
		} catch (FileNotFoundException e1) {
			logger.error("can't open pdf: " + take.getName());
			throw new CantOpenFileException(e1);
		} catch (IOException e1) {
			logger.error("can't open pdf: " + take.getName());
			throw new CantOpenFileException(e1);
		} catch (Exception e1) {
			logger.error("can't open pdf: " + take.getName());
			throw new CantOpenFileException(e1);
		} catch (Throwable e) {
			logger.error("can't open pdf: " + take.getName());
			throw new CantOpenFileException(e);
		}
		if(StringUtils.isBlank(result)){
			throw new ISBNNotFoundExecption(take);
		}
		return result;
	}

}

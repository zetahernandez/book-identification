package com.book.identification.volumes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.chm.CHMDocumentInformation;

import com.book.identification.BookFile;

public class CHMISBNExtractor extends ISBNExtractor {
	Logger logger = LogManager.getLogger(CHMISBNExtractor.class);

	@Override
	public String searchISBN(BookFile take) {
		String result = "";
		try {
			CHMDocumentInformation load = CHMDocumentInformation.load(new FileInputStream(take.getFile()));
			String page = load.getText();
			
			result = findIsbn(page);

			if (!StringUtils.isBlank(result)) {
				take.setIsbn(result);
			}
		} catch (FileNotFoundException e) {
			logger.error("Can't Read Chm file", e);
		} catch (TikaException e) {
			logger.error("Can't Read Chm file", e);
		} catch (IOException e) {
			logger.error("Can't Read Chm file", e);
		}
		return result;
	}

}

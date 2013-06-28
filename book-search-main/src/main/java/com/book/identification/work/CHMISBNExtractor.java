package com.book.identification.work;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.tika.exception.TikaException;
import org.apache.tika.parser.chm.CHMDocumentInformation;

import com.book.identification.work.exceptions.CantOpenFileException;
import com.book.identification.work.exceptions.ISBNNotFoundExecption;

public class CHMISBNExtractor extends ISBNExtractor {
	Logger logger = LogManager.getLogger(CHMISBNExtractor.class);

	@Override
	public String foundISBN(File take) throws ISBNNotFoundExecption, CantOpenFileException {
		String result = "";
		try {
			CHMDocumentInformation load = CHMDocumentInformation.load(FileUtils.openInputStream(take));
			String page = load.getText();
			
			result = findIsbn(page);

		} catch (FileNotFoundException e) {
			logger.error("Can't Read Chm file", e);
			throw new CantOpenFileException(e);
		} catch (TikaException e) {
			logger.error("Can't Read Chm file", e);
			throw new CantOpenFileException(e);
		} catch (IOException e) {
			logger.error("Can't Read Chm file", e);
			throw new CantOpenFileException(e);
		}
		if(StringUtils.isBlank(result)){
			throw new ISBNNotFoundExecption(take);
		}
		return result;
	}

}

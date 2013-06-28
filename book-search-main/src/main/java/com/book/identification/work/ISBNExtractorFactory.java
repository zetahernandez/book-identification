package com.book.identification.volumes;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.book.identification.FileType;

public class ISBNExtractorFactory {
	final static Logger logger = LogManager.getLogger(ISBNExtractorFactory.class);

	public static synchronized ISBNExtract getIsbnExtractor(FileType fileType) {
	ISBNExtract result = null;
		if(fileType.equals(FileType.PDF)){
			result = new PDFISBNExtractor();
		}else if(fileType.equals(FileType.CHM)){
			result = new CHMISBNExtractor();
		}
		return result;
	}

}

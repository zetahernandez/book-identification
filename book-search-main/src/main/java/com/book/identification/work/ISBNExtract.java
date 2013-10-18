package com.book.identification.work;

import java.io.File;

import com.book.identification.work.exceptions.CantOpenFileException;
import com.book.identification.work.exceptions.ISBNNotFoundExecption;

public interface ISBNExtract {
	String foundISBN(File take) throws CantOpenFileException,
			ISBNNotFoundExecption;

}

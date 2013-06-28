package com.book.identification.work.exceptions;

import java.io.File;

public class ISBNNotFoundExecption extends Exception implements IdentificationException {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4976502438260925071L;

	public ISBNNotFoundExecption(File take) {
	}

	@Override
	public IdentificationError getIdentificationError() {
		return IdentificationError.ISBN_NOT_FOUND;
	}
	
	
}

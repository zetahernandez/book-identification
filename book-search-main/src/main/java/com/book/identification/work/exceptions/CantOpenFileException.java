package com.book.identification.work.exceptions;



public class CantOpenFileException extends Exception implements IdentificationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6151986321067855308L;

	public CantOpenFileException(Throwable e) {
		super(e);
	}

	@Override
	public IdentificationError getIdentificationError() {
		// TODO Auto-generated method stub
		return IdentificationError.ERROR_FILE;
	}

	
}

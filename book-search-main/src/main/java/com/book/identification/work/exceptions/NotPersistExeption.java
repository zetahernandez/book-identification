package com.book.identification.work.exceptions;

public class NotPersistExeption extends Exception implements IdentificationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8274948069965636131L;

	public NotPersistExeption(Exception e) {
		super(e);
	}

	@Override
	public IdentificationError getIdentificationError() {
		return IdentificationError.NOT_PERSIST_VOLUME;
	}

}

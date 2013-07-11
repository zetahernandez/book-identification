package com.book.identification.work.exceptions;

public class VolumeNotFoundExecption extends Exception implements IdentificationException {

	private String isbn;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7178941228443340901L;

	
	
	public VolumeNotFoundExecption(String isbn) {
		super();
		this.isbn = isbn;
	}

	@Override
	public IdentificationError getIdentificationError() {
		return IdentificationError.VOLUME_NOT_FOUND;
	}

	public String getISBN() {
		return isbn;
	}

}

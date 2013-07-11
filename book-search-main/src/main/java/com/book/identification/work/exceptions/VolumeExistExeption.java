package com.book.identification.work.exceptions;

public class VolumeExistExeption extends Exception implements IdentificationException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5364575846524452262L;

	@Override
	public IdentificationError getIdentificationError() {
		return IdentificationError.VOLUME_EXIST;
	}

}

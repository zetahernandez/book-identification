package com.book.identification.work.exceptions;

public class VolumeNotFoundExecption extends Exception implements IdentificationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7178941228443340901L;

	@Override
	public IdentificationError getIdentificationError() {
		return IdentificationError.VOLUME_NOT_FOUND;
	}

}

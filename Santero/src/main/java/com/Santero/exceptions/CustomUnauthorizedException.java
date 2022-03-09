package com.Santero.exceptions;

public class CustomUnauthorizedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -610116970392520245L;
	
	public CustomUnauthorizedException() {
		super();
	}

	public CustomUnauthorizedException(String message) {
		super(message);
	}
}

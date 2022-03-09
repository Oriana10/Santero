package com.Santero.exceptions;

public class CustomParameterConstraintException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4972548590735649471L;

	public CustomParameterConstraintException() {
		super();
	}
	
	 public CustomParameterConstraintException(String message) {
	        super(message);
	 }
}

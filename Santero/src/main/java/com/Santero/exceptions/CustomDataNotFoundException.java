package com.Santero.exceptions;

public class CustomDataNotFoundException extends RuntimeException {  
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 4403621136597115729L;

	public CustomDataNotFoundException() {
        super();
    }

    public CustomDataNotFoundException(String message) {
        super(message);
    }
    
}
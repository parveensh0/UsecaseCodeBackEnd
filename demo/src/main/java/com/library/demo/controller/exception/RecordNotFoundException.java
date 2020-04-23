package com.library.demo.controller.exception;

/**
 * Custom Exception thrown
 * 
 */
public class RecordNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -108580826327183744L;

	public RecordNotFoundException(String string) {
		super(string);
	}
}

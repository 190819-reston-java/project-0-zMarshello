package com.revature.exception;

public class InvalidSelectionException extends RuntimeException {
	
	public InvalidSelectionException () {
		super("This selection is not within range.");
	}
	
	public InvalidSelectionException (String message) {
		super(message);
	}
	
}

package com.revature.exception;

public class InvalidSelectionException extends RuntimeException {
	
	public InvalidSelectionException () {
		System.out.println("This selection is not within range.");
	}
	
	public InvalidSelectionException (String message) {
		super(message);
	}
	
}

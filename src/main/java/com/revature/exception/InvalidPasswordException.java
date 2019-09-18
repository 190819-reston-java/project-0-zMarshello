package com.revature.exception;

public class InvalidPasswordException extends RuntimeException{

	public InvalidPasswordException() {
		super("Your password did not meet requirements. Please try again.");
	}

	public InvalidPasswordException(String s) {
		super(s);
	}
}

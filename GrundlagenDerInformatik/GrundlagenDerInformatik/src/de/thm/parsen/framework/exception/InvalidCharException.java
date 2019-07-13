package de.thm.parsen.framework.exception;

@SuppressWarnings("serial")
public class InvalidCharException extends RuntimeException {

	public InvalidCharException(char c) {
		super("Invalid char: " + c);
	}
	
}

package de.thm.parsen.framework.exception;

import java.util.Arrays;

import de.thm.parsen.framework.Token;

@SuppressWarnings("serial")
public class TokenTypeException extends RuntimeException {

	public TokenTypeException(String[] expectedTokenTypes, Token usedToken) {
		super("Expected " + Arrays.toString(expectedTokenTypes) + " but was " + usedToken);
	}
	
}

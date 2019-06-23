package de.thm.parsen.list;

import de.thm.parsen.framework.Token;

public enum TokenType {
	
	EOF("<EOF>"),
	NAME,
	COMMA(","),
	LBRACK("["),
	RBRACK("]");
	
	private final String value;
	
	private TokenType(String value) {
		this.value = value;
	}
	
	private TokenType() { 
		value = null; 
	}
	
	public final String 
	
	public Token getToken() {
		return new Token(value, name());
	}

}
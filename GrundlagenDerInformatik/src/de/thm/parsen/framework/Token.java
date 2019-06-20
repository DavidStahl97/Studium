package de.thm.parsen.framework;

import de.thm.parsen.list.ListLexer;

public class Token {
	
	private String text;
	private String typeName;
	
	public Token(String text, String typeName) {
		this.text = text;
		this.typeName = typeName;
	}
	
	public String getText() {
		return text;
	}
	
	@Override
	public String toString() {
		return "<'" + text + "', " + typeName + ">";
	}
	
}

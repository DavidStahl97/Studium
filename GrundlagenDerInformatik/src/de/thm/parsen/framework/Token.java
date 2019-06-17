package de.thm.parsen.framework;

import de.thm.parsen.list.ListLexer;

public class Token {
	
	private int type;
	private String text;
	private String typeName;
	
	public Token(int type, String text, String typeName) {
		this.type = type;
		this.text = text;
		this.typeName = typeName;
	}

	public int getType() {
		return type;
	}
	
	public String getText() {
		return text;
	}
	
	@Override
	public String toString() {
		return "<'" + text + "', " + typeName + ">";
	}
	
}

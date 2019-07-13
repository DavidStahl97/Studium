package de.thm.antlr.arithmetic;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

public class Main {
	public static void main(String[] args) throws Exception {
		var s = "(34+234)*3\n";
		var input = new ANTLRStringStream(s);

		var lexer = new arithmeticLexer(input); 
		var tokens = new CommonTokenStream(lexer); 
		var parser = new arithmeticParser(tokens); 
		parser.prog(); 
	}
}

package de.thm.antlr.arithmetic2;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;

public class Main {
	public static void main(String[] args) throws Exception {
		var s = "x = 5\n" +
				"y = 8\n" +
				"z = (x + y) / 2\n" +
				"z\n";
		var input = new ANTLRStringStream(s);

		var lexer = new ArithmeticV2Lexer(input); 
		var tokens = new CommonTokenStream(lexer); 
		var parser = new ArithmeticV2Parser(tokens); 
		parser.prog();
	}
}

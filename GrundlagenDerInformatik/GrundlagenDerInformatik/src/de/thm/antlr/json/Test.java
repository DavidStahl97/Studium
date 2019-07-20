package de.thm.antlr.json;

import java.io.IOException;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;

import de.thm.antlr.json.output.JsonGeneratorASTLexer;
import de.thm.antlr.json.output.JsonGeneratorASTParser;

public class Test {

	public static void main(String[] args) {
		
		try {
			var input = new ANTLRFileStream("C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\output\\test.txt", "UTF8");
			
			var lexer = new JsonGeneratorASTLexer();
			var tokenStream = new CommonTokenStream(lexer);
			var parser = new JsonGeneratorASTParser(tokenStream);
			
			parser.prog();
		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

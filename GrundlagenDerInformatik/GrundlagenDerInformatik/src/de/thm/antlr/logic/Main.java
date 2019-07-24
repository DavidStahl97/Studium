package de.thm.antlr.logic;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import de.thm.antlr.logic.output.LogicGrammaticLexer;
import de.thm.antlr.logic.output.LogicGrammaticParser;
import de.thm.antlr.logic.output.LogicGrammaticTree;

public class Main {

	public static void main(String[] args) {
		
		try {

			var input = new ANTLRFileStream("C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\output\\test.txt", "UTF8");

			var lexer = new LogicGrammaticLexer(input); 
			var tokens = new CommonTokenStream(lexer); 
			var parser = new LogicGrammaticParser(tokens);
			
			System.out.println("Creating tree");
			var tree = parser.prog();
			System.out.println();
			
			var nodes = new CommonTreeNodeStream(tree.getTree());
			var walker = new LogicGrammaticTree(nodes);
			
			System.out.println("read tree");
			walker.prog();	
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

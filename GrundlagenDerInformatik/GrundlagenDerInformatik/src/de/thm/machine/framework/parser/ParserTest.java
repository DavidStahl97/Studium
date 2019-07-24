package de.thm.machine.framework.parser;

import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import de.thm.machine.framework.parser.output.*;


public class ParserTest {

	public static void main(String[] args) {
		try {
			
			var input = new ANTLRFileStream("C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\output\\test.txt", "UTF8");

			var lexer = new FileParserLexer(input); 
			var tokens = new CommonTokenStream(lexer); 
			var parser = new FileParserParser(tokens);
			
			System.out.println("Creating tree");
			var tree = parser.lines();
			System.out.println();
			
			var nodes = new CommonTreeNodeStream(tree.getTree());
			var walker = new FiniteStateMachineTree(nodes);
			
			System.out.println("read tree");
			walker.prog();	
			
		}
		catch (Exception e) {
			System.out.println(e);
		}

    }
	
}

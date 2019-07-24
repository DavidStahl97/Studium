package de.thm.antlr.json;

import de.thm.antlr.json.output.JsonGeneratorASTLexer;
import de.thm.antlr.json.output.JsonGeneratorASTParser;
import de.thm.antlr.json.output.JsonGeneratorTree;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTreeNodeStream;

public class Main {

    public static void main(String[] args) throws Exception {

        var input = new ANTLRFileStream("C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\output\\test.txt");
        var lexer = new JsonGeneratorASTLexer(input);
        var tokenStream = new CommonTokenStream(lexer);
        var parser = new JsonGeneratorASTParser(tokenStream);

        System.out.println("create AST");
        var tree = parser.list();
        System.out.println(tree);
        System.out.println();

        var nodes = new CommonTreeNodeStream(tree.getTree());
        var walker = new JsonGeneratorTree(nodes);

        System.out.println("read tree");
        var json = walker.list();

        System.out.println();
        System.out.println(json);
    }

}

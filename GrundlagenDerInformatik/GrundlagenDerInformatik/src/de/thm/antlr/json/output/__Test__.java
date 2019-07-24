import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import de.thm.antlr.json.output.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        JsonGeneratorASTLexer lex = new JsonGeneratorASTLexer(new ANTLRFileStream("C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        JsonGeneratorASTParser g = new JsonGeneratorASTParser(tokens, 49100, null);
        try {
            g.list();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}
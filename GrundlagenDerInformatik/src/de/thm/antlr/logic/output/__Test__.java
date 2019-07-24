import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import de.thm.antlr.logic.output.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        LogicGrammaticLexer lex = new LogicGrammaticLexer(new ANTLRFileStream("C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\output\\__Test___input.txt", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        LogicGrammaticParser g = new LogicGrammaticParser(tokens, 49100, null);
        try {
            g.prog();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}
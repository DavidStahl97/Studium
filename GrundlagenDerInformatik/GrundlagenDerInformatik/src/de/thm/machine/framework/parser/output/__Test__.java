import java.io.*;
import org.antlr.runtime.*;
import org.antlr.runtime.debug.DebugEventSocketProxy;

import de.thm.machine.framework.parser.*;


public class __Test__ {

    public static void main(String args[]) throws Exception {
        FiniteStateMachineParserLexer lex = new FiniteStateMachineParserLexer(new ANTLRFileStream("C:\\Users\\dstah\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\2. Berechenbarkeit\\1. Aufgaben - Automaten\\Automaten\\Lehrbuch - Aufgabe 34b.fsm", "UTF8"));
        CommonTokenStream tokens = new CommonTokenStream(lex);

        FiniteStateMachineParserParser g = new FiniteStateMachineParserParser(tokens, 49100, null);
        try {
            g.lines();
        } catch (RecognitionException e) {
            e.printStackTrace();
        }
    }
}
// $ANTLR 3.5.1 C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g 2019-07-13 19:40:16
 package de.thm.machine.framework.parser; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FiniteStateMachineParserLexer extends Lexer {
	public static final int EOF=-1;
	public static final int BLANK=4;
	public static final int ID=5;
	public static final int NEWLINE=6;
	public static final int WS=7;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public FiniteStateMachineParserLexer() {} 
	public FiniteStateMachineParserLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public FiniteStateMachineParserLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g"; }

	// $ANTLR start "BLANK"
	public final void mBLANK() throws RecognitionException {
		try {
			int _type = BLANK;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:17:7: ( '_' )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:17:9: '_'
			{
			match('_'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "BLANK"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:18:4: ( ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+ )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:18:6: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+
			{
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:18:6: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:20:9: ( ( ( '\\r' )? '\\n' ) )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:20:11: ( ( '\\r' )? '\\n' )
			{
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:20:11: ( ( '\\r' )? '\\n' )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:20:12: ( '\\r' )? '\\n'
			{
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:20:12: ( '\\r' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\r') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:20:12: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NEWLINE"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:21:4: ( ( ' ' | '\\t' )+ )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:21:6: ( ' ' | '\\t' )+
			{
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:21:6: ( ' ' | '\\t' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( (LA3_0=='\t'||LA3_0==' ') ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:
					{
					if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:1:8: ( BLANK | ID | NEWLINE | WS )
		int alt4=4;
		switch ( input.LA(1) ) {
		case '_':
			{
			alt4=1;
			}
			break;
		case '0':
		case '1':
		case '2':
		case '3':
		case '4':
		case '5':
		case '6':
		case '7':
		case '8':
		case '9':
		case 'A':
		case 'B':
		case 'C':
		case 'D':
		case 'E':
		case 'F':
		case 'G':
		case 'H':
		case 'I':
		case 'J':
		case 'K':
		case 'L':
		case 'M':
		case 'N':
		case 'O':
		case 'P':
		case 'Q':
		case 'R':
		case 'S':
		case 'T':
		case 'U':
		case 'V':
		case 'W':
		case 'X':
		case 'Y':
		case 'Z':
		case 'a':
		case 'b':
		case 'c':
		case 'd':
		case 'e':
		case 'f':
		case 'g':
		case 'h':
		case 'i':
		case 'j':
		case 'k':
		case 'l':
		case 'm':
		case 'n':
		case 'o':
		case 'p':
		case 'q':
		case 'r':
		case 's':
		case 't':
		case 'u':
		case 'v':
		case 'w':
		case 'x':
		case 'y':
		case 'z':
			{
			alt4=2;
			}
			break;
		case '\n':
		case '\r':
			{
			alt4=3;
			}
			break;
		case '\t':
		case ' ':
			{
			alt4=4;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 4, 0, input);
			throw nvae;
		}
		switch (alt4) {
			case 1 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:1:10: BLANK
				{
				mBLANK(); 

				}
				break;
			case 2 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:1:16: ID
				{
				mID(); 

				}
				break;
			case 3 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:1:19: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 4 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:1:27: WS
				{
				mWS(); 

				}
				break;

		}
	}



}

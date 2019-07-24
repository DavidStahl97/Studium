// $ANTLR 3.5.1 C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g 2019-07-21 13:41:51
 package de.thm.antlr.logic.output; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class LogicGrammaticLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int AND=4;
	public static final int EQ=5;
	public static final int FALSE=6;
	public static final int ID=7;
	public static final int IMPL=8;
	public static final int NEWLINE=9;
	public static final int NOT=10;
	public static final int OR=11;
	public static final int TRUE=12;
	public static final int WS=13;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public LogicGrammaticLexer() {} 
	public LogicGrammaticLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public LogicGrammaticLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g"; }

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:4:7: ( '(' )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:4:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__14"

	// $ANTLR start "T__15"
	public final void mT__15() throws RecognitionException {
		try {
			int _type = T__15;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:5:7: ( ')' )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:5:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:6:7: ( '=' )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:6:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "EQ"
	public final void mEQ() throws RecognitionException {
		try {
			int _type = EQ;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:24:4: ( '==' )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:24:6: '=='
			{
			match("=="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQ"

	// $ANTLR start "IMPL"
	public final void mIMPL() throws RecognitionException {
		try {
			int _type = IMPL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:25:6: ( '->' )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:25:8: '->'
			{
			match("->"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IMPL"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:26:4: ( '||' )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:26:6: '||'
			{
			match("||"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:27:5: ( '&&' )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:27:7: '&&'
			{
			match("&&"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "NOT"
	public final void mNOT() throws RecognitionException {
		try {
			int _type = NOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:28:5: ( '!' )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:28:7: '!'
			{
			match('!'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT"

	// $ANTLR start "TRUE"
	public final void mTRUE() throws RecognitionException {
		try {
			int _type = TRUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:30:6: ( 'True' )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:30:8: 'True'
			{
			match("True"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "TRUE"

	// $ANTLR start "FALSE"
	public final void mFALSE() throws RecognitionException {
		try {
			int _type = FALSE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:31:7: ( 'False' )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:31:9: 'False'
			{
			match("False"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FALSE"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:33:4: ( ( 'a' .. 'z' )+ )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:33:6: ( 'a' .. 'z' )+
			{
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:33:6: ( 'a' .. 'z' )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:
					{
					if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:35:9: ( ( '\\r' )? '\\n' )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:35:11: ( '\\r' )? '\\n'
			{
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:35:11: ( '\\r' )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0=='\r') ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:35:11: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
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
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:36:4: ( ( ' ' | '\\t' )+ )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:36:6: ( ' ' | '\\t' )+
			{
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:36:6: ( ' ' | '\\t' )+
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
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:
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

			skip();
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
		// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:8: ( T__14 | T__15 | T__16 | EQ | IMPL | OR | AND | NOT | TRUE | FALSE | ID | NEWLINE | WS )
		int alt4=13;
		switch ( input.LA(1) ) {
		case '(':
			{
			alt4=1;
			}
			break;
		case ')':
			{
			alt4=2;
			}
			break;
		case '=':
			{
			int LA4_3 = input.LA(2);
			if ( (LA4_3=='=') ) {
				alt4=4;
			}

			else {
				alt4=3;
			}

			}
			break;
		case '-':
			{
			alt4=5;
			}
			break;
		case '|':
			{
			alt4=6;
			}
			break;
		case '&':
			{
			alt4=7;
			}
			break;
		case '!':
			{
			alt4=8;
			}
			break;
		case 'T':
			{
			alt4=9;
			}
			break;
		case 'F':
			{
			alt4=10;
			}
			break;
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
			alt4=11;
			}
			break;
		case '\n':
		case '\r':
			{
			alt4=12;
			}
			break;
		case '\t':
		case ' ':
			{
			alt4=13;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 4, 0, input);
			throw nvae;
		}
		switch (alt4) {
			case 1 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:10: T__14
				{
				mT__14(); 

				}
				break;
			case 2 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:16: T__15
				{
				mT__15(); 

				}
				break;
			case 3 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:22: T__16
				{
				mT__16(); 

				}
				break;
			case 4 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:28: EQ
				{
				mEQ(); 

				}
				break;
			case 5 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:31: IMPL
				{
				mIMPL(); 

				}
				break;
			case 6 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:36: OR
				{
				mOR(); 

				}
				break;
			case 7 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:39: AND
				{
				mAND(); 

				}
				break;
			case 8 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:43: NOT
				{
				mNOT(); 

				}
				break;
			case 9 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:47: TRUE
				{
				mTRUE(); 

				}
				break;
			case 10 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:52: FALSE
				{
				mFALSE(); 

				}
				break;
			case 11 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:58: ID
				{
				mID(); 

				}
				break;
			case 12 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:61: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 13 :
				// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:1:69: WS
				{
				mWS(); 

				}
				break;

		}
	}



}

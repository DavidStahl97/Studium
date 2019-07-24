// $ANTLR 3.5.1 C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g 2019-07-20 20:05:30
 package de.thm.antlr.json.output; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class JsonGeneratorASTLexer extends Lexer {
	public static final int EOF=-1;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int DEFINE=4;
	public static final int ID=5;
	public static final int NEWLINE=6;
	public static final int VALUE=7;
	public static final int WS=8;

	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public JsonGeneratorASTLexer() {} 
	public JsonGeneratorASTLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public JsonGeneratorASTLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g"; }

	// $ANTLR start "T__9"
	public final void mT__9() throws RecognitionException {
		try {
			int _type = T__9;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:4:6: ( '\"' )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:4:8: '\"'
			{
			match('\"'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__9"

	// $ANTLR start "T__10"
	public final void mT__10() throws RecognitionException {
		try {
			int _type = T__10;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:5:7: ( '(' )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:5:9: '('
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
	// $ANTLR end "T__10"

	// $ANTLR start "T__11"
	public final void mT__11() throws RecognitionException {
		try {
			int _type = T__11;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:6:7: ( ')' )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:6:9: ')'
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
	// $ANTLR end "T__11"

	// $ANTLR start "T__12"
	public final void mT__12() throws RecognitionException {
		try {
			int _type = T__12;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:7:7: ( ',' )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:7:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__12"

	// $ANTLR start "T__13"
	public final void mT__13() throws RecognitionException {
		try {
			int _type = T__13;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:8:7: ( 'ATTR' )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:8:9: 'ATTR'
			{
			match("ATTR"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__13"

	// $ANTLR start "T__14"
	public final void mT__14() throws RecognitionException {
		try {
			int _type = T__14;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:9:7: ( 'LIST' )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:9:9: 'LIST'
			{
			match("LIST"); 

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
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:10:7: ( 'OBJECT' )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:10:9: 'OBJECT'
			{
			match("OBJECT"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__15"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:21:4: ( ( 'a' .. 'z' )+ )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:21:6: ( 'a' .. 'z' )+
			{
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:21:6: ( 'a' .. 'z' )+
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
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:
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

	// $ANTLR start "VALUE"
	public final void mVALUE() throws RecognitionException {
		try {
			int _type = VALUE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:22:7: ( ( '0' .. '9' )+ )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:22:9: ( '0' .. '9' )+
			{
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:22:9: ( '0' .. '9' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
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
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VALUE"

	// $ANTLR start "DEFINE"
	public final void mDEFINE() throws RecognitionException {
		try {
			int _type = DEFINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:24:8: ( '=' )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:24:10: '='
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
	// $ANTLR end "DEFINE"

	// $ANTLR start "NEWLINE"
	public final void mNEWLINE() throws RecognitionException {
		try {
			int _type = NEWLINE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:26:9: ( ( '\\r' )? '\\n' )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:26:11: ( '\\r' )? '\\n'
			{
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:26:11: ( '\\r' )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0=='\r') ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:26:11: '\\r'
					{
					match('\r'); 
					}
					break;

			}

			match('\n'); 
			skip();
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
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:27:4: ( ( ' ' | '\\t' )+ )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:27:6: ( ' ' | '\\t' )+
			{
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:27:6: ( ' ' | '\\t' )+
			int cnt4=0;
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='\t'||LA4_0==' ') ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:
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
					if ( cnt4 >= 1 ) break loop4;
					EarlyExitException eee = new EarlyExitException(4, input);
					throw eee;
				}
				cnt4++;
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
		// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:8: ( T__9 | T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | ID | VALUE | DEFINE | NEWLINE | WS )
		int alt5=12;
		switch ( input.LA(1) ) {
		case '\"':
			{
			alt5=1;
			}
			break;
		case '(':
			{
			alt5=2;
			}
			break;
		case ')':
			{
			alt5=3;
			}
			break;
		case ',':
			{
			alt5=4;
			}
			break;
		case 'A':
			{
			alt5=5;
			}
			break;
		case 'L':
			{
			alt5=6;
			}
			break;
		case 'O':
			{
			alt5=7;
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
			alt5=8;
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
			{
			alt5=9;
			}
			break;
		case '=':
			{
			alt5=10;
			}
			break;
		case '\n':
		case '\r':
			{
			alt5=11;
			}
			break;
		case '\t':
		case ' ':
			{
			alt5=12;
			}
			break;
		default:
			NoViableAltException nvae =
				new NoViableAltException("", 5, 0, input);
			throw nvae;
		}
		switch (alt5) {
			case 1 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:10: T__9
				{
				mT__9(); 

				}
				break;
			case 2 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:15: T__10
				{
				mT__10(); 

				}
				break;
			case 3 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:21: T__11
				{
				mT__11(); 

				}
				break;
			case 4 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:27: T__12
				{
				mT__12(); 

				}
				break;
			case 5 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:33: T__13
				{
				mT__13(); 

				}
				break;
			case 6 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:39: T__14
				{
				mT__14(); 

				}
				break;
			case 7 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:45: T__15
				{
				mT__15(); 

				}
				break;
			case 8 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:51: ID
				{
				mID(); 

				}
				break;
			case 9 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:54: VALUE
				{
				mVALUE(); 

				}
				break;
			case 10 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:60: DEFINE
				{
				mDEFINE(); 

				}
				break;
			case 11 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:67: NEWLINE
				{
				mNEWLINE(); 

				}
				break;
			case 12 :
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:1:75: WS
				{
				mWS(); 

				}
				break;

		}
	}



}

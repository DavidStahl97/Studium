// $ANTLR 3.5.1 C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g 2019-07-11 11:43:27
package de.thm.antlr.arithmetic;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class arithmeticParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "NEWLINE", "WS", 
		"'('", "')'", "'*'", "'+'", "'-'", "'='"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int ID=4;
	public static final int INT=5;
	public static final int NEWLINE=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public arithmeticParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public arithmeticParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return arithmeticParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g"; }



	// $ANTLR start "prog"
	// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:6:1: prog : ( stat )+ ;
	public final void prog() throws RecognitionException {
		try {
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:6:5: ( ( stat )+ )
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:6:7: ( stat )+
			{
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:6:7: ( stat )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= ID && LA1_0 <= NEWLINE)||LA1_0==8) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:6:7: stat
					{
					pushFollow(FOLLOW_stat_in_prog25);
					stat();
					state._fsp--;

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

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "prog"



	// $ANTLR start "stat"
	// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:7:1: stat : ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE );
	public final void stat() throws RecognitionException {
		try {
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:7:5: ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE )
			int alt2=3;
			switch ( input.LA(1) ) {
			case INT:
			case 8:
				{
				alt2=1;
				}
				break;
			case ID:
				{
				int LA2_2 = input.LA(2);
				if ( (LA2_2==13) ) {
					alt2=2;
				}
				else if ( (LA2_2==NEWLINE||(LA2_2 >= 10 && LA2_2 <= 12)) ) {
					alt2=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

				}
				break;
			case NEWLINE:
				{
				alt2=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:7:7: expr NEWLINE
					{
					pushFollow(FOLLOW_expr_in_stat33);
					expr();
					state._fsp--;

					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat35); 
					}
					break;
				case 2 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:7:22: ID '=' expr NEWLINE
					{
					match(input,ID,FOLLOW_ID_in_stat39); 
					match(input,13,FOLLOW_13_in_stat41); 
					pushFollow(FOLLOW_expr_in_stat43);
					expr();
					state._fsp--;

					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat45); 
					}
					break;
				case 3 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:7:44: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat49); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "stat"



	// $ANTLR start "expr"
	// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:8:1: expr : multExpr ( ( '+' | '-' ) multExpr )* ;
	public final void expr() throws RecognitionException {
		try {
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:8:5: ( multExpr ( ( '+' | '-' ) multExpr )* )
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:8:7: multExpr ( ( '+' | '-' ) multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_expr55);
			multExpr();
			state._fsp--;

			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:8:16: ( ( '+' | '-' ) multExpr )*
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= 11 && LA3_0 <= 12)) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:8:17: ( '+' | '-' ) multExpr
					{
					if ( (input.LA(1) >= 11 && input.LA(1) <= 12) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr64);
					multExpr();
					state._fsp--;

					}
					break;

				default :
					break loop3;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "expr"



	// $ANTLR start "multExpr"
	// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:9:1: multExpr : atom ( '*' atom )* ;
	public final void multExpr() throws RecognitionException {
		try {
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:9:9: ( atom ( '*' atom )* )
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:9:11: atom ( '*' atom )*
			{
			pushFollow(FOLLOW_atom_in_multExpr73);
			atom();
			state._fsp--;

			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:9:16: ( '*' atom )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==10) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:9:17: '*' atom
					{
					match(input,10,FOLLOW_10_in_multExpr76); 
					pushFollow(FOLLOW_atom_in_multExpr78);
					atom();
					state._fsp--;

					}
					break;

				default :
					break loop4;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "atom"
	// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:10:1: atom : ( INT | ID | '(' expr ')' );
	public final void atom() throws RecognitionException {
		try {
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:10:5: ( INT | ID | '(' expr ')' )
			int alt5=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt5=1;
				}
				break;
			case ID:
				{
				alt5=2;
				}
				break;
			case 8:
				{
				alt5=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}
			switch (alt5) {
				case 1 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:10:7: INT
					{
					match(input,INT,FOLLOW_INT_in_atom87); 
					}
					break;
				case 2 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:10:13: ID
					{
					match(input,ID,FOLLOW_ID_in_atom91); 
					}
					break;
				case 3 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\Arithmetik\\arithmetic.g:10:18: '(' expr ')'
					{
					match(input,8,FOLLOW_8_in_atom95); 
					pushFollow(FOLLOW_expr_in_atom97);
					expr();
					state._fsp--;

					match(input,9,FOLLOW_9_in_atom99); 
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atom"

	// Delegated rules



	public static final BitSet FOLLOW_stat_in_prog25 = new BitSet(new long[]{0x0000000000000172L});
	public static final BitSet FOLLOW_expr_in_stat33 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat35 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat39 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_stat41 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_expr_in_stat43 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat45 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_stat49 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr55 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_set_in_expr58 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_multExpr_in_expr64 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_atom_in_multExpr73 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_10_in_multExpr76 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_atom_in_multExpr78 = new BitSet(new long[]{0x0000000000000402L});
	public static final BitSet FOLLOW_INT_in_atom87 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom91 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_atom95 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_expr_in_atom97 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_atom99 = new BitSet(new long[]{0x0000000000000002L});
}

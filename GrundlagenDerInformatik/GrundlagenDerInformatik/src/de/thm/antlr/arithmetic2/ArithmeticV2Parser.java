// $ANTLR 3.5.1 C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g 2019-07-11 14:12:07

	package de.thm.antlr.arithmetic2;
	import java.util.HashMap;
	

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ArithmeticV2Parser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "INT", "NEWLINE", "WS", 
		"'('", "')'", "'*'", "'+'", "'-'", "'/'", "'='"
	};
	public static final int EOF=-1;
	public static final int T__8=8;
	public static final int T__9=9;
	public static final int T__10=10;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int ID=4;
	public static final int INT=5;
	public static final int NEWLINE=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public ArithmeticV2Parser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public ArithmeticV2Parser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return ArithmeticV2Parser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g"; }

	 HashMap<String, Double> memory = new HashMap<String, Double>(); 


	// $ANTLR start "prog"
	// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:12:1: prog : ( stat )+ ;
	public final void prog() throws RecognitionException {
		try {
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:12:5: ( ( stat )+ )
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:12:7: ( stat )+
			{
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:12:7: ( stat )+
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
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:12:7: stat
					{
					pushFollow(FOLLOW_stat_in_prog36);
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
	// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:13:1: stat : ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE );
	public final void stat() throws RecognitionException {
		Token ID2=null;
		double expr1 =0.0;
		double expr3 =0.0;

		try {
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:13:5: ( expr NEWLINE | ID '=' expr NEWLINE | NEWLINE )
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
				if ( (LA2_2==14) ) {
					alt2=2;
				}
				else if ( (LA2_2==NEWLINE||(LA2_2 >= 10 && LA2_2 <= 13)) ) {
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
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:16:2: expr NEWLINE
					{
					pushFollow(FOLLOW_expr_in_stat49);
					expr1=expr();
					state._fsp--;

					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat51); 
					System.out.println(expr1);
					}
					break;
				case 2 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:19:2: ID '=' expr NEWLINE
					{
					ID2=(Token)match(input,ID,FOLLOW_ID_in_stat63); 
					match(input,14,FOLLOW_14_in_stat65); 
					pushFollow(FOLLOW_expr_in_stat67);
					expr3=expr();
					state._fsp--;

					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat69); 
					memory.put((ID2!=null?ID2.getText():null), new Double(expr3));
					}
					break;
				case 3 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:21:2: NEWLINE
					{
					match(input,NEWLINE,FOLLOW_NEWLINE_in_stat78); 
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
	// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:23:1: expr returns [double value] : e= multExpr ( '+' e= multExpr | '-' e= multExpr )* ;
	public final double expr() throws RecognitionException {
		double value = 0.0;


		double e =0.0;

		try {
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:23:28: (e= multExpr ( '+' e= multExpr | '-' e= multExpr )* )
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:24:2: e= multExpr ( '+' e= multExpr | '-' e= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_expr94);
			e=multExpr();
			state._fsp--;

			value = e;
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:25:2: ( '+' e= multExpr | '-' e= multExpr )*
			loop3:
			while (true) {
				int alt3=3;
				int LA3_0 = input.LA(1);
				if ( (LA3_0==11) ) {
					alt3=1;
				}
				else if ( (LA3_0==12) ) {
					alt3=2;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:25:4: '+' e= multExpr
					{
					match(input,11,FOLLOW_11_in_expr102); 
					pushFollow(FOLLOW_multExpr_in_expr106);
					e=multExpr();
					state._fsp--;

					value = value + e;
					}
					break;
				case 2 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:27:4: '-' e= multExpr
					{
					match(input,12,FOLLOW_12_in_expr117); 
					pushFollow(FOLLOW_multExpr_in_expr121);
					e=multExpr();
					state._fsp--;

					value = value - e;
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
		return value;
	}
	// $ANTLR end "expr"



	// $ANTLR start "atom"
	// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:30:1: atom returns [double value] : ( INT | ID | '(' expr ')' );
	public final double atom() throws RecognitionException {
		double value = 0.0;


		Token INT4=null;
		Token ID5=null;
		double expr6 =0.0;

		try {
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:30:28: ( INT | ID | '(' expr ')' )
			int alt4=3;
			switch ( input.LA(1) ) {
			case INT:
				{
				alt4=1;
				}
				break;
			case ID:
				{
				alt4=2;
				}
				break;
			case 8:
				{
				alt4=3;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:32:2: INT
					{
					INT4=(Token)match(input,INT,FOLLOW_INT_in_atom146); 
					value = (double) Integer.parseInt((INT4!=null?INT4.getText():null));
					}
					break;
				case 2 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:34:3: ID
					{
					ID5=(Token)match(input,ID,FOLLOW_ID_in_atom157); 
					 Double v = (double)memory.get((ID5!=null?ID5.getText():null)); 
						 // wird ein Wert gefunden, ist es der Rückgabewert 
						 // sonst gibt es einen Fehler 
						 if(v != null) value = v.doubleValue(); 
						 else System.err.println("undefined var: " + (ID5!=null?ID5.getText():null)); 
					}
					break;
				case 3 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:41:3: '(' expr ')'
					{
					match(input,8,FOLLOW_8_in_atom172); 
					pushFollow(FOLLOW_expr_in_atom174);
					expr6=expr();
					state._fsp--;

					match(input,9,FOLLOW_9_in_atom176); 
					value = expr6;
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
		return value;
	}
	// $ANTLR end "atom"



	// $ANTLR start "multExpr"
	// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:45:1: multExpr returns [double value] : e= atom ( '*' e= atom | '/' e= atom )* ;
	public final double multExpr() throws RecognitionException {
		double value = 0.0;


		double e =0.0;

		try {
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:45:32: (e= atom ( '*' e= atom | '/' e= atom )* )
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:46:2: e= atom ( '*' e= atom | '/' e= atom )*
			{
			pushFollow(FOLLOW_atom_in_multExpr196);
			e=atom();
			state._fsp--;

			value = (double) e;
			// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:47:2: ( '*' e= atom | '/' e= atom )*
			loop5:
			while (true) {
				int alt5=3;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==10) ) {
					alt5=1;
				}
				else if ( (LA5_0==13) ) {
					alt5=2;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:47:3: '*' e= atom
					{
					match(input,10,FOLLOW_10_in_multExpr202); 
					pushFollow(FOLLOW_atom_in_multExpr206);
					e=atom();
					state._fsp--;

					value *= e;
					}
					break;
				case 2 :
					// C:\\Users\\de18702\\OneDrive\\Duales Studium\\Technische Hochschule Mittelhessen\\2. Semester\\Grundlagen der Informatik\\7. Parsergeneratoren\\ArithmeticExpGrammaticV2\\ArithmeticV2.g:49:3: '/' e= atom
					{
					match(input,13,FOLLOW_13_in_multExpr217); 
					pushFollow(FOLLOW_atom_in_multExpr221);
					e=atom();
					state._fsp--;

					value /= e;
					}
					break;

				default :
					break loop5;
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
		return value;
	}
	// $ANTLR end "multExpr"

	// Delegated rules



	public static final BitSet FOLLOW_stat_in_prog36 = new BitSet(new long[]{0x0000000000000172L});
	public static final BitSet FOLLOW_expr_in_stat49 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat51 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat63 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_14_in_stat65 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_expr_in_stat67 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_NEWLINE_in_stat69 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_stat78 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr94 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_11_in_expr102 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_multExpr_in_expr106 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_12_in_expr117 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_multExpr_in_expr121 = new BitSet(new long[]{0x0000000000001802L});
	public static final BitSet FOLLOW_INT_in_atom146 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom157 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_8_in_atom172 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_expr_in_atom174 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_atom176 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atom_in_multExpr196 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_10_in_multExpr202 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_atom_in_multExpr206 = new BitSet(new long[]{0x0000000000002402L});
	public static final BitSet FOLLOW_13_in_multExpr217 = new BitSet(new long[]{0x0000000000000130L});
	public static final BitSet FOLLOW_atom_in_multExpr221 = new BitSet(new long[]{0x0000000000002402L});
}

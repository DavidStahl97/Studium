// $ANTLR 3.5.1 C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g 2019-07-11 20:55:44
 
	package de.thm.antlr.logic.output;
	import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class LogicGrammaticTree extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "EQ", "FALSE", "ID", "IMPL", 
		"NEWLINE", "NOT", "OR", "TRUE", "WS", "'('", "')'", "'='"
	};
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
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public LogicGrammaticTree(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public LogicGrammaticTree(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return LogicGrammaticTree.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g"; }


		HashMap<String, Boolean> memory = new HashMap<String, Boolean>();
		
		void cache(String id, boolean val) {
			memory.put(id, new Boolean(val));
		}
		
		boolean load(String id) {
			Boolean b = (Boolean)memory.get(id);
			if(b != null) {
				return b.booleanValue();
			}
			else {
				throw new RuntimeException("Die Variable " + id + " wurde nicht definiert.");
			}
		}



	// $ANTLR start "prog"
	// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:31:1: prog : ( stat )+ ;
	public final void prog() throws RecognitionException {
		try {
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:31:6: ( ( stat )+ )
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:31:8: ( stat )+
			{
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:31:8: ( stat )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= AND && LA1_0 <= IMPL)||(LA1_0 >= NOT && LA1_0 <= TRUE)||LA1_0==16) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:31:9: stat
					{
					pushFollow(FOLLOW_stat_in_prog45);
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
	// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:33:1: stat : ( expr | ^( '=' ID expr ) );
	public final void stat() throws RecognitionException {
		CommonTree ID2=null;
		boolean expr1 =false;
		boolean expr3 =false;

		try {
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:33:6: ( expr | ^( '=' ID expr ) )
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( ((LA2_0 >= AND && LA2_0 <= IMPL)||(LA2_0 >= NOT && LA2_0 <= TRUE)) ) {
				alt2=1;
			}
			else if ( (LA2_0==16) ) {
				alt2=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 2, 0, input);
				throw nvae;
			}

			switch (alt2) {
				case 1 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:33:8: expr
					{
					pushFollow(FOLLOW_expr_in_stat55);
					expr1=expr();
					state._fsp--;

					System.out.println(expr1);
					}
					break;
				case 2 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:34:5: ^( '=' ID expr )
					{
					match(input,16,FOLLOW_16_in_stat66); 
					match(input, Token.DOWN, null); 
					ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_stat68); 
					pushFollow(FOLLOW_expr_in_stat70);
					expr3=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 cache((ID2!=null?ID2.getText():null), expr3); System.out.println((ID2!=null?ID2.getText():null) + " = " + expr3); 
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
	// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:37:1: expr returns [boolean value] : ( ^( NOT a= expr ) | ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( IMPL a= expr b= expr ) | ^( EQ a= expr b= expr ) | ID | TRUE | FALSE );
	public final boolean expr() throws RecognitionException {
		boolean value = false;


		CommonTree ID4=null;
		boolean a =false;
		boolean b =false;

		try {
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:37:29: ( ^( NOT a= expr ) | ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( IMPL a= expr b= expr ) | ^( EQ a= expr b= expr ) | ID | TRUE | FALSE )
			int alt3=8;
			switch ( input.LA(1) ) {
			case NOT:
				{
				alt3=1;
				}
				break;
			case AND:
				{
				alt3=2;
				}
				break;
			case OR:
				{
				alt3=3;
				}
				break;
			case IMPL:
				{
				alt3=4;
				}
				break;
			case EQ:
				{
				alt3=5;
				}
				break;
			case ID:
				{
				alt3=6;
				}
				break;
			case TRUE:
				{
				alt3=7;
				}
				break;
			case FALSE:
				{
				alt3=8;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:39:2: ^( NOT a= expr )
					{
					match(input,NOT,FOLLOW_NOT_in_expr92); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr96);
					a=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = !a; 
					}
					break;
				case 2 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:40:2: ^( AND a= expr b= expr )
					{
					match(input,AND,FOLLOW_AND_in_expr105); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr109);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr113);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = a && b; 
					}
					break;
				case 3 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:41:2: ^( OR a= expr b= expr )
					{
					match(input,OR,FOLLOW_OR_in_expr122); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr126);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr130);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = a || b; 
					}
					break;
				case 4 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:42:2: ^( IMPL a= expr b= expr )
					{
					match(input,IMPL,FOLLOW_IMPL_in_expr139); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr143);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr147);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = !a || (a && b); 
					}
					break;
				case 5 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:43:2: ^( EQ a= expr b= expr )
					{
					match(input,EQ,FOLLOW_EQ_in_expr156); 
					match(input, Token.DOWN, null); 
					pushFollow(FOLLOW_expr_in_expr160);
					a=expr();
					state._fsp--;

					pushFollow(FOLLOW_expr_in_expr164);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 

					 value = a == b; 
					}
					break;
				case 6 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:45:2: ID
					{
					ID4=(CommonTree)match(input,ID,FOLLOW_ID_in_expr174); 
					 value = load((ID4!=null?ID4.getText():null)); 
					}
					break;
				case 7 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:47:2: TRUE
					{
					match(input,TRUE,FOLLOW_TRUE_in_expr183); 
					 value = true; 
					}
					break;
				case 8 :
					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:48:2: FALSE
					{
					match(input,FALSE,FOLLOW_FALSE_in_expr190); 
					 value = false; 
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
	// $ANTLR end "expr"

	// Delegated rules



	public static final BitSet FOLLOW_stat_in_prog45 = new BitSet(new long[]{0x0000000000011DF2L});
	public static final BitSet FOLLOW_expr_in_stat55 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_stat66 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_stat68 = new BitSet(new long[]{0x0000000000001DF0L});
	public static final BitSet FOLLOW_expr_in_stat70 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_expr92 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr96 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_expr105 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr109 = new BitSet(new long[]{0x0000000000001DF0L});
	public static final BitSet FOLLOW_expr_in_expr113 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expr122 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr126 = new BitSet(new long[]{0x0000000000001DF0L});
	public static final BitSet FOLLOW_expr_in_expr130 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IMPL_in_expr139 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr143 = new BitSet(new long[]{0x0000000000001DF0L});
	public static final BitSet FOLLOW_expr_in_expr147 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expr156 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr160 = new BitSet(new long[]{0x0000000000001DF0L});
	public static final BitSet FOLLOW_expr_in_expr164 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_expr174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_expr183 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_expr190 = new BitSet(new long[]{0x0000000000000002L});
}

// $ANTLR 3.5.1 C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g 2019-07-14 17:14:37
 
	package de.thm.antlr.logic.output;
	import java.util.HashMap;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
@SuppressWarnings("all")
public class LogicGrammaticTree extends DebugTreeParser {
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


	public static final String[] ruleNames = new String[] {
		"invalidRule", "prog", "expr", "stat"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public LogicGrammaticTree(TreeNodeStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public LogicGrammaticTree(TreeNodeStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this, port, input.getTreeAdaptor());

		setDebugListener(proxy);
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
	}

	public LogicGrammaticTree(TreeNodeStream input, DebugEventListener dbg) {
		super(input, dbg, new RecognizerSharedState());
	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

	@Override public String[] getTokenNames() { return LogicGrammaticTree.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g"; }


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
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:32:1: prog : ( stat )+ ;
	public final void prog() throws RecognitionException {
		try { dbg.enterRule(getGrammarFileName(), "prog");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(32, 0);

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:32:6: ( ( stat )+ )
			dbg.enterAlt(1);

			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:32:8: ( stat )+
			{
			dbg.location(32,8);
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:32:8: ( stat )+
			int cnt1=0;
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=2;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= AND && LA1_0 <= IMPL)||(LA1_0 >= NOT && LA1_0 <= TRUE)||LA1_0==16) ) {
					alt1=1;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:32:9: stat
					{
					dbg.location(32,9);
					pushFollow(FOLLOW_stat_in_prog46);
					stat();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt1++;
			}
			} finally {dbg.exitSubRule(1);}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(32, 14);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "prog");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "prog"



	// $ANTLR start "stat"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:34:1: stat : ( expr | ^( '=' ID expr ) );
	public final void stat() throws RecognitionException {
		CommonTree ID2=null;
		boolean expr1 =false;
		boolean expr3 =false;

		try { dbg.enterRule(getGrammarFileName(), "stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(34, 0);

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:34:6: ( expr | ^( '=' ID expr ) )
			int alt2=2;
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

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
				dbg.recognitionException(nvae);
				throw nvae;
			}

			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:34:8: expr
					{
					dbg.location(34,8);
					pushFollow(FOLLOW_expr_in_stat56);
					expr1=expr();
					state._fsp--;
					dbg.location(34,13);
					System.out.println(expr1);
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:35:5: ^( '=' ID expr )
					{
					dbg.location(35,5);
					dbg.location(35,7);
					match(input,16,FOLLOW_16_in_stat67); 
					match(input, Token.DOWN, null); 
					dbg.location(35,11);
					ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_stat69); dbg.location(35,14);
					pushFollow(FOLLOW_expr_in_stat71);
					expr3=expr();
					state._fsp--;

					match(input, Token.UP, null); 
					dbg.location(35,20);
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
		dbg.location(35, 104);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

	}
	// $ANTLR end "stat"



	// $ANTLR start "expr"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:38:1: expr returns [boolean value] : ( ^( NOT a= expr ) | ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( IMPL a= expr b= expr ) | ^( EQ a= expr b= expr ) | ID | TRUE | FALSE );
	public final boolean expr() throws RecognitionException {
		boolean value = false;


		CommonTree ID4=null;
		boolean a =false;
		boolean b =false;

		try { dbg.enterRule(getGrammarFileName(), "expr");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(38, 0);

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:38:29: ( ^( NOT a= expr ) | ^( AND a= expr b= expr ) | ^( OR a= expr b= expr ) | ^( IMPL a= expr b= expr ) | ^( EQ a= expr b= expr ) | ID | TRUE | FALSE )
			int alt3=8;
			try { dbg.enterDecision(3, decisionCanBacktrack[3]);

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
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(3);}

			switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:40:2: ^( NOT a= expr )
					{
					dbg.location(40,2);
					dbg.location(40,4);
					match(input,NOT,FOLLOW_NOT_in_expr93); 
					match(input, Token.DOWN, null); 
					dbg.location(40,9);
					pushFollow(FOLLOW_expr_in_expr97);
					a=expr();
					state._fsp--;

					match(input, Token.UP, null); 
					dbg.location(40,16);
					 value = !a; 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:41:2: ^( AND a= expr b= expr )
					{
					dbg.location(41,2);
					dbg.location(41,4);
					match(input,AND,FOLLOW_AND_in_expr106); 
					match(input, Token.DOWN, null); 
					dbg.location(41,9);
					pushFollow(FOLLOW_expr_in_expr110);
					a=expr();
					state._fsp--;
					dbg.location(41,16);
					pushFollow(FOLLOW_expr_in_expr114);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 
					dbg.location(41,23);
					 value = a && b; 
					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:42:2: ^( OR a= expr b= expr )
					{
					dbg.location(42,2);
					dbg.location(42,4);
					match(input,OR,FOLLOW_OR_in_expr123); 
					match(input, Token.DOWN, null); 
					dbg.location(42,8);
					pushFollow(FOLLOW_expr_in_expr127);
					a=expr();
					state._fsp--;
					dbg.location(42,15);
					pushFollow(FOLLOW_expr_in_expr131);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 
					dbg.location(42,22);
					 value = a || b; 
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:43:2: ^( IMPL a= expr b= expr )
					{
					dbg.location(43,2);
					dbg.location(43,4);
					match(input,IMPL,FOLLOW_IMPL_in_expr140); 
					match(input, Token.DOWN, null); 
					dbg.location(43,10);
					pushFollow(FOLLOW_expr_in_expr144);
					a=expr();
					state._fsp--;
					dbg.location(43,17);
					pushFollow(FOLLOW_expr_in_expr148);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 
					dbg.location(43,24);
					 value = !a || (a && b); 
					}
					break;
				case 5 :
					dbg.enterAlt(5);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:44:2: ^( EQ a= expr b= expr )
					{
					dbg.location(44,2);
					dbg.location(44,4);
					match(input,EQ,FOLLOW_EQ_in_expr157); 
					match(input, Token.DOWN, null); 
					dbg.location(44,8);
					pushFollow(FOLLOW_expr_in_expr161);
					a=expr();
					state._fsp--;
					dbg.location(44,15);
					pushFollow(FOLLOW_expr_in_expr165);
					b=expr();
					state._fsp--;

					match(input, Token.UP, null); 
					dbg.location(44,22);
					 value = a == b; 
					}
					break;
				case 6 :
					dbg.enterAlt(6);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:46:2: ID
					{
					dbg.location(46,2);
					ID4=(CommonTree)match(input,ID,FOLLOW_ID_in_expr175); dbg.location(46,5);
					 value = load((ID4!=null?ID4.getText():null)); 
					}
					break;
				case 7 :
					dbg.enterAlt(7);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:48:2: TRUE
					{
					dbg.location(48,2);
					match(input,TRUE,FOLLOW_TRUE_in_expr184); dbg.location(48,7);
					 value = true; 
					}
					break;
				case 8 :
					dbg.enterAlt(8);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammaticTree.g:49:2: FALSE
					{
					dbg.location(49,2);
					match(input,FALSE,FOLLOW_FALSE_in_expr191); dbg.location(49,8);
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
		dbg.location(49, 26);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "expr");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return value;
	}
	// $ANTLR end "expr"

	// Delegated rules



	public static final BitSet FOLLOW_stat_in_prog46 = new BitSet(new long[]{0x0000000000011DF2L});
	public static final BitSet FOLLOW_expr_in_stat56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_stat67 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_stat69 = new BitSet(new long[]{0x0000000000001DF0L});
	public static final BitSet FOLLOW_expr_in_stat71 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NOT_in_expr93 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr97 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_AND_in_expr106 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr110 = new BitSet(new long[]{0x0000000000001DF0L});
	public static final BitSet FOLLOW_expr_in_expr114 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_OR_in_expr123 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr127 = new BitSet(new long[]{0x0000000000001DF0L});
	public static final BitSet FOLLOW_expr_in_expr131 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_IMPL_in_expr140 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr144 = new BitSet(new long[]{0x0000000000001DF0L});
	public static final BitSet FOLLOW_expr_in_expr148 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EQ_in_expr157 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_expr_in_expr161 = new BitSet(new long[]{0x0000000000001DF0L});
	public static final BitSet FOLLOW_expr_in_expr165 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_ID_in_expr175 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_expr184 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_expr191 = new BitSet(new long[]{0x0000000000000002L});
}

// $ANTLR 3.5.1 C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g 2019-07-21 13:41:51
 package de.thm.antlr.logic.output; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class LogicGrammaticParser extends DebugParser {
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
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "prog", "eq", "or", "bool", "stat", "and", "impl", "not"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false, false, false, false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public LogicGrammaticParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public LogicGrammaticParser(TokenStream input, int port, RecognizerSharedState state) {
		super(input, state);
		DebugEventSocketProxy proxy =
			new DebugEventSocketProxy(this,port,adaptor);
		setDebugListener(proxy);
		setTokenStream(new DebugTokenStream(input,proxy));
		try {
			proxy.handshake();
		}
		catch (IOException ioe) {
			reportError(ioe);
		}
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);
		proxy.setTreeAdaptor(adap);
	}

	public LogicGrammaticParser(TokenStream input, DebugEventListener dbg) {
		super(input, dbg);
		 
		TreeAdaptor adap = new CommonTreeAdaptor();
		setTreeAdaptor(adap);

	}

	protected boolean evalPredicate(boolean result, String predicate) {
		dbg.semanticPredicate(result, predicate);
		return result;
	}

		protected DebugTreeAdaptor adaptor;
		public void setTreeAdaptor(TreeAdaptor adaptor) {
			this.adaptor = new DebugTreeAdaptor(dbg,adaptor);
		}
		public TreeAdaptor getTreeAdaptor() {
			return adaptor;
		}
	@Override public String[] getTokenNames() { return LogicGrammaticParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g"; }


	public static class prog_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "prog"
	// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:11:1: prog : ( stat )+ ;
	public final LogicGrammaticParser.prog_return prog() throws RecognitionException {
		LogicGrammaticParser.prog_return retval = new LogicGrammaticParser.prog_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope stat1 =null;


		try { dbg.enterRule(getGrammarFileName(), "prog");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(11, 0);

		try {
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:11:6: ( ( stat )+ )
			dbg.enterAlt(1);

			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:11:8: ( stat )+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(11,8);
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:11:8: ( stat )+
			int cnt1=0;
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=2;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= FALSE && LA1_0 <= ID)||(LA1_0 >= NEWLINE && LA1_0 <= NOT)||LA1_0==TRUE||LA1_0==14) ) {
					alt1=1;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:11:9: stat
					{
					dbg.location(11,9);
					pushFollow(FOLLOW_stat_in_prog47);
					stat1=stat();
					state._fsp--;

					adaptor.addChild(root_0, stat1.getTree());
					dbg.location(11,14);
					System.out.println((stat1!=null?((CommonTree)stat1.getTree()):null) == null ? "null" : (stat1!=null?((CommonTree)stat1.getTree()):null).toStringTree());
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

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(11, 93);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "prog");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "prog"


	public static class stat_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "stat"
	// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:13:1: stat : ( eq NEWLINE !| ID '=' eq NEWLINE -> ^( '=' ID eq ) | NEWLINE ->);
	public final LogicGrammaticParser.stat_return stat() throws RecognitionException {
		LogicGrammaticParser.stat_return retval = new LogicGrammaticParser.stat_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NEWLINE3=null;
		Token ID4=null;
		Token char_literal5=null;
		Token NEWLINE7=null;
		Token NEWLINE8=null;
		ParserRuleReturnScope eq2 =null;
		ParserRuleReturnScope eq6 =null;

		CommonTree NEWLINE3_tree=null;
		CommonTree ID4_tree=null;
		CommonTree char_literal5_tree=null;
		CommonTree NEWLINE7_tree=null;
		CommonTree NEWLINE8_tree=null;
		RewriteRuleTokenStream stream_16=new RewriteRuleTokenStream(adaptor,"token 16");
		RewriteRuleTokenStream stream_NEWLINE=new RewriteRuleTokenStream(adaptor,"token NEWLINE");
		RewriteRuleTokenStream stream_ID=new RewriteRuleTokenStream(adaptor,"token ID");
		RewriteRuleSubtreeStream stream_eq=new RewriteRuleSubtreeStream(adaptor,"rule eq");

		try { dbg.enterRule(getGrammarFileName(), "stat");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(13, 0);

		try {
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:13:6: ( eq NEWLINE !| ID '=' eq NEWLINE -> ^( '=' ID eq ) | NEWLINE ->)
			int alt2=3;
			try { dbg.enterDecision(2, decisionCanBacktrack[2]);

			switch ( input.LA(1) ) {
			case FALSE:
			case NOT:
			case TRUE:
			case 14:
				{
				alt2=1;
				}
				break;
			case ID:
				{
				int LA2_2 = input.LA(2);
				if ( (LA2_2==16) ) {
					alt2=2;
				}
				else if ( ((LA2_2 >= AND && LA2_2 <= EQ)||(LA2_2 >= IMPL && LA2_2 <= NEWLINE)||LA2_2==OR) ) {
					alt2=1;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 2, 2, input);
						dbg.recognitionException(nvae);
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
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(2);}

			switch (alt2) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:13:8: eq NEWLINE !
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(13,8);
					pushFollow(FOLLOW_eq_in_stat59);
					eq2=eq();
					state._fsp--;

					adaptor.addChild(root_0, eq2.getTree());
					dbg.location(13,18);
					NEWLINE3=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat61); 
					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:14:3: ID '=' eq NEWLINE
					{
					dbg.location(14,3);
					ID4=(Token)match(input,ID,FOLLOW_ID_in_stat68);  
					stream_ID.add(ID4);
					dbg.location(14,6);
					char_literal5=(Token)match(input,16,FOLLOW_16_in_stat70);  
					stream_16.add(char_literal5);
					dbg.location(14,10);
					pushFollow(FOLLOW_eq_in_stat72);
					eq6=eq();
					state._fsp--;

					stream_eq.add(eq6.getTree());dbg.location(14,13);
					NEWLINE7=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat74);  
					stream_NEWLINE.add(NEWLINE7);

					// AST REWRITE
					// elements: 16, eq, ID
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 14:21: -> ^( '=' ID eq )
					{
						dbg.location(14,24);
						// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:14:24: ^( '=' ID eq )
						{
						CommonTree root_1 = (CommonTree)adaptor.nil();
						dbg.location(14,26);
						root_1 = (CommonTree)adaptor.becomeRoot(stream_16.nextNode(), root_1);
						dbg.location(14,30);
						adaptor.addChild(root_1, stream_ID.nextNode());dbg.location(14,33);
						adaptor.addChild(root_1, stream_eq.nextTree());
						adaptor.addChild(root_0, root_1);
						}

					}


					retval.tree = root_0;

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:15:3: NEWLINE
					{
					dbg.location(15,3);
					NEWLINE8=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_stat90);  
					stream_NEWLINE.add(NEWLINE8);

					// AST REWRITE
					// elements: 
					// token labels: 
					// rule labels: retval
					// token list labels: 
					// rule list labels: 
					// wildcard labels: 
					retval.tree = root_0;
					RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.getTree():null);

					root_0 = (CommonTree)adaptor.nil();
					// 15:11: ->
					{
						dbg.location(15,14);
						root_0 = null;
					}


					retval.tree = root_0;

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(15, 13);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "stat");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "stat"


	public static class eq_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "eq"
	// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:17:1: eq : impl ( EQ ^ impl )* ;
	public final LogicGrammaticParser.eq_return eq() throws RecognitionException {
		LogicGrammaticParser.eq_return retval = new LogicGrammaticParser.eq_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQ10=null;
		ParserRuleReturnScope impl9 =null;
		ParserRuleReturnScope impl11 =null;

		CommonTree EQ10_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "eq");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(17, 0);

		try {
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:17:4: ( impl ( EQ ^ impl )* )
			dbg.enterAlt(1);

			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:17:6: impl ( EQ ^ impl )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(17,6);
			pushFollow(FOLLOW_impl_in_eq101);
			impl9=impl();
			state._fsp--;

			adaptor.addChild(root_0, impl9.getTree());
			dbg.location(17,11);
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:17:11: ( EQ ^ impl )*
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=2;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( (LA3_0==EQ) ) {
					alt3=1;
				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:17:12: EQ ^ impl
					{
					dbg.location(17,14);
					EQ10=(Token)match(input,EQ,FOLLOW_EQ_in_eq104); 
					EQ10_tree = (CommonTree)adaptor.create(EQ10);
					root_0 = (CommonTree)adaptor.becomeRoot(EQ10_tree, root_0);
					dbg.location(17,16);
					pushFollow(FOLLOW_impl_in_eq107);
					impl11=impl();
					state._fsp--;

					adaptor.addChild(root_0, impl11.getTree());

					}
					break;

				default :
					break loop3;
				}
			}
			} finally {dbg.exitSubRule(3);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(17, 21);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "eq");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "eq"


	public static class impl_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "impl"
	// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:18:1: impl : or ( IMPL ^ or )* ;
	public final LogicGrammaticParser.impl_return impl() throws RecognitionException {
		LogicGrammaticParser.impl_return retval = new LogicGrammaticParser.impl_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IMPL13=null;
		ParserRuleReturnScope or12 =null;
		ParserRuleReturnScope or14 =null;

		CommonTree IMPL13_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "impl");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(18, 0);

		try {
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:18:6: ( or ( IMPL ^ or )* )
			dbg.enterAlt(1);

			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:18:8: or ( IMPL ^ or )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(18,8);
			pushFollow(FOLLOW_or_in_impl116);
			or12=or();
			state._fsp--;

			adaptor.addChild(root_0, or12.getTree());
			dbg.location(18,11);
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:18:11: ( IMPL ^ or )*
			try { dbg.enterSubRule(4);

			loop4:
			while (true) {
				int alt4=2;
				try { dbg.enterDecision(4, decisionCanBacktrack[4]);

				int LA4_0 = input.LA(1);
				if ( (LA4_0==IMPL) ) {
					alt4=1;
				}

				} finally {dbg.exitDecision(4);}

				switch (alt4) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:18:12: IMPL ^ or
					{
					dbg.location(18,16);
					IMPL13=(Token)match(input,IMPL,FOLLOW_IMPL_in_impl119); 
					IMPL13_tree = (CommonTree)adaptor.create(IMPL13);
					root_0 = (CommonTree)adaptor.becomeRoot(IMPL13_tree, root_0);
					dbg.location(18,18);
					pushFollow(FOLLOW_or_in_impl122);
					or14=or();
					state._fsp--;

					adaptor.addChild(root_0, or14.getTree());

					}
					break;

				default :
					break loop4;
				}
			}
			} finally {dbg.exitSubRule(4);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(18, 21);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "impl");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "impl"


	public static class or_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "or"
	// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:19:1: or : and ( OR ^ and )* ;
	public final LogicGrammaticParser.or_return or() throws RecognitionException {
		LogicGrammaticParser.or_return retval = new LogicGrammaticParser.or_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token OR16=null;
		ParserRuleReturnScope and15 =null;
		ParserRuleReturnScope and17 =null;

		CommonTree OR16_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "or");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(19, 0);

		try {
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:19:4: ( and ( OR ^ and )* )
			dbg.enterAlt(1);

			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:19:6: and ( OR ^ and )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(19,6);
			pushFollow(FOLLOW_and_in_or131);
			and15=and();
			state._fsp--;

			adaptor.addChild(root_0, and15.getTree());
			dbg.location(19,10);
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:19:10: ( OR ^ and )*
			try { dbg.enterSubRule(5);

			loop5:
			while (true) {
				int alt5=2;
				try { dbg.enterDecision(5, decisionCanBacktrack[5]);

				int LA5_0 = input.LA(1);
				if ( (LA5_0==OR) ) {
					alt5=1;
				}

				} finally {dbg.exitDecision(5);}

				switch (alt5) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:19:11: OR ^ and
					{
					dbg.location(19,13);
					OR16=(Token)match(input,OR,FOLLOW_OR_in_or134); 
					OR16_tree = (CommonTree)adaptor.create(OR16);
					root_0 = (CommonTree)adaptor.becomeRoot(OR16_tree, root_0);
					dbg.location(19,15);
					pushFollow(FOLLOW_and_in_or137);
					and17=and();
					state._fsp--;

					adaptor.addChild(root_0, and17.getTree());

					}
					break;

				default :
					break loop5;
				}
			}
			} finally {dbg.exitSubRule(5);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(19, 19);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "or");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "or"


	public static class and_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "and"
	// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:20:1: and : not ( AND ^ not )* ;
	public final LogicGrammaticParser.and_return and() throws RecognitionException {
		LogicGrammaticParser.and_return retval = new LogicGrammaticParser.and_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token AND19=null;
		ParserRuleReturnScope not18 =null;
		ParserRuleReturnScope not20 =null;

		CommonTree AND19_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "and");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(20, 0);

		try {
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:20:5: ( not ( AND ^ not )* )
			dbg.enterAlt(1);

			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:20:7: not ( AND ^ not )*
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(20,7);
			pushFollow(FOLLOW_not_in_and146);
			not18=not();
			state._fsp--;

			adaptor.addChild(root_0, not18.getTree());
			dbg.location(20,11);
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:20:11: ( AND ^ not )*
			try { dbg.enterSubRule(6);

			loop6:
			while (true) {
				int alt6=2;
				try { dbg.enterDecision(6, decisionCanBacktrack[6]);

				int LA6_0 = input.LA(1);
				if ( (LA6_0==AND) ) {
					alt6=1;
				}

				} finally {dbg.exitDecision(6);}

				switch (alt6) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:20:12: AND ^ not
					{
					dbg.location(20,15);
					AND19=(Token)match(input,AND,FOLLOW_AND_in_and149); 
					AND19_tree = (CommonTree)adaptor.create(AND19);
					root_0 = (CommonTree)adaptor.becomeRoot(AND19_tree, root_0);
					dbg.location(20,17);
					pushFollow(FOLLOW_not_in_and152);
					not20=not();
					state._fsp--;

					adaptor.addChild(root_0, not20.getTree());

					}
					break;

				default :
					break loop6;
				}
			}
			} finally {dbg.exitSubRule(6);}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(20, 21);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "and");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "and"


	public static class not_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "not"
	// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:21:1: not : ( NOT ^)? bool ;
	public final LogicGrammaticParser.not_return not() throws RecognitionException {
		LogicGrammaticParser.not_return retval = new LogicGrammaticParser.not_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NOT21=null;
		ParserRuleReturnScope bool22 =null;

		CommonTree NOT21_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "not");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(21, 0);

		try {
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:21:5: ( ( NOT ^)? bool )
			dbg.enterAlt(1);

			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:21:7: ( NOT ^)? bool
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(21,7);
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:21:7: ( NOT ^)?
			int alt7=2;
			try { dbg.enterSubRule(7);
			try { dbg.enterDecision(7, decisionCanBacktrack[7]);

			int LA7_0 = input.LA(1);
			if ( (LA7_0==NOT) ) {
				alt7=1;
			}
			} finally {dbg.exitDecision(7);}

			switch (alt7) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:21:8: NOT ^
					{
					dbg.location(21,11);
					NOT21=(Token)match(input,NOT,FOLLOW_NOT_in_not162); 
					NOT21_tree = (CommonTree)adaptor.create(NOT21);
					root_0 = (CommonTree)adaptor.becomeRoot(NOT21_tree, root_0);

					}
					break;

			}
			} finally {dbg.exitSubRule(7);}
			dbg.location(21,15);
			pushFollow(FOLLOW_bool_in_not167);
			bool22=bool();
			state._fsp--;

			adaptor.addChild(root_0, bool22.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(21, 18);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "not");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "not"


	public static class bool_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "bool"
	// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:22:1: bool : ( TRUE | FALSE | '(' ! eq ')' !| ID );
	public final LogicGrammaticParser.bool_return bool() throws RecognitionException {
		LogicGrammaticParser.bool_return retval = new LogicGrammaticParser.bool_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token TRUE23=null;
		Token FALSE24=null;
		Token char_literal25=null;
		Token char_literal27=null;
		Token ID28=null;
		ParserRuleReturnScope eq26 =null;

		CommonTree TRUE23_tree=null;
		CommonTree FALSE24_tree=null;
		CommonTree char_literal25_tree=null;
		CommonTree char_literal27_tree=null;
		CommonTree ID28_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "bool");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(22, 0);

		try {
			// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:22:6: ( TRUE | FALSE | '(' ! eq ')' !| ID )
			int alt8=4;
			try { dbg.enterDecision(8, decisionCanBacktrack[8]);

			switch ( input.LA(1) ) {
			case TRUE:
				{
				alt8=1;
				}
				break;
			case FALSE:
				{
				alt8=2;
				}
				break;
			case 14:
				{
				alt8=3;
				}
				break;
			case ID:
				{
				alt8=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 8, 0, input);
				dbg.recognitionException(nvae);
				throw nvae;
			}
			} finally {dbg.exitDecision(8);}

			switch (alt8) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:22:8: TRUE
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(22,8);
					TRUE23=(Token)match(input,TRUE,FOLLOW_TRUE_in_bool174); 
					TRUE23_tree = (CommonTree)adaptor.create(TRUE23);
					adaptor.addChild(root_0, TRUE23_tree);

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:22:15: FALSE
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(22,15);
					FALSE24=(Token)match(input,FALSE,FOLLOW_FALSE_in_bool178); 
					FALSE24_tree = (CommonTree)adaptor.create(FALSE24);
					adaptor.addChild(root_0, FALSE24_tree);

					}
					break;
				case 3 :
					dbg.enterAlt(3);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:22:23: '(' ! eq ')' !
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(22,26);
					char_literal25=(Token)match(input,14,FOLLOW_14_in_bool182); dbg.location(22,28);
					pushFollow(FOLLOW_eq_in_bool185);
					eq26=eq();
					state._fsp--;

					adaptor.addChild(root_0, eq26.getTree());
					dbg.location(22,34);
					char_literal27=(Token)match(input,15,FOLLOW_15_in_bool187); 
					}
					break;
				case 4 :
					dbg.enterAlt(4);

					// C:\\Users\\de18702\\Projekte\\Studium\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\logic\\LogicGrammatic.g:22:38: ID
					{
					root_0 = (CommonTree)adaptor.nil();


					dbg.location(22,38);
					ID28=(Token)match(input,ID,FOLLOW_ID_in_bool192); 
					ID28_tree = (CommonTree)adaptor.create(ID28);
					adaptor.addChild(root_0, ID28_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		dbg.location(22, 39);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "bool");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "bool"

	// Delegated rules



	public static final BitSet FOLLOW_stat_in_prog47 = new BitSet(new long[]{0x00000000000056C2L});
	public static final BitSet FOLLOW_eq_in_stat59 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_NEWLINE_in_stat61 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_stat68 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_stat70 = new BitSet(new long[]{0x00000000000054C0L});
	public static final BitSet FOLLOW_eq_in_stat72 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_NEWLINE_in_stat74 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_stat90 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_impl_in_eq101 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_EQ_in_eq104 = new BitSet(new long[]{0x00000000000054C0L});
	public static final BitSet FOLLOW_impl_in_eq107 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_or_in_impl116 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_IMPL_in_impl119 = new BitSet(new long[]{0x00000000000054C0L});
	public static final BitSet FOLLOW_or_in_impl122 = new BitSet(new long[]{0x0000000000000102L});
	public static final BitSet FOLLOW_and_in_or131 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_OR_in_or134 = new BitSet(new long[]{0x00000000000054C0L});
	public static final BitSet FOLLOW_and_in_or137 = new BitSet(new long[]{0x0000000000000802L});
	public static final BitSet FOLLOW_not_in_and146 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_AND_in_and149 = new BitSet(new long[]{0x00000000000054C0L});
	public static final BitSet FOLLOW_not_in_and152 = new BitSet(new long[]{0x0000000000000012L});
	public static final BitSet FOLLOW_NOT_in_not162 = new BitSet(new long[]{0x00000000000050C0L});
	public static final BitSet FOLLOW_bool_in_not167 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TRUE_in_bool174 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FALSE_in_bool178 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_14_in_bool182 = new BitSet(new long[]{0x00000000000054C0L});
	public static final BitSet FOLLOW_eq_in_bool185 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_bool187 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_bool192 = new BitSet(new long[]{0x0000000000000002L});
}

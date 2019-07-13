// $ANTLR 3.5.1 C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g 2019-07-13 19:40:16
 package de.thm.machine.framework.parser; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class FiniteStateMachineParserParser extends DebugParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLANK", "ID", "NEWLINE", "WS"
	};
	public static final int EOF=-1;
	public static final int BLANK=4;
	public static final int ID=5;
	public static final int NEWLINE=6;
	public static final int WS=7;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public static final String[] ruleNames = new String[] {
		"invalidRule", "lines", "line", "newline"
	};

	public static final boolean[] decisionCanBacktrack = new boolean[] {
		false, // invalid decision
		false, false, false
	};

 
	public int ruleLevel = 0;
	public int getRuleLevel() { return ruleLevel; }
	public void incRuleLevel() { ruleLevel++; }
	public void decRuleLevel() { ruleLevel--; }
	public FiniteStateMachineParserParser(TokenStream input) {
		this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
	}
	public FiniteStateMachineParserParser(TokenStream input, int port, RecognizerSharedState state) {
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

	public FiniteStateMachineParserParser(TokenStream input, DebugEventListener dbg) {
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
	@Override public String[] getTokenNames() { return FiniteStateMachineParserParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g"; }


	public static class lines_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "lines"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:11:1: lines : ( line | NEWLINE !)+ ;
	public final FiniteStateMachineParserParser.lines_return lines() throws RecognitionException {
		FiniteStateMachineParserParser.lines_return retval = new FiniteStateMachineParserParser.lines_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token NEWLINE2=null;
		ParserRuleReturnScope line1 =null;

		CommonTree NEWLINE2_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "lines");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(11, 0);

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:11:7: ( ( line | NEWLINE !)+ )
			dbg.enterAlt(1);

			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:11:9: ( line | NEWLINE !)+
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(11,9);
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:11:9: ( line | NEWLINE !)+
			int cnt1=0;
			try { dbg.enterSubRule(1);

			loop1:
			while (true) {
				int alt1=3;
				try { dbg.enterDecision(1, decisionCanBacktrack[1]);

				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= BLANK && LA1_0 <= ID)) ) {
					alt1=1;
				}
				else if ( (LA1_0==NEWLINE) ) {
					alt1=2;
				}

				} finally {dbg.exitDecision(1);}

				switch (alt1) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:11:10: line
					{
					dbg.location(11,10);
					pushFollow(FOLLOW_line_in_lines49);
					line1=line();
					state._fsp--;

					adaptor.addChild(root_0, line1.getTree());

					}
					break;
				case 2 :
					dbg.enterAlt(2);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:11:17: NEWLINE !
					{
					dbg.location(11,24);
					NEWLINE2=(Token)match(input,NEWLINE,FOLLOW_NEWLINE_in_lines53); 
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
		dbg.location(11, 26);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "lines");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "lines"


	public static class line_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "line"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:13:1: line : ( ( ID | BLANK ) ( WS !)? )+ newline ^;
	public final FiniteStateMachineParserParser.line_return line() throws RecognitionException {
		FiniteStateMachineParserParser.line_return retval = new FiniteStateMachineParserParser.line_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set3=null;
		Token WS4=null;
		ParserRuleReturnScope newline5 =null;

		CommonTree set3_tree=null;
		CommonTree WS4_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "line");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(13, 0);

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:13:6: ( ( ( ID | BLANK ) ( WS !)? )+ newline ^)
			dbg.enterAlt(1);

			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:13:8: ( ( ID | BLANK ) ( WS !)? )+ newline ^
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(13,8);
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:13:8: ( ( ID | BLANK ) ( WS !)? )+
			int cnt3=0;
			try { dbg.enterSubRule(3);

			loop3:
			while (true) {
				int alt3=2;
				try { dbg.enterDecision(3, decisionCanBacktrack[3]);

				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= BLANK && LA3_0 <= ID)) ) {
					alt3=1;
				}

				} finally {dbg.exitDecision(3);}

				switch (alt3) {
				case 1 :
					dbg.enterAlt(1);

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:13:9: ( ID | BLANK ) ( WS !)?
					{
					dbg.location(13,9);
					set3=input.LT(1);
					if ( (input.LA(1) >= BLANK && input.LA(1) <= ID) ) {
						input.consume();
						adaptor.addChild(root_0, (CommonTree)adaptor.create(set3));
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						dbg.recognitionException(mse);
						throw mse;
					}dbg.location(13,22);
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:13:22: ( WS !)?
					int alt2=2;
					try { dbg.enterSubRule(2);
					try { dbg.enterDecision(2, decisionCanBacktrack[2]);

					int LA2_0 = input.LA(1);
					if ( (LA2_0==WS) ) {
						alt2=1;
					}
					} finally {dbg.exitDecision(2);}

					switch (alt2) {
						case 1 :
							dbg.enterAlt(1);

							// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:13:23: WS !
							{
							dbg.location(13,25);
							WS4=(Token)match(input,WS,FOLLOW_WS_in_line74); 
							}
							break;

					}
					} finally {dbg.exitSubRule(2);}

					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					dbg.recognitionException(eee);

					throw eee;
				}
				cnt3++;
			}
			} finally {dbg.exitSubRule(3);}
			dbg.location(13,38);
			pushFollow(FOLLOW_newline_in_line81);
			newline5=newline();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(newline5.getTree(), root_0);
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
		dbg.location(13, 38);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "line");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "line"


	public static class newline_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "newline"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:15:1: newline : ( NEWLINE | EOF );
	public final FiniteStateMachineParserParser.newline_return newline() throws RecognitionException {
		FiniteStateMachineParserParser.newline_return retval = new FiniteStateMachineParserParser.newline_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set6=null;

		CommonTree set6_tree=null;

		try { dbg.enterRule(getGrammarFileName(), "newline");
		if ( getRuleLevel()==0 ) {dbg.commence();}
		incRuleLevel();
		dbg.location(15, 0);

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:15:9: ( NEWLINE | EOF )
			dbg.enterAlt(1);

			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineParser.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			dbg.location(15,9);
			set6=input.LT(1);
			if ( input.LA(1)==EOF||input.LA(1)==NEWLINE ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set6));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				dbg.recognitionException(mse);
				throw mse;
			}
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
		dbg.location(15, 23);

		}
		finally {
			dbg.exitRule(getGrammarFileName(), "newline");
			decRuleLevel();
			if ( getRuleLevel()==0 ) {dbg.terminate();}
		}

		return retval;
	}
	// $ANTLR end "newline"

	// Delegated rules



	public static final BitSet FOLLOW_line_in_lines49 = new BitSet(new long[]{0x0000000000000072L});
	public static final BitSet FOLLOW_NEWLINE_in_lines53 = new BitSet(new long[]{0x0000000000000072L});
	public static final BitSet FOLLOW_set_in_line65 = new BitSet(new long[]{0x00000000000000F0L});
	public static final BitSet FOLLOW_WS_in_line74 = new BitSet(new long[]{0x0000000000000070L});
	public static final BitSet FOLLOW_newline_in_line81 = new BitSet(new long[]{0x0000000000000002L});
}

// $ANTLR 3.5.1 C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g 2019-07-20 11:17:02
 package de.thm.antlr.json.output; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class JsonGeneratorASTParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ID", "NEWLINE", "WS", "';'", 
		"'TEST'"
	};
	public static final int EOF=-1;
	public static final int T__7=7;
	public static final int T__8=8;
	public static final int ID=4;
	public static final int NEWLINE=5;
	public static final int WS=6;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public JsonGeneratorASTParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public JsonGeneratorASTParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return JsonGeneratorASTParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g"; }


	public static class prog_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "prog"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:11:1: prog : 'TEST' WS ( ID WS )+ ';' ;
	public final JsonGeneratorASTParser.prog_return prog() throws RecognitionException {
		JsonGeneratorASTParser.prog_return retval = new JsonGeneratorASTParser.prog_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal1=null;
		Token WS2=null;
		Token ID3=null;
		Token WS4=null;
		Token char_literal5=null;

		CommonTree string_literal1_tree=null;
		CommonTree WS2_tree=null;
		CommonTree ID3_tree=null;
		CommonTree WS4_tree=null;
		CommonTree char_literal5_tree=null;

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:11:6: ( 'TEST' WS ( ID WS )+ ';' )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:11:8: 'TEST' WS ( ID WS )+ ';'
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal1=(Token)match(input,8,FOLLOW_8_in_prog46); 
			string_literal1_tree = (CommonTree)adaptor.create(string_literal1);
			adaptor.addChild(root_0, string_literal1_tree);

			WS2=(Token)match(input,WS,FOLLOW_WS_in_prog48); 
			WS2_tree = (CommonTree)adaptor.create(WS2);
			adaptor.addChild(root_0, WS2_tree);

			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:11:18: ( ID WS )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==ID) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:11:19: ID WS
					{
					ID3=(Token)match(input,ID,FOLLOW_ID_in_prog51); 
					ID3_tree = (CommonTree)adaptor.create(ID3);
					adaptor.addChild(root_0, ID3_tree);

					WS4=(Token)match(input,WS,FOLLOW_WS_in_prog53); 
					WS4_tree = (CommonTree)adaptor.create(WS4);
					adaptor.addChild(root_0, WS4_tree);

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			char_literal5=(Token)match(input,7,FOLLOW_7_in_prog57); 
			char_literal5_tree = (CommonTree)adaptor.create(char_literal5);
			adaptor.addChild(root_0, char_literal5_tree);

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
		return retval;
	}
	// $ANTLR end "prog"

	// Delegated rules



	public static final BitSet FOLLOW_8_in_prog46 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_WS_in_prog48 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_ID_in_prog51 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_WS_in_prog53 = new BitSet(new long[]{0x0000000000000090L});
	public static final BitSet FOLLOW_7_in_prog57 = new BitSet(new long[]{0x0000000000000002L});
}

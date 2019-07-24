// $ANTLR 3.5.1 C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g 2019-07-20 20:05:30
 package de.thm.antlr.json.output; 

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class JsonGeneratorASTParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "DEFINE", "ID", "NEWLINE", "VALUE", 
		"WS", "'\"'", "'('", "')'", "','", "'ATTR'", "'LIST'", "'OBJECT'"
	};
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


	public static class list_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "list"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:11:1: list : 'LIST' ! '(' ! ( object ( ',' ! object )* )? ')' !;
	public final JsonGeneratorASTParser.list_return list() throws RecognitionException {
		JsonGeneratorASTParser.list_return retval = new JsonGeneratorASTParser.list_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal1=null;
		Token char_literal2=null;
		Token char_literal4=null;
		Token char_literal6=null;
		ParserRuleReturnScope object3 =null;
		ParserRuleReturnScope object5 =null;

		CommonTree string_literal1_tree=null;
		CommonTree char_literal2_tree=null;
		CommonTree char_literal4_tree=null;
		CommonTree char_literal6_tree=null;

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:11:6: ( 'LIST' ! '(' ! ( object ( ',' ! object )* )? ')' !)
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:11:8: 'LIST' ! '(' ! ( object ( ',' ! object )* )? ')' !
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal1=(Token)match(input,14,FOLLOW_14_in_list46); 
			char_literal2=(Token)match(input,10,FOLLOW_10_in_list49); 
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:11:21: ( object ( ',' ! object )* )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==15) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:11:22: object ( ',' ! object )*
					{
					pushFollow(FOLLOW_object_in_list53);
					object3=object();
					state._fsp--;

					adaptor.addChild(root_0, object3.getTree());

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:11:29: ( ',' ! object )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0==12) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:11:30: ',' ! object
							{
							char_literal4=(Token)match(input,12,FOLLOW_12_in_list56); 
							pushFollow(FOLLOW_object_in_list59);
							object5=object();
							state._fsp--;

							adaptor.addChild(root_0, object5.getTree());

							}
							break;

						default :
							break loop1;
						}
					}

					}
					break;

			}

			char_literal6=(Token)match(input,11,FOLLOW_11_in_list65); 
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
	// $ANTLR end "list"


	public static class object_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "object"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:13:1: object : 'OBJECT' ! '(' ! '\"' ! ID ^ '\"' ! attributs ')' !;
	public final JsonGeneratorASTParser.object_return object() throws RecognitionException {
		JsonGeneratorASTParser.object_return retval = new JsonGeneratorASTParser.object_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal7=null;
		Token char_literal8=null;
		Token char_literal9=null;
		Token ID10=null;
		Token char_literal11=null;
		Token char_literal13=null;
		ParserRuleReturnScope attributs12 =null;

		CommonTree string_literal7_tree=null;
		CommonTree char_literal8_tree=null;
		CommonTree char_literal9_tree=null;
		CommonTree ID10_tree=null;
		CommonTree char_literal11_tree=null;
		CommonTree char_literal13_tree=null;

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:13:8: ( 'OBJECT' ! '(' ! '\"' ! ID ^ '\"' ! attributs ')' !)
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:13:10: 'OBJECT' ! '(' ! '\"' ! ID ^ '\"' ! attributs ')' !
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal7=(Token)match(input,15,FOLLOW_15_in_object74); 
			char_literal8=(Token)match(input,10,FOLLOW_10_in_object77); 
			char_literal9=(Token)match(input,9,FOLLOW_9_in_object80); 
			ID10=(Token)match(input,ID,FOLLOW_ID_in_object83); 
			ID10_tree = (CommonTree)adaptor.create(ID10);
			root_0 = (CommonTree)adaptor.becomeRoot(ID10_tree, root_0);

			char_literal11=(Token)match(input,9,FOLLOW_9_in_object86); 
			pushFollow(FOLLOW_attributs_in_object90);
			attributs12=attributs();
			state._fsp--;

			adaptor.addChild(root_0, attributs12.getTree());

			char_literal13=(Token)match(input,11,FOLLOW_11_in_object92); 
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
	// $ANTLR end "object"


	public static class attributs_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "attributs"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:15:1: attributs : 'ATTR' ! '(' ! ( attribut ( ',' ! attribut )* )? ')' !;
	public final JsonGeneratorASTParser.attributs_return attributs() throws RecognitionException {
		JsonGeneratorASTParser.attributs_return retval = new JsonGeneratorASTParser.attributs_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal14=null;
		Token char_literal15=null;
		Token char_literal17=null;
		Token char_literal19=null;
		ParserRuleReturnScope attribut16 =null;
		ParserRuleReturnScope attribut18 =null;

		CommonTree string_literal14_tree=null;
		CommonTree char_literal15_tree=null;
		CommonTree char_literal17_tree=null;
		CommonTree char_literal19_tree=null;

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:15:10: ( 'ATTR' ! '(' ! ( attribut ( ',' ! attribut )* )? ')' !)
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:15:12: 'ATTR' ! '(' ! ( attribut ( ',' ! attribut )* )? ')' !
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal14=(Token)match(input,13,FOLLOW_13_in_attributs100); 
			char_literal15=(Token)match(input,10,FOLLOW_10_in_attributs103); 
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:15:25: ( attribut ( ',' ! attribut )* )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ID) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:15:26: attribut ( ',' ! attribut )*
					{
					pushFollow(FOLLOW_attribut_in_attributs107);
					attribut16=attribut();
					state._fsp--;

					adaptor.addChild(root_0, attribut16.getTree());

					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:15:35: ( ',' ! attribut )*
					loop3:
					while (true) {
						int alt3=2;
						int LA3_0 = input.LA(1);
						if ( (LA3_0==12) ) {
							alt3=1;
						}

						switch (alt3) {
						case 1 :
							// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:15:36: ',' ! attribut
							{
							char_literal17=(Token)match(input,12,FOLLOW_12_in_attributs110); 
							pushFollow(FOLLOW_attribut_in_attributs113);
							attribut18=attribut();
							state._fsp--;

							adaptor.addChild(root_0, attribut18.getTree());

							}
							break;

						default :
							break loop3;
						}
					}

					}
					break;

			}

			char_literal19=(Token)match(input,11,FOLLOW_11_in_attributs120); 
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
	// $ANTLR end "attributs"


	public static class attribut_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "attribut"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:17:1: attribut : ID DEFINE ^ VALUE ;
	public final JsonGeneratorASTParser.attribut_return attribut() throws RecognitionException {
		JsonGeneratorASTParser.attribut_return retval = new JsonGeneratorASTParser.attribut_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ID20=null;
		Token DEFINE21=null;
		Token VALUE22=null;

		CommonTree ID20_tree=null;
		CommonTree DEFINE21_tree=null;
		CommonTree VALUE22_tree=null;

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:17:9: ( ID DEFINE ^ VALUE )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorAST.g:17:11: ID DEFINE ^ VALUE
			{
			root_0 = (CommonTree)adaptor.nil();


			ID20=(Token)match(input,ID,FOLLOW_ID_in_attribut128); 
			ID20_tree = (CommonTree)adaptor.create(ID20);
			adaptor.addChild(root_0, ID20_tree);

			DEFINE21=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_attribut130); 
			DEFINE21_tree = (CommonTree)adaptor.create(DEFINE21);
			root_0 = (CommonTree)adaptor.becomeRoot(DEFINE21_tree, root_0);

			VALUE22=(Token)match(input,VALUE,FOLLOW_VALUE_in_attribut133); 
			VALUE22_tree = (CommonTree)adaptor.create(VALUE22);
			adaptor.addChild(root_0, VALUE22_tree);

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
	// $ANTLR end "attribut"

	// Delegated rules



	public static final BitSet FOLLOW_14_in_list46 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_list49 = new BitSet(new long[]{0x0000000000008800L});
	public static final BitSet FOLLOW_object_in_list53 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_12_in_list56 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_object_in_list59 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_11_in_list65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_15_in_object74 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_object77 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_object80 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_object83 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_9_in_object86 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_attributs_in_object90 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_11_in_object92 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_13_in_attributs100 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_10_in_attributs103 = new BitSet(new long[]{0x0000000000000820L});
	public static final BitSet FOLLOW_attribut_in_attributs107 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_12_in_attributs110 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_attribut_in_attributs113 = new BitSet(new long[]{0x0000000000001800L});
	public static final BitSet FOLLOW_11_in_attributs120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_attribut128 = new BitSet(new long[]{0x0000000000000010L});
	public static final BitSet FOLLOW_DEFINE_in_attribut130 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_VALUE_in_attribut133 = new BitSet(new long[]{0x0000000000000002L});
}

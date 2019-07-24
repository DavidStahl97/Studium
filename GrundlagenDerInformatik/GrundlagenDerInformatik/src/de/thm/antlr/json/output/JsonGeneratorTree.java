// $ANTLR 3.5.1 C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g 2019-07-20 20:19:07
 
	package de.thm.antlr.json.output;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class JsonGeneratorTree extends TreeParser {
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
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public JsonGeneratorTree(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public JsonGeneratorTree(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return JsonGeneratorTree.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g"; }


		int tabulator = 0;
		
		private String nextLine() {
			var s = "\n";
			for(int i = 0; i < tabulator; i++) {
				s += "\t";
			}
			return s;
		}
		
		private String getOpenBracket() {
			tabulator++;
			return "{";
		}
		
		private String getClosedBracket() {
			tabulator--;
			return "}";
		}
		
		private String writeID(String s) {
			return "\"" + s + "\"";
		}



	// $ANTLR start "list"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:38:1: list returns [String value] : (o= object (o= object )* )? ;
	public final String list() throws RecognitionException {
		String value = null;


		String o =null;

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:38:28: ( (o= object (o= object )* )? )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:39:2: (o= object (o= object )* )?
			{
			 value = getOpenBracket() + nextLine(); 
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:40:2: (o= object (o= object )* )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ID) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:41:3: o= object (o= object )*
					{
					pushFollow(FOLLOW_object_in_list58);
					o=object();
					state._fsp--;

					 value += o; 
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:42:3: (o= object )*
					loop1:
					while (true) {
						int alt1=2;
						int LA1_0 = input.LA(1);
						if ( (LA1_0==ID) ) {
							alt1=1;
						}

						switch (alt1) {
						case 1 :
							// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:42:4: o= object
							{
							pushFollow(FOLLOW_object_in_list67);
							o=object();
							state._fsp--;

							 value += "," + nextLine() + o; 
							}
							break;

						default :
							break loop1;
						}
					}

					}
					break;

			}

			 var c = getClosedBracket(); value += nextLine() + c; 
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
	// $ANTLR end "list"



	// $ANTLR start "object"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:46:1: object returns [String value] : ^(id= ID (a= attribute (a= attribute )* )? ) ;
	public final String object() throws RecognitionException {
		String value = null;


		CommonTree id=null;
		String a =null;

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:46:30: ( ^(id= ID (a= attribute (a= attribute )* )? ) )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:47:2: ^(id= ID (a= attribute (a= attribute )* )? )
			{
			id=(CommonTree)match(input,ID,FOLLOW_ID_in_object98); 
			 value = writeID(id.getText()) + " : " + getOpenBracket() + nextLine(); 
			if ( input.LA(1)==Token.DOWN ) {
				match(input, Token.DOWN, null); 
				// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:49:3: (a= attribute (a= attribute )* )?
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==DEFINE) ) {
					alt4=1;
				}
				switch (alt4) {
					case 1 :
						// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:50:4: a= attribute (a= attribute )*
						{
						pushFollow(FOLLOW_attribute_in_object111);
						a=attribute();
						state._fsp--;

						 value += a; 
						// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:51:4: (a= attribute )*
						loop3:
						while (true) {
							int alt3=2;
							int LA3_0 = input.LA(1);
							if ( (LA3_0==DEFINE) ) {
								alt3=1;
							}

							switch (alt3) {
							case 1 :
								// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:51:6: a= attribute
								{
								pushFollow(FOLLOW_attribute_in_object122);
								a=attribute();
								state._fsp--;

								 value += "," + nextLine() + a; 
								}
								break;

							default :
								break loop3;
							}
						}

						}
						break;

				}

				 var c = getClosedBracket(); value += nextLine() + c; 
				match(input, Token.UP, null); 
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
	// $ANTLR end "object"



	// $ANTLR start "attribute"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:56:1: attribute returns [String value] : ^( DEFINE id= ID VALUE ) ;
	public final String attribute() throws RecognitionException {
		String value = null;


		CommonTree id=null;
		CommonTree DEFINE1=null;
		CommonTree VALUE2=null;

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:56:33: ( ^( DEFINE id= ID VALUE ) )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\antlr\\json\\JsonGeneratorTree.g:57:2: ^( DEFINE id= ID VALUE )
			{
			DEFINE1=(CommonTree)match(input,DEFINE,FOLLOW_DEFINE_in_attribute153); 
			match(input, Token.DOWN, null); 
			id=(CommonTree)match(input,ID,FOLLOW_ID_in_attribute157); 
			VALUE2=(CommonTree)match(input,VALUE,FOLLOW_VALUE_in_attribute159); 
			match(input, Token.UP, null); 

			 value = writeID(id.getText()) + " "  + (DEFINE1!=null?DEFINE1.getText():null) + " " + (VALUE2!=null?VALUE2.getText():null); 
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
	// $ANTLR end "attribute"

	// Delegated rules



	public static final BitSet FOLLOW_object_in_list58 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_object_in_list67 = new BitSet(new long[]{0x0000000000000022L});
	public static final BitSet FOLLOW_ID_in_object98 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_attribute_in_object111 = new BitSet(new long[]{0x0000000000000018L});
	public static final BitSet FOLLOW_attribute_in_object122 = new BitSet(new long[]{0x0000000000000018L});
	public static final BitSet FOLLOW_DEFINE_in_attribute153 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_attribute157 = new BitSet(new long[]{0x0000000000000080L});
	public static final BitSet FOLLOW_VALUE_in_attribute159 = new BitSet(new long[]{0x0000000000000008L});
}

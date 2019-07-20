// $ANTLR 3.5.1 C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g 2019-07-14 17:12:49

	package de.thm.machine.framework.parser.output;
	
	import java.util.HashMap;
	import de.thm.machine.framework.machines.*;
	import de.thm.machine.framework.tupleElements.*;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class FiniteStateMachineTree extends TreeParser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "BLANK", "ID", "NEWLINE", "WS"
	};
	public static final int EOF=-1;
	public static final int BLANK=4;
	public static final int ID=5;
	public static final int NEWLINE=6;
	public static final int WS=7;

	// delegates
	public TreeParser[] getDelegates() {
		return new TreeParser[] {};
	}

	// delegators


	public FiniteStateMachineTree(TreeNodeStream input) {
		this(input, new RecognizerSharedState());
	}
	public FiniteStateMachineTree(TreeNodeStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return FiniteStateMachineTree.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g"; }


		HashMap<String, State> states = new HashMap<String, State>();
		TransitionFunction function = new TransitionFunction();
		State startState;
		
		void cache(String id, State state) {
			states.put(id, state);
		}
		
		State load(String id) {
			State state = states.get(id);
			return state;
		}
		
		State getState(String id) {
			State state = load(id);
			if(state != null) return state;
			
			state = new State(id);
			cache(id, state);
			return state;
		}



	// $ANTLR start "prog"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:40:1: prog : end_state start_state ( transition )* ( last_transition ) ;
	public final void prog() throws RecognitionException {
		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:40:6: ( end_state start_state ( transition )* ( last_transition ) )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:41:3: end_state start_state ( transition )* ( last_transition )
			{
			pushFollow(FOLLOW_end_state_in_prog48);
			end_state();
			state._fsp--;

			pushFollow(FOLLOW_start_state_in_prog50);
			start_state();
			state._fsp--;

			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:41:25: ( transition )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==NEWLINE) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:41:25: transition
					{
					pushFollow(FOLLOW_transition_in_prog52);
					transition();
					state._fsp--;

					}
					break;

				default :
					break loop1;
				}
			}

			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:41:37: ( last_transition )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:41:38: last_transition
			{
			pushFollow(FOLLOW_last_transition_in_prog56);
			last_transition();
			state._fsp--;

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



	// $ANTLR start "end_state"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:42:1: end_state : ^( NEWLINE ( ID )+ ) ;
	public final void end_state() throws RecognitionException {
		CommonTree ID1=null;

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:43:2: ( ^( NEWLINE ( ID )+ ) )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:43:4: ^( NEWLINE ( ID )+ )
			{
			match(input,NEWLINE,FOLLOW_NEWLINE_in_end_state66); 
			match(input, Token.DOWN, null); 
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:43:14: ( ID )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==ID) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:43:15: ID
					{
					ID1=(CommonTree)match(input,ID,FOLLOW_ID_in_end_state69); 
					 
								cache((ID1!=null?ID1.getText():null), new State((ID1!=null?ID1.getText():null), true));
							
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match(input, Token.UP, null); 

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
	// $ANTLR end "end_state"



	// $ANTLR start "start_state"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:47:1: start_state : ^( NEWLINE ID ) ;
	public final void start_state() throws RecognitionException {
		CommonTree ID2=null;

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:48:2: ( ^( NEWLINE ID ) )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:48:4: ^( NEWLINE ID )
			{
			match(input,NEWLINE,FOLLOW_NEWLINE_in_start_state86); 
			match(input, Token.DOWN, null); 
			ID2=(CommonTree)match(input,ID,FOLLOW_ID_in_start_state88); 
			match(input, Token.UP, null); 

			 cache((ID2!=null?ID2.getText():null), new State((ID2!=null?ID2.getText():null))); 
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
	// $ANTLR end "start_state"



	// $ANTLR start "transition"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:51:1: transition : ^( NEWLINE a= ID cell= ID b= ID ) ;
	public final void transition() throws RecognitionException {
		CommonTree a=null;
		CommonTree cell=null;
		CommonTree b=null;

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:52:2: ( ^( NEWLINE a= ID cell= ID b= ID ) )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:52:4: ^( NEWLINE a= ID cell= ID b= ID )
			{
			match(input,NEWLINE,FOLLOW_NEWLINE_in_transition104); 
			match(input, Token.DOWN, null); 
			a=(CommonTree)match(input,ID,FOLLOW_ID_in_transition108); 
			cell=(CommonTree)match(input,ID,FOLLOW_ID_in_transition112); 
			b=(CommonTree)match(input,ID,FOLLOW_ID_in_transition116); 
			match(input, Token.UP, null); 


						
						State s1 = getState(a.getText());
						State s2 = getState(b.getText());
						
						if(cell.getText().length() != 1) throw new RuntimeException("Der Input darf nur aus einem Character bestehen");
						
						Domain d = new Domain(s1, cell.getText().charAt(0));
						Image i = new Image(s2);
						
						function.add(d, i);
						
					
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
	// $ANTLR end "transition"



	// $ANTLR start "last_transition"
	// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:66:1: last_transition : ^( EOF a= ID cell= ID b= ID ) ;
	public final void last_transition() throws RecognitionException {
		CommonTree a=null;
		CommonTree cell=null;
		CommonTree b=null;

		try {
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:67:2: ( ^( EOF a= ID cell= ID b= ID ) )
			// C:\\Users\\dstah\\Programming\\Studium\\GrundlagenDerInformatik\\GrundlagenDerInformatik\\src\\de\\thm\\machine\\framework\\parser\\FiniteStateMachineTree.g:67:4: ^( EOF a= ID cell= ID b= ID )
			{
			match(input,EOF,FOLLOW_EOF_in_last_transition131); 
			match(input, Token.DOWN, null); 
			a=(CommonTree)match(input,ID,FOLLOW_ID_in_last_transition135); 
			cell=(CommonTree)match(input,ID,FOLLOW_ID_in_last_transition139); 
			b=(CommonTree)match(input,ID,FOLLOW_ID_in_last_transition143); 
			match(input, Token.UP, null); 


						
						State s1 = getState(a.getText());
						State s2 = getState(b.getText());
						
						if(cell.getText().length() != 1) throw new RuntimeException("Der Input darf nur aus einem Character bestehen");
						
						Domain d = new Domain(s1, cell.getText().charAt(0));
						Image i = new Image(s2);
						
						function.add(d, i);
						
					
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
	// $ANTLR end "last_transition"

	// Delegated rules



	public static final BitSet FOLLOW_end_state_in_prog48 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_start_state_in_prog50 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_transition_in_prog52 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_last_transition_in_prog56 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_NEWLINE_in_end_state66 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_end_state69 = new BitSet(new long[]{0x0000000000000028L});
	public static final BitSet FOLLOW_NEWLINE_in_start_state86 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_start_state88 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_NEWLINE_in_transition104 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_transition108 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_transition112 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_transition116 = new BitSet(new long[]{0x0000000000000008L});
	public static final BitSet FOLLOW_EOF_in_last_transition131 = new BitSet(new long[]{0x0000000000000004L});
	public static final BitSet FOLLOW_ID_in_last_transition135 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_last_transition139 = new BitSet(new long[]{0x0000000000000020L});
	public static final BitSet FOLLOW_ID_in_last_transition143 = new BitSet(new long[]{0x0000000000000008L});
}

tree grammar FiniteStateMachineTree;

options {
	tokenVocab = FileParser;
	ASTLabelType = CommonTree;
}

@header {
	package de.thm.machine.framework.parser.output;
	
	import java.util.HashMap;
	import de.thm.machine.framework.machines.*;
	import de.thm.machine.framework.tupleElements.*;
}

@members {
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
}

prog	:	
		end_state start_state transition* (last_transition);
end_state
	:	^(NEWLINE (ID { 
			cache($ID.text, new State($ID.text, true));
		})+ );
	
start_state
	:	^(NEWLINE ID) { cache($ID.text, new State($ID.text)); };
	
	
transition
	:	^(NEWLINE a=ID cell=ID b=ID) {
			
			State s1 = getState(a.getText());
			State s2 = getState(b.getText());
			
			if(cell.getText().length() != 1) throw new RuntimeException("Der Input darf nur aus einem Character bestehen");
			
			Domain d = new Domain(s1, cell.getText().charAt(0));
			Image i = new Image(s2);
			
			function.add(d, i);
			
		};
		
last_transition
	:	^(EOF a=ID cell=ID b=ID) {
			
			State s1 = getState(a.getText());
			State s2 = getState(b.getText());
			
			if(cell.getText().length() != 1) throw new RuntimeException("Der Input darf nur aus einem Character bestehen");
			
			Domain d = new Domain(s1, cell.getText().charAt(0));
			Image i = new Image(s2);
			
			function.add(d, i);
			
		};


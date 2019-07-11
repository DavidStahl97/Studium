tree grammar LogicGrammaticTree;

options { 
	tokenVocab=LogicGrammatic; 
	ASTLabelType=CommonTree; 
}

@header { 
	package de.thm.antlr.logic.output;
	import java.util.HashMap;
}

@members {
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
}


prog	:	(stat)+;

stat	:	expr {System.out.println($expr.value);} |
	  	^('=' ID expr) { cache($ID.text, $expr.value); System.out.println($ID.text + " = " + $expr.value); };
	  

expr returns [boolean value]:
	
	^(NOT a=expr) { $value = !a; } |
	^(AND a=expr b=expr) { $value = a && b; } |
	^(OR a=expr b=expr) { $value = a || b; } |
	^(IMPL a=expr b=expr) { $value = !a || (a && b); } |
	^(EQ a=expr b=expr) { $value = a == b; } |
	
	ID { $value = load($ID.text); } |
	
	TRUE { $value = true; } |
	FALSE { $value = false; };

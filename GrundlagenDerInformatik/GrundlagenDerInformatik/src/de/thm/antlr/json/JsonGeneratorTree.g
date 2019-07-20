tree grammar JsonGeneratorTree;

options { 
	tokenVocab=JsonGeneratorAST; 
	ASTLabelType=CommonTree; 
}

@header { 
	package de.thm.antlr.json.output;
}

@members {
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
}

list returns [String value]:
	{ $value = getOpenBracket() + nextLine(); }
	( 
		o=object { $value += o; }
		(o=object { $value += "," + nextLine() + o; } )*
	)?
	{ var c = getClosedBracket(); $value += nextLine() + c; };
	
object returns [String value]:
	^(
		id=ID { $value = writeID(id.getText()) + " : " + getOpenBracket() + nextLine(); }
		(
			a=attribute { $value += a; }
			( a=attribute { $value += "," + nextLine() + a; } )*
		)?
		{ var c = getClosedBracket(); $value += nextLine() + c; }
	);
	
attribute returns [String value]:
	^(DEFINE id=ID VALUE) { $value = writeID(id.getText()) + " "  + $DEFINE.text + " " + $VALUE.text; };
	
	
	

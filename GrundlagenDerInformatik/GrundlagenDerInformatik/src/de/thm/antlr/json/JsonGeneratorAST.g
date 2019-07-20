grammar JsonGeneratorAST;

options { 
	output=AST; 
	ASTLabelType=CommonTree; 
}

@parser::header{ package de.thm.antlr.json.output; } 
@lexer::header{ package de.thm.antlr.json.output; }

list	:	'LIST'! '('! (object (','! object)*)? ')'!;

object	:	'OBJECT'! '('! '"'! ID^ '"'!  attributs ')'!;

attributs:	'ATTR'! '('! (attribut (','! attribut )*)? ')'!;

attribut:	ID DEFINE^ VALUE;



ID	:	('a'..'z')+;
VALUE	:	('0'..'9')+;

DEFINE	:	'=';

NEWLINE	:	'\r'? '\n' {skip();};
WS	:	(' ' | '\t')+ {skip();};
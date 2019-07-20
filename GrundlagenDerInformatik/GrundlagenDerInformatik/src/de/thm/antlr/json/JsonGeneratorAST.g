grammar JsonGeneratorAST;

options { 
	output=AST; 
	ASTLabelType=CommonTree; 
}

@parser::header{ package de.thm.antlr.json.output; } 
@lexer::header{ package de.thm.antlr.json.output; }

prog	:	'TEST' WS (ID WS)+ ';';

ID	:	('A'..'Z')+;

NEWLINE	:	'\r'? '\n';
WS	:	(' ' | '\t')+;
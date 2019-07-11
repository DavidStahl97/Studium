grammar LogicGrammatic;

options { 
	output=AST; 
	ASTLabelType=CommonTree; 
}

@parser::header{ package de.thm.antlr.logic.output; } 
@lexer::header{ package de.thm.antlr.logic.output; }

prog	:	(stat {System.out.println($stat.tree == null ? "null" : $stat.tree.toStringTree());})+;

stat	:	eq NEWLINE! |
		ID '=' eq NEWLINE -> ^('=' ID eq) |
		NEWLINE -> ;

eq	:	impl (EQ^ impl)*;
impl	:	or (IMPL^ or)*;
or	:	and (OR^ and)*;
and	:	not (AND^ not)*;
not	:	(NOT^)? bool;
bool	:	TRUE | FALSE | '('! eq ')'! | ID;

EQ	:	'==';
IMPL	:	'->';
OR	:	'||';
AND	:	'&&';
NOT	:	'!';

TRUE	:	'True';
FALSE	:	'False';

ID	:	('a'..'z')+;

NEWLINE	:	'\r'? '\n';
WS	:	(' ' | '\t')+ {skip();};
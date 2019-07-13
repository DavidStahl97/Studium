grammar FiniteStateMachineParser;

options {
	output = AST;
	ASTLabelType = CommonTree;
}

@parser::header { package de.thm.machine.framework.parser; }
@lexer::header { package de.thm.machine.framework.parser; }

lines	:	(line | NEWLINE!)+;

line	:	((ID | BLANK) (WS!)?)+ newline^;

newline	:	NEWLINE | EOF;

BLANK	:	'_';
ID	:	('0'..'9' | 'a'..'z' | 'A'..'Z')+;

NEWLINE	:	('\r'? '\n');
WS	:	(' ' | '\t')+;
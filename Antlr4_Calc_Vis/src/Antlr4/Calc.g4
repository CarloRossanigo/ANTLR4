grammar Calc;

@header {
    package Antlr4;
}

// Parser rules
prog:  (decl | expr)+ EOF #Program
;

decl: ID ':' TYPE ':' NUM  #Declaration
;

expr: expr (GREAT | LESS | GREATER | LESSER) expr #GreatLess
    | expr (EQUALS | NEQUALS) expr  #EqualsNequ
    | '(' expr ')'                  #Paren
    | expr (MUL | DIV | POW) expr   #MultDivPow
    | expr (ADD | SUB) expr         #AddSub
    | ID                            #Variable
    | NUM                           #Number
    | COSTANT                       #Costant
    | FUNCTION '(' expr ')'         #Function
    ;

// Lexer rules
ID      : [a-z][a-zA-Z0-9_]*;
FUNCTION: 'COS' | 'SIN' | 'TAN' | 'SQRT' | 'LOG' | 'LN' | 'ACOS' | 'ABS' | 'ROUND' | 'ASINH' | 'SINH' | 'COSH' | 'ACOSH' | 'TANH' | 'ATANH' | 'EXP' | 'ASIN' | 'ATAN';
COSTANT : ('-'? 'PI') | ('-'? 'EULER');
NUM     : '0' | '-'?[0-9][0-9]* ('.' [0-9]+)? | [0-9]+ ('.' [0-9]+)?;
TYPE    : 'INT' | 'DOUBLE';
LPAREN  : '(';
RPAREN  : ')';
POW     : '^';
MUL     : '*';
DIV     : '/';
ADD     : '+';
SUB     : '-';
GREATER : '≥';
GREAT   : '>';
LESSER  : '≤';
LESS    : '<';
EQUALS  : '=';
NEQUALS : '≠';
COMMENT : '--' ~[\r\n]* -> skip;
WS      : [ \t\r\n]+ -> skip;

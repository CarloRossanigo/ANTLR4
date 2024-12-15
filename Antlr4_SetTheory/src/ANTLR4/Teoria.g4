grammar Teoria;

@header {
    package ANTLR4;
}

// Entry point
prog: (decl | expr)+ EOF  #Program
;

// Declarations
decl: ID ':{'((NUM|STRING) (','( NUM|STRING))*)? '}'  #Declaration
;

// Expressions
expr: expr (UNION | INTERSECTION | DIFFERENZA | DIFFERENZASIMMETRICA) expr  #UnionIntDiffSimm
    | COMPLEMENTO expr   #Compl
    |  LP expr RP   #Parens 
    | expr (EQUALS|NEQUAL|CONTENUTODX|CONTENUTOSX) expr   #EqNeqCdxCsx
    | (MIN | MAX) expr   #MinMax
    | ID  #Set
;

// Tokens
MIN: 'MIN';
MAX: 'MAX';
ID: [A-Z]+ ;
NUM: '0' | '-'?[0-9]+ ('.' [0-9]+)? ;
UNION: '+' ;
INTERSECTION: '^' ;
DIFFERENZA: '/' ;
DIFFERENZASIMMETRICA: '∆' ;
COMPLEMENTO: '!' ;
LP: '(' ;
RP: ')' ;
EQUALS: '=' ;
NEQUAL: '≠' ;
CONTENUTODX: '≤' ;
CONTENUTOSX: '≥' ;
STRING: [a-z]+ ;
COMMENT: '--' ~[\r\n]* -> skip ;
WS: [ \t\r\n]+ -> skip ;

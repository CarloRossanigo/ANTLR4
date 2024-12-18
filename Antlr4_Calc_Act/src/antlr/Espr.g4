  grammar Espr;

@header {
    package antlr;
    import org.antlr.v4.runtime.*;
    import java.io.*;
    import java.util.*;
    import Espr.*;
}

@members {
    // per gestione errori
    public List<String> vars = new ArrayList<>();
    public List<String> semErrors = new ArrayList<>();
    // radice dell'AST (di tipo Expression)
    public Program program = new Program();
}

// Start symbol/variable
prog returns [Program p]
    : ( 
        d=decl {
            program.addExpression($d.d);
        }
        |
        e=expr {
            program.addExpression($e.e);
        }
    )+ EOF
    { $p = program; }
    ;

decl returns [Expression d]
    : name=ID ':' type=TYPE ':' val=NUM {
        int line = $name.getLine();
        int col = $name.getCharPositionInLine() + 1;
        String id = $name.getText();
        if (vars.contains(id)) {
            semErrors.add("Errore, variabile: " + id + "già dichiarata (linea " + line + ", colonna " + col + ")");
        } else {
            vars.add(id);
        }
        String tipo = $type.getText();
        double val = Double.parseDouble($val.getText());
        $d = new VariableDeclaration(id, tipo, val);
    }
    ;

expr returns [Expression e]
    : left=expr '<' right=expr {
        $e = new BooleanExpression($left.e, $right.e,"<");
    }
    | left=expr '≤' right=expr {
        $e = new BooleanExpression($left.e, $right.e,"≤");
    }
    | left=expr '≥' right=expr {
        $e = new BooleanExpression($left.e, $right.e,"≥");
    }
    | left=expr '>' right=expr {
        $e = new BooleanExpression($left.e, $right.e,">");
    }
    | left=expr '≠' right=expr {
        $e = new  BooleanExpression($left.e, $right.e,"≠");
    }
    | left=expr '=' right=expr {
        $e = new BooleanExpression($left.e, $right.e,"=");
    }
    | left=expr '^' right=expr {
        $e = new NumericExpression($left.e, $right.e,"^");
    }
    | '(' middle=expr ')' {
        $e = $middle.e;
    }
    | left=expr '*' right=expr {
        $e = new NumericExpression($left.e, $right.e,"*");
    }
    | left=expr '/' right=expr {
        $e = new NumericExpression($left.e, $right.e,"/");
    }
    | left=expr '+' right=expr {
        $e = new NumericExpression($left.e, $right.e,"+");
    }
    | left=expr '-' right=expr {
        $e = new NumericExpression($left.e, $right.e,"-");
    }
    | id=ID {
        int line = $id.getLine();
        int col = $id.getCharPositionInLine() + 1;
        if (!vars.contains($id.getText())) {
            semErrors.add("Errore, variabile : " + $id.getText() + " non dichiarata (line " + line + ", col " + col + ")");
        }
        $e = new Var($id.getText());
    }
    | n=NUM {
        $e = new NumericExpression(Double.parseDouble($n.getText()));
    }
    | c=COST {
        switch ($c.getText()) {
            case "PI":
                $e =new  NumericExpression("PI");
                break;
            case "-PI":
                $e = new NumericExpression("-PI");
                break;
            case "EULER":
                $e = new NumericExpression("EULER");
                break;
            case "-EULER":
                $e = new NumericExpression("-EULER");
                break;
        }
    }
   | func=FUNCTION '(' param=expr ')' {
        try {
            Functions funcEnum = Functions.valueOf($func.getText());
            $e = new NumericExpression(funcEnum, $param.e);
        } catch (IllegalArgumentException ex) {
            semErrors.add("Errore: funzione inesistente " + $func.getText());
        }
    }
    ;

// Tokens
ID: [a-z][a-zA-Z0-9_]*;
NUM : '0' | '-'?[0-9][0-9]* ('.' [0-9]+)? | [0-9]+ ('.' [0-9]+)?;
TYPE: 'INT'|'DOUBLE';
COST:('-'? 'PI') | ('-'? 'EULER');
FUNCTION: 'COS' | 'SIN'|'TAN'|'SQRT'| 'LOG'|'LN'|'ACOS'|'ABS'|'ROUND'|'ASIN'|'ATAN'|'EXP'|'COSH'|'SINH'|'TANH';
COMMENT: '--' ~[\r\n]* -> skip;
WS: [ \t\r\n]+ -> skip;

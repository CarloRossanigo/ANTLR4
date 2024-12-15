package Espr;

public class NumericExpression extends Expression {
    private Expression left; // Espressione destra
    private Expression right; // Espressione(operando) sx
    private String operator; // Operatore aritmetico
    private Functions function; // Funzione  
    private String constant; // Costante 
    private Double number; // Numero
    
 // Costruttore per espressioni aritmetiche
    public NumericExpression(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
 // Costruttore per funzioni
    public NumericExpression(Functions function, Expression argument) {
        this.left = argument;
        this.function = function;
    }
 // Costruttore per espressioni costanti
    public NumericExpression(String constant) {
        this.constant = constant;
    }
 // Costruttore per numeri
    public NumericExpression(Double number) {
        this.number = number;
    }
 // Valuta l'espressione e restituisce il risultato
    @Override
    public Value evaluate(Environment env) {
        if (function != null) {
            double result = function.Eval((Double) left.evaluate(env).getValue());
            return new ValueNum(rounds(result));
        } else if (constant != null) {
            return new ValueNum(rounds(evaluateConstant()));
        } else if (number != null) {
            return new ValueNum(rounds(number));
        } else {
            double result =OperationEval(env);
           return new ValueNum(rounds(result));
        }
    }

    private double evaluateConstant() {
    	switch(constant) {
    	case "PI":
    		return Math.PI;
        case "-PI":
        	return -Math.PI;
        case "EULER":
        	return Math.E;
        case "-EULER":
        	return -Math.E;
        default:
         throw new UnsupportedOperationException("Costante non supportata: " + constant);
         
    	}
    }
 // Evaluation dell'operazione
    private double OperationEval(Environment env) {
        double leftVal = (Double) left.evaluate(env).getValue();
        double rightVal = right != null ? (Double) right.evaluate(env).getValue() : 0.0;

         switch (operator) {
            case "+":
            	return leftVal + rightVal;
            case "-" :
            	return leftVal - rightVal;
            case "*" :
            	return leftVal * rightVal;
            case "/":
            	return leftVal / rightVal;
            case "^":
            	return Math.pow(leftVal, rightVal);
            default:
            	throw new UnsupportedOperationException("Operatore aritmetico non supportato: " + operator);
            	
         }
    }

    @Override
    public String toString() {
        if (function != null) {
            return function + "(" + left + ")";
        } else if (constant != null) {
            return constant;
        } else if (number != null) {
            return number.toString();
        } else {
            return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
        }
    }
    //arrotondamento
    
    private double rounds(double value) {
        return Math.round(value * 1000000.0) / 1000000.0;
    }
}

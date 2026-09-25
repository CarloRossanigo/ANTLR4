package Espr;

public class NumericExpression extends Expression {
    private Expression left;         
    private Expression right;         
    private String operator;          
    private Functions function;         
    private String constant;           
    private Double number;            

    // Constructor for arithmetic expression 
    public NumericExpression(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    // Constructor for functions 
    public NumericExpression(Functions function, Expression argument) {
        this.left = argument;
        this.function = function;
    }

    // Constructor for constant 
    public NumericExpression(String constant) {
        this.constant = constant;
    }

    // Constructor for numbers 
    public NumericExpression(Double number) {
        this.number = number;
    }

    // Evaluate the expression and return the results Valuta 
    @Override
    public Value evaluate(Environment env) {
        
        if (function != null) {
            double result = function.Eval((Double) left.evaluate(env).getValue());
            return new ValueNum(rounds(result));
        } 
       
        else if (constant != null) {
            return new ValueNum(rounds(evaluateConstant()));
        } 
        
        else if (number != null) {
            return new ValueNum(rounds(number));
        } 
        
        else {
            double result = OperationEval(env);
            return new ValueNum(rounds(result));
        }
    }

    // Constant Evaluation 
    private double evaluateConstant() {
        return switch (constant) {
            case "PI" -> Math.PI;
            case "-PI" -> -Math.PI;
            case "EULER" -> Math.E;
            case "-EULER" -> -Math.E;
            default -> throw new UnsupportedOperationException("Costante non supportata: " + constant);
        };
    }

    // Operation Evaluation 
    private double OperationEval(Environment env) {
        double leftVal = (Double) left.evaluate(env).getValue();
        double rightVal = right != null ? (Double) right.evaluate(env).getValue() : 0.0;

        
        switch (operator) {
            case "+":
                return leftVal + rightVal;
            case "-":
                return leftVal - rightVal;
            case "*":
                return leftVal * rightVal;
            case "/":
                return leftVal / rightVal;
            case "^":
                return Math.pow(leftVal, rightVal);
            default:
                throw new UnsupportedOperationException("Operatore aritmetico non supportato: " + operator);
        }
    }

    // Print (toString)
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

    
    private double rounds(double value) {
        return Math.round(value * 1000000.0) / 1000000.0;
    }
}

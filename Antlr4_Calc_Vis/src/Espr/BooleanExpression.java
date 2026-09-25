package Espr;

public class BooleanExpression extends Expression {
    private Expression left; 
    private Expression right; 
    private String operator; // Logic Operator 

    //Constructor for logic expression with 2 operands and operator 
    public BooleanExpression(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public Value evaluate(Environment env) {
        // Evaluate the logic expression and return the result 
        boolean result = OperationEval(env);
        return new ValueBool(result);
    }

    private boolean OperationEval(Environment env) {
        // Execute the boolean operaion between 2 operands 
        double leftV = (Double) left.evaluate(env).getValue();
        double rightV = right != null ? (Double) right.evaluate(env).getValue() : 0.0;
        
        // Evaluate the logic operator 
        switch(operator) {
        	case ">":  return leftV > rightV;    
        	case "≥":  return leftV >= rightV;   
        	case "<":  return leftV < rightV;    
            case "≤":  return leftV <= rightV;   
            case "=":  return leftV == rightV;   
            case "≠":  return leftV != rightV;   
            default: 
            	throw new UnsupportedOperationException("Operatore booleano non supportato: " + operator);
        }
    }

    @Override
    public String toString() {
       
        return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
    }
}

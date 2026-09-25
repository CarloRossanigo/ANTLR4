package Espr;

public class BooleanExpression extends Expression {
    private Expression left;
    private Expression right;
    private String operator; //operatore booleano

    // Constructor for boolean expression with thw operands and an operator 
    public BooleanExpression(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
    
    @Override
    public Value evaluate(Environment env) {
    	// Evaluate the boolean expression 
        boolean result = OperationEval(env);
        
        return new ValueBool(result);
    }

    private boolean OperationEval(Environment env) {
    	// Values extraction of the right and left expression 
        double leftV = (Double) left.evaluate(env).getValue();
        double rightV = right != null ? (Double) right.evaluate(env).getValue() : 0.0;
        switch(operator) {
        	case ">":
        		return leftV > rightV;
        	case ">=" :
        		return leftV >= rightV;
        	case "<" : 
        		return  leftV < rightV;
            case "<=" :
            	return leftV <= rightV;
            case "=" :
            	return leftV == rightV;
            case "≠" :
            	return leftV != rightV;
            default: 
            	throw new UnsupportedOperationException("Operatore booleano non supportato: " + operator);
            	
        }
    }


    @Override
    public String toString() {
        return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
    }
}

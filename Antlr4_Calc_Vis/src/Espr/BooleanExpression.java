package Espr;

public class BooleanExpression extends Expression {
    private Expression left; 
    private Expression right; 
    private String operator; // Operatore logico

    //costruttore per espressioni logiche con due operandi e un operatore
    public BooleanExpression(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }

    @Override
    public Value evaluate(Environment env) {
        // Valuta l'espressione logica e ritorna il risultato
        boolean result = OperationEval(env);
        return new ValueBool(result);
    }

    private boolean OperationEval(Environment env) {
        // Esegue l'operazione booleana tra i due operandi
        double leftV = (Double) left.evaluate(env).getValue();
        double rightV = right != null ? (Double) right.evaluate(env).getValue() : 0.0;
        
        // Valuta l'operatore logico
        switch(operator) {
        	case ">":  return leftV > rightV;    // Maggiore di
        	case "≥":  return leftV >= rightV;   // Maggiore o uguale a
        	case "<":  return leftV < rightV;    // Minore di
            case "≤":  return leftV <= rightV;   // Minore o uguale a
            case "=":  return leftV == rightV;   // Uguale a
            case "≠":  return leftV != rightV;   // Diverso da
            default: 
            	throw new UnsupportedOperationException("Operatore booleano non supportato: " + operator);
        }
    }

    @Override
    public String toString() {
       
        return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
    }
}

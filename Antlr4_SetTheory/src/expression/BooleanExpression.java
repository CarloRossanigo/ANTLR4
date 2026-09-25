package expression;

import java.util.List;

public class BooleanExpression extends Expression {
    private Expression left;
    private Expression right;
    private String operator; //Boolean Operator 
  //Constructor for boolean expression  
    public BooleanExpression(Expression left, Expression right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
//Logic operations evaluation 
    @Override
    public Value evaluate(Environment env) {
        Value leftValue = left.evaluate(env);
        Value rightValue = right.evaluate(env);
        	//Proceed if there are two sets 
        if (leftValue instanceof ValueSet && rightValue instanceof ValueSet) {
            List<Object> leftList = leftValue.getValue();
            List<Object> rightList = rightValue.getValue();

            List<Object> result = evaluateBooleanOperation(leftList, rightList);
            return new ValueBool(result.contains("vero"));
        } else {
            throw new UnsupportedOperationException("Operatore booleano non supportato: " + leftValue.getClass().getName() + " e " + rightValue.getClass().getName());
        }
    }
    //Methods that bring to single boolean operations 
    private List<Object> evaluateBooleanOperation(List<Object> leftList, List<Object> rightList) {
        return switch (operator) {
            case "=" -> equals(leftList, rightList);
            case "≠" -> notEquals(leftList, rightList);
            case "≤" -> contenutoIn(leftList, rightList);
            case "≥" -> contenuto(leftList, rightList);
            default -> throw new UnsupportedOperationException("Operatore booleano non supportato: " + operator);
        };
    }
    // Check if the two sets are equals 
    private List<Object> equals(List<Object> left, List<Object> right) {
        if (left.equals(right)) 
            return List.of("vero");
         else 
            return List.of("falso");
        }
  //check if the two sets aren't equal 
        private List<Object> notEquals(List<Object> left, List<Object> right) {
            if (!left.equals(right)) {
                return List.of("vero");
            } else {
                return List.of("falso");
            }
        }
      //Check if the right sets contains the left 
        private List<Object> contenutoIn(List<Object> left, List<Object> right) {
            if (right.containsAll(left)) {
                return List.of("vero");
            } else {
                return List.of("falso");
            }
        }
        // Check if the left set contains the right 
        private List<Object> contenuto(List<Object> left, List<Object> right) {
            if (left.containsAll(right)) {
                return List.of("vero");
            } else {
                return List.of("falso");
            }
        }

        @Override
        public String toString() {
        	return "(" + left.toString() + " " + operator + " " + right.toString() + ")";
        }
    }


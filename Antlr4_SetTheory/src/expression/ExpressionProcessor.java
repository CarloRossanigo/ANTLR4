package expression;

import java.util.ArrayList;
import java.util.List;

public class ExpressionProcessor {
    private List<Expression> expressions; // Expression list to evaluate 
    private Environment env;  // Environment  

    // Constructor that initialize ehe expression list and the environemnt 
    public ExpressionProcessor(List<Expression> expressions) {
        this.expressions = expressions;
        this.env = new Environment();
    }
 // Methods to obtian the results of expression evaluation 
    public List<String> getEvaluationResults() {
        List<String> evaluations = new ArrayList<>();

        for (Expression e : expressions) {
        	try {
        		// Handle the sets declaration 
            if (e instanceof SetDeclaration) {
                SetDeclaration decl = (SetDeclaration) e;
                Value value = new ValueSet(decl.getValue());
                env.addSet(decl.getId(), value);
            } else {
                String input = e.toString();
                Value result = e.evaluate(env);
                //Boolean operations 
                if (result instanceof ValueBool) {
                    evaluations.add(input + " è " + result.getValue().get(0));
                }// Set operations 
                else if (result instanceof ValueSet) {
                    evaluations.add(input + " è " + result.getValue());
                } 
            }
        	}catch (RuntimeException ex) {
                evaluations.add("Errore valutando l'espressione: " + ex.getMessage());//Error evaluate the expressions
            }
        }
        return evaluations;
    }
}

package Espr;

import java.util.ArrayList;
import java.util.List;

public class ExpressionProcessor {
    private List<Expression> expressions;  // List of the expression to evaluate 
    private Environment environment;        // Environment   

    // Constructor that initalize the list of expression and the environment 
    public ExpressionProcessor(List<Expression> expressions) {
        this.expressions = expressions;
        this.environment = new Environment();
    }

    // Methods to obtain the result of the expressions evaluation 
    public List<String> getEvaluationResults() {
        List<String> evaluations = new ArrayList<>();
        
        for (Expression e : expressions) {
            try {
                // Handle the variable Declaration 
                if (e instanceof VariableDeclaration) {
                    VariableDeclaration decl = (VariableDeclaration) e;
                    Value value = new ValueNum(decl.getValue()); 
                    environment.addVariable(decl.getName(), value);
                } 
                // Evaluation of the variable expressions 
                else if (e instanceof Var) {
                    Value result = e.evaluate(environment);
                    evaluations.add(e.toString() + " è " + formatValue(result));
                } 
                
                else {
                    Value result = e.evaluate(environment);
                    evaluations.add(e.toString() + " è " + formatValue(result));
                }
            } catch (RuntimeException ex) {
                
                evaluations.add("Errore nella valutazione dell'espressione: " + ex.getMessage());
            }
        }

        return evaluations;  // Return the evaluation results 
    }

    
    private String formatValue(Value value) {
        if (value instanceof ValueNum) {
            return ((ValueNum) value).getValue() + "";
        } else if (value instanceof ValueBool) {
            return ((ValueBool) value).getValue() + "";
        } else {
            return "Risultato non riconosciuto: " + value;
        }
    }
}

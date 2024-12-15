package Espr;

import java.util.ArrayList;
import java.util.List;

public class ExpressionProcessor {
    private List<Expression> expressions; // Lista delle espressioni da valutare
    private Environment environment; // Ambiente  

    // Costruttore che inizializza la lista delle espressioni e l'ambiente
    public ExpressionProcessor(List<Expression> expressions) {
        this.expressions = expressions;
        this.environment = new Environment();
    }
    
    // Metodo per ottenere i risultati della valutazione delle espressioni

    public List<String> getEvaluationResults() {
        List<String> evaluations = new ArrayList<>();
        
        for (Expression e : expressions) {
            try {
            	// Gestione delle dichiarazioni di variabili
                if (e instanceof VariableDeclaration) {
                    VariableDeclaration decl = (VariableDeclaration) e;
                    Value value = new ValueNum(decl.getValue());
                    environment.addVariable(decl.getName(), value);
                } // Valutazione delle espressioni di variabili
                else if (e instanceof Var) {
                    Value result = e.evaluate(environment);
                    evaluations.add(e.toString() + " è " + formatValue(result));
                } else {
                    Value result = e.evaluate(environment);
                    evaluations.add(e.toString() + " è " + formatValue(result));
                }
            } catch (RuntimeException ex) {
                evaluations.add("Errore valutano l'espressione: " + ex.getMessage());
            }
        }

        return evaluations; // Restituisce i risultati delle valutazioni
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

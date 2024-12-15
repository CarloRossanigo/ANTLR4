package expression;

import java.util.ArrayList;
import java.util.List;

public class ExpressionProcessor {
    private List<Expression> expressions; // Lista delle espressioni da valutare
    private Environment env;  // Ambiente 

    // Costruttore che inizializza la lista delle espressioni e l'ambiente
    public ExpressionProcessor(List<Expression> expressions) {
        this.expressions = expressions;
        this.env = new Environment();
    }
 // Metodo per ottenere i risultati della valutazione delle espressioni
    public List<String> getEvaluationResults() {
        List<String> evaluations = new ArrayList<>();

        for (Expression e : expressions) {
        	try {
        		//gestione dichiarazione degli insiemi
            if (e instanceof SetDeclaration) {
                SetDeclaration decl = (SetDeclaration) e;
                Value value = new ValueSet(decl.getValue());
                env.addSet(decl.getId(), value);
            } else {
                String input = e.toString();
                Value result = e.evaluate(env);
                //Operazioni booleane
                if (result instanceof ValueBool) {
                    evaluations.add(input + " è " + result.getValue().get(0));
                }//Operazioni "aritmetiche"
                else if (result instanceof ValueSet) {
                    evaluations.add(input + " è " + result.getValue());
                } 
            }
        	}catch (RuntimeException ex) {
                evaluations.add("Errore valutando l'espressione: " + ex.getMessage());//Errore valutando l'espressione:
            }
        }
        return evaluations;
    }
}

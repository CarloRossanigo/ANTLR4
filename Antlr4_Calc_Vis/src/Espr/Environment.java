package Espr;

import java.util.HashMap;

public class Environment {
    private HashMap<String, Value> context;// mappa delle variabili e dei loro valori 
    

    public Environment() {
        this.context = new HashMap<>();
    }

    public void addVariable(String name, Value value) {
        context.put(name, value);// aggiunge una variabile al contesto
        
    }

    
    public Value getVariable(Var name) {
        if (context.containsKey(name.toString())) {
            return context.get(name.toString());// restituisce il valore della variabile 
            
        } else {
            throw new RuntimeException("Variabile non trovata: " + name);
        }
    }

    public Value evaluate(Expression expr) {
        return expr.evaluate(this);// valuta l'espressione nel contesto corrente 
       
    }
}

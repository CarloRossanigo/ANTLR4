package Espr;

import java.util.HashMap;

public class Environment {
    private HashMap<String, Value> context;// Variable Map and their values  
    

    public Environment() {
        this.context = new HashMap<>();
    }

    public void addVariable(String name, Value value) {
        context.put(name, value);// Adding variable to the context 
        
    }

    
    public Value getVariable(Var name) {
        if (context.containsKey(name.toString())) {
            return context.get(name.toString());// return the variable value  
            
        } else {
            throw new RuntimeException("Variabile non trovata: " + name);
        }
    }

    public Value evaluate(Expression expr) {
        return expr.evaluate(this);// Evaluate the expression in the current context  
       
    }
}

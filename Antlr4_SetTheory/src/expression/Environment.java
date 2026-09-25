package expression;

import java.util.HashMap;

public class Environment {
    private HashMap<String, Value> context; // Sets and their values map  

    public Environment() {
        this.context = new HashMap<>();
    }

    public HashMap<String, Value> values() {
        return context;
    }

    public void addSet(String name, Value value) {
        context.put(name, value); // Adding a set to the context 
    }

    public Value getVariable(Set name) {
        if (context.containsKey(name.toString())) {
            return context.get(name.toString()); // return the sets name  
        } else {
            throw new RuntimeException("Insieme non trovato: " + name);
        }
    }

    public Value evaluate(Expression expr) {
        return expr.evaluate(this); //Evaluiate the expression in the current context  
    }
}

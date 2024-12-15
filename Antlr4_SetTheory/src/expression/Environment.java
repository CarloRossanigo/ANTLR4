package expression;

import java.util.HashMap;

public class Environment {
    private HashMap<String, Value> context; // mappa degli insiemi e dei loro valori 

    public Environment() {
        this.context = new HashMap<>();
    }

    public HashMap<String, Value> values() {
        return context;
    }

    public void addSet(String name, Value value) {
        context.put(name, value); // aggiunge un insieme al contesto
    }

    public Value getVariable(Set name) {
        if (context.containsKey(name.toString())) {
            return context.get(name.toString()); // restituisce il nome dell'insieme 
        } else {
            throw new RuntimeException("Insieme non trovato: " + name);
        }
    }

    public Value evaluate(Expression expr) {
        return expr.evaluate(this); // valuta l'espressione nel contesto corrente 
    }
}

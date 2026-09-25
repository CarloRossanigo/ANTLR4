package Espr;


import java.util.HashMap;


public class Environment {
    private HashMap<String, Value> context;// hMap of variables and their values  
    

    public Environment() {
        this.context = new HashMap<>();
    }

    public void addVariable(String name, Value value) {
        context.put(name, value);// adding variables to the context 
        
    }

    
    public Value getVariable(Var name) {
        if (context.containsKey(name.toString())) {
            return context.get(name.toString());// returning the variables values  
           
        } else {
            throw new RuntimeException("Non trovo la variabile: " + name);// Variable not found 
        }
    }

    public Value evaluate(Expression expr) {
        return expr.evaluate(this);// Evaluate teh expression in the current context  
       
    }
}



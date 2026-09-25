package Espr;

public class Var extends Expression {
    private String name; // Variable name 

    // Constructor that intialize the variable  
    public Var(String name) {
        this.name = name;
    }

    
    @Override
    public Value evaluate(Environment env) {
        return env.getVariable(this); 
    }

    
    @Override
    public String toString() {
        return name;
    }
}



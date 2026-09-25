package Espr;

public class VariableDeclaration extends Expression {
    private String name;  // Variable name 
    private String type;  // Variable type  
    private double value; // Associated Value  

    // Constructor to iniztalie the variable with name, type and value  
    public VariableDeclaration(String name, String type, double value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    // Return the variable name 
    public String getName() {
        return name;
    }

    // Return the variable type  
    public String getType() {
        return type;
    }

    // Return the variable's value 
    public double getValue() {
        return value;
    }

    
    @Override
    public String toString() {
        return name + " : " + type + " : " + value;
    }

    // Execution of the variablkes's evaluation  
    @Override
    public Value evaluate(Environment env) {
        Value value = new ValueNum(this.value);  
        env.addVariable(name, value);  // Adding the variable to the environment 
        return value;  // Return the value 
    }
}

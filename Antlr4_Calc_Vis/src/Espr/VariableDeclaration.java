package Espr;

public class VariableDeclaration extends Expression {
    private String name; // variable name 
    private String type; // Variable type  
    private double value; // variable value 

 // Constructor to initialize the varibale with name,type,value 
    public VariableDeclaration(String name, String type, double value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    // Return the name variable
    public String getName() {
        return name;
    }
    // Return the variable type 
    public String getType() {
        return type;
    }
 // return the variable value 
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + " : " + type + " : " + value;
    }
 // Execution the evaluation variable 
    @Override
    public Value evaluate(Environment env) {
        Value value = new ValueNum(this.value);  
        env.addVariable(name, value); // Adding the variable to the environment 
        return value;  // Return the value 
    }
}

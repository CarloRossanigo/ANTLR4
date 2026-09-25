package Espr;

public class ValueBool extends Value {
    private boolean value; // Boolean value linked  

    // Constructor to initialize the boolean value  
    public ValueBool(boolean v) {
        this.value = v;
    }

    // Return the value
    @Override
    public Boolean getValue() {
        return value;
    }
}

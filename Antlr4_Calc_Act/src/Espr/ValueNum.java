package Espr;

public class ValueNum extends Value {
    private double value; // Linked numeric value 

    // Constructor that initialize the numeric value  
    public ValueNum(double value) {
        this.value = value;
    }

    // Return the value  
    @Override
    public Double getValue() {
        return value;
    }
}

package Espr;

public class ValueNum extends Value {
    private double value; // Numeric value linked 

 // Constructor to initialize the numeric value 
    public ValueNum(double value) {
        this.value = value;
    }

 // Return the value 
    @Override
    public Double getValue() {
        return value;
    }
}



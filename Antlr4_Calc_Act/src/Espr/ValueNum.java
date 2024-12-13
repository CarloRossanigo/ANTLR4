package Espr;

public class ValueNum extends Value {
    private double value; // Valore numerico associato

    // Costruttore che inizializza il valore numerico
    public ValueNum(double value) {
        this.value = value;
    }

    // Restituisce il valore 
    @Override
    public Double getValue() {
        return value;
    }
}

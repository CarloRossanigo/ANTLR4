package Espr;
public class ValueBool extends Value {
    private boolean value; // Valore booleano associato

    // Costruttore che inizializza il valore booleano
    public ValueBool(boolean v) {
        this.value = v;
    }

 // Restituisce il valore
    @Override
    public Boolean getValue() {
        return value;
    }
}

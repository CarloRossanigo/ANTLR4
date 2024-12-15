package expression;

import java.util.List;

public class ValueBool extends Value {
    private boolean value;	// Valore booleano associato
 // Costruttore che inizializza il valore booleano
    public ValueBool(boolean v) {
        this.value = v;
    }

    @Override
    // Restituisce il valore
    public List<Object> getValue() {
        return List.of(value);
    }
}

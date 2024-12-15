package expression;

import java.util.List;

public class ValueSet extends Value {
    private List<Object> value; // lista dei valori

 // Costruttore che inizializza la lista dei valori
    public ValueSet(List<Object> result) {
        this.value = result;
    }

    @Override
 // Restituisce i valori 
    public List<Object> getValue() {
        return value;
    }
}



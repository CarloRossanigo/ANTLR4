package expression;

import java.util.List;

public class ValueSet extends Value {
    private List<Object> value; // Value list

 // Constructor to initialize the value list
    public ValueSet(List<Object> result) {
        this.value = result;
    }

    @Override
 // Return the value 
    public List<Object> getValue() {
        return value;
    }
}



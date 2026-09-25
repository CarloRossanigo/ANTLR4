package expression;

import java.util.List;

public class ValueBool extends Value {
    private boolean value;	// Boolean value linked 
 // Constructor to intialize the boolean value 
    public ValueBool(boolean v) {
        this.value = v;
    }

    @Override
    // Return the value
    public List<Object> getValue() {
        return List.of(value);
    }
}

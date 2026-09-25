package expression;

import java.util.List;
//Class to declare a set 
public class SetDeclaration extends Expression {
    private String id; //Name
    private List<Object> value; //Elements
//Constructor to declare a set from the name and a elements list
    public SetDeclaration(String id, List<Object> value) {
        this.id = id;
        this.value = value;
    }
//return the elements list 
    public List<Object> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return id;
    }

    public String getId() {
        return id;
    }
// Set's Evaluation: to add to the defined sets list
    @Override
    public Value evaluate(Environment environment) {
        ValueSet valueSet = new ValueSet(value);
        environment.addSet(id, valueSet);
        return valueSet;
    }
}

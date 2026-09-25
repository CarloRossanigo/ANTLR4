package expression;

//Class to represent the sets 
public class Set extends Expression {
    private String id;	//Sets name  
//Constructor to buld the set from the name 
    public Set(String Id) {
        this.id = Id;
    }

    @Override
    public String toString() {
        return id;
    }

    public String getId() {
        return id;
    }

    @Override
    // Set's Evaluation 
    public Value evaluate(Environment environment) {
        if (!environment.values().containsKey(id)) {
            throw new RuntimeException("Insieme non definito: " + id);
        }
        return new ValueSet(environment.values().get(id).getValue());
    }
}

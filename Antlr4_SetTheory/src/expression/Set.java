package expression;

//Classe per rappresentare gli insiemi
public class Set extends Expression {
    private String id;	//nome insieme 
//Costruttore che costruisce un insieme a partire dal nome
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
    //Evaluation dell'insieme
    public Value evaluate(Environment environment) {
        if (!environment.values().containsKey(id)) {
            throw new RuntimeException("Insieme non definito: " + id);
        }
        return new ValueSet(environment.values().get(id).getValue());
    }
}

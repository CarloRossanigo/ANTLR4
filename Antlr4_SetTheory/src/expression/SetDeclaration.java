package expression;

import java.util.List;
//Classe per la dichiarazione di un insieme
public class SetDeclaration extends Expression {
    private String id; //Nome
    private List<Object> value; //Elementi
//Costruttore che dichiara un insieme tramite nome e lista degli elementi
    public SetDeclaration(String id, List<Object> value) {
        this.id = id;
        this.value = value;
    }
//Restituisce la lista degli elementi
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
//Evaluation dell'insieme: lo aggiungiamo alla lista degli insiemi definiti
    @Override
    public Value evaluate(Environment environment) {
        ValueSet valueSet = new ValueSet(value);
        environment.addSet(id, valueSet);
        return valueSet;
    }
}

package Espr;

public class VariableDeclaration extends Expression {
    private String name; // Nome della variabile
    private String type; // Tipo variabile 
    private double value; // Valore variabile

 // Costruttore che inizializza la variabile con nome, tipo e valore
    public VariableDeclaration(String name, String type, double value) {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    // Restituisce il nome della variabile
    public String getName() {
        return name;
    }
    // Restituisce il tipo della variabile
    public String getType() {
        return type;
    }
 // Restituisce il valore della variabile
    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name + " : " + type + " : " + value;
    }
 // Esegui la valutazione della variabil
    @Override
    public Value evaluate(Environment env) {
        Value value = new ValueNum(this.value);  
        env.addVariable(name, value); // Aggiunge la variabile all'ambiente
        return value;  // Restituisce il valore
    }
}

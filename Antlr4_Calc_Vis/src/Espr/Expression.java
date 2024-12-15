package Espr;

//Classe astratta che modelizza una espressione
public abstract class Expression {
	//metodo astratto per la valutazione di una espressione
public abstract Value evaluate(Environment env);

}

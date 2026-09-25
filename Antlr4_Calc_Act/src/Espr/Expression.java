package Espr;

//Abstract Class that modelize and expression 

public abstract class Expression {
	//Abstract Methods to evaluate the expression 
	// Each subclass must implement this method  
public abstract Value evaluate(Environment env);
}

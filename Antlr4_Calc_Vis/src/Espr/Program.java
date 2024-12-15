package Espr;

import java.util.ArrayList;
import java.util.List;

public class Program {
	
	private List<Expression> expressions;// Lista delle espressioni nel programma
    
	// Costruttore che inizializza la lista delle espressioni
	public Program() {
		this.expressions=new ArrayList<>();
	}
	// Aggiunge un'espressione alla lista
	public void addExpression(Expression e) {
		expressions.add(e);
	}
	// Restituisce la lista delle espressioni
	public  List<Expression> getExpr(){ return expressions;}
}
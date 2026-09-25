package Espr;

import java.util.ArrayList;
import java.util.List;

public class Program {
	
	private List<Expression> expressions;// Expression list in the program 
    
	// Constructor to initialize expression list 
	public Program() {
		this.expressions=new ArrayList<>();
	}
	// Adding the expression to the list 
	public void addExpression(Expression e) {
		expressions.add(e);
	}
	// Return the expression list 
	public  List<Expression> getExpr(){ return expressions;}
}

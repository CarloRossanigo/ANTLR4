package expression;

import java.util.ArrayList;
import java.util.List;

public class Program {
	public List<Expression> expressions;// Expression list in the program 
	// Constructor that initalize the expression list 
	public Program() {
		this.expressions=new ArrayList<>();
	}
	//Adding an expression to the list 
	public void addExpression(Expression e) {
		expressions.add(e);
	}
	
}

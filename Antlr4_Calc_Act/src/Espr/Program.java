package Espr;

import java.util.ArrayList;
import java.util.List;

public class Program {
    
    private List<Expression> expressions; // Expression list 
    
    // Constrcutor that initalize the expression list 
    public Program() {
        this.expressions = new ArrayList<>();
    }
    
    // Adding an expression to the list 
    public void addExpression(Expression e) {
        expressions.add(e);
    }
    
    // Return an expression list  
    public List<Expression> getExpr() { 
        return expressions;
    }
}

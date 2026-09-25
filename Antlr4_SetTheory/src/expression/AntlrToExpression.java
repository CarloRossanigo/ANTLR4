package expression;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import ANTLR4.TeoriaBaseVisitor;
import ANTLR4.TeoriaParser.DeclarationContext;
import ANTLR4.TeoriaParser.EqNeqCdxCsxContext;
import ANTLR4.TeoriaParser.MinMaxContext;
import ANTLR4.TeoriaParser.ParensContext;
import ANTLR4.TeoriaParser.SetContext;
import ANTLR4.TeoriaParser.ComplContext;
import ANTLR4.TeoriaParser.UnionIntDiffSimmContext;

public class AntlrToExpression extends TeoriaBaseVisitor<Expression> {
    private List<String> sets; 
    private List<String> semanticErrors; // Semantic error list 

    public AntlrToExpression(List<String> semanticErrors) {
        sets = new ArrayList<>();
        this.semanticErrors = semanticErrors;
    }
    
    @Override
    public Expression visitDeclaration(DeclarationContext ctx) {
    	//retrieve the information to declare a set  
        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int col = idToken.getCharPositionInLine() + 1;
        String id = ctx.ID().getText();
     // Control if the set is already declared 
        if (sets.contains(id)) {
            semanticErrors.add("Errore: insieme " + id + " già dichiarato alla riga " + line + ", colonna " + col);
        } else {
            sets.add(id);
        }
        //Retrieve the set elements 
        List<Object> values = new ArrayList<>();
        // Numbers
        for (TerminalNode numToken : ctx.NUM()) {
            float num = Float.parseFloat(numToken.getText());
            if(!values.contains(num)) // Don't accept duplicates 
            values.add(num);
        }
        // String
        for (TerminalNode stringToken : ctx.STRING()) {
            String s = stringToken.getText();
            if(!values.contains(s)) // Don't accept duplicates 
            values.add(s);
        }

        return new SetDeclaration(id, values);
    }

    @Override
    // Handle operations between sets with two operands 
    public Expression visitUnionIntDiffSimm(UnionIntDiffSimmContext ctx) {
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String operator = ctx.getChild(1).getText();
        return new SetExpression(left, right, operator);
    }

    @Override
  //Handle Complimentary operatioin between sets 
    public Expression visitCompl(ComplContext ctx) {
        Expression expr = visit(ctx.expr());
        String op = ctx.getChild(0).getText();
        return new SetExpression(expr, op);
    }

    @Override
    // Handle expression between parens 
    public Expression visitParens(ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    // Handle sets
    public Expression visitSet(SetContext ctx) {
        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int col = idToken.getCharPositionInLine() + 1;
        String id = ctx.ID().getText();

        if (!sets.contains(id)) {
            semanticErrors.add("Errore: insieme " + id + " non dichiarato alla riga " + line + ", colonna " + col);
        }
        return new Set(id);
    }

    @Override
    //Handle boolean operations 
    public Expression visitEqNeqCdxCsx(EqNeqCdxCsxContext ctx) {
        Expression l = visit(ctx.expr(0));
        Expression r = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();
        return new BooleanExpression(l, r, op);
    }

    @Override
    //Handle minimum and maximum of a set 
    public Expression visitMinMax(MinMaxContext ctx) {
        Expression r = visit(ctx.expr());
        String op = ctx.getChild(0).getText();
        return new SetExpression(r, op);
    }
}

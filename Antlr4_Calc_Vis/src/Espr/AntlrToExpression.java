package Espr;

import Antlr4.CalcBaseVisitor;
import Antlr4.CalcParser;
import Antlr4.CalcParser.AddSubContext;
import Antlr4.CalcParser.CostantContext;
import Antlr4.CalcParser.FunctionContext;
import Antlr4.CalcParser.GreatLessContext;
import Antlr4.CalcParser.EqualsNequContext;
import Antlr4.CalcParser.MultDivPowContext;
import Antlr4.CalcParser.NumberContext;
import Antlr4.CalcParser.ParenContext;
import Antlr4.CalcParser.VariableContext;

import org.antlr.v4.runtime.Token;
import java.util.HashMap;
import java.util.List;

public class AntlrToExpression extends CalcBaseVisitor<Expression> {

    private HashMap<String, Double> variabili; // Variable delcared Map 
    private List<String> semanticErrors; // Error semantic list 

    public AntlrToExpression(List<String> semanticErrors) {
        variabili = new HashMap<String, Double>();
        this.semanticErrors = semanticErrors;
    }

    @Override
    public Expression visitDeclaration(CalcParser.DeclarationContext ctx) {
        // extraction of information about the variable declaration  
        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int col = idToken.getCharPositionInLine() + 1;
        String id = ctx.getChild(0).getText();

        // Verifying if the variable i already declared 
        if (variabili.containsKey(id)) {
            semanticErrors.add("Errore: variabile " + id + " già dichiarata alla linea " + line + ", " + col);
        }

        String type = ctx.getChild(2).getText();
        Double value = Double.parseDouble(ctx.NUM().getText());
        variabili.put(id, value);

        return new VariableDeclaration(id, type, value);
    }

    @Override
    public Expression visitAddSub(AddSubContext ctx) {
        // Handle the sum and difference expression 
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();

        return new NumericExpression(left, right, op);
    }

    @Override
    public Expression visitMultDivPow(MultDivPowContext ctx) {
        // Handle the product, divison and power expression 
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();

        return new NumericExpression(left, right, op);
    }

    @Override
    public Expression visitVariable(VariableContext ctx) {
        // Control the variable use 
        String id = ctx.ID().getText();

        // error if the varibale isn't declared 
        if (!variabili.containsKey(id)) {
            Token idToken = ctx.ID().getSymbol();
            int line = idToken.getLine();
            int col = idToken.getCharPositionInLine() + 1;
            semanticErrors.add("Errore: variabile " + id + " non dichiarata alla linea " + line + ", " + col);
        }

        return new Var(id);
    }

    @Override
    public Expression visitParen(ParenContext ctx) {
        // Handle the expression between parens 
        return visit(ctx.expr());
    }

    @Override
    public Expression visitNumber(NumberContext ctx) {
        // Handle the constant 
        Double value = Double.parseDouble(ctx.NUM().getText());
        return new NumericExpression(value);
    }

    @Override
    public Expression visitGreatLess(GreatLessContext ctx) {
        // Handle the exprsion of > and < )
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();
        return new BooleanExpression(left, right, op);
    }

    @Override
    public Expression visitEqualsNequ(EqualsNequContext ctx) {
        //  Handle the expression = and != 
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();
        return new BooleanExpression(left, right, op);
    }

    @Override
    public Expression visitFunction(FunctionContext ctx) {
        // Handle the function 
        String functionName = ctx.FUNCTION().getText();
        Expression argument = visit(ctx.expr());
        Functions function = Functions.valueOf(functionName.toUpperCase());

        return new NumericExpression(function, argument);
    }

    @Override
    public Expression visitCostant(CostantContext ctx) {
        // Handle constant 
        String constant = ctx.COSTANT().getText();
        return new NumericExpression(constant);
    }
}

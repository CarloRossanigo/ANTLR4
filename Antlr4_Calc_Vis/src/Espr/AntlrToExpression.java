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

    private HashMap<String, Double> variabili; // Mappa delle variabili dichiarate
    private List<String> semanticErrors; // Lista per gli errori semantici

    public AntlrToExpression(List<String> semanticErrors) {
        variabili = new HashMap<String, Double>();
        this.semanticErrors = semanticErrors;
    }

    @Override
    public Expression visitDeclaration(CalcParser.DeclarationContext ctx) {
        // Estrae informazioni sulla dichiarazione di variabile
        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int col = idToken.getCharPositionInLine() + 1;
        String id = ctx.getChild(0).getText();

        // Controlla se la variabile è già dichiarata
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
        // Gestisce le espressioni di somma e sottrazione
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();

        return new NumericExpression(left, right, op);
    }

    @Override
    public Expression visitMultDivPow(MultDivPowContext ctx) {
        // Gestisce le espressioni di moltiplicazione, divisione e potenza
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();

        return new NumericExpression(left, right, op);
    }

    @Override
    public Expression visitVariable(VariableContext ctx) {
        // Controlla l'uso di una variabile
        String id = ctx.ID().getText();

        // Errore se la variabile non è stata dichiarata
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
        // Gestisce le espressioni tra parentesi
        return visit(ctx.expr());
    }

    @Override
    public Expression visitNumber(NumberContext ctx) {
        // Gestisce i numeri costanti
        Double value = Double.parseDouble(ctx.NUM().getText());
        return new NumericExpression(value);
    }

    @Override
    public Expression visitGreatLess(GreatLessContext ctx) {
        // Gestisce le espressioni di confronto (maggiore/meno)
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();
        return new BooleanExpression(left, right, op);
    }

    @Override
    public Expression visitEqualsNequ(EqualsNequContext ctx) {
        // Gestisce le espressioni di uguaglianza/diseguaglianza
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();
        return new BooleanExpression(left, right, op);
    }

    @Override
    public Expression visitFunction(FunctionContext ctx) {
        // Gestisce le chiamate a funzioni
        String functionName = ctx.FUNCTION().getText();
        Expression argument = visit(ctx.expr());
        Functions function = Functions.valueOf(functionName.toUpperCase());

        return new NumericExpression(function, argument);
    }

    @Override
    public Expression visitCostant(CostantContext ctx) {
        // Gestisce le costanti
        String constant = ctx.COSTANT().getText();
        return new NumericExpression(constant);
    }
}

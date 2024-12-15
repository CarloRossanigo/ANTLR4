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
    private List<String> sets; // memorizzo gli insiemi dichiarati
    private List<String> semanticErrors; // Lista errori semantici

    public AntlrToExpression(List<String> semanticErrors) {
        sets = new ArrayList<>();
        this.semanticErrors = semanticErrors;
    }
    //Override dei metodi di visita
    @Override
    public Expression visitDeclaration(DeclarationContext ctx) {
    	//Recupero le informazioni per dichiarazione insieme
        Token idToken = ctx.ID().getSymbol();
        int line = idToken.getLine();
        int col = idToken.getCharPositionInLine() + 1;
        String id = ctx.ID().getText();
     // Controlla se l'insieme è già dichiarato
        if (sets.contains(id)) {
            semanticErrors.add("Errore: insieme " + id + " già dichiarato alla riga " + line + ", colonna " + col);
        } else {
            sets.add(id);
        }
        //Recupero gli elementi dell'insieme
        List<Object> values = new ArrayList<>();
        //numeri
        for (TerminalNode numToken : ctx.NUM()) {
            float num = Float.parseFloat(numToken.getText());
            if(!values.contains(num)) //Non voglio duplicati
            values.add(num);
        }
        //stringhe
        for (TerminalNode stringToken : ctx.STRING()) {
            String s = stringToken.getText();
            if(!values.contains(s)) //Non voglio duplicati
            values.add(s);
        }

        return new SetDeclaration(id, values);
    }

    @Override
    //gestione operazioni a due operandi fra insiemi
    public Expression visitUnionIntDiffSimm(UnionIntDiffSimmContext ctx) {
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        String operator = ctx.getChild(1).getText();
        return new SetExpression(left, right, operator);
    }

    @Override
  //gestione operazione complementare fra insiemi
    public Expression visitCompl(ComplContext ctx) {
        Expression expr = visit(ctx.expr());
        String op = ctx.getChild(0).getText();
        return new SetExpression(expr, op);
    }

    @Override
    //gestione delle espressioni fra parentesi
    public Expression visitParens(ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    //gestione insiemi
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
    //gestione operazioni booleane
    public Expression visitEqNeqCdxCsx(EqNeqCdxCsxContext ctx) {
        Expression l = visit(ctx.expr(0));
        Expression r = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();
        return new BooleanExpression(l, r, op);
    }

    @Override
    //gestione calcolo Min e Max
    public Expression visitMinMax(MinMaxContext ctx) {
        Expression r = visit(ctx.expr());
        String op = ctx.getChild(0).getText();
        return new SetExpression(r, op);
    }
}

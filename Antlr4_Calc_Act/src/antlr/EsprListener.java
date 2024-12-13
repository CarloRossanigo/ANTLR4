// Generated from Espr.g4 by ANTLR 4.13.1

    package antlr;
    import org.antlr.v4.runtime.*;
    import java.io.*;
    import java.util.*;
    import Espr.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EsprParser}.
 */
public interface EsprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EsprParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(EsprParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link EsprParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(EsprParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link EsprParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDecl(EsprParser.DeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link EsprParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDecl(EsprParser.DeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link EsprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(EsprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link EsprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(EsprParser.ExprContext ctx);
}
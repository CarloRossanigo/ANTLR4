// Generated from Teoria.g4 by ANTLR 4.13.1

    package ANTLR4;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TeoriaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TeoriaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link TeoriaParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TeoriaParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link TeoriaParser#decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(TeoriaParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnionIntDiffSimm}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnionIntDiffSimm(TeoriaParser.UnionIntDiffSimmContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqNeqCdxCsx}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqNeqCdxCsx(TeoriaParser.EqNeqCdxCsxContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Set}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(TeoriaParser.SetContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(TeoriaParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Compl}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompl(TeoriaParser.ComplContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MinMax}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinMax(TeoriaParser.MinMaxContext ctx);
}
// Generated from Teoria.g4 by ANTLR 4.13.1

    package ANTLR4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TeoriaParser}.
 */
public interface TeoriaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Program}
	 * labeled alternative in {@link TeoriaParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TeoriaParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Program}
	 * labeled alternative in {@link TeoriaParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TeoriaParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link TeoriaParser#decl}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(TeoriaParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link TeoriaParser#decl}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(TeoriaParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnionIntDiffSimm}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnionIntDiffSimm(TeoriaParser.UnionIntDiffSimmContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnionIntDiffSimm}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnionIntDiffSimm(TeoriaParser.UnionIntDiffSimmContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqNeqCdxCsx}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqNeqCdxCsx(TeoriaParser.EqNeqCdxCsxContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqNeqCdxCsx}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqNeqCdxCsx(TeoriaParser.EqNeqCdxCsxContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Set}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSet(TeoriaParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Set}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSet(TeoriaParser.SetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(TeoriaParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Parens}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(TeoriaParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Compl}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCompl(TeoriaParser.ComplContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Compl}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCompl(TeoriaParser.ComplContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MinMax}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMinMax(TeoriaParser.MinMaxContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MinMax}
	 * labeled alternative in {@link TeoriaParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMinMax(TeoriaParser.MinMaxContext ctx);
}
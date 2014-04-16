// Generated from Demo.g4 by ANTLR 4.2
package de.letsbuildacompiler.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link DemoParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface DemoVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link DemoParser#Mult}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(@NotNull DemoParser.MultContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#Plus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlus(@NotNull DemoParser.PlusContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#Minus}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinus(@NotNull DemoParser.MinusContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#Variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(@NotNull DemoParser.VariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#ProgPartFunctionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgPartFunctionDefinition(@NotNull DemoParser.ProgPartFunctionDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#Number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull DemoParser.NumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(@NotNull DemoParser.StatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(@NotNull DemoParser.FunctionCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(@NotNull DemoParser.AssignmentContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(@NotNull DemoParser.FunctionDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#println}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintln(@NotNull DemoParser.PrintlnContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#MainStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainStatement(@NotNull DemoParser.MainStatementContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull DemoParser.ProgramContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#funcCallExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpression(@NotNull DemoParser.FuncCallExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#Div}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiv(@NotNull DemoParser.DivContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(@NotNull DemoParser.VarDeclarationContext ctx);
}
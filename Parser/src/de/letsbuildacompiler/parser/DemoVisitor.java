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
	 * Visit a parse tree produced by {@link DemoParser#println}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintln(@NotNull DemoParser.PrintlnContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#Number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(@NotNull DemoParser.NumberContext ctx);

	/**
	 * Visit a parse tree produced by {@link DemoParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull DemoParser.ProgramContext ctx);
}
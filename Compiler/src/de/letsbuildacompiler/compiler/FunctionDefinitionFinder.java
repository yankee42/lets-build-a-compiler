package de.letsbuildacompiler.compiler;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;

import de.letsbuildacompiler.compiler.exceptions.FunctionAlreadyDefinedException;
import de.letsbuildacompiler.parser.DemoBaseVisitor;
import de.letsbuildacompiler.parser.DemoParser.FunctionDefinitionContext;

public class FunctionDefinitionFinder {
	
	public static Set<String> findFunctions(ParseTree tree) {
		final Set<String> definedFunctions = new HashSet<>();
		new DemoBaseVisitor<Void>() {
			@Override
			public Void visitFunctionDefinition(FunctionDefinitionContext ctx) {
				String functionName = ctx.funcName.getText();
				if (definedFunctions.contains(functionName)) {
					throw new FunctionAlreadyDefinedException(ctx.funcName);
				}
				definedFunctions.add(functionName);
				return null;
			}
		}.visit(tree);
		return definedFunctions;
	}
}

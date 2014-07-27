package de.letsbuildacompiler.compiler;

import org.antlr.v4.runtime.tree.ParseTree;

import de.letsbuildacompiler.compiler.exceptions.FunctionAlreadyDefinedException;
import de.letsbuildacompiler.parser.DemoBaseVisitor;
import de.letsbuildacompiler.parser.DemoParser.FunctionDefinitionContext;

public class FunctionDefinitionFinder {

  public static FunctionList findFunctions(final ParseTree tree) {
    final FunctionList definedFunctions = new FunctionList();

    new DemoBaseVisitor<Void>() {
      @Override
      public Void visitFunctionDefinition(final FunctionDefinitionContext ctx) {
        String functionName = ctx.funcName.getText();
        visit(ctx.params);

        if (definedFunctions.contains(functionName, ctx.returnType, ctx.params.declarations)) {
          throw new FunctionAlreadyDefinedException(ctx.funcName);
        }

        definedFunctions.add(functionName, ctx.returnType, ctx.params.declarations);

        return null;
      }
    }.visit(tree);

    return definedFunctions;
  }
}

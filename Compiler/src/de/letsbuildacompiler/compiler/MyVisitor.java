package de.letsbuildacompiler.compiler;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import de.letsbuildacompiler.compiler.exceptions.UndeclaredVariableException;
import de.letsbuildacompiler.compiler.exceptions.VariableAlreadyDefinedException;
import de.letsbuildacompiler.parser.DemoBaseVisitor;
import de.letsbuildacompiler.parser.DemoParser.AssignmentContext;
import de.letsbuildacompiler.parser.DemoParser.DivContext;
import de.letsbuildacompiler.parser.DemoParser.FunctionCallContext;
import de.letsbuildacompiler.parser.DemoParser.FunctionDefinitionContext;
import de.letsbuildacompiler.parser.DemoParser.MainStatementContext;
import de.letsbuildacompiler.parser.DemoParser.MinusContext;
import de.letsbuildacompiler.parser.DemoParser.MultContext;
import de.letsbuildacompiler.parser.DemoParser.NumberContext;
import de.letsbuildacompiler.parser.DemoParser.PlusContext;
import de.letsbuildacompiler.parser.DemoParser.PrintlnContext;
import de.letsbuildacompiler.parser.DemoParser.ProgramContext;
import de.letsbuildacompiler.parser.DemoParser.VarDeclarationContext;
import de.letsbuildacompiler.parser.DemoParser.VariableContext;

public class MyVisitor extends DemoBaseVisitor<String> {
	
	private Map<String, Integer> variables = new HashMap<>();
	
	@Override
	public String visitPrintln(PrintlnContext ctx) {
		return "  getstatic java/lang/System/out Ljava/io/PrintStream;\n" + 
				 visit(ctx.argument) + "\n" + 
				"  invokevirtual java/io/PrintStream/println(I)V\n";
	}
	
	@Override
	public String visitPlus(PlusContext ctx) {
		return visitChildren(ctx) + "\n" +
			"iadd";
	}
	
	@Override
	public String visitMinus(MinusContext ctx) {
		return visitChildren(ctx) + "\n" +
				"isub";
	}
	
	@Override
	public String visitDiv(DivContext ctx) {
		return visitChildren(ctx) + "\n" +
				"idiv";
	}
	
	@Override
	public String visitMult(MultContext ctx) {
		return visitChildren(ctx) + "\n" +
				"imul";
	}
	
	@Override
	public String visitNumber(NumberContext ctx) {
		return "ldc " + ctx.number.getText();
	}
	
	@Override
	public String visitVarDeclaration(VarDeclarationContext ctx) {
		if (variables.containsKey(ctx.varName.getText())) {
			throw new VariableAlreadyDefinedException(ctx.varName);
		}
		variables.put(ctx.varName.getText(), variables.size());
		return "";
	}
	
	@Override
	public String visitAssignment(AssignmentContext ctx) {
		return visit(ctx.expr) + "\n" +
				"istore " + requireVariableIndex(ctx.varName);
	}
	
	@Override
	public String visitVariable(VariableContext ctx) {
		return "iload " + requireVariableIndex(ctx.varName);
	}
	
	@Override
	public String visitFunctionCall(FunctionCallContext ctx) {
		return "invokestatic HelloWorld/" + ctx.funcName.getText() + "()I";
	}
	
	@Override
	public String visitFunctionDefinition(FunctionDefinitionContext ctx) {
		Map<String, Integer> oldVariables = variables;
		variables = new HashMap<>();
		String statementInstructions = visit(ctx.statements);
		String result = ".method public static " + ctx.funcName.getText() + "()I\n" +
				".limit locals 100\n" +
				".limit stack 100\n" +
				(statementInstructions == null ? "" : statementInstructions + "\n") +
				visit(ctx.returnValue) + "\n" +
				"ireturn\n" +
				".end method";
		variables = oldVariables;
		return result;
	}
	
	@Override
	public String visitProgram(ProgramContext ctx) {
		String mainCode = "";
		String functions = "";
		for(int i = 0; i < ctx.getChildCount(); ++i) {
			ParseTree child = ctx.getChild(i);
			String instructions = visit(child);
			if (child instanceof MainStatementContext) {
				mainCode += instructions + "\n";
			} else {
				functions += instructions + "\n";
			}
		}
		return functions + "\n" +
		".method public static main([Ljava/lang/String;)V\n" + 
		"  .limit stack 100\n" + 
		"  .limit locals 100\n" + 
		"  \n" + 
		 mainCode + "\n" + 
		"  return\n" + 
		"  \n" + 
		".end method";
	}
	
	private int requireVariableIndex(Token varNameToken) {
		Integer varIndex = variables.get(varNameToken.getText());
		if (varIndex == null) {
			throw new UndeclaredVariableException(varNameToken);
		}
		return varIndex;
	}
	
	@Override
	protected String aggregateResult(String aggregate, String nextResult) {
		if (aggregate == null) {
			return nextResult;
		}
		if (nextResult == null) {
			return aggregate;
		}
		return aggregate + "\n" + nextResult;
	}
}

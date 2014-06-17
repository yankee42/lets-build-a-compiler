package de.letsbuildacompiler.compiler;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;

import de.letsbuildacompiler.compiler.exceptions.UndeclaredVariableException;
import de.letsbuildacompiler.compiler.exceptions.UndefinedFunctionException;
import de.letsbuildacompiler.compiler.exceptions.VariableAlreadyDefinedException;
import de.letsbuildacompiler.parser.DemoBaseVisitor;
import de.letsbuildacompiler.parser.DemoParser.AndContext;
import de.letsbuildacompiler.parser.DemoParser.AssignmentContext;
import de.letsbuildacompiler.parser.DemoParser.BranchContext;
import de.letsbuildacompiler.parser.DemoParser.DivContext;
import de.letsbuildacompiler.parser.DemoParser.FunctionCallContext;
import de.letsbuildacompiler.parser.DemoParser.FunctionDefinitionContext;
import de.letsbuildacompiler.parser.DemoParser.MainStatementContext;
import de.letsbuildacompiler.parser.DemoParser.MinusContext;
import de.letsbuildacompiler.parser.DemoParser.MultContext;
import de.letsbuildacompiler.parser.DemoParser.NumberContext;
import de.letsbuildacompiler.parser.DemoParser.OrContext;
import de.letsbuildacompiler.parser.DemoParser.PlusContext;
import de.letsbuildacompiler.parser.DemoParser.PrintContext;
import de.letsbuildacompiler.parser.DemoParser.PrintlnContext;
import de.letsbuildacompiler.parser.DemoParser.ProgramContext;
import de.letsbuildacompiler.parser.DemoParser.RelationalContext;
import de.letsbuildacompiler.parser.DemoParser.StringContext;
import de.letsbuildacompiler.parser.DemoParser.VarDeclarationContext;
import de.letsbuildacompiler.parser.DemoParser.VariableContext;

public class MyVisitor extends DemoBaseVisitor<String> {
	
	private Map<String, Integer> variables = new HashMap<>();
	private JvmStack jvmStack = new JvmStack();
	private final FunctionList definedFunctions;
	private int branchCounter = 0;
	private int compareCount = 0;
	private int andCounter = 0;
	private int orCounter = 0;
	
	public MyVisitor(FunctionList definedFunctions) {
		if (definedFunctions == null) {
			throw new NullPointerException("definedFunctions");
		}
		this.definedFunctions = definedFunctions;
	}

	@Override
	public String visitPrintln(PrintlnContext ctx) {
		String argumentInstructions = visit(ctx.argument);
		DataType type = jvmStack.pop();
		return "  getstatic java/lang/System/out Ljava/io/PrintStream;\n" + 
				 argumentInstructions + "\n" + 
				"  invokevirtual java/io/PrintStream/println(" + type.getJvmType() + ")V\n";
	}
	
	@Override
	public String visitPrint(PrintContext ctx) {
		String argumentInstructions = visit(ctx.argument);
		DataType type = jvmStack.pop();
		return "  getstatic java/lang/System/out Ljava/io/PrintStream;\n" + 
				 argumentInstructions + "\n" + 
				"  invokevirtual java/io/PrintStream/print(" + type.getJvmType() + ")V\n";
	}
	
	@Override
	public String visitPlus(PlusContext ctx) {
		String instructions = visitChildren(ctx) + "\n" +
			"iadd";
		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);
		return instructions;
	}
	
	@Override
	public String visitMinus(MinusContext ctx) {
		String instructions = visitChildren(ctx) + "\n" +
				"isub";
		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);
		return instructions;
	}
	
	@Override
	public String visitDiv(DivContext ctx) {
		String instructions = visitChildren(ctx) + "\n" +
				"idiv";
		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);
		return instructions;
	}
	
	@Override
	public String visitMult(MultContext ctx) {
		String instructions = visitChildren(ctx) + "\n" +
				"imul";
		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);
		return instructions;
	}
	
	@Override
	public String visitRelational(RelationalContext ctx) {
		int compareNum = compareCount ;
		++compareCount;
		String jumpInstruction;
		switch(ctx.operator.getText()) {
		case "<":
			jumpInstruction = "if_icmplt";
			break;
		case "<=":
			jumpInstruction = "if_icmple";
			break;
		case ">":
			jumpInstruction = "if_icmpgt";
			break;
		case ">=":
			jumpInstruction = "if_icmpge";
			break;
		default:
			throw new IllegalArgumentException("Unknown operator: " + ctx.operator.getText());
		}
		String instructions = visitChildren(ctx) + "\n" + 
				jumpInstruction + " onTrue" + compareNum + "\n" + 
				"ldc 0\n" + 
				"goto onFalse" + compareNum + "\n" + 
				"onTrue" + compareNum + ":\n" + 
				"ldc 1\n" + 
				"onFalse" + compareNum + ":";
		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);
		return instructions;
	}
	
	@Override
	public String visitAnd(AndContext ctx) {
		String left = visit(ctx.left);
		String right = visit(ctx.right);
		int andNum = andCounter ;
		++andCounter;
		
		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);
		
		return left + "\n" + 
				"ifeq onAndFalse" + andNum + "\n" + 
				right + "\n" + 
				"ifeq onAndFalse" + andNum + "\n" + 
				"ldc 1\n" + 
				"goto andEnd" + andNum + "\n" + 
				"onAndFalse" + andNum + ":\n" + 
				"ldc 0\n" + 
				"andEnd" + andNum + ":";
	}
	
	@Override
	public String visitOr(OrContext ctx) {
		String left = visit(ctx.left);
		String right = visit(ctx.right);
		int orNum = orCounter ;
		++orCounter ;
		
		jvmStack.pop();
		jvmStack.pop();
		jvmStack.push(DataType.INT);
		
		return left + "\n" + 
				"ifne onOrTrue" + orNum + "\n" + 
				right + "\n" + 
				"ifne onOrTrue" + orNum + "\n" + 
				"ldc 0\n" + 
				"goto orEnd" + orNum + "\n" + 
				"onOrTrue" + orNum + ":\n" + 
				"ldc 1\n" + 
				"orEnd" + orNum + ":";
	}
	
	@Override
	public String visitNumber(NumberContext ctx) {
		jvmStack.push(DataType.INT);
		return "ldc " + ctx.number.getText();
	}
	
	@Override
	public String visitString(StringContext ctx) {
		jvmStack.push(DataType.STRING);
		return "ldc " + ctx.txt.getText();
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
	public String visitBranch(BranchContext ctx) {
		String conditionInstructions = visit(ctx.condition);
		jvmStack.pop();
		String onTrueInstructions = visit(ctx.onTrue);
		String onFalseInstructions = visit(ctx.onFalse);
		int branchNum = branchCounter ;
		++branchCounter;
		
		return conditionInstructions + "\n" +
			"ifne ifTrue" + branchNum + "\n" +
			onFalseInstructions + "\n" +
			"goto endIf" + branchNum + "\n" +
			"ifTrue" + branchNum + ":\n" +
			onTrueInstructions + "\n" +
			"endIf" + branchNum + ":\n";
	}
	
	@Override
	public String visitAssignment(AssignmentContext ctx) {
		String instructions = visit(ctx.expr) + "\n" +
				"istore " + requireVariableIndex(ctx.varName);
		jvmStack.pop();
		return instructions;
	}
	
	@Override
	public String visitVariable(VariableContext ctx) {
		jvmStack.push(DataType.INT);
		return "iload " + requireVariableIndex(ctx.varName);
	}
	
	@Override
	public String visitFunctionCall(FunctionCallContext ctx) {
		int numberOfParameters = ctx.arguments.expressions.size();
		if (!definedFunctions.contains(ctx.funcName.getText(), numberOfParameters)) {
			throw new UndefinedFunctionException(ctx.funcName);
		}
		String instructions = "";
		String argumentsInstructions = visit(ctx.arguments);
		if (argumentsInstructions != null) {
			instructions += argumentsInstructions + '\n';
		}
		instructions += "invokestatic HelloWorld/" + ctx.funcName.getText() + "(";
		instructions += stringRepeat("I", numberOfParameters);
		instructions += ")I";
		for(int i = 0; i < numberOfParameters; ++i) {
			jvmStack.pop();
		}
		jvmStack.push(DataType.INT);
		return instructions;
	}
	
	@Override
	public String visitFunctionDefinition(FunctionDefinitionContext ctx) {
		Map<String, Integer> oldVariables = variables;
		JvmStack oldJvmStack = jvmStack;
		variables = new HashMap<>();
		jvmStack = new JvmStack();
		visit(ctx.params);
		String statementInstructions = visit(ctx.statements);
		String result = ".method public static " + ctx.funcName.getText() + "(";
		int numberOfParameters = ctx.params.declarations.size();
		result += stringRepeat("I", numberOfParameters);
		result += ")I\n" +
				".limit locals 100\n" +
				".limit stack 100\n" +
				(statementInstructions == null ? "" : statementInstructions + "\n") +
				visit(ctx.returnValue) + "\n" +
				"ireturn\n" +
				".end method";
		jvmStack.pop();
		variables = oldVariables;
		jvmStack = oldJvmStack;
		return result;
	}
	
	private String stringRepeat(String string, int count) {
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < count; ++i) {
			result.append(string);
		}
		return result.toString();
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

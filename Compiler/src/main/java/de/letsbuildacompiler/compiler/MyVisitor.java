package de.letsbuildacompiler.compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import de.letsbuildacompiler.parser.DemoParser.CompositeContext;
import de.letsbuildacompiler.parser.DemoParser.DivContext;
import de.letsbuildacompiler.parser.DemoParser.DoubleContext;
import de.letsbuildacompiler.parser.DemoParser.ExpressionContext;
import de.letsbuildacompiler.parser.DemoParser.FloatContext;
import de.letsbuildacompiler.parser.DemoParser.FunctionCallContext;
import de.letsbuildacompiler.parser.DemoParser.FunctionDefinitionContext;
import de.letsbuildacompiler.parser.DemoParser.IntContext;
import de.letsbuildacompiler.parser.DemoParser.LongContext;
import de.letsbuildacompiler.parser.DemoParser.MainStatementContext;
import de.letsbuildacompiler.parser.DemoParser.MinusContext;
import de.letsbuildacompiler.parser.DemoParser.MultContext;
import de.letsbuildacompiler.parser.DemoParser.OrContext;
import de.letsbuildacompiler.parser.DemoParser.PlusContext;
import de.letsbuildacompiler.parser.DemoParser.PrintContext;
import de.letsbuildacompiler.parser.DemoParser.PrintlnContext;
import de.letsbuildacompiler.parser.DemoParser.ProgramContext;
import de.letsbuildacompiler.parser.DemoParser.RelationalContext;
import de.letsbuildacompiler.parser.DemoParser.StringContext;
import de.letsbuildacompiler.parser.DemoParser.TypeScalarContext;
import de.letsbuildacompiler.parser.DemoParser.VarDeclarationContext;
import de.letsbuildacompiler.parser.DemoParser.VariableContext;

public class MyVisitor extends DemoBaseVisitor<String> {

  private Map<String, Variable> variables = new HashMap<>();
  private int variableIndex = 0;
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
        argumentInstructions + '\n' +
        "  invokevirtual java/io/PrintStream/println(" + type.getJvmType() + ")V\n";
  }

  @Override
  public String visitPrint(PrintContext ctx) {
    String argumentInstructions = visit(ctx.argument);
    DataType type = jvmStack.pop();

    return "  getstatic java/lang/System/out Ljava/io/PrintStream;\n" +
        argumentInstructions + '\n' +
        "  invokevirtual java/io/PrintStream/print(" + type.getJvmType() + ")V\n";
  }

  @Override
  public String visitPlus(final PlusContext ctx) {
    String instructions = visitChildren(ctx) + '\n';
    DataType dataType = jvmStack.pop();
    jvmStack.pop();
    instructions += "  " + dataType.getLoad() + "add";
    jvmStack.push(dataType);

    return instructions;
  }

  @Override
  public String visitMinus(final MinusContext ctx) {
    String instructions = visitChildren(ctx) + '\n';
    DataType dataType = jvmStack.pop();
    jvmStack.pop();
    instructions += "  " + dataType.getLoad() + "sub";
    jvmStack.push(dataType);

    return instructions;
  }

  @Override
  public String visitDiv(final DivContext ctx) {
    String instructions = visitChildren(ctx) + '\n';
    DataType dataType = jvmStack.pop();
    jvmStack.pop();
    instructions += "  " + dataType.getLoad() + "div";
    jvmStack.push(dataType);

    return instructions;
  }

  @Override
  public String visitMult(final MultContext ctx) {
    String instructions = visitChildren(ctx) + '\n';
    DataType dataType = jvmStack.pop();
    jvmStack.pop();
    instructions += "  " + dataType.getLoad() + "mul";
    jvmStack.push(dataType);

    return instructions;
  }

  @Override
  public String visitRelational(final RelationalContext ctx) {
    int compareNum = compareCount++;
    String jumpInstruction;

    switch (ctx.operator.getText()) {
    case "<":
      jumpInstruction = "  if_icmplt";
      break;
    case "<=":
      jumpInstruction = "  if_icmple";
      break;
    case ">":
      jumpInstruction = "  if_icmpgt";
      break;
    case ">=":
      jumpInstruction = "  if_icmpge";
      break;
    default:
      throw new IllegalArgumentException("Unknown operator: " + ctx.operator.getText());
    }

    String instructions = visitChildren(ctx) + '\n' +
        jumpInstruction + " onTrue" + compareNum + '\n' +
        "  iconst_0\n" +
        "  goto onFalse" + compareNum + '\n' +
        "onTrue" + compareNum + ":\n" +
        "  iconst_1\n" +
        "onFalse" + compareNum + ':';
    jvmStack.pop();
    jvmStack.pop();
    jvmStack.push(DataType.INT);

    return instructions;
  }

  @Override
  public String visitAnd(final AndContext ctx) {
    String left = visit(ctx.left);
    jvmStack.pop();
    String right = visit(ctx.right);
    jvmStack.pop();
    int andNum = andCounter;
    ++andCounter;

    jvmStack.push(DataType.INT);
    String infix = ""; //"_icmp";

    return left + '\n' +
        "  if"+ infix + "eq onAndFalse" + andNum + '\n' +
        right + '\n' +
        "  if"+ infix + "eq onAndFalse" + andNum + '\n' +
        "  iconst_1\n" +
        "  goto andEnd" + andNum + '\n' +
        "onAndFalse" + andNum + ":\n" +
        "  iconst_0\n" +
        "andEnd" + andNum + ':';
  }

  @Override
  public String visitComposite(final CompositeContext ctx) {
    String instructions = visit(ctx.left);

    DataType dataType = jvmStack.pop();
    jvmStack.push(dataType);

    return instructions;
  }

  @Override
  public String visitOr(final OrContext ctx) {
    String left = visit(ctx.left);
    jvmStack.pop();
    String right = visit(ctx.right);
    jvmStack.pop();
    int orNum = orCounter++;

    String infix = ""; //"_icmp"; //DataType.INT == dataType ? "_icmp" : "";
    jvmStack.push(DataType.INT);

    return left + '\n' +
        "  if" + infix + "ne onOrTrue" + orNum + '\n' +
        right + '\n' +
        "  if" + infix + "ne onOrTrue" + orNum + '\n' +
        "  iconst_0\n" +
        "  goto orEnd" + orNum + '\n' +
        "onOrTrue" + orNum + ":\n" +
        "  iconst_1\n" +
        "orEnd" + orNum + ':';
  }

  @Override
  public String visitInt(final IntContext ctx) {
    String number = ctx.getText();
    jvmStack.push(DataType.INT);
    String instruction = "  ldc " + number;
    int i = Integer.parseInt(number);

    if (-1 == i) {
      instruction = "  iconst_m1";
    }
    else if (i >= 0 && i <= 5) {
      instruction = "  iconst_" + number;
    }
    else if (i >= Byte.MIN_VALUE && i <= Byte.MAX_VALUE) {
      instruction = "  bipush " + number;
    }
    else if (i >= Short.MIN_VALUE && i <= Short.MAX_VALUE) {
      instruction = "  sipush " + number;
    }
    else {
      instruction = "  ldc " + number;
    }

    return instruction;
  }

  @Override
  public String visitLong(final LongContext ctx) {
    return createNumericInstruction (ctx.getText(), DataType.LONG);
  }

  @Override
  public String visitFloat(final FloatContext ctx) {
    return createNumericInstruction (ctx.getText(), DataType.FLOAT);
  }


  @Override
  public String visitDouble(final DoubleContext ctx) {
    return createNumericInstruction (ctx.getText(), DataType.DOUBLE);
  }

  private String createNumericInstruction (final String number, final DataType dataType) {
    String instruction = null;
    int len = number.length();
    String n = number.substring(0, len - 1);

    if ("0".equals (n) || "1".equals (n)) {
      instruction = "  " + dataType.getLoad() + "const_" + n;
    }
    else {
      instruction = "  ldc" + (DataType.FLOAT == dataType ? " " : "2_w ") + n;
      if (DataType.LONG != dataType) {
        instruction += dataType.getLoad();
      }
    }

    jvmStack.push(dataType);

    return instruction;
  }

  @Override
  public String visitString(final StringContext ctx) {
    jvmStack.push(DataType.STRING);
    return "  ldc " + ctx.txt.getText();
  }

  @Override
  public String visitVarDeclaration(final VarDeclarationContext ctx) {
    String varName = ctx.varName.getText();

    if (variables.containsKey(varName)) {
      throw new VariableAlreadyDefinedException(ctx.varName);
    }

    addVariable(varName, ctx.typeScalar());

    return "";
  }

  private void addVariable(final String varName, final TypeScalarContext ctx) {
    String typeName = ctx.getText();
    DataType dataType = DataType.valueOf(typeName.toUpperCase());
    addVariable(varName, dataType);
  }

  private void addVariable(final String varName, final DataType dataType) {
    Variable variable = new Variable(varName, dataType, variableIndex);
    variables.put(varName, variable);
    variableIndex++;

    if (DataType.LONG == dataType || DataType.DOUBLE == dataType) {
      variableIndex++;
    }
  }

  private void removeVariable(final String varName) {
    variables.remove(varName);
  }

  @Override
  public String visitBranch(final BranchContext ctx) {
    String conditionInstructions = visit(ctx.condition);
    jvmStack.pop();
    String onTrueInstructions = visit(ctx.onTrue);
    String onFalseInstructions = visit(ctx.onFalse);

    int branchNum = branchCounter++;
    String infix = ""; //"_icmp";

    return conditionInstructions + '\n' +
        "  if" + infix + "ne ifTrue" + branchNum + '\n' +
        onFalseInstructions + '\n' +
        "  goto endIf" +
        branchNum + '\n' +
        "ifTrue" + branchNum + ":\n" +
        onTrueInstructions + '\n' +
        "endIf" + branchNum + ":\n";
  }

  @Override
  public String visitAssignment(final AssignmentContext ctx) {
    Variable variable = requireVariable(ctx.varName);
    int index = variable.getIndex();

    String instructions = visit(ctx.expr) + '\n' +
        "  " + variable.getType().getLoad() + "store" +((index >= 0 && index <= 3) ? '_' : ' ') + index;
    jvmStack.pop();

    return instructions;
  }

  @Override
  public String visitVariable(final VariableContext ctx) {
    Variable variable = requireVariable(ctx.varName);
    int index = variable.getIndex();
    jvmStack.push(variable.getType());

    return "  " + variable.getType().getLoad() + "load" +((index >= 0 && index <= 3) ? '_' : ' ') + index;
  }

  @Override
  public String visitFunctionCall(final FunctionCallContext ctx) {
    String argumentsInstructions = visit(ctx.arguments);
    List<ExpressionContext> arguments = ctx.arguments.expressions;
    FunctionDefinition func = definedFunctions.getFunctionDefinition(ctx.funcName.getText(), convert(arguments));

    if (null == func) {
      throw new UndefinedFunctionException(ctx.funcName);
    }

    String instructions = "";

    if (argumentsInstructions != null) {
      instructions += argumentsInstructions + '\n';
    }

    instructions += "  invokestatic HelloWorld/" + ctx.funcName.getText() + '(';
    for (DataType dataType : func.getParameters()) {
      instructions += dataType.getJvmType();
      //jvmStack.pop();
    }

    instructions += ')' + func.getReturnType().getJvmType();
    jvmStack.push(func.getReturnType());

    return instructions;
  }

  private List<DataType> convert(final List<ExpressionContext> expressions) {
    List<DataType> parameters = new ArrayList<>();

    for (int i = 0; i < expressions.size(); i++) {
      DataType dataType = jvmStack.pop();
      parameters.add(dataType);
    }

    return parameters;
  }

  @Override
  public String visitFunctionDefinition(final FunctionDefinitionContext ctx) {
    Map<String, Variable> oldVariables = variables;
    JvmStack oldJvmStack = jvmStack;

    variables = new HashMap<>();
    jvmStack = new JvmStack();

    String parameters = "";

    for (VarDeclarationContext varCtx : ctx.params.declarations) {
      DataType dataType = DataType.valueOf(varCtx.typeScalar().getText().toUpperCase());
      parameters += dataType.getJvmType();
    }

    visit(ctx.params);
    String statementInstructions = visit(ctx.statements);
    DataType returnType = DataType.valueOf(ctx.returnType.getText().toUpperCase());

    String result =
      ".method public static " + ctx.funcName.getText() + '(' + parameters + ')' + returnType.getJvmType() + '\n' +
      "  .limit locals 100\n" +
      "  .limit stack 100\n" +
      (statementInstructions == null ? "" : statementInstructions + '\n') +
      visit(ctx.returnValue) + '\n' +
      "  " + returnType.getLoad() + "return\n" +
      ".end method";

    jvmStack.pop();
    variables = oldVariables;
    jvmStack = oldJvmStack;

    return result;
  }

  @Override
  public String visitProgram(final ProgramContext ctx) {
    String mainCode = "";
    String functions = "";

    for (int i = 0; i < ctx.getChildCount(); ++i) {
      ParseTree child = ctx.getChild(i);
      String instructions = visit(child);

      if (child instanceof MainStatementContext) {
        mainCode += instructions + '\n';
      } else {
        functions += instructions + '\n';
      }
    }

    return functions + '\n' +
        ".method public static main([Ljava/lang/String;)V\n" +
        "  .limit stack 100\n" +
        "  .limit locals 100\n\n" +
        mainCode + '\n' +
        "  return\n" +
        ".end method";
  }

  private Variable requireVariable(final Token varNameToken) {
    Variable variable = variables.get(varNameToken.getText());

    if (variable == null) {
      throw new UndeclaredVariableException(varNameToken);
    }

    return variable;
  }

  @Override
  protected String aggregateResult(final String aggregate, final String nextResult) {
    if (aggregate == null) {
      return nextResult;
    }

    if (nextResult == null) {
      return aggregate;
    }

    return aggregate + '\n' + nextResult;
  }
}

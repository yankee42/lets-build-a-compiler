package de.letsbuildacompiler.compiler;

import java.util.List;

public final class FunctionDefinition {
  private final String functionName;
  private final DataType returnType;
  private final List<DataType> parameters;
  private final List<String> parameterNames;

  public FunctionDefinition(final String functionName, final DataType returnType, final List<DataType> parameters, final List<String> parameterNames) {
    this.functionName = functionName;
    this.returnType = returnType;
    this.parameters = parameters;
    this.parameterNames = parameterNames;
  }

  public String getFunctionName() {
    return functionName;
  }

  public DataType getReturnType() {
    return returnType;
  }

  public List<DataType> getParameters() {
    return parameters;
  }

  public List<String> getParameterNames() {
    return parameterNames;
  }
}

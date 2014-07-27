package de.letsbuildacompiler.compiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.letsbuildacompiler.parser.DemoParser.TypeScalarContext;
import de.letsbuildacompiler.parser.DemoParser.VarDeclarationContext;

public class FunctionList {
  private Collection<FunctionDefinition> definitions = new ArrayList<>();

  public void add(final String functionName, final TypeScalarContext typeScalar, final List<VarDeclarationContext> varDeclarations) {
    DataType returnType = convert(typeScalar);
    List<DataType> parameters = extractParameterDataTypes(varDeclarations);
    List<String> parameterNames = extractParameterNames(varDeclarations);
    definitions.add(new FunctionDefinition(functionName, returnType, parameters, parameterNames));
  }

  public boolean contains(final String functionName, final TypeScalarContext typeScalar, final List<VarDeclarationContext> varDeclarations) {
    DataType returnType = convert(typeScalar);
    List<DataType> parameters = extractParameterDataTypes(varDeclarations);

    for (FunctionDefinition definition : definitions) {
      if (definition.getFunctionName().equals(functionName) &&
          definition.getParameters().equals(parameters) &&
          definition.getReturnType() == returnType)
      {
        return true;
      }
    }

    return false;
  }

  public FunctionDefinition getFunctionDefinition (final String functionName, final List<DataType> parameters) {
    for (FunctionDefinition definition : definitions) {
      if (definition.getFunctionName().equals(functionName) &&
          definition.getParameters().equals(parameters))
      {
        return definition;
      }
    }

    return null;
  }

  private DataType convert(final TypeScalarContext typeScalar) {
    return DataType.valueOf(typeScalar.getText().toUpperCase());
  }

  private List<DataType> extractParameterDataTypes(final List<VarDeclarationContext> parameterDeclarations) {
    List<DataType> parameters = new ArrayList<>();

    for (VarDeclarationContext varCtx : parameterDeclarations) {
      parameters.add(DataType.valueOf(varCtx.type.getText().toUpperCase()));
    }

    return parameters;
  }

  private List<String> extractParameterNames(final List<VarDeclarationContext> parameterDeclarations) {
    List<String> names = new ArrayList<>();

    for (VarDeclarationContext varCtx : parameterDeclarations) {
      names.add(varCtx.varName.getText());
    }

    return names;
  }
}

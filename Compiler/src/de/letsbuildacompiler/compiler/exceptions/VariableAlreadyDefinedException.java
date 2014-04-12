package de.letsbuildacompiler.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class VariableAlreadyDefinedException extends CompileException {
	private String varName;
	
	public VariableAlreadyDefinedException(Token variableNameToken) {
		super(variableNameToken);
		varName = variableNameToken.getText();
	}
	
	@Override
	public String getMessage() {
		return line + ":" + column + " variable already defined: <" + varName + ">";
	}
}

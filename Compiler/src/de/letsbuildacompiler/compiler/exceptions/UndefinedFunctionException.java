package de.letsbuildacompiler.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class UndefinedFunctionException extends CompileException {
	private final String functionName;
	
	public UndefinedFunctionException(Token functionNameToken) {
		super(functionNameToken);
		this.functionName = functionNameToken.getText();
	}
	
	@Override
	public String getMessage() {
		return line + ":" + column + " call to undefined function: <" + functionName + ">";
	}
}

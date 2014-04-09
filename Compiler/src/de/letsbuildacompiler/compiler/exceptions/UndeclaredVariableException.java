package de.letsbuildacompiler.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class UndeclaredVariableException extends RuntimeException {
	private int line;
	private int column;
	private String varName;
	
	public UndeclaredVariableException(Token varNameToken) {
		line = varNameToken.getLine();
		column = varNameToken.getCharPositionInLine();
		varName = varNameToken.getText();
	}
	
	@Override
	public String getMessage() {
		return line + ":" + column + " undeclared variable <" + varName + ">";
	}
}

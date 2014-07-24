package de.letsbuildacompiler.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class UndeclaredVariableException extends CompileException {
	/**
   * serial version UID
   */
  private static final long serialVersionUID = 5134765767570595594L;

  private String varName;
	
	public UndeclaredVariableException(Token varNameToken) {
		super(varNameToken);
		varName = varNameToken.getText();
	}
	
	@Override
	public String getMessage() {
		return line + ":" + column + " undeclared variable <" + varName + ">";
	}
}

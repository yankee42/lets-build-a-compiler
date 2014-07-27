package de.letsbuildacompiler.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class VariableAlreadyDefinedException extends CompileException {
  /**
   * serial version UID
   */
  private static final long serialVersionUID = 966961943373656340L;

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

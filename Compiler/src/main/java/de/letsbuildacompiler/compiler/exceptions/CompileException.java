package de.letsbuildacompiler.compiler.exceptions;

import org.antlr.v4.runtime.Token;

public class CompileException extends RuntimeException {
  /**
   * serial version UID
   */
  private static final long serialVersionUID = 6828558632963558853L;

  protected int line;
	protected int column;
	
	public CompileException(Token token) {
		line = token.getLine();
		column = token.getCharPositionInLine();
	}
}

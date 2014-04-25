package de.letsbuildacompiler.compiler;

import java.util.ArrayList;
import java.util.Collection;

public class FunctionList {
	private Collection<FunctionDefinition> definitions = new ArrayList<>();
	public boolean contains(String functionName, int parameterCount) {
		for(FunctionDefinition definition : definitions) {
			if (definition.functionName.equals(functionName) && definition.parameterCount == parameterCount) {
				return true;
			}
		}
		return false;
	}
	
	public void add(String functionName, int parameterCount) {
		definitions.add(new FunctionDefinition(functionName, parameterCount));
	}
	
	private static class FunctionDefinition {
		private final String functionName;
		private final int parameterCount;
		
		private FunctionDefinition(String functionName, int parameterCount) {
			super();
			this.functionName = functionName;
			this.parameterCount = parameterCount;
		}
	}
}

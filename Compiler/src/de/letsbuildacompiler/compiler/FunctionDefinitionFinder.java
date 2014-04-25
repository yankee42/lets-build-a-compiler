package de.letsbuildacompiler.compiler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import de.letsbuildacompiler.parser.DemoBaseVisitor;
import de.letsbuildacompiler.parser.DemoParser.FunctionDefinitionContext;

public class FunctionDefinitionFinder extends DemoBaseVisitor<Set<String>> {
	@Override
	public Set<String> visitFunctionDefinition(FunctionDefinitionContext ctx) {
		String functionName = ctx.funcName.getText();
		return Collections.singleton(functionName);
	}
	
	@Override
	protected Set<String> aggregateResult(Set<String> aggregate,
			Set<String> nextResult) {
		if (aggregate == null) {
			return nextResult;
		}
		if (nextResult == null) {
			return aggregate;
		}
		Set<String> merged = new HashSet<>(aggregate);
		merged.addAll(nextResult);
		return merged;
	}
}

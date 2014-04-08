package de.letsbuildacompiler.compiler;

import de.letsbuildacompiler.parser.DemoBaseVisitor;
import de.letsbuildacompiler.parser.DemoParser.PlusContext;
import de.letsbuildacompiler.parser.DemoParser.ZahlContext;

public class MyVisitor extends DemoBaseVisitor<String> {
	
	@Override
	public String visitPlus(PlusContext ctx) {
		return visitChildren(ctx) + "\n" +
				ctx.rechts.getText() + "\n" +
				"iadd";
	}
	
	@Override
	public String visitZahl(ZahlContext ctx) {
		return "ldc " + ctx.zahl.getText();
	}
	
	@Override
	protected String aggregateResult(String aggregate, String nextResult) {
		if (aggregate == null) {
			return nextResult;
		}
		if (nextResult == null) {
			return aggregate;
		}
		return aggregate + "\n" + nextResult;
	}
}

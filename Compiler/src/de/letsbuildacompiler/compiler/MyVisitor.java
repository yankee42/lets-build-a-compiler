package de.letsbuildacompiler.compiler;

import de.letsbuildacompiler.parser.DemoBaseVisitor;
import de.letsbuildacompiler.parser.DemoParser.PlusContext;
import de.letsbuildacompiler.parser.DemoParser.ZahlContext;

public class MyVisitor extends DemoBaseVisitor<String> {
	
	@Override
	public String visitPlus(PlusContext ctx) {
		visitChildren(ctx);
		System.out.println(ctx.rechts.getText());
		System.out.println("addition");
		return null;
	}
	
	@Override
	public String visitZahl(ZahlContext ctx) {
		System.out.println(ctx.zahl.getText());
		return null;
	}
}

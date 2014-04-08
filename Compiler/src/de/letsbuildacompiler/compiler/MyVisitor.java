package de.letsbuildacompiler.compiler;

import de.letsbuildacompiler.parser.DemoBaseVisitor;
import de.letsbuildacompiler.parser.DemoParser.AdditionContext;

public class MyVisitor extends DemoBaseVisitor<String> {
	@Override
	public String visitAddition(AdditionContext ctx) {
		visitChildren(ctx);
		if (ctx.getChildCount() == 1) {
			System.out.println(ctx.getChild(0));
		} else {
			System.out.println(ctx.getChild(2));
			System.out.println("addition");
		}
		return null;
	}
}

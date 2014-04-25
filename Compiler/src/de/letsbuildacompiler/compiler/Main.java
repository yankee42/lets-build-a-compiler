package de.letsbuildacompiler.compiler;

import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import de.letsbuildacompiler.parser.DemoLexer;
import de.letsbuildacompiler.parser.DemoParser;

public class Main {

	public static void main(String[] args) throws Exception {
		ANTLRInputStream input = new ANTLRFileStream("code.demo");
		System.out.println(compile(input));
	}
	
	public static String compile(ANTLRInputStream input) {
		DemoLexer lexer = new DemoLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		DemoParser parser = new DemoParser(tokens);
		
		ParseTree tree = parser.program();
		Set<String> definedFunctions = new FunctionDefinitionFinder().visit(tree);
		return createJasminFile(new MyVisitor(definedFunctions).visit(tree));
	}
	
	private static String createJasminFile(String instructions) {
		return ".class public HelloWorld\n" + 
				".super java/lang/Object\n" + 
				"\n" + 
				instructions;
	}
}

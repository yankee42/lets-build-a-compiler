package de.letsbuildacompiler.compiler;

import jasmin.ClassFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import de.letsbuildacompiler.compiler.exceptions.FunctionAlreadyDefinedException;
import de.letsbuildacompiler.compiler.exceptions.UndeclaredVariableException;
import de.letsbuildacompiler.compiler.exceptions.UndefinedFunctionException;
import de.letsbuildacompiler.compiler.exceptions.VariableAlreadyDefinedException;

public class CompilerTest {
	private Path tempDir;
	
	@BeforeMethod
	public void createTempDir() throws IOException {
		tempDir = Files.createTempDirectory("compilerTest");
	}
	
	@AfterMethod
	public void deleteTempDir() {
		deleteRecursive(tempDir.toFile());
	}
	
	private void deleteRecursive(File file) {
		if (file.isDirectory()) {
			for(File child : file.listFiles()) {
				deleteRecursive(child);
			}
		}
		if (!file.delete()) {
			throw new Error("Could not delete file <" + file + ">");
		}
	}

	@Test(dataProvider = "provide_code_expectedText")
	public void runningCode_outputsExpectedText(
			String description,
			String code,
			String expectedText) throws Exception {
		// execution
		String actualOutput = compileAndRun(code);
		
		// evaluation
		Assert.assertEquals(actualOutput, expectedText);
	}
	
	@Test(expectedExceptions = UndeclaredVariableException.class,
			expectedExceptionsMessageRegExp = "1:8 undeclared variable <x>")
	public void compilingCode_throwsUndeclaredVariableException_ifReadingUndefinedVariable() throws Exception {
		// execution
		compileAndRun("println(x);");
		
		// evaluation performed by expected exception
	}
	
	@Test(expectedExceptions = UndeclaredVariableException.class,
			expectedExceptionsMessageRegExp = "1:0 undeclared variable <x>")
	public void compilingCode_throwsUndeclaredVariableException_ifWritingUndefinedVariable() throws Exception {
		// execution
		compileAndRun("x = 5;");
		
		// evaluation performed by expected exception
	}
	
	@Test(expectedExceptions = VariableAlreadyDefinedException.class,
			expectedExceptionsMessageRegExp = "2:4 variable already defined: <x>")
	public void compilingCode_throwsVariableAlreadyDefinedException_whenDefiningAlreadyDefinedVariable() throws Exception {
		// execution
		compileAndRun("int x;" + System.lineSeparator() +
		              "int x;");
		
		// evaluation performed by expected exception
	}
	
	@Test(expectedExceptions = UndefinedFunctionException.class,
			expectedExceptionsMessageRegExp = "1:8 call to undefined function: <someUndefinedFunction>")
	public void compilingCode_throwsUndefinedFunctionException_whenCallingUndefinedFunction() throws Exception {
		// execution
		compileAndRun("println(someUndefinedFunction());");
		
		// evaluation performed by expected exception
	}
	
	@Test(expectedExceptions = FunctionAlreadyDefinedException.class,
			expectedExceptionsMessageRegExp = "2:4 function already defined: <x>")
	public void compilingCode_throwsFunctionAlreadyDefinedException_whenDefiningFunctionTwice() throws Exception {
		// execution
		compileAndRun("int x() { return 42; }\n" +
					  "int x() { return 42; }");
		
		// evaluation performed by expected exception
	}
	
	@DataProvider
	public Object[][] provide_code_expectedText() throws Exception {
		return new Object[][]{
				{"plus",
					"println(1+2);", "3" + System.lineSeparator()},
					
				{"chained plus",
						"println(1+2+42);", "45" + System.lineSeparator()},
						
				{"multiple statements",
							"println(1); println(2);",
					"1" + System.lineSeparator() +
					"2" + System.lineSeparator()},
					
				{"minus",
						"println(3-2);", "1" + System.lineSeparator()},
						
				{"times",
						"println(2*3);", "6" + System.lineSeparator()},
							
				{"divide",
						"println(6/2);", "3" + System.lineSeparator()},
						
				{"divide and truncate",
						"println(7/2);", "3" + System.lineSeparator()},
						
				{"precedence times and divide",
						"println(8/2*4);", "16" + System.lineSeparator()},
				
				{"precedence plus and times",
						"println(2+3*3);", "11" + System.lineSeparator()},
						
				{"precedence minus and times",
						"println(9-2*3);", "3" + System.lineSeparator()},
						
				{"precedence minus and plus",
						"println(8-2+5);", "11" + System.lineSeparator()},
				
				{"int variable",
						"int foo; foo = 42; println(foo);", "42" + System.lineSeparator()},
						
				{"add var and constant parameter",
						"int foo; foo = 42; println(foo+2);", "44" + System.lineSeparator()},
							
				{"add two vars parameter",
						"int a; int b; a = 2; b = 5; println(a+b);", "7" + System.lineSeparator()},
				
				{"return only function",
						"int randomNumber() { return 4; } println(randomNumber());", "4" + System.lineSeparator()},
				
				example("function/simple_function", "4" + System.lineSeparator()),
						
				example("function/scopes",
							"4" + System.lineSeparator() +
							"42" + System.lineSeparator()),
							
				example("function/int_parameters",
						"13" + System.lineSeparator()),
				
				example("function/overloading",
						"0" + System.lineSeparator() +
						"42" + System.lineSeparator()),
				
				example("branch/if_int_false", "42" + System.lineSeparator()),
				example("branch/if_int_true", "81" + System.lineSeparator()),
				
				{"lower than true", "println(1 < 2);", "1" + System.lineSeparator()},
				{"lower than false", "println(2 < 2);", "0" + System.lineSeparator()},
				
				{"lower than or equal true", "println(2 <= 2);", "1" + System.lineSeparator()},
				{"lower than or equal false", "println(3 <= 2);", "0" + System.lineSeparator()},
				
				{"greater than true", "println(3 > 2);", "1" + System.lineSeparator()},
				{"greater than false", "println(2 > 2);", "0" + System.lineSeparator()},
				
				{"greater than or equal true", "println(2 >= 2);", "1" + System.lineSeparator()},
				{"greater than or equal false", "println(1 >= 2);", "0" + System.lineSeparator()},
				
				{"and true", "println(1 && 1);", "1" + System.lineSeparator()},
				{"and left false", "println(0 && 1);", "0" + System.lineSeparator()},
				{"and right false", "println(1 && 0);", "0" + System.lineSeparator()},
				example("operators/and-skip-right", "0" + System.lineSeparator() +  "0" + System.lineSeparator()),
				
				{"or false", "println(0 || 0);", "0" + System.lineSeparator()},
				{"or left true", "println(1 || 0);", "1" + System.lineSeparator()},
				{"or right true", "println(0 || 1);", "1" + System.lineSeparator()},
				example("operators/or-skip-right", "1" + System.lineSeparator() +  "1" + System.lineSeparator()),
				
				{"print", "print(42);", "42"},
				
				{"print string literal", "print(\"hello world\");", "hello world"},
		};
	}
	
	private static String[] example(String name, String expectedResult) throws Exception {
		try(InputStream in = CompilerTest.class.getResourceAsStream("/examples/" + name + ".txt")) {
			if (in == null) {
				throw new IllegalArgumentException("No such example <" + name + ">");
			}
			String code = new Scanner(in, "UTF-8").useDelimiter("\\A").next();
			return new String[]{name, code, expectedResult};
		}
	}

	private String compileAndRun(String code) throws Exception {
		code = Main.compile(new ANTLRInputStream(code));
		ClassFile classFile = new ClassFile();
		classFile.readJasmin(new StringReader(code), "", false);
		Path outputPath = tempDir.resolve(classFile.getClassName() + ".class");
		try(OutputStream output = Files.newOutputStream(outputPath)) {
			classFile.write(output);
		}
		return runJavaClass(tempDir, classFile.getClassName());
	}

	private String runJavaClass(Path dir, String className) throws Exception {
		Process process = Runtime.getRuntime().exec(new String[]{"java", "-cp", dir.toString(), className});
		try(InputStream in = process.getInputStream()) {
			return new Scanner(in).useDelimiter("\\A").next();
		}
	}
}

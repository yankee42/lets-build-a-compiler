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
      for (File child : file.listFiles()) {
        deleteRecursive(child);
      }
    }

    if (!file.delete()) {
      throw new Error("Could not delete file <" + file + '>');
    }
  }

  @Test(dataProvider = "provide_code_expectedText")
  public void runningCode_outputsExpectedText(String description, String code,
      String expectedText) throws Exception {
    // execution
    String actualOutput = compileAndRun(code);

    // evaluation
    Assert.assertEquals(actualOutput, expectedText);
  }

  @Test(expectedExceptions = UndeclaredVariableException.class, expectedExceptionsMessageRegExp = "1:7 undeclared variable <x>")
  public void compilingCode_throwsUndeclaredVariableException_ifReadingUndefinedVariable()
      throws Exception {
    // execution
    compileAndRun("print (x);");

    // evaluation performed by expected exception
  }

  @Test(expectedExceptions = UndeclaredVariableException.class, expectedExceptionsMessageRegExp = "1:0 undeclared variable <x>")
  public void compilingCode_throwsUndeclaredVariableException_ifWritingUndefinedVariable()
      throws Exception {
    // execution
    compileAndRun("x = 5;");

    // evaluation performed by expected exception
  }

  @Test(expectedExceptions = VariableAlreadyDefinedException.class, expectedExceptionsMessageRegExp = "2:4 variable already defined: <x>")
  public void compilingCode_throwsVariableAlreadyDefinedException_whenDefiningAlreadyDefinedVariable()
      throws Exception {
    // execution
    compileAndRun("int x;" + System.lineSeparator() + "int x;");

    // evaluation performed by expected exception
  }

  @Test(expectedExceptions = UndefinedFunctionException.class, expectedExceptionsMessageRegExp = "1:7 call to undefined function: <someUndefinedFunction>")
  public void compilingCode_throwsUndefinedFunctionException_whenCallingUndefinedFunction()
      throws Exception {
    // execution
    compileAndRun("print (someUndefinedFunction ());");

    // evaluation performed by expected exception
  }

  @Test(expectedExceptions = FunctionAlreadyDefinedException.class, expectedExceptionsMessageRegExp = "2:4 function already defined: <x>")
  public void compilingCode_throwsFunctionAlreadyDefinedException_whenDefiningFunctionTwice()
      throws Exception {
    // execution
    compileAndRun("int x () { return 42; }" + System.lineSeparator()
        + "int x () { return 42; }");

    // evaluation performed by expected exception
  }

  @DataProvider
  public Object[][] provide_code_expectedText() throws Exception {
    return new Object[][] {
        { "plus", "print (1 + 2);", "3" },
        { "chained plus", "print (1 + 2 + 42);", "45" },
        { "multiple statements", "print (1); print (2);", "12" },
        { "minus", "print (3 - 2);", "1" },
        { "times", "print (2 * 3);", "6" },
        { "divide", "print (6 / 2);", "3" },
        { "divide and truncate", "print (7 / 2);", "3" },
        { "precedence times and divide", "print (8 / 2 * 4);", "16" },
        { "precedence plus and times", "print (2 + 3 * 3);", "11" },
        { "precedence minus and times", "print (9 - 2 * 3);", "3" },
        { "precedence minus and plus", "print (8 - 2 + 5);", "11" },
        { "int variable", "int foo; foo = 42; print (foo);", "42" },
        { "add var and constant parameter",
            "int foo; foo = 42; print (foo + 2);", "44" },
        { "add two vars parameter",
            "int a; int b; a = 2; b = 5; print (a + b);", "7" },
        { "return only function",
            "int randomNumber () { return 4; } print (randomNumber ());", "4" },
        example("function/simple_function", "4"),
        example("function/scopes", "4" + "42"),
        example("function/int_parameters", "13"),
        example("function/overloading", "0" + "42"),
        example("branch/if_int_false", "42"),
        example("branch/if_int_true", "81"),
        { "lower than true", "print (1 < 2);", "1" },
        { "lower than false", "print (2 < 2);", "0" },
        { "lower than or equal true", "print (2 <= 2);", "1" },
        { "lower than or equal false", "print (3 <= 2);", "0" },
        { "greater than true", "print (3 > 2);", "1" },
        { "greater than false", "print (2 > 2);", "0" },
        { "greater than or equal true", "print (2 >= 2);", "1" },
        { "greater than or equal false", "print (1 >= 2);", "0" },
        { "and true", "print (1 && 1);", "1" },
        { "and left false", "print (0 && 1);", "0" },
        { "and right false", "print (1 && 0);", "0" },
        { "or false", "print (0 || 0);", "0" },
        { "or left true", "print (1 || 0);", "1" },
        { "or right true", "print (0 || 1);", "1" },
        example("operators/and-skip-right", "0" + "0"),
        example("operators/or-skip-right", "1" + "1"),
        { "print", "print (42);", "42" },
        { "print string literal", "print (\"hello world\");", "hello world" },
        example("expression/composite", "72"),
        example("expression/comment", "7"),

        example("datatype/int_operations", "-9112"),
        example("datatype/long_statement", "1234567890123456789"),
        example("datatype/long_operations", "2"),
        example("datatype/float_statement", "10.25"),
        example("datatype/float_operations", "-11.0"),
        example("datatype/double_statement", "100.75"),
        example("datatype/double_operations", "-4.0"),
    };
  }

  private static String[] example(final String name, final String expectedResult)
      throws Exception {
    try (InputStream in = CompilerTest.class.getResourceAsStream("/examples/" + name + ".txt")) {
      if (in == null) {
        throw new IllegalArgumentException("No such example <" + name + '>');
      }

      String code = "";

      try (Scanner scanner = new Scanner(in, "UTF-8")) {
        code = scanner.useDelimiter("\\A").next();
      }

      return new String[] { name, code, expectedResult };
    }
  }

  private String compileAndRun(final String code) throws Exception {
    String jasminCode = Main.compile(new ANTLRInputStream(code));
    //System.out.println(jasminCode);
    ClassFile classFile = new ClassFile();
    classFile.readJasmin(new StringReader(jasminCode), "", false);
    Path outputPath = tempDir.resolve(classFile.getClassName() + ".class");

    try (OutputStream output = Files.newOutputStream(outputPath)) {
      classFile.write(output);
    }

    return runJavaClass(tempDir, classFile.getClassName());
  }

  private String runJavaClass(Path dir, String className) throws Exception {
    Process process = Runtime.getRuntime().exec(
        new String[] { "java", "-cp", dir.toString(), className });
    try (InputStream in = process.getInputStream()) {
      return new Scanner(in).useDelimiter("\\A").next();
    }
  }
}

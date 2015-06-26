//UIUC CS125 FALL 2012 MP. File: AutomaticGrader.java, CS125 Project: Challenge5-DataStructures, Version: 2012-10-12T13:24:10-0500.281837000
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import junit.framework.TestResult;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * This program runs all of unit tests and generates a score. A similar program
 * will be used to grade you work after the deadline. You do not need to modify
 * this file.
 * 
 * @author angrave
 * 
 */
public class AutomaticGrader {

	public static void main(String[] args) throws Exception {
		checkForCompileErrors();

		TestRunner runner = new TestRunner();
		TestSuite suite = new TestSuite();
		suite.addTestSuite(KeyValueMapTest.class);
		suite.addTestSuite(QueueTest.class);
		suite.addTestSuite(CallAStaticMethodTest.class);
		suite.addTestSuite(StaticMethodsAreEasyTest.class);
		suite.addTestSuite(UsingPublicFieldsIsEasyTest.class);
		suite.addTestSuite(GeocacheTest.class);
		suite.addTestSuite(StackTest.class);
		suite.addTestSuite(GeocacheListTest.class);

		TestResult result = runner.doRun(suite, false);

		int passed = result.runCount() - result.errorCount()
				- result.failureCount();
		int total = result.runCount();
		int max = 100;
		try {
			if (args.length > 0)
				max = Integer.parseInt(args[0]);
		} catch (Exception ignored) {

		}
		int score = (int) ((max * passed) / total);

		System.out.println(passed + " passed out of " + total);
		System.out.println("Score=" + score);
		System.exit(score);

	}

	public static void checkPublicPrivateModifiers(Class<?> claz) {
		checkAllFieldsArePrivate(claz);
		checkAllMethodsAndConstructorsArePublic(claz);
	}

	public static void checkAllFieldsArePrivate(Class<?> claz) {

		Field[] allFields = claz.getDeclaredFields();
		Field[] publicFields = claz.getFields();
		if (0 != publicFields.length)
			throw new RuntimeException(claz.getName() + " has public fields");
		for (int i = 0; i < allFields.length; i++) {
			if (0 == (allFields[i].getModifiers() & Modifier.PRIVATE))
				throw new RuntimeException(allFields[i].getName()
						+ " should be private");

		}
	}

	public static void checkAllMethodsAndConstructorsArePublic(Class<?> claz) {
		Method[] allMethods = claz.getDeclaredMethods();
		for (int i = 0; i < allMethods.length; i++) {
			if (0 == (allMethods[i].getModifiers() & Modifier.PUBLIC))
				throw new RuntimeException(allMethods[i].getName()
						+ " should be public");
		}
		Constructor<?>[] allConstructors = claz.getConstructors();
		for (int i = 0; i < allConstructors.length; i++) {
			if (0 == (allConstructors[i].getModifiers() & Modifier.PUBLIC))
				throw new RuntimeException(allConstructors[i].getName()
						+ " constructor should be public");
		}
	}
	public static void checkForCompileErrors() {
		File[] files = new File(".").listFiles();
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if (file.getName().endsWith(".class")
					|| file.getName().endsWith(".java"))
				checkFileForCompileError(file);
		}
	}

	private static void checkFileForCompileError(File file) {
		boolean isClass = file.getName().endsWith(".class");
		if ("|CheckInputOutput|AutomaticGrader|TextIO|".contains("|"
				+ file.getName().replace(".java", "").replace(".class", "")
				+ "|"))
			return;
		try {
			byte[] buffer = new byte[(int) file.length()];
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(file));
			bis.read(buffer);
			String sourceCode;
			if (isClass)
				sourceCode = new String(buffer);
			else
				sourceCode = new String(buffer, "UTF8");
			// TextIO.putln(sourceCode);
			if (sourceCode.contains("Unresolved compilation problem")) {
				System.out
						.println("Fix Compilation Errors in "
								+ file.getName()
								+ " - see the Package explorer or Problems view for details.");
				System.exit(1);
			}

			if (sourceCode.contains("System.exit")) {
				System.out.println("Don't use System.exit (file: "
						+ file.getName() + ")- see README instructions");
				System.exit(1);
			}
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

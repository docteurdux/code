package dux.com.github.javaparser;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class JavaParserTest extends AbstractTest {
	@Test
	public void test() {
		CompilationUnit compilationUnit = JavaParser
				.parse("class A { /** This is foo */ public String foo() { return \"foo\";} /** This is bar */ public String bar(){return \"bar\";}}");

		ClassOrInterfaceDeclaration classA = compilationUnit.getClassByName("A").get();

		List<MethodDeclaration> ns = new ArrayList<>();

		new VoidVisitorAdapter() {
			public void visit(MethodDeclaration n, Object arg) {
				if (!"bar".equals(n.getName().asString())) {
					System.out.println("Removing " + n.getName());
					ns.add(n);
				}
			};
		}.visit(classA, null);

		System.out.println(ns.size());
		for (MethodDeclaration n : ns) {
			n.remove();
		}

		System.out.println(compilationUnit.toString());

	}
}

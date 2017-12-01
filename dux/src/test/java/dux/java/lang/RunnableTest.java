package dux.java.lang;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.vladsch.flexmark.ext.jekyll.tag.JekyllTagExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;

/*-
# java.lang.Runnable

The java.lang.Runnable interface is a very simple interface that only defines a void run() method.
It is great for defining code that will be run later.

{% include test %}

Output of which is:

{% include output %}

 */
public class RunnableTest extends AbstractTest {

	public void test() {
		Runnable myRunnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("Hello from myRunnable");
			}
		};
		myRunnable.run();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testJavaParser() throws Exception {

		// Generate output
		PrintStream sysout = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		test();
		System.setOut(sysout);

		// Convert output to markdown
		String output = new String(baos.toByteArray());
		output = "\n```\n" + output + "```\n";

		// Compute file location
		String userDir = System.getProperty("user.dir");
		Class<? extends RunnableTest> clazz = this.getClass();
		String className = clazz.getName();
		className = className.replaceAll("\\.", "\\\\");
		String fileLocation = userDir + "\\src\\test\\java\\" + className + ".java";

		// Get file content
		String content = FileUtils.readFileToString(new File(fileLocation), "UTF-8");

		CompilationUnit compilationUnit = JavaParser.parse(content);
		ClassOrInterfaceDeclaration classA = compilationUnit.getClassByName(clazz.getSimpleName()).get();
		MethodDeclaration[] ns = new MethodDeclaration[] { null };
		new VoidVisitorAdapter() {
			public void visit(MethodDeclaration n, Object arg) {
				if ("test".equals(n.getName().asString())) {
					ns[0] = n;
				}
			};
		}.visit(classA, null);
		String javaCode = ns[0].toString();
		String javaCodeMarkdown = "\n```java\n" + javaCode + "\n```\n";

		String classComment = classA.getComment().get().getContent();
		if (classComment.startsWith("-\r\n")) {
			classComment = classComment.substring(3);
		} else {
			classComment.startsWith("-\n");
			classComment = classComment.substring(2);
		}

		MutableDataSet subOptions = new MutableDataSet();
		Parser subParser = Parser.builder(subOptions).build();
		HtmlRenderer subRenderer = HtmlRenderer.builder(subOptions).build();

		Map<String, String> map = new HashMap<>();
		map.put("test", subRenderer.render(subParser.parse(javaCodeMarkdown)));
		map.put("output", subRenderer.render(subParser.parse(output)));

		MutableDataSet mainOptions = new MutableDataSet()
				.set(Parser.EXTENSIONS, Arrays.asList(JekyllTagExtension.create()))
				.set(JekyllTagExtension.INCLUDED_HTML, map).set(JekyllTagExtension.ENABLE_BLOCK_TAGS, true);

		Parser mainParser = Parser.builder(mainOptions).build();
		HtmlRenderer mainRenderer = HtmlRenderer.builder(mainOptions).build();

		String html = mainRenderer.render(mainParser.parse(classComment));
		System.out.println(html);

	}

}

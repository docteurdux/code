package com.github.docteurdux.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.vladsch.flexmark.ext.jekyll.tag.JekyllTagExtension;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;

public class HTMLRenderer {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void renderToHTML(Class<?> clazz, Method testMethod, Object instance) throws Exception {

		// Generate output
		PrintStream sysout = System.out;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(baos));
		testMethod.invoke(instance);
		System.setOut(sysout);

		// Convert output to markdown
		String output = new String(baos.toByteArray());
		output = "\n```shell\n" + output + "```\n";

		// Compute file location
		String userDir = System.getProperty("user.dir");
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

		String before = "<html><head><link rel=\"stylesheet\" href=\"http://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/styles/obsidian.min.css\"><script src=\"http://cdnjs.cloudflare.com/ajax/libs/highlight.js/9.12.0/highlight.min.js\"></script><style>html {font-size:62.5%;} h1 {font-size:3.7rem; font-weight:700; color:#444; clear:both; line-height:1.2; margin:50px 0 20px} body { font-size:1.8rem;} p { line-height:1.7; margin-bottom:1.1em; }</style></head><body>";
		String after = "<script>hljs.initHighlightingOnLoad();</script></body></html>";

		FileOutputStream fos = new FileOutputStream("C:\\output\\output.html");
		fos.write(before.getBytes());
		fos.write(html.getBytes());
		fos.write(after.getBytes());
		fos.close();

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void renderToHTML2(Class<?> clazz) throws Exception {

		// Compute file location
		String userDir = System.getProperty("user.dir");
		String className = clazz.getName();
		className = className.replaceAll("\\.", "\\\\");
		String fileLocation = userDir + "\\src\\test\\java\\" + className + ".java";

		// Get file content
		String content = FileUtils.readFileToString(new File(fileLocation), "UTF-8");

		JavaParser.getStaticConfiguration().setLexicalPreservationEnabled(true);
		JavaParser.getStaticConfiguration().setDoNotAssignCommentsPrecedingEmptyLines(true);
		CompilationUnit compilationUnit = JavaParser.parse(content);

		new VVA().visit(compilationUnit, null);

	}

}

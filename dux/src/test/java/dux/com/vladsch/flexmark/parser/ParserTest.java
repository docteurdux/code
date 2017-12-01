package dux.com.vladsch.flexmark.parser;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.vladsch.flexmark.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.options.MutableDataSet;

public class ParserTest extends AbstractTest {
	@Test
	public void test() {
		MutableDataSet options = new MutableDataSet();

		Parser parser = Parser.builder(options).build();
		HtmlRenderer renderer = HtmlRenderer.builder(options).build();

		Node document = parser.parse("This is *Sparta*");
		String html = renderer.render(document);
		System.out.println(html);
	}
}

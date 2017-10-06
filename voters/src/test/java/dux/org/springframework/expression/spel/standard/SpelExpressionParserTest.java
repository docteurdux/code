package dux.org.springframework.expression.spel.standard;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ParserContext;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import dum.org.springframework.expression.DummyParserContext;

public class SpelExpressionParserTest {
	@Test
	public void test() {
		SpelParserConfiguration configuration = new SpelParserConfiguration();
		SpelExpressionParser parser = new SpelExpressionParser(configuration);
		String expressionString = "#{4}";
		TemplateParserContext templateParserContext = new TemplateParserContext();
		ParserContext parserContext = new DummyParserContext();
		Expression exp = parser.parseExpression(expressionString, parserContext);
		System.out.println(exp.getClass().getName());
	}
}

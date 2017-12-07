package dux.org.springframework.expression.spel.standard;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(SpelExpressionParser.class)
public class SpelExpressionParserTest extends AbstractTest {
	@Test
	public void test() {
		SpelParserConfiguration configuration = new SpelParserConfiguration(SpelCompilerMode.IMMEDIATE, null);
		SpelExpressionParser parser = new SpelExpressionParser(configuration);
		Expression ex = parser.parseExpression("true&&false");
		aeq(false, ex.getValue());
		aeq(false, ex.getValue());
	}
}

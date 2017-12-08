package dux.org.springframework.expression.spel.ast;

import org.junit.Test;
import org.springframework.expression.spel.ast.StringLiteral;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(StringLiteral.class)
public class StringLiteralTest extends AbstractTest {
	@Test
	public void test() {
		StringLiteral l = new StringLiteral("payload", 1, "\"va''lu\"\"e\"");
		aeq("va'lu\"e", l.getLiteralValue().getValue());
		aeq("'va'lu\"e'", l.toString());
		aeq(true, l.isCompilable());

	}
}

package dux.org.hibernate.criterion;

import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.mysql.cj.api.xdevapi.Expression;

@Done
public class ExpressionTest extends AbstractTest {

	private String expressionString1;
	private String expressionString2;

	@Before
	public void before() {
		expressionString1 = "expressionString1";
		expressionString2 = "expressionString1";
	}

	@Test
	public void test() {

		Expression expression1 = new Expression(expressionString1);
		aeq(expressionString1, expression1.getExpressionString());

		Expression expression2 = Expression.expr(expressionString2);
		aeq(expressionString2, expression2.getExpressionString());
	}
}

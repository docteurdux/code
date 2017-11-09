package dux.org.hibernate.criterion;

import org.hibernate.criterion.AbstractEmptinessExpression;
import org.hibernate.criterion.NotEmptyExpression;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.criterion.DummyNotEmptyExpression;

@Done
public class NotEmptyExpressionTest extends AbstractTest {
	@Test
	public void test() {
		aeq(AbstractEmptinessExpression.class, NotEmptyExpression.class.getSuperclass());

		DummyNotEmptyExpression expr = new DummyNotEmptyExpression("propertyName");

		at(expr.excludeEmpty());

		aeq("propertyName", getField(expr, "propertyName", AbstractEmptinessExpression.class));
	}
}

package dux.org.hibernate.criterion;

import java.lang.reflect.Field;

import org.hibernate.criterion.AbstractEmptinessExpression;
import org.hibernate.criterion.EmptyExpression;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.criterion.DummyEmptyExpression;

@Done
public class EmptyExpressionTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		aeq(AbstractEmptinessExpression.class, EmptyExpression.class.getSuperclass());

		DummyEmptyExpression expr = new DummyEmptyExpression("propertyName");
		af(expr.excludeEmpty());

		Field field = AbstractEmptinessExpression.class.getDeclaredField("propertyName");
		field.setAccessible(true);
		aeq("propertyName", field.get(expr));

	}
}

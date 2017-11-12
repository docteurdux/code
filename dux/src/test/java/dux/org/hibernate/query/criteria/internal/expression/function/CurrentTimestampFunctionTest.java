package dux.org.hibernate.query.criteria.internal.expression.function;

import java.sql.Timestamp;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.expression.function.BasicFunctionExpression;
import org.hibernate.query.criteria.internal.expression.function.CurrentTimestampFunction;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import duu.org.hibernate.query.criteria.internal.CriteriaBuilderImplUtils;

@Done
public class CurrentTimestampFunctionTest extends AbstractTest {

	private CriteriaBuilderImpl criteriaBuilderImpl;

	@Before
	public void before() {
		criteriaBuilderImpl = CriteriaBuilderImplUtils.getAnInstance();
	}

	@Test
	public void test() {

		aeq(BasicFunctionExpression.class, CurrentTimestampFunction.class.getSuperclass());

		CurrentTimestampFunction currentTimestampFunction = new CurrentTimestampFunction(criteriaBuilderImpl);

		aeq("current_timestamp", CurrentTimestampFunction.NAME);

		BasicFunctionExpression<?> basicFunctionExpression = currentTimestampFunction;

		aeq(Timestamp.class, basicFunctionExpression.getJavaType());
		aeqr(criteriaBuilderImpl, basicFunctionExpression.criteriaBuilder());
		aeq("current_timestamp", basicFunctionExpression.getFunctionName());
	}

}

package dux.org.hibernate.query.criteria.internal.expression.function;

import java.sql.Time;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.expression.function.BasicFunctionExpression;
import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import duu.org.hibernate.query.criteria.internal.CriteriaBuilderImplUtils;

@Done
public class CurrentTimeFunctionTest extends AbstractTest {

	private CriteriaBuilderImpl criteriaBuilderImpl;

	@Before
	public void before() {
		criteriaBuilderImpl = CriteriaBuilderImplUtils.getAnInstance();
	}

	@Test
	public void test() {

		aeq(BasicFunctionExpression.class, CurrentTimeFunction.class.getSuperclass());

		aeq("current_time", CurrentTimeFunction.NAME);

		CurrentTimeFunction ctf = new CurrentTimeFunction(criteriaBuilderImpl);
		aeq("current_time", ctf.getFunctionName());
		aeq(Time.class, ctf.getJavaType());
		aeqr(criteriaBuilderImpl, ctf.criteriaBuilder());

	}
}

package dux.org.hibernate.query.criteria.internal.expression.function;

import javax.persistence.criteria.Expression;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.expression.function.LowerFunction;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.persistence.criteria.DummyExpression;
import duu.org.hibernate.query.criteria.internal.CriteriaBuilderImplUtils;

@Done
public class LowerFunctionTest extends AbstractTest {

	private CriteriaBuilderImpl criteriaBuilderImpl;
	private Expression<String> expression;

	@Before
	public void before() {
		criteriaBuilderImpl = CriteriaBuilderImplUtils.getAnInstance();
		expression = new DummyExpression<String>();
	}

	@Test
	public void test() {

		aeq("lower", LowerFunction.NAME);

		LowerFunction lowerFunction = new LowerFunction(criteriaBuilderImpl, expression);
		aeq(LowerFunction.NAME, lowerFunction.getFunctionName());
		aeq(String.class, lowerFunction.getJavaType());
		aeqr(criteriaBuilderImpl, lowerFunction.criteriaBuilder());

		aeq(true, invoke(lowerFunction, "isStandardJpaFunction"));
	}
}

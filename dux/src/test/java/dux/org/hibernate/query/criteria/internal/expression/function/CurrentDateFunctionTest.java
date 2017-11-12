package dux.org.hibernate.query.criteria.internal.expression.function;

import java.sql.Date;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.expression.function.BasicFunctionExpression;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import duu.org.hibernate.query.criteria.internal.CriteriaBuilderImplUtils;

@Done
public class CurrentDateFunctionTest extends AbstractTest {
	private CriteriaBuilderImpl criteriaBuilder;

	@Before
	public void before() {
		criteriaBuilder = CriteriaBuilderImplUtils.getAnInstance();
	}

	@Test
	public void test() {

		aeq(BasicFunctionExpression.class, CurrentDateFunction.class.getSuperclass());

		aeq("current_date", CurrentDateFunction.NAME);

		CurrentDateFunction cdf = new CurrentDateFunction(criteriaBuilder);
		aeq("current_date", cdf.getFunctionName());
		aeq(Date.class, cdf.getJavaType());
		aeqr(criteriaBuilder, cdf.criteriaBuilder());

	}
}

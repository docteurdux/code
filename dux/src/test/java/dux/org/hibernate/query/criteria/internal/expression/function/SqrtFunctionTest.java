package dux.org.hibernate.query.criteria.internal.expression.function;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.expression.function.SqrtFunction;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.DUXFactories;
import com.github.docteurdux.test.Done;

import dum.javax.persistence.criteria.DummyExpression;

@Done
public class SqrtFunctionTest extends AbstractTest {

	private Map<DUXFactories, Object> io;
	private CriteriaBuilderImpl criteriaBuilderImpl;
	private DummyExpression<? extends Number> expression;

	@Before
	public void before() {
		io = new HashMap<>();
		criteriaBuilderImpl = DUXFactories.CRITERIA_BUILDER_IMPL.get(io, CriteriaBuilderImpl.class);
		expression = new DummyExpression<>();
	}

	@Test
	public void test() {

		aeq("sqrt", SqrtFunction.NAME);

		SqrtFunction sf = new SqrtFunction(criteriaBuilderImpl, expression);

		aeq("sqrt", sf.getFunctionName());
		aeq(Double.class, sf.getJavaType());
		aeqr(criteriaBuilderImpl, sf.criteriaBuilder());

		aeq(true, invoke(sf, "isStandardJpaFunction"));
	}
}

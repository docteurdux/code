package dux.org.hibernate.query.criteria.internal.expression.function;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.expression.function.AbsFunction;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.DUXFactories;
import com.github.docteurdux.test.Done;

import dum.javax.persistence.criteria.DummyExpression;

@Done
public class AbsFunctionTest extends AbstractTest {

	private Map<DUXFactories, Object> io;

	@SuppressWarnings("rawtypes")
	private DummyExpression expression;

	@SuppressWarnings("rawtypes")
	public AbsFunctionTest() {

		io = new HashMap<>();

		expression = new DummyExpression();
	}

	@Test
	public void test() {

		aeq("abs", AbsFunction.NAME);

		AbsFunction<Number> absFunction = new AbsFunction<>(
				DUXFactories.CRITERIA_BUILDER_IMPL.get(io, CriteriaBuilderImpl.class), expression);
		aeq(true, invoke(absFunction, "isStandardJpaFunction"));

	}
}

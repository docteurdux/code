package dux.org.hibernate.query.criteria.internal.expression.function;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.query.criteria.internal.expression.function.LengthFunction;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.DUXFactories;
import com.github.docteurdux.test.Done;

import dum.javax.persistence.criteria.DummyExpression;

@Done
public class LengthFunctionTest extends AbstractTest {

	private Map<DUXFactories, Object> io;
	private CriteriaBuilderImpl criteriaBuilderImpl;
	private DummyExpression<String> expression;

	public LengthFunctionTest() {

		io = new HashMap<DUXFactories, Object>();
		criteriaBuilderImpl = DUXFactories.CRITERIA_BUILDER_IMPL.get(io, CriteriaBuilderImpl.class);
		expression = new DummyExpression<>();

	}

	@Test
	public void test() {

		aeq("length", LengthFunction.NAME);

		LengthFunction lengthFunction = new LengthFunction(criteriaBuilderImpl, expression);

		aeq("length", lengthFunction.getFunctionName());
		aeq(Integer.class, lengthFunction.getJavaType());

	}
}

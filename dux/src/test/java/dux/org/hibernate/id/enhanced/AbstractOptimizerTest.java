package dux.org.hibernate.id.enhanced;

import org.hibernate.id.enhanced.DummyAbstractOptimizer;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class AbstractOptimizerTest extends AbstractTest {
	private Class<?> returnClass;
	private int incrementSize;

	@Before
	public void before() {
		returnClass = Object.class;
		incrementSize = 0;
	}

	@Test
	public void test() {
		DummyAbstractOptimizer abstractOptimizer = new DummyAbstractOptimizer(returnClass, incrementSize);
		aeq(returnClass, abstractOptimizer.getReturnClass());
		aeq(incrementSize, abstractOptimizer.getIncrementSize());
	}
}

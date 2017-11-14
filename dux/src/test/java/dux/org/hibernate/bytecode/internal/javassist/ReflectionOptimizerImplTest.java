package dux.org.hibernate.bytecode.internal.javassist;

import org.hibernate.bytecode.internal.bytebuddy.ReflectionOptimizerImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.bytecode.spi.ReflectionOptimizer.DummyAccessOptimizer;
import dum.org.hibernate.bytecode.spi.ReflectionOptimizer.DummyInstantiationOptimizer;

@Done
public class ReflectionOptimizerImplTest extends AbstractTest {

	private DummyInstantiationOptimizer instantiationOptimizer;
	private DummyAccessOptimizer accessOptimizer;

	@Before
	public void before() {
		instantiationOptimizer = new DummyInstantiationOptimizer();
		accessOptimizer = new DummyAccessOptimizer();
	}

	@Test
	public void test() {

		ReflectionOptimizerImpl reflectionOptimizerImpl = new ReflectionOptimizerImpl(instantiationOptimizer,
				accessOptimizer);
		aeqr(accessOptimizer, reflectionOptimizerImpl.getAccessOptimizer());
		aeqr(instantiationOptimizer, reflectionOptimizerImpl.getInstantiationOptimizer());

	}
}

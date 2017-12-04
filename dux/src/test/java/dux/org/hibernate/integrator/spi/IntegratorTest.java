package dux.org.hibernate.integrator.spi;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dux.org.hibernate.cache.internal.CollectionCacheInvalidatorTest;
import dux.org.hibernate.cfg.beanvalidation.BeanValidationIntegratorTest;
import dux.org.hibernate.jpa.event.spi.JpaIntegratorTest;
import dux.org.hibernate.secure.spi.JaccIntegratorTest;

public class IntegratorTest extends AbstractTest {

	/*-
	 * The org.hibernate.integrator.spi.Integrator interface defines the two
	 * functions "integrate" and "disintegrate".
	 * 
	 * Both functions take a org.hibernate.engine.spi.SessionFactoryImplementor and
	 * a org.hibernate.service.spi.SessionFactoryServiceRegistry as parameters
	 * 
	 * In addition, the "integrate" function takes a org.hibernate.boot.Metadata as
	 * input
	 * 
	 * Among the integrators provided by hibernate are:
	 * * org.hibernate.cfg.beanvalidation.BeanValidationIntegrator
	 * * org.hibernate.cache.internal.CollectionCacheInvalidator
	 * * org.hibernate.jpa.event.spi.JpaIntegrator
	 * * org.hibernate.secure.spi.JaccIntegrator
	 */
	@Test
	public void test() {
		include(BeanValidationIntegratorTest.class);
		include(CollectionCacheInvalidatorTest.class);
		include(JpaIntegratorTest.class);
		include(JaccIntegratorTest.class);

	}
}

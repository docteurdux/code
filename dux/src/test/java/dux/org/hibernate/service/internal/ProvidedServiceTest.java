package dux.org.hibernate.service.internal;

import org.hibernate.service.internal.ProvidedService;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ProvidedServiceTest extends AbstractTest {

	private A a;

	public static interface A {

	}

	@Before
	public void before() {
		a = new A() {

		};
	}

	@Test
	public void test() {
		ProvidedService<A> providedService = new ProvidedService<A>(A.class, a);
		aeq(A.class, providedService.getServiceRole());
		aeqr(a, providedService.getService());
	}
}

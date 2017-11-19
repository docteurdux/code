package dux.org.hibernate.engine.spi;

import org.hibernate.engine.spi.AbstractDelegatingSessionBuilderImplementor;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.TestEvent;

import dum.org.hibernate.engine.spi.DummySessionBuilderImplementor;
import dum.org.hibernate.engine.spi.DummySessionOwner;

@Done("todo : remove rawtypes warnings")
public class AbstractDelegatingSessionBuilderImplementorTest extends AbstractTest {

	@SuppressWarnings("rawtypes")
	private DummySessionBuilderImplementor sessionBuilderImplementor;

	private DummySessionOwner sessionOwner;

	@Before
	@SuppressWarnings("rawtypes")
	public void before() {
		sessionBuilderImplementor = new DummySessionBuilderImplementor();
		sessionOwner = new DummySessionOwner();
	}

	@Test
	public void test() {

		@SuppressWarnings("rawtypes")
		AbstractDelegatingSessionBuilderImplementor abstractDelegatingSessionBuilderImplementor = new AbstractDelegatingSessionBuilderImplementor(
				sessionBuilderImplementor) {

		};

		aeqr(abstractDelegatingSessionBuilderImplementor,
				abstractDelegatingSessionBuilderImplementor.owner(sessionOwner));

		aeq(1, sessionBuilderImplementor.getTestEvents().size());

		TestEvent testEvent = getTestEvent(sessionBuilderImplementor, 0);
		aeq("owner", testEvent.getName());
		aeqr(sessionOwner, testEvent.prop("sessionOwner"));

	}

}

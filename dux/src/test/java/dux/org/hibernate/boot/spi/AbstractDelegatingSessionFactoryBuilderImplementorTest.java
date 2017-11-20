package dux.org.hibernate.boot.spi;

import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.TestEvent;

import dum.org.hibernate.boot.spi.DummyAbstractDelegatingSessionFactoryBuilderImplementor;
import dum.org.hibernate.boot.spi.DummySessionFactoryBuilderImplementor;
import dum.org.hibernate.boot.spi.DummySessionFactoryOptions;

@Done
public class AbstractDelegatingSessionFactoryBuilderImplementorTest extends AbstractTest {
	private DummySessionFactoryOptions sessionFactoryOptions;
	private DummySessionFactoryBuilderImplementor sessionFactoryBuilderImplementor;

	@Before
	public void before() {

		sessionFactoryOptions = new DummySessionFactoryOptions();

		sessionFactoryBuilderImplementor = new DummySessionFactoryBuilderImplementor();
		sessionFactoryBuilderImplementor.setSessionFactoryOptions(sessionFactoryOptions);
	}

	@Test
	public void test() {

		DummyAbstractDelegatingSessionFactoryBuilderImplementor<DummySessionFactoryBuilderImplementor> abstractDelegatingSessionFactoryBuilderImplementor = new DummyAbstractDelegatingSessionFactoryBuilderImplementor<>(
				sessionFactoryBuilderImplementor);

		abstractDelegatingSessionFactoryBuilderImplementor.markAsJpaBootstrap();
		TestEvent lastTestEvent = getLastTestEvent(sessionFactoryBuilderImplementor);
		aeq("markAsJpaBootstrap", lastTestEvent.getName());

		abstractDelegatingSessionFactoryBuilderImplementor.disableJtaTransactionAccess();
		lastTestEvent = getLastTestEvent(sessionFactoryBuilderImplementor);
		aeq("disableJtaTransactionAccess", lastTestEvent.getName());

		aeqr(sessionFactoryOptions, abstractDelegatingSessionFactoryBuilderImplementor.buildSessionFactoryOptions());

		aeq(null, abstractDelegatingSessionFactoryBuilderImplementor.applyNameAsJndiName(false));
		abstractDelegatingSessionFactoryBuilderImplementor.setThis(sessionFactoryBuilderImplementor);
		aeqr(sessionFactoryBuilderImplementor,
				abstractDelegatingSessionFactoryBuilderImplementor.applyNameAsJndiName(false));
	}

}

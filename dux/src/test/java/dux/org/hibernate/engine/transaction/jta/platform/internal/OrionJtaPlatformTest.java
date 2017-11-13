package dux.org.hibernate.engine.transaction.jta.platform.internal;

import org.hibernate.engine.jndi.spi.JndiService;
import org.hibernate.engine.transaction.jta.platform.internal.OrionJtaPlatform;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.transaction.DummyTransactionManager;
import dum.javax.transaction.DummyUserTransaction;
import dum.org.hibernate.engine.jndi.spi.DummyJndiService;
import dum.org.hibernate.engine.transaction.jta.platform.internal.DummyOrionJtaPlatform;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

@Done
public class OrionJtaPlatformTest extends AbstractTest {
	private DummyJndiService jndiService;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;
	private DummyTransactionManager transactionManager;
	private DummyUserTransaction userTransaction;

	@Before
	public void before() {

		transactionManager = new DummyTransactionManager();
		userTransaction = new DummyUserTransaction();

		jndiService = new DummyJndiService();

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JndiService.class, jndiService);
	}

	@Test
	public void test() {

		DummyOrionJtaPlatform orionJtaPlatform = new DummyOrionJtaPlatform();
		orionJtaPlatform.injectServices(serviceRegistryImplementor);

		aeq("java:comp/UserTransaction", OrionJtaPlatform.TM_NAME);
		aeq("java:comp/UserTransaction", OrionJtaPlatform.UT_NAME);
		aeq(OrionJtaPlatform.TM_NAME, OrionJtaPlatform.UT_NAME);

		jndiService.bind(OrionJtaPlatform.TM_NAME, transactionManager);
		aeqr(transactionManager, orionJtaPlatform.locateTransactionManager());

		jndiService.bind(OrionJtaPlatform.UT_NAME, userTransaction);
		aeqr(userTransaction, orionJtaPlatform.locateUserTransaction());
	}
}

package dux.org.hibernate.engine.transaction.jta.platform.internal;

import org.hibernate.engine.jndi.spi.JndiService;
import org.hibernate.engine.transaction.jta.platform.internal.SunOneJtaPlatform;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.transaction.DummyTransactionManager;
import dum.javax.transaction.DummyUserTransaction;
import dum.org.hibernate.engine.jndi.spi.DummyJndiService;
import dum.org.hibernate.engine.transaction.jta.platform.internal.DummySunOneJtaPlatform;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

@Done
public class SunOneJtaPlatformTest extends AbstractTest {

	private DummyTransactionManager transactionManager;
	private DummyUserTransaction userTransaction;
	private DummyJndiService jndiService;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;

	@Before
	public void before() {
		transactionManager = new DummyTransactionManager();
		userTransaction = new DummyUserTransaction();
		jndiService = new DummyJndiService();
		jndiService.bind(SunOneJtaPlatform.TM_NAME, transactionManager);
		jndiService.bind(SunOneJtaPlatform.UT_NAME, userTransaction);
		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JndiService.class, jndiService);
	}

	@Test
	public void test() {

		aeq("java:appserver/TransactionManager", SunOneJtaPlatform.TM_NAME);
		aeq("java:comp/UserTransaction", SunOneJtaPlatform.UT_NAME);

		DummySunOneJtaPlatform s = new DummySunOneJtaPlatform();
		s.injectServices(serviceRegistryImplementor);

		aeqr(transactionManager, s.locateTransactionManager());
		aeqr(userTransaction, s.locateUserTransaction());

	}
}

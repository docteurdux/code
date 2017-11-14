package dux.org.hibernate.engine.transaction.jta.platform.internal;

import org.hibernate.engine.jndi.spi.JndiService;
import org.hibernate.engine.transaction.jta.platform.internal.JRun4JtaPlatform;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.transaction.DummyTransactionManager;
import dum.javax.transaction.DummyUserTransaction;
import dum.org.hibernate.engine.jndi.spi.DummyJndiService;
import dum.org.hibernate.engine.transaction.jta.platform.internal.DummyJRun4JtaPlatform;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

@Done
public class JRun4JtaPlatformTest extends AbstractTest {

	private DummyTransactionManager transactionManager;
	private DummyUserTransaction userTransaction;
	private DummyJndiService jndiService;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;

	@Before
	public void before() {

		transactionManager = new DummyTransactionManager();
		userTransaction = new DummyUserTransaction();

		jndiService = new DummyJndiService();
		jndiService.bind(JRun4JtaPlatform.TM_NAME, transactionManager);
		jndiService.bind(JRun4JtaPlatform.UT_NAME, userTransaction);

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JndiService.class, jndiService);
	}

	@Test
	public void test() {

		aeq("java:/TransactionManager", JRun4JtaPlatform.TM_NAME);
		aeq("java:comp/UserTransaction", JRun4JtaPlatform.UT_NAME);

		DummyJRun4JtaPlatform jRun4JtaPlatform = new DummyJRun4JtaPlatform();
		jRun4JtaPlatform.injectServices(serviceRegistryImplementor);

		aeqr(transactionManager, jRun4JtaPlatform.locateTransactionManager());
		aeqr(userTransaction, jRun4JtaPlatform.locateUserTransaction());
	}
}

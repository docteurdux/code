package dux.org.hibernate.engine.transaction.jta.platform.internal;

import org.hibernate.engine.jndi.spi.JndiService;
import org.hibernate.engine.transaction.jta.platform.internal.SapNetWeaverJtaPlatform;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.transaction.DummyTransactionManager;
import dum.javax.transaction.DummyUserTransaction;
import dum.org.hibernate.engine.jndi.spi.DummyJndiService;
import dum.org.hibernate.engine.transaction.jta.platform.internal.DummySapNetWeaverJtaPlatform;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

@Done
public class SapNetWeaverJtaPlatformTest extends AbstractTest {

	private DummyTransactionManager transactionManager;
	private DummyUserTransaction userTransaction;
	private DummyJndiService jndiService;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;

	@Before
	public void before() {

		transactionManager = new DummyTransactionManager();
		userTransaction = new DummyUserTransaction();

		jndiService = new DummyJndiService();
		jndiService.bind(SapNetWeaverJtaPlatform.TM_NAME, transactionManager);
		jndiService.bind(SapNetWeaverJtaPlatform.UT_NAME, userTransaction);

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JndiService.class, jndiService);
	}

	@Test
	public void test() {

		aeq("TransactionManager", SapNetWeaverJtaPlatform.TM_NAME);
		aeq("UserTransaction", SapNetWeaverJtaPlatform.UT_NAME);

		DummySapNetWeaverJtaPlatform snwjp = new DummySapNetWeaverJtaPlatform();
		snwjp.injectServices(serviceRegistryImplementor);
		aeqr(transactionManager, snwjp.locateTransactionManager());
		aeqr(userTransaction, snwjp.locateUserTransaction());
	}
}

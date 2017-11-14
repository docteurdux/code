package dux.org.hibernate.engine.transaction.jta.platform.internal;

import org.hibernate.engine.jndi.spi.JndiService;
import org.hibernate.engine.transaction.jta.platform.internal.ResinJtaPlatform;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.transaction.DummyTransactionManager;
import dum.javax.transaction.DummyUserTransaction;
import dum.org.hibernate.engine.jndi.spi.DummyJndiService;
import dum.org.hibernate.engine.transaction.jta.platform.internal.DummyResinJtaPlatform;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

@Done
public class ResinJtaPlatformTest extends AbstractTest {

	private DummyTransactionManager transactionManager;
	private DummyUserTransaction userTransaction;
	private DummyJndiService jndiService;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;

	@Before
	public void before() {

		transactionManager = new DummyTransactionManager();
		userTransaction = new DummyUserTransaction();

		jndiService = new DummyJndiService();
		jndiService.bind(ResinJtaPlatform.TM_NAME, transactionManager);
		jndiService.bind(ResinJtaPlatform.UT_NAME, userTransaction);

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JndiService.class, jndiService);
	}

	@Test
	public void test() {

		aeq("java:comp/TransactionManager", ResinJtaPlatform.TM_NAME);
		aeq("java:comp/UserTransaction", ResinJtaPlatform.UT_NAME);

		DummyResinJtaPlatform rjp = new DummyResinJtaPlatform();
		rjp.injectServices(serviceRegistryImplementor);

		aeqr(transactionManager, rjp.locateTransactionManager());
		aeqr(userTransaction, rjp.locateUserTransaction());
	}
}

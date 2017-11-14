package dux.org.hibernate.engine.transaction.jta.platform.internal;

import org.hibernate.engine.jndi.spi.JndiService;
import org.hibernate.engine.transaction.jta.platform.internal.OC4JJtaPlatform;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.transaction.DummyTransactionManager;
import dum.javax.transaction.DummyUserTransaction;
import dum.org.hibernate.engine.jndi.spi.DummyJndiService;
import dum.org.hibernate.engine.transaction.jta.platform.internal.DummyOC4JJtaPlatform;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

@Done
public class OC4JJtaPlatformTest extends AbstractTest {

	private DummyTransactionManager transactionManager;
	private DummyUserTransaction userTransaction;
	private DummyJndiService jndiService;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;

	@Before
	public void before() {

		transactionManager = new DummyTransactionManager();
		userTransaction = new DummyUserTransaction();

		jndiService = new DummyJndiService();
		jndiService.bind(OC4JJtaPlatform.TM_NAME, transactionManager);
		jndiService.bind(OC4JJtaPlatform.UT_NAME, userTransaction);

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JndiService.class, jndiService);
	}

	@Test
	public void test() {

		aeq("java:comp/pm/TransactionManager", OC4JJtaPlatform.TM_NAME);
		aeq("java:comp/UserTransaction", OC4JJtaPlatform.UT_NAME);

		DummyOC4JJtaPlatform oc4jJtaPlatform = new DummyOC4JJtaPlatform();
		oc4jJtaPlatform.injectServices(serviceRegistryImplementor);

		aeqr(transactionManager, oc4jJtaPlatform.locateTransactionManager());
		aeqr(userTransaction, oc4jJtaPlatform.locateUserTransaction());
	}

}

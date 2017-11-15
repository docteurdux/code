package dux.org.hibernate.engine.transaction.jta.platform.internal;

import org.hibernate.engine.jndi.spi.JndiService;
import org.hibernate.engine.transaction.jta.platform.internal.BorlandEnterpriseServerJtaPlatform;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.transaction.DummyTransactionManager;
import dum.javax.transaction.DummyUserTransaction;
import dum.org.hibernate.engine.jndi.spi.DummyJndiService;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

@Done
public class BorlandEnterpriseServerJtaPlatformTest extends AbstractTest {

	private String TM_NAME;
	private String UT_NAME;

	private DummyTransactionManager transactionManager;
	private DummyUserTransaction userTransaction;
	private DummyJndiService jndiService;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;

	@Before
	public void before() {

		TM_NAME = (String) getField(null, "TM_NAME", BorlandEnterpriseServerJtaPlatform.class);
		UT_NAME = (String) getField(null, "UT_NAME", BorlandEnterpriseServerJtaPlatform.class);

		transactionManager = new DummyTransactionManager();
		userTransaction = new DummyUserTransaction();

		jndiService = new DummyJndiService();
		jndiService.bind(TM_NAME, transactionManager);
		jndiService.bind(UT_NAME, userTransaction);

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JndiService.class, jndiService);

	}

	@Test
	public void test() throws Exception {

		aeq("java:pm/TransactionManager", TM_NAME);
		aeq("java:comp/UserTransaction", UT_NAME);

		BorlandEnterpriseServerJtaPlatform p = new BorlandEnterpriseServerJtaPlatform();
		p.injectServices(serviceRegistryImplementor);

		aeqr(transactionManager, invoke(p, "locateTransactionManager"));
		aeqr(userTransaction, invoke(p, "locateUserTransaction"));

	}
}

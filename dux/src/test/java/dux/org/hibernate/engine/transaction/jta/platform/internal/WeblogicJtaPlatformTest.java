package dux.org.hibernate.engine.transaction.jta.platform.internal;

import org.hibernate.engine.jndi.spi.JndiService;
import org.hibernate.engine.transaction.jta.platform.internal.WeblogicJtaPlatform;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.transaction.DummyTransactionManager;
import dum.javax.transaction.DummyUserTransaction;
import dum.org.hibernate.engine.jndi.spi.DummyJndiService;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

@Done
public class WeblogicJtaPlatformTest extends AbstractTest {

	private DummyTransactionManager transactionManager;
	private DummyUserTransaction userTransaction;
	private DummyJndiService jndiService;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;

	public WeblogicJtaPlatformTest() {

		transactionManager = new DummyTransactionManager();
		userTransaction = new DummyUserTransaction();

		jndiService = new DummyJndiService();
		jndiService.bind(WeblogicJtaPlatform.TM_NAME, transactionManager);
		jndiService.bind(WeblogicJtaPlatform.UT_NAME, userTransaction);

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JndiService.class, jndiService);
	}

	@Test
	public void test() {

		aeq("javax.transaction.TransactionManager", WeblogicJtaPlatform.TM_NAME);
		aeq("javax.transaction.UserTransaction", WeblogicJtaPlatform.UT_NAME);

		DummyWeblogicJtaPlatform wljp = new DummyWeblogicJtaPlatform();
		wljp.injectServices(serviceRegistryImplementor);

		aeqr(transactionManager, wljp.locateTransactionManager());
		aeqr(userTransaction, wljp.locateUserTransaction());
	}
}

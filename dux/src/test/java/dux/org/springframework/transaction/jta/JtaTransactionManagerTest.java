package dux.org.springframework.transaction.jta;

import java.util.Properties;

import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.TransactionSynchronizationRegistry;
import javax.transaction.UserTransaction;

import org.junit.Test;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

@Topic(JtaTransactionManager.class)
@Extends({})
@ExtendedBy({})
@Related({})
public class JtaTransactionManagerTest extends AbstractTest {
	@Test
	public void test() throws NotSupportedException, SystemException {

		UserTransaction userTransaction = null;
		TransactionManager transactionManager = null;
		String name = null;
		int timeout = 0;
		boolean allowCustomIsolationLevels = false;
		boolean autodetectTransactionManager = false;
		boolean autodetectTransactionSynchronizationRegistry = false;
		boolean autodetectUserTransaction = false;
		boolean cacheUserTransaction = false;
		Properties jndiEnvironment = null;
		JndiTemplate jndiTemplate = null;
		String transactionManagerName = null;
		TransactionSynchronizationRegistry transactionSynchronizationRegistry = null;
		String userTransactionName = null;

		JtaTransactionManager m = new JtaTransactionManager();
		m = new JtaTransactionManager(transactionManager);
		m = new JtaTransactionManager(userTransaction);
		m = new JtaTransactionManager(userTransaction, transactionManager);
		m.afterPropertiesSet();
		m.createTransaction(name, timeout);
		m.getJndiEnvironment();
		m.getJndiTemplate();
		m.getTransactionManager();
		m.getTransactionSynchronizationRegistry();
		m.getUserTransaction();
		m.setAllowCustomIsolationLevels(allowCustomIsolationLevels);
		m.setAutodetectTransactionManager(autodetectTransactionManager);
		m.setAutodetectTransactionSynchronizationRegistry(autodetectTransactionSynchronizationRegistry);
		m.setAutodetectUserTransaction(autodetectUserTransaction);
		m.setCacheUserTransaction(cacheUserTransaction);
		m.setJndiEnvironment(jndiEnvironment);
		m.setJndiTemplate(jndiTemplate);
		m.setTransactionManager(transactionManager);
		m.setTransactionManagerName(transactionManagerName);
		m.setTransactionSynchronizationRegistry(transactionSynchronizationRegistry);
		m.setUserTransaction(userTransaction);
		m.setUserTransactionName(userTransactionName);
		m.supportsResourceAdapterManagedTransactions();

	}
}
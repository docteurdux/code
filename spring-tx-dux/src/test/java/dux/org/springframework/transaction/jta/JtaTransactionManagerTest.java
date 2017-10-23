package dux.org.springframework.transaction.jta;

import javax.transaction.UserTransaction;

import org.junit.Test;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.jta.JtaTransactionManager;

import com.github.docteurdux.test.AbstractTest;

import dum.javax.transaction.DummyUserTransaction;
import dum.org.springframework.transaction.DummyTransactionDefinition;

public class JtaTransactionManagerTest extends AbstractTest {
	@Test
	public void test() {

		UserTransaction userTransaction = new DummyUserTransaction();

		JtaTransactionManager manager = new JtaTransactionManager();
		manager.setUserTransaction(userTransaction);

		TransactionDefinition definition = new DummyTransactionDefinition();
		TransactionStatus status = manager.getTransaction(definition);

		af(status.hasSavepoint());
		af(status.isCompleted());
		af(status.isNewTransaction());
		af(status.isRollbackOnly());

		manager.commit(status);
		// manager.rollback(status);
	}
}

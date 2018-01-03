package dux.org.springframework.transaction.support;

import org.junit.Test;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.ExtendedBy;
import com.github.docteurdux.test.Extends;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.java.io.SerializableTest;
import dux.org.springframework.jca.cci.connection.CciLocalTransactionManagerTest;

@Topic(AbstractPlatformTransactionManager.class)
@Extends({ PlatformTransactionManager.class, SerializableTest.class })
@ExtendedBy({CciLocalTransactionManagerTest.class})
@Related({})
public class AbstractPlatformTransactionManagerTest extends AbstractTest {
	@Test
	public void test() {

		AbstractPlatformTransactionManager a = new A();

		TransactionStatus status = null;
		TransactionDefinition definition = null;
		int defaultTimeout = 0;
		boolean globalRollbackOnParticipationFailure = false;
		boolean nestedTransactionAllowed = false;
		boolean rollbackOnCommitFailure = false;
		int transactionSynchronization = 0;
		String constantName = null;
		boolean validateExistingTransaction = false;

		a.commit(status);
		a.getDefaultTimeout();
		a.getTransaction(definition);
		a.getTransactionSynchronization();
		a.isFailEarlyOnGlobalRollbackOnly();
		a.isGlobalRollbackOnParticipationFailure();
		a.isNestedTransactionAllowed();
		a.isRollbackOnCommitFailure();
		a.isValidateExistingTransaction();
		a.rollback(status);
		a.setDefaultTimeout(defaultTimeout);
		a.isFailEarlyOnGlobalRollbackOnly();
		a.setGlobalRollbackOnParticipationFailure(globalRollbackOnParticipationFailure);
		a.setNestedTransactionAllowed(nestedTransactionAllowed);
		a.setRollbackOnCommitFailure(rollbackOnCommitFailure);
		a.setTransactionSynchronization(transactionSynchronization);
		a.setTransactionSynchronizationName(constantName);
		a.setValidateExistingTransaction(validateExistingTransaction);

		/*-
		  AbstractPlatformTransactionManager()
		commit(TransactionStatus)
		getDefaultTimeout()
		getTransaction(TransactionDefinition)
		getTransactionSynchronization()
		isFailEarlyOnGlobalRollbackOnly()
		isGlobalRollbackOnParticipationFailure()
		isNestedTransactionAllowed()
		isRollbackOnCommitFailure()
		isValidateExistingTransaction()
		rollback(TransactionStatus)
		setDefaultTimeout(int)
		setFailEarlyOnGlobalRollbackOnly(boolean)
		setGlobalRollbackOnParticipationFailure(boolean)
		setNestedTransactionAllowed(boolean)
		setRollbackOnCommitFailure(boolean)
		setTransactionSynchronization(int)
		setTransactionSynchronizationName(String)
		setValidateExistingTransaction(boolean)
		 */

	}

	private static class A extends AbstractPlatformTransactionManager {

		private static final long serialVersionUID = 1L;

		@Override
		protected Object doGetTransaction() throws TransactionException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		protected void doBegin(Object transaction, TransactionDefinition definition) throws TransactionException {
			// TODO Auto-generated method stub

		}

		@Override
		protected void doCommit(DefaultTransactionStatus status) throws TransactionException {
			// TODO Auto-generated method stub

		}

		@Override
		protected void doRollback(DefaultTransactionStatus status) throws TransactionException {
			// TODO Auto-generated method stub

		}

	}
}
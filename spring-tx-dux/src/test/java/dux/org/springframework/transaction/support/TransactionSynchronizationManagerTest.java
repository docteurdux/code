package dux.org.springframework.transaction.support;

import java.sql.Connection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.github.docteurdux.test.AbstractTest;

import dum.org.springframework.transaction.support.DummyTransactionSynchronization;

public class TransactionSynchronizationManagerTest extends AbstractTest {

	@Before
	public void before() {
		TransactionSynchronizationManager.clear();
	}

	public void foo() {
		Object key = new Object();
		Object value = new Object();

		TransactionSynchronizationManager.bindResource(key, value);
		TransactionSynchronizationManager.clear();
		TransactionSynchronizationManager.getResource(key);
		TransactionSynchronizationManager.getResourceMap();
		TransactionSynchronizationManager.hasResource(key);
		TransactionSynchronizationManager.unbindResource(key);
		TransactionSynchronizationManager.unbindResourceIfPossible(key);
	}

	@Test
	public void test1t() {
		TransactionSynchronizationManager.setActualTransactionActive(true);
		at(TransactionSynchronizationManager.isActualTransactionActive());
	}

	@Test
	public void test1f() {
		TransactionSynchronizationManager.setActualTransactionActive(false);
		af(TransactionSynchronizationManager.isActualTransactionActive());
	}

	@Test
	public void test2t() {
		TransactionSynchronizationManager.setCurrentTransactionReadOnly(false);
		af(TransactionSynchronizationManager.isCurrentTransactionReadOnly());
	}

	@Test
	public void test2f() {
		TransactionSynchronizationManager.setCurrentTransactionReadOnly(true);
		at(TransactionSynchronizationManager.isCurrentTransactionReadOnly());
	}

	@Test
	public void test3() {
		an(TransactionSynchronizationManager.getCurrentTransactionName());
		TransactionSynchronizationManager.setCurrentTransactionName("name");
		aeq("name", TransactionSynchronizationManager.getCurrentTransactionName());
	}

	@Test
	public void test4() {

		an(TransactionSynchronizationManager.getCurrentTransactionIsolationLevel());
		TransactionSynchronizationManager
				.setCurrentTransactionIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
		aeq(TransactionDefinition.ISOLATION_SERIALIZABLE,
				TransactionSynchronizationManager.getCurrentTransactionIsolationLevel());

		aeq(TransactionDefinition.ISOLATION_SERIALIZABLE, Connection.TRANSACTION_SERIALIZABLE);
		aeq(TransactionDefinition.ISOLATION_REPEATABLE_READ, Connection.TRANSACTION_REPEATABLE_READ);
		aeq(TransactionDefinition.ISOLATION_READ_COMMITTED, Connection.TRANSACTION_READ_COMMITTED);
		aeq(TransactionDefinition.ISOLATION_READ_UNCOMMITTED, Connection.TRANSACTION_READ_UNCOMMITTED);
	}

	@Test
	public void test5() {

		TransactionSynchronization synchronization = new DummyTransactionSynchronization();

		af(TransactionSynchronizationManager.isSynchronizationActive());

		TransactionSynchronizationManager.initSynchronization();

		at(TransactionSynchronizationManager.isSynchronizationActive());

		TransactionSynchronizationManager.registerSynchronization(synchronization);

		List<TransactionSynchronization> synchronizations = TransactionSynchronizationManager.getSynchronizations();

		aeq(1, synchronizations.size());
		aeq(synchronization, synchronizations.get(0));

		TransactionSynchronizationManager.clearSynchronization();

		af(TransactionSynchronizationManager.isSynchronizationActive());

	}
}

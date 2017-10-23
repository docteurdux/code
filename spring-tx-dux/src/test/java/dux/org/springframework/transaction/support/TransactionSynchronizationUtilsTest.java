package dux.org.springframework.transaction.support;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.transaction.support.ResourceTransactionManager;
import org.springframework.transaction.support.TransactionSynchronization;
import org.springframework.transaction.support.TransactionSynchronizationUtils;

import dum.org.springframework.transaction.support.DummyResourceTransactionManager;
import dum.org.springframework.transaction.support.DummyTransactionSynchronization;

public class TransactionSynchronizationUtilsTest {

	public void foo() {

		List<TransactionSynchronization> synchronizations = new ArrayList<TransactionSynchronization>();
		DummyTransactionSynchronization synchronization = new DummyTransactionSynchronization();
		synchronizations.add(synchronization);
		int completionStatus = 0;
		ResourceTransactionManager tm = new DummyResourceTransactionManager();
		Object resourceFactory = new Object();
		boolean readOnly = false;

		TransactionSynchronizationUtils.triggerBeforeCommit(readOnly);
		TransactionSynchronizationUtils.triggerBeforeCompletion();

		TransactionSynchronizationUtils.triggerAfterCommit();
		TransactionSynchronizationUtils.triggerAfterCompletion(completionStatus);

		TransactionSynchronizationUtils.invokeAfterCommit(synchronizations);
		TransactionSynchronizationUtils.invokeAfterCompletion(synchronizations, completionStatus);

		TransactionSynchronizationUtils.sameResourceFactory(tm, resourceFactory);

		TransactionSynchronizationUtils.triggerFlush();
	}

	@Test
	public void test1() {
		TransactionSynchronizationUtils.triggerBeforeCompletion();
	}
}

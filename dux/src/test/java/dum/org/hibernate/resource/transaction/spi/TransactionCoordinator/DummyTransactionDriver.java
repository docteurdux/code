package dum.org.hibernate.resource.transaction.spi.TransactionCoordinator;

import org.hibernate.resource.transaction.spi.TransactionCoordinator.TransactionDriver;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyTransactionDriver extends TestEventCollector implements TransactionDriver {

	private TransactionStatus status;

	@Override
	public void begin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void commit() {
		testEvents.add(new TestEvent("commit"));
	}

	@Override
	public void rollback() {
		// TODO Auto-generated method stub

	}

	@Override
	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

	@Override
	public void markRollbackOnly() {
		// TODO Auto-generated method stub

	}

}

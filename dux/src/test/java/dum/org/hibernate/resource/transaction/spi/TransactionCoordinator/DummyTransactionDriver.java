package dum.org.hibernate.resource.transaction.spi.TransactionCoordinator;

import org.hibernate.resource.transaction.spi.TransactionCoordinator.TransactionDriver;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class DummyTransactionDriver implements TransactionDriver {

	private TransactionStatus status;

	@Override
	public void begin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub

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

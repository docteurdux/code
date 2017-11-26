package dum.org.hibernate.resource.transaction.spi;

import org.hibernate.engine.transaction.spi.IsolationDelegate;
import org.hibernate.engine.transaction.spi.TransactionObserver;
import org.hibernate.resource.transaction.spi.SynchronizationRegistry;
import org.hibernate.resource.transaction.spi.TransactionCoordinator;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder;

public class DummyTransactionCoordinator implements TransactionCoordinator {

	private boolean joined;
	private TransactionDriver transactionDriverControl;
	private SynchronizationRegistry localSynchronizations;

	@Override
	public void explicitJoin() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isJoined() {
		return joined;
	}

	public void setJoined(boolean joined) {
		this.joined = joined;
	}

	@Override
	public void pulse() {
		// TODO Auto-generated method stub

	}

	@Override
	public TransactionDriver getTransactionDriverControl() {
		return transactionDriverControl;
	}

	public void setTransactionDriverControl(TransactionDriver transactionDriverControl) {
		this.transactionDriverControl = transactionDriverControl;
	}

	@Override
	public SynchronizationRegistry getLocalSynchronizations() {
		return localSynchronizations;
	}

	public void setLocalSynchronizations(SynchronizationRegistry localSynchronizations) {
		this.localSynchronizations = localSynchronizations;
	}

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IsolationDelegate createIsolationDelegate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addObserver(TransactionObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeObserver(TransactionObserver observer) {
		// TODO Auto-generated method stub

	}

	@Override
	public TransactionCoordinatorBuilder getTransactionCoordinatorBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTimeOut(int seconds) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTimeOut() {
		// TODO Auto-generated method stub
		return 0;
	}

}

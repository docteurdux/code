package dum.org.hibernate.resource.transaction.spi;

import org.hibernate.resource.jdbc.spi.JdbcSessionOwner;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorOwner;

public class DummyTransactionCoordinatorOwner implements TransactionCoordinatorOwner {

	@Override
	public boolean isActive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterTransactionBegin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeTransactionCompletion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterTransactionCompletion(boolean successful, boolean delayed) {
		// TODO Auto-generated method stub

	}

	@Override
	public JdbcSessionOwner getJdbcSessionOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTransactionTimeOut(int seconds) {
		// TODO Auto-generated method stub

	}

	@Override
	public void flushBeforeTransactionCompletion() {
		// TODO Auto-generated method stub

	}

}

package dum.org.hibernate.engine.transaction.jta.platform.internal;

import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;

import org.hibernate.engine.transaction.jta.platform.internal.JRun4JtaPlatform;

public class DummyJRun4JtaPlatform extends JRun4JtaPlatform {

	private static final long serialVersionUID = 1L;

	@Override
	public TransactionManager locateTransactionManager() {
		return super.locateTransactionManager();
	}

	@Override
	public UserTransaction locateUserTransaction() {
		return super.locateUserTransaction();
	}

}

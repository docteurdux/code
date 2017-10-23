package dum.javax.transaction;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

public class DummyUserTransaction implements UserTransaction {

	private int status;

	public void begin() throws NotSupportedException, SystemException {
	}

	public void commit() throws RollbackException, HeuristicMixedException, HeuristicRollbackException,
			SecurityException, IllegalStateException, SystemException {
	}

	public int getStatus() throws SystemException {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void rollback() throws IllegalStateException, SecurityException, SystemException {
	}

	public void setRollbackOnly() throws IllegalStateException, SystemException {
	}

	public void setTransactionTimeout(int arg0) throws SystemException {
	}

}

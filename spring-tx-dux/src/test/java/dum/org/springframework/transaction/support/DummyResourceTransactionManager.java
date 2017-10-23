package dum.org.springframework.transaction.support;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.ResourceTransactionManager;

public class DummyResourceTransactionManager implements ResourceTransactionManager {

	private TransactionStatus transaction;
	private Object resourceFactory;

	public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
		return transaction;
	}

	public void commit(TransactionStatus status) throws TransactionException {
	}

	public void rollback(TransactionStatus status) throws TransactionException {
	}

	public Object getResourceFactory() {
		return resourceFactory;
	}

	public void setTransaction(TransactionStatus transaction) {
		this.transaction = transaction;
	}

	public void setResourceFactory(Object resourceFactory) {
		this.resourceFactory = resourceFactory;
	}

}

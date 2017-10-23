package dum.org.hibernate.resource.transaction.backend.jdbc.spi;

import org.hibernate.resource.transaction.backend.jdbc.spi.JdbcResourceTransaction;
import org.hibernate.resource.transaction.backend.jdbc.spi.JdbcResourceTransactionAccess;

public class DummyJdbcResourceTransactionAccess implements JdbcResourceTransactionAccess {

	private JdbcResourceTransaction resourceLocalTransaction;

	@Override
	public JdbcResourceTransaction getResourceLocalTransaction() {
		return resourceLocalTransaction;
	}

	public void setResourceLocalTransaction(JdbcResourceTransaction resourceLocalTransaction) {
		this.resourceLocalTransaction = resourceLocalTransaction;
	}

}

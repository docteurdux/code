package dum.org.hibernate.resource.transaction.backend.jdbc.spi;

import org.hibernate.resource.transaction.backend.jdbc.spi.JdbcResourceTransaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyJdbcResourceTransaction extends TestEventCollector implements JdbcResourceTransaction {

	private TransactionStatus status;

	@Override
	public void begin() {
		testEvents.add(new TestEvent("begin"));
	}

	@Override
	public void commit() {
		testEvents.add(new TestEvent("commit"));

	}

	@Override
	public void rollback() {
		testEvents.add(new TestEvent("rollback"));

	}

	@Override
	public TransactionStatus getStatus() {
		return status;
	}

	public void setStatus(TransactionStatus status) {
		this.status = status;
	}

}

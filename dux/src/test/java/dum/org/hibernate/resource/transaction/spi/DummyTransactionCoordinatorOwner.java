package dum.org.hibernate.resource.transaction.spi;

import org.hibernate.resource.jdbc.spi.JdbcSessionOwner;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorOwner;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyTransactionCoordinatorOwner extends TestEventCollector implements TransactionCoordinatorOwner {

	private boolean active;
	private JdbcSessionOwner jdbcSessionOwner;
	private int timeout;

	@Override
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public void afterTransactionBegin() {
		testEvents.add(new TestEvent("afterTransactionBegin"));
	}

	@Override
	public void beforeTransactionCompletion() {
		testEvents.add(new TestEvent("beforeTransactionCompletion"));
	}

	@Override
	public void afterTransactionCompletion(boolean successful, boolean delayed) {
		testEvents.add(
				new TestEvent("afterTransactionCompletion").prop("successful", successful).prop("delayed", delayed));
	}

	@Override
	public JdbcSessionOwner getJdbcSessionOwner() {
		return jdbcSessionOwner;
	}

	public void setJdbcSessionOwner(JdbcSessionOwner jdbcSessionOwner) {
		this.jdbcSessionOwner = jdbcSessionOwner;
	}

	@Override
	public void setTransactionTimeOut(int seconds) {
		this.timeout = seconds;
	}

	@Override
	public void flushBeforeTransactionCompletion() {
		testEvents.add(new TestEvent("flushBeforeTransactionCompletion"));
	}

}

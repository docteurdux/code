package dum.org.hibernate.resource.jdbc.spi;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.resource.jdbc.spi.JdbcSessionContext;
import org.hibernate.resource.jdbc.spi.JdbcSessionOwner;
import org.hibernate.resource.transaction.spi.TransactionCoordinator;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyJdbcSessionOwner extends TestEventCollector implements JdbcSessionOwner {

	private JdbcSessionContext jdbcSessionContext;
	private JdbcConnectionAccess jdbcConnectionAccess;
	private TransactionCoordinator transactionCoordinator;
	private Integer jdbcBatchSize;

	@Override
	public JdbcSessionContext getJdbcSessionContext() {
		return jdbcSessionContext;
	}

	public void setJdbcSessionContext(JdbcSessionContext jdbcSessionContext) {
		this.jdbcSessionContext = jdbcSessionContext;
	}

	@Override
	public JdbcConnectionAccess getJdbcConnectionAccess() {
		return jdbcConnectionAccess;
	}

	public void setJdbcConnectionAccess(JdbcConnectionAccess jdbcConnectionAccess) {
		this.jdbcConnectionAccess = jdbcConnectionAccess;
	}

	@Override
	public TransactionCoordinator getTransactionCoordinator() {
		return transactionCoordinator;
	}

	public void setTransactionCoordinator(TransactionCoordinator transactionCoordinator) {
		this.transactionCoordinator = transactionCoordinator;
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
	public void flushBeforeTransactionCompletion() {
		testEvents.add(new TestEvent("flushBeforeTransactionCompletion"));

	}

	@Override
	public Integer getJdbcBatchSize() {
		return jdbcBatchSize;
	}

	public void setJdbcBatchSize(Integer jdbcBatchSize) {
		this.jdbcBatchSize = jdbcBatchSize;
	}

}

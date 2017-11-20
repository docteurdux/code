package dum.org.hibernate.engine.jdbc.spi;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Statement;

import org.hibernate.engine.jdbc.batch.spi.Batch;
import org.hibernate.engine.jdbc.batch.spi.BatchKey;
import org.hibernate.engine.jdbc.spi.JdbcCoordinator;
import org.hibernate.engine.jdbc.spi.ResultSetReturn;
import org.hibernate.engine.jdbc.spi.StatementPreparer;
import org.hibernate.jdbc.WorkExecutorVisitable;
import org.hibernate.resource.jdbc.spi.JdbcSessionOwner;
import org.hibernate.resource.jdbc.spi.LogicalConnectionImplementor;
import org.hibernate.resource.transaction.backend.jdbc.spi.JdbcResourceTransaction;

public class DummyJdbcCoordinator implements JdbcCoordinator {

	private static final long serialVersionUID = 1L;
	private StatementPreparer statementPreparer;
	private ResultSetReturn resultSetReturn;
	private LogicalConnectionImplementor logicalConnectionImplementor;

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

	@Override
	public JdbcResourceTransaction getResourceLocalTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LogicalConnectionImplementor getLogicalConnection() {
		return logicalConnectionImplementor;
	}

	public void setLogicalConnectionImplementor(LogicalConnectionImplementor logicalConnectionImplementor) {
		this.logicalConnectionImplementor = logicalConnectionImplementor;
	}

	@Override
	public Batch getBatch(BatchKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executeBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public void abortBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public StatementPreparer getStatementPreparer() {
		return statementPreparer;
	}

	public void setStatementPreparer(StatementPreparer statementPreparer) {
		this.statementPreparer = statementPreparer;
	}

	@Override
	public ResultSetReturn getResultSetReturn() {
		return resultSetReturn;
	}

	public void setResultSetReturn(ResultSetReturn resultSetReturn) {
		this.resultSetReturn = resultSetReturn;
	}

	@Override
	public void flushBeginning() {
		// TODO Auto-generated method stub

	}

	@Override
	public void flushEnding() {
		// TODO Auto-generated method stub

	}

	@Override
	public Connection close() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void afterTransaction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterStatementExecution() {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T coordinateWork(WorkExecutorVisitable<T> work) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelLastQuery() {
		// TODO Auto-generated method stub

	}

	@Override
	public int determineRemainingTransactionTimeOutPeriod() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void enableReleases() {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableReleases() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerLastQuery(Statement statement) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isReadyForSerialization() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void serialize(ObjectOutputStream objectOutputStream) throws IOException {
		// TODO Auto-generated method stub

	}

}

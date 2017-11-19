package dum.org.hibernate;

import java.sql.Connection;
import java.util.TimeZone;

import org.hibernate.ConnectionReleaseMode;
import org.hibernate.FlushMode;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionEventListener;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.jdbc.spi.StatementInspector;

public class DummySessionBuilder<T extends SessionBuilder> implements SessionBuilder<T> {

	@Override
	public Session openSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T interceptor(Interceptor interceptor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T noInterceptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T statementInspector(StatementInspector statementInspector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T connection(Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T connectionReleaseMode(ConnectionReleaseMode connectionReleaseMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T connectionHandlingMode(PhysicalConnectionHandlingMode mode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T autoJoinTransactions(boolean autoJoinTransactions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T autoClose(boolean autoClose) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T autoClear(boolean autoClear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T flushMode(FlushMode flushMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T tenantIdentifier(String tenantIdentifier) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T eventListeners(SessionEventListener... listeners) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T clearEventListeners() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T jdbcTimeZone(TimeZone timeZone) {
		// TODO Auto-generated method stub
		return null;
	}
}

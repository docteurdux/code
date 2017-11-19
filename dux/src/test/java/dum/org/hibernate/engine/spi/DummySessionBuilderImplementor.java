package dum.org.hibernate.engine.spi;

import java.sql.Connection;
import java.util.TimeZone;

import org.hibernate.ConnectionReleaseMode;
import org.hibernate.FlushMode;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.SessionEventListener;
import org.hibernate.engine.spi.SessionBuilderImplementor;
import org.hibernate.engine.spi.SessionOwner;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.jdbc.spi.StatementInspector;

import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

@SuppressWarnings("deprecation")
public class DummySessionBuilderImplementor<T extends SessionBuilder<?>> extends TestEventCollector
		implements SessionBuilderImplementor<T> {

	private RunnableWithArgs<Object> ownerRWA;

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

	@Override
	@SuppressWarnings("unchecked")
	public T owner(SessionOwner sessionOwner) {
		testEvents.add(new TestEvent("owner").prop("sessionOwner", sessionOwner));
		if (ownerRWA != null) {
			return (T) ownerRWA.run(sessionOwner);
		}
		return null;
	}

	public void setOwnerRWA(RunnableWithArgs<Object> ownerRWA) {
		this.ownerRWA = ownerRWA;
	}

}

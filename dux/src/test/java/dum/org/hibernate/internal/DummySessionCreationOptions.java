package dum.org.hibernate.internal;

import java.sql.Connection;
import java.util.TimeZone;

import org.hibernate.FlushMode;
import org.hibernate.Interceptor;
import org.hibernate.engine.spi.SessionOwner;
import org.hibernate.internal.SessionCreationOptions;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.AfterCompletionAction;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.ExceptionMapper;
import org.hibernate.resource.transaction.backend.jta.internal.synchronization.ManagedFlushChecker;

@SuppressWarnings("deprecation")
public class DummySessionCreationOptions implements SessionCreationOptions {

	private String tenantIdentifier;
	private FlushMode initialSessionFlushMode;

	@Override
	public boolean shouldAutoJoinTransactions() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FlushMode getInitialSessionFlushMode() {
		return initialSessionFlushMode;
	}

	public void setInitialSessionFlushMode(FlushMode initialSessionFlushMode) {
		this.initialSessionFlushMode = initialSessionFlushMode;
	}

	@Override
	public boolean shouldAutoClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean shouldAutoClear() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Interceptor getInterceptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatementInspector getStatementInspector() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhysicalConnectionHandlingMode getPhysicalConnectionHandlingMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTenantIdentifier() {
		return tenantIdentifier;
	}

	public void setTenantIdentifier(String tenantIdentifier) {
		this.tenantIdentifier = tenantIdentifier;
	}

	@Override
	public TimeZone getJdbcTimeZone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionOwner getSessionOwner() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExceptionMapper getExceptionMapper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AfterCompletionAction getAfterCompletionAction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManagedFlushChecker getManagedFlushChecker() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isQueryParametersValidationEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

}

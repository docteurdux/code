package dum.org.hibernate.resource.jdbc.spi;

import org.hibernate.ConnectionAcquisitionMode;
import org.hibernate.ConnectionReleaseMode;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.resource.jdbc.spi.JdbcObserver;
import org.hibernate.resource.jdbc.spi.JdbcSessionContext;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.hibernate.service.ServiceRegistry;

public class DummyJdbcSessionContext implements JdbcSessionContext {

	private boolean scrollableResultSetsEnabled;
	private boolean getGeneratedKeysEnabled;
	private int fetchSize;
	private PhysicalConnectionHandlingMode physicalConnectionHandlingMode;
	private boolean connectionProviderDisableAutoCommit;
	private ConnectionReleaseMode connectionReleaseMode;
	private ConnectionAcquisitionMode connectionAcquisitionMode;
	private StatementInspector statementInspector;
	private JdbcObserver observer;
	private SessionFactoryImplementor sessionFactory;
	private ServiceRegistry serviceRegistry;

	@Override
	public boolean isScrollableResultSetsEnabled() {
		return scrollableResultSetsEnabled;
	}

	public void setScrollableResultSetsEnabled(boolean scrollableResultSetsEnabled) {
		this.scrollableResultSetsEnabled = scrollableResultSetsEnabled;
	}

	@Override
	public boolean isGetGeneratedKeysEnabled() {
		return getGeneratedKeysEnabled;
	}

	public void setGetGeneratedKeysEnabled(boolean getGeneratedKeysEnabled) {
		this.getGeneratedKeysEnabled = getGeneratedKeysEnabled;
	}

	@Override
	public int getFetchSize() {
		return fetchSize;
	}

	public void setFetchSize(int fetchSize) {
		this.fetchSize = fetchSize;
	}

	@Override
	public PhysicalConnectionHandlingMode getPhysicalConnectionHandlingMode() {
		return physicalConnectionHandlingMode;
	}

	public void setPhysicalConnectionHandlingMode(PhysicalConnectionHandlingMode physicalConnectionHandlingMode) {
		this.physicalConnectionHandlingMode = physicalConnectionHandlingMode;
	}

	@Override
	public boolean doesConnectionProviderDisableAutoCommit() {
		return connectionProviderDisableAutoCommit;
	}

	public void setConnectionProviderDisableAutoCommit(boolean connectionProviderDisableAutoCommit) {
		this.connectionProviderDisableAutoCommit = connectionProviderDisableAutoCommit;
	}

	@Override
	public ConnectionReleaseMode getConnectionReleaseMode() {
		return connectionReleaseMode;
	}

	public void setConnectionReleaseMode(ConnectionReleaseMode connectionReleaseMode) {
		this.connectionReleaseMode = connectionReleaseMode;
	}

	@Override
	public ConnectionAcquisitionMode getConnectionAcquisitionMode() {
		return connectionAcquisitionMode;
	}

	public void setConnectionAcquisitionMode(ConnectionAcquisitionMode connectionAcquisitionMode) {
		this.connectionAcquisitionMode = connectionAcquisitionMode;
	}

	@Override
	public StatementInspector getStatementInspector() {
		return statementInspector;
	}

	public void setStatementInspector(StatementInspector statementInspector) {
		this.statementInspector = statementInspector;
	}

	@Override
	public JdbcObserver getObserver() {
		return observer;
	}

	public void setObserver(JdbcObserver observer) {
		this.observer = observer;
	}

	@Override
	public SessionFactoryImplementor getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactoryImplementor sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public ServiceRegistry getServiceRegistry() {
		return serviceRegistry;
	}

	public void setServiceRegistry(ServiceRegistry serviceRegistry) {
		this.serviceRegistry = serviceRegistry;
	}

}

package dum.org.hibernate.engine.spi;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import javax.persistence.FlushModeType;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.ScrollMode;
import org.hibernate.Transaction;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.jdbc.LobCreator;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.jdbc.spi.JdbcCoordinator;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.query.spi.sql.NativeSQLQuerySpecification;
import org.hibernate.engine.spi.EntityKey;
import org.hibernate.engine.spi.ExceptionConverter;
import org.hibernate.engine.spi.LoadQueryInfluencers;
import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.QueryParameters;
import org.hibernate.engine.spi.SessionEventListenerManager;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.loader.custom.CustomQuery;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.Query;
import org.hibernate.query.spi.NativeQueryImplementor;
import org.hibernate.query.spi.QueryImplementor;
import org.hibernate.query.spi.ScrollableResultsImplementor;
import org.hibernate.resource.jdbc.spi.JdbcSessionContext;
import org.hibernate.resource.transaction.spi.TransactionCoordinator;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummySharedSessionContractImplementor implements SharedSessionContractImplementor {

	private static final long serialVersionUID = 1L;
	private SessionFactoryImplementor factory;
	private PersistenceContext persistenceContext;
	private boolean open;
	private boolean connected;
	private RunnableWithArgs<Object> immediateLoadRWA;
	private boolean closed;
	private RunnableWithArgs<Serializable> getContextEntityIdentifierRWA;
	private CacheMode cacheMode;
	private JdbcCoordinator jdbcCoordinator;

	public void close() throws HibernateException {
		// TODO Auto-generated method stub

	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

	public Transaction beginTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	public Transaction getTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcedureCall getNamedProcedureCall(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcedureCall createStoredProcedureCall(String procedureName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcedureCall createStoredProcedureCall(String procedureName, Class... resultClasses) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcedureCall createStoredProcedureCall(String procedureName, String... resultSetMappings) {
		// TODO Auto-generated method stub
		return null;
	}

	public Criteria createCriteria(Class persistentClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public Criteria createCriteria(Class persistentClass, String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	public Criteria createCriteria(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Criteria createCriteria(String entityName, String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getJdbcBatchSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setJdbcBatchSize(Integer jdbcBatchSize) {
		// TODO Auto-generated method stub

	}

	public Query createNamedQuery(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public JdbcSessionContext getJdbcSessionContext() {
		// TODO Auto-generated method stub
		return null;
	}

	public JdbcConnectionAccess getJdbcConnectionAccess() {
		// TODO Auto-generated method stub
		return null;
	}

	public TransactionCoordinator getTransactionCoordinator() {
		// TODO Auto-generated method stub
		return null;
	}

	public void afterTransactionBegin() {
		// TODO Auto-generated method stub

	}

	public void beforeTransactionCompletion() {
		// TODO Auto-generated method stub

	}

	public void afterTransactionCompletion(boolean successful, boolean delayed) {
		// TODO Auto-generated method stub

	}

	public void flushBeforeTransactionCompletion() {
		// TODO Auto-generated method stub

	}

	public boolean shouldAutoJoinTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> T execute(Callback<T> callback) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean useStreamForLobBinding() {
		// TODO Auto-generated method stub
		return false;
	}

	public LobCreator getLobCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
		// TODO Auto-generated method stub
		return null;
	}

	public TimeZone getJdbcTimeZone() {
		// TODO Auto-generated method stub
		return null;
	}

	public QueryImplementor getNamedQuery(String queryName) {
		// TODO Auto-generated method stub
		return null;
	}

	public QueryImplementor createQuery(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	public <R> QueryImplementor<R> createQuery(String queryString, Class<R> resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public <R> QueryImplementor<R> createNamedQuery(String name, Class<R> resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public NativeQueryImplementor createNativeQuery(String sqlString) {
		// TODO Auto-generated method stub
		return null;
	}

	public NativeQueryImplementor createNativeQuery(String sqlString, Class resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public NativeQueryImplementor createNativeQuery(String sqlString, String resultSetMapping) {
		// TODO Auto-generated method stub
		return null;
	}

	public NativeQueryImplementor getNamedNativeQuery(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactoryImplementor getFactory() {
		return factory;
	}

	public SessionEventListenerManager getEventListenerManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public PersistenceContext getPersistenceContext() {
		return persistenceContext;
	}

	public void setPersistenceContext(PersistenceContext persistenceContext) {
		this.persistenceContext = persistenceContext;
	}

	public JdbcCoordinator getJdbcCoordinator() {
		return jdbcCoordinator;
	}

	public void setJdbcCoordinator(JdbcCoordinator jdbcCoordinator) {
		this.jdbcCoordinator = jdbcCoordinator;
	}

	public JdbcServices getJdbcServices() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTenantIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	public UUID getSessionIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public void checkOpen(boolean markForRollbackIfClosed) {
		// TODO Auto-generated method stub

	}

	public void markForRollbackOnly() {
		// TODO Auto-generated method stub

	}

	public long getTimestamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isTransactionInProgress() {
		// TODO Auto-generated method stub
		return false;
	}

	public Transaction accessTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityKey generateEntityKey(Serializable id, EntityPersister persister) {
		// TODO Auto-generated method stub
		return null;
	}

	public Interceptor getInterceptor() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAutoClear(boolean enabled) {
		// TODO Auto-generated method stub

	}

	public void initializeCollection(PersistentCollection collection, boolean writing) throws HibernateException {
		// TODO Auto-generated method stub

	}

	public Object internalLoad(String entityName, Serializable id, boolean eager, boolean nullable)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object immediateLoad(String entityName, Serializable id) throws HibernateException {
		if (immediateLoadRWA != null) {
			return immediateLoadRWA.run(entityName, id);
		}
		return null;
	}

	public void setImmediateLoadRWA(RunnableWithArgs<Object> immediateLoadRWA) {
		this.immediateLoadRWA = immediateLoadRWA;
	}

	public List list(String query, QueryParameters queryParameters) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator iterate(String query, QueryParameters queryParameters) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public ScrollableResultsImplementor scroll(String query, QueryParameters queryParameters)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public ScrollableResultsImplementor scroll(Criteria criteria, ScrollMode scrollMode) {
		// TODO Auto-generated method stub
		return null;
	}

	public List list(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	public List listFilter(Object collection, String filter, QueryParameters queryParameters)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator iterateFilter(Object collection, String filter, QueryParameters queryParameters)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityPersister getEntityPersister(String entityName, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEntityUsingInterceptor(EntityKey key) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Serializable getContextEntityIdentifier(Object object) {
		if (getContextEntityIdentifierRWA != null) {
			return getContextEntityIdentifierRWA.run(object);
		}
		return null;
	}

	public void setGetContextEntityIdentifierRWA(RunnableWithArgs<Serializable> getContextEntityIdentifierRWA) {
		this.getContextEntityIdentifierRWA = getContextEntityIdentifierRWA;
	}

	public String bestGuessEntityName(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public String guessEntityName(Object entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object instantiate(String entityName, Serializable id) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public List listCustomQuery(CustomQuery customQuery, QueryParameters queryParameters) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public ScrollableResultsImplementor scrollCustomQuery(CustomQuery customQuery, QueryParameters queryParameters)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public List list(NativeSQLQuerySpecification spec, QueryParameters queryParameters) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public ScrollableResultsImplementor scroll(NativeSQLQuerySpecification spec, QueryParameters queryParameters) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getDontFlushFromFind() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int executeUpdate(String query, QueryParameters queryParameters) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	public int executeNativeUpdate(NativeSQLQuerySpecification specification, QueryParameters queryParameters)
			throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	public CacheMode getCacheMode() {
		return cacheMode;
	}

	public void setCacheMode(CacheMode cacheMode) {
		this.cacheMode = cacheMode;
	}

	public void setFlushMode(FlushMode flushMode) {
		// TODO Auto-generated method stub

	}

	public FlushModeType getFlushMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setHibernateFlushMode(FlushMode flushMode) {
		// TODO Auto-generated method stub

	}

	public FlushMode getHibernateFlushMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection connection() {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() {
		// TODO Auto-generated method stub

	}

	public boolean isEventSource() {
		// TODO Auto-generated method stub
		return false;
	}

	public void afterScrollOperation() {
		// TODO Auto-generated method stub

	}

	public boolean shouldAutoClose() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isAutoCloseSessionEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public LoadQueryInfluencers getLoadQueryInfluencers() {
		// TODO Auto-generated method stub
		return null;
	}

	public ExceptionConverter getExceptionConverter() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFactory(SessionFactoryImplementor factory) {
		this.factory = factory;
	}

}

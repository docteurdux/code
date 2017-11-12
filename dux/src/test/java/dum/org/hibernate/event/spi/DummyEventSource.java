package dum.org.hibernate.event.spi;

import java.io.Serializable;
import java.sql.Connection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.Interceptor;
import org.hibernate.LobHelper;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.ReplicationMode;
import org.hibernate.ScrollMode;
import org.hibernate.SessionEventListener;
import org.hibernate.SharedSessionBuilder;
import org.hibernate.SimpleNaturalIdLoadAccess;
import org.hibernate.Transaction;
import org.hibernate.TypeHelper;
import org.hibernate.UnknownProfileException;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.jdbc.LobCreator;
import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.jdbc.spi.JdbcCoordinator;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.query.spi.sql.NativeSQLQuerySpecification;
import org.hibernate.engine.spi.ActionQueue;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.EntityKey;
import org.hibernate.engine.spi.ExceptionConverter;
import org.hibernate.engine.spi.LoadQueryInfluencers;
import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.QueryParameters;
import org.hibernate.engine.spi.SessionEventListenerManager;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.event.spi.EventSource;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.hibernate.loader.custom.CustomQuery;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.Query;
import org.hibernate.query.spi.NativeQueryImplementor;
import org.hibernate.query.spi.QueryImplementor;
import org.hibernate.query.spi.ScrollableResultsImplementor;
import org.hibernate.resource.jdbc.spi.JdbcSessionContext;
import org.hibernate.resource.transaction.spi.TransactionCoordinator;
import org.hibernate.stat.SessionStatistics;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

public class DummyEventSource implements EventSource {

	private static final long serialVersionUID = 1L;
	private SessionFactoryImplementor factory;
	private PersistenceContext persistenceContext;

	@Override
	public SessionFactoryImplementor getSessionFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFlushBeforeCompletionEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public QueryImplementor createQuery(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> QueryImplementor<T> createQuery(String queryString, Class<T> resultType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> QueryImplementor<T> createNamedQuery(String name, Class<T> resultType) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public QueryImplementor createNamedQuery(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NativeQueryImplementor createNativeQuery(String sqlString) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public NativeQueryImplementor createNativeQuery(String sqlString, Class resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NativeQueryImplementor createNativeQuery(String sqlString, String resultSetMapping) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NativeQueryImplementor getNamedNativeQuery(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public QueryImplementor getNamedQuery(String queryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NativeQueryImplementor getNamedSQLQuery(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> QueryImplementor<T> createQuery(CriteriaQuery<T> criteriaQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public QueryImplementor createQuery(CriteriaUpdate updateQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public QueryImplementor createQuery(CriteriaDelete deleteQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> QueryImplementor<T> createQuery(String jpaqlString, Class<T> resultClass,
			@SuppressWarnings("rawtypes") Selection selection,
			@SuppressWarnings("deprecation") QueryOptions queryOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public SharedSessionBuilder sessionWithOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFlushMode(FlushMode flushMode) {
		// TODO Auto-generated method stub

	}

	@Override
	public FlushModeType getFlushMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setHibernateFlushMode(FlushMode flushMode) {
		// TODO Auto-generated method stub

	}

	@Override
	public FlushMode getHibernateFlushMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCacheMode(CacheMode cacheMode) {
		// TODO Auto-generated method stub

	}

	@Override
	public CacheMode getCacheMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cancelQuery() throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDirty() throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDefaultReadOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDefaultReadOnly(boolean readOnly) {
		// TODO Auto-generated method stub

	}

	@Override
	public Serializable getIdentifier(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(String entityName, Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void evict(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T load(Class<T> theClass, Serializable id, LockMode lockMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T load(Class<T> theClass, Serializable id, LockOptions lockOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object load(String entityName, Serializable id, LockMode lockMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object load(String entityName, Serializable id, LockOptions lockOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T load(Class<T> theClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object load(String entityName, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(Object object, Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void replicate(Object object, ReplicationMode replicationMode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void replicate(String entityName, Object object, ReplicationMode replicationMode) {
		// TODO Auto-generated method stub

	}

	@Override
	public Serializable save(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(String entityName, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdate(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrUpdate(String entityName, Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String entityName, Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object merge(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object merge(String entityName, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void persist(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void persist(String entityName, Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String entityName, Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lock(Object object, LockMode lockMode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lock(String entityName, Object object, LockMode lockMode) {
		// TODO Auto-generated method stub

	}

	@Override
	public LockRequest buildLockRequest(LockOptions lockOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void refresh(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(String entityName, Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(Object object, LockMode lockMode) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(Object object, LockOptions lockOptions) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(String entityName, Object object, LockOptions lockOptions) {
		// TODO Auto-generated method stub

	}

	@Override
	public LockMode getCurrentLockMode(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Query createFilter(Object collection, String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T get(Class<T> entityType, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T get(Class<T> entityType, Serializable id, LockMode lockMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T get(Class<T> entityType, Serializable id, LockOptions lockOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(String entityName, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(String entityName, Serializable id, LockMode lockMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(String entityName, Serializable id, LockOptions lockOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityName(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public IdentifierLoadAccess byId(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> MultiIdentifierLoadAccess<T> byMultipleIds(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public MultiIdentifierLoadAccess byMultipleIds(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> IdentifierLoadAccess<T> byId(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public NaturalIdLoadAccess byNaturalId(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> NaturalIdLoadAccess<T> byNaturalId(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public SimpleNaturalIdLoadAccess bySimpleNaturalId(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> SimpleNaturalIdLoadAccess<T> bySimpleNaturalId(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filter enableFilter(String filterName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Filter getEnabledFilter(String filterName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disableFilter(String filterName) {
		// TODO Auto-generated method stub

	}

	@Override
	public SessionStatistics getStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isReadOnly(Object entityOrProxy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setReadOnly(Object entityOrProxy, boolean readOnly) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doWork(Work work) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T doReturningWork(ReturningWork<T> work) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection disconnect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void reconnect(Connection connection) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFetchProfileEnabled(String name) throws UnknownProfileException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void enableFetchProfile(String name) throws UnknownProfileException {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableFetchProfile(String name) throws UnknownProfileException {
		// TODO Auto-generated method stub

	}

	@Override
	public TypeHelper getTypeHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LobHelper getLobHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEventListeners(SessionEventListener... listeners) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTenantIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Transaction beginTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transaction getTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcedureCall getNamedProcedureCall(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcedureCall createStoredProcedureCall(String procedureName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcedureCall createStoredProcedureCall(String procedureName,
			@SuppressWarnings("rawtypes") Class... resultClasses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProcedureCall createStoredProcedureCall(String procedureName, String... resultSetMappings) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criteria createCriteria(@SuppressWarnings("rawtypes") Class persistentClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criteria createCriteria(@SuppressWarnings("rawtypes") Class persistentClass, String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criteria createCriteria(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Criteria createCriteria(String entityName, String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getJdbcBatchSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJdbcBatchSize(Integer jdbcBatchSize) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> EntityGraph<T> createEntityGraph(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityGraph<?> createEntityGraph(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoredProcedureQuery createNamedStoredProcedureQuery(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(String arg0, @SuppressWarnings("rawtypes") Class... arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StoredProcedureQuery createStoredProcedureQuery(String arg0, String... arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void detach(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1, Map<String, Object> arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2, Map<String, Object> arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CriteriaBuilder getCriteriaBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDelegate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityGraph<?> getEntityGraph(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LockModeType getLockMode(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Metamodel getMetamodel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getReference(Class<T> arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isJoinedToTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void joinTransaction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void lock(Object arg0, LockModeType arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void lock(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(Object arg0, Map<String, Object> arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(Object arg0, LockModeType arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Object arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setFlushMode(FlushModeType arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setProperty(String arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryImplementor getFactory() {
		return factory;
	}

	public void setFactory(SessionFactoryImplementor factory) {
		this.factory = factory;
	}

	@Override
	public SessionEventListenerManager getEventListenerManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistenceContext getPersistenceContext() {
		return persistenceContext;
	}

	public void setPersistenceContext(PersistenceContext persistenceContext) {
		this.persistenceContext = persistenceContext;
	}

	@Override
	public JdbcCoordinator getJdbcCoordinator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JdbcServices getJdbcServices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getSessionIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClosed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void checkOpen(boolean markForRollbackIfClosed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void markForRollbackOnly() {
		// TODO Auto-generated method stub

	}

	@Override
	public long getTimestamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isTransactionInProgress() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Transaction accessTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityKey generateEntityKey(Serializable id, EntityPersister persister) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Interceptor getInterceptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAutoClear(boolean enabled) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initializeCollection(PersistentCollection collection, boolean writing) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object internalLoad(String entityName, Serializable id, boolean eager, boolean nullable)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object immediateLoad(String entityName, Serializable id) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List list(String query, QueryParameters queryParameters) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iterate(String query, QueryParameters queryParameters) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScrollableResultsImplementor scroll(String query, QueryParameters queryParameters)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScrollableResultsImplementor scroll(Criteria criteria, ScrollMode scrollMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List list(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List listFilter(Object collection, String filter, QueryParameters queryParameters)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator iterateFilter(Object collection, String filter, QueryParameters queryParameters)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPersister getEntityPersister(String entityName, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEntityUsingInterceptor(EntityKey key) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getContextEntityIdentifier(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String bestGuessEntityName(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guessEntityName(Object entity) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object instantiate(String entityName, Serializable id) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List listCustomQuery(CustomQuery customQuery, QueryParameters queryParameters) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScrollableResultsImplementor scrollCustomQuery(CustomQuery customQuery, QueryParameters queryParameters)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List list(NativeSQLQuerySpecification spec, QueryParameters queryParameters) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ScrollableResultsImplementor scroll(NativeSQLQuerySpecification spec, QueryParameters queryParameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDontFlushFromFind() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeUpdate(String query, QueryParameters queryParameters) throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int executeNativeUpdate(NativeSQLQuerySpecification specification, QueryParameters queryParameters)
			throws HibernateException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Connection connection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEventSource() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterScrollOperation() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean shouldAutoClose() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAutoCloseSessionEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoadQueryInfluencers getLoadQueryInfluencers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExceptionConverter getExceptionConverter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JdbcSessionContext getJdbcSessionContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JdbcConnectionAccess getJdbcConnectionAccess() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TransactionCoordinator getTransactionCoordinator() {
		// TODO Auto-generated method stub
		return null;
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
	public void flushBeforeTransactionCompletion() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean shouldAutoJoinTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T execute(Callback<T> callback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean useStreamForLobBinding() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LobCreator getLobCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimeZone getJdbcTimeZone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionImplementor getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LockOptions getLockRequest(LockModeType lockModeType, Map<String, Object> properties) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionQueue getActionQueue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object instantiate(EntityPersister persister, Serializable id) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void forceFlush(EntityEntry e) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(String entityName, Object object, @SuppressWarnings("rawtypes") Map copiedAlready)
			throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void persist(String entityName, Object object, @SuppressWarnings("rawtypes") Map createdAlready)
			throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void persistOnFlush(String entityName, Object object, @SuppressWarnings("rawtypes") Map copiedAlready) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(String entityName, Object object, @SuppressWarnings("rawtypes") Map refreshedAlready)
			throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String entityName, Object child, boolean isCascadeDeleteEnabled,
			@SuppressWarnings("rawtypes") Set transientEntities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeOrphanBeforeUpdates(String entityName, Object child) {
		// TODO Auto-generated method stub

	}

}

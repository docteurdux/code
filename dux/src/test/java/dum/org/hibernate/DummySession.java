package dum.org.hibernate;

import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;

import org.hibernate.CacheMode;
import org.hibernate.Criteria;
import org.hibernate.Filter;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.IdentifierLoadAccess;
import org.hibernate.LobHelper;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.MultiIdentifierLoadAccess;
import org.hibernate.NaturalIdLoadAccess;
import org.hibernate.ReplicationMode;
import org.hibernate.Session;
import org.hibernate.SessionEventListener;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionBuilder;
import org.hibernate.SimpleNaturalIdLoadAccess;
import org.hibernate.Transaction;
import org.hibernate.TypeHelper;
import org.hibernate.UnknownProfileException;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.hibernate.stat.SessionStatistics;

public class DummySession implements Session {

	public String getTenantIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() throws HibernateException {
		// TODO Auto-generated method stub

	}

	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
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

	public Query getNamedQuery(String queryName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query createNamedQuery(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public NativeQuery createNativeQuery(String sqlString) {
		// TODO Auto-generated method stub
		return null;
	}

	public NativeQuery createNativeQuery(String sqlString, String resultSetMapping) {
		// TODO Auto-generated method stub
		return null;
	}

	public NativeQuery getNamedNativeQuery(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> EntityGraph<T> createEntityGraph(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityGraph<?> createEntityGraph(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public StoredProcedureQuery createNamedStoredProcedureQuery(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public NativeQuery createNativeQuery(String arg0, Class arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public StoredProcedureQuery createStoredProcedureQuery(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public StoredProcedureQuery createStoredProcedureQuery(String arg0, Class... arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public StoredProcedureQuery createStoredProcedureQuery(String arg0, String... arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void detach(Object arg0) {
		// TODO Auto-generated method stub

	}

	public <T> T find(Class<T> arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T find(Class<T> arg0, Object arg1, Map<String, Object> arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T find(Class<T> arg0, Object arg1, LockModeType arg2, Map<String, Object> arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDelegate() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityGraph<?> getEntityGraph(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public LockModeType getLockMode(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Metamodel getMetamodel() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T getReference(Class<T> arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isJoinedToTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

	public void joinTransaction() {
		// TODO Auto-generated method stub

	}

	public void lock(Object arg0, LockModeType arg1) {
		// TODO Auto-generated method stub

	}

	public void lock(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
		// TODO Auto-generated method stub

	}

	public void refresh(Object arg0, Map<String, Object> arg1) {
		// TODO Auto-generated method stub

	}

	public void refresh(Object arg0, LockModeType arg1) {
		// TODO Auto-generated method stub

	}

	public void refresh(Object arg0, LockModeType arg1, Map<String, Object> arg2) {
		// TODO Auto-generated method stub

	}

	public void remove(Object arg0) {
		// TODO Auto-generated method stub

	}

	public void setFlushMode(FlushModeType arg0) {
		// TODO Auto-generated method stub

	}

	public void setProperty(String arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public SharedSessionBuilder sessionWithOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public void flush() throws HibernateException {
		// TODO Auto-generated method stub

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

	public void setCacheMode(CacheMode cacheMode) {
		// TODO Auto-generated method stub

	}

	public CacheMode getCacheMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public void cancelQuery() throws HibernateException {
		// TODO Auto-generated method stub

	}

	public boolean isDirty() throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDefaultReadOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setDefaultReadOnly(boolean readOnly) {
		// TODO Auto-generated method stub

	}

	public Serializable getIdentifier(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean contains(String entityName, Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	public void evict(Object object) {
		// TODO Auto-generated method stub

	}

	public <T> T load(Class<T> theClass, Serializable id, LockMode lockMode) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T load(Class<T> theClass, Serializable id, LockOptions lockOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object load(String entityName, Serializable id, LockMode lockMode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object load(String entityName, Serializable id, LockOptions lockOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T load(Class<T> theClass, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object load(String entityName, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void load(Object object, Serializable id) {
		// TODO Auto-generated method stub

	}

	public void replicate(Object object, ReplicationMode replicationMode) {
		// TODO Auto-generated method stub

	}

	public void replicate(String entityName, Object object, ReplicationMode replicationMode) {
		// TODO Auto-generated method stub

	}

	public Serializable save(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Serializable save(String entityName, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpdate(Object object) {
		// TODO Auto-generated method stub

	}

	public void saveOrUpdate(String entityName, Object object) {
		// TODO Auto-generated method stub

	}

	public void update(Object object) {
		// TODO Auto-generated method stub

	}

	public void update(String entityName, Object object) {
		// TODO Auto-generated method stub

	}

	public Object merge(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object merge(String entityName, Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public void persist(Object object) {
		// TODO Auto-generated method stub

	}

	public void persist(String entityName, Object object) {
		// TODO Auto-generated method stub

	}

	public void delete(Object object) {
		// TODO Auto-generated method stub

	}

	public void delete(String entityName, Object object) {
		// TODO Auto-generated method stub

	}

	public void lock(Object object, LockMode lockMode) {
		// TODO Auto-generated method stub

	}

	public void lock(String entityName, Object object, LockMode lockMode) {
		// TODO Auto-generated method stub

	}

	public LockRequest buildLockRequest(LockOptions lockOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	public void refresh(Object object) {
		// TODO Auto-generated method stub

	}

	public void refresh(String entityName, Object object) {
		// TODO Auto-generated method stub

	}

	public void refresh(Object object, LockMode lockMode) {
		// TODO Auto-generated method stub

	}

	public void refresh(Object object, LockOptions lockOptions) {
		// TODO Auto-generated method stub

	}

	public void refresh(String entityName, Object object, LockOptions lockOptions) {
		// TODO Auto-generated method stub

	}

	public LockMode getCurrentLockMode(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query createFilter(Object collection, String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public <T> T get(Class<T> entityType, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T get(Class<T> entityType, Serializable id, LockMode lockMode) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T get(Class<T> entityType, Serializable id, LockOptions lockOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object get(String entityName, Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object get(String entityName, Serializable id, LockMode lockMode) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object get(String entityName, Serializable id, LockOptions lockOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEntityName(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	public IdentifierLoadAccess byId(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> MultiIdentifierLoadAccess<T> byMultipleIds(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public MultiIdentifierLoadAccess byMultipleIds(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> IdentifierLoadAccess<T> byId(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public NaturalIdLoadAccess byNaturalId(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> NaturalIdLoadAccess<T> byNaturalId(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public SimpleNaturalIdLoadAccess bySimpleNaturalId(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> SimpleNaturalIdLoadAccess<T> bySimpleNaturalId(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public Filter enableFilter(String filterName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Filter getEnabledFilter(String filterName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void disableFilter(String filterName) {
		// TODO Auto-generated method stub

	}

	public SessionStatistics getStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isReadOnly(Object entityOrProxy) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setReadOnly(Object entityOrProxy, boolean readOnly) {
		// TODO Auto-generated method stub

	}

	public void doWork(Work work) throws HibernateException {
		// TODO Auto-generated method stub

	}

	public <T> T doReturningWork(ReturningWork<T> work) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Connection disconnect() {
		// TODO Auto-generated method stub
		return null;
	}

	public void reconnect(Connection connection) {
		// TODO Auto-generated method stub

	}

	public boolean isFetchProfileEnabled(String name) throws UnknownProfileException {
		// TODO Auto-generated method stub
		return false;
	}

	public void enableFetchProfile(String name) throws UnknownProfileException {
		// TODO Auto-generated method stub

	}

	public void disableFetchProfile(String name) throws UnknownProfileException {
		// TODO Auto-generated method stub

	}

	public TypeHelper getTypeHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	public LobHelper getLobHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addEventListeners(SessionEventListener... listeners) {
		// TODO Auto-generated method stub

	}

	public Query createQuery(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Query<T> createQuery(String queryString, Class<T> resultType) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Query<T> createQuery(CriteriaQuery<T> criteriaQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query createQuery(CriteriaUpdate updateQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query createQuery(CriteriaDelete deleteQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Query<T> createNamedQuery(String name, Class<T> resultType) {
		// TODO Auto-generated method stub
		return null;
	}

}

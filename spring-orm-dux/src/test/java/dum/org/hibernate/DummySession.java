package dum.org.hibernate;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
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

import com.github.docteurdux.test.TestEvent;

public class DummySession implements Session {

	private static final long serialVersionUID = 1L;

	List<TestEvent> events = new ArrayList<TestEvent>();
	Map<String, Throwable> throwMap = new HashMap<String, Throwable>();

	public Transaction beginTransaction() {
		return null;
	}

	public void close() throws HibernateException {
		events.add(new TestEvent("close"));
		if (throwMap.containsKey("close")) {
			Throwable ex = throwMap.get("close");
			if (ex instanceof HibernateException) {
				throw (HibernateException) ex;
			}
		}
	}

	public Criteria createCriteria(Class arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Criteria createCriteria(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Criteria createCriteria(Class arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Criteria createCriteria(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcedureCall createStoredProcedureCall(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcedureCall createStoredProcedureCall(String arg0, Class... arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcedureCall createStoredProcedureCall(String arg0, String... arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getJdbcBatchSize() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProcedureCall getNamedProcedureCall(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTenantIdentifier() {
		// TODO Auto-generated method stub
		return null;
	}

	public Transaction getTransaction() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setJdbcBatchSize(Integer arg0) {
		// TODO Auto-generated method stub

	}

	public Query createNamedQuery(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public NativeQuery createNativeQuery(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public NativeQuery createNativeQuery(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public NativeQuery getNamedNativeQuery(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query getNamedQuery(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void remove(Object entity) {
		// TODO Auto-generated method stub

	}

	public <T> T find(Class<T> entityClass, Object primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T getReference(Class<T> entityClass, Object primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFlushMode(FlushModeType flushMode) {
		// TODO Auto-generated method stub

	}

	public void lock(Object entity, LockModeType lockMode) {
		// TODO Auto-generated method stub

	}

	public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		// TODO Auto-generated method stub

	}

	public void refresh(Object entity, Map<String, Object> properties) {
		// TODO Auto-generated method stub

	}

	public void refresh(Object entity, LockModeType lockMode) {
		// TODO Auto-generated method stub

	}

	public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		// TODO Auto-generated method stub

	}

	public void detach(Object entity) {
		// TODO Auto-generated method stub

	}

	public boolean contains(Object entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public LockModeType getLockMode(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setProperty(String propertyName, Object value) {
		// TODO Auto-generated method stub

	}

	public Map<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	public StoredProcedureQuery createNamedStoredProcedureQuery(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public StoredProcedureQuery createStoredProcedureQuery(String procedureName) {
		// TODO Auto-generated method stub
		return null;
	}

	public StoredProcedureQuery createStoredProcedureQuery(String procedureName, Class... resultClasses) {
		// TODO Auto-generated method stub
		return null;
	}

	public StoredProcedureQuery createStoredProcedureQuery(String procedureName, String... resultSetMappings) {
		// TODO Auto-generated method stub
		return null;
	}

	public void joinTransaction() {
		// TODO Auto-generated method stub

	}

	public boolean isJoinedToTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> T unwrap(Class<T> cls) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDelegate() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Metamodel getMetamodel() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> EntityGraph<T> createEntityGraph(Class<T> rootType) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityGraph<?> createEntityGraph(String graphName) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityGraph<?> getEntityGraph(String graphName) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<EntityGraph<? super T>> getEntityGraphs(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public Session getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addEventListeners(SessionEventListener... arg0) {
		// TODO Auto-generated method stub

	}

	public LockRequest buildLockRequest(LockOptions arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public IdentifierLoadAccess byId(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> IdentifierLoadAccess<T> byId(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> MultiIdentifierLoadAccess<T> byMultipleIds(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public MultiIdentifierLoadAccess byMultipleIds(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public NaturalIdLoadAccess byNaturalId(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> NaturalIdLoadAccess<T> byNaturalId(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public SimpleNaturalIdLoadAccess bySimpleNaturalId(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> SimpleNaturalIdLoadAccess<T> bySimpleNaturalId(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void cancelQuery() throws HibernateException {
		// TODO Auto-generated method stub

	}

	public void clear() {
		// TODO Auto-generated method stub

	}

	public boolean contains(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	public Query createFilter(Object arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Query<T> createNamedQuery(String arg0, Class<T> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query createQuery(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Query<T> createQuery(CriteriaQuery<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query createQuery(CriteriaUpdate arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Query createQuery(CriteriaDelete arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Query<T> createQuery(String arg0, Class<T> arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Object arg0) {
		// TODO Auto-generated method stub

	}

	public void delete(String arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public void disableFetchProfile(String arg0) throws UnknownProfileException {
		// TODO Auto-generated method stub

	}

	public void disableFilter(String arg0) {
		// TODO Auto-generated method stub

	}

	public Connection disconnect() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T doReturningWork(ReturningWork<T> arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public void doWork(Work arg0) throws HibernateException {
		// TODO Auto-generated method stub

	}

	public void enableFetchProfile(String arg0) throws UnknownProfileException {
		// TODO Auto-generated method stub

	}

	public Filter enableFilter(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void evict(Object arg0) {
		// TODO Auto-generated method stub

	}

	public void flush() throws HibernateException {
		// TODO Auto-generated method stub

	}

	public <T> T get(Class<T> arg0, Serializable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object get(String arg0, Serializable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T get(Class<T> arg0, Serializable arg1, LockMode arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T get(Class<T> arg0, Serializable arg1, LockOptions arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object get(String arg0, Serializable arg1, LockMode arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object get(String arg0, Serializable arg1, LockOptions arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public CacheMode getCacheMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public LockMode getCurrentLockMode(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Filter getEnabledFilter(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEntityName(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public FlushModeType getFlushMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public FlushMode getHibernateFlushMode() {
		// TODO Auto-generated method stub
		return null;
	}

	public Serializable getIdentifier(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public LobHelper getLobHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionStatistics getStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	public TypeHelper getTypeHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isDefaultReadOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDirty() throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isFetchProfileEnabled(String arg0) throws UnknownProfileException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isReadOnly(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> T load(Class<T> arg0, Serializable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object load(String arg0, Serializable arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void load(Object arg0, Serializable arg1) {
		// TODO Auto-generated method stub

	}

	public <T> T load(Class<T> arg0, Serializable arg1, LockMode arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T load(Class<T> arg0, Serializable arg1, LockOptions arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object load(String arg0, Serializable arg1, LockMode arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object load(String arg0, Serializable arg1, LockOptions arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public void lock(Object arg0, LockMode arg1) {
		// TODO Auto-generated method stub

	}

	public void lock(String arg0, Object arg1, LockMode arg2) {
		// TODO Auto-generated method stub

	}

	public Object merge(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object merge(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void persist(Object arg0) {
		// TODO Auto-generated method stub

	}

	public void persist(String arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public void reconnect(Connection arg0) {
		// TODO Auto-generated method stub

	}

	public void refresh(Object arg0) {
		// TODO Auto-generated method stub

	}

	public void refresh(String arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public void refresh(Object arg0, LockMode arg1) {
		// TODO Auto-generated method stub

	}

	public void refresh(Object arg0, LockOptions arg1) {
		// TODO Auto-generated method stub

	}

	public void refresh(String arg0, Object arg1, LockOptions arg2) {
		// TODO Auto-generated method stub

	}

	public void replicate(Object arg0, ReplicationMode arg1) {
		// TODO Auto-generated method stub

	}

	public void replicate(String arg0, Object arg1, ReplicationMode arg2) {
		// TODO Auto-generated method stub

	}

	public Serializable save(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Serializable save(String arg0, Object arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public void saveOrUpdate(Object arg0) {
		// TODO Auto-generated method stub

	}

	public void saveOrUpdate(String arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public SharedSessionBuilder sessionWithOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCacheMode(CacheMode arg0) {
		// TODO Auto-generated method stub

	}

	public void setDefaultReadOnly(boolean arg0) {
		// TODO Auto-generated method stub

	}

	public void setFlushMode(FlushMode arg0) {
		// TODO Auto-generated method stub

	}

	public void setHibernateFlushMode(FlushMode arg0) {
		// TODO Auto-generated method stub

	}

	public void setReadOnly(Object arg0, boolean arg1) {
		// TODO Auto-generated method stub

	}

	public void update(Object arg0) {
		// TODO Auto-generated method stub

	}

	public void update(String arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public NativeQuery createNativeQuery(String sqlString, Class resultClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TestEvent> getEvents() {
		return events;
	}

	public void setThrow(String name, Throwable ex) {
		throwMap.put(name, ex);
	}

}

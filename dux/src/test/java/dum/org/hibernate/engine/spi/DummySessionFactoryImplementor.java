package dum.org.hibernate.engine.spi;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.Query;
import javax.persistence.SynchronizationType;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.CustomEntityDirtinessStrategy;
import org.hibernate.HibernateException;
import org.hibernate.Interceptor;
import org.hibernate.MappingException;
import org.hibernate.Session;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.StatelessSession;
import org.hibernate.StatelessSessionBuilder;
import org.hibernate.TypeHelper;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cfg.Settings;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.dialect.function.SQLFunctionRegistry;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.profile.FetchProfile;
import org.hibernate.engine.query.spi.QueryPlanCache;
import org.hibernate.engine.spi.CacheImplementor;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.engine.spi.SessionBuilderImplementor;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.factory.IdentifierGeneratorFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.metamodel.spi.MetamodelImplementor;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.hibernate.query.spi.NamedQueryRepository;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.hibernate.stat.spi.StatisticsImplementor;
import org.hibernate.type.Type;
import org.hibernate.type.TypeResolver;

public class DummySessionFactoryImplementor implements SessionFactoryImplementor {

	private ServiceRegistryImplementor serviceRegistry;

	public IdentifierGeneratorFactory getIdentifierGeneratorFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public Type getIdentifierType(String className) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIdentifierPropertyName(String className) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	public Type getReferencedPropertyType(String className, String propertyName) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionFactoryOptions getSessionFactoryOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Session openSession() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Session getCurrentSession() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public StatelessSessionBuilder withStatelessOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public StatelessSession openStatelessSession() {
		// TODO Auto-generated method stub
		return null;
	}

	public StatelessSession openStatelessSession(Connection connection) {
		// TODO Auto-generated method stub
		return null;
	}

	public void close() throws HibernateException {
		// TODO Auto-generated method stub

	}

	public boolean isClosed() {
		// TODO Auto-generated method stub
		return false;
	}

	public Set getDefinedFilterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public FilterDefinition getFilterDefinition(String filterName) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean containsFetchProfileDefinition(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public TypeHelper getTypeHelper() {
		// TODO Auto-generated method stub
		return null;
	}

	public ClassMetadata getClassMetadata(Class entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public ClassMetadata getClassMetadata(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	public CollectionMetadata getCollectionMetadata(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, ClassMetadata> getAllClassMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map getAllCollectionMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> void addNamedEntityGraph(String arg0, EntityGraph<T> arg1) {
		// TODO Auto-generated method stub

	}

	public void addNamedQuery(String arg0, Query arg1) {
		// TODO Auto-generated method stub

	}

	public EntityManager createEntityManager() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityManager createEntityManager(Map arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityManager createEntityManager(SynchronizationType arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityManager createEntityManager(SynchronizationType arg0, Map arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public CriteriaBuilder getCriteriaBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	public PersistenceUnitUtil getPersistenceUnitUtil() {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isOpen() {
		// TODO Auto-generated method stub
		return false;
	}

	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> List<EntityGraph<? super T>> findEntityGraphsByType(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return null;
	}

	public Reference getReference() throws NamingException {
		// TODO Auto-generated method stub
		return null;
	}

	public Type resolveParameterBindType(Object bindValue) {
		// TODO Auto-generated method stub
		return null;
	}

	public Type resolveParameterBindType(Class clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUuid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public SessionBuilderImplementor withOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	public Session openTemporarySession() throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public CacheImplementor getCache() {
		// TODO Auto-generated method stub
		return null;
	}

	public StatisticsImplementor getStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	public ServiceRegistryImplementor getServiceRegistry() {
		return serviceRegistry;
	}

	public Interceptor getInterceptor() {
		// TODO Auto-generated method stub
		return null;
	}

	public QueryPlanCache getQueryPlanCache() {
		// TODO Auto-generated method stub
		return null;
	}

	public NamedQueryRepository getNamedQueryRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	public FetchProfile getFetchProfile(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public TypeResolver getTypeResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	public IdentifierGenerator getIdentifierGenerator(String rootEntityName) {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityNotFoundDelegate getEntityNotFoundDelegate() {
		// TODO Auto-generated method stub
		return null;
	}

	public SQLFunctionRegistry getSqlFunctionRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addObserver(SessionFactoryObserver observer) {
		// TODO Auto-generated method stub

	}

	public CustomEntityDirtinessStrategy getCustomEntityDirtinessStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	public CurrentTenantIdentifierResolver getCurrentTenantIdentifierResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	public DeserializationResolver getDeserializationResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	public JdbcServices getJdbcServices() {
		// TODO Auto-generated method stub
		return null;
	}

	public Settings getSettings() {
		// TODO Auto-generated method stub
		return null;
	}

	public MetamodelImplementor getMetamodel() {
		// TODO Auto-generated method stub
		return null;
	}

	public EntityGraph findEntityGraphByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map getAllSecondLevelCacheRegions() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setServiceRegistry(ServiceRegistryImplementor serviceRegistry) {
		this.serviceRegistry = serviceRegistry;
	}

}

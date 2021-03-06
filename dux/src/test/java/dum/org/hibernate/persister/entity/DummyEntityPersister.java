package dum.org.hibernate.persister.entity;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.EntityMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.MappingException;
import org.hibernate.bytecode.spi.BytecodeEnhancementMetadata;
import org.hibernate.cache.spi.access.EntityRegionAccessStrategy;
import org.hibernate.cache.spi.access.NaturalIdRegionAccessStrategy;
import org.hibernate.cache.spi.entry.CacheEntry;
import org.hibernate.cache.spi.entry.CacheEntryStructure;
import org.hibernate.engine.spi.CascadeStyle;
import org.hibernate.engine.spi.EntityEntryFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.engine.spi.ValueInclusion;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.internal.FilterAliasGenerator;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.entity.Joinable;
import org.hibernate.persister.entity.Loadable;
import org.hibernate.persister.entity.MultiLoadOptions;
import org.hibernate.persister.walking.spi.AttributeDefinition;
import org.hibernate.persister.walking.spi.EntityIdentifierDefinition;
import org.hibernate.tuple.entity.EntityMetamodel;
import org.hibernate.tuple.entity.EntityTuplizer;
import org.hibernate.type.Type;
import org.hibernate.type.VersionType;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyEntityPersister implements EntityPersister, Joinable, Loadable {

	private String entityName;
	private Type identifierType;
	private EntityIdentifierDefinition entityKeyDefinition;
	private boolean consumesEntityAlias;
	private SessionFactoryImplementor factory;
	private RunnableWithArgs<String[]> getIdentifierAliasesRWA;
	private String[] propertyNames;
	private boolean hasNaturalIdentifier;
	private int[] naturalIdentifierProperties = new int[] {};
	private EntityMetamodel entityMetamodel;
	private Serializable[] querySpaces = new Serializable[] {};
	private boolean mutable;
	private String rootEntityName;
	private EntityEntryFactory entityEntryFactory;
	private boolean implementsLifecycle;

	@Override
	public Comparator getVersionComparator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPersister getEntityPersister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityIdentifierDefinition getEntityKeyDefinition() {
		return entityKeyDefinition;
	}

	public void setEntityKeyDefinition(EntityIdentifierDefinition entityKeyDefinition) {
		this.entityKeyDefinition = entityKeyDefinition;
	}

	@Override
	public Iterable<AttributeDefinition> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateEntityDefinition() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postInstantiate() throws MappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public SessionFactoryImplementor getFactory() {
		return factory;
	}

	public void setFactory(SessionFactoryImplementor factory) {
		this.factory = factory;
	}

	@Override
	public EntityEntryFactory getEntityEntryFactory() {
		return entityEntryFactory;
	}

	public void setEntityEntryFactory(EntityEntryFactory entityEntryFactory) {
		this.entityEntryFactory = entityEntryFactory;
	}

	@Override
	public String getRootEntityName() {
		return rootEntityName;
	}

	public void setRootEntityName(String rootEntityName) {
		this.rootEntityName = rootEntityName;
	}

	@Override
	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	@Override
	public EntityMetamodel getEntityMetamodel() {
		return entityMetamodel;
	}

	public void setEntityMetamodel(EntityMetamodel entityMetamodel) {
		this.entityMetamodel = entityMetamodel;
	}

	@Override
	public boolean isSubclassEntityName(String entityName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable[] getPropertySpaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable[] getQuerySpaces() {
		return querySpaces;
	}

	public void setQuerySpaces(Serializable[] querySpaces) {
		this.querySpaces = querySpaces;
	}

	@Override
	public boolean hasProxy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasCollections() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasMutableProperties() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasSubselectLoadableCollections() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasCascades() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMutable() {
		return mutable;
	}

	public void setMutable(boolean mutable) {
		this.mutable = mutable;
	}

	@Override
	public boolean isInherited() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIdentifierAssignedByInsert() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type getPropertyType(String propertyName) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] findDirty(Object[] currentState, Object[] previousState, Object owner,
			SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] findModified(Object[] old, Object[] current, Object object, SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasIdentifierProperty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canExtractIdOutOfEntity() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVersioned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VersionType getVersionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getVersionProperty() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasNaturalIdentifier() {
		return hasNaturalIdentifier;
	}

	public void setHasNaturalIdentifier(boolean hasNaturalIdentifier) {
		this.hasNaturalIdentifier = hasNaturalIdentifier;
	}

	@Override
	public int[] getNaturalIdentifierProperties() {
		return naturalIdentifierProperties;
	}

	public void setNaturalIdentifierProperties(int[] naturalIdentifierProperties) {
		this.naturalIdentifierProperties = naturalIdentifierProperties;
	}

	@Override
	public Object[] getNaturalIdentifierSnapshot(Serializable id, SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentifierGenerator getIdentifierGenerator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasLazyProperties() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable loadEntityIdByNaturalId(Object[] naturalIdValues, LockOptions lockOptions,
			SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object load(Serializable id, Object optionalObject, LockMode lockMode,
			SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object load(Serializable id, Object optionalObject, LockOptions lockOptions,
			SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List multiLoad(Serializable[] ids, SharedSessionContractImplementor session, MultiLoadOptions loadOptions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void lock(Serializable id, Object version, Object object, LockMode lockMode,
			SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void lock(Serializable id, Object version, Object object, LockOptions lockOptions,
			SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Serializable id, Object[] fields, Object object, SharedSessionContractImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public Serializable insert(Object[] fields, Object object, SharedSessionContractImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Serializable id, Object version, Object object, SharedSessionContractImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Serializable id, Object[] fields, int[] dirtyFields, boolean hasDirtyCollection,
			Object[] oldFields, Object oldVersion, Object object, Object rowId,
			SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public Type[] getPropertyTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getPropertyNames() {
		return propertyNames;
	}

	public void setPropertyNames(String[] propertyNames) {
		this.propertyNames = propertyNames;
	}

	@Override
	public boolean[] getPropertyInsertability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValueInclusion[] getPropertyInsertGenerationInclusions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValueInclusion[] getPropertyUpdateGenerationInclusions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] getPropertyUpdateability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] getPropertyCheckability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] getPropertyNullability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] getPropertyVersionability() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean[] getPropertyLaziness() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CascadeStyle[] getPropertyCascadeStyles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getIdentifierType() {
		return identifierType;
	}

	public void setIdentifierType(Type identifierType) {
		this.identifierType = identifierType;
	}

	@Override
	public String getIdentifierPropertyName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCacheInvalidationRequired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLazyPropertiesCacheable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasCache() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EntityRegionAccessStrategy getCacheAccessStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CacheEntryStructure getCacheEntryStructure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CacheEntry buildCacheEntry(Object entity, Object[] state, Object version,
			SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasNaturalIdCache() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NaturalIdRegionAccessStrategy getNaturalIdCacheAccessStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClassMetadata getClassMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBatchLoadable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSelectBeforeUpdateRequired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] getDatabaseSnapshot(Serializable id, SharedSessionContractImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getIdByUniqueKey(Serializable key, String uniquePropertyName,
			SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCurrentVersion(Serializable id, SharedSessionContractImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object forceVersionIncrement(Serializable id, Object currentVersion,
			SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInstrumented() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasInsertGeneratedProperties() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasUpdateGeneratedProperties() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVersionPropertyGenerated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void afterInitialize(Object entity, SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterReassociate(Object entity, SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object createProxy(Serializable id, SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isTransient(Object object, SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getPropertyValuesToInsert(Object object, Map mergeMap, SharedSessionContractImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processInsertGeneratedProperties(Serializable id, Object entity, Object[] state,
			SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub

	}

	@Override
	public void processUpdateGeneratedProperties(Serializable id, Object entity, Object[] state,
			SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub

	}

	@Override
	public Class getMappedClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean implementsLifecycle() {
		return implementsLifecycle;
	}

	public void setImplementsLifecycle(boolean implementsLifecycle) {
		this.implementsLifecycle = implementsLifecycle;
	}

	@Override
	public Class getConcreteProxyClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPropertyValues(Object object, Object[] values) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPropertyValue(Object object, int i, Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getPropertyValues(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPropertyValue(Object object, int i) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getPropertyValue(Object object, String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getIdentifier(Object object) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getIdentifier(Object entity, SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setIdentifier(Object entity, Serializable id, SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getVersion(Object object) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object instantiate(Serializable id, SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInstance(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasUninitializedLazyProperties(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resetIdentifier(Object entity, Serializable currentId, Object currentVersion,
			SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub

	}

	@Override
	public EntityPersister getSubclassEntityPersister(Object instance, SessionFactoryImplementor factory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityMode getEntityMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityTuplizer getEntityTuplizer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BytecodeEnhancementMetadata getInstrumentationMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FilterAliasGenerator getFilterAliasGenerator(String rootAlias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] resolveAttributeIndexes(String[] attributeNames) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canUseReferenceCacheEntries() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTableName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectFragment(Joinable rhs, String rhsAlias, String lhsAlias, String currentEntitySuffix,
			String currentCollectionSuffix, boolean includeCollectionColumns) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String whereJoinFragment(String alias, boolean innerJoin, boolean includeSubclasses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String whereJoinFragment(String alias, boolean innerJoin, boolean includeSubclasses,
			Set<String> treatAsDeclarations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fromJoinFragment(String alias, boolean innerJoin, boolean includeSubclasses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String fromJoinFragment(String alias, boolean innerJoin, boolean includeSubclasses,
			Set<String> treatAsDeclarations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getKeyColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String filterFragment(String alias, Map enabledFilters) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String filterFragment(String alias, Map enabledFilters, Set<String> treatAsDeclarations)
			throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String oneToManyFilterFragment(String alias) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String oneToManyFilterFragment(String alias, Set<String> treatAsDeclarations) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCollection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean consumesEntityAlias() {
		return consumesEntityAlias;
	}

	public void consumesEntityAlias(boolean consumesEntityAlias) {
		this.consumesEntityAlias = consumesEntityAlias;
	}

	@Override
	public boolean consumesCollectionAlias() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasSubclasses() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type getDiscriminatorType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getDiscriminatorValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSubclassForDiscriminatorValue(Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getIdentifierColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getIdentifierAliases(String suffix) {
		if (getIdentifierAliasesRWA != null) {
			return getIdentifierAliasesRWA.run(suffix);
		}
		return null;
	}

	public void setGetIdentifierAliasesRWA(RunnableWithArgs<String[]> getIdentifierAliasesRWA) {
		this.getIdentifierAliasesRWA = getIdentifierAliasesRWA;
	}

	@Override
	public String[] getPropertyAliases(String suffix, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getPropertyColumnNames(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDiscriminatorAlias(String suffix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDiscriminatorColumnName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasRowId() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] hydrate(ResultSet rs, Serializable id, Object object, Loadable rootLoadable,
			String[][] suffixedPropertyColumns, boolean allProperties, SharedSessionContractImplementor session)
			throws SQLException, HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAbstract() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void registerAffectingFetchProfile(String fetchProfileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getTableAliasForColumn(String columnName, String rootAlias) {
		// TODO Auto-generated method stub
		return null;
	}

}

package dum.org.hibernate.persister.collection;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.QueryException;
import org.hibernate.cache.spi.access.CollectionRegionAccessStrategy;
import org.hibernate.cache.spi.entry.CacheEntryStructure;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.persister.collection.CollectionPersister;
import org.hibernate.persister.collection.QueryableCollection;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.entity.Joinable;
import org.hibernate.persister.walking.spi.CollectionElementDefinition;
import org.hibernate.persister.walking.spi.CollectionIndexDefinition;
import org.hibernate.type.CollectionType;
import org.hibernate.type.Type;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyCollectionPersister implements CollectionPersister, Joinable, QueryableCollection {

	private EntityPersister ownerEntityPersister;
	private Type elementType;
	private String tableName;
	private String[] keyColumnNames = new String[] {};
	private String role;
	private RunnableWithArgs<String> filterFragmentRWA;
	private RunnableWithArgs<String> selectFragmentRWA;
	private CollectionElementDefinition elementDefinition;

	@Override
	public CollectionPersister getCollectionPersister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionIndexDefinition getIndexDefinition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionElementDefinition getElementDefinition() {
		return elementDefinition;
	}

	public void setElementDefinition(CollectionElementDefinition elementDefinition) {
		this.elementDefinition = elementDefinition;
	}

	@Override
	public void initialize(Serializable key, SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasCache() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CollectionRegionAccessStrategy getCacheAccessStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CacheEntryStructure getCacheEntryStructure() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionType getCollectionType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getKeyType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getIndexType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getElementType() {
		return elementType;
	}

	public void setElementType(Type elementType) {
		this.elementType = elementType;
	}

	@Override
	public Class getElementClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object readKey(ResultSet rs, String[] keyAliases, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object readElement(ResultSet rs, Object owner, String[] columnAliases,
			SharedSessionContractImplementor session) throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object readIndex(ResultSet rs, String[] columnAliases, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object readIdentifier(ResultSet rs, String columnAlias, SharedSessionContractImplementor session)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPrimitiveArray() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isArray() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOneToMany() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isManyToMany() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getManyToManyFilterFragment(String alias, Map enabledFilters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasIndex() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLazy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInverse() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(Serializable id, SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void recreate(PersistentCollection collection, Serializable key, SharedSessionContractImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRows(PersistentCollection collection, Serializable key, SharedSessionContractImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateRows(PersistentCollection collection, Serializable key, SharedSessionContractImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertRows(PersistentCollection collection, Serializable key, SharedSessionContractImplementor session)
			throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void processQueuedOps(PersistentCollection collection, Serializable key,
			SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public EntityPersister getOwnerEntityPersister() {
		return ownerEntityPersister;
	}

	public void setOwnerEntityPersister(EntityPersister ownerEntityPersister) {
		this.ownerEntityPersister = ownerEntityPersister;
	}

	@Override
	public IdentifierGenerator getIdentifierGenerator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getIdentifierType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasOrphanDelete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasOrdering() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasManyToManyOrdering() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable[] getCollectionSpaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionMetadata getCollectionMetadata() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCascadeDeleteEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isVersioned() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void postInstantiate() throws MappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public SessionFactoryImplementor getFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAffectedByEnabledFilters(SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String[] getKeyColumnAliases(String suffix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getIndexColumnAliases(String suffix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getElementColumnAliases(String suffix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdentifierColumnAlias(String suffix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExtraLazy() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize(Serializable key, SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean indexExists(Serializable key, Object index, SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean elementExists(Serializable key, Object element, SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getElementByIndex(Serializable key, Object index, SharedSessionContractImplementor session,
			Object owner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBatchSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getMappedByProperty() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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
		return keyColumnNames;
	}

	public void setKeyColumnNames(String[] keyColumnNames) {
		this.keyColumnNames = keyColumnNames;
	}

	@Override
	public String filterFragment(String alias, Map enabledFilters) throws MappingException {
		if (filterFragmentRWA != null) {
			return filterFragmentRWA.run(alias, enabledFilters);
		} else {
			return null;
		}
	}

	public void setFilterFragmentRWA(RunnableWithArgs<String> filterFragmentRWA) {
		this.filterFragmentRWA = filterFragmentRWA;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean consumesCollectionAlias() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Type toType(String propertyName) throws QueryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] toColumns(String alias, String propertyName) throws QueryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] toColumns(String propertyName) throws QueryException, UnsupportedOperationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String selectFragment(String alias, String columnSuffix) {
		if (selectFragmentRWA != null) {
			return selectFragmentRWA.run(alias, columnSuffix);
		} else {
			return null;
		}
	}

	public void setSelectFragmentRWA(RunnableWithArgs<String> selectFragmentRWA) {
		this.selectFragmentRWA = selectFragmentRWA;
	}

	@Override
	public String[] getIndexColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getIndexFormulas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getIndexColumnNames(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getElementColumnNames(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getElementColumnNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSQLOrderByString(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getManyToManyOrderByString(String alias) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasWhere() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EntityPersister getElementPersister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FetchMode getFetchMode() {
		// TODO Auto-generated method stub
		return null;
	}

}

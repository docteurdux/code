package dum.org.hibernate.persister.collection;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.cache.spi.access.CollectionRegionAccessStrategy;
import org.hibernate.cache.spi.entry.CacheEntryStructure;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.metadata.CollectionMetadata;
import org.hibernate.persister.collection.CollectionPersister;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.walking.spi.CollectionElementDefinition;
import org.hibernate.persister.walking.spi.CollectionIndexDefinition;
import org.hibernate.type.CollectionType;
import org.hibernate.type.Type;

public class DummyCollectionPersister implements CollectionPersister {

	private EntityPersister ownerEntityPersister;

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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
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

}

package dum.org.hibernate.engine.spi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.MappingException;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.loading.internal.LoadContexts;
import org.hibernate.engine.spi.BatchFetchQueue;
import org.hibernate.engine.spi.CollectionEntry;
import org.hibernate.engine.spi.CollectionKey;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.EntityKey;
import org.hibernate.engine.spi.EntityUniqueKey;
import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.engine.spi.Status;
import org.hibernate.persister.collection.CollectionPersister;
import org.hibernate.persister.entity.EntityPersister;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyPersistenceContext implements PersistenceContext {

	private List<Object> entities = new ArrayList<>();
	private List<EntityEntry> entries = new ArrayList<>();
	private NaturalIdHelper naturalIdHelper;
	private CollectionEntry collectionEntry;
	private Object loadedCollectionOwner;
	private Serializable loadedCollectionOwnerId;
	private RunnableWithArgs<EntityEntry> getEntryRWA;

	@Override
	public boolean isStateless() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SharedSessionContractImplementor getSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoadContexts getLoadContexts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUnownedCollection(CollectionKey key, PersistentCollection collection) {
		// TODO Auto-generated method stub

	}

	@Override
	public PersistentCollection useUnownedCollection(CollectionKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BatchFetchQueue getBatchFetchQueue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasNonReadOnlyEntities() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEntryStatus(EntityEntry entry, Status status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterTransactionCompletion() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getDatabaseSnapshot(Serializable id, EntityPersister persister) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getCachedDatabaseSnapshot(EntityKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getNaturalIdSnapshot(Serializable id, EntityPersister persister) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEntity(EntityKey key, Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getEntity(EntityKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsEntity(EntityKey key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object removeEntity(EntityKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEntity(EntityUniqueKey euk, Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object getEntity(EntityUniqueKey euk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityEntry getEntry(Object entity) {
		if (getEntryRWA != null) {
			return getEntryRWA.run(entity);
		}
		for (int i = 0; i < entities.size(); ++i) {
			if (entities.get(i) == entity) {
				return entries.get(i);
			}
		}
		return null;
	}

	public void setGetEntryRWA(RunnableWithArgs<EntityEntry> getEntryRWA) {
		this.getEntryRWA = getEntryRWA;
	}

	public void setEntry(Object entity, EntityEntry entry) {
		entities.add(entity);
		entries.add(entry);
	}

	@Override
	public EntityEntry removeEntry(Object entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEntryFor(Object entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CollectionEntry getCollectionEntry(PersistentCollection coll) {
		return collectionEntry;
	}

	public void setCollectionEntry(CollectionEntry collectionEntry) {
		this.collectionEntry = collectionEntry;
	}

	@Override
	public EntityEntry addEntity(Object entity, Status status, Object[] loadedState, EntityKey entityKey,
			Object version, LockMode lockMode, boolean existsInDatabase, EntityPersister persister,
			boolean disableVersionIncrement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityEntry addEntry(Object entity, Status status, Object[] loadedState, Object rowId, Serializable id,
			Object version, LockMode lockMode, boolean existsInDatabase, EntityPersister persister,
			boolean disableVersionIncrement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsCollection(PersistentCollection collection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsProxy(Object proxy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reassociateIfUninitializedProxy(Object value) throws MappingException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reassociateProxy(Object value, Serializable id) throws MappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object unproxy(Object maybeProxy) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object unproxyAndReassociate(Object maybeProxy) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkUniqueness(EntityKey key, Object object) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object narrowProxy(Object proxy, EntityPersister persister, EntityKey key, Object object)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object proxyFor(EntityPersister persister, EntityKey key, Object impl) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object proxyFor(Object impl) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCollectionOwner(Serializable key, CollectionPersister collectionPersister)
			throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLoadedCollectionOwnerOrNull(PersistentCollection collection) {
		return loadedCollectionOwner;
	}

	public void setLoadedCollectionOwner(Object loadedCollectionOwner) {
		this.loadedCollectionOwner = loadedCollectionOwner;
	}

	@Override
	public Serializable getLoadedCollectionOwnerIdOrNull(PersistentCollection collection) {
		return loadedCollectionOwnerId;
	}

	public void setLoadedCollectionOwnerId(Serializable loadedCollectionOwnerId) {
		this.loadedCollectionOwnerId = loadedCollectionOwnerId;
	}

	@Override
	public void addUninitializedCollection(CollectionPersister persister, PersistentCollection collection,
			Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addUninitializedDetachedCollection(CollectionPersister persister, PersistentCollection collection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNewCollection(CollectionPersister persister, PersistentCollection collection)
			throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addInitializedDetachedCollection(CollectionPersister collectionPersister,
			PersistentCollection collection) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public CollectionEntry addInitializedCollection(CollectionPersister persister, PersistentCollection collection,
			Serializable id) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentCollection getCollection(CollectionKey collectionKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNonLazyCollection(PersistentCollection collection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void initializeNonLazyCollections() throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public PersistentCollection getCollectionHolder(Object array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCollectionHolder(PersistentCollection holder) {
		// TODO Auto-generated method stub

	}

	@Override
	public PersistentCollection removeCollectionHolder(Object array) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable getSnapshot(PersistentCollection coll) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionEntry getCollectionEntryOrNull(Object collection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProxy(EntityKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProxy(EntityKey key, Object proxy) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object removeProxy(EntityKey key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashSet getNullifiableEntityKeys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getEntitiesByKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<Object, EntityEntry>[] reentrantSafeEntityEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getEntityEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfManagedEntities() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map getCollectionEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map getCollectionsByKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCascadeLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int incrementCascadeLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int decrementCascadeLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isFlushing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFlushing(boolean flushing) {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeLoad() {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterLoad() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLoadFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Serializable getOwnerId(String entityName, String propertyName, Object childEntity, Map mergeMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getIndexInOwner(String entity, String property, Object childObject, Map mergeMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNullProperty(EntityKey ownerKey, String propertyName) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPropertyNull(EntityKey ownerKey, String propertyName) {
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
	public boolean isReadOnly(Object entityOrProxy) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setReadOnly(Object entityOrProxy, boolean readOnly) {
		// TODO Auto-generated method stub

	}

	@Override
	public void replaceDelayedEntityIdentityInsertKeys(EntityKey oldKey, Serializable generatedId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addChildParent(Object child, Object parent) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeChildParent(Object child) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerInsertedKey(EntityPersister persister, Serializable id) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean wasInsertedDuringTransaction(EntityPersister persister, Serializable id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NaturalIdHelper getNaturalIdHelper() {
		return naturalIdHelper;
	}

	public void setNaturalIdHelper(NaturalIdHelper naturalIdHelper) {
		this.naturalIdHelper = naturalIdHelper;
	}

}

package dux.org.hibernate.engine.internal;

import java.io.Serializable;

import org.hibernate.EntityMode;
import org.hibernate.LockMode;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.internal.ImmutableEntityEntryFactory;
import org.hibernate.engine.internal.StatefulPersistenceContext;
import org.hibernate.engine.spi.EntityEntryFactory;
import org.hibernate.engine.spi.EntityKey;
import org.hibernate.engine.spi.EntityUniqueKey;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.Status;
import org.hibernate.mapping.DummyPersistentClass;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.persister.collection.CollectionPersister;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.tuple.entity.EntityMetamodel;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.collection.spi.DummyPersistentCollection;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.engine.spi.DummySharedSessionContractImplementor;
import dum.org.hibernate.persister.collection.DummyCollectionPersister;
import dum.org.hibernate.persister.entity.DummyEntityPersister;
import dum.org.hibernate.type.DummyType;
import dus.hibernate.core.HibernateCoreSummaryTest;

public class StatefulPersistenceContextTest extends AbstractTest {
	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, StatefulPersistenceContext.class);

	}

	@Test
	public void test() {

		DummySharedSessionContractImplementor session = new DummySharedSessionContractImplementor();
		StatefulPersistenceContext p = new StatefulPersistenceContext(session);

		new Runnable() {
			@Override
			public void run() {
				Object o1 = new Object();
				Object o2 = new Object();
				p.addChildParent(o1, o2);
			}
		};

		new Runnable() {
			@Override
			public void run() {
				DummyPersistentCollection holder = new DummyPersistentCollection();
				p.addCollectionHolder(holder);
			}
		};

		new Runnable() {
			@Override
			public void run() {
				Serializable id = new Serializable() {
					private static final long serialVersionUID = 1L;
				};
				DummyType identifierType = new DummyType();
				DummyEntityPersister persister = new DummyEntityPersister();
				persister.setIdentifierType(identifierType);
				EntityKey key = new EntityKey(id, persister);
				Object entity = new Object();
				p.addEntity(key, entity);
			}
		};

		new Runnable() {
			@Override
			public void run() {
				Object semiResolvedKey = new Object();
				DummyType keyType = new DummyType();
				DummyType semiResolvedType = new DummyType();
				keyType.setSemiResolvedType(semiResolvedType);
				EntityMode entityMode = EntityMode.POJO;
				DummySessionFactoryImplementor factory = new DummySessionFactoryImplementor();
				EntityUniqueKey euk = new EntityUniqueKey("entityName", "uniqueKeyName", semiResolvedKey, keyType,
						entityMode, factory);
				Object entity = new Object();
				p.addEntity(euk, entity);
			}
		};

		new Runnable() {
			@Override
			public void run() {
				Object entity = new Object();
				Status status = Status.MANAGED;
				Object[] loadedState = new Object[] {};
				Serializable id = new Serializable() {
					private static final long serialVersionUID = 1L;
				};
				DummyEntityPersister persister = new DummyEntityPersister();
				EntityEntryFactory entityEntryFactory = ImmutableEntityEntryFactory.INSTANCE;
				persister.setEntityEntryFactory(entityEntryFactory);
				DummyType identifierType = new DummyType();
				persister.setIdentifierType(identifierType);
				EntityKey entityKey = new EntityKey(id, persister);
				Object version = new Object();
				LockMode lockMode = LockMode.NONE;
				boolean existsInDatabase = false;
				boolean disableVersionIncrement = false;
				p.addEntity(entity, status, loadedState, entityKey, version, lockMode, existsInDatabase, persister,
						disableVersionIncrement);
			}
		};

		new Runnable() {
			@Override
			public void run() {
				Object entity = new Object();
				Status status = Status.MANAGED;
				Object[] loadedState = new Object[] {};
				Object rowId = new Object();
				Serializable id = new Serializable() {
					private static final long serialVersionUID = 1L;
				};
				Object version = new Object();
				LockMode lockMode = LockMode.NONE;
				boolean existsInDatabase = false;
				DummyEntityPersister persister = new DummyEntityPersister();
				persister.setEntityEntryFactory(ImmutableEntityEntryFactory.INSTANCE);
				boolean disableVersionIncrement = false;
				p.addEntry(entity, status, loadedState, rowId, id, version, lockMode, existsInDatabase, persister,
						disableVersionIncrement);
			}
		};

		DummyMetadataBuildingContext metadataBuildingContext = new DummyMetadataBuildingContext();
		DummyPersistentClass persistentClass = new DummyPersistentClass(metadataBuildingContext);
		DummyEntityPersister ownerEntityPersister = new DummyEntityPersister();
		DummySessionFactoryImplementor sessionFactory = new DummySessionFactoryImplementor();
		EntityMetamodel entityMetamodel = new EntityMetamodel(persistentClass, ownerEntityPersister, sessionFactory);
		ownerEntityPersister.setEntityMetamodel(entityMetamodel);
		DummyCollectionPersister persister = new DummyCollectionPersister();
		persister.setOwnerEntityPersister(ownerEntityPersister);
		DummyPersistentCollection collection = new DummyPersistentCollection();
		Serializable id = new Serializable() {
			private static final long serialVersionUID = 1L;
		};
		p.addInitializedCollection(persister, collection, id);
		/*-
		addInitializedCollection(CollectionPersister, PersistentCollection, Serializable)
		addInitializedDetachedCollection(CollectionPersister, PersistentCollection)
		addNewCollection(CollectionPersister, PersistentCollection)
		addNonLazyCollection(PersistentCollection)
		addNullProperty(EntityKey, String)
		addProxy(EntityKey, Object)
		addReferenceEntry(Object, Status)
		addUninitializedCollection(CollectionPersister, PersistentCollection, Serializable)
		addUninitializedDetachedCollection(CollectionPersister, PersistentCollection)
		addUnownedCollection(CollectionKey, PersistentCollection)
		afterLoad()
		afterTransactionCompletion()
		beforeLoad()
		beginRemoveOrphanBeforeUpdates()
		checkUniqueness(EntityKey, Object)
		clear()
		containsCollection(PersistentCollection)
		containsEntity(EntityKey)
		containsProxy(Object)
		decrementCascadeLevel()
		endRemoveOrphanBeforeUpdates()
		getBatchFetchQueue()
		getCachedDatabaseSnapshot(EntityKey)
		getCascadeLevel()
		getCollection(CollectionKey)
		getCollectionEntries()
		getCollectionEntry(PersistentCollection)
		getCollectionEntryOrNull(Object)
		getCollectionHolder(Object)
		getCollectionOwner(Serializable, CollectionPersister)
		getCollectionsByKey()
		getDatabaseSnapshot(Serializable, EntityPersister)
		getEntitiesByKey()
		getEntity(EntityKey)
		getEntity(EntityUniqueKey)
		getEntityEntries()
		getEntry(Object)
		getIndexInOwner(String, String, Object, Map)
		getLoadContexts()
		getLoadedCollectionOwnerIdOrNull(PersistentCollection)
		getLoadedCollectionOwnerOrNull(PersistentCollection)
		getNaturalIdHelper()
		getNaturalIdSnapshot(Serializable, EntityPersister)
		getNullifiableEntityKeys()
		getNumberOfManagedEntities()
		getOwnerId(String, String, Object, Map)
		getProxiesByKey()
		getProxy(EntityKey)
		getSession()
		getSnapshot(PersistentCollection)
		hasNonReadOnlyEntities()
		incrementCascadeLevel()
		initializeNonLazyCollections()
		isDefaultReadOnly()
		isEntryFor(Object)
		isFlushing()
		isLoadFinished()
		isPropertyNull(EntityKey, String)
		isReadOnly(Object)
		isRemovingOrphanBeforeUpates()
		isStateless()
		narrowProxy(Object, EntityPersister, EntityKey, Object)
		proxyFor(EntityPersister, EntityKey, Object)
		proxyFor(Object)
		reassociateIfUninitializedProxy(Object)
		reassociateProxy(Object, Serializable)
		reentrantSafeEntityEntries()
		registerInsertedKey(EntityPersister, Serializable)
		removeChildParent(Object)
		removeCollectionHolder(Object)
		removeEntity(EntityKey)
		removeEntry(Object)
		removeProxy(EntityKey)
		replaceDelayedEntityIdentityInsertKeys(EntityKey, Serializable)
		serialize(ObjectOutputStream)
		setDefaultReadOnly(boolean)
		setEntryStatus(EntityEntry, Status)
		setFlushing(boolean)
		setReadOnly(Object, boolean)
		toString()
		unproxy(Object)
		unproxyAndReassociate(Object)
		useUnownedCollection(CollectionKey)
		wasInsertedDuringTransaction(EntityPersister, Serializable)
		*/
	}
}

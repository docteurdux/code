package dux.org.hibernate.event.spi;

import java.io.Serializable;

import org.hibernate.event.spi.PreCollectionUpdateEvent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.collection.spi.DummyPersistentCollection;
import dum.org.hibernate.engine.spi.DummyEntityEntry;
import dum.org.hibernate.engine.spi.DummyPersistenceContext;
import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.persister.collection.DummyCollectionPersister;
import dum.org.hibernate.persister.entity.DummyEntityPersister;

@Done
public class PreCollectionUpdateEventTest extends AbstractTest {

	private String entityName;
	private Object entity;
	private Serializable id;

	private DummyEntityEntry entityEntry;

	private DummyEntityPersister entityPersister;

	private DummyCollectionPersister collectionPersister;

	private DummyPersistentCollection persistentCollection;

	private DummyPersistenceContext persistenceContext;

	private DummyEventSource eventSource;

	@Before
	public void before() {
		entityName = "entityName";
		entity = new Object();
		id = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		entityEntry = new DummyEntityEntry();

		entityPersister = new DummyEntityPersister();
		entityPersister.setEntityName(entityName);

		collectionPersister = new DummyCollectionPersister();
		collectionPersister.setOwnerEntityPersister(entityPersister);

		persistentCollection = new DummyPersistentCollection();

		persistenceContext = new DummyPersistenceContext();
		persistenceContext.setLoadedCollectionOwner(entity);
		persistenceContext.setLoadedCollectionOwnerId(id);
		persistenceContext.setEntry(entity, entityEntry);

		eventSource = new DummyEventSource();
		eventSource.setPersistenceContext(persistenceContext);

	}

	@Test
	public void test() {
		PreCollectionUpdateEvent preCollectionUpdateEvent = new PreCollectionUpdateEvent(collectionPersister,
				persistentCollection, eventSource);

		aeq(entityName, preCollectionUpdateEvent.getAffectedOwnerEntityName());
		aeqr(entity, preCollectionUpdateEvent.getAffectedOwnerOrNull());
		aeqr(id, preCollectionUpdateEvent.getAffectedOwnerIdOrNull());
		aeqr(persistentCollection, preCollectionUpdateEvent.getCollection());
		aeqr(eventSource, preCollectionUpdateEvent.getSession());

	}
}

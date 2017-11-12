package dux.org.hibernate.event.spi;

import org.hibernate.event.spi.AbstractCollectionEvent;
import org.hibernate.event.spi.AbstractEvent;
import org.hibernate.event.spi.PreCollectionRemoveEvent;
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
public class PreCollectionRemoveEventTest extends AbstractTest {

	private String entityName;
	private String ownerEntryId;
	private Object owner;
	private DummyEntityPersister entityPersister;
	private DummyCollectionPersister collectionPersister;
	private DummyPersistentCollection persistentCollection;
	private DummyEntityEntry entityEntry;
	private DummyPersistenceContext persistenceContext;
	private DummyEventSource eventSource;

	@Before
	public void before() {

		entityName = "entityName";
		ownerEntryId = "ownerEntryId";

		owner = new Object();

		entityPersister = new DummyEntityPersister();
		entityPersister.setEntityName(entityName);

		collectionPersister = new DummyCollectionPersister();
		collectionPersister.setOwnerEntityPersister(entityPersister);

		persistentCollection = new DummyPersistentCollection();

		entityEntry = new DummyEntityEntry();
		entityEntry.setId(ownerEntryId);

		persistenceContext = new DummyPersistenceContext();
		persistenceContext.setEntry(owner, entityEntry);

		eventSource = new DummyEventSource();
		eventSource.setPersistenceContext(persistenceContext);

	}

	@Test
	public void test() {

		aeq(AbstractCollectionEvent.class, PreCollectionRemoveEvent.class.getSuperclass());

		PreCollectionRemoveEvent preCollectionRemoveEvent = new PreCollectionRemoveEvent(collectionPersister,
				persistentCollection, eventSource, owner);

		AbstractCollectionEvent abstractCollectionEvent = preCollectionRemoveEvent;

		aeqr(persistentCollection, abstractCollectionEvent.getCollection());
		aeqr(owner, abstractCollectionEvent.getAffectedOwnerOrNull());
		aeq(ownerEntryId, abstractCollectionEvent.getAffectedOwnerIdOrNull());
		aeq(entityName, abstractCollectionEvent.getAffectedOwnerEntityName());

		AbstractEvent abstractEvent = abstractCollectionEvent;
		aeqr(eventSource, abstractEvent.getSession());
	}
}

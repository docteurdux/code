package dux.org.hibernate.event.spi;

import java.io.Serializable;

import org.hibernate.event.spi.PreCollectionRecreateEvent;
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
public class PreCollectionRecreateEventTest extends AbstractTest {

	private String entityName;

	private Object owner;

	private Serializable ownerId;

	private DummyEntityPersister entityPersister;

	private DummyCollectionPersister collectionPersister;

	private DummyPersistentCollection persistentCollection;

	private DummyEntityEntry entityEntry;

	private DummyPersistenceContext persistenceContext;

	private DummyEventSource eventSource;

	@Before
	public void before() {

		entityName = "entityName";

		owner = new Object();

		ownerId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		entityPersister = new DummyEntityPersister();
		entityPersister.setEntityName(entityName);

		collectionPersister = new DummyCollectionPersister();
		collectionPersister.setOwnerEntityPersister(entityPersister);

		persistentCollection = new DummyPersistentCollection();
		persistentCollection.setOwner(owner);

		entityEntry = new DummyEntityEntry();
		entityEntry.setId(ownerId);

		persistenceContext = new DummyPersistenceContext();
		persistenceContext.setEntry(owner, entityEntry);

		eventSource = new DummyEventSource();
		eventSource.setPersistenceContext(persistenceContext);
	}

	@Test
	public void test() {
		PreCollectionRecreateEvent preCollectionRecreateEvent = new PreCollectionRecreateEvent(collectionPersister,
				persistentCollection, eventSource);

		aeqr(eventSource, preCollectionRecreateEvent.getSession());
		aeqr(persistentCollection, preCollectionRecreateEvent.getCollection());
		aeqr(owner, preCollectionRecreateEvent.getAffectedOwnerOrNull());
		aeqr(ownerId, preCollectionRecreateEvent.getAffectedOwnerIdOrNull());
		aeq(entityName, preCollectionRecreateEvent.getAffectedOwnerEntityName());
	}
}

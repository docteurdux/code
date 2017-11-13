package dux.org.hibernate.event.spi;

import java.io.Serializable;

import org.hibernate.event.spi.PostCollectionRecreateEvent;
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
public class PostCollectionRecreateEventTest extends AbstractTest {
	private String entityName;
	private Serializable entityId;
	private Object entity;
	private DummyEntityPersister entityPersister;
	private DummyCollectionPersister collectionPersister;
	private DummyPersistentCollection persistentCollection;
	private DummyPersistenceContext persistenceContext;
	private DummyEntityEntry entityEntry;
	private DummyEventSource eventSource;

	@Before
	public void before() {
		entityName = "entityName";
		entityId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};
		entity = new Object();
		entityPersister = new DummyEntityPersister();
		entityPersister.setEntityName(entityName);
		collectionPersister = new DummyCollectionPersister();
		collectionPersister.setOwnerEntityPersister(entityPersister);
		persistentCollection = new DummyPersistentCollection();
		persistentCollection.setOwner(entity);
		entityEntry = new DummyEntityEntry();
		entityEntry.setId(entityId);
		persistenceContext = new DummyPersistenceContext();
		persistenceContext.setEntry(entity, entityEntry);
		eventSource = new DummyEventSource();
		eventSource.setPersistenceContext(persistenceContext);
	}

	@Test
	public void test() {

		PostCollectionRecreateEvent postCollectionRecreateEvent = new PostCollectionRecreateEvent(collectionPersister,
				persistentCollection, eventSource);

		aeqr(eventSource, postCollectionRecreateEvent.getSession());
		aeqr(persistentCollection, postCollectionRecreateEvent.getCollection());
		aeqr(entity, postCollectionRecreateEvent.getAffectedOwnerOrNull());
		aeqr(entityId, postCollectionRecreateEvent.getAffectedOwnerIdOrNull());
		aeq(entityName, postCollectionRecreateEvent.getAffectedOwnerEntityName());

	}
}

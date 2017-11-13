package dux.org.hibernate.event.spi;

import java.io.Serializable;

import org.hibernate.event.spi.PostCollectionUpdateEvent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.collection.spi.DummyPersistentCollection;
import dum.org.hibernate.engine.spi.DummyPersistenceContext;
import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.persister.collection.DummyCollectionPersister;
import dum.org.hibernate.persister.entity.DummyEntityPersister;

@Done
public class PostCollectionUpdateEventTest extends AbstractTest {

	private String entityName;
	private Object owner;
	private Serializable ownerId;

	private DummyPersistentCollection persistentCollection;

	private DummyEntityPersister entityPersister;

	private DummyCollectionPersister collectionPersister;

	private DummyPersistenceContext persistenceContext;

	private DummyEventSource eventSource;

	@Before
	public void before() {

		entityName = "entityName";

		owner = new Object();
		ownerId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		persistentCollection = new DummyPersistentCollection();

		entityPersister = new DummyEntityPersister();
		entityPersister.setEntityName(entityName);

		collectionPersister = new DummyCollectionPersister();
		collectionPersister.setOwnerEntityPersister(entityPersister);

		persistenceContext = new DummyPersistenceContext();
		persistenceContext.setLoadedCollectionOwner(owner);
		persistenceContext.setLoadedCollectionOwnerId(ownerId);

		eventSource = new DummyEventSource();
		eventSource.setPersistenceContext(persistenceContext);
	}

	@Test
	public void test() {

		PostCollectionUpdateEvent postCollectionUpdateEvent = new PostCollectionUpdateEvent(collectionPersister,
				persistentCollection, eventSource);

		aeqr(eventSource, postCollectionUpdateEvent.getSession());
		aeqr(persistentCollection, postCollectionUpdateEvent.getCollection());

		aeqr(owner, postCollectionUpdateEvent.getAffectedOwnerOrNull());
		aeqr(ownerId, postCollectionUpdateEvent.getAffectedOwnerIdOrNull());
		aeq(entityName, postCollectionUpdateEvent.getAffectedOwnerEntityName());

	}
}

package dux.org.hibernate.event.spi;

import java.io.Serializable;

import org.hibernate.event.spi.AbstractCollectionEvent;
import org.hibernate.event.spi.PostCollectionRemoveEvent;
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
public class PostCollectionRemoveEventTest extends AbstractTest {

	private Object owner;
	private Serializable entityEntryId;
	private DummyEntityEntry entityEntry;

	private DummyCollectionPersister collectionPersister;
	private DummyPersistentCollection persistentCollection;
	private DummyEventSource eventSource;
	private DummyPersistenceContext persistenceContext;
	private DummyEntityPersister ownerEntityPersister;

	@Before
	public void before() {

		owner = new Object();

		entityEntryId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		entityEntry = new DummyEntityEntry();
		entityEntry.setId(entityEntryId);

		ownerEntityPersister = new DummyEntityPersister();

		collectionPersister = new DummyCollectionPersister();
		collectionPersister.setOwnerEntityPersister(ownerEntityPersister);

		persistentCollection = new DummyPersistentCollection();

		persistenceContext = new DummyPersistenceContext();
		persistenceContext.setEntry(owner, entityEntry);

		eventSource = new DummyEventSource();
		eventSource.setPersistenceContext(persistenceContext);

	}

	@Test
	public void test() {

		aeq(AbstractCollectionEvent.class, PostCollectionRemoveEvent.class.getSuperclass());

		PostCollectionRemoveEvent postCollectionRemoveEvent = new PostCollectionRemoveEvent(collectionPersister,
				persistentCollection, eventSource, owner);

		aeqr(eventSource, postCollectionRemoveEvent.getSession());
		aeqr(persistentCollection, postCollectionRemoveEvent.getCollection());
		aeqr(owner, postCollectionRemoveEvent.getAffectedOwnerOrNull());
		aeqr(entityEntryId, postCollectionRemoveEvent.getAffectedOwnerIdOrNull());
	}
}

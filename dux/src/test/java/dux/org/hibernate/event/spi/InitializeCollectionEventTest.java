package dux.org.hibernate.event.spi;

import java.io.Serializable;

import org.hibernate.engine.spi.CollectionEntry;
import org.hibernate.event.spi.AbstractCollectionEvent;
import org.hibernate.event.spi.InitializeCollectionEvent;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.collection.spi.DummyPersistentCollection;
import dum.org.hibernate.engine.spi.DummyPersistenceContext;
import dum.org.hibernate.event.spi.DummyEventSource;
import dum.org.hibernate.persister.collection.DummyCollectionPersister;

@Done
public class InitializeCollectionEventTest extends AbstractTest {

	private Serializable ownerId;
	private Object owner;

	private DummyPersistentCollection persistentCollection;

	private DummyCollectionPersister collectionPersister;

	private CollectionEntry collectionEntry;

	private DummyPersistenceContext persistenceContext;
	private DummyEventSource eventSource;

	public InitializeCollectionEventTest() {

		ownerId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		owner = new Object();

		persistentCollection = new DummyPersistentCollection();

		collectionPersister = new DummyCollectionPersister();

		collectionEntry = new CollectionEntry(collectionPersister, persistentCollection);

		persistenceContext = new DummyPersistenceContext();
		persistenceContext.setCollectionEntry(collectionEntry);
		persistenceContext.setLoadedCollectionOwner(owner);
		persistenceContext.setLoadedCollectionOwnerId(ownerId);

		eventSource = new DummyEventSource();
		eventSource.setPersistenceContext(persistenceContext);
	}

	@Test
	public void test() {

		aeq(AbstractCollectionEvent.class, InitializeCollectionEvent.class.getSuperclass());

		InitializeCollectionEvent ice = new InitializeCollectionEvent(persistentCollection, eventSource);

		aeqr(eventSource, ice.getSession());
		aeqr(persistentCollection, ice.getCollection());
		aeqr(ownerId, ice.getAffectedOwnerIdOrNull());
		aeqr(owner, ice.getAffectedOwnerOrNull());
	}
}

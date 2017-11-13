package dum.org.hibernate.collection.spi;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.loader.CollectionAliases;
import org.hibernate.persister.collection.CollectionPersister;
import org.hibernate.type.Type;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyPersistentCollection extends TestEventCollector implements PersistentCollection {

	private boolean wasInitialized;
	private Object owner;

	public Object getOwner() {
		return owner;
	}

	public void setOwner(Object entity) {
		owner = entity;

	}

	public boolean empty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setSnapshot(Serializable key, String role, Serializable snapshot) {
		// TODO Auto-generated method stub

	}

	public void postAction() {
		// TODO Auto-generated method stub

	}

	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	public void beginRead() {
		// TODO Auto-generated method stub

	}

	public boolean endRead() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean afterInitialize() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDirectlyAccessible() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unsetSession(SharedSessionContractImplementor currentSession) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setCurrentSession(SharedSessionContractImplementor session) throws HibernateException {
		// TODO Auto-generated method stub
		return false;
	}

	public void initializeFromCache(CollectionPersister persister, Serializable disassembled, Object owner) {
		// TODO Auto-generated method stub

	}

	public Iterator entries(CollectionPersister persister) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object readFrom(ResultSet rs, CollectionPersister role, CollectionAliases descriptor, Object owner)
			throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getIdentifier(Object entry, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getIndex(Object entry, int i, CollectionPersister persister) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getElement(Object entry) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getSnapshotElement(Object entry, int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void beforeInitialize(CollectionPersister persister, int anticipatedSize) {
		// TODO Auto-generated method stub

	}

	public boolean equalsSnapshot(CollectionPersister persister) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSnapshotEmpty(Serializable snapshot) {
		// TODO Auto-generated method stub
		return false;
	}

	public Serializable disassemble(CollectionPersister persister) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean needsRecreate(CollectionPersister persister) {
		// TODO Auto-generated method stub
		return false;
	}

	public Serializable getSnapshot(CollectionPersister persister) {
		// TODO Auto-generated method stub
		return null;
	}

	public void forceInitialization() {
		testEvents.add(new TestEvent("forceInitialization"));
	}

	public boolean entryExists(Object entry, int i) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean needsInserting(Object entry, int i, Type elemType) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean needsUpdating(Object entry, int i, Type elemType) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isRowUpdatePossible() {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator getDeletes(CollectionPersister persister, boolean indexIsFormula) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isWrapper(Object collection) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean wasInitialized() {
		return wasInitialized;
	}

	public boolean hasQueuedOperations() {
		// TODO Auto-generated method stub
		return false;
	}

	public Iterator queuedAdditionIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection getQueuedOrphans(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	public Serializable getKey() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getRole() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isUnreferenced() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	public void clearDirty() {
		// TODO Auto-generated method stub

	}

	public Serializable getStoredSnapshot() {
		// TODO Auto-generated method stub
		return null;
	}

	public void dirty() {
		// TODO Auto-generated method stub

	}

	public void preInsert(CollectionPersister persister) {
		// TODO Auto-generated method stub

	}

	public void afterRowInsert(CollectionPersister persister, Object entry, int i) {
		// TODO Auto-generated method stub

	}

	public Collection getOrphans(Serializable snapshot, String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setWasInitialized(boolean wasInitialized) {
		this.wasInitialized = wasInitialized;
	}

}

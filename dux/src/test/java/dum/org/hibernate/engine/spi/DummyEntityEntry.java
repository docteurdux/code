package dum.org.hibernate.engine.spi;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.hibernate.LockMode;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.EntityEntryExtraState;
import org.hibernate.engine.spi.EntityKey;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.engine.spi.Status;
import org.hibernate.persister.entity.EntityPersister;

public class DummyEntityEntry implements EntityEntry {

	private Serializable id;

	@Override
	public LockMode getLockMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLockMode(LockMode lockMode) {
		// TODO Auto-generated method stub

	}

	@Override
	public Status getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStatus(Status status) {
		// TODO Auto-generated method stub

	}

	@Override
	public Serializable getId() {
		return id;
	}

	public void setId(Serializable id) {
		this.id = id;
	}

	@Override
	public Object[] getLoadedState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLoadedValue(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void overwriteLoadedStateCollectionValue(String propertyName, PersistentCollection collection) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getDeletedState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDeletedState(Object[] deletedState) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isExistsInDatabase() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPersister getPersister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityKey getEntityKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEntityName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isBeingReplicated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getRowId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void postUpdate(Object entity, Object[] updatedState, Object nextVersion) {
		// TODO Auto-generated method stub

	}

	@Override
	public void postDelete() {
		// TODO Auto-generated method stub

	}

	@Override
	public void postInsert(Object[] insertedState) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isNullifiable(boolean earlyInsert, SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean requiresDirtyCheck(Object entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isModifiableEntity() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void forceLocked(Object entity, Object nextVersion) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isReadOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setReadOnly(boolean readOnly, Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void serialize(ObjectOutputStream oos) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addExtraState(EntityEntryExtraState extraState) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T extends EntityEntryExtraState> T getExtraState(Class<T> extraStateType) {
		// TODO Auto-generated method stub
		return null;
	}

}

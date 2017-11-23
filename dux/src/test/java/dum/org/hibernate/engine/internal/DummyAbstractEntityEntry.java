package dum.org.hibernate.engine.internal;

import java.io.Serializable;

import org.hibernate.EntityMode;
import org.hibernate.LockMode;
import org.hibernate.engine.internal.AbstractEntityEntry;
import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.Status;
import org.hibernate.persister.entity.EntityPersister;

public class DummyAbstractEntityEntry extends AbstractEntityEntry {

	private static final long serialVersionUID = 1L;

	protected DummyAbstractEntityEntry(SessionFactoryImplementor factory, String entityName, Serializable id,
			Status status, Status previousStatus, Object[] loadedState, Object[] deletedState, Object version,
			LockMode lockMode, boolean existsInDatabase, boolean isBeingReplicated,
			PersistenceContext persistenceContext) {
		super(factory, entityName, id, status, previousStatus, loadedState, deletedState, version, lockMode,
				existsInDatabase, isBeingReplicated, persistenceContext);
	}

	public DummyAbstractEntityEntry(Status status, Object[] loadedState, Object rowId, Serializable id, Object version,
			LockMode lockMode, boolean existsInDatabase, EntityPersister persister, boolean disableVersionIncrement,
			PersistenceContext persistenceContext) {
		super(status, loadedState, rowId, id, version, lockMode, existsInDatabase, persister, disableVersionIncrement,
				persistenceContext);
	}

	@SuppressWarnings("deprecation")
	public DummyAbstractEntityEntry(Status status, Object[] loadedState, Object rowId, Serializable id, Object version,
			LockMode lockMode, boolean existsInDatabase, EntityPersister persister, EntityMode entityMode,
			String tenantId, boolean disableVersionIncrement, PersistenceContext persistenceContext) {
		super(status, loadedState, rowId, id, version, lockMode, existsInDatabase, persister, entityMode, tenantId,
				disableVersionIncrement, persistenceContext);
	}

}

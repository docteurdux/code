package dum.org.hibernate.event.internal;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.engine.spi.CascadingAction;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.EntityKey;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.event.internal.AbstractSaveEventListener;
import org.hibernate.event.spi.EventSource;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.type.Type;

public class DummyAbstractSaveEventListener extends AbstractSaveEventListener {

	private static final long serialVersionUID = 1L;

	private CascadingAction cascadeAction;

	@Override
	public CascadingAction getCascadeAction() {
		return cascadeAction;
	}

	public void setCascadeAction(CascadingAction cascadeAction) {
		this.cascadeAction = cascadeAction;
	}

	@Override
	public void cascadeAfterSave(EventSource source, EntityPersister persister, Object entity, Object anything) {
		super.cascadeAfterSave(source, persister, entity, anything);
	}

	@Override
	public void cascadeBeforeSave(EventSource source, EntityPersister persister, Object entity, Object anything) {
		super.cascadeBeforeSave(source, persister, entity, anything);
	}

	@Override
	public Boolean getAssumedUnsaved() {
		return super.getAssumedUnsaved();
	}

	@Override
	public EntityState getEntityState(Object entity, String entityName, EntityEntry entry, SessionImplementor source) {
		return super.getEntityState(entity, entityName, entry, source);
	}

	@Override
	public String getLoggableName(String entityName, Object entity) {
		return super.getLoggableName(entityName, entity);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Map getMergeMap(Object anything) {
		return super.getMergeMap(anything);
	}

	@Override
	public boolean invokeSaveLifecycle(Object entity, EntityPersister persister, EventSource source) {
		return super.invokeSaveLifecycle(entity, persister, source);
	}

	@Override
	public boolean isVersionIncrementDisabled() {
		return super.isVersionIncrementDisabled();
	}

	@Override
	public Serializable performSave(Object entity, Serializable id, EntityPersister persister,
			boolean useIdentityColumn, Object anything, EventSource source, boolean requiresImmediateIdAccess) {
		return super.performSave(entity, id, persister, useIdentityColumn, anything, source, requiresImmediateIdAccess);
	}

	@Override
	public Serializable performSaveOrReplicate(Object entity, EntityKey key, EntityPersister persister,
			boolean useIdentityColumn, Object anything, EventSource source, boolean requiresImmediateIdAccess) {
		return super.performSaveOrReplicate(entity, key, persister, useIdentityColumn, anything, source,
				requiresImmediateIdAccess);
	}

	@Override
	public Serializable saveWithGeneratedId(Object entity, String entityName, Object anything, EventSource source,
			boolean requiresImmediateIdAccess) {
		return super.saveWithGeneratedId(entity, entityName, anything, source, requiresImmediateIdAccess);
	}

	@Override
	public Serializable saveWithRequestedId(Object entity, Serializable requestedId, String entityName, Object anything,
			EventSource source) {
		return super.saveWithRequestedId(entity, requestedId, entityName, anything, source);
	}

	@Override
	public boolean substituteValuesIfNecessary(Object entity, Serializable id, Object[] values,
			EntityPersister persister, SessionImplementor source) {
		return super.substituteValuesIfNecessary(entity, id, values, persister, source);
	}

	@Override
	public boolean visitCollectionsBeforeSave(Object entity, Serializable id, Object[] values, Type[] types,
			EventSource source) {
		return super.visitCollectionsBeforeSave(entity, id, values, types, source);
	}

}

package dum.org.hibernate.engine.spi;

import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.ManagedEntity;

public class DummyManagedEntity implements ManagedEntity {

	private EntityEntry entityEntry;

	@Override
	public Object $$_hibernate_getEntityInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityEntry $$_hibernate_getEntityEntry() {
		return entityEntry;
	}

	@Override
	public void $$_hibernate_setEntityEntry(EntityEntry entityEntry) {
		this.entityEntry = entityEntry;

	}

	@Override
	public ManagedEntity $$_hibernate_getPreviousManagedEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void $$_hibernate_setPreviousManagedEntity(ManagedEntity previous) {
		// TODO Auto-generated method stub

	}

	@Override
	public ManagedEntity $$_hibernate_getNextManagedEntity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void $$_hibernate_setNextManagedEntity(ManagedEntity next) {
		// TODO Auto-generated method stub

	}

}

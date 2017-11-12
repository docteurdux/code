package dum.org.hibernate.engine.spi.PersistenceContext;

import java.io.Serializable;
import java.util.Collection;

import org.hibernate.engine.spi.CachedNaturalIdValueSource;
import org.hibernate.engine.spi.PersistenceContext.NaturalIdHelper;
import org.hibernate.persister.entity.EntityPersister;

public class DummyNaturalIdHelper implements NaturalIdHelper {

	@Override
	public Object[] extractNaturalIdValues(Object[] state, EntityPersister persister) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] extractNaturalIdValues(Object entity, EntityPersister persister) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cacheNaturalIdCrossReferenceFromLoad(EntityPersister persister, Serializable id,
			Object[] naturalIdValues) {
		// TODO Auto-generated method stub

	}

	@Override
	public void manageLocalNaturalIdCrossReference(EntityPersister persister, Serializable id, Object[] state,
			Object[] previousState, CachedNaturalIdValueSource source) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] removeLocalNaturalIdCrossReference(EntityPersister persister, Serializable id, Object[] state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void manageSharedNaturalIdCrossReference(EntityPersister persister, Serializable id, Object[] state,
			Object[] previousState, CachedNaturalIdValueSource source) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeSharedNaturalIdCrossReference(EntityPersister persister, Serializable id,
			Object[] naturalIdValues) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] findCachedNaturalId(EntityPersister persister, Serializable pk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable findCachedNaturalIdResolution(EntityPersister persister, Object[] naturalIdValues) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Serializable> getCachedPkResolutions(EntityPersister persister) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handleSynchronization(EntityPersister persister, Serializable pk, Object entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cleanupFromSynchronizations() {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleEviction(Object object, EntityPersister persister, Serializable identifier) {
		// TODO Auto-generated method stub

	}

}

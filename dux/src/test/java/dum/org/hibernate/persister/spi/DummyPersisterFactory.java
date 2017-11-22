package dum.org.hibernate.persister.spi;

import org.hibernate.HibernateException;
import org.hibernate.cache.spi.access.CollectionRegionAccessStrategy;
import org.hibernate.cache.spi.access.EntityRegionAccessStrategy;
import org.hibernate.cache.spi.access.NaturalIdRegionAccessStrategy;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.persister.collection.CollectionPersister;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.spi.PersisterCreationContext;
import org.hibernate.persister.spi.PersisterFactory;

import com.github.docteurdux.test.RunnableWithArgs;

public class DummyPersisterFactory implements PersisterFactory {

	private static final long serialVersionUID = 1L;

	private RunnableWithArgs<EntityPersister> createEntityPersisterRWA;

	@Override
	public EntityPersister createEntityPersister(PersistentClass entityBinding,
			EntityRegionAccessStrategy entityCacheAccessStrategy,
			NaturalIdRegionAccessStrategy naturalIdCacheAccessStrategy, PersisterCreationContext creationContext)
			throws HibernateException {
		if (createEntityPersisterRWA != null) {
			return createEntityPersisterRWA.run(entityBinding, entityCacheAccessStrategy, naturalIdCacheAccessStrategy,
					creationContext);
		}
		return null;
	}

	public void setCreateEntityPersisterRWA(RunnableWithArgs<EntityPersister> createEntityPersisterRWA) {
		this.createEntityPersisterRWA = createEntityPersisterRWA;
	}

	@Override
	public CollectionPersister createCollectionPersister(Collection collectionBinding,
			CollectionRegionAccessStrategy cacheAccessStrategy, PersisterCreationContext creationContext)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}

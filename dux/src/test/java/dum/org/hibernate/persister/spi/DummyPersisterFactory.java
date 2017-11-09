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

public class DummyPersisterFactory implements PersisterFactory {

	@Override
	public EntityPersister createEntityPersister(PersistentClass entityBinding,
			EntityRegionAccessStrategy entityCacheAccessStrategy,
			NaturalIdRegionAccessStrategy naturalIdCacheAccessStrategy, PersisterCreationContext creationContext)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionPersister createCollectionPersister(Collection collectionBinding,
			CollectionRegionAccessStrategy cacheAccessStrategy, PersisterCreationContext creationContext)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

}

package dum.org.hibernate.loader.collection.plan;

import org.hibernate.engine.spi.LoadQueryInfluencers;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.loader.collection.CollectionInitializer;
import org.hibernate.loader.collection.plan.AbstractBatchingCollectionInitializerBuilder;
import org.hibernate.persister.collection.QueryableCollection;

public class DummyAbstractBatchingCollectionInitializerBuilder extends AbstractBatchingCollectionInitializerBuilder {

	@Override
	protected CollectionInitializer createRealBatchingCollectionInitializer(QueryableCollection persister,
			int maxBatchSize, SessionFactoryImplementor factory, LoadQueryInfluencers influencers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected CollectionInitializer createRealBatchingOneToManyInitializer(QueryableCollection persister,
			int maxBatchSize, SessionFactoryImplementor factory, LoadQueryInfluencers influencers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionInitializer buildNonBatchingLoader(QueryableCollection persister,
			SessionFactoryImplementor factory, LoadQueryInfluencers influencers) {
		return super.buildNonBatchingLoader(persister, factory, influencers);
	}

}

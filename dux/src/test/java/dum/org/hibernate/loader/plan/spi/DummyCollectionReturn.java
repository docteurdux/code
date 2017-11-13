package dum.org.hibernate.loader.plan.spi;

import org.hibernate.loader.PropertyPath;
import org.hibernate.loader.plan.spi.CollectionFetchableElement;
import org.hibernate.loader.plan.spi.CollectionFetchableIndex;
import org.hibernate.loader.plan.spi.CollectionReturn;
import org.hibernate.persister.collection.CollectionPersister;

public class DummyCollectionReturn implements CollectionReturn {

	@Override
	public String getQuerySpaceUid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionPersister getCollectionPersister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionFetchableIndex getIndexGraph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionFetchableElement getElementGraph() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyPath getPropertyPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean allowElementJoin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean allowIndexJoin() {
		// TODO Auto-generated method stub
		return false;
	}

}

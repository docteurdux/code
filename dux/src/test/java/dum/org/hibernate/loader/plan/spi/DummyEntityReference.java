package dum.org.hibernate.loader.plan.spi;

import org.hibernate.loader.PropertyPath;
import org.hibernate.loader.plan.spi.BidirectionalEntityReference;
import org.hibernate.loader.plan.spi.EntityIdentifierDescription;
import org.hibernate.loader.plan.spi.EntityReference;
import org.hibernate.loader.plan.spi.Fetch;
import org.hibernate.persister.entity.EntityPersister;

public class DummyEntityReference implements EntityReference {

	@Override
	public PropertyPath getPropertyPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fetch[] getFetches() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BidirectionalEntityReference[] getBidirectionalEntityReferences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityReference resolveEntityReference() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQuerySpaceUid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPersister getEntityPersister() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityIdentifierDescription getIdentifierDescription() {
		// TODO Auto-generated method stub
		return null;
	}

}

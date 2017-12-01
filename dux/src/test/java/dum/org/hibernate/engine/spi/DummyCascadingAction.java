package dum.org.hibernate.engine.spi;

import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.CascadingAction;
import org.hibernate.event.spi.EventSource;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.type.CollectionType;
import org.hibernate.type.Type;

public class DummyCascadingAction implements CascadingAction {

	@Override
	public void cascade(EventSource session, Object child, String entityName, Object anything,
			boolean isCascadeDeleteEnabled) throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator getCascadableChildrenIterator(EventSource session, CollectionType collectionType,
			Object collection) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteOrphans() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean requiresNoCascadeChecking() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void noCascade(EventSource session, Object parent, EntityPersister persister, Type propertyType,
			int propertyIndex) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean performOnLazyProperty() {
		// TODO Auto-generated method stub
		return false;
	}

}

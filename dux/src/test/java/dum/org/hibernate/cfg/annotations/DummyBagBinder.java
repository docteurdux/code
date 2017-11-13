package dum.org.hibernate.cfg.annotations;

import org.hibernate.cfg.annotations.BagBinder;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.PersistentClass;

public class DummyBagBinder extends BagBinder {

	@Override
	public Collection createCollection(PersistentClass persistentClass) {
		return super.createCollection(persistentClass);
	}
	
}

package dum.org.hibernate.cfg.annotations;

import org.hibernate.cfg.annotations.ArrayBinder;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.PersistentClass;

public class DummyArrayBinder extends ArrayBinder {
	
	@Override
	public Collection createCollection(PersistentClass persistentClass) {
		return super.createCollection(persistentClass);
	}
	
}

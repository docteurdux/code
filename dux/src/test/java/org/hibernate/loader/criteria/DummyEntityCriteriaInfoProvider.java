package org.hibernate.loader.criteria;

import java.io.Serializable;

import org.hibernate.persister.entity.PropertyMapping;
import org.hibernate.persister.entity.Queryable;
import org.hibernate.type.Type;

public class DummyEntityCriteriaInfoProvider {

	private EntityCriteriaInfoProvider instance;

	public DummyEntityCriteriaInfoProvider(Queryable persister) {
		instance = new EntityCriteriaInfoProvider(persister);
	}

	public String getName() {
		return instance.getName();
	}

	public Serializable[] getSpaces() {
		return instance.getSpaces();
	}

	public PropertyMapping getPropertyMapping() {
		return instance.getPropertyMapping();
	}

	public Type getType(String relativePath) {
		return instance.getType(relativePath);
	}

}

package org.hibernate.proxy.map;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.engine.spi.SharedSessionContractImplementor;

public class DummyMapLazyInitializer {

	private MapLazyInitializer instance;

	public DummyMapLazyInitializer(String entityName, Serializable id, SharedSessionContractImplementor session) {
		instance = new MapLazyInitializer(entityName, id, session);
	}

	@SuppressWarnings("rawtypes")
	public Map getMap() {
		return instance.getMap();
	}

	@SuppressWarnings("rawtypes")
	public Class getPersistentClass() {
		return instance.getPersistentClass();
	}

}

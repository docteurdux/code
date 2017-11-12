package com.github.docteurdux.test;

import java.util.HashMap;
import java.util.Map;

public class Instances {

	private Map<Class<?>, Object> map = new HashMap<>();

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz) {
		return (T) map.get(clazz);
	}

	public <T> void set(T instance) {
		map.put(instance.getClass(), instance);
	}

	public <T> void set(Class<T> clazz, T instance) {
		map.put(clazz, instance);
	}
}

package com.github.docteurdux.spring.security.notes;

import java.util.HashSet;
import java.util.Set;

public abstract class N {

	Set<Class<?>> classes = new HashSet<>();

	public void todo(Class<?>... classes) {
		for (Class<?> clazz : classes) {
			this.classes.add(clazz);
		}
	}

	public Set<Class<?>> getClasses() {
		return classes;
	}

}

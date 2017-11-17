package dum.javax.persistence;

import java.lang.annotation.Annotation;

import javax.persistence.Entity;

public abstract class DummyEntity implements Entity {

	@Override
	public Class<? extends Annotation> annotationType() {
		return null;
	}

	@Override
	public String name() {
		return null;
	}

}

package dum.org.hibernate.annotations.common.reflection;

import java.lang.annotation.Annotation;

import org.hibernate.annotations.common.reflection.XAnnotatedElement;

public class DummyXAnnotatedElement implements XAnnotatedElement {

	@Override
	public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Annotation> boolean isAnnotationPresent(Class<T> annotationType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Annotation[] getAnnotations() {
		// TODO Auto-generated method stub
		return null;
	}

}

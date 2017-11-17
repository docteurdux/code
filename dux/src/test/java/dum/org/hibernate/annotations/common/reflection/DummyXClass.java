package dum.org.hibernate.annotations.common.reflection;

import java.lang.annotation.Annotation;
import java.util.List;

import org.hibernate.annotations.common.reflection.Filter;
import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.annotations.common.reflection.XMethod;
import org.hibernate.annotations.common.reflection.XProperty;

public class DummyXClass implements XClass {

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

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XClass getSuperclass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XClass[] getInterfaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInterface() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAbstract() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrimitive() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnum() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAssignableFrom(XClass c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<XProperty> getDeclaredProperties(String accessType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<XProperty> getDeclaredProperties(String accessType, Filter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<XMethod> getDeclaredMethods() {
		// TODO Auto-generated method stub
		return null;
	}

}

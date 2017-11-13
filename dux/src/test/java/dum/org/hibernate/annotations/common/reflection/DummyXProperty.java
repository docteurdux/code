package dum.org.hibernate.annotations.common.reflection;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.annotations.common.reflection.XProperty;

public class DummyXProperty implements XProperty {

	private Map<Class<?>, Object> annotations = new HashMap<>();

	@Override
	public XClass getDeclaringClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCollection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isArray() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Class<? extends Collection> getCollectionClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XClass getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XClass getElementClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XClass getClassOrElementClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XClass getMapKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getModifiers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAccessible(boolean accessible) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object invoke(Object target, Object... parameters) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object invoke(Object target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isTypeResolved() {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
		return (T) annotations.get(annotationType);
	}

	@Override
	public <T extends Annotation> boolean isAnnotationPresent(Class<T> annotationType) {
		return annotations.containsKey(annotationType);
	}

	@Override
	public Annotation[] getAnnotations() {
		return annotations.values().toArray(new Annotation[] {});
	}

	public <T extends Annotation> void setAnnotation(Class<T> annotationType, T annotation) {
		annotations.put(annotationType, annotation);
	}

}

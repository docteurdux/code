package org.hibernate.annotations.common.reflection.java;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;

import org.hibernate.annotations.common.reflection.Filter;
import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.annotations.common.reflection.XMethod;
import org.hibernate.annotations.common.reflection.XProperty;
import org.hibernate.annotations.common.reflection.java.generics.TypeEnvironment;

public class DummyJavaXClass {

	private JavaXClass javaXClass;

	public DummyJavaXClass(@SuppressWarnings("rawtypes") Class clazz, TypeEnvironment env,
			JavaReflectionManager factory) {
		javaXClass = new JavaXClass(clazz, env, factory);

	}

	public JavaXClass leak() {
		return javaXClass;
	}

	public List<XMethod> getDeclaredMethods() {
		return javaXClass.getDeclaredMethods();
	}

	public List<XProperty> getDeclaredProperties(String accessType) {
		return javaXClass.getDeclaredProperties(accessType);
	}

	public List<XProperty> getDeclaredProperties(String accessType, Filter filter) {
		return javaXClass.getDeclaredProperties(accessType, filter);
	}

	public XClass[] getInterfaces() {
		return javaXClass.getInterfaces();
	}

	public String getName() {
		return javaXClass.getName();
	}

	public XClass getSuperclass() {
		return javaXClass.getSuperclass();
	}

	public boolean isAbstract() {
		return javaXClass.isAbstract();
	}

	public boolean isAssignableFrom(XClass c) {
		return javaXClass.isAssignableFrom(c);
	}

	public boolean isEnum() {
		return javaXClass.isEnum();
	}

	public boolean isInterface() {
		return javaXClass.isInterface();
	}

	public boolean isPrimitive() {
		return javaXClass.isPrimitive();
	}

	public Class<?> toClass() {
		return javaXClass.toClass();
	}

	public String toString() {
		return javaXClass.toString();
	}

	public boolean equals(Object x) {
		return javaXClass.equals(x);
	}

	public <T extends Annotation> T getAnnotation(Class<T> annotationType) {
		return javaXClass.getAnnotation(annotationType);
	}

	public Annotation[] getAnnotations() {
		return javaXClass.getAnnotations();
	}

	public int hashCode() {
		return javaXClass.hashCode();
	}

	public <T extends Annotation> boolean isAnnotationPresent(Class<T> annotationType) {
		return javaXClass.isAnnotationPresent(annotationType);
	}

	public AnnotatedElement toAnnotatedElement() {
		return javaXClass.toAnnotatedElement();
	}

}

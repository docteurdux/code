package dum.org.hibernate.annotations.common.reflection;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.annotations.common.reflection.AnnotationReader;
import org.hibernate.annotations.common.reflection.ClassLoaderDelegate;
import org.hibernate.annotations.common.reflection.ClassLoadingException;
import org.hibernate.annotations.common.reflection.ReflectionManager;
import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.annotations.common.reflection.XMethod;
import org.hibernate.annotations.common.reflection.XPackage;
import org.hibernate.annotations.common.reflection.java.JavaReflectionManager;

public class DummyReflectionManager implements ReflectionManager {

	JavaReflectionManager javaReflectionManager = new JavaReflectionManager();
	
	@SuppressWarnings("rawtypes")
	private Map defaults = new HashMap<>();

	public JavaReflectionManager getJavaReflectionManager() {
		return javaReflectionManager;
	}

	@Override
	public void injectClassLoaderDelegate(ClassLoaderDelegate delegate) {
		// TODO Auto-generated method stub

	}

	@Override
	public ClassLoaderDelegate getClassLoaderDelegate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> XClass toXClass(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class toClass(XClass xClazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Method toMethod(XMethod method) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> XClass classForName(String name, Class<T> caller) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XClass classForName(String name) throws ClassLoadingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XPackage packageForName(String packageName) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> boolean equals(XClass class1, Class<T> class2) {
		return javaReflectionManager.equals(class1, class2);
	}

	@Override
	public AnnotationReader buildAnnotationReader(AnnotatedElement annotatedElement) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Map getDefaults() {
		return defaults;
	}

}

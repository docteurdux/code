package dum.org.hibernate.boot.registry.classloading.spi;

import java.io.InputStream;
import java.lang.reflect.InvocationHandler;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.boot.registry.classloading.spi.ClassLoadingException;

import dux.org.hibernate.boot.registry.selector.internal.StrategySelectorImplTest.D;

public class DummyClassLoaderService implements ClassLoaderService {

	private static final long serialVersionUID = 1L;

	private Map<String, Class<?>> forNames = new HashMap<>();

	public void stop() {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	public <T> Class<T> classForName(String className) {

		if (forNames.containsKey(className)) {
			return (Class<T>) forNames.get(className);
		}

		try {
			return (Class<T>) Class.forName(className);
		} catch (ClassNotFoundException e) {
			throw new ClassLoadingException(e.getMessage(), e);
		}
	}

	public URL locateResource(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public InputStream locateResourceStream(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<URL> locateResources(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public <S> Collection<S> loadJavaServices(Class<S> serviceContract) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T generateProxy(InvocationHandler handler, Class... interfaces) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T workWithClassLoader(Work<T> work) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Class<?>> getForNames() {
		return forNames;
	}

}

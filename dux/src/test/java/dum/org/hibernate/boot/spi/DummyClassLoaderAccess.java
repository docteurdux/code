package dum.org.hibernate.boot.spi;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.spi.ClassLoaderAccess;

public class DummyClassLoaderAccess implements ClassLoaderAccess {

	private Map<String, Class<?>> classes = new HashMap<>();
	private Map<String, URL> urls = new HashMap<>();

	@SuppressWarnings("unchecked")
	@Override
	public <T> Class<T> classForName(String name) {
		return (Class<T>) classes.get(name);
	}

	@Override
	public URL locateResource(String resourceName) {
		return urls.get(resourceName);
	}

	public void setClass(String name, Class<?> clazz) {
		classes.put(name, clazz);
	}

	public void setURL(String name, URL url) {
		urls.put(name, url);
	}

}

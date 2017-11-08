package dum.java.lang;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import dum.java.util.DummyEnumeration;

public class DummyClassLoader extends ClassLoader {

	private ClassLoader parent;

	private Map<String, byte[]> classes = new HashMap<>();
	private Map<String, URL> resources = new HashMap<>();

	public void setParent(ClassLoader parent) {
		this.parent = parent;
	}

	public Map<String, byte[]> getClasses() {
		return classes;
	}

	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		byte[] bytes = classes.get(name);
		if (bytes == null) {
			if (parent != null) {
				return parent.loadClass(name);
			} else {
				return super.loadClass(name);
			}
		} else {
			Class<?> c = defineClass(name, bytes, 0, bytes.length);
			resolveClass(c);
			return super.loadClass(name);
		}
	}

	public Map<String, URL> getResources() {
		return resources;
	}

	@Override
	public URL getResource(String name) {
		URL resource = resources.get(name);
		if (resource != null) {
			return resource;
		} else {
			if (parent != null) {
				return parent.getResource(name);
			} else {
				return super.getResource(name);
			}
		}
	}

	@Override
	public Enumeration<URL> getResources(String name) throws IOException {
		return new DummyEnumeration<URL>(getResource(name));
	}

}

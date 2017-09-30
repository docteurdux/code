package dum.org.springframework.core.io;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class DummyResourceLoader implements ResourceLoader {

	private ClassLoader classLoader;
	private Map<String, Resource> resources = new HashMap<>();

	@Override
	public Resource getResource(String location) {
		return resources.get(location);
	}

	@Override
	public ClassLoader getClassLoader() {
		return classLoader;
	}

	public Map<String, Resource> getResources() {
		return resources;
	}

	public void setResources(Map<String, Resource> resources) {
		this.resources = resources;
	}

	public void setClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}
	
	

}

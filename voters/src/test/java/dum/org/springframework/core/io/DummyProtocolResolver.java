package dum.org.springframework.core.io;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class DummyProtocolResolver implements ProtocolResolver {

<<<<<<< HEAD
	private Map<String, Resource> resources = new HashMap<String, Resource>();

	@Override
	public Resource resolve(String location, ResourceLoader resourceLoader) {
		Resource resource = resources.get(location);
		if (resource == null) {
			System.out.println("No resource found for " + location);
		}
		return resource;
	}

	public Map<String, Resource> getResources() {
		return resources;
=======
	private Map<String, ResourceLoader> resourceLoaders = new HashMap<>();

	@Override
	public Resource resolve(String location, ResourceLoader resourceLoader) {
		return resourceLoaders.get(location).getResource(location);
	}

	public Map<String, ResourceLoader> getResourceLoaders() {
		return resourceLoaders;
	}

	public void setResourceLoaders(Map<String, ResourceLoader> resourceLoaders) {
		this.resourceLoaders = resourceLoaders;
>>>>>>> 748c8fa8be898c4eceb904d2b4b199cb90740f91
	}

}

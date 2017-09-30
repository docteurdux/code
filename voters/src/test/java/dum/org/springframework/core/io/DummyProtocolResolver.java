package dum.org.springframework.core.io;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class DummyProtocolResolver implements ProtocolResolver {

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
	}

}

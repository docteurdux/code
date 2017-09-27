package dum.org.springframework.core.io;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class DummyProtocolResolver implements ProtocolResolver {

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
	}

}

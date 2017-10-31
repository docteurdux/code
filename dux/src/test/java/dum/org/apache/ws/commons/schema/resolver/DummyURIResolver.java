package dum.org.apache.ws.commons.schema.resolver;

import java.util.HashMap;
import java.util.Map;

import org.apache.ws.commons.schema.resolver.URIResolver;
import org.xml.sax.InputSource;

public class DummyURIResolver implements URIResolver {

	Map<String, Map<String, Map<String, InputSource>>> map = new HashMap<>();

	@Override
	public InputSource resolveEntity(String targetNamespace, String schemaLocation, String baseUri) {
		Map<String, Map<String, InputSource>> a = map.get(targetNamespace);
		if (a == null) {
			return null;
		}
		Map<String, InputSource> b = a.get(schemaLocation);
		if (b == null) {
			return null;
		}
		return b.get(baseUri);
	}

	public void set(String targetNamespace, String schemaLocation, String baseUri, InputSource source) {
		Map<String, Map<String, InputSource>> a = map.get(targetNamespace);
		if (a == null) {
			a = new HashMap<>();
			map.put(targetNamespace, a);

		}
		Map<String, InputSource> b = a.get(schemaLocation);
		if (b == null) {
			b = new HashMap<>();
			a.put(schemaLocation, b);
		}
		b.put(baseUri, source);
	}

}

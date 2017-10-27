package dum.org.apache.ws.commons.schema.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.ws.commons.schema.utils.NamespacePrefixList;

public class DummyNamespacePrefixList implements NamespacePrefixList {

	List<String> prefixes = new ArrayList<>();
	List<String> namespaceURIs = new ArrayList<>();

	@Override
	public String getNamespaceURI(String prefix) {
		for (int i = 0; i < prefixes.size(); ++i) {
			String candidate = prefixes.get(i);
			if (candidate == null && prefix == null) {
				return namespaceURIs.get(i);
			} else if (candidate != null && candidate.equals(prefix)) {
				return namespaceURIs.get(i);
			}
		}
		return null;
	}

	@Override
	public String getPrefix(String namespaceURI) {
		for (int i = 0; i < namespaceURIs.size(); ++i) {
			String candidate = namespaceURIs.get(i);
			if (candidate == null && namespaceURI == null) {
				return prefixes.get(i);
			}
			if (candidate != null && candidate.equals(namespaceURI)) {
				return prefixes.get(i);
			}
		}
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Iterator getPrefixes(String namespaceURI) {
		List<String> matches = new ArrayList<>();
		for (int i = 0; i < namespaceURIs.size(); ++i) {
			String candidate = namespaceURIs.get(i);
			if (candidate == null && namespaceURI == null) {
				matches.add(prefixes.get(i));
			} else if (candidate != null && candidate.equals(namespaceURI)) {
				matches.add(prefixes.get(i));
			}
		}
		return matches.iterator();
	}

	@Override
	public String[] getDeclaredPrefixes() {
		return prefixes.toArray(new String[] {});
	}

	public void add(String prefix, String namespaceURI) {
		prefixes.add(prefix);
		namespaceURIs.add(namespaceURI);
	}

}

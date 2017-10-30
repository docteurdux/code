package dux.org.apache.ws.commons.schema.utils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.commons.schema.utils.PrefixCollector;
import org.junit.Test;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;

public class PrefixCollectorTest extends AbstractTest {

	public static class CollectedItem {

		private String prefix;
		private String nsuri;

		public CollectedItem(String prefix, String nsuri) {
			this.prefix = prefix;
			this.nsuri = nsuri;
		}

		public String getPrefix() {
			return prefix;
		}

		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}

		public String getNsuri() {
			return nsuri;
		}

		public void setNsuri(String nsuri) {
			this.nsuri = nsuri;
		}

	}

	@Test
	public void test() throws DOMException, ParserConfigurationException {

		List<CollectedItem> collectedItems = new ArrayList<>();

		Element node = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument().createElement("element");
		PrefixCollector collector = new PrefixCollector() {
			@Override
			protected void declare(String prefix, String nsuri) {
				collectedItems.add(new CollectedItem(prefix, nsuri));
			}
		};
		collector.searchAllPrefixDeclarations(node);
		collector.searchLocalPrefixDeclarations(node);
	}
}

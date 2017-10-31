package dux.org.apache.ws.commons.schema.utils;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.commons.schema.constants.Constants;
import org.apache.ws.commons.schema.utils.PrefixCollector;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PrefixCollectorTest extends AbstractTest {

	private List<CollectedItem> collectedItems;
	private Document document;
	private PrefixCollector collector;

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

	@Before
	public void before() throws ParserConfigurationException {
		collectedItems = new ArrayList<>();

		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		collector = new PrefixCollector() {
			@Override
			protected void declare(String prefix, String nsuri) {
				collectedItems.add(new CollectedItem(prefix, nsuri));
			}
		};
	}

	@Test
	public void test1() throws DOMException {

		Comment comment = document.createComment("comment");
		collector.searchLocalPrefixDeclarations(comment);
		aeq(0, collectedItems.size());
	}

	@Test
	public void test2() throws DOMException {
		collector.searchLocalPrefixDeclarations(document);
		aeq(0, collectedItems.size());
	}

	@Test
	public void test3() throws DOMException {
		Element element = document.createElement("element");
		collector.searchLocalPrefixDeclarations(element);
		aeq(0, collectedItems.size());
	}

	@Test
	public void test4() throws DOMException {
		Element element = document.createElement("element");
		element.setAttribute("attributeName", "attributeValue");
		collector.searchLocalPrefixDeclarations(element);
		aeq(0, collectedItems.size());
	}

	@Test
	public void test5() throws DOMException {
		Element element = document.createElementNS("namespace", "element");
		element.setAttributeNS(Constants.XMLNS_ATTRIBUTE_NS_URI, Constants.XMLNS_ATTRIBUTE, "attributeValue");
		collector.searchLocalPrefixDeclarations(element);
		aeq(1, collectedItems.size());
		aeq("attributeValue", collectedItems.get(0).getNsuri());
		aeq("", collectedItems.get(0).getPrefix());
	}

	@Test
	public void test6() throws DOMException {
		Element element = document.createElementNS("namespace", "element");
		element.setAttributeNS(Constants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:foo", "attributeValue");
		collector.searchLocalPrefixDeclarations(element);
		aeq(1, collectedItems.size());
		aeq("attributeValue", collectedItems.get(0).getNsuri());
		aeq("foo", collectedItems.get(0).getPrefix());
	}

	@Test
	public void test7() throws DOMException {
		collector.searchAllPrefixDeclarations(document);
		aeq(0, collectedItems.size());
	}

	@Test
	public void test8() throws DOMException {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		collector.searchAllPrefixDeclarations(element);
		aeq(0, collectedItems.size());
	}

}

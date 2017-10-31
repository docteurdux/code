package dux.org.apache.ws.commons.schema.utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.commons.schema.utils.NodeNamespaceContext;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;

public class NodeNamespaceContextTest extends AbstractTest {

	private Document document;

	@Before
	public void before() throws ParserConfigurationException {
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	}

	@Test
	public void test1() throws DOMException {
		Element element = document.createElement("element");
		// NodeNamespaceContext context =
		// NodeNamespaceContext.getNamespaceContext(element);
		// NodeNamespaceContext.getNamespacePrefix(element, "namespace");
		// NodeNamespaceContext.getNamespaceURI(element, "prefix");
	}
}

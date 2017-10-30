package dux.org.apache.ws.commons.schema.utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.commons.schema.utils.NodeNamespaceContext;
import org.junit.Test;
import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

import com.github.docteurdux.test.AbstractTest;

public class NodeNamespaceContextTest extends AbstractTest {
	@Test
	public void test() throws DOMException, ParserConfigurationException {
		Node node = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument().createElement("element");
		NodeNamespaceContext context = NodeNamespaceContext.getNamespaceContext(node);
	}
}

package dux.org.apache.ws.commons.schema.utils;

import java.util.Iterator;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.commons.schema.constants.Constants;
import org.apache.ws.commons.schema.utils.NamespacePrefixList;
import org.apache.ws.commons.schema.utils.NodeNamespaceContext;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;

public class NodeNamespaceContextTest extends AbstractTest {

	private Document document;
	private Element element;
	private String namespace;

	@Before
	public void before() throws ParserConfigurationException {

		namespace = "namespace";

		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		element = document.createElement("element");
	}

	@Test
	public void test1() {
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		aeq(0, context.getDeclaredPrefixes().length);
	}

	@Test
	public void test2() {
		aeq("http://www.w3.org/XML/1998/namespace", NodeNamespaceContext.getNamespaceURI(element, "xml"));
	}

	@Test
	public void test3() {
		aeq("http://www.w3.org/2000/xmlns/", NodeNamespaceContext.getNamespaceURI(element, "xmlns"));
	}

	@Test
	public void test4() {
		an(NodeNamespaceContext.getNamespaceURI(element, ""));
	}

	@Test
	public void test5() {
		an(NodeNamespaceContext.getNamespaceURI(element, "prefix"));
	}

	@Test
	public void test6() {
		an(NodeNamespaceContext.getNamespacePrefix(element, namespace));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test7() {
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		context.getNamespaceURI(null);
	}

	@Test
	public void test8() {
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		aeq(Constants.XML_NS_URI, context.getNamespaceURI(Constants.XML_NS_PREFIX));
	}

	@Test
	public void test9() {
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		aeq(Constants.XMLNS_ATTRIBUTE_NS_URI, context.getNamespaceURI(Constants.XMLNS_ATTRIBUTE));
	}

	@Test
	public void test10() {
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		aeq("", context.getNamespaceURI("prefix"));
	}

	@Test
	public void test11() {
		element.setAttributeNS(Constants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:foo", "fooNS");
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		aeq("fooNS", context.getNamespaceURI("foo"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test12() {
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		context.getPrefix(null);
	}

	@Test
	public void test13() {
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		aeq(Constants.XML_NS_PREFIX, context.getPrefix(Constants.XML_NS_URI));
	}

	@Test
	public void test14() {
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		aeq(Constants.XMLNS_ATTRIBUTE, context.getPrefix(Constants.XMLNS_ATTRIBUTE_NS_URI));
	}

	@Test
	public void test15() {
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		an(context.getPrefix("namespace"));
	}

	@Test
	public void test16() {
		element.setAttributeNS(Constants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:foo", "fooNS");
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		an(context.getPrefix("fooNS_"));
	}

	@Test
	public void test17() {
		element.setAttributeNS(Constants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:foo", "fooNS");
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		aeq("foo", context.getPrefix("fooNS"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test18() {
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);
		context.getPrefixes(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test19() {

		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);

		@SuppressWarnings("rawtypes")
		Iterator it = context.getPrefixes(Constants.XML_NS_URI);

		aeq(Constants.XML_NS_PREFIX, it.next());
		af(it.hasNext());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test20() {

		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);

		@SuppressWarnings("rawtypes")
		Iterator it = context.getPrefixes(Constants.XMLNS_ATTRIBUTE_NS_URI);

		aeq(Constants.XMLNS_ATTRIBUTE, it.next());
		af(it.hasNext());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test21() {

		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);

		@SuppressWarnings("rawtypes")
		Iterator it = context.getPrefixes("fooNS_");

		af(it.hasNext());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test22() {

		element.setAttributeNS(Constants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:foo", "fooNS");
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);

		@SuppressWarnings("rawtypes")
		Iterator it = context.getPrefixes("fooNS_");

		af(it.hasNext());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test23() {

		element.setAttributeNS(Constants.XMLNS_ATTRIBUTE_NS_URI, "xmlns:foo", "fooNS");
		NamespacePrefixList context = NodeNamespaceContext.getNamespaceContext(element);

		@SuppressWarnings("rawtypes")
		Iterator it = context.getPrefixes("fooNS");

		aeq("foo", it.next());
		af(it.hasNext());
	}
}

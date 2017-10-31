package dux.org.apache.ws.commons.schema.utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.commons.schema.utils.XDOMUtil;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XDOMUtilTest extends AbstractTest {

	private Document document;

	@Before
	public void before() throws ParserConfigurationException {
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	}

	@Test
	public void test1() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);
		an(XDOMUtil.getFirstChildElementNS(parent, "namespace"));
	}

	@Test
	public void test2() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Comment comment = document.createComment("comment");
		parent.appendChild(comment);

		an(XDOMUtil.getFirstChildElementNS(parent, "namespace"));
	}

	@Test
	public void test3() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child = document.createElementNS("namespace", "child");
		parent.appendChild(child);

		an(XDOMUtil.getFirstChildElementNS(parent, "namespace_"));
	}

	@Test
	public void test4() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child = document.createElement("child");
		parent.appendChild(child);

		an(XDOMUtil.getFirstChildElementNS(parent, "namespace"));
	}

	@Test
	public void test5() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child = document.createElementNS("namespace", "child");
		parent.appendChild(child);

		aeqr(child, XDOMUtil.getFirstChildElementNS(parent, "namespace"));
	}

	@Test
	public void test6() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		an(XDOMUtil.getNextSiblingElementNS(child1, "namespace"));
	}

	@Test
	public void test7() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Comment comment = document.createComment("comment");
		parent.appendChild(comment);

		an(XDOMUtil.getNextSiblingElementNS(child1, "namespace"));
	}

	@Test
	public void test8() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElement("child2");
		parent.appendChild(child2);

		an(XDOMUtil.getNextSiblingElementNS(child1, "namespace"));
	}

	@Test
	public void test9() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace_", "child2");
		parent.appendChild(child2);

		an(XDOMUtil.getNextSiblingElementNS(child1, "namespace"));
	}

	@Test
	public void test10() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		aeqr(child2, XDOMUtil.getNextSiblingElementNS(child1, "namespace"));
	}

	@Test
	public void test11() {
		Element parent = document.createElement("parent");
		document.appendChild(parent);
		af(XDOMUtil.anyElementsWithNameNS(parent, "namespace", "child1"));
	}

	@Test
	public void test12() {
		Element parent = document.createElement("parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1_");
		parent.appendChild(child1);

		af(child1.getLocalName().equals("child1"));

		af(XDOMUtil.anyElementsWithNameNS(parent, "namespace", "child1"));
	}

	@Test
	public void test14() {
		Element parent = document.createElement("parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		at(child1.getLocalName().equals("child1"));
		at(child1.getNamespaceURI().equals("namespace"));

		at(XDOMUtil.anyElementsWithNameNS(parent, "namespace", "child1"));
	}

}

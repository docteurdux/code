package dux.org.apache.ws.commons.schema.utils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.commons.schema.utils.DOMUtil;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class DOMUtilTest extends AbstractTest {

	private Document document;

	@Before
	public void before() throws ParserConfigurationException {
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	}

	@Test
	public void test1() {
		an(DOMUtil.getFirstChildElement(document));
	}

	@Test
	public void test2() {
		Element element = document.createElement("element");
		document.appendChild(element);
		aeqr(element, DOMUtil.getFirstChildElement(document));
	}

	@Test
	public void test3() {
		Comment comment = document.createComment("comment");
		document.appendChild(comment);
		Element element = document.createElement("element");
		document.appendChild(element);
		aeqr(element, DOMUtil.getFirstChildElement(document));
	}

	@Test
	public void test4() {
		an(DOMUtil.getLastChildElement(document));

	}

	@Test
	public void test5() {
		Element element = document.createElement("element");
		document.appendChild(element);
		aeq(element, DOMUtil.getLastChildElement(document));

	}

	@Test
	public void test6() {
		Element element = document.createElement("element");
		document.appendChild(element);
		Comment comment = document.createComment("comment");
		document.appendChild(comment);
		aeq(element, DOMUtil.getLastChildElement(document));

	}

	@Test
	public void test7() {
		an(DOMUtil.getNextSiblingElement(document));
	}

	@Test
	public void test8() {

		Element parent = document.createElement("parent");
		document.appendChild(parent);

		Element child1 = document.createElement("child1");
		parent.appendChild(child1);

		Element child2 = document.createElement("child2");
		parent.appendChild(child2);

		aeqr(child2, DOMUtil.getNextSiblingElement(child1));
	}

	@Test
	public void test9() {

		Element parent = document.createElement("parent");
		document.appendChild(parent);

		Element child1 = document.createElement("child1");
		parent.appendChild(child1);

		Comment comment = document.createComment("comment");
		parent.appendChild(comment);

		Element child2 = document.createElement("child2");
		parent.appendChild(child2);

		aeqr(child2, DOMUtil.getNextSiblingElement(child1));
	}

	@Test
	public void test10() {
		an(DOMUtil.getFirstChildElement(document, "element"));
	}

	@Test
	public void test11() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		aeqr(element, DOMUtil.getFirstChildElement(document, "element"));
	}

	@Test
	public void test12() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getFirstChildElement(document, "element1"));
	}

	@Test
	public void test13() {
		Comment comment = document.createComment("comment");
		document.appendChild(comment);
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		aeqr(element, DOMUtil.getFirstChildElement(document, "element"));
	}

	@Test
	public void test14() {
		an(DOMUtil.getLastChildElement(document, "element"));
	}

	@Test
	public void test15() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		aeqr(element, DOMUtil.getLastChildElement(document, "element"));
	}

	@Test
	public void test16() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getLastChildElement(document, "element1"));
	}

	@Test
	public void test17() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		Comment comment = document.createComment("comment");
		document.appendChild(comment);
		aeqr(element, DOMUtil.getLastChildElement(document, "element"));
	}

	@Test
	public void test18() {
		an(DOMUtil.getNextSiblingElement(document, "element"));
	}

	@Test
	public void test19() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		aeqr(child2, DOMUtil.getNextSiblingElement(child1, "child2"));
	}

	@Test
	public void test20() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Comment comment = document.createComment("comment");
		parent.appendChild(comment);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		aeqr(child2, DOMUtil.getNextSiblingElement(child1, "child2"));
	}

	@Test
	public void test21() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		Element child3 = document.createElementNS("namespace", "child3");
		parent.appendChild(child3);

		aeqr(child3, DOMUtil.getNextSiblingElement(child1, "child3"));
	}

	@Test
	public void test22() {
		an(DOMUtil.getFirstChildElementNS(document, "namespace", "element"));
	}

	@Test
	public void test23() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		aeqr(element, DOMUtil.getFirstChildElementNS(document, "namespace", "element"));
	}

	@Test
	public void test24() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getFirstChildElementNS(document, "namespace", "element1"));
	}

	@Test
	public void test25() {
		Comment comment = document.createComment("comment");
		document.appendChild(comment);
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		aeqr(element, DOMUtil.getFirstChildElementNS(document, "namespace", "element"));
	}

	@Test
	public void test26() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getFirstChildElementNS(document, "namespace1", "element"));
	}

	@Test
	public void test27() {
		Element element = document.createElement("element");
		document.appendChild(element);
		an(DOMUtil.getFirstChildElementNS(document, "namespace", "element"));
	}

	@Test
	public void test28() {
		an(DOMUtil.getLastChildElementNS(document, "namespace", "element"));
	}

	@Test
	public void test29() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		aeqr(element, DOMUtil.getLastChildElementNS(document, "namespace", "element"));
	}

	@Test
	public void test30() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getLastChildElementNS(document, "namespace", "element1"));
	}

	@Test
	public void test31() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		Comment comment = document.createComment("comment");
		document.appendChild(comment);
		aeqr(element, DOMUtil.getLastChildElementNS(document, "namespace", "element"));
	}

	@Test
	public void test32() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getLastChildElementNS(document, "namespace1", "element"));
	}

	@Test
	public void test33() {
		Element element = document.createElement("element");
		document.appendChild(element);
		an(DOMUtil.getLastChildElementNS(document, "namespace", "element"));
	}

	@Test
	public void test34() {
		an(DOMUtil.getNextSiblingElementNS(document, "namespace", "child2"));
	}

	@Test
	public void test35() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		aeqr(child2, DOMUtil.getNextSiblingElementNS(child1, "namespace", "child2"));
	}

	@Test
	public void test36() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Comment comment = document.createComment("comment");
		parent.appendChild(comment);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		aeqr(child2, DOMUtil.getNextSiblingElementNS(child1, "namespace", "child2"));
	}

	@Test
	public void test37() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElement("child2");
		parent.appendChild(child2);

		an(DOMUtil.getNextSiblingElementNS(child1, "namespace", "child2"));
	}

	@Test
	public void test38() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace1", "child2");
		parent.appendChild(child2);

		an(DOMUtil.getNextSiblingElementNS(child1, "namespace", "child2"));
	}

	@Test
	public void test39() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2_");
		parent.appendChild(child2);

		an(DOMUtil.getNextSiblingElementNS(child1, "namespace", "child2"));
	}

	@Test
	public void test40() {
		an(DOMUtil.getFirstChildElement(document, new String[] { "element" }));
	}

	@Test
	public void test41() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		aeqr(element, DOMUtil.getFirstChildElement(document, new String[] { "element" }));
	}

	@Test
	public void test42() {
		Comment comment = document.createComment("comment");
		document.appendChild(comment);
		an(DOMUtil.getFirstChildElement(document, new String[] { "element" }));
	}

	@Test
	public void test43() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getFirstChildElement(document, new String[] {}));
	}

	@Test
	public void test44() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getFirstChildElement(document, new String[] { "element1" }));
	}

	@Test
	public void test45() {
		an(DOMUtil.getLastChildElement(document, new String[] { "element" }));
	}

	@Test
	public void test46() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		aeqr(element, DOMUtil.getLastChildElement(document, new String[] { "element" }));
	}

	@Test
	public void test47() {
		Comment comment = document.createComment("comment");
		document.appendChild(comment);
		an(DOMUtil.getLastChildElement(document, new String[] { "element" }));
	}

	@Test
	public void test48() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getLastChildElement(document, new String[] {}));
	}

	@Test
	public void test49() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getLastChildElement(document, new String[] { "element1" }));
	}

	@Test
	public void test50() {
		an(DOMUtil.getNextSiblingElement(document, new String[] { "element" }));
	}

	@Test
	public void test51() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Comment comment = document.createComment("comment");
		parent.appendChild(comment);

		an(DOMUtil.getNextSiblingElement(child1, new String[] { "element" }));
	}

	@Test
	public void test52() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		an(DOMUtil.getNextSiblingElement(child1, new String[] {}));
	}

	@Test
	public void test53() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		an(DOMUtil.getNextSiblingElement(child1, new String[] { "element" }));
	}

	@Test
	public void test54() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		aeqr(child2, DOMUtil.getNextSiblingElement(child1, new String[] { "child2" }));
	}

	@Test
	public void test55() {
		an(DOMUtil.getFirstChildElementNS(document, new String[][] {}));
	}

	@Test
	public void test56() {
		Comment comment = document.createComment("comment");
		document.appendChild(comment);
		an(DOMUtil.getFirstChildElementNS(document, new String[][] {}));
	}

	@Test
	public void test57() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getFirstChildElementNS(document, new String[][] {}));
	}

	@Test
	public void test58() {
		Element element = document.createElement("element");
		document.appendChild(element);
		an(DOMUtil.getFirstChildElementNS(document, new String[][] { new String[] { "namespace", "element" } }));
	}

	@Test
	public void test59() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getFirstChildElementNS(document, new String[][] { new String[] { "namespace1", "element" } }));
	}

	@Test
	public void test60() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getFirstChildElementNS(document, new String[][] { new String[] { "namespace", "element1" } }));
	}

	@Test
	public void test61() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		aeqr(element,
				DOMUtil.getFirstChildElementNS(document, new String[][] { new String[] { "namespace", "element" } }));
	}

	@Test
	public void test62() {
		an(DOMUtil.getLastChildElementNS(document, new String[][] {}));
	}

	@Test
	public void test63() {
		Comment comment = document.createComment("comment");
		document.appendChild(comment);
		an(DOMUtil.getLastChildElementNS(document, new String[][] {}));
	}

	@Test
	public void test64() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getLastChildElementNS(document, new String[][] {}));
	}

	@Test
	public void test65() {
		Element element = document.createElement("element");
		document.appendChild(element);
		an(DOMUtil.getLastChildElementNS(document, new String[][] { new String[] { "namespace", "element" } }));
	}

	@Test
	public void test66() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getLastChildElementNS(document, new String[][] { new String[] { "namespace1", "element" } }));
	}

	@Test
	public void test67() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getLastChildElementNS(document, new String[][] { new String[] { "namespace", "element1" } }));
	}

	@Test
	public void test68() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		aeqr(element,
				DOMUtil.getLastChildElementNS(document, new String[][] { new String[] { "namespace", "element" } }));
	}

	@Test
	public void test69() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);
		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);
		an(DOMUtil.getNextSiblingElementNS(child1, new String[][] {}));
	}

	@Test
	public void test70() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Comment comment = document.createComment("comment");
		parent.appendChild(comment);

		an(DOMUtil.getNextSiblingElementNS(child1, new String[][] {}));
	}

	@Test
	public void test71() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		an(DOMUtil.getNextSiblingElementNS(child1, new String[][] {}));
	}

	@Test
	public void test72() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElement("child2");
		parent.appendChild(child2);

		an(DOMUtil.getNextSiblingElementNS(child1, new String[][] { new String[] { "namespace", "child2" } }));
	}

	@Test
	public void test73() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		an(DOMUtil.getNextSiblingElementNS(child1, new String[][] { new String[] { "namespace_", "child2" } }));
	}

	@Test
	public void test74() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		an(DOMUtil.getNextSiblingElementNS(child1, new String[][] { new String[] { "namespace", "child2_" } }));
	}

	@Test
	public void test75() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		aeqr(child2,
				DOMUtil.getNextSiblingElementNS(child1, new String[][] { new String[] { "namespace", "child2" } }));
	}

	@Test
	public void test76() {
		an(DOMUtil.getFirstChildElement(document, "element", "id", "elementId"));
	}

	@Test
	public void test77() {
		Comment comment = document.createComment("comment");
		document.appendChild(comment);
		an(DOMUtil.getFirstChildElement(document, "element", "id", "elementId"));
	}

	@Test
	public void test78() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getFirstChildElement(document, "element_", "id", "elementId"));
	}

	@Test
	public void test79() {
		Element element = document.createElementNS("namespace", "element");
		element.setAttribute("id", "elementId");
		document.appendChild(element);
		an(DOMUtil.getFirstChildElement(document, "element", "id", "elementId_"));
	}

	@Test
	public void test80() {
		Element element = document.createElementNS("namespace", "element");
		element.setAttribute("id", "elementId");
		document.appendChild(element);
		aeqr(element, DOMUtil.getFirstChildElement(document, "element", "id", "elementId"));
	}

	@Test
	public void test81() {
		an(DOMUtil.getLastChildElement(document, "element", "id", "elementId"));
	}

	@Test
	public void test82() {
		Comment comment = document.createComment("comment");
		document.appendChild(comment);
		an(DOMUtil.getLastChildElement(document, "element", "id", "elementId"));
	}

	@Test
	public void test83() {
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		an(DOMUtil.getLastChildElement(document, "element_", "id", "elementId"));
	}

	@Test
	public void test84() {
		Element element = document.createElementNS("namespace", "element");
		element.setAttribute("id", "elementId");
		document.appendChild(element);
		an(DOMUtil.getLastChildElement(document, "element", "id", "elementId_"));
	}

	@Test
	public void test85() {
		Element element = document.createElementNS("namespace", "element");
		element.setAttribute("id", "elementId");
		document.appendChild(element);
		aeqr(element, DOMUtil.getLastChildElement(document, "element", "id", "elementId"));
	}

	@Test
	public void test86() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		an(DOMUtil.getNextSiblingElement(child1, "child2", "id", "child2Id"));
	}

	@Test
	public void test87() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Comment comment = document.createComment("comment");
		parent.appendChild(comment);

		an(DOMUtil.getNextSiblingElement(child1, "child2", "id", "child2Id"));
	}

	@Test
	public void test88() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		parent.appendChild(child2);

		an(DOMUtil.getNextSiblingElement(child1, "child2_", "id", "child2Id"));
	}

	@Test
	public void test89() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		child2.setAttribute("id", "child2Id");
		parent.appendChild(child2);

		an(DOMUtil.getNextSiblingElement(child1, "child2", "id", "child2Id_"));
	}

	@Test
	public void test90() {
		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child1 = document.createElementNS("namespace", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("namespace", "child2");
		child2.setAttribute("id", "child2Id");
		parent.appendChild(child2);

		aeqr(child2, DOMUtil.getNextSiblingElement(child1, "child2", "id", "child2Id"));
	}

	@Test
	public void test91() {
		an(DOMUtil.getChildText(null));
	}

	@Test
	public void test92() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		aeq("", DOMUtil.getChildText(parent));
	}

	@Test
	public void test93() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element element = document.createElementNS("namespace", "element");
		parent.appendChild(element);

		aeq("", DOMUtil.getChildText(document));
	}

	@Test
	public void test94() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Text text = document.createTextNode("text");
		parent.appendChild(text);

		aeq("text", DOMUtil.getChildText(parent));
	}

	@Test
	public void test95() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		CDATASection data = document.createCDATASection("data");
		parent.appendChild(data);

		aeq("", DOMUtil.getChildText(parent));
	}

	@Test
	public void test96() {
		an(DOMUtil.getName(document));
	}

	@Test
	public void test97() {
		an(DOMUtil.getLocalName(document));
	}

	@Test
	public void test98() {

		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);

		aeq("element", DOMUtil.getLocalName(element));
	}

	@Test
	public void test99() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		an(DOMUtil.getParent(parent));
	}

	@Test
	public void test100() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		Element child = document.createElementNS("namespace", "child");
		parent.appendChild(child);

		aeqr(parent, DOMUtil.getParent(child));
	}

	@Test
	public void test101() {

		Element parent = document.createElementNS("namespace", "parent");
		document.appendChild(parent);

		aeqr(document, DOMUtil.getDocument(parent));
	}

	@Test
	public void test102() {
		an(document.getDocumentElement());
		an(DOMUtil.getRoot(document));
	}

	@Test
	public void test103() {

		Attr attribute = document.createAttribute("attribute");

		Element element = document.createElementNS("namespace", "element");
		element.setAttributeNode(attribute);
		document.appendChild(element);

		aeqr(attribute, DOMUtil.getAttr(element, "attribute"));
	}

	@Test
	public void test104() {

		Attr attribute = document.createAttributeNS("namespace", "attribute");

		Element element = document.createElementNS("namespace", "element");
		element.setAttributeNode(attribute);
		document.appendChild(element);

		aeqr(attribute, DOMUtil.getAttrNS(element, "namespace", "attribute"));
	}

	@Test
	public void test105() {

		Attr attribute = document.createAttributeNS("namespace", "attribute");

		Element element = document.createElementNS("namespace", "element");
		element.setAttributeNode(attribute);
		document.appendChild(element);

		aeqr(attribute, DOMUtil.getAttrs(element)[0]);
	}

	@Test
	public void test106() {

		Attr attribute = document.createAttributeNS("namespace", "attribute");
		attribute.setValue("value");

		aeq("value", DOMUtil.getValue(attribute));
	}

	@Test
	public void test107() {

		Attr attribute = document.createAttributeNS("namespace", "attribute");
		attribute.setValue("value");

		Element element = document.createElementNS("namespace", "element");
		element.setAttributeNode(attribute);

		aeq("value", DOMUtil.getAttrValue(element, "attribute"));
	}

	@Test
	public void test108() {

		Attr attribute = document.createAttributeNS("namespace", "attribute");
		attribute.setValue("value");

		Element element = document.createElementNS("namespace", "element");
		element.setAttributeNode(attribute);

		aeq("value", DOMUtil.getAttrValueNS(element, "namespace", "attribute"));
	}

	@Test
	public void test109() {

		Element element = document.createElementNS("namespace", "element");

		aeq("namespace", DOMUtil.getNamespaceURI(element));
	}

	@Test
	public void test110() {
		an(DOMUtil.getInputEncoding(document));
	}

	@Test
	public void test111() {
		an(DOMUtil.getXmlEncoding(document));
	}
}

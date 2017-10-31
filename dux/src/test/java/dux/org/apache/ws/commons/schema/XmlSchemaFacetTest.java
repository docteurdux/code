package dux.org.apache.ws.commons.schema;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.commons.schema.XmlSchemaEnumerationFacet;
import org.apache.ws.commons.schema.XmlSchemaException;
import org.apache.ws.commons.schema.XmlSchemaFacet;
import org.apache.ws.commons.schema.XmlSchemaFractionDigitsFacet;
import org.apache.ws.commons.schema.XmlSchemaLengthFacet;
import org.apache.ws.commons.schema.XmlSchemaMaxExclusiveFacet;
import org.apache.ws.commons.schema.XmlSchemaMaxInclusiveFacet;
import org.apache.ws.commons.schema.XmlSchemaMaxLengthFacet;
import org.apache.ws.commons.schema.XmlSchemaMinExclusiveFacet;
import org.apache.ws.commons.schema.XmlSchemaMinInclusiveFacet;
import org.apache.ws.commons.schema.XmlSchemaMinLengthFacet;
import org.apache.ws.commons.schema.XmlSchemaPatternFacet;
import org.apache.ws.commons.schema.XmlSchemaTotalDigitsFacet;
import org.apache.ws.commons.schema.XmlSchemaWhiteSpaceFacet;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaFacetTest extends AbstractTest {

	private Document document;

	@Before
	public void before() throws ParserConfigurationException {
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	}

	@Test
	public void test1() {
		XmlSchemaFacet facet = new XmlSchemaFacet() {
		};

		Object value = new Object();
		boolean fixed = false;
		facet = new XmlSchemaFacet(value, fixed) {
		};

		aeqr(value, facet.getValue());

	}

	@Test(expected = XmlSchemaException.class)
	public void test2() {
		Element element = document.createElementNS("namespace", "element");
		XmlSchemaFacet.construct(element);
	}

	@Test
	public void test3() {
		Element element = document.createElementNS("namespace", "enumeration");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet instanceof XmlSchemaEnumerationFacet);
	}

	@Test
	public void test4() {
		Element element = document.createElementNS("namespace", "fractionDigits");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet instanceof XmlSchemaFractionDigitsFacet);
	}

	@Test
	public void test5() {
		Element element = document.createElementNS("namespace", "length");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet instanceof XmlSchemaLengthFacet);
	}

	@Test
	public void test6() {
		Element element = document.createElementNS("namespace", "maxExclusive");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet instanceof XmlSchemaMaxExclusiveFacet);
	}

	@Test
	public void test7() {
		Element element = document.createElementNS("namespace", "maxInclusive");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet instanceof XmlSchemaMaxInclusiveFacet);
	}

	@Test
	public void test8() {
		Element element = document.createElementNS("namespace", "maxLength");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet instanceof XmlSchemaMaxLengthFacet);
	}

	@Test
	public void test9() {
		Element element = document.createElementNS("namespace", "minLength");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet instanceof XmlSchemaMinLengthFacet);
	}

	@Test
	public void test10() {
		Element element = document.createElementNS("namespace", "minExclusive");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet instanceof XmlSchemaMinExclusiveFacet);
	}

	@Test
	public void test11() {
		Element element = document.createElementNS("namespace", "minInclusive");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet instanceof XmlSchemaMinInclusiveFacet);
	}

	@Test
	public void test12() {
		Element element = document.createElementNS("namespace", "pattern");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet instanceof XmlSchemaPatternFacet);
	}

	@Test
	public void test13() {
		Element element = document.createElementNS("namespace", "totalDigits");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet instanceof XmlSchemaTotalDigitsFacet);
	}

	@Test
	public void test14() {
		Element element = document.createElementNS("namespace", "whiteSpace");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet instanceof XmlSchemaWhiteSpaceFacet);
	}

	@Test
	public void test15() {
		Element element = document.createElementNS("namespace", "whiteSpace");
		element.setAttribute("fixed", "true");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		at(facet.isFixed());
	}

	@Test
	public void test16() {
		Element element = document.createElementNS("namespace", "whiteSpace");
		element.setAttribute("id", "elementId");
		XmlSchemaFacet facet = XmlSchemaFacet.construct(element);
		aeq("elementId", facet.getId());
	}

}

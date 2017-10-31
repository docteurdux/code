package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaWhiteSpaceFacet;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaWhiteSpaceFacetTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaWhiteSpaceFacet facet = new XmlSchemaWhiteSpaceFacet();
		an(facet.getValue());
		af(facet.isFixed());
	}

	@Test
	public void test2() {
		Object value = new Object();
		XmlSchemaWhiteSpaceFacet facet = new XmlSchemaWhiteSpaceFacet(value, true);
		aeqr(value, facet.getValue());
		at(facet.isFixed());
	}

}

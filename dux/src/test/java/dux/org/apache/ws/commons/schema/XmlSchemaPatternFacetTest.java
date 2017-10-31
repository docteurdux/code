package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaPatternFacet;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaPatternFacetTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaPatternFacet facet = new XmlSchemaPatternFacet();
		an(facet.getValue());
		af(facet.isFixed());
	}

	@Test
	public void test2() {
		Object value = new Object();
		XmlSchemaPatternFacet facet = new XmlSchemaPatternFacet(value, true);
		aeqr(value, facet.getValue());
		at(facet.isFixed());
	}

}

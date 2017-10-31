package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaEnumerationFacet;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaEnumerationFacetTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaEnumerationFacet facet = new XmlSchemaEnumerationFacet();
		an(facet.getValue());
		af(facet.isFixed());
	}

	@Test
	public void test2() {
		Object value = new Object();
		XmlSchemaEnumerationFacet facet = new XmlSchemaEnumerationFacet(value, true);
		aeqr(value, facet.getValue());
		at(facet.isFixed());
	}

}

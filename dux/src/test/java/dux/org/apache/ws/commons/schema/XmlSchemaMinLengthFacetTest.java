package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaMinLengthFacet;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaMinLengthFacetTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaMinLengthFacet facet = new XmlSchemaMinLengthFacet();
		an(facet.getValue());
		af(facet.isFixed());
	}

	@Test
	public void test2() {
		Object value = new Object();
		XmlSchemaMinLengthFacet facet = new XmlSchemaMinLengthFacet(value, true);
		aeqr(value, facet.getValue());
		at(facet.isFixed());
	}

}

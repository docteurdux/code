package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaMinInclusiveFacet;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaMinInclusiveFacetTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaMinInclusiveFacet facet = new XmlSchemaMinInclusiveFacet();
		an(facet.getValue());
		af(facet.isFixed());
	}

	@Test
	public void test2() {
		Object value = new Object();
		XmlSchemaMinInclusiveFacet facet = new XmlSchemaMinInclusiveFacet(value, true);
		aeqr(value, facet.getValue());
		at(facet.isFixed());
	}

}

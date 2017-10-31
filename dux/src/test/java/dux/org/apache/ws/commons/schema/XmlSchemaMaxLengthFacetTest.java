package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaMaxLengthFacet;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaMaxLengthFacetTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaMaxLengthFacet facet = new XmlSchemaMaxLengthFacet();
		an(facet.getValue());
		af(facet.isFixed());
	}

	@Test
	public void test2() {
		Object value = new Object();
		XmlSchemaMaxLengthFacet facet = new XmlSchemaMaxLengthFacet(value, true);
		aeqr(value, facet.getValue());
		at(facet.isFixed());
	}

}

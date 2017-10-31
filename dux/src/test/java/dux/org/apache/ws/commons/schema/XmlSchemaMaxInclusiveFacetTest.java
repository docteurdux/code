package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaMaxInclusiveFacet;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaMaxInclusiveFacetTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaMaxInclusiveFacet facet = new XmlSchemaMaxInclusiveFacet();
		an(facet.getValue());
		af(facet.isFixed());
	}

	@Test
	public void test2() {
		Object value = new Object();
		XmlSchemaMaxInclusiveFacet facet = new XmlSchemaMaxInclusiveFacet(value, true);
		aeqr(value, facet.getValue());
		at(facet.isFixed());
	}

}

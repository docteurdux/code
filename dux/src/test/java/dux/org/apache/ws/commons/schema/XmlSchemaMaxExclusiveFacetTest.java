package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaMaxExclusiveFacet;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaMaxExclusiveFacetTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaMaxExclusiveFacet facet = new XmlSchemaMaxExclusiveFacet();
		an(facet.getValue());
		af(facet.isFixed());
	}

	@Test
	public void test2() {
		Object value = new Object();
		XmlSchemaMaxExclusiveFacet facet = new XmlSchemaMaxExclusiveFacet(value, true);
		aeqr(value, facet.getValue());
		at(facet.isFixed());
	}

}

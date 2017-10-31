package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaMinExclusiveFacet;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaMinExclusiveFacetTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaMinExclusiveFacet facet = new XmlSchemaMinExclusiveFacet();
		an(facet.getValue());
		af(facet.isFixed());
	}

	@Test
	public void test2() {
		Object value = new Object();
		XmlSchemaMinExclusiveFacet facet = new XmlSchemaMinExclusiveFacet(value, true);
		aeqr(value, facet.getValue());
		at(facet.isFixed());
	}

}

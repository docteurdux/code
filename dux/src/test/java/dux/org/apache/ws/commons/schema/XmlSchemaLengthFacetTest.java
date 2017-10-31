package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaLengthFacet;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaLengthFacetTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaLengthFacet facet = new XmlSchemaLengthFacet();
		an(facet.getValue());
		af(facet.isFixed());
	}

	@Test
	public void test2() {
		Object value = new Object();
		XmlSchemaLengthFacet facet = new XmlSchemaLengthFacet(value, true);
		aeqr(value, facet.getValue());
		at(facet.isFixed());
	}

}

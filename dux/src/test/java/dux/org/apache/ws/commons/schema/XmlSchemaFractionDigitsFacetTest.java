package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaFractionDigitsFacet;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaFractionDigitsFacetTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaFractionDigitsFacet facet = new XmlSchemaFractionDigitsFacet();
		an(facet.getValue());
		af(facet.isFixed());
	}

	@Test
	public void test2() {
		Object value = new Object();
		XmlSchemaFractionDigitsFacet facet = new XmlSchemaFractionDigitsFacet(value, true);
		aeqr(value, facet.getValue());
		at(facet.isFixed());
	}

}

package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaTotalDigitsFacet;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaTotalDigitsFacetTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaTotalDigitsFacet facet = new XmlSchemaTotalDigitsFacet();
		an(facet.getValue());
		af(facet.isFixed());
	}

	@Test
	public void test2() {
		Object value = new Object();
		XmlSchemaTotalDigitsFacet facet = new XmlSchemaTotalDigitsFacet(value, true);
		aeqr(value, facet.getValue());
		at(facet.isFixed());
	}

}

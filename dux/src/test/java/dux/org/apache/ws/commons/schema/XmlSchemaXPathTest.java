package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaXPath;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaXPathTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaXPath xpath = new XmlSchemaXPath();
		an(xpath.getXPath());
		xpath.setXPath("xpath");
		aeq("xpath", xpath.getXPath());
	}

}

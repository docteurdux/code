package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaAll;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaAllTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaAll all = new XmlSchemaAll();
		aeq(0, all.getItems().size());
	}

}

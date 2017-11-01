package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaIdentityConstraint;
import org.apache.ws.commons.schema.XmlSchemaKey;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaKeyTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		aeq(XmlSchemaIdentityConstraint.class, XmlSchemaKey.class.getSuperclass());
	}

}

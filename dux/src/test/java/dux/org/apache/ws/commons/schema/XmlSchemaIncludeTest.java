package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaExternal;
import org.apache.ws.commons.schema.XmlSchemaInclude;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaIncludeTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		String namespace = "namespace";
		String systemId = "systemId";
		XmlSchemaCollection parent = new XmlSchemaCollection();
		XmlSchema schema = new XmlSchema(namespace, systemId, parent);
		XmlSchemaInclude include = new XmlSchemaInclude(schema);

		aeq(XmlSchemaExternal.class, XmlSchemaInclude.class.getSuperclass());

	}

}

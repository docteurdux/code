package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaRedefine;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class XmlSchemaRedefineTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		String namespace = "namespace";
		String systemId = "systemId";
		XmlSchemaCollection parent = new XmlSchemaCollection();
		XmlSchema schema = new XmlSchema(namespace, systemId, parent);
		XmlSchemaRedefine redefine = new XmlSchemaRedefine(schema);
	}

}
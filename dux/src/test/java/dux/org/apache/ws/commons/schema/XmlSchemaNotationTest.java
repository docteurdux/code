package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaNotation;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class XmlSchemaNotationTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		String namespace = "namespace";
		String systemId = "systemId";
		XmlSchemaCollection parent = new XmlSchemaCollection();
		XmlSchema schema = new XmlSchema(namespace, systemId, parent);
		XmlSchemaNotation notation = new XmlSchemaNotation(schema);
	}

}

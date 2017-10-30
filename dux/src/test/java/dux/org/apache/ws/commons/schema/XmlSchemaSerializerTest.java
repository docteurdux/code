package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaSerializer;
import org.apache.ws.commons.schema.XmlSchemaSerializer.XmlSchemaSerializerException;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Focus;

@Focus
public class XmlSchemaSerializerTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() throws XmlSchemaSerializerException {
		XmlSchemaSerializer serializer = new XmlSchemaSerializer();
		String namespace = "namespace";
		String systemId = "systemId";
		XmlSchemaCollection parent = new XmlSchemaCollection();
		XmlSchema schema = new XmlSchema(namespace, systemId, parent);
		serializer.serializeSchema(schema, false);
	}

}

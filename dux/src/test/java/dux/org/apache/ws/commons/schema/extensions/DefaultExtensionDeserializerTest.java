package dux.org.apache.ws.commons.schema.extensions;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.extensions.DefaultExtensionDeserializer;
import org.junit.Test;
import org.w3c.dom.Node;

import com.github.docteurdux.test.AbstractTest;

public class DefaultExtensionDeserializerTest extends AbstractTest {
	@Test
	public void test() throws ParserConfigurationException {
		DefaultExtensionDeserializer deserializer = new DefaultExtensionDeserializer();
		String namespace = "namespace";
		String systemId = "systemId";
		XmlSchemaCollection parent = new XmlSchemaCollection();
		XmlSchema schema = new XmlSchema(namespace, systemId, parent);
		QName qn = new QName("qn");
		Node node = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		deserializer.deserialize(schema, qn, node);
	}
}

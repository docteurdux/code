package dux.org.apache.ws.commons.schema;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaAttributeGroupRef;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaAttributeGroupRefTest extends AbstractTest {

	private String namespace;
	private String systemId;
	private XmlSchemaCollection parent;
	private XmlSchema schema;

	@Before
	public void before() {

		namespace = "namespace";
		systemId = "systemId";
		parent = new XmlSchemaCollection();
		schema = new XmlSchema(namespace, systemId, parent);

	}

	@Test
	public void test1() {

		XmlSchemaAttributeGroupRef attributeGroupRef = new XmlSchemaAttributeGroupRef(schema);

		ann(attributeGroupRef.getRef());
		aeqr(attributeGroupRef.getRef(), attributeGroupRef.getRefBase());
		an(attributeGroupRef.getTargetQName());
		af(attributeGroupRef.isRef());

		QName targetQName = new QName("targetQNameNS", "targetQNameLP");
		attributeGroupRef.getRef().setTargetQName(targetQName);
		aeq(targetQName, attributeGroupRef.getTargetQName());
		at(attributeGroupRef.isRef());
	}

}

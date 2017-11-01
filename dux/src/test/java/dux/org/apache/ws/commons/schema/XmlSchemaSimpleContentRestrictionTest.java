package dux.org.apache.ws.commons.schema;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaAnyAttribute;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaSimpleContentRestriction;
import org.apache.ws.commons.schema.XmlSchemaSimpleType;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaSimpleContentRestrictionTest extends AbstractTest {

	private XmlSchema schema;
	private String namespace;
	private String systemId;
	private XmlSchemaCollection parent;

	@Before
	public void before() {
		namespace = "namespace";
		systemId = "systemId";
		parent = new XmlSchemaCollection();
		schema = new XmlSchema(namespace, systemId, parent);
	}

	@Test
	public void test1() {

		XmlSchemaSimpleContentRestriction restriction = new XmlSchemaSimpleContentRestriction();

		XmlSchemaAnyAttribute anyAttribute = new XmlSchemaAnyAttribute();
		an(restriction.getAnyAttribute());
		restriction.setAnyAttribute(anyAttribute);
		aeqr(anyAttribute, restriction.getAnyAttribute());

		QName baseTypeName = new QName("baseTypeNameNS", "baseTypeNameLP");
		an(restriction.getBaseTypeName());
		restriction.setBaseTypeName(baseTypeName);
		aeq(baseTypeName, restriction.getBaseTypeName());

		XmlSchemaSimpleType baseType = new XmlSchemaSimpleType(schema, true);
		an(restriction.getBaseType());
		restriction.setBaseType(baseType);
		aeqr(baseType, restriction.getBaseType());

		aeq(0, restriction.getAttributes().size());
		aeq(0, restriction.getFacets().size());
	}

}

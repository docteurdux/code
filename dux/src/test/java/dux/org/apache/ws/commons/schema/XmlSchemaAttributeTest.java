package dux.org.apache.ws.commons.schema;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaAttribute;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaForm;
import org.apache.ws.commons.schema.XmlSchemaSimpleType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class XmlSchemaAttributeTest extends AbstractTest {
	@Test
	public void test() {
		String namespace = "namespace";
		String systemId = "systemId";
		XmlSchemaCollection parent = new XmlSchemaCollection();
		XmlSchema schema = new XmlSchema(namespace, systemId, parent);
		XmlSchemaAttribute a = new XmlSchemaAttribute(schema, true);

		an(a.getDefaultValue());
		String defaultValue = "defaultValue";
		a.setDefaultValue(defaultValue);
		aeq(defaultValue, a.getDefaultValue());

		an(a.getFixedValue());
		String fixedValue = "fixedValue";
		a.setFixedValue(fixedValue);
		aeq(fixedValue, a.getFixedValue());

		ann(a.getRef());

		an(a.getSchemaType());
		XmlSchemaSimpleType schemaType = new XmlSchemaSimpleType(schema, true);
		a.setSchemaType(schemaType);
		aeq(schemaType, a.getSchemaType());

		an(a.getSchemaTypeName());
		QName schemaTypeName = new QName("schemaTypeName");
		a.setSchemaTypeName(schemaTypeName);
		aeq(schemaTypeName, a.getSchemaTypeName());

//		aeq(XmlSchemaUse.NONE, a.getUse());
//		a.setUse(XmlSchemaUse.OPTIONAL);
		
		an(a.getName());
		aeqr(schema, a.getParent());
		an(a.getQName());
		at(a.isAnonymous());
		at(a.isTopLevel());
		
		String name="name";
		a.setName(name);
		
		af(a.isFormSpecified());
		aeq(XmlSchemaForm.UNQUALIFIED, a.getForm());
//		a.setForm(XmlSchemaForm.QUALIFIED);
		
		aeq(new QName("name"),a.getWireName());
		af(a.isRef());
		an(a.getTargetQName());
		ann(a.getRefBase());

	}
}

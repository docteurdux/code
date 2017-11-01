package dux.org.apache.ws.commons.schema;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchemaAnyAttribute;
import org.apache.ws.commons.schema.XmlSchemaAttributeOrGroupRef;
import org.apache.ws.commons.schema.XmlSchemaSimpleContentExtension;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaSimpleContentExtensionTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaSimpleContentExtension extension = new XmlSchemaSimpleContentExtension();

		XmlSchemaAnyAttribute anyAttribute = new XmlSchemaAnyAttribute();
		an(extension.getAnyAttribute());
		extension.setAnyAttribute(anyAttribute);
		aeqr(anyAttribute, extension.getAnyAttribute());

		QName baseTypeName = new QName("baseTypeNameNS", "baseTypeNameLP");
		an(extension.getBaseTypeName());
		extension.setBaseTypeName(baseTypeName);
		aeq(baseTypeName, extension.getBaseTypeName());

		aeq(0, extension.getAttributes().size());

		List<XmlSchemaAttributeOrGroupRef> attributes = new ArrayList<>();
		extension.setAttributes(attributes);
		aeqr(attributes, extension.getAttributes());

	}

}

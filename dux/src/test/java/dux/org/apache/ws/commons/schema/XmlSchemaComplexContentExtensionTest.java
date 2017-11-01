package dux.org.apache.ws.commons.schema;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchemaAnyAttribute;
import org.apache.ws.commons.schema.XmlSchemaAttributeOrGroupRef;
import org.apache.ws.commons.schema.XmlSchemaComplexContentExtension;
import org.apache.ws.commons.schema.XmlSchemaParticle;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaComplexContentExtensionTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		XmlSchemaComplexContentExtension extension = new XmlSchemaComplexContentExtension();

		XmlSchemaAnyAttribute anyAttribute = new XmlSchemaAnyAttribute();
		an(extension.getAnyAttribute());
		extension.setAnyAttribute(anyAttribute);
		aeqr(anyAttribute, extension.getAnyAttribute());

		aeq(0, extension.getAttributes().size());

		QName baseTypeName = new QName("baseTypeNameNS", "baseTypeNameLP");
		an(extension.getBaseTypeName());
		extension.setBaseTypeName(baseTypeName);
		aeq(baseTypeName, extension.getBaseTypeName());

		XmlSchemaParticle particle = new XmlSchemaParticle() {
		};
		an(extension.getParticle());
		extension.setParticle(particle);
		aeqr(particle, extension.getParticle());

		List<XmlSchemaAttributeOrGroupRef> attributes = new ArrayList<>();
		Method setAttributes = XmlSchemaComplexContentExtension.class.getDeclaredMethod("setAttributes", List.class);
		setAttributes.setAccessible(true);
		setAttributes.invoke(extension, attributes);
		aeqr(attributes, extension.getAttributes());
	}

}

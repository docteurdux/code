package dux.org.apache.ws.commons.schema;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchemaAnyAttribute;
import org.apache.ws.commons.schema.XmlSchemaAttributeOrGroupRef;
import org.apache.ws.commons.schema.XmlSchemaComplexContentRestriction;
import org.apache.ws.commons.schema.XmlSchemaParticle;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaComplexContentRestrictionTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		XmlSchemaComplexContentRestriction restriction = new XmlSchemaComplexContentRestriction();

		XmlSchemaAnyAttribute anyAttribute = new XmlSchemaAnyAttribute();
		an(restriction.getAnyAttribute());
		restriction.setAnyAttribute(anyAttribute);
		aeqr(anyAttribute, restriction.getAnyAttribute());

		QName baseTypeName = new QName("baseTypeNameNS", "baseTypeNameLP");
		an(restriction.getBaseTypeName());
		restriction.setBaseTypeName(baseTypeName);
		aeq(baseTypeName, restriction.getBaseTypeName());

		XmlSchemaParticle particle = new XmlSchemaParticle() {
		};
		an(restriction.getParticle());
		restriction.setParticle(particle);
		aeqr(particle, restriction.getParticle());

		aeq(0, restriction.getAttributes().size());

		List<XmlSchemaAttributeOrGroupRef> attributes = new ArrayList<>();
		Method setAttributes = XmlSchemaComplexContentRestriction.class.getDeclaredMethod("setAttributes", List.class);
		setAttributes.setAccessible(true);
		setAttributes.invoke(restriction, attributes);
		aeqr(attributes, restriction.getAttributes());
	}

}

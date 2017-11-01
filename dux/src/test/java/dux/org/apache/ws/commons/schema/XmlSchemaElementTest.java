package dux.org.apache.ws.commons.schema;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaDerivationMethod;
import org.apache.ws.commons.schema.XmlSchemaElement;
import org.apache.ws.commons.schema.XmlSchemaForm;
import org.apache.ws.commons.schema.XmlSchemaSimpleType;
import org.apache.ws.commons.schema.XmlSchemaType;
import org.apache.ws.commons.schema.utils.XmlSchemaRefBase;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done("except equals")
public class XmlSchemaElementTest extends AbstractTest {

	private String namespace;
	private String systemId;
	private boolean topLevel;
	private XmlSchemaCollection parent;
	private XmlSchema schema;

	@Before
	public void before() {
		namespace = "namespace";
		systemId = "systemId";
		topLevel = true;
		parent = new XmlSchemaCollection();
		schema = new XmlSchema(namespace, systemId, parent);
	}

	@Test
	public void test1() {

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);

		aeqr(schema, element.getParent());
		at(element.isTopLevel());
		aeq(element, schema.getItems().get(0));

		aeq(0, element.getConstraints().size());

	}

	@Test
	public void test2() {

		XmlSchemaType schemaType = new XmlSchemaSimpleType(schema, topLevel);

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);
		an(element.getSchemaType());
		element.setSchemaType(schemaType);
		aeqr(schemaType, element.getSchemaType());

		element.setType(null);
		an(element.getSchemaType());

	}

	@Test
	public void test3() {

		QName schemaTypeName = new QName("schemaTypeNameNS", "schemaTypeNameLP");

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);
		an(element.getSchemaTypeName());
		element.setSchemaTypeName(schemaTypeName);
		aeq(schemaTypeName, element.getSchemaTypeName());

	}

	@Test
	public void test4() {

		QName substitutionGroup = new QName("substitutionGroupNS", "substitutionGroupLP");

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);
		an(element.getSubstitutionGroup());
		element.setSubstitutionGroup(substitutionGroup);
		aeq(substitutionGroup, element.getSubstitutionGroup());

	}

	@Test
	public void test5() {

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);
		af(element.isNillable());
		element.setNillable(true);
		at(element.isNillable());
	}

	@Test
	public void test6() {

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);
		af(element.isAbstract());
		element.setAbstract(true);
		at(element.isAbstract());
	}

	@Test
	public void test7() {

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);
		aeq(XmlSchemaForm.UNQUALIFIED, element.getForm());
		element.setForm(XmlSchemaForm.QUALIFIED);
		aeq(XmlSchemaForm.QUALIFIED, element.getForm());
	}

	@Test
	public void test8() {

		XmlSchemaDerivationMethod derivationMethod = new XmlSchemaDerivationMethod();

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);

		aeqr(XmlSchemaDerivationMethod.NONE, element.getFinalDerivation());
		element.setFinalDerivation(derivationMethod);
		aeqr(derivationMethod, element.getFinalDerivation());
	}

	@Test
	public void test9() {

		XmlSchemaDerivationMethod derivationMethod = new XmlSchemaDerivationMethod();

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);

		aeqr(XmlSchemaDerivationMethod.NONE, element.getBlock());
		element.setBlock(derivationMethod);
		aeqr(derivationMethod, element.getBlock());
	}

	@Test
	public void test10() {

		XmlSchemaDerivationMethod derivationMethod = new XmlSchemaDerivationMethod();

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);

		aeqr(XmlSchemaDerivationMethod.NONE, element.getFinal());
		element.setFinal(derivationMethod);
		aeqr(derivationMethod, element.getFinal());

	}

	@Test
	public void test11() {

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);

		an(element.getFixedValue());
		element.setFixedValue("fixedValue");
		aeq("fixedValue", element.getFixedValue());

	}

	@Test
	public void test12() {

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);

		an(element.getDefaultValue());
		element.setDefaultValue("defaultValue");
		aeq("defaultValue", element.getDefaultValue());

	}

	@Test
	public void test13() {

		XmlSchemaElement element = new XmlSchemaElement(schema, topLevel);

		af(element.isAbstractElement());
		element.setAbstractElement(true);
		at(element.isAbstractElement());

	}

	@Test
	public void test14() {

		XmlSchemaElement element = new XmlSchemaElement(schema, false);

		aeqr(schema, element.getParent());
		af(element.isTopLevel());
		aeq(0, schema.getItems().size());

	}

	@Test
	public void test15() {

		XmlSchemaElement element = new XmlSchemaElement(schema, false);
		element.setName("name");
		aeq(0, schema.getElements().size());

	}

	@Test
	public void test16() {

		XmlSchemaElement element = new XmlSchemaElement(schema, true);
		element.setName("name");
		aeq(1, schema.getElements().size());
		aeq(namespace, schema.getElements().keySet().iterator().next().getNamespaceURI());
		aeq("name", schema.getElements().keySet().iterator().next().getLocalPart());

		element.setName("name2");
		aeq(1, schema.getElements().size());
		aeq(namespace, schema.getElements().keySet().iterator().next().getNamespaceURI());
		aeq("name2", schema.getElements().keySet().iterator().next().getLocalPart());

	}

	@Test
	public void test17() {

		XmlSchemaElement element = new XmlSchemaElement(schema, true);
		an(element.getTargetQName());
		af(element.isRef());
		aeqr(element.getRef(), element.getRefBase());

		QName targetQName = new QName("targetQNameNS", "targetQNameLP");

		XmlSchemaRefBase refBase = element.getRefBase();
		refBase.setTargetQName(targetQName);

		aeq(targetQName, element.getTargetQName());
		at(element.isRef());

	}

	@Test
	public void test18() {

		XmlSchemaElement element = new XmlSchemaElement(schema, true);
		af(element.isFormSpecified());

	}

	@Test
	public void test19() {

		XmlSchemaElement element = new XmlSchemaElement(schema, true);
		at(element.isAnonymous());
		an(element.getName());
		an(element.getWireName());

		element.setName("name");
		af(element.isAnonymous());
		aeq("name", element.getName());
		aeq(new QName("", "name"), element.getWireName());

	}

	@Test
	public void test20() {

		XmlSchemaElement element = new XmlSchemaElement(schema, true);
		element.hashCode();
		element.setAbstract(true);
		element.setNillable(true);
		element.hashCode();

	}

}

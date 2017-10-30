package dux.org.apache.ws.commons.schema.utils;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaException;
import org.apache.ws.commons.schema.XmlSchemaForm;
import org.apache.ws.commons.schema.utils.XmlSchemaNamedWithFormImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.apache.ws.commons.schema.utils.DummyXmlSchemaRefBase;

@Done
public class XmlSchemaNamedWithFormImplTest extends AbstractTest {
	private String namespace;
	private String systemId;
	private XmlSchemaCollection parent;
	private XmlSchema schema;
	private boolean topLevel;
	private boolean element;
	private String name;

	@Before
	public void before() {
		namespace = "namespace";
		systemId = "systemId";
		name = "name";
		parent = new XmlSchemaCollection();
		schema = new XmlSchema(namespace, systemId, parent);
		topLevel = true;
		element = true;
	}

	@Test
	public void test1() {

		aeq(XmlSchemaForm.UNQUALIFIED, schema.getElementFormDefault());
		aeq(XmlSchemaForm.UNQUALIFIED, schema.getAttributeFormDefault());

		XmlSchemaNamedWithFormImpl named = new XmlSchemaNamedWithFormImpl(schema, topLevel, element);
		aeq(XmlSchemaForm.UNQUALIFIED, named.getForm());

		element = false;
		named = new XmlSchemaNamedWithFormImpl(schema, topLevel, element);
		aeq(XmlSchemaForm.UNQUALIFIED, named.getForm());

		named.setForm(XmlSchemaForm.QUALIFIED);
		aeq(XmlSchemaForm.QUALIFIED, named.getForm());

	}

	@Test
	public void test2() {

		XmlSchemaNamedWithFormImpl named = new XmlSchemaNamedWithFormImpl(schema, topLevel, element);
		named.setName(name);
		af(named.isFormSpecified());

		named.setForm(XmlSchemaForm.NONE);
		af(named.isFormSpecified());

		named.setForm(XmlSchemaForm.QUALIFIED);
		at(named.isFormSpecified());

		named.setForm(XmlSchemaForm.UNQUALIFIED);
		at(named.isFormSpecified());

	}

	@Test(expected = XmlSchemaException.class)
	public void test3() {
		XmlSchemaNamedWithFormImpl named = new XmlSchemaNamedWithFormImpl(schema, topLevel, element);
		named.setName(name);
		named.setForm(null);

	}

	/**
	 * Wire name depends on name, form, and presence of a ref object
	 * 
	 * If ref object is present, use that
	 * 
	 * Otherwise, if form is qualified, return qname from super class
	 * 
	 * Otherwise, return name with empty string as namespace
	 **/
	@Test
	public void test4() {

		XmlSchemaNamedWithFormImpl named = new XmlSchemaNamedWithFormImpl(schema, topLevel, element);
		an(named.getWireName());

		named.setName(name);
		aeq(new QName("", name), named.getWireName());

		named.setForm(XmlSchemaForm.QUALIFIED);
		aeq(new QName(namespace, name), named.getWireName());

		String baseNS = "baseNS";
		String baseLP = "baseLP";
		QName baseQN = new QName(baseNS, baseLP);
		DummyXmlSchemaRefBase base = new DummyXmlSchemaRefBase();
		base.setTargetQName(baseQN);
		named.setRefObject(base);
		aeq(baseQN, named.getWireName());

		base.setTargetQName(null);
		aeq(new QName(namespace, name), named.getWireName());
	}

	@Test
	public void test5() {
		XmlSchemaNamedWithFormImpl named = new XmlSchemaNamedWithFormImpl(schema, topLevel, element);
		named.hashCode();

		element = false;
		named = new XmlSchemaNamedWithFormImpl(schema, topLevel, element);
		named.hashCode();

	}
}

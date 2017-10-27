package dux.org.apache.cxf.service.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.cxf.service.model.SchemaInfo;
import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaForm;
import org.apache.ws.commons.schema.XmlSchemaSerializer.XmlSchemaSerializerException;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;

public class SchemaInfoTest extends AbstractTest {

	@Test
	public void test1() {
		String nsUri = "nsUri";
		String nsUri2 = "nsUri2";
		String systemId = "systemId";

		SchemaInfo schemi = new SchemaInfo(nsUri);
		aeq(nsUri, schemi.getNamespaceURI());

		af(schemi.isElementFormQualified());
		af(schemi.isAttributeFormQualified());

		schemi.setSystemId(systemId);
		aeq(systemId, schemi.getSystemId());
		aeq("org.apache.cxf.service.model.SchemaInfo [namespaceURI: nsUri] [systemId: systemId]", schemi.toString());

		schemi.setNamespaceURI(nsUri2);
		aeq(nsUri2, schemi.getNamespaceURI());

		// an(schemi.getSchema());

	}

	/**
	 * Different getters to same properties : smells like fish
	 **/
	@Test
	public void test2() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		String nsUri = "nsUri";
		SchemaInfo schemi = new SchemaInfo(nsUri);

		Method getter = SchemaInfo.class.getDeclaredMethod("getNamespaceUri");
		getter.setAccessible(true);
		aeq(nsUri, schemi.getNamespaceURI());
		aeq(nsUri, getter.invoke(schemi));

		getter = SchemaInfo.class.getDeclaredMethod("isElementQualified");
		getter.setAccessible(true);
		af(schemi.isElementFormQualified());
		af((Boolean) getter.invoke(schemi));

		getter = SchemaInfo.class.getDeclaredMethod("isAttributeQualified");
		getter.setAccessible(true);
		af(schemi.isAttributeFormQualified());
		af((Boolean) getter.invoke(schemi));

	}

	/**
	 * getElement requires an xmlSchema to be set
	 **/
	@Test(expected = RuntimeException.class)
	public void test3() {

		String nsUri = "nsUri";
		SchemaInfo schemi = new SchemaInfo(nsUri);
		Element element = schemi.getElement();

	}

	/**
	 * getElement requires an xmlSchema to be set, but its not enough
	 **/
	@Test(expected = NullPointerException.class)
	public void test4() {

		String nsUri = "nsUri";
		SchemaInfo schemi = new SchemaInfo(nsUri);
		XmlSchema schema = new XmlSchema();
		schemi.setSchema(schema);
		aeq(schema.getElementFormDefault().equals(XmlSchemaForm.QUALIFIED), schemi.isElementFormQualified());
		aeq(schema.getAttributeFormDefault().equals(XmlSchemaForm.QUALIFIED), schemi.isAttributeFormQualified());
		Element element = schemi.getElement();

	}

	/**
	 * getElement requires an xmlSchema to be set, but its not enough
	 * 
	 * @throws XmlSchemaSerializerException
	 **/
	@Test
	public void test5() throws XmlSchemaSerializerException {

		String nsUri = "nsUri";
		String nsUri2 = "nsUri2";
		SchemaInfo schemi = new SchemaInfo(nsUri);
		XmlSchemaCollection parent = new XmlSchemaCollection();
		XmlSchema schema = new XmlSchema(nsUri2, parent);
		schemi.setSchema(schema);
		aeq(schema.getElementFormDefault().equals(XmlSchemaForm.QUALIFIED), schemi.isElementFormQualified());
		aeq(schema.getAttributeFormDefault().equals(XmlSchemaForm.QUALIFIED), schemi.isAttributeFormQualified());

		Element element = schemi.getElement();
		

	}
}

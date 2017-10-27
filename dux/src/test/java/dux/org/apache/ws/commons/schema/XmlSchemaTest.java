package dux.org.apache.ws.commons.schema;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.commons.io.output.NullOutputStream;
import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaAttribute;
import org.apache.ws.commons.schema.XmlSchemaAttributeGroup;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaDerivationMethod;
import org.apache.ws.commons.schema.XmlSchemaElement;
import org.apache.ws.commons.schema.XmlSchemaExternal;
import org.apache.ws.commons.schema.XmlSchemaForm;
import org.apache.ws.commons.schema.XmlSchemaGroup;
import org.apache.ws.commons.schema.XmlSchemaImport;
import org.apache.ws.commons.schema.XmlSchemaInclude;
import org.apache.ws.commons.schema.XmlSchemaNotation;
import org.apache.ws.commons.schema.XmlSchemaSerializer.XmlSchemaSerializerException;
import org.apache.ws.commons.schema.XmlSchemaType;
import org.apache.ws.commons.schema.utils.NamespacePrefixList;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import com.github.docteurdux.test.AbstractTest;

import dum.org.apache.ws.commons.schema.utils.DummyNamespacePrefixList;
import dux.org.apache.ws.commons.schema.XmlSchemaTest.ItemType;

public class XmlSchemaTest extends AbstractTest {

	private String namespace1;
	private String prefix;
	private String systemId;
	private XmlSchemaCollection parent;
	private XmlSchema schema;
	private String sourceURI;

	@Before
	public void before() {
		namespace1 = "namespace1";
		prefix = "prefix";
		systemId = "systemId";
		sourceURI = "sourceURI";
		parent = new XmlSchemaCollection();

		schema = new XmlSchema(namespace1, systemId, parent);
		schema.setSourceURI(sourceURI);
	}

	@Test
	public void test1() {
		schema = new XmlSchema();
		aeq("", schema.getLogicalTargetNamespace());
		an(schema.getParent());
	}

	@Test
	public void test2() {

		aeq(namespace1, schema.getLogicalTargetNamespace());
		aeq(namespace1, schema.getTargetNamespace());
		aeqr(parent, schema.getParent());
		aeqr(schema, schema.getParent().getXmlSchema(systemId)[0]);

		aeq(XmlSchemaForm.UNQUALIFIED, schema.getAttributeFormDefault());
		schema.setAttributeFormDefault(XmlSchemaForm.QUALIFIED);
		aeq(XmlSchemaForm.QUALIFIED, schema.getAttributeFormDefault());

		aeq(XmlSchemaForm.UNQUALIFIED, schema.getElementFormDefault());
		schema.setElementFormDefault(XmlSchemaForm.QUALIFIED);
		aeq(XmlSchemaForm.QUALIFIED, schema.getElementFormDefault());

		XmlSchemaDerivationMethod xsdm = new XmlSchemaDerivationMethod();
		aeq(XmlSchemaDerivationMethod.NONE, schema.getBlockDefault());
		schema.setBlockDefault(xsdm);
		aeqr(xsdm, schema.getBlockDefault());

		aeq(XmlSchemaDerivationMethod.NONE, schema.getFinalDefault());
		schema.setFinalDefault(xsdm);
		aeqr(xsdm, schema.getFinalDefault());

		aeq(0, schema.getItems().size());
		aeq(0, schema.getExternals().size());
		aeq(0, schema.getElements().size());
		aeq(0, schema.getAttributeGroups().size());
		aeq(0, schema.getAttributes().size());
		aeq(0, schema.getGroups().size());
		aeq(0, schema.getNotations().size());
		aeq(0, schema.getSchemaTypes().size());

		String inputEncoding = "inputEncoding";
		an(schema.getInputEncoding());
		schema.setInputEncoding(inputEncoding);
		aeq(inputEncoding, schema.getInputEncoding());

		an(schema.getSchemaNamespacePrefix());
		schema.setSchemaNamespacePrefix(prefix);
		aeq(prefix, schema.getSchemaNamespacePrefix());

		NamespacePrefixList context = new DummyNamespacePrefixList();
		an(schema.getNamespaceContext());
		schema.setNamespaceContext(context);
		aeqr(context, schema.getNamespaceContext());

		an(schema.getVersion());

		schema.toString();

	}

	@Test
	public void test3() throws XmlSchemaSerializerException {

		Document[] documents = schema.getAllSchemas();
		aeq(1, documents.length);

		Document document = documents[0];
		Document schemaDocument = schema.getSchemaDocument();

		for (Document d : new Document[] { document, schemaDocument }) {

			an(d.getAttributes());

			Node schemaNode = d.getChildNodes().item(0);
			aeq("schema", schemaNode.getNodeName());
			af(schemaNode.hasChildNodes());

			NamedNodeMap schemaAttributes = schemaNode.getAttributes();
			aeq(5, schemaAttributes.getLength());
			aeq("unqualified", schemaAttributes.getNamedItem("attributeFormDefault").getNodeValue());
			aeq("unqualified", schemaAttributes.getNamedItem("attributeFormDefault").getNodeValue());
			aeq("unqualified", schemaAttributes.getNamedItem("elementFormDefault").getNodeValue());
			aeq("namespace", schemaAttributes.getNamedItem("targetNamespace").getNodeValue());
			aeq("http://www.w3.org/2001/XMLSchema", schemaAttributes.getNamedItem("xmlns").getNodeValue());
			aeq("namespace", schemaAttributes.getNamedItem("xmlns:tns").getNodeValue());
		}
	}

	@Test
	public void test4() {
		String aQnLp = "aQnLP";
		QName aQn = new QName(aQnLp);
		QName aQnNs = new QName(namespace1, aQnLp);

		XmlSchemaAttribute a = new XmlSchemaAttribute(schema, true);

		an(schema.getAttributeByName(aQn));
		schema.getAttributes().put(aQn, a);
		aeqr(a, schema.getAttributeByName(aQn));

		an(schema.getAttributeByName(aQnLp));
		schema.getAttributes().put(aQnNs, a);
		aeqr(a, schema.getAttributeByName(aQnLp));
	}

	@Test
	public void test5() {
		QName agQn = new QName("agQn");

		XmlSchemaAttributeGroup ag = new XmlSchemaAttributeGroup(schema);

		an(schema.getAttributeGroupByName(agQn));
		schema.getAttributeGroups().put(agQn, ag);
		aeqr(ag, schema.getAttributeGroupByName(agQn));
	}

	@Test
	public void test6() {
		String eQnLp = "eQnLP";
		QName eQn = new QName(eQnLp);
		QName eQnNs = new QName(namespace1, eQnLp);

		XmlSchemaElement e = new XmlSchemaElement(schema, true);

		an(schema.getElementByName(eQn));
		schema.getElements().put(eQn, e);
		aeqr(e, schema.getElementByName(eQn));

		an(schema.getElementByName(eQnLp));
		schema.getElements().put(eQnNs, e);
		aeqr(e, schema.getElementByName(eQnLp));

	}

	@Test
	public void test7() {
		QName gQn = new QName("gQn");

		XmlSchemaGroup g = new XmlSchemaGroup(schema);

		an(schema.getGroupByName(gQn));
		schema.getGroups().put(gQn, g);
		aeqr(g, schema.getGroupByName(gQn));
	}

	@Test
	public void test8() {
		QName nQn = new QName("nQn");

		XmlSchemaNotation n = new XmlSchemaNotation(schema);

		an(schema.getNotationByName(nQn));
		schema.getNotations().put(nQn, n);
		aeqr(n, schema.getNotationByName(nQn));
	}

	@Test
	public void test9() {

		String tQnLp = "tQnLP";
		QName tQn = new QName(tQnLp);
		QName tQnNs = new QName(namespace1, tQnLp);

		XmlSchemaType t = new XmlSchemaType(schema, true) {
		};

		an(schema.getTypeByName(tQn));
		schema.getSchemaTypes().put(tQn, t);
		aeqr(t, schema.getTypeByName(tQn));

		an(schema.getTypeByName(tQnLp));
		schema.getSchemaTypes().put(tQnNs, t);
		aeqr(t, schema.getTypeByName(tQnLp));

	}

	@Test
	public void test10() {

		schema.setTargetNamespace("");
		aeq(namespace1, schema.getLogicalTargetNamespace());
		aeq(namespace1, schema.getTargetNamespace());

		String namespace2 = "namespace2";
		schema.setTargetNamespace(namespace2);
		aeq(namespace2, schema.getLogicalTargetNamespace());
		aeq(namespace2, schema.getTargetNamespace());

		schema.setTargetNamespace(null);
		an(schema.getLogicalTargetNamespace());
		an(schema.getTargetNamespace());

	}

	@Test
	public void test11() throws UnsupportedEncodingException {

		NullOutputStream os = new NullOutputStream();

		schema.setInputEncoding(null);
		schema.write(os);

		schema.setInputEncoding("");
		schema.write(os);

		schema.setInputEncoding("UTF-8");
		schema.write(os);

	}

	@Test
	public void test12() throws UnsupportedEncodingException {

		NullOutputStream os = new NullOutputStream();
		Map<String, String> options = new HashMap<>();

		schema.setInputEncoding(null);
		schema.write(os, options);

		schema.setInputEncoding("");
		schema.write(os, options);

		schema.setInputEncoding("UTF-8");
		schema.write(os, options);

	}

	public static enum ItemType {
		ATTRIBUTE(XmlSchemaAttribute.class);

		Class<?> classType;

		private ItemType(Class<?> classType) {
			this.classType = classType;
		}

		public Class<?> getClassType() {
			return classType;
		}

		public <T> T construct(XmlSchema schema, Class<T> clazz)
				throws InstantiationException, IllegalAccessException, IllegalArgumentException,
				InvocationTargetException, NoSuchMethodException, SecurityException {
			return clazz.getConstructor(XmlSchema.class, boolean.class).newInstance(schema, true);
		}

		@SuppressWarnings("unchecked")
		public <T> Map<QName, T> getAll(XmlSchema schema, Class<T> clazz) throws IllegalAccessException,
				IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
			return (Map<QName, T>) XmlSchema.class.getMethod("getAttributes").invoke(schema);
		}

		@SuppressWarnings("unchecked")
		public <T> T getByName(XmlSchema schema, QName aQn) throws IllegalAccessException, IllegalArgumentException,
				InvocationTargetException, NoSuchMethodException, SecurityException {
			return (T) XmlSchema.class.getMethod("getAttributeByName", QName.class).invoke(schema, aQn);
		}
	};

	/** When an <item> is added to the schema, it is found **/
	public <T> void test13(ItemType itemType, Class<T> clazz) {

		QName aQn = new QName("aQn");
		XmlSchemaAttribute attribute = new XmlSchemaAttribute(schema, true);
		schema.getAttributes().put(aQn, attribute);
		aeqr(attribute, schema.getAttributeByName(aQn));

	}

	/** <Items> in imported schemas are found **/
	public <T> void test14(ItemType itemType, Class<T> clazz) {

		String importNamespace = "importNamespace";
		String importSourceURI = "importSourceURI";

		QName aQn = new QName("aQn");

		XmlSchema importSchema = new XmlSchema(importNamespace, systemId, parent);
		importSchema.setSourceURI(importSourceURI);

		XmlSchemaAttribute attribute = new XmlSchemaAttribute(importSchema, true);
		importSchema.getAttributes().put(aQn, attribute);

		XmlSchemaImport sImport = new XmlSchemaImport(schema);
		sImport.setSchema(importSchema);

		aeqr(attribute, schema.getAttributeByName(aQn));

	}

	/**
	 * <Items> in included schemas are found
	 **/
	public <T> void test15(ItemType itemType, Class<T> clazz) {

		String includeNamespace = "includeNamespace";
		String includeSourceURI = "includeSourceURI";

		QName aQn = new QName("aQn");

		XmlSchema includeSchema = new XmlSchema(includeNamespace, systemId, parent);
		includeSchema.setSourceURI(includeSourceURI);

		XmlSchemaAttribute attribute = new XmlSchemaAttribute(includeSchema, true);
		includeSchema.getAttributes().put(aQn, attribute);

		XmlSchemaInclude sInclude = new XmlSchemaInclude(schema);
		sInclude.setSchema(includeSchema);

		aeqr(attribute, schema.getAttributeByName(aQn));

	}

	/**
	 * <Items> in other kind of externals are ignored
	 **/
	public <T> void test16(ItemType it, Class<T> clazz) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		String externalNamespace = "externacNamespace";
		String externalSourceURI = "externacSourceURI";

		QName aQn = new QName("aQn");

		XmlSchema externalSchema = new XmlSchema(externalNamespace, systemId, parent);
		externalSchema.setSourceURI(externalSourceURI);

		T item = it.construct(externalSchema, clazz);

		Map<QName, T> items = it.getAll(externalSchema, clazz);

		items.put(aQn, item);

		XmlSchemaExternal sExternal = new XmlSchemaExternal(schema) {
		};
		sExternal.setSchema(externalSchema);

		T gottenItem = it.getByName(schema, aQn);

		an(gottenItem);

	}

	/**
	 * Loops do not produce infinite recursion ; btw, schema are considered
	 * identical if their source URI are identical
	 * 
	 **/
	public <T> void test17(ItemType itemType, Class<T> clazz) {

		String includeNamespace = "includeNamespace";

		QName aQn = new QName("aQn");

		XmlSchema includeSchema = new XmlSchema(includeNamespace, systemId, parent);
		includeSchema.setSourceURI(schema.getSourceURI());

		XmlSchemaAttribute attribute = new XmlSchemaAttribute(includeSchema, true);
		includeSchema.getAttributes().put(aQn, attribute);

		XmlSchemaInclude sInclude = new XmlSchemaInclude(schema);
		sInclude.setSchema(includeSchema);

		an(schema.getAttributeByName(aQn));

	}

	/**
	 * To achieve 100% coverage here, use two externals
	 **/
	public <T> void test18(ItemType itemType, Class<T> clazz) {

		String importNamespace = "importNamespace";
		String importSourceURI = "importSourceURI";

		String includeNamespace = "includeNamespace";
		String includeSourceURI = "includeSourceURI";

		QName aQn = new QName("aQn");

		XmlSchema importSchema = new XmlSchema(importNamespace, systemId, parent);
		importSchema.setSourceURI(importSourceURI);

		XmlSchemaImport sImport = new XmlSchemaImport(schema);
		sImport.setSchema(importSchema);

		XmlSchema includeSchema = new XmlSchema(includeNamespace, systemId, parent);
		includeSchema.setSourceURI(includeSourceURI);

		XmlSchemaInclude sInclude = new XmlSchemaInclude(schema);
		sInclude.setSchema(includeSchema);

		schema.getAttributeByName(aQn);

	}

	@Test
	public void test19() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {

		for (ItemType itemType : ItemType.values()) {
			for (int i = 13; i <= 18; ++i) {
				before();
				Class<?> type = itemType.getClassType();
				this.getClass().getMethod("test" + i, ItemType.class, Class.class).invoke(this, itemType, type);
			}
		}

	}
}

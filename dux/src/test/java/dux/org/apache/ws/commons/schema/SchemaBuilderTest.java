package dux.org.apache.ws.commons.schema;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaAnnotationItem;
import org.apache.ws.commons.schema.XmlSchemaAppInfo;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaDocumentation;
import org.apache.ws.commons.schema.XmlSchemaException;
import org.apache.ws.commons.schema.XmlSchemaObject;
import org.apache.ws.commons.schema.XmlSchemaSimpleType;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.github.docteurdux.test.AbstractTest;

public class SchemaBuilderTest extends AbstractTest {

	@Rule
	public TestName testName = new TestName();

	private Document document;
	private XmlSchemaCollection collection;
	private String namespace;
	private XmlSchema schema;

	@Before
	public void before() throws ParserConfigurationException {

		schema = null;
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		namespace = XMLConstants.W3C_XML_SCHEMA_NS_URI;

		collection = new XmlSchemaCollection();
	}

	@After
	public void after() throws UnsupportedEncodingException {
		if (schema != null) {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			schema.write(baos);
			System.out.println("== " + testName.getMethodName() + " ==");
			System.out.println(new String(baos.toByteArray()));
		}
	}

	@Test(expected = XmlSchemaException.class)
	public void test1() throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {

		namespace = "http://www.w3.org/1999/XMLSchema";
		Element parent = document.createElementNS(namespace, "parent");
		document.appendChild(parent);

		Element element = document.createElementNS(namespace, "element");
		parent.appendChild(element);

		schema = collection.read(document);

	}

	@Test
	public void test2() throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {

		namespace = "http://www.w3.org/1999/XMLSchema";
		Element parent = document.createElementNS(namespace, "parent");
		document.appendChild(parent);

		schema = collection.read(document);

	}

	@Test
	public void test3() throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {

		Element parent = document.createElementNS(namespace, "parent");
		document.appendChild(parent);

		Element simpleTypeElement = document.createElementNS(namespace, "simpleType");
		parent.appendChild(simpleTypeElement);

		ann(document.getDocumentElement());

		schema = collection.read(document);

		aeq(0, schema.getAttributes().size());
		aeq(0, schema.getAttributeGroups().size());
		aeq(0, schema.getElements().size());
		aeq(0, schema.getExternals().size());
		aeq(0, schema.getGroups().size());
		aeq(1, schema.getItems().size());
		aeq(0, schema.getNotations().size());
		aeq(0, schema.getSchemaTypes().size());

		XmlSchemaObject item = schema.getItems().iterator().next();

		at(item instanceof XmlSchemaSimpleType);

		XmlSchemaSimpleType simpleType = (XmlSchemaSimpleType) item;
		an(simpleType.getName());

	}

	@Test
	public void test4() throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {

		Element parent = document.createElementNS(namespace, "parent");
		document.appendChild(parent);

		Element simpleTypeElement = document.createElementNS(namespace, "simpleType");
		simpleTypeElement.setAttribute("name", "simpleTypeName");
		parent.appendChild(simpleTypeElement);

		ann(document.getDocumentElement());

		schema = collection.read(document);

		aeq(0, schema.getAttributes().size());
		aeq(0, schema.getAttributeGroups().size());
		aeq(0, schema.getElements().size());
		aeq(0, schema.getExternals().size());
		aeq(0, schema.getGroups().size());
		aeq(1, schema.getItems().size());
		aeq(0, schema.getNotations().size());
		aeq(1, schema.getSchemaTypes().size());

		XmlSchemaObject item = schema.getItems().iterator().next();
		aeqr(item, schema.getSchemaTypes().values().iterator().next());

		at(item instanceof XmlSchemaSimpleType);

		XmlSchemaSimpleType simpleType = (XmlSchemaSimpleType) item;
		aeq("simpleTypeName", simpleType.getName());

	}

	@Test
	public void test5() throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {

		Element parent = document.createElementNS(namespace, "parent");
		document.appendChild(parent);

		Element simpleTypeElement = document.createElementNS(namespace, "simpleType");
		simpleTypeElement.setAttribute("name", "simpleTypeName");
		parent.appendChild(simpleTypeElement);

		Element annotationElement = document.createElementNS(namespace, "annotation");
		simpleTypeElement.appendChild(annotationElement);

		ann(document.getDocumentElement());

		schema = collection.read(document);

		aeq(0, schema.getAttributes().size());
		aeq(0, schema.getAttributeGroups().size());
		aeq(0, schema.getElements().size());
		aeq(0, schema.getExternals().size());
		aeq(0, schema.getGroups().size());
		aeq(1, schema.getItems().size());
		aeq(0, schema.getNotations().size());
		aeq(1, schema.getSchemaTypes().size());

		XmlSchemaObject item = schema.getItems().iterator().next();
		aeqr(item, schema.getSchemaTypes().values().iterator().next());

		at(item instanceof XmlSchemaSimpleType);

		XmlSchemaSimpleType simpleType = (XmlSchemaSimpleType) item;
		aeq("simpleTypeName", simpleType.getName());
		ann(simpleType.getAnnotation());

	}

	@Test
	public void test6() throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {

		Element parent = document.createElementNS(namespace, "parent");
		document.appendChild(parent);

		Element simpleTypeElement = document.createElementNS(namespace, "simpleType");
		simpleTypeElement.setAttribute("name", "simpleTypeName");
		parent.appendChild(simpleTypeElement);

		Element annotationElement = document.createElementNS(namespace, "annotation");
		simpleTypeElement.appendChild(annotationElement);

		Element appInfoElement = document.createElementNS(namespace, "appinfo");
		appInfoElement.setAttribute("source", "source");
		annotationElement.appendChild(appInfoElement);

		ann(document.getDocumentElement());

		schema = collection.read(document);

		aeq(0, schema.getAttributes().size());
		aeq(0, schema.getAttributeGroups().size());
		aeq(0, schema.getElements().size());
		aeq(0, schema.getExternals().size());
		aeq(0, schema.getGroups().size());
		aeq(1, schema.getItems().size());
		aeq(0, schema.getNotations().size());
		aeq(1, schema.getSchemaTypes().size());

		XmlSchemaObject item = schema.getItems().iterator().next();
		aeqr(item, schema.getSchemaTypes().values().iterator().next());

		at(item instanceof XmlSchemaSimpleType);

		XmlSchemaSimpleType simpleType = (XmlSchemaSimpleType) item;
		aeq("simpleTypeName", simpleType.getName());
		ann(simpleType.getAnnotation());
		aeq(1, simpleType.getAnnotation().getItems().size());
		XmlSchemaAppInfo appInfo = (XmlSchemaAppInfo) simpleType.getAnnotation().getItems().iterator().next();
		aeq("source", appInfo.getSource());

	}

	@Test
	public void test7() throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {

		Element parent = document.createElementNS(namespace, "parent");
		document.appendChild(parent);

		Element simpleTypeElement = document.createElementNS(namespace, "simpleType");
		simpleTypeElement.setAttribute("name", "simpleTypeName");
		parent.appendChild(simpleTypeElement);

		Element annotationElement = document.createElementNS(namespace, "annotation");
		simpleTypeElement.appendChild(annotationElement);

		Element appInfoElement = document.createElementNS(namespace, "appinfo");
		annotationElement.appendChild(appInfoElement);

		ann(document.getDocumentElement());

		schema = collection.read(document);

		aeq(0, schema.getAttributes().size());
		aeq(0, schema.getAttributeGroups().size());
		aeq(0, schema.getElements().size());
		aeq(0, schema.getExternals().size());
		aeq(0, schema.getGroups().size());
		aeq(1, schema.getItems().size());
		aeq(0, schema.getNotations().size());
		aeq(1, schema.getSchemaTypes().size());

		XmlSchemaObject item = schema.getItems().iterator().next();
		aeqr(item, schema.getSchemaTypes().values().iterator().next());

		at(item instanceof XmlSchemaSimpleType);

		XmlSchemaSimpleType simpleType = (XmlSchemaSimpleType) item;
		aeq("simpleTypeName", simpleType.getName());
		ann(simpleType.getAnnotation());
		aeq(0, simpleType.getAnnotation().getItems().size());

	}

	@Test
	public void test8() throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {

		Element parent = document.createElementNS(namespace, "parent");
		document.appendChild(parent);

		Element simpleTypeElement = document.createElementNS(namespace, "simpleType");
		simpleTypeElement.setAttribute("name", "simpleTypeName");
		parent.appendChild(simpleTypeElement);

		Element annotationElement = document.createElementNS(namespace, "annotation");
		simpleTypeElement.appendChild(annotationElement);

		Element appInfoElement = document.createElementNS(namespace, "appinfo");
		annotationElement.appendChild(appInfoElement);

		Element appInfoChild = document.createElementNS(namespace, "appInfoChild");
		appInfoElement.appendChild(appInfoChild);

		ann(document.getDocumentElement());

		schema = collection.read(document);

		aeq(0, schema.getAttributes().size());
		aeq(0, schema.getAttributeGroups().size());
		aeq(0, schema.getElements().size());
		aeq(0, schema.getExternals().size());
		aeq(0, schema.getGroups().size());
		aeq(1, schema.getItems().size());
		aeq(0, schema.getNotations().size());
		aeq(1, schema.getSchemaTypes().size());

		XmlSchemaObject item = schema.getItems().iterator().next();
		aeqr(item, schema.getSchemaTypes().values().iterator().next());

		at(item instanceof XmlSchemaSimpleType);

		XmlSchemaSimpleType simpleType = (XmlSchemaSimpleType) item;
		aeq("simpleTypeName", simpleType.getName());
		ann(simpleType.getAnnotation());
		aeq(1, simpleType.getAnnotation().getItems().size());
		XmlSchemaAppInfo appInfo = (XmlSchemaAppInfo) simpleType.getAnnotation().getItems().iterator().next();
		an(appInfo.getSource());
		aeq(1, appInfo.getMarkup().getLength());
		aeq("appInfoChild", appInfo.getMarkup().item(0).getNodeName());

	}

	@Test
	public void test9() throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {

		Element parent = document.createElementNS(namespace, "parent");
		document.appendChild(parent);

		Element simpleTypeElement = document.createElementNS(namespace, "simpleType");
		simpleTypeElement.setAttribute("name", "simpleTypeName");
		parent.appendChild(simpleTypeElement);

		Element annotationElement = document.createElementNS(namespace, "annotation");
		simpleTypeElement.appendChild(annotationElement);

		Element documentationElement = document.createElementNS(namespace, "documentation");
		annotationElement.appendChild(documentationElement);

		ann(document.getDocumentElement());

		schema = collection.read(document);

		aeq(0, schema.getAttributes().size());
		aeq(0, schema.getAttributeGroups().size());
		aeq(0, schema.getElements().size());
		aeq(0, schema.getExternals().size());
		aeq(0, schema.getGroups().size());
		aeq(1, schema.getItems().size());
		aeq(0, schema.getNotations().size());
		aeq(1, schema.getSchemaTypes().size());

		XmlSchemaObject item = schema.getItems().iterator().next();
		aeqr(item, schema.getSchemaTypes().values().iterator().next());

		at(item instanceof XmlSchemaSimpleType);

		XmlSchemaSimpleType simpleType = (XmlSchemaSimpleType) item;
		aeq("simpleTypeName", simpleType.getName());
		ann(simpleType.getAnnotation());
		aeq(0, simpleType.getAnnotation().getItems().size());

	}

	@Test
	public void test10() throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {

		Element parent = document.createElementNS(namespace, "parent");
		document.appendChild(parent);

		Element simpleTypeElement = document.createElementNS(namespace, "simpleType");
		simpleTypeElement.setAttribute("name", "simpleTypeName");
		parent.appendChild(simpleTypeElement);

		Element annotationElement = document.createElementNS(namespace, "annotation");
		simpleTypeElement.appendChild(annotationElement);

		Element documentationElement = document.createElementNS(namespace, "documentation");
		documentationElement.setAttribute("source", "source");
		annotationElement.appendChild(documentationElement);

		ann(document.getDocumentElement());

		schema = collection.read(document);

		aeq(0, schema.getAttributes().size());
		aeq(0, schema.getAttributeGroups().size());
		aeq(0, schema.getElements().size());
		aeq(0, schema.getExternals().size());
		aeq(0, schema.getGroups().size());
		aeq(1, schema.getItems().size());
		aeq(0, schema.getNotations().size());
		aeq(1, schema.getSchemaTypes().size());

		XmlSchemaObject item = schema.getItems().iterator().next();
		aeqr(item, schema.getSchemaTypes().values().iterator().next());

		at(item instanceof XmlSchemaSimpleType);

		XmlSchemaSimpleType simpleType = (XmlSchemaSimpleType) item;
		aeq("simpleTypeName", simpleType.getName());
		ann(simpleType.getAnnotation());
		aeq(1, simpleType.getAnnotation().getItems().size());
		XmlSchemaDocumentation documentation = (XmlSchemaDocumentation) simpleType.getAnnotation().getItems().iterator()
				.next();
		aeq("source", documentation.getSource());
	}

	@Test
	public void test11() throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {

		Element parent = document.createElementNS(namespace, "parent");
		document.appendChild(parent);

		Element simpleTypeElement = document.createElementNS(namespace, "simpleType");
		simpleTypeElement.setAttribute("name", "simpleTypeName");
		parent.appendChild(simpleTypeElement);

		Element annotationElement = document.createElementNS(namespace, "annotation");
		simpleTypeElement.appendChild(annotationElement);

		Element documentationElement = document.createElementNS(namespace, "documentation");
		documentationElement.setAttribute("xml:lang", "xmllang");
		annotationElement.appendChild(documentationElement);

		ann(document.getDocumentElement());

		schema = collection.read(document);

		aeq(0, schema.getAttributes().size());
		aeq(0, schema.getAttributeGroups().size());
		aeq(0, schema.getElements().size());
		aeq(0, schema.getExternals().size());
		aeq(0, schema.getGroups().size());
		aeq(1, schema.getItems().size());
		aeq(0, schema.getNotations().size());
		aeq(1, schema.getSchemaTypes().size());

		XmlSchemaObject item = schema.getItems().iterator().next();
		aeqr(item, schema.getSchemaTypes().values().iterator().next());

		at(item instanceof XmlSchemaSimpleType);

		XmlSchemaSimpleType simpleType = (XmlSchemaSimpleType) item;
		aeq("simpleTypeName", simpleType.getName());
		ann(simpleType.getAnnotation());
		aeq(1, simpleType.getAnnotation().getItems().size());
		XmlSchemaDocumentation documentation = (XmlSchemaDocumentation) simpleType.getAnnotation().getItems().iterator()
				.next();
		an(documentation.getSource());
		aeq("xmllang", documentation.getLanguage());
	}

	@Test
	public void test12() throws InstantiationException, IllegalAccessException, UnsupportedEncodingException {

		Element parent = document.createElementNS(namespace, "parent");
		document.appendChild(parent);

		Element simpleTypeElement = document.createElementNS(namespace, "simpleType");
		simpleTypeElement.setAttribute("name", "simpleTypeName");
		parent.appendChild(simpleTypeElement);

		Element annotationElement = document.createElementNS(namespace, "annotation");
		simpleTypeElement.appendChild(annotationElement);

		Element documentationElement = document.createElementNS(namespace, "documentation");
		annotationElement.appendChild(documentationElement);

		Element documentationChild = document.createElementNS(namespace, "documentationChild");
		documentationElement.appendChild(documentationChild);

		ann(document.getDocumentElement());

		schema = collection.read(document);

		aeq(0, schema.getAttributes().size());
		aeq(0, schema.getAttributeGroups().size());
		aeq(0, schema.getElements().size());
		aeq(0, schema.getExternals().size());
		aeq(0, schema.getGroups().size());
		aeq(1, schema.getItems().size());
		aeq(0, schema.getNotations().size());
		aeq(1, schema.getSchemaTypes().size());

		XmlSchemaObject item = schema.getItems().iterator().next();
		aeqr(item, schema.getSchemaTypes().values().iterator().next());

		at(item instanceof XmlSchemaSimpleType);

		XmlSchemaSimpleType simpleType = (XmlSchemaSimpleType) item;
		aeq("simpleTypeName", simpleType.getName());
		ann(simpleType.getAnnotation());
		aeq(1, simpleType.getAnnotation().getItems().size());
		XmlSchemaDocumentation documentation = (XmlSchemaDocumentation) simpleType.getAnnotation().getItems().iterator()
				.next();
		an(documentation.getSource());
		an(documentation.getLanguage());
		aeq(1, documentation.getMarkup().getLength());
		aeq("documentationChild", documentation.getMarkup().item(0).getNodeName());
	}
	
	// stopped at SchemaBuilder line 593 : handleSimpleType
}

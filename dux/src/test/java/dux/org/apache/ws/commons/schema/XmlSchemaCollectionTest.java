package dux.org.apache.ws.commons.schema;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaCollection.SchemaKey;
import org.apache.ws.commons.schema.extensions.ExtensionRegistry;
import org.apache.ws.commons.schema.resolver.URIResolver;
import org.apache.ws.commons.schema.utils.NamespacePrefixList;
import org.apache.ws.commons.schema.utils.TargetNamespaceValidator;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

import com.github.docteurdux.test.AbstractTest;

import dum.javax.xml.transform.DummySource;
import dum.org.apache.ws.commons.schema.resolver.DummyURIResolver;
import dum.org.apache.ws.commons.schema.utils.DummyNamespacePrefixList;
import dum.org.apache.ws.commons.schema.utils.DummyTargetNamespaceValidator;

public class XmlSchemaCollectionTest extends AbstractTest {

	private Document document;
	private String systemId;
	private String namespace;

	@Before
	public void before() throws ParserConfigurationException {

		namespace = "namespace";
		systemId = "systemId";

		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	}

	public void foo() {
		XmlSchemaCollection collection = new XmlSchemaCollection();
		SchemaKey key = null;
		collection.check(key);
		ann(collection.getExtReg());
		aeq(0, collection.getKnownNamespaceMap().size());
		an(collection.getNamespaceContext());
		ann(collection.getSchemaResolver());

		an(collection.getTypeByQName(new QName(namespace, "name")));

		aeq(0, collection.getXmlSchema(systemId).length);
		aeq(1, collection.getXmlSchemas().length);
		collection.push(null);
		collection.pop();
		// collection.read(document, "systemId");
		TargetNamespaceValidator validator = new DummyTargetNamespaceValidator();
		// collection.read(document, "systemId", validator );
		// collection.read(document);
		Element element = document.createElementNS(namespace, "element");
		collection.read(element);
		collection.read(element, systemId);
		ByteArrayInputStream bais = new ByteArrayInputStream(new byte[] {});
		InputSource inputSource = new InputSource(bais);
		// collection.read(inputSource);
		Reader reader = new InputStreamReader(bais);
		Source source = new DummySource(systemId);
		// collection.read(reader);
		// collection.read(source);
		collection.schemaForNamespace(namespace);
		collection.setBaseUri(namespace);
		ExtensionRegistry extReg = new ExtensionRegistry();
		collection.setExtReg(extReg);
		Map<String, XmlSchema> knownNamespaceMap = new HashMap<>();
		collection.setKnownNamespaceMap(knownNamespaceMap);
		NamespacePrefixList namespaceContext = new DummyNamespacePrefixList();
		collection.setNamespaceContext(namespaceContext);
		URIResolver schemaResolver = new DummyURIResolver();
		collection.setSchemaResolver(schemaResolver);
		collection.toString();
		QName schemaAttributeName = new QName("");
		collection.getAttributeByQName(schemaAttributeName);
		collection.getElementByQName(schemaAttributeName);
		collection.getAttributeGroupByQName(schemaAttributeName);
		collection.getGroupByQName(schemaAttributeName);
		collection.getNotationByQName(schemaAttributeName);
		
		collection.read(document);
	}

}

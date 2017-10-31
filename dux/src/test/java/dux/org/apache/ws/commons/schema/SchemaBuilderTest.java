package dux.org.apache.ws.commons.schema;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;

public class SchemaBuilderTest extends AbstractTest {

	private Document document;
	private XmlSchemaCollection collection;

	@Before
	public void before() throws ParserConfigurationException {

		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

		collection = new XmlSchemaCollection();
	}

	@Test
	public void test1() throws InstantiationException, IllegalAccessException {
		
		Element element = document.createElementNS("namespace", "element");
		document.appendChild(element);
		
		ann(document.getDocumentElement());
		
		collection.read(document);
	}

}

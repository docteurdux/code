package dux.org.apache.neethi.builders.converters;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLStreamReader;

import org.apache.neethi.builders.converters.DOMToStaxConverter;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class DOMToStaxConverterTest extends AbstractTest {

	private Document document;

	@Before
	public void before() throws Exception {
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	}

	@Test
	public void test() throws Exception {
		DOMToStaxConverter converter = new DOMToStaxConverter();
		Element element = document.createElementNS("elementNS", "elementLP");
		XMLStreamReader streamReader = converter.convert(element);

		at(streamReader.hasNext());

		streamReader.next();

		aeq(0, streamReader.getAttributeCount());
		at(streamReader.hasName());
		aeq(new QName("elementNS", "elementLP"), streamReader.getName());

		streamReader.close();

	}
}

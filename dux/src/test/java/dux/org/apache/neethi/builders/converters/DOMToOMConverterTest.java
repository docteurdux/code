package dux.org.apache.neethi.builders.converters;

import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.llom.OMElementImpl;
import org.apache.neethi.builders.converters.DOMToOMConverter;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class DOMToOMConverterTest extends AbstractTest {

	private Document document;

	@Before
	public void before() throws Exception {
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
	}

	@Test
	public void test() {
		DOMToOMConverter converter = new DOMToOMConverter();
		Element element = document.createElementNS("elementNS", "elementLP");
		OMElement result = converter.convert(element);
		aeq(OMElementImpl.class, result.getClass());
	}
}

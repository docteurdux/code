package dux.org.apache.neethi.builders.converters;

import java.util.Arrays;

import org.apache.neethi.builders.converters.OMToDOMConverter;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.xml.stream.DummyXMLStreamReader;
import dum.javax.xml.stream.DummyXMLStreamReader.Event;
import dux.org.apache.axiom.om.DummyOMElement;

@Done
public class OMToDOMConverterTest extends AbstractTest {

	private DummyXMLStreamReader streamReader;
	private DummyOMElement element;

	@Before
	public void before() {

		streamReader = new DummyXMLStreamReader();

		streamReader.setEvents(
				Arrays.asList(new Event[] { Event.startElement("elementNS", "elementLP"), Event.endElement() }));

		element = new DummyOMElement();
		element.setXmlStreamReader(streamReader);
	}

	@Test
	public void test() {

		OMToDOMConverter converter = new OMToDOMConverter();

		Element result = converter.convert(element);

		aeq(result.getNamespaceURI(), "elementNS");
		aeq(result.getNodeName(), "elementLP");

	}
}

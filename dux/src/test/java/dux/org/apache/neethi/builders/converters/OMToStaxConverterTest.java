package dux.org.apache.neethi.builders.converters;

import javax.xml.stream.XMLStreamReader;

import org.apache.neethi.builders.converters.OMToStaxConverter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.javax.xml.stream.DummyXMLStreamReader;
import dux.org.apache.axiom.om.DummyOMElement;

public class OMToStaxConverterTest extends AbstractTest {

	private DummyXMLStreamReader xmlStreamReader;
	private DummyOMElement element;

	@Before
	public void before() {

		xmlStreamReader = new DummyXMLStreamReader();

		element = new DummyOMElement();
		element.setXmlStreamReader(xmlStreamReader);
	}

	@Test
	public void test() {

		OMToStaxConverter converter = new OMToStaxConverter();

		XMLStreamReader result = converter.convert(element);

		aeqr(xmlStreamReader, result);

	}
}

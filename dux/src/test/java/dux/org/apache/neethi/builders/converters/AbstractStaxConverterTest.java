package dux.org.apache.neethi.builders.converters;

import java.util.Arrays;

import org.apache.neethi.builders.converters.AbstractStaxConverter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.javax.xml.stream.DummyXMLStreamReader;
import dum.javax.xml.stream.DummyXMLStreamReader.Event;

public class AbstractStaxConverterTest extends AbstractTest {

	private DummyXMLStreamReader streamReader;

	@Before
	public void before() {

		streamReader = new DummyXMLStreamReader();

		streamReader.setEvents(Arrays.asList(new Event[] {

				Event.startElement("elementNS", "elementLP"),

				Event.endElement()

		}));
	}

	@Test
	public void test() {

		AbstractStaxConverter converter = new AbstractStaxConverter() {
		};

		converter.getQName(streamReader);

		converter.getAttributes(streamReader);

		converter.getChildren(streamReader);
	}
}

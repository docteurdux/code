package dux.org.apache.neethi.builders.converters;

import java.util.Arrays;

import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.impl.llom.OMElementImpl;
import org.apache.neethi.builders.converters.StaxToOMConverter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.xml.stream.DummyXMLStreamReader;
import dum.javax.xml.stream.DummyXMLStreamReader.Event;

@Done
public class StaxToOMConverterTest extends AbstractTest {

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

		StaxToOMConverter converter = new StaxToOMConverter();

		OMElement result = converter.convert(streamReader);

		aeq(OMElementImpl.class, result.getClass());
	}
}

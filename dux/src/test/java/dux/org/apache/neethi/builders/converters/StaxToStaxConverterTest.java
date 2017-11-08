package dux.org.apache.neethi.builders.converters;

import javax.xml.stream.XMLStreamReader;

import org.apache.neethi.builders.converters.StaxToStaxConverter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.xml.stream.DummyXMLStreamReader;

@Done
public class StaxToStaxConverterTest extends AbstractTest {

	private XMLStreamReader streamReader;

	@Before
	public void before() {
		streamReader = new DummyXMLStreamReader();
	}

	@Test
	public void test() {

		StaxToStaxConverter converter = new StaxToStaxConverter();

		aeqr(streamReader, converter.convert(streamReader));
	}
}

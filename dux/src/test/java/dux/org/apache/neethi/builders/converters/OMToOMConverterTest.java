package dux.org.apache.neethi.builders.converters;

import org.apache.axiom.om.OMElement;
import org.apache.neethi.builders.converters.OMToOMConverter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dux.org.apache.axiom.om.DummyOMElement;

@Done
public class OMToOMConverterTest extends AbstractTest {
	private OMElement element;

	@Before
	public void before() {

		element = new DummyOMElement();
	}

	@Test
	public void test() {

		OMToOMConverter converter = new OMToOMConverter();

		aeqr(element, converter.convert(element));
	}
}

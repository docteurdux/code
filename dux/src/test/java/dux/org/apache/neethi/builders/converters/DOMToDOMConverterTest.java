package dux.org.apache.neethi.builders.converters;

import org.apache.neethi.builders.converters.DOMToDOMConverter;
import org.junit.Test;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.w3c.dom.DummyElement;

@Done
public class DOMToDOMConverterTest extends AbstractTest {

	@Test
	public void test() {
		DOMToDOMConverter converter = new DOMToDOMConverter();
		Element element = new DummyElement();
		aeqr(element, converter.convert(element));
	}
}

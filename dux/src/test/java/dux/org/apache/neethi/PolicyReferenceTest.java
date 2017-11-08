package dux.org.apache.neethi;

import javax.xml.stream.XMLStreamException;

import org.apache.neethi.PolicyReference;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.javax.xml.stream.DummyXMLStreamWriter;

public class PolicyReferenceTest extends AbstractTest {
	@Test
	public void test() throws XMLStreamException {
		PolicyReference reference = new PolicyReference();

		DummyXMLStreamWriter writer = new DummyXMLStreamWriter();
		reference.serialize(writer);
		dumpTestEvents(writer);

	}
}

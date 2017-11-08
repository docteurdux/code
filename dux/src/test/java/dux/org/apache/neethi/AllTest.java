package dux.org.apache.neethi;

import java.util.Map.Entry;

import javax.xml.stream.XMLStreamException;

import org.apache.neethi.All;
import org.apache.neethi.Assertion;
import org.apache.neethi.Constants;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.TestEvent;

import dum.javax.xml.stream.DummyXMLStreamWriter;
import dum.org.apache.neethi.DummyAssertion;

public class AllTest extends AbstractTest {
	@Test
	public void test() throws XMLStreamException {
		All all = new All();
		Assertion assertion = new DummyAssertion();
		all.addAssertion(assertion);
		aeqr(assertion, all.getAssertions().get(0));

		aeq(Constants.TYPE_ALL, all.getType());

		DummyXMLStreamWriter writer = new DummyXMLStreamWriter();
		all.serialize(writer);

		for (TestEvent te : writer.getTestEvents()) {
			System.out.println(te.getName());
			for (Entry<String, Object> prop : te.getProps().entrySet()) {
				System.out.println(" - " + prop.getKey() + " : " + str(prop.getValue()));
			}
		}
	}
}

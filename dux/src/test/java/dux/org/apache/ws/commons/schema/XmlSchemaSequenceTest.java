package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaSequence;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaSequenceTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaSequence sequence = new XmlSchemaSequence();
		aeq(0, sequence.getItems().size());
	}

}

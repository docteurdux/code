package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaChoice;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaChoiceTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaChoice choice = new XmlSchemaChoice();
		aeq(0, choice.getItems().size());
	}

}

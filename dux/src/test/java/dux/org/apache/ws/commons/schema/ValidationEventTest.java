package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.ValidationEvent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class ValidationEventTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		Object source = new Object();
		ValidationEvent event = new ValidationEvent(source);
	}

}

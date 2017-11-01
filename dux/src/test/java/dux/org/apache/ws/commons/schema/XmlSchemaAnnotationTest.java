package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaAnnotation;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaAnnotationTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaAnnotation annotation = new XmlSchemaAnnotation();
		aeq(0, annotation.getItems().size());
	}

}

package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaContent;
import org.apache.ws.commons.schema.XmlSchemaSimpleContent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaSimpleContentTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaSimpleContent simpleContent = new XmlSchemaSimpleContent();

		XmlSchemaContent content = new XmlSchemaContent() {
		};
		an(simpleContent.getContent());
		simpleContent.setContent(content);
		aeqr(content, simpleContent.getContent());
	}

}

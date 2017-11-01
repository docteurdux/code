package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaComplexContent;
import org.apache.ws.commons.schema.XmlSchemaContent;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaComplexContentTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaComplexContent complexContent = new XmlSchemaComplexContent();

		XmlSchemaContent content = new XmlSchemaContent() {
		};
		an(complexContent.getContent());
		complexContent.setContent(content);
		aeqr(content, complexContent.getContent());

		af(complexContent.isMixed());
		complexContent.setMixed(true);
		at(complexContent.isMixed());
	}

}

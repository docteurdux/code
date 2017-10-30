package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaContent;
import org.apache.ws.commons.schema.XmlSchemaContentModel;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class XmlSchemaContentModelTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaContentModel model = new XmlSchemaContentModel() {

			@Override
			public void setContent(XmlSchemaContent content) {
			}

			@Override
			public XmlSchemaContent getContent() {
				return null;
			}
		};
	}

}

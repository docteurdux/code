package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaAnnotationItem;
import org.apache.ws.commons.schema.XmlSchemaAppInfo;
import org.apache.ws.commons.schema.XmlSchemaDocumentation;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaAnnotationItemTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		aeq(XmlSchemaAnnotationItem.class, XmlSchemaAppInfo.class.getSuperclass());
		aeq(XmlSchemaAnnotationItem.class, XmlSchemaDocumentation.class.getSuperclass());
	}

}

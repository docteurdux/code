package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaAnyAttribute;
import org.apache.ws.commons.schema.XmlSchemaContentProcessing;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaAnyAttributeTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaAnyAttribute aa = new XmlSchemaAnyAttribute();

		an(aa.getNamespace());
		aa.setNamespace("namespace");
		aeq("namespace", aa.getNamespace());

		aeq(XmlSchemaContentProcessing.NONE, aa.getProcessContent());
		aa.setProcessContent(XmlSchemaContentProcessing.LAX);
		aeq(XmlSchemaContentProcessing.LAX, aa.getProcessContent());
	}

}

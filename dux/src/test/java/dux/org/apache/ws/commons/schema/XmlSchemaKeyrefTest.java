package dux.org.apache.ws.commons.schema;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchemaKeyref;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaKeyrefTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaKeyref keyref = new XmlSchemaKeyref();
		QName referQn = new QName("referNS", "referLP");

		an(keyref.getRefer());
		keyref.setRefer(referQn);
		aeq(referQn, keyref.getRefer());
	}

}

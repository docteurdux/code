package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaAll;
import org.apache.ws.commons.schema.XmlSchemaChoice;
import org.apache.ws.commons.schema.XmlSchemaGroupParticle;
import org.apache.ws.commons.schema.XmlSchemaSequence;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaGroupParticleTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		aeq(XmlSchemaGroupParticle.class, XmlSchemaAll.class.getSuperclass());
		aeq(XmlSchemaGroupParticle.class, XmlSchemaChoice.class.getSuperclass());
		aeq(XmlSchemaGroupParticle.class, XmlSchemaSequence.class.getSuperclass());
	}

}

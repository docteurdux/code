package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaParticle;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaParticleTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaParticle particle = new XmlSchemaParticle() {
		};

		aeq(1L, particle.getMaxOccurs());
		particle.setMaxOccurs(2);
		aeq(2L, particle.getMaxOccurs());

		aeq(1L, particle.getMinOccurs());
		particle.setMinOccurs(3);
		aeq(3L, particle.getMinOccurs());

	}

}

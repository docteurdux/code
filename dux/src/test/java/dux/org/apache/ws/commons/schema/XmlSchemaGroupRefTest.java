package dux.org.apache.ws.commons.schema;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchemaGroupParticle;
import org.apache.ws.commons.schema.XmlSchemaGroupRef;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaGroupRefTest extends AbstractTest {

	private String refNameNS;
	private String refNameLP;
	private QName refName;
	private XmlSchemaGroupParticle particle;

	@Before
	public void before() {
		refNameNS = "refNameNS";
		refNameLP = "refNameLP";
		refName = new QName(refNameNS, refNameLP);

		particle = new XmlSchemaGroupParticle() {
		};
	}

	@Test
	public void test1() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		XmlSchemaGroupRef ref = new XmlSchemaGroupRef();

		an(ref.getRefName());
		ref.setRefName(refName);
		aeq(refName, ref.getRefName());

		an(ref.getParticle());

		Method setParticle = XmlSchemaGroupRef.class.getDeclaredMethod("setParticle", XmlSchemaGroupParticle.class);
		setParticle.setAccessible(true);
		setParticle.invoke(ref, particle);

		aeqr(particle, ref.getParticle());

	}

}

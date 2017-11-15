package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmGeneratorSpecificationType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmGeneratorSpecificationTypeTest extends AbstractTest {
	
	@Test
	public void test() {
		JaxbHbmGeneratorSpecificationType jaxbHbmGeneratorSpecificationType = new JaxbHbmGeneratorSpecificationType();

		an(jaxbHbmGeneratorSpecificationType.getClazz());
		jaxbHbmGeneratorSpecificationType.setClazz("clazz");
		aeq("clazz", jaxbHbmGeneratorSpecificationType.getClazz());
	}
}

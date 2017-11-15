package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmTypeSpecificationType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmTypeSpecificationTypeTest extends AbstractTest {
	
	@Test
	public void test() {

		JaxbHbmTypeSpecificationType jaxbHbmTypeSpecificationType = new JaxbHbmTypeSpecificationType();
		an(jaxbHbmTypeSpecificationType.getName());
		jaxbHbmTypeSpecificationType.setName("name");
		aeq("name", jaxbHbmTypeSpecificationType.getName());
	}
}

package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmParentType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmParentTypeTest extends AbstractTest {

	@Test
	public void tes() {
		JaxbHbmParentType jaxbHbmParentType = new JaxbHbmParentType();

		an(jaxbHbmParentType.getName());
		jaxbHbmParentType.setName("name");
		aeq("name", jaxbHbmParentType.getName());
	}
}

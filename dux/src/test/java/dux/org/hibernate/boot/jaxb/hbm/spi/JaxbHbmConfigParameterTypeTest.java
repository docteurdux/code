package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmConfigParameterType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmConfigParameterTypeTest extends AbstractTest {
	@Test
	public void test() {

		JaxbHbmConfigParameterType jaxbHbmConfigParameterType = new JaxbHbmConfigParameterType();

		an(jaxbHbmConfigParameterType.getValue());
		jaxbHbmConfigParameterType.setValue("value");
		aeq("value", jaxbHbmConfigParameterType.getValue());

		an(jaxbHbmConfigParameterType.getName());
		jaxbHbmConfigParameterType.setName("name");
		aeq("name", jaxbHbmConfigParameterType.getName());

	}
}

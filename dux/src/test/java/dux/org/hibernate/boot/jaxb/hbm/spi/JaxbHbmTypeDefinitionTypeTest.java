package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmTypeDefinitionType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmTypeDefinitionTypeTest extends AbstractTest {

	@Test
	public void test() {

		JaxbHbmTypeDefinitionType j = new JaxbHbmTypeDefinitionType();

		an(j.getClazz());
		j.setClazz("clazz");
		aeq("clazz", j.getClazz());

		an(j.getName());
		j.setName("name");
		aeq("name", j.getName());
	}
}

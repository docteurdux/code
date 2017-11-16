package dux.org.hibernate.boot.jaxb.cfg.spi;

import org.hibernate.boot.jaxb.cfg.spi.JaxbCfgConfigPropertyType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbCfgConfigPropertyTypeTest extends AbstractTest {
	@Test
	public void test() {

		JaxbCfgConfigPropertyType j = new JaxbCfgConfigPropertyType();

		an(j.getValue());
		j.setValue("value");
		aeq("value", j.getValue());

		an(j.getName());
		j.setName("name");
		aeq("name", j.getName());
	}
}

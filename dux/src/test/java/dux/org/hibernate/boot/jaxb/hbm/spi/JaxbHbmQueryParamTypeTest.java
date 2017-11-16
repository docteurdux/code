package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmQueryParamType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmQueryParamTypeTest extends AbstractTest {
	@Test
	public void test() {

		JaxbHbmQueryParamType j = new JaxbHbmQueryParamType();

		an(j.getName());
		j.setName("name");
		aeq("name", j.getName());

		an(j.getType());
		j.setType("type");
		aeq("type", j.getType());
	}
}

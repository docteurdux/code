package dux.org.hibernate.boot.jaxb.hbm.spi;

import javax.xml.bind.JAXBException;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmFilterParameterType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmFilterParameterTypeTest extends AbstractTest {
	@Test
	public void test() throws JAXBException {
		JaxbHbmFilterParameterType j = new JaxbHbmFilterParameterType();

		an(j.getParameterName());
		j.setParameterName("parameterName");
		aeq("parameterName", j.getParameterName());

		an(j.getParameterValueTypeName());
		j.setParameterValueTypeName("parameterValueTypeName");
		aeq("parameterValueTypeName", j.getParameterValueTypeName());

	}
}

package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNativeQueryScalarReturnType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmNativeQueryScalarReturnTypeTest extends AbstractTest {
	@Test
	public void test() {
		JaxbHbmNativeQueryScalarReturnType jaxbHbmNativeQueryScalarReturnType = new JaxbHbmNativeQueryScalarReturnType();

		an(jaxbHbmNativeQueryScalarReturnType.getColumn());
		jaxbHbmNativeQueryScalarReturnType.setColumn("column");
		aeq("column", jaxbHbmNativeQueryScalarReturnType.getColumn());

		an(jaxbHbmNativeQueryScalarReturnType.getType());
		jaxbHbmNativeQueryScalarReturnType.setType("type");
		aeq("type", jaxbHbmNativeQueryScalarReturnType.getType());
	}
}

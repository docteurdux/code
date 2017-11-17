package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmAnyValueMappingType;
import org.junit.Test;

import com.github.docteurdux.test.Done;

@Done
public final class JaxbHbmAnyValueMappingTypeTest extends Adapter1Test {
	@Test
	public void test() {

		JaxbHbmAnyValueMappingType jaxbHbmAnyValueMappingType = new JaxbHbmAnyValueMappingType();

		aeq(null, jaxbHbmAnyValueMappingType.getClazz());
		jaxbHbmAnyValueMappingType.setClazz("clazz");
		aeq("clazz", jaxbHbmAnyValueMappingType.getClazz());

		aeq(null, jaxbHbmAnyValueMappingType.getValue());
		jaxbHbmAnyValueMappingType.setValue("value");
		aeq("value", jaxbHbmAnyValueMappingType.getValue());

	}
}

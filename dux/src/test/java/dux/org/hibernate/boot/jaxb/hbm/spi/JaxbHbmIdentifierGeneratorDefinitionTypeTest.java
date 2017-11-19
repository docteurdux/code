package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmIdentifierGeneratorDefinitionType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmIdentifierGeneratorDefinitionTypeTest extends AbstractTest {
	@Test
	public void test() {
		JaxbHbmIdentifierGeneratorDefinitionType jaxbHbmIdentifierGeneratorDefinitionType = new JaxbHbmIdentifierGeneratorDefinitionType();

		an(jaxbHbmIdentifierGeneratorDefinitionType.getClazz());
		jaxbHbmIdentifierGeneratorDefinitionType.setClazz("clazz");
		aeq("clazz", jaxbHbmIdentifierGeneratorDefinitionType.getClazz());

		an(jaxbHbmIdentifierGeneratorDefinitionType.getName());
		jaxbHbmIdentifierGeneratorDefinitionType.setName("name");
		aeq("name", jaxbHbmIdentifierGeneratorDefinitionType.getName());
	}
}

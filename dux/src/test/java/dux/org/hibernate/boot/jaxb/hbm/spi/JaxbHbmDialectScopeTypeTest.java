package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmDialectScopeType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmDialectScopeTypeTest extends AbstractTest {
	
	@Test
	public void test() {
		JaxbHbmDialectScopeType jaxbHbmDialectScopeType = new JaxbHbmDialectScopeType();

		an(jaxbHbmDialectScopeType.getValue());
		jaxbHbmDialectScopeType.setValue("value");
		aeq("value", jaxbHbmDialectScopeType.getValue());

		an(jaxbHbmDialectScopeType.getName());
		jaxbHbmDialectScopeType.setName("name");
		aeq("name", jaxbHbmDialectScopeType.getName());
	}
}

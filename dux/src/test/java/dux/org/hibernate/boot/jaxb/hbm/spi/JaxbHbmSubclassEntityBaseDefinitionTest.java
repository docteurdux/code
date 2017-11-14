package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmSubclassEntityBaseDefinitionTest extends AbstractTest {
	
	@Test
	public void test() {
		
		DummyJaxbHbmSubclassEntityBaseDefinition jaxbHbmSubclassEntityBaseDefinition = new DummyJaxbHbmSubclassEntityBaseDefinition();
		
		an(jaxbHbmSubclassEntityBaseDefinition.getExtends());
		jaxbHbmSubclassEntityBaseDefinition.setExtends("extends");
		aeq("extends", jaxbHbmSubclassEntityBaseDefinition.getExtends());

	}
}

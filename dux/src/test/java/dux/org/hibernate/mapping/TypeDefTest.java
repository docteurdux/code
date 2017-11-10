package dux.org.hibernate.mapping;

import java.util.Properties;

import org.hibernate.mapping.TypeDef;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class TypeDefTest extends AbstractTest {
	@Test
	public void test() {

		String typeClass = "typeClass";
		Properties parameters = new Properties();

		TypeDef typeDef = new TypeDef(typeClass, parameters);

		aeq(typeClass, typeDef.getTypeClass());
		aeqr(parameters, typeDef.getParameters());
	}
}

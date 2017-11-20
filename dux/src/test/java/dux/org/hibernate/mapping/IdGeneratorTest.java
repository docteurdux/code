package dux.org.hibernate.mapping;

import org.hibernate.mapping.IdGenerator;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class IdGeneratorTest extends AbstractTest {

	@Test
	public void test() {

		IdGenerator idGenerator = new IdGenerator();

		an(idGenerator.getName());
		idGenerator.setName("name");
		aeq("name", idGenerator.getName());

		an(idGenerator.getIdentifierGeneratorStrategy());
		idGenerator.setIdentifierGeneratorStrategy("identifierGeneratorStrategy");
		aeq("identifierGeneratorStrategy", idGenerator.getIdentifierGeneratorStrategy());

		aeq(0, idGenerator.getParams().size());
		idGenerator.addParam("key", "value");
		aeq("value", idGenerator.getParams().get("key"));

	}
}

package dux.org.hibernate.internal;

import org.hibernate.internal.StaticFilterAliasGenerator;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class StaticFilterAliasGeneratorTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		String anyString = "anyString";

		StaticFilterAliasGenerator filter = new StaticFilterAliasGenerator("alias");
		aeq("alias", filter.getAlias(anyString));
	}
}

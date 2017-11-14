
package dux.org.hibernate.internal;

import org.hibernate.internal.DynamicFilterAliasGenerator;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class DynamicFilterAliasGeneratorTest extends AbstractTest {

	private String[] tables;
	private String rootAlias;

	@Before
	public void before() {
		tables = new String[] { "table0", "table1", "table2" };
		rootAlias = "rootAlias_";
	}

	@Test
	public void test() {
		DynamicFilterAliasGenerator dynamicFilterAliasGenerator = new DynamicFilterAliasGenerator(tables, rootAlias);

		aeq(rootAlias, dynamicFilterAliasGenerator.getAlias(null));
		aeq(rootAlias, dynamicFilterAliasGenerator.getAlias("table0"));

		aeq(rootAlias + "1_", dynamicFilterAliasGenerator.getAlias("table1"));
		aeq(rootAlias + "2_", dynamicFilterAliasGenerator.getAlias("table2"));
	}
}

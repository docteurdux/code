package dux.org.hibernate.hql.internal.ast.util;

import org.hibernate.hql.internal.ast.util.AliasGenerator;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class AliasGeneratorTest extends AbstractTest {

	@Test
	public void test() {

		AliasGenerator ag = new AliasGenerator();
		aeq("name0_", ag.createName("name"));
		aeq("name1_", ag.createName("name"));

	}
}

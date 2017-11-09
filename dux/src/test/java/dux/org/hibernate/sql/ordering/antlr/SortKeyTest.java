package dux.org.hibernate.sql.ordering.antlr;

import javax.naming.ldap.SortKey;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class SortKeyTest extends AbstractTest {
	@Test
	public void test() {
		
		SortKey key = new SortKey("id", true, "rule");
		
		aeq("id",key.getAttributeID());
		aeq("rule",key.getMatchingRuleID());
		af(key.isAscending());
		
		key = new SortKey("id", false, "rule");
		at(key.isAscending());
		
		
	}
}

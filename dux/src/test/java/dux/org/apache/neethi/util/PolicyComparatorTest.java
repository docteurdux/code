package dux.org.apache.neethi.util;

import org.apache.neethi.All;
import org.apache.neethi.util.PolicyComparator;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class PolicyComparatorTest extends AbstractTest {
	@Test
	public void test() {
		All all1 = new All();
		All all2 = new All();
		PolicyComparator.compare(all1, all2);

	}
}

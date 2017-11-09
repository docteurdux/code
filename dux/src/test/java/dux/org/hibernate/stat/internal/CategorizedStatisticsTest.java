package dux.org.hibernate.stat.internal;

import org.hibernate.stat.internal.CategorizedStatistics;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class CategorizedStatisticsTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		CategorizedStatistics cs = instantiate(CategorizedStatistics.class, new Class<?>[] { String.class },
				"categoryName");

		aeq("categoryName", cs.getCategoryName());
	}
}

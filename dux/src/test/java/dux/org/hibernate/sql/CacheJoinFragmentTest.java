package dux.org.hibernate.sql;

import org.hibernate.AssertionFailure;
import org.hibernate.sql.CacheJoinFragment;
import org.hibernate.sql.JoinType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWhichThrow;

@Done
public class CacheJoinFragmentTest extends AbstractTest {

	@Test
	public void test() {
		String rhsTableName = "rhsTableName";
		String rhsAlias = "rhsAlias";
		String[] lhsColumns = new String[] {};
		String[] rhsColumns = new String[] {};
		JoinType joinType = JoinType.FULL_JOIN;
		String on = "on";

		CacheJoinFragment cacheJoinFragment = new CacheJoinFragment();

		expect(AssertionFailure.class, new RunnableWhichThrow() {
			@Override
			public void run() throws Exception {
				cacheJoinFragment.addJoin(rhsTableName, rhsAlias, lhsColumns, rhsColumns, joinType, on);
			}

			@Override
			public void inspect(Exception e) {
				aeq("Cache does not support full outer joins", e.getMessage());
			}
		});

	}
}

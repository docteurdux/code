package dux.org.hibernate.hql.internal.ast.tree;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.hql.internal.ast.HqlSqlWalker;
import org.hibernate.hql.internal.ast.tree.OrderByClause;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.DUXFactories;
import com.github.docteurdux.test.Done;

@Done("need a second pass once hql is understood")
public class OrderByClauseTest extends AbstractTest {
	@Test
	public void test() {
		OrderByClause obc = new OrderByClause();
		Map<DUXFactories, Object> io = new HashMap<>();
		HqlSqlWalker hqlSqlWalker = (HqlSqlWalker) DUXFactories.HQL_SQL_WALKER.get(io);
		obc.initialize(hqlSqlWalker);
		String orderByFragment = "orderByFragment";
		obc.addOrderFragment(orderByFragment);
	}
}

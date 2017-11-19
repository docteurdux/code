package dux.org.hibernate.hql.internal.ast.tree;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.hql.internal.ast.HqlSqlWalker;
import org.hibernate.hql.internal.ast.tree.NullNode;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.DUXFactories;
import com.github.docteurdux.test.Done;

import antlr.SemanticException;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;

@Done
public class NullNodeTest extends AbstractTest {

	private DummySessionFactoryImplementor ignoredSessionFactoryImplementor;
	private Map<DUXFactories, Object> io;
	private HqlSqlWalker hqlSqlWalker;

	@Before
	public void before() {

		io = new HashMap<>();

		ignoredSessionFactoryImplementor = new DummySessionFactoryImplementor();
		hqlSqlWalker = DUXFactories.HQL_SQL_WALKER.get(io, HqlSqlWalker.class);
	}

	@Test
	public void test() throws SemanticException {
		NullNode nullNode = new NullNode();

		an(nullNode.getDataType());
		an(nullNode.getValue());

		aeq("null", nullNode.getRenderText(ignoredSessionFactoryImplementor));

		nullNode.initialize(hqlSqlWalker);
		nullNode.setScalarColumnText(0);
		aeq(" as col_0_0_", nullNode.getNextSibling().getText());
	}
}

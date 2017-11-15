package dux.org.hibernate.hql.internal.ast.tree;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.hql.internal.ast.HqlParser;
import org.hibernate.hql.internal.ast.HqlSqlWalker;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.hql.internal.ast.SqlASTFactory;
import org.hibernate.hql.internal.ast.tree.HqlSqlWalkerNode;
import org.hibernate.hql.internal.ast.util.AliasGenerator;
import org.hibernate.hql.internal.ast.util.SessionFactoryHelper;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;

@Done
public class HqlSqlWalkerNodeTest extends AbstractTest {
	private String queryIdentifier;
	private String query;
	private String hql;
	private String collectionRole;

	@SuppressWarnings("rawtypes")
	private Map enabledFilters;

	@SuppressWarnings("rawtypes")
	private Map tokenReplacements;

	private DummySessionFactoryImplementor sessionFactoryImplementor;

	private QueryTranslatorImpl queryTranslatorImpl;

	private HqlParser hqlParser;

	private HqlSqlWalker hqlSqlWalker;

	@Before
	public void before() {

		queryIdentifier = "queryIdentifier";
		query = "query";
		hql = "hql";
		collectionRole = "collectionRole";

		enabledFilters = new HashMap<>();
		tokenReplacements = new HashMap<>();

		sessionFactoryImplementor = new DummySessionFactoryImplementor();

		queryTranslatorImpl = new QueryTranslatorImpl(queryIdentifier, query, enabledFilters,
				sessionFactoryImplementor);

		hqlParser = HqlParser.getInstance(hql);

		hqlSqlWalker = new HqlSqlWalker(queryTranslatorImpl, sessionFactoryImplementor, hqlParser, tokenReplacements,
				collectionRole);

	}

	@Test
	public void test() {

		HqlSqlWalkerNode hswn = new HqlSqlWalkerNode();

		an(hswn.getWalker());

		hswn.initialize(hqlSqlWalker);
		aeqr(hqlSqlWalker, hswn.getWalker());

		SessionFactoryHelper sessionFactoryHelper = hswn.getSessionFactoryHelper();
		aeq(SessionFactoryHelper.class, sessionFactoryHelper.getClass());
		aeqr(sessionFactoryImplementor, sessionFactoryHelper.getFactory());

		aeq(SqlASTFactory.class, hswn.getASTFactory().getClass());

		aeq(AliasGenerator.class, hqlSqlWalker.getAliasGenerator().getClass());

	}
}

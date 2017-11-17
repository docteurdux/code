package dux.org.hibernate.hql.spi.id.inline;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.dialect.Dialect;
import org.hibernate.hql.internal.ast.HqlParser;
import org.hibernate.hql.internal.ast.HqlSqlWalker;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.hql.spi.id.inline.AbstractInlineIdsBulkIdHandler;
import org.hibernate.hql.spi.id.inline.IdsClauseBuilder;
import org.hibernate.type.Type;
import org.hibernate.type.TypeResolver;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.type.DummyType;

@Done("TODO : after knowing more about hql, try to go through prepareInlineStatement and do something interesting here")
public class AbstractInlineIdsBulkIdHandlerTest extends AbstractTest {

	private String queryIdentifier;
	private String query;
	private String hql;
	private String collectionRole;
	private String statement;

	@SuppressWarnings("rawtypes")
	private Map enabledFilters;

	@SuppressWarnings("rawtypes")
	private Map tokenReplacements;

	private String[] ds;
	private List<Object[]> e;

	private Dialect dialect;

	private Type type;
	private TypeResolver typeResolver;

	private DummySessionFactoryImplementor sessionFactoryImplementor;

	private QueryTranslatorImpl queryTranslatorImpl;

	private HqlParser hqlParser;

	private HqlSqlWalker hqlSqlWalker;
	private IdsClauseBuilder idsClauseBuilder;

	@Before
	public void before() {

		queryIdentifier = "queryIdentifier";
		query = "query";
		hql = "hql";
		collectionRole = "collectionRole";
		statement = "statement";

		tokenReplacements = new HashMap<>();
		enabledFilters = new HashMap<>();
		ds = new String[] {};
		e = new ArrayList<>();

		dialect = new Dialect() {
		};

		type = new DummyType();
		typeResolver = new TypeResolver();

		sessionFactoryImplementor = new DummySessionFactoryImplementor();

		queryTranslatorImpl = new QueryTranslatorImpl(queryIdentifier, query, enabledFilters,
				sessionFactoryImplementor);

		hqlParser = HqlParser.getInstance(hql);

		hqlSqlWalker = new HqlSqlWalker(queryTranslatorImpl, sessionFactoryImplementor, hqlParser, tokenReplacements,
				collectionRole);

		idsClauseBuilder = new IdsClauseBuilder(dialect, type, typeResolver, ds, e) {

			@Override
			public String toStatement() {

				return statement;
			}
		};
	}

	@Test
	public void test() {

		if (hqlSqlWalker.getAST() != null) {
			@SuppressWarnings("unused")
			AbstractInlineIdsBulkIdHandler abstractInlineIdsBulkIdHandler = new AbstractInlineIdsBulkIdHandler(
					sessionFactoryImplementor, hqlSqlWalker) {
				@Override
				protected IdsClauseBuilder newIdsClauseBuilder(List<Object[]> ids) {
					return idsClauseBuilder;
				}
			};
		}

	}
}

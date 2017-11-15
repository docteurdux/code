package dux.org.hibernate.dialect;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.dialect.HANAColumnStoreDialect;
import org.hibernate.hql.internal.ast.HqlParser;
import org.hibernate.hql.internal.ast.HqlSqlWalker;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.hql.spi.id.MultiTableBulkIdStrategy;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;

// dont forget to remove duplicated class HANAColumnStoreDialect.java
public class HANAColumnStoreDialectTest extends AbstractTest {
	@Test
	public void test() {
		HANAColumnStoreDialect dialect = new HANAColumnStoreDialect();

		aeq("create column table", dialect.getCreateTableString());

		MultiTableBulkIdStrategy defaultMultiTableBulkIdStrategy = dialect.getDefaultMultiTableBulkIdStrategy();
		ann(defaultMultiTableBulkIdStrategy);

		DummySessionFactoryImplementor factory = new DummySessionFactoryImplementor();

		String queryIdentifier = "queryIdentifier";
		String query = "query";
		Map enabledFilters = new HashMap<>();
		QueryTranslatorImpl qti = new QueryTranslatorImpl(queryIdentifier, query, enabledFilters, factory);
		String hql = "";
		HqlParser parser = HqlParser.getInstance(hql);
		Map tokenReplacements = new HashMap<>();
		String collectionRole = "collectionRole";
		HqlSqlWalker walker = new HqlSqlWalker(qti, factory, parser, tokenReplacements, collectionRole);
		defaultMultiTableBulkIdStrategy.buildDeleteHandler(factory, walker);
		defaultMultiTableBulkIdStrategy.buildUpdateHandler(factory, walker);

	}
}

package dux.org.hibernate.hql.internal.classic;

import java.util.HashMap;
import java.util.List;

import org.hibernate.hql.internal.classic.HavingParser;
import org.hibernate.hql.internal.classic.QueryTranslatorImpl;
import org.hibernate.hql.internal.classic.WhereParser;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.boot.spi.DummySessionFactoryOptions;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;

@Done
public class HavingParserTest extends AbstractTest {

	private DummySessionFactoryOptions sessionFactoryOptions;
	private DummySessionFactoryImplementor sessionFactoryImplementor;
	private QueryTranslatorImpl queryTranslatorImpl;

	@Before
	public void before() {

		sessionFactoryOptions = new DummySessionFactoryOptions();

		sessionFactoryImplementor = new DummySessionFactoryImplementor();
		sessionFactoryImplementor.setSessionFactoryOptions(sessionFactoryOptions);

		queryTranslatorImpl = new QueryTranslatorImpl("queryString", new HashMap<>(), sessionFactoryImplementor);

	}

	@Test
	public void test() throws Exception {

		aeq(WhereParser.class, HavingParser.class.getSuperclass());

		HavingParser havingParser = new HavingParser();

		invokeAppendToken(havingParser, "token");

		aeq("token", getHavingTokens(queryTranslatorImpl).get(0));

	}

	private void invokeAppendToken(HavingParser havingParser, String string) throws Exception {
		invoke(havingParser, "appendToken", queryTranslatorImpl, "token");
	}

	@SuppressWarnings("rawtypes")
	private List getHavingTokens(QueryTranslatorImpl queryTranslatorImpl) {
		return (List) getField(queryTranslatorImpl, "havingTokens");
	}
}

package dux.org.hibernate.internal;

import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.JdbcSessionContextImpl;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.boot.spi.DummySessionFactoryOptions;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.engine.spi.DummySharedSessionContractImplementor;
import dum.org.hibernate.resource.jdbc.spi.DummyStatementInspector;
import dus.hibernate.core.HibernateCoreSummaryTest;

public class JdbcSessionContextImplTest extends AbstractTest {

	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, JdbcSessionContextImpl.class);
	}

	@Test
	public void test() {
		DummySessionFactoryOptions sessionFactoryOptions = new DummySessionFactoryOptions();
		DummySessionFactoryImplementor factory = new DummySessionFactoryImplementor();
		factory.setSessionFactoryOptions(sessionFactoryOptions);
		DummySharedSessionContractImplementor session = new DummySharedSessionContractImplementor();
		session.setFactory(factory);
		StatementInspector statementInspector = new DummyStatementInspector();
		JdbcSessionContextImpl j = new JdbcSessionContextImpl(session, statementInspector);

		j.isScrollableResultSetsEnabled();

		j.isGetGeneratedKeysEnabled();

		// j.getFetchSize();

		j.getPhysicalConnectionHandlingMode();

		j.doesConnectionProviderDisableAutoCommit();

		// j.getConnectionReleaseMode();

		// j.getConnectionAcquisitionMode();

		j.getStatementInspector();

		j.getObserver();

		j.getSessionFactory();

		j.getServiceRegistry();

	}
}

package dux.org.hibernate.loader.plan.exec.query.internal;

import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.engine.spi.LoadQueryInfluencers;
import org.hibernate.loader.plan.exec.query.internal.QueryBuildingParametersImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;

@Done
public class QueryBuildingParametersImplTest extends AbstractTest {

	private DummySessionFactoryImplementor sessionFactoryImplementor;
	private LoadQueryInfluencers loadQueryInfluencers;
	private int batchSize;
	private LockMode lockMode;
	private LockOptions lockOptions;

	@Before
	public void before() {
		sessionFactoryImplementor = new DummySessionFactoryImplementor();
		loadQueryInfluencers = new LoadQueryInfluencers(sessionFactoryImplementor);
		batchSize = 0;
		lockMode = LockMode.NONE;
		lockOptions = new LockOptions();
	}

	@Test
	public void test() {

		QueryBuildingParametersImpl queryBuildingParametersImpl = new QueryBuildingParametersImpl(loadQueryInfluencers,
				batchSize, lockMode, lockOptions);

		aeqr(loadQueryInfluencers, queryBuildingParametersImpl.getQueryInfluencers());
		aeq(batchSize, queryBuildingParametersImpl.getBatchSize());
		aeq(lockMode, queryBuildingParametersImpl.getLockMode());
		aeq(lockOptions, queryBuildingParametersImpl.getLockOptions());
	}
}

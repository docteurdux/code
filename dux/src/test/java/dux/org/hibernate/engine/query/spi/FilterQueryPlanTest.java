package dux.org.hibernate.engine.query.spi;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.engine.query.spi.FilterQueryPlan;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.hql.spi.FilterTranslator;
import org.hibernate.hql.spi.QueryTranslatorFactory;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.hibernate.FilterTranslatorCreator;

import dum.org.hibernate.boot.spi.DummySessionFactoryOptions;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.hql.spi.DummyFilterTranslator;
import dum.org.hibernate.hql.spi.DummyParameterTranslations;
import dum.org.hibernate.hql.spi.DummyQueryTranslatorFactory;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

@Done
public class FilterQueryPlanTest extends AbstractTest {

	private String hql;
	private String collectionRole;
	private boolean shallow;

	@SuppressWarnings("rawtypes")
	private Map enabledFilters;

	private DummySessionFactoryOptions sessionFactoryOptions;
	private DummyParameterTranslations parameterTranslations;
	private DummyFilterTranslator filterTranslator;
	private DummyQueryTranslatorFactory queryTranslatorFactory;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;
	private DummySessionFactoryImplementor sessionFactoryImplementor;

	public FilterQueryPlanTest() {
		hql = "hql";
		collectionRole = "collectionRole";
		shallow = true;
		enabledFilters = new HashMap<>();
		sessionFactoryOptions = new DummySessionFactoryOptions();
		parameterTranslations = new DummyParameterTranslations();
		filterTranslator = new DummyFilterTranslator();
		filterTranslator.setParameterTranslations(parameterTranslations);
		queryTranslatorFactory = new DummyQueryTranslatorFactory();
		queryTranslatorFactory.setFilterTranslatorCreator(new FilterTranslatorCreator() {
			@Override
			public FilterTranslator create(String queryIdentifier, String queryString, Map filters,
					SessionFactoryImplementor factory) {
				return filterTranslator;
			}
		});
		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(QueryTranslatorFactory.class, queryTranslatorFactory);
		sessionFactoryImplementor = new DummySessionFactoryImplementor();
		sessionFactoryImplementor.setSessionFactoryOptions(sessionFactoryOptions);
		sessionFactoryImplementor.setServiceRegistry(serviceRegistryImplementor);
	}

	@Test
	public void test() {
		FilterQueryPlan fqp = new FilterQueryPlan(hql, collectionRole, shallow, enabledFilters,
				sessionFactoryImplementor);
		aeq(collectionRole, fqp.getCollectionRole());
	}
}

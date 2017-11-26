package dux.org.hibernate;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.cfg.Environment;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dus.hibernate.core.HibernateCoreSummaryTest;

@Done
public class MultiTenancyStrategyTest extends AbstractTest {

	@SuppressWarnings("rawtypes")
	private Map properties;

	@Before
	public void before() {

		requireSources(HibernateCoreSummaryTest.MVNNAME, MultiTenancyStrategy.class);

		properties = new HashMap<>();
	}

	@Test
	public void test0() {
		aeq("hibernate.multiTenancy", Environment.MULTI_TENANT);
	}

	@Test
	public void test1() {
		aeq(MultiTenancyStrategy.NONE, MultiTenancyStrategy.determineMultiTenancyStrategy(properties));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test2() {
		properties.put(Environment.MULTI_TENANT, MultiTenancyStrategy.DATABASE);
		aeq(MultiTenancyStrategy.DATABASE, MultiTenancyStrategy.determineMultiTenancyStrategy(properties));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test3() {
		properties.put(Environment.MULTI_TENANT, "SCHEMA");
		aeq(MultiTenancyStrategy.SCHEMA, MultiTenancyStrategy.determineMultiTenancyStrategy(properties));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test4() {
		properties.put(Environment.MULTI_TENANT, "anyother");
		aeq(MultiTenancyStrategy.NONE, MultiTenancyStrategy.determineMultiTenancyStrategy(properties));
	}

	@Test
	public void test5() {
		aeq(4, MultiTenancyStrategy.values().length);
		aeq(true, MultiTenancyStrategy.DATABASE.requiresMultiTenantConnectionProvider());
		aeq(true, MultiTenancyStrategy.SCHEMA.requiresMultiTenantConnectionProvider());
		aeq(false, MultiTenancyStrategy.DISCRIMINATOR.requiresMultiTenantConnectionProvider());
		aeq(false, MultiTenancyStrategy.NONE.requiresMultiTenantConnectionProvider());
	}

}

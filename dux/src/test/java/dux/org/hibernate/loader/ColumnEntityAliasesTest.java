package dux.org.hibernate.loader;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.loader.DummyColumnEntityAliases;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;

@Done
public class ColumnEntityAliasesTest extends AbstractTest {
	private String discriminatorColumnName;
	private String suffix;
	private Dialect dialect;
	private DummyJdbcServices jdbcServices;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;
	private DummySessionFactoryImplementor sessionFactoryImplementor;
	private DummyLoadable loadable;
	private String[] identifierColumnNames;
	private String[] propertyColumnNames;

	@SuppressWarnings("rawtypes")
	private Map returnProperties;

	@Before
	public void before() {
		discriminatorColumnName = "discriminatorColumnName";
		suffix = "suffix";

		identifierColumnNames = new String[] {};
		propertyColumnNames = identifierColumnNames;

		dialect = new Dialect() {
		};

		jdbcServices = new DummyJdbcServices();
		jdbcServices.setDialect(dialect);

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JdbcServices.class, jdbcServices);

		sessionFactoryImplementor = new DummySessionFactoryImplementor();
		sessionFactoryImplementor.setServiceRegistry(serviceRegistryImplementor);

		loadable = new DummyLoadable();
		loadable.setFactory(sessionFactoryImplementor);
		loadable.setIdentifierColumnNames(identifierColumnNames);
		loadable.setDiscriminatorColumnName(discriminatorColumnName);
		loadable.getPropertyColumnNames().add(propertyColumnNames);

		returnProperties = new HashMap<>();
	}

	@Test
	public void test() {
		DummyColumnEntityAliases columnEntityAliases = new DummyColumnEntityAliases(returnProperties, loadable, suffix);
		aeqr(identifierColumnNames, columnEntityAliases.getIdentifierAliases(loadable, suffix));
		aeqr(discriminatorColumnName, columnEntityAliases.getDiscriminatorAlias(loadable, suffix));
		aeqr(propertyColumnNames, columnEntityAliases.getPropertyAliases(loadable, 0));

	}
}

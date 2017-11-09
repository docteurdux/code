package dux.org.hibernate.query.criteria.internal;

import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.integrator.spi.IntegratorService;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.persister.spi.PersisterFactory;
import org.hibernate.query.criteria.internal.AbstractNode;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.service.spi.SessionFactoryServiceRegistryFactory;
import org.hibernate.type.TypeResolver;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.boot.cfgxml.spi.DummyCfgXmlAccessService;
import dum.org.hibernate.boot.model.naming.DummyPhysicalNamingStrategy;
import dum.org.hibernate.boot.spi.DummyMappingDefaults;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.boot.spi.DummyMetadataImplementor;
import dum.org.hibernate.boot.spi.DummySessionFactoryOptions;
import dum.org.hibernate.engine.config.spi.DummyConfigurationService;
import dum.org.hibernate.engine.jdbc.env.spi.DummyIdentifierHelper;
import dum.org.hibernate.engine.jdbc.env.spi.DummyJdbcEnvironment;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.persister.spi.DummyPersisterFactory;
import dum.org.hibernate.service.spi.DummySessionFactoryServiceRegistry;
import dum.org.hibernate.service.spi.DummySessionFactoryServiceRegistryFactory;

public class AbstractNodeTest extends AbstractTest {
	@Test
	public void test() {

		Dialect dialect = new Dialect() {
		};

		DummyIdentifierHelper identifierHelper = new DummyIdentifierHelper();

		DummyJdbcEnvironment jdbcEnvironment = new DummyJdbcEnvironment();
		jdbcEnvironment.setIdentifierHelper(identifierHelper);
		jdbcEnvironment.setDialect(dialect);

		DummyJdbcServices jdbcServices = new DummyJdbcServices();
		jdbcServices.setDialect(dialect);
		jdbcServices.setJdbcEnvironment(jdbcEnvironment);

		DummyCfgXmlAccessService cfgXmlAccessService = new DummyCfgXmlAccessService();

		ConfigurationService configurationService = new DummyConfigurationService();

		IntegratorService integratorService = new DummyIntegratorService();

		PersisterFactory persisterFactory = new DummyPersisterFactory();

		DummySessionFactoryServiceRegistry sessionFactoryServiceRegistry = new DummySessionFactoryServiceRegistry();
		sessionFactoryServiceRegistry.setService(CfgXmlAccessService.class, cfgXmlAccessService);
		sessionFactoryServiceRegistry.setService(ConfigurationService.class, configurationService);
		sessionFactoryServiceRegistry.setService(JdbcServices.class, jdbcServices);
		sessionFactoryServiceRegistry.setService(IntegratorService.class, integratorService);
		sessionFactoryServiceRegistry.setService(PersisterFactory.class, persisterFactory);

		DummySessionFactoryServiceRegistryFactory sessionFactoryServiceRegistryFactory = new DummySessionFactoryServiceRegistryFactory();
		sessionFactoryServiceRegistryFactory.setServiceRegistry(sessionFactoryServiceRegistry);

		DummyStandardServiceRegistry serviceRegistry = new DummyStandardServiceRegistry();
		serviceRegistry.setService(JdbcServices.class, jdbcServices);
		serviceRegistry.setService(SessionFactoryServiceRegistryFactory.class, sessionFactoryServiceRegistryFactory);

		DummyMappingDefaults mappingDefaults = new DummyMappingDefaults();
		mappingDefaults.setImplicitCatalogName("implicitCatalogName");
		mappingDefaults.setImplicitSchemaName("implicitSchemaName");

		PhysicalNamingStrategy physicalNamingStrategy = new DummyPhysicalNamingStrategy();

		DummyMetadataBuildingOptions buildingOptions = new DummyMetadataBuildingOptions();
		buildingOptions.setServiceRegistry(serviceRegistry);
		buildingOptions.setMappingDefaults(mappingDefaults);
		buildingOptions.setPhysicalNamingStrategy(physicalNamingStrategy);

		Database database = new Database(buildingOptions, jdbcEnvironment);

		TypeResolver typeResolver = new TypeResolver();

		DummyMetadataImplementor metadata = new DummyMetadataImplementor();
		metadata.setDatabase(database);
		metadata.setTypeResolver(typeResolver);
		metadata.getFilterDefinitions();
		metadata.getEntityBindings();

		DummySessionFactoryOptions options = new DummySessionFactoryOptions();
		options.setServiceRegistry(serviceRegistry);
		options.getSessionFactoryObservers();

		SessionFactoryImpl sessionFactory = new SessionFactoryImpl(metadata, options);

		CriteriaBuilderImpl builder = new CriteriaBuilderImpl(sessionFactory);

		AbstractNode node = new AbstractNode(builder) {
			private static final long serialVersionUID = 1L;
		};
		aeqr(builder, node.criteriaBuilder());
	}
}

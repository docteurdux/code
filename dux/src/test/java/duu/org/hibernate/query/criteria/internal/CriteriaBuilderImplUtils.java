package duu.org.hibernate.query.criteria.internal;

import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.integrator.spi.IntegratorService;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.persister.spi.PersisterFactory;
import org.hibernate.query.criteria.internal.CriteriaBuilderImpl;
import org.hibernate.service.spi.SessionFactoryServiceRegistryFactory;
import org.hibernate.type.TypeResolver;

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
import dum.org.hibernate.hql.spi.id.DummyMultiTableBulkIdStrategy;
import dum.org.hibernate.persister.spi.DummyPersisterFactory;
import dum.org.hibernate.service.spi.DummySessionFactoryServiceRegistry;
import dum.org.hibernate.service.spi.DummySessionFactoryServiceRegistryFactory;
import dux.org.hibernate.query.criteria.internal.DummyIntegratorService;
import dux.org.hibernate.query.criteria.internal.DummyStandardServiceRegistry;

public class CriteriaBuilderImplUtils {

	public static CriteriaBuilderImpl getAnInstance() {

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

		DummyConfigurationService configurationService = new DummyConfigurationService();

		DummyIntegratorService integratorService = new DummyIntegratorService();

		DummyPersisterFactory persisterFactory = new DummyPersisterFactory();

		DummySessionFactoryServiceRegistry sessionFactoryServiceRegistry = new DummySessionFactoryServiceRegistry();
		sessionFactoryServiceRegistry.setService(CfgXmlAccessService.class, cfgXmlAccessService);
		sessionFactoryServiceRegistry.setService(ConfigurationService.class, configurationService);
		sessionFactoryServiceRegistry.setService(JdbcServices.class, jdbcServices);
		sessionFactoryServiceRegistry.setService(IntegratorService.class, integratorService);
		sessionFactoryServiceRegistry.setService(PersisterFactory.class, persisterFactory);

		DummySessionFactoryServiceRegistryFactory sessionFactoryServiceRegistryFactory = new DummySessionFactoryServiceRegistryFactory();
		sessionFactoryServiceRegistryFactory.setServiceRegistry(sessionFactoryServiceRegistry);

		DummyStandardServiceRegistry standardServiceRegistry = new DummyStandardServiceRegistry();
		standardServiceRegistry.setService(JdbcServices.class, jdbcServices);
		standardServiceRegistry.setService(SessionFactoryServiceRegistryFactory.class,
				sessionFactoryServiceRegistryFactory);

		DummyMappingDefaults mappingDefaults = new DummyMappingDefaults();
		mappingDefaults.setImplicitCatalogName("implicitCatalogName");
		mappingDefaults.setImplicitSchemaName("implicitSchemaName");

		DummyPhysicalNamingStrategy physicalNamingStrategy = new DummyPhysicalNamingStrategy();

		DummyMetadataBuildingOptions metadataBuildingOptions = new DummyMetadataBuildingOptions();
		metadataBuildingOptions.setServiceRegistry(standardServiceRegistry);
		metadataBuildingOptions.setMappingDefaults(mappingDefaults);
		metadataBuildingOptions.setPhysicalNamingStrategy(physicalNamingStrategy);

		Database database = new Database(metadataBuildingOptions, jdbcEnvironment);

		TypeResolver typeResolver = new TypeResolver();

		DummyMetadataImplementor metadataImplementor = new DummyMetadataImplementor();
		metadataImplementor.setDatabase(database);
		metadataImplementor.setTypeResolver(typeResolver);
		metadataImplementor.getFilterDefinitions();
		metadataImplementor.getEntityBindings();

		DummyMultiTableBulkIdStrategy multiTableBulkIdStrategy = new DummyMultiTableBulkIdStrategy();

		DummySessionFactoryOptions sessionFactoryOptions = new DummySessionFactoryOptions();
		sessionFactoryOptions.setServiceRegistry(standardServiceRegistry);
		sessionFactoryOptions.getSessionFactoryObservers();
		sessionFactoryOptions.setMultiTableBulkIdStrategy(multiTableBulkIdStrategy);

		SessionFactoryImpl sessionFactoryImpl = new SessionFactoryImpl(metadataImplementor, sessionFactoryOptions);

		return new CriteriaBuilderImpl(sessionFactoryImpl);
	}

}

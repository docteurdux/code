package dux.org.hibernate.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.hibernate.boot.internal.ClassLoaderAccessImpl;
import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.internal.MetadataBuilderImpl.MetadataBuildingOptionsImpl;
import org.hibernate.boot.internal.MetadataBuildingContextRootImpl;
import org.hibernate.boot.internal.MetadataImpl;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.boot.registry.selector.spi.StrategySelector;
import org.hibernate.boot.spi.ClassLoaderAccess;
import org.hibernate.boot.spi.InFlightMetadataCollector;
import org.hibernate.boot.spi.MetadataBuildingOptions;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cache.spi.RegionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.CacheImplementor;
import org.hibernate.event.service.spi.EventListenerGroup;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.PersistEventListener;
import org.hibernate.integrator.spi.IntegratorService;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.transaction.spi.TransactionCoordinator;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.hibernate.service.spi.SessionFactoryServiceRegistry;
import org.hibernate.service.spi.SessionFactoryServiceRegistryFactory;
import org.hibernate.stat.spi.StatisticsImplementor;
import org.hibernate.type.TypeResolver;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.java.sql.DummyConnection;
import dum.org.hibernate.boot.cfgxml.spi.DummyCfgXmlAccessService;
import dum.org.hibernate.boot.model.naming.DummyPhysicalNamingStrategy;
import dum.org.hibernate.boot.registry.selector.spi.DummyStrategySelector;
import dum.org.hibernate.boot.spi.DummyMappingDefaults;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.cache.spi.DummyRegionFactory;
import dum.org.hibernate.engine.config.spi.DummyConfigurationService;
import dum.org.hibernate.engine.jdbc.connections.spi.DummyConnectionProvider;
import dum.org.hibernate.engine.jdbc.env.spi.DummyExtractedDatabaseMetaData;
import dum.org.hibernate.engine.jdbc.env.spi.DummyIdentifierHelper;
import dum.org.hibernate.engine.jdbc.env.spi.DummyJdbcEnvironment;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.spi.DummyCacheImplementor;
import dum.org.hibernate.event.service.spi.DummyEventListenerGroup;
import dum.org.hibernate.event.service.spi.DummyEventListenerRegistry;
import dum.org.hibernate.hql.spi.id.DummyMultiTableBulkIdStrategy;
import dum.org.hibernate.resource.transaction.spi.DummySynchronizationRegistry;
import dum.org.hibernate.resource.transaction.spi.DummyTransactionCoordinator;
import dum.org.hibernate.resource.transaction.spi.DummyTransactionCoordinatorBuilder;
import dum.org.hibernate.resource.transaction.spi.TransactionCoordinator.DummyTransactionDriver;
import dum.org.hibernate.service.spi.DummySessionFactoryServiceRegistry;
import dum.org.hibernate.service.spi.DummySessionFactoryServiceRegistryFactory;
import dum.org.hibernate.stat.spi.DummyStatisticsImplementor;
import dus.hibernate.core.HibernateCoreSummaryTest;
import dux.org.hibernate.query.criteria.internal.DummyIntegratorService;
import dux.org.hibernate.query.criteria.internal.DummyStandardServiceRegistry;

public class SessionFactoryImplTest extends AbstractTest {

	public static class A {

	}

	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, SessionFactoryImpl.class);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void test() {

		DummyIdentifierHelper identifierHelper = new DummyIdentifierHelper();

		Dialect dialect = new Dialect() {
		};

		DummyJdbcEnvironment jdbcEnvironment = new DummyJdbcEnvironment();
		jdbcEnvironment.setIdentifierHelper(identifierHelper);
		jdbcEnvironment.setDialect(dialect);

		DummyExtractedDatabaseMetaData extractedMetaDataSupport = new DummyExtractedDatabaseMetaData();

		DummyJdbcServices jdbcServices = new DummyJdbcServices();
		jdbcServices.setJdbcEnvironment(jdbcEnvironment);
		jdbcServices.setExtractedMetaDataSupport(extractedMetaDataSupport);

		DummyCfgXmlAccessService cfgXmlAccessService = new DummyCfgXmlAccessService();

		Map<String, Object> config = new HashMap<>();
		config.put(AvailableSettings.GLOBALLY_QUOTED_IDENTIFIERS, false);
		config.put(AvailableSettings.IMPLICIT_DISCRIMINATOR_COLUMNS_FOR_JOINED_SUBCLASS, false);
		config.put(AvailableSettings.IGNORE_EXPLICIT_DISCRIMINATOR_COLUMNS_FOR_JOINED_SUBCLASS, false);
		config.put(AvailableSettings.FORCE_DISCRIMINATOR_IN_SELECTS_BY_DEFAULT, false);
		config.put("hibernate.enable_specj_proprietary_syntax", false);
		config.put(AvailableSettings.USE_NEW_ID_GENERATOR_MAPPINGS, true);
		config.put(AvailableSettings.USE_NATIONALIZED_CHARACTER_DATA, false);
		config.put(AvailableSettings.USE_LEGACY_LIMIT_HANDLERS, false);

		DummyConfigurationService configurationService = new DummyConfigurationService();
		configurationService.getSettings().put("hibernate.current_session_context_class", "thread");
		configurationService.setGetSettingRWA(new RunnableWithArgs<Object>() {
			@Override
			public Object run(Object... args) {
				String name = (String) args[0];
				return config.get(name);
			}
		});

		DummyIntegratorService integratorService = new DummyIntegratorService();

		DummyRegionFactory regionFactory = new DummyRegionFactory();

		DummyCacheImplementor cacheImplementor = new DummyCacheImplementor();
		cacheImplementor.setRegionFactory(regionFactory);

		DummyStatisticsImplementor statisticsImplementor = new DummyStatisticsImplementor();

		DummyConnection connection = new DummyConnection();

		DummyConnectionProvider connectionProvider = new DummyConnectionProvider();
		connectionProvider.setConnection(connection);

		DummySynchronizationRegistry localSynchronizations = new DummySynchronizationRegistry();

		DummyTransactionDriver transactionDriverControl = new DummyTransactionDriver();

		DummyTransactionCoordinator transactionCoordinator = new DummyTransactionCoordinator();
		transactionCoordinator.setLocalSynchronizations(localSynchronizations);
		transactionCoordinator.setTransactionDriverControl(transactionDriverControl);

		PhysicalConnectionHandlingMode physicalConnectionHandlingMode = PhysicalConnectionHandlingMode.IMMEDIATE_ACQUISITION_AND_HOLD;

		DummyTransactionCoordinatorBuilder transactionCoordinatorBuilder = new DummyTransactionCoordinatorBuilder();
		transactionCoordinatorBuilder.setDefaultConnectionHandlingMode(physicalConnectionHandlingMode);
		transactionCoordinatorBuilder.setBuildTransactionCoordinatorRWA(new RunnableWithArgs<TransactionCoordinator>() {
			@Override
			public TransactionCoordinator run(Object... args) {
				return transactionCoordinator;
			}
		});

		DummyEventListenerGroup eventListenerGroupPersist = new DummyEventListenerGroup<>();

		Map<Class<?>, EventListenerGroup<?>> eventListenerGroups = new HashMap<>();
		eventListenerGroups.put(PersistEventListener.class, eventListenerGroupPersist);

		DummyEventListenerRegistry eventListenerRegistry = new DummyEventListenerRegistry();
		eventListenerRegistry.setGetEventListenerGroupRWA(new RunnableWithArgs<EventListenerGroup>() {
			@Override
			public EventListenerGroup run(Object... args) {
				EventType<?> eventType = (EventType<?>) args[0];
				return eventListenerGroups.get(eventType.baseListenerInterface());
			}
		});

		DummySessionFactoryServiceRegistry sessionFactoryServiceRegistry = new DummySessionFactoryServiceRegistry();
		sessionFactoryServiceRegistry.setService(CfgXmlAccessService.class, cfgXmlAccessService);
		sessionFactoryServiceRegistry.setService(ConfigurationService.class, configurationService);
		sessionFactoryServiceRegistry.setService(JdbcServices.class, jdbcServices);
		sessionFactoryServiceRegistry.setService(IntegratorService.class, integratorService);
		sessionFactoryServiceRegistry.setService(CacheImplementor.class, cacheImplementor);
		sessionFactoryServiceRegistry.setService(StatisticsImplementor.class, statisticsImplementor);
		sessionFactoryServiceRegistry.setService(ConnectionProvider.class, connectionProvider);
		sessionFactoryServiceRegistry.setService(TransactionCoordinatorBuilder.class, transactionCoordinatorBuilder);
		sessionFactoryServiceRegistry.setService(EventListenerRegistry.class, eventListenerRegistry);

		DummySessionFactoryServiceRegistryFactory sessionFactoryServiceRegistryFactory = new DummySessionFactoryServiceRegistryFactory();
		sessionFactoryServiceRegistryFactory
				.setBuildServiceRegistryRWA(new RunnableWithArgs<SessionFactoryServiceRegistry>() {
					@Override
					public SessionFactoryServiceRegistry run(Object... args) {
						return sessionFactoryServiceRegistry;
					}
				});

		DummyStrategySelector strategySelector = new DummyStrategySelector();

		ClassLoaderService classLoaderService = new ClassLoaderServiceImpl();

		DummyStandardServiceRegistry standardServiceRegistry = new DummyStandardServiceRegistry();
		standardServiceRegistry.setService(JdbcEnvironment.class, jdbcEnvironment);
		standardServiceRegistry.setService(JdbcServices.class, jdbcServices);
		standardServiceRegistry.setService(SessionFactoryServiceRegistryFactory.class,
				sessionFactoryServiceRegistryFactory);
		standardServiceRegistry.setService(ConfigurationService.class, configurationService);
		standardServiceRegistry.setService(StrategySelector.class, strategySelector);
		standardServiceRegistry.setService(RegionFactory.class, regionFactory);
		standardServiceRegistry.setService(TransactionCoordinatorBuilder.class, transactionCoordinatorBuilder);
		standardServiceRegistry.setService(ClassLoaderService.class, classLoaderService);
		standardServiceRegistry.setService(CfgXmlAccessService.class, cfgXmlAccessService);

		DummyPhysicalNamingStrategy physicalNamingStrategy = new DummyPhysicalNamingStrategy();

		DummyMultiTableBulkIdStrategy multiTableBulkIdStrategy = new DummyMultiTableBulkIdStrategy();

		MetadataSources sources = new MetadataSources(standardServiceRegistry);
		MetadataBuilderImpl mbi = new MetadataBuilderImpl(sources, standardServiceRegistry);
		mbi.applyPhysicalNamingStrategy(physicalNamingStrategy);

		MetadataImplementor metadataImpl = mbi.build();

		SessionFactoryBuilderImpl sessionFactoryBuilderImpl = new SessionFactoryBuilderImpl(metadataImpl);
		sessionFactoryBuilderImpl.applyMultiTableBulkIdStrategy(multiTableBulkIdStrategy);

		SessionFactory sessionFactory = sessionFactoryBuilderImpl.build();

		Session s = sessionFactory.getCurrentSession();

		Transaction t = s.getTransaction();

		transactionDriverControl.setStatus(TransactionStatus.ACTIVE);

		A a = new A();
		s.persist(a);

		t.commit();

		sessionFactory.close();

	}
}

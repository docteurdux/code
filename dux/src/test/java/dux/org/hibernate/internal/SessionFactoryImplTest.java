package dux.org.hibernate.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.ConnectionReleaseMode;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.Session;
import org.hibernate.SessionEventListener;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.Transaction;
import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.hibernate.boot.internal.SessionFactoryOptionsImpl;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.boot.registry.selector.spi.StrategySelector;
import org.hibernate.cache.spi.RegionFactory;
import org.hibernate.cfg.BaselineSessionEventsListenerBuilder;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.env.spi.ExtractedDatabaseMetaData;
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
import dum.org.hibernate.DummySessionFactoryObserver;
import dum.org.hibernate.boot.cfgxml.spi.DummyCfgXmlAccessService;
import dum.org.hibernate.boot.internal.DummySessionFactoryOptionsState;
import dum.org.hibernate.boot.model.naming.DummyPhysicalNamingStrategy;
import dum.org.hibernate.boot.registry.selector.spi.DummyStrategySelector;
import dum.org.hibernate.boot.spi.DummyMappingDefaults;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.boot.spi.DummyMetadataImplementor;
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

		DummyConfigurationService configurationService = new DummyConfigurationService();
		configurationService.getSettings().put("hibernate.current_session_context_class", "thread");

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

		DummyTransactionCoordinatorBuilder transactionCoordinatorBuilder = new DummyTransactionCoordinatorBuilder();
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

		DummyStandardServiceRegistry standardServiceRegistry = new DummyStandardServiceRegistry();
		standardServiceRegistry.setService(JdbcEnvironment.class, jdbcEnvironment);
		standardServiceRegistry.setService(JdbcServices.class, jdbcServices);
		standardServiceRegistry.setService(SessionFactoryServiceRegistryFactory.class,
				sessionFactoryServiceRegistryFactory);
		standardServiceRegistry.setService(ConfigurationService.class, configurationService);
		standardServiceRegistry.setService(StrategySelector.class, strategySelector);
		standardServiceRegistry.setService(RegionFactory.class, regionFactory);
		standardServiceRegistry.setService(TransactionCoordinatorBuilder.class, transactionCoordinatorBuilder);

		DummyMappingDefaults mappingDefaults = new DummyMappingDefaults();
		mappingDefaults.setImplicitCatalogName("implicitCatalogName");
		mappingDefaults.setImplicitSchemaName("implicitSchemaName");

		DummyPhysicalNamingStrategy physicalNamingStrategy = new DummyPhysicalNamingStrategy();

		DummyMetadataBuildingOptions metadataBuildingOptions = new DummyMetadataBuildingOptions();
		metadataBuildingOptions.setServiceRegistry(standardServiceRegistry);
		metadataBuildingOptions.setMappingDefaults(mappingDefaults);
		metadataBuildingOptions.setPhysicalNamingStrategy(physicalNamingStrategy);

		Database database = new Database(metadataBuildingOptions);

		TypeResolver typeResolver = new TypeResolver();

		DummyMetadataImplementor metadataImplementor = new DummyMetadataImplementor();
		metadataImplementor.setDatabase(database);
		metadataImplementor.setTypeResolver(typeResolver);
		metadataImplementor.setMetadataBuildingOptions(metadataBuildingOptions);

		DummyMultiTableBulkIdStrategy multiTableBulkIdStrategy = new DummyMultiTableBulkIdStrategy();

		boolean logSessionMetrics = false;
		Class<? extends SessionEventListener> autoListener = null;
		BaselineSessionEventsListenerBuilder baselineSessionEventsListenerBuilder = new BaselineSessionEventsListenerBuilder(
				logSessionMetrics, autoListener);

		ConnectionReleaseMode connectionReleaseMode = ConnectionReleaseMode.ON_CLOSE;

		MultiTenancyStrategy multiTenancyStrategy = MultiTenancyStrategy.NONE;

		PhysicalConnectionHandlingMode physicalConnectionHandlingMode = PhysicalConnectionHandlingMode.IMMEDIATE_ACQUISITION_AND_HOLD;

		SessionFactoryObserver sessionFactoryObserver = new DummySessionFactoryObserver();
		SessionFactoryObserver[] sessionFactoryObservers = new SessionFactoryObserver[] { sessionFactoryObserver };

		SessionFactoryBuilderImpl sfbi = new SessionFactoryBuilderImpl(metadataImplementor);

		DummySessionFactoryOptionsState sessionFactoryOptionsState = new DummySessionFactoryOptionsState();
		sessionFactoryOptionsState.setServiceRegistry(standardServiceRegistry);
		sessionFactoryOptionsState.setSessionFactoryObservers(sessionFactoryObservers);
		sessionFactoryOptionsState.setMultiTableBulkIdStrategy(multiTableBulkIdStrategy);
		sessionFactoryOptionsState.setBaselineSessionEventsListenerBuilder(baselineSessionEventsListenerBuilder);
		sessionFactoryOptionsState.setPhysicalConnectionHandlingMode(physicalConnectionHandlingMode);
		sessionFactoryOptionsState.setMultiTenancyStrategy(multiTenancyStrategy);
		sessionFactoryOptionsState.setConnectionReleaseMode(connectionReleaseMode);

		SessionFactoryOptionsImpl sessionFactoryOptionsImpl = new SessionFactoryOptionsImpl(sessionFactoryOptionsState);

		SessionFactoryImpl sfi = new SessionFactoryImpl(metadataImplementor, sessionFactoryOptionsImpl);

		Session s = sfi.getCurrentSession();

		Transaction t = s.getTransaction();

		transactionDriverControl.setStatus(TransactionStatus.ACTIVE);

		A a = new A();
		s.persist(a);

		t.commit();

		sfi.close();

		/*-
		addNamedEntityGraph(String, EntityGraph<T>)
		addNamedQuery(String, Query)
		addObserver(SessionFactoryObserver)
		close()
		containsFetchProfileDefinition(String)
		createEntityManager()
		createEntityManager(Map)
		createEntityManager(SynchronizationType)
		createEntityManager(SynchronizationType, Map)
		findEntityGraphByName(String)
		findEntityGraphsByType(Class<T>)
		getAllClassMetadata()
		getAllCollectionMetadata()
		getAllSecondLevelCacheRegions()
		getCache()
		getClassMetadata(Class)
		getClassMetadata(String)
		getCollectionMetadata(String)
		getCriteriaBuilder()
		getCurrentSession()
		getCurrentTenantIdentifierResolver()
		getCustomEntityDirtinessStrategy()
		getDefinedFilterNames()
		getDeserializationResolver()
		getEntityNotFoundDelegate()
		getFetchProfile(String)
		getFilterDefinition(String)
		getIdentifierGenerator(String)
		getIdentifierGeneratorFactory()
		getIdentifierPropertyName(String)
		getIdentifierType(String)
		getInterceptor()
		getJdbcServices()
		getMetamodel()
		getName()
		getNamedQueryRepository()
		getPersistenceUnitUtil()
		getProperties()
		getQueryPlanCache()
		getReference()
		getReferencedPropertyType(String, String)
		getReturnAliases(String)
		getReturnTypes(String)
		getServiceRegistry()
		getSessionFactoryOptions()
		getSettings()
		getSqlFunctionRegistry()
		getStatistics()
		getTypeHelper()
		getTypeResolver()
		getUuid()
		isClosed()
		isOpen()
		openSession()
		openStatelessSession()
		openStatelessSession(Connection)
		openTemporarySession()
		resolveParameterBindType(Class)
		resolveParameterBindType(Object)
		unwrap(Class<T>)
		withOptions()
		withStatelessOptions()
		*/
	}
}

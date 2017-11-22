package dux.org.hibernate.internal;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.FlushMode;
import org.hibernate.LockOptions;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.cache.spi.RegionFactory;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.CacheImplementor;
import org.hibernate.event.service.spi.EventListenerGroup;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.FlushEventListener;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.factory.IdentifierGeneratorFactory;
import org.hibernate.integrator.spi.IntegratorService;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.internal.SessionImpl;
import org.hibernate.mapping.RootClass;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.spi.PersisterFactory;
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

import dum.org.hibernate.DummySessionEventListener;
import dum.org.hibernate.boot.cfgxml.spi.DummyCfgXmlAccessService;
import dum.org.hibernate.boot.model.naming.DummyPhysicalNamingStrategy;
import dum.org.hibernate.boot.spi.DummyMappingDefaults;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.boot.spi.DummyMetadataImplementor;
import dum.org.hibernate.boot.spi.DummySessionFactoryOptions;
import dum.org.hibernate.cache.spi.DummyRegionFactory;
import dum.org.hibernate.engine.config.spi.DummyConfigurationService;
import dum.org.hibernate.engine.jdbc.env.spi.DummyIdentifierHelper;
import dum.org.hibernate.engine.jdbc.env.spi.DummyJdbcEnvironment;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.spi.DummyCacheImplementor;
import dum.org.hibernate.event.service.spi.DummyEventListenerGroup;
import dum.org.hibernate.event.service.spi.DummyEventListenerRegistry;
import dum.org.hibernate.hql.spi.id.DummyMultiTableBulkIdStrategy;
import dum.org.hibernate.id.DummyIdentifierGenerator;
import dum.org.hibernate.id.factory.DummyIdentifierGeneratorFactory;
import dum.org.hibernate.internal.DummySessionCreationOptions;
import dum.org.hibernate.mapping.DummyKeyValue;
import dum.org.hibernate.persister.entity.DummyEntityPersister;
import dum.org.hibernate.persister.spi.DummyPersisterFactory;
import dum.org.hibernate.resource.transaction.spi.DummyTransactionCoordinator;
import dum.org.hibernate.resource.transaction.spi.DummyTransactionCoordinatorBuilder;
import dum.org.hibernate.resource.transaction.spi.TransactionCoordinator.DummyTransactionDriver;
import dum.org.hibernate.service.spi.DummySessionFactoryServiceRegistry;
import dum.org.hibernate.service.spi.DummySessionFactoryServiceRegistryFactory;
import dum.org.hibernate.stat.spi.DummyStatisticsImplementor;
import dux.org.hibernate.query.criteria.internal.DummyIntegratorService;
import dux.org.hibernate.query.criteria.internal.DummyStandardServiceRegistry;

public class SessionImplTest extends AbstractTest {

	public static class A {

	}

	private Dialect dialect;
	private DummyIdentifierHelper identifierHelper;
	private DummyJdbcEnvironment jdbcEnvironment;
	private DummyJdbcServices jdbcServices;
	private DummyStandardServiceRegistry standardServiceRegistry;
	private DummySessionFactoryServiceRegistryFactory sessionFactoryServiceRegistryFactory;
	private DummySessionFactoryServiceRegistry sessionFactoryServiceRegistry;
	private DummyCfgXmlAccessService cfgXmlAccessService;
	private DummyIntegratorService integratorService;
	private DummyConfigurationService configurationService;
	private DummyCacheImplementor cacheImplementor;
	private RegionFactory regionFactory;
	private DummyStatisticsImplementor statisticsImplementor;
	private DummyTransactionCoordinatorBuilder transactionCoordinatorBuilder;
	private DummyTransactionCoordinator transactionCoordinator;
	private DummyMappingDefaults mappingDefaults;
	private DummyMetadataBuildingOptions metadataBuildingOptions;
	private DummyPhysicalNamingStrategy physicalNamingStrategy;
	private Database database;
	private TypeResolver typeResolver;
	private DummyMetadataImplementor metadataImplementor;
	private DummySessionFactoryOptions sessionFactoryOptions;
	private PhysicalConnectionHandlingMode physicalConnectionHandlingMode;
	private MultiTenancyStrategy multiTenancyStrategy;
	private DummyMultiTableBulkIdStrategy multiTableBulkIdStrategy;
	private SessionFactoryImpl sessionFactoryImpl;
	private DummySessionCreationOptions sessionCreationOptions;
	private FlushMode initialSessionFlushMode;
	private DummyEventListenerRegistry eventListenerRegistry;
	private DummyEventListenerGroup<FlushEventListener> eventListenerGroupFlush;
	private DummyTransactionDriver transactionDriver;
	private DummyMetadataBuildingContext metadataBuildingContext;
	private RootClass persistentClass1;
	private DummyPersisterFactory persisterFactory;
	private DummyEntityPersister entityPersister;
	private RootClass persistentClass2;
	private DummyIdentifierGenerator identifierGenerator1;
	private DummyKeyValue identifier1;
	private DummyIdentifierGenerator identifierGenerator2;
	private DummyKeyValue identifier2;
	private IdentifierGeneratorFactory identifierGeneratorFactory;
	private Map<String, Identifier> identifiers;

	public SessionImplTest() {

	}

	@SuppressWarnings("rawtypes")
	@Before
	public void before() {
		dialect = new Dialect() {
		};

		identifiers = new HashMap<>();

		identifierHelper = new DummyIdentifierHelper();
		identifierHelper.setToIdentifierRWA(new RunnableWithArgs<Identifier>() {
			@Override
			public Identifier run(Object... args) {
				String text = (String) args[0];
				if (!identifiers.containsKey(text)) {
					identifiers.put(text, new Identifier(text, false));
				}
				return identifiers.get(text);
			}
		});

		jdbcEnvironment = new DummyJdbcEnvironment();
		jdbcEnvironment.setIdentifierHelper(identifierHelper);
		jdbcEnvironment.setDialect(dialect);

		jdbcServices = new DummyJdbcServices();
		jdbcServices.setJdbcEnvironment(jdbcEnvironment);

		cfgXmlAccessService = new DummyCfgXmlAccessService();

		integratorService = new DummyIntegratorService();

		configurationService = new DummyConfigurationService();

		regionFactory = new DummyRegionFactory();

		cacheImplementor = new DummyCacheImplementor();
		cacheImplementor.setRegionFactory(regionFactory);

		statisticsImplementor = new DummyStatisticsImplementor();

		transactionDriver = new DummyTransactionDriver();

		transactionCoordinator = new DummyTransactionCoordinator();
		transactionCoordinator.setTransactionDriverControl(transactionDriver);

		transactionCoordinatorBuilder = new DummyTransactionCoordinatorBuilder();
		transactionCoordinatorBuilder.setBuildTransactionCoordinatorRWA(new RunnableWithArgs<TransactionCoordinator>() {
			@Override
			public TransactionCoordinator run(Object... args) {
				return transactionCoordinator;
			}
		});

		eventListenerGroupFlush = new DummyEventListenerGroup<FlushEventListener>();

		eventListenerRegistry = new DummyEventListenerRegistry();
		eventListenerRegistry.setGetEventListenerGroupRWA(new RunnableWithArgs<EventListenerGroup>() {
			@Override
			public EventListenerGroup run(Object... args) {
				EventType et = (EventType) args[0];
				if (et.baseListenerInterface() == FlushEventListener.class) {
					return eventListenerGroupFlush;
				}
				return null;
			}
		});

		entityPersister = new DummyEntityPersister();

		persisterFactory = new DummyPersisterFactory();
		persisterFactory.setCreateEntityPersisterRWA(new RunnableWithArgs<EntityPersister>() {

			@Override
			public EntityPersister run(Object... args) {
				return entityPersister;
			}
		});

		sessionFactoryServiceRegistry = new DummySessionFactoryServiceRegistry();
		sessionFactoryServiceRegistry.setService(CfgXmlAccessService.class, cfgXmlAccessService);
		sessionFactoryServiceRegistry.setService(JdbcServices.class, jdbcServices);
		sessionFactoryServiceRegistry.setService(IntegratorService.class, integratorService);
		sessionFactoryServiceRegistry.setService(ConfigurationService.class, configurationService);
		sessionFactoryServiceRegistry.setService(StatisticsImplementor.class, statisticsImplementor);
		sessionFactoryServiceRegistry.setService(CacheImplementor.class, cacheImplementor);
		sessionFactoryServiceRegistry.setService(TransactionCoordinatorBuilder.class, transactionCoordinatorBuilder);
		sessionFactoryServiceRegistry.setService(EventListenerRegistry.class, eventListenerRegistry);
		sessionFactoryServiceRegistry.setService(PersisterFactory.class, persisterFactory);

		sessionFactoryServiceRegistryFactory = new DummySessionFactoryServiceRegistryFactory();
		sessionFactoryServiceRegistryFactory
				.setBuildServiceRegistryRWA(new RunnableWithArgs<SessionFactoryServiceRegistry>() {
					@Override
					public SessionFactoryServiceRegistry run(Object... args) {
						return sessionFactoryServiceRegistry;
					}
				});

		standardServiceRegistry = new DummyStandardServiceRegistry();
		standardServiceRegistry.setService(SessionFactoryServiceRegistryFactory.class,
				sessionFactoryServiceRegistryFactory);
		standardServiceRegistry.setService(JdbcServices.class, jdbcServices);

		mappingDefaults = new DummyMappingDefaults();
		mappingDefaults.setImplicitCatalogName("implicitCatalogName");
		mappingDefaults.setImplicitSchemaName("implicitSchemaName");

		physicalNamingStrategy = new DummyPhysicalNamingStrategy();

		metadataBuildingOptions = new DummyMetadataBuildingOptions();
		metadataBuildingOptions.setServiceRegistry(standardServiceRegistry);
		metadataBuildingOptions.setMappingDefaults(mappingDefaults);
		metadataBuildingOptions.setPhysicalNamingStrategy(physicalNamingStrategy);

		database = new Database(metadataBuildingOptions, jdbcEnvironment);

		typeResolver = new TypeResolver();

		metadataBuildingContext = new DummyMetadataBuildingContext();

		identifierGenerator1 = new DummyIdentifierGenerator();

		identifier1 = new DummyKeyValue();
		identifier1.setCreateIdentifierGeneratorRWA(new RunnableWithArgs<IdentifierGenerator>() {
			@Override
			public IdentifierGenerator run(Object... args) {
				return identifierGenerator1;
			}
		});

		persistentClass1 = new RootClass(metadataBuildingContext);
		persistentClass1.setIdentifier(identifier1);
		persistentClass1.setEntityName("entityName");

		identifierGenerator2 = new DummyIdentifierGenerator();

		identifier2 = new DummyKeyValue();
		identifier2.setCreateIdentifierGeneratorRWA(new RunnableWithArgs<IdentifierGenerator>() {
			@Override
			public IdentifierGenerator run(Object... args) {
				return identifierGenerator2;
			}
		});

		persistentClass2 = new RootClass(metadataBuildingContext);
		persistentClass2.setIdentifier(identifier2);
		persistentClass2.setEntityName("dux.org.hibernate.internal.SessionImplTest$A");

		identifierGeneratorFactory = new DummyIdentifierGeneratorFactory();

		metadataImplementor = new DummyMetadataImplementor();
		metadataImplementor.setTypeResolver(typeResolver);
		metadataImplementor.setDatabase(database);
		metadataImplementor.getEntityBindings().add(persistentClass1);
		metadataImplementor.getEntityBindings().add(persistentClass2);
		metadataImplementor.setIdentifierGeneratorFactory(identifierGeneratorFactory);

		physicalConnectionHandlingMode = PhysicalConnectionHandlingMode.DELAYED_ACQUISITION_AND_HOLD;
		multiTenancyStrategy = MultiTenancyStrategy.DATABASE;

		multiTableBulkIdStrategy = new DummyMultiTableBulkIdStrategy();

		sessionFactoryOptions = new DummySessionFactoryOptions();
		sessionFactoryOptions.setPhysicalConnectionHandlingMode(physicalConnectionHandlingMode);
		sessionFactoryOptions.setMultiTenancyStrategy(multiTenancyStrategy);
		sessionFactoryOptions.setMultiTableBulkIdStrategy(multiTableBulkIdStrategy);
		sessionFactoryOptions.setServiceRegistry(standardServiceRegistry);

		sessionFactoryImpl = new SessionFactoryImpl(metadataImplementor, sessionFactoryOptions);

		initialSessionFlushMode = FlushMode.AUTO;

		sessionCreationOptions = new DummySessionCreationOptions();
		sessionCreationOptions.setInitialSessionFlushMode(initialSessionFlushMode);
		sessionCreationOptions.setTenantIdentifier("tenantIdentifier");

	}

	@Test
	public void test() {
		SessionImpl sessionImpl = new SessionImpl(sessionFactoryImpl, sessionCreationOptions);
		DummySessionEventListener sessionEventListener = new DummySessionEventListener();
		sessionImpl.addEventListeners(sessionEventListener);
		sessionImpl.afterOperation(true);
		sessionImpl.afterScrollOperation();
		sessionImpl.afterTransactionBegin();
		sessionImpl.afterTransactionCompletion(true, false);

		setTransactionActive(true);
		try {
			sessionImpl.beforeTransactionCompletion();
		} finally {
			setTransactionActive(false);
		}

		aeq("java.lang.Object", sessionImpl.bestGuessEntityName(new Object()));

		LockOptions lockOptions = new LockOptions();
		sessionImpl.buildLockRequest(lockOptions);
		sessionImpl.byId(A.class);
		sessionImpl.byId("entityName");
		sessionImpl.byMultipleIds(A.class);
		sessionImpl.byMultipleIds("entityName");
		sessionImpl.byNaturalId(A.class);

		sessionImpl.close();
	}

	private void setTransactionActive(boolean active) {
		if (active) {
			transactionCoordinator.setJoined(true);
			transactionDriver.setStatus(TransactionStatus.ACTIVE);
		} else {
			transactionCoordinator.setJoined(false);
			transactionDriver.setStatus(TransactionStatus.NOT_ACTIVE);
		}
	}
}

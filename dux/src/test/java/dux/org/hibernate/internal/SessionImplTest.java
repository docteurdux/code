package dux.org.hibernate.internal;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.LockModeType;
import javax.persistence.NamedEntityGraph;
import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.EntityMode;
import org.hibernate.FlushMode;
import org.hibernate.LockMode;
import org.hibernate.LockOptions;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.ReplicationMode;
import org.hibernate.ScrollMode;
import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.cache.spi.RegionFactory;
import org.hibernate.cfg.annotations.NamedEntityGraphDefinition;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.ResultSetMappingDefinition;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.internal.AbstractEntityEntry;
import org.hibernate.engine.internal.EntityEntryContext;
import org.hibernate.engine.internal.StatefulPersistenceContext;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.engine.jdbc.spi.SqlStatementLogger;
import org.hibernate.engine.query.spi.NativeQueryInterpreter;
import org.hibernate.engine.query.spi.NativeSQLQueryPlan;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn;
import org.hibernate.engine.query.spi.sql.NativeSQLQuerySpecification;
import org.hibernate.engine.spi.CacheImplementor;
import org.hibernate.engine.spi.EntityEntry;
import org.hibernate.engine.spi.EntityKey;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.engine.spi.ManagedEntity;
import org.hibernate.engine.spi.NamedQueryDefinition;
import org.hibernate.engine.spi.NamedSQLQueryDefinition;
import org.hibernate.engine.spi.PersistenceContext;
import org.hibernate.engine.spi.QueryParameters;
import org.hibernate.engine.spi.Status;
import org.hibernate.event.internal.AbstractSaveEventListener;
import org.hibernate.event.internal.DefaultPersistEventListener;
import org.hibernate.event.service.spi.EventListenerGroup;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.ClearEventListener;
import org.hibernate.event.spi.DeleteEventListener;
import org.hibernate.event.spi.EventType;
import org.hibernate.event.spi.EvictEventListener;
import org.hibernate.event.spi.FlushEventListener;
import org.hibernate.event.spi.LoadEventListener;
import org.hibernate.event.spi.PersistEvent;
import org.hibernate.event.spi.PersistEventListener;
import org.hibernate.hql.spi.QueryTranslator;
import org.hibernate.hql.spi.QueryTranslatorFactory;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.factory.IdentifierGeneratorFactory;
import org.hibernate.integrator.spi.IntegratorService;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.internal.SessionImpl;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.hibernate.loader.custom.CustomQuery;
import org.hibernate.mapping.FetchProfile;
import org.hibernate.mapping.MetadataSource;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.RootClass;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.persister.spi.PersisterFactory;
import org.hibernate.procedure.ProcedureCallMemento;
import org.hibernate.query.criteria.internal.compile.CriteriaInterpretation;
import org.hibernate.query.spi.NamedQueryRepository;
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
import com.github.docteurdux.test.RunnableWhichThrow;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.java.sql.DummyConnection;
import dum.java.sql.DummyPreparedStatement;
import dum.javax.persistence.criteria.DummyCriteriaDelete;
import dum.javax.persistence.criteria.DummyCriteriaQuery;
import dum.javax.persistence.criteria.DummyCriteriaUpdate;
import dum.javax.persistence.criteria.DummySelection;
import dum.org.hibernate.DummySessionEventListener;
import dum.org.hibernate.boot.cfgxml.spi.DummyCfgXmlAccessService;
import dum.org.hibernate.boot.model.naming.DummyPhysicalNamingStrategy;
import dum.org.hibernate.boot.spi.DummyClassLoaderAccess;
import dum.org.hibernate.boot.spi.DummyMappingDefaults;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.boot.spi.DummyMetadataImplementor;
import dum.org.hibernate.boot.spi.DummySessionFactoryOptions;
import dum.org.hibernate.cache.spi.DummyRegionFactory;
import dum.org.hibernate.collection.spi.DummyPersistentCollection;
import dum.org.hibernate.engine.config.spi.DummyConfigurationService;
import dum.org.hibernate.engine.internal.DummyAbstractEntityEntry;
import dum.org.hibernate.engine.jdbc.connections.spi.DummyMultiTenantConnectionProvider;
import dum.org.hibernate.engine.jdbc.env.spi.DummyIdentifierHelper;
import dum.org.hibernate.engine.jdbc.env.spi.DummyJdbcEnvironment;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.query.spi.DummyNativeQueryInterpreter;
import dum.org.hibernate.engine.spi.DummyCacheImplementor;
import dum.org.hibernate.engine.spi.DummyManagedEntity;
import dum.org.hibernate.event.service.spi.DummyEventListenerGroup;
import dum.org.hibernate.event.service.spi.DummyEventListenerRegistry;
import dum.org.hibernate.hql.spi.DummyParameterTranslations;
import dum.org.hibernate.hql.spi.DummyQueryTranslator;
import dum.org.hibernate.hql.spi.DummyQueryTranslatorFactory;
import dum.org.hibernate.hql.spi.id.DummyMultiTableBulkIdStrategy;
import dum.org.hibernate.id.DummyIdentifierGenerator;
import dum.org.hibernate.id.factory.DummyIdentifierGeneratorFactory;
import dum.org.hibernate.internal.DummySessionCreationOptions;
import dum.org.hibernate.loader.custom.DummyCustomQuery;
import dum.org.hibernate.mapping.DummyKeyValue;
import dum.org.hibernate.persister.entity.DummyEntityPersister;
import dum.org.hibernate.persister.spi.DummyPersisterFactory;
import dum.org.hibernate.procedure.DummyProcedureCallMemento;
import dum.org.hibernate.proxy.DummyEntityNotFoundDelegate;
import dum.org.hibernate.proxy.DummyHibernateProxy;
import dum.org.hibernate.proxy.DummyLazyInitializer;
import dum.org.hibernate.query.criteria.internal.compile.DummyCriteriaInterpretation;
import dum.org.hibernate.resource.transaction.spi.DummyTransactionCoordinator;
import dum.org.hibernate.resource.transaction.spi.DummyTransactionCoordinatorBuilder;
import dum.org.hibernate.resource.transaction.spi.TransactionCoordinator.DummyTransactionDriver;
import dum.org.hibernate.service.spi.DummySessionFactoryServiceRegistry;
import dum.org.hibernate.service.spi.DummySessionFactoryServiceRegistryFactory;
import dum.org.hibernate.stat.spi.DummyStatisticsImplementor;
import dum.org.hibernate.type.DummyType;
import dus.hibernate.core.HibernateCoreSummaryTest;
import dux.org.hibernate.query.criteria.internal.DummyIntegratorService;
import dux.org.hibernate.query.criteria.internal.DummyStandardServiceRegistry;

public class SessionImplTest extends AbstractTest {

	@NamedEntityGraph
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
	private RootClass rootClass1;
	private DummyPersisterFactory persisterFactory;
	private DummyEntityPersister entityPersister;
	private RootClass rootClass2;
	private DummyIdentifierGenerator identifierGenerator1;
	private DummyKeyValue identifier1;
	private DummyIdentifierGenerator identifierGenerator2;
	private DummyKeyValue identifier2;
	private IdentifierGeneratorFactory identifierGeneratorFactory;
	private Map<String, Identifier> identifiers;
	private DummyEventListenerGroup<ClearEventListener> eventListenerGroupClear;
	private DummyMultiTenantConnectionProvider multiTenantConnectionProvider;
	private DummyClassLoaderAccess classLoaderAccess;
	private DummyCriteriaInterpretation criteriaInterpretation;
	private DummyCriteriaDelete<Object> criteriaDelete;
	private DummyCriteriaQuery<Object> criteriaQuery;
	private DummyCriteriaUpdate<Object> criteriaUpdate;
	private DummyQueryTranslatorFactory queryTranslatorFactory;
	private DummyQueryTranslator queryTranslator;
	private DummySelection<Object> selection;
	private DummyQueryOptions queryOptions;
	private DummyProcedureCallMemento procedureCallMemento;
	private ResultSetMappingDefinition resultSetMappingDefinition;
	private DummyEventListenerGroup<DeleteEventListener> eventListenerGroupDelete;
	private DummyEventListenerGroup<EvictEventListener> eventListenerGroupEvict;
	private DummyNativeQueryInterpreter nativeQueryInterpreter;
	private NativeSQLQueryPlan nativeSQLQueryPlan;
	private DummyConnection connection;
	private DummyEventListenerGroup<LoadEventListener> eventListenerGroupLoad;
	private DummyEventListenerGroup<PersistEventListener> eventListenerGroupPersist;
	private DummyPersistEventListener persistEventListener;

	public SessionImplTest() {

	}

	@SuppressWarnings("rawtypes")
	@Before
	public void before() {

		requireSources(HibernateCoreSummaryTest.MVNNAME, SessionImpl.class, DefaultPersistEventListener.class,
				AbstractSaveEventListener.class, StatefulPersistenceContext.class, EntityEntryContext.class);

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

		SqlStatementLogger sqlStatementLogger = new SqlStatementLogger();

		SqlExceptionHelper sqlExceptionHelper = new SqlExceptionHelper(false);

		jdbcServices = new DummyJdbcServices();
		jdbcServices.setJdbcEnvironment(jdbcEnvironment);
		jdbcServices.setSqlStatementLogger(sqlStatementLogger);
		jdbcServices.setSqlExceptionHelper(sqlExceptionHelper);

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

		DefaultPersistEventListener defaultPersistEventListener = new DefaultPersistEventListener();

		persistEventListener = new DummyPersistEventListener();
		persistEventListener.setOnPersistRWA(new RunnableWithArgs<Void>() {
			@Override
			public Void run(Object... args) {
				PersistEvent event = (PersistEvent) args[0];
				if (args.length == 1) {
					defaultPersistEventListener.onPersist(event);
				} else {
					Map createdAlready = (Map) args[1];
					defaultPersistEventListener.onPersist(event, createdAlready);
				}
				return null;
			}
		});

		eventListenerGroupFlush = new DummyEventListenerGroup<FlushEventListener>();
		eventListenerGroupClear = new DummyEventListenerGroup<ClearEventListener>();
		eventListenerGroupDelete = new DummyEventListenerGroup<DeleteEventListener>();
		eventListenerGroupEvict = new DummyEventListenerGroup<EvictEventListener>();
		eventListenerGroupLoad = new DummyEventListenerGroup<LoadEventListener>();
		eventListenerGroupPersist = new DummyEventListenerGroup<PersistEventListener>();
		eventListenerGroupPersist.appendListener(persistEventListener);

		eventListenerRegistry = new DummyEventListenerRegistry();
		eventListenerRegistry.setGetEventListenerGroupRWA(new RunnableWithArgs<EventListenerGroup>() {
			@Override
			public EventListenerGroup run(Object... args) {
				EventType et = (EventType) args[0];
				if (et.baseListenerInterface() == FlushEventListener.class) {
					return eventListenerGroupFlush;
				} else if (et.baseListenerInterface() == ClearEventListener.class) {
					return eventListenerGroupClear;
				} else if (et.baseListenerInterface() == DeleteEventListener.class) {
					return eventListenerGroupDelete;
				} else if (et.baseListenerInterface() == EvictEventListener.class) {
					return eventListenerGroupEvict;
				} else if (et.baseListenerInterface() == LoadEventListener.class) {
					return eventListenerGroupLoad;
				} else if (et.baseListenerInterface() == PersistEventListener.class) {
					return eventListenerGroupPersist;
				}
				return null;
			}
		});

		DummyType identifierType = new DummyType();

		entityPersister = new DummyEntityPersister();
		entityPersister.setHasNaturalIdentifier(true);
		entityPersister.setNaturalIdentifierProperties(new int[] { 0 });
		entityPersister.setPropertyNames(new String[] { "propertyName" });
		entityPersister.setQuerySpaces(new String[] {});
		entityPersister.setEntityName("entityName");
		entityPersister.setMutable(true);
		entityPersister.setRootEntityName("rootEntityName");
		entityPersister.setIdentifierType(identifierType);

		persisterFactory = new DummyPersisterFactory();
		persisterFactory.setCreateEntityPersisterRWA(new RunnableWithArgs<EntityPersister>() {
			@Override
			public EntityPersister run(Object... args) {
				return entityPersister;
			}
		});

		DummyPreparedStatement preparedStatement = new DummyPreparedStatement();

		connection = new DummyConnection();
		connection.setPrepareStatementRWA(new RunnableWithArgs<PreparedStatement>() {
			@Override
			public PreparedStatement run(Object... args) {
				return preparedStatement;
			}
		});

		multiTenantConnectionProvider = new DummyMultiTenantConnectionProvider();
		multiTenantConnectionProvider.setGetConnectionRWA(new RunnableWithArgs<Connection>() {
			@Override
			public Connection run(Object... args) {
				return connection;
			}
		});

		DummyParameterTranslations parameterTranslations = new DummyParameterTranslations();

		queryTranslator = new DummyQueryTranslator();
		queryTranslator.setParameterTranslations(parameterTranslations);

		queryTranslatorFactory = new DummyQueryTranslatorFactory();
		queryTranslatorFactory.setCreateQueryTranslatorRWA(new RunnableWithArgs<QueryTranslator>() {
			@Override
			public QueryTranslator run(Object... args) {
				return queryTranslator;
			}
		});

		DummyCustomQuery customQuery = new DummyCustomQuery();
		customQuery.setSQL("sql");
		nativeSQLQueryPlan = new NativeSQLQueryPlan("sourceQuery", customQuery);

		nativeQueryInterpreter = new DummyNativeQueryInterpreter();
		nativeQueryInterpreter.setCreateQueryPlanRWA(new RunnableWithArgs<NativeSQLQueryPlan>() {
			@Override
			public NativeSQLQueryPlan run(Object... args) {
				return nativeSQLQueryPlan;
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
		sessionFactoryServiceRegistry.setService(MultiTenantConnectionProvider.class, multiTenantConnectionProvider);
		sessionFactoryServiceRegistry.setService(QueryTranslatorFactory.class, queryTranslatorFactory);
		sessionFactoryServiceRegistry.setService(NativeQueryInterpreter.class, nativeQueryInterpreter);

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

		classLoaderAccess = new DummyClassLoaderAccess();
		classLoaderAccess.setClassForNameRWA(new RunnableWithArgs<Class<?>>() {
			@Override
			public Class<?> run(Object... args) {
				@SuppressWarnings("unused")
				String name = (String) args[0];
				return A.class;
			}
		});

		metadataBuildingContext = new DummyMetadataBuildingContext();
		metadataBuildingContext.setClassLoaderAccess(classLoaderAccess);

		identifierGenerator1 = new DummyIdentifierGenerator();

		identifier1 = new DummyKeyValue();
		identifier1.setCreateIdentifierGeneratorRWA(new RunnableWithArgs<IdentifierGenerator>() {
			@Override
			public IdentifierGenerator run(Object... args) {
				return identifierGenerator1;
			}
		});

		rootClass1 = new RootClass(metadataBuildingContext);
		rootClass1.setIdentifier(identifier1);
		rootClass1.setEntityName("entityName");
		rootClass1.setClassName("entityClassName");

		identifierGenerator2 = new DummyIdentifierGenerator();

		identifier2 = new DummyKeyValue();
		identifier2.setCreateIdentifierGeneratorRWA(new RunnableWithArgs<IdentifierGenerator>() {
			@Override
			public IdentifierGenerator run(Object... args) {
				return identifierGenerator2;
			}
		});

		rootClass2 = new RootClass(metadataBuildingContext);
		rootClass2.setIdentifier(identifier2);
		rootClass2.setEntityName("dux.org.hibernate.internal.SessionImplTest$A");
		rootClass2.setClassName(A.class.getName());

		identifierGeneratorFactory = new DummyIdentifierGeneratorFactory();

		procedureCallMemento = new DummyProcedureCallMemento();

		resultSetMappingDefinition = new ResultSetMappingDefinition("resultSetMapping1");

		Iterable<NamedQueryDefinition> namedQueryDefinitions = new ArrayList<>();
		Iterable<NamedSQLQueryDefinition> namedSqlQueryDefinitions = new ArrayList<>();

		ArrayList<ResultSetMappingDefinition> namedSqlResultSetMappings = new ArrayList<>();
		namedSqlResultSetMappings.add(resultSetMappingDefinition);

		Map<String, ProcedureCallMemento> namedProcedureCalls = new HashMap<>();
		namedProcedureCalls.put("namedStoredProcedureQuery", procedureCallMemento);
		NamedQueryRepository namedQueryRepository = new NamedQueryRepository(namedQueryDefinitions,
				namedSqlQueryDefinitions, namedSqlResultSetMappings, namedProcedureCalls);

		FetchProfile fp = new FetchProfile("fetchProfileName", MetadataSource.OTHER);

		FilterDefinition fd = new FilterDefinition("filterName", "defaultCondition", new HashMap<>());

		NamedEntityGraph namedEntityGraph = getAnnotation(A.class, NamedEntityGraph.class);
		NamedEntityGraphDefinition namedEntityGraphDefinition = new NamedEntityGraphDefinition(namedEntityGraph,
				"jpaEntityName", "entityName");

		metadataImplementor = new DummyMetadataImplementor();
		metadataImplementor.setTypeResolver(typeResolver);
		metadataImplementor.setDatabase(database);
		metadataImplementor.getEntityBindings().add(rootClass1);
		metadataImplementor.getEntityBindings().add(rootClass2);
		metadataImplementor.setIdentifierGeneratorFactory(identifierGeneratorFactory);
		metadataImplementor.setBuildNamedQueryRepositoryRWA(new RunnableWithArgs<NamedQueryRepository>() {
			@Override
			public NamedQueryRepository run(Object... args) {
				return namedQueryRepository;
			}
		});
		metadataImplementor.getFetchProfiles().add(fp);
		metadataImplementor.getFilterDefinitions().put("filterName", fd);
		metadataImplementor.getNamedEntityGraphs().put("entityGraphName", namedEntityGraphDefinition);

		physicalConnectionHandlingMode = PhysicalConnectionHandlingMode.DELAYED_ACQUISITION_AND_HOLD;
		multiTenancyStrategy = MultiTenancyStrategy.DATABASE;

		multiTableBulkIdStrategy = new DummyMultiTableBulkIdStrategy();

		DummyEntityNotFoundDelegate entityNotFoundDelegate = new DummyEntityNotFoundDelegate();

		sessionFactoryOptions = new DummySessionFactoryOptions();
		sessionFactoryOptions.setPhysicalConnectionHandlingMode(physicalConnectionHandlingMode);
		sessionFactoryOptions.setMultiTenancyStrategy(multiTenancyStrategy);
		sessionFactoryOptions.setMultiTableBulkIdStrategy(multiTableBulkIdStrategy);
		sessionFactoryOptions.setServiceRegistry(standardServiceRegistry);
		sessionFactoryOptions.setEntityNotFoundDelegate(entityNotFoundDelegate);

		sessionFactoryImpl = new SessionFactoryImpl(metadataImplementor, sessionFactoryOptions);

		initialSessionFlushMode = FlushMode.AUTO;

		sessionCreationOptions = new DummySessionCreationOptions();
		sessionCreationOptions.setInitialSessionFlushMode(initialSessionFlushMode);
		sessionCreationOptions.setTenantIdentifier("tenantIdentifier");

		criteriaInterpretation = new DummyCriteriaInterpretation();
		criteriaDelete = new DummyCriteriaDelete<>();
		criteriaDelete.setInterpretRWA(new RunnableWithArgs<CriteriaInterpretation>() {
			@Override
			public CriteriaInterpretation run(Object... args) {
				return criteriaInterpretation;
			}
		});

		criteriaQuery = new DummyCriteriaQuery<>();
		criteriaQuery.setInterpretRWA(new RunnableWithArgs<CriteriaInterpretation>() {
			@Override
			public CriteriaInterpretation run(Object... args) {
				return criteriaInterpretation;
			}
		});

		criteriaUpdate = new DummyCriteriaUpdate<>();
		criteriaUpdate.setInterpretRWA(new RunnableWithArgs<CriteriaInterpretation>() {
			@Override
			public CriteriaInterpretation run(Object... args) {
				return criteriaInterpretation;
			}
		});

		selection = new DummySelection<>();
		queryOptions = new DummyQueryOptions();
	}

	@SuppressWarnings("unchecked")
	// @Test
	public void test() {
		if (t()) {
			return;
		}
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
		sessionImpl.byNaturalId("entityName");
		sessionImpl.bySimpleNaturalId(A.class);
		sessionImpl.bySimpleNaturalId("entityName");
		sessionImpl.cancelQuery();
		sessionImpl.clear();
		sessionImpl.connection();
		sessionImpl.contains(new A());
		sessionImpl.contains("dux.org.hibernate.internal.SessionImplTest$A", new A());
		sessionImpl.createCriteria(A.class);
		sessionImpl.createCriteria(A.class, "alias");
		sessionImpl.createCriteria("entityName");
		sessionImpl.createCriteria("entityName", "alias");
		sessionImpl.createEntityGraph(A.class);
		sessionImpl.createEntityGraph("entityName");
		// sessionImpl.createFilter(collection, "queryString");
		sessionImpl.createNamedStoredProcedureQuery("namedStoredProcedureQuery");

		sessionImpl.createQuery(criteriaDelete);
		sessionImpl.createQuery(criteriaQuery);
		sessionImpl.createQuery(criteriaUpdate);
		sessionImpl.createQuery("jpaqlString", A.class, selection, queryOptions);

		sessionImpl.createStoredProcedureCall("procedureName");
		sessionImpl.createStoredProcedureCall("procedureName", A.class);
		sessionImpl.createStoredProcedureCall("procedureName", "resultSetMapping1");

		sessionImpl.createStoredProcedureQuery("procedureName");
		sessionImpl.createStoredProcedureQuery("procedureName", A.class);
		sessionImpl.createStoredProcedureQuery("procedureName", "resultSetMapping1");

		sessionImpl.delete(new Object());
		sessionImpl.delete("entityName", new Object());
		boolean isCascadeDeleteEnabled = false;
		@SuppressWarnings("rawtypes")
		Set transientEntities = new HashSet<>();
		sessionImpl.delete("entityName", new Object(), isCascadeDeleteEnabled, transientEntities);

		sessionImpl.detach(new Object());

		sessionImpl.disableFetchProfile("fetchProfileName");

		sessionImpl.disableFilter("filterName");

		sessionImpl.disconnect();

		sessionImpl.doReturningWork(new ReturningWork<String>() {
			@Override
			public String execute(Connection connection) throws SQLException {
				return null;
			}
		});

		sessionImpl.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
			}
		});

		sessionImpl.enableFetchProfile("fetchProfileName");

		sessionImpl.enableFilter("filterName");

		sessionImpl.evict(new Object());

		NativeSQLQueryReturn[] queryReturns = new NativeSQLQueryReturn[] {};
		Collection querySpaces = new ArrayList<>();
		NativeSQLQuerySpecification nativeQuerySpecification = new NativeSQLQuerySpecification("queryString",
				queryReturns, querySpaces);
		QueryParameters queryParameters = new QueryParameters();
		sessionImpl.executeNativeUpdate(nativeQuerySpecification, queryParameters);

		sessionImpl.executeUpdate("query", queryParameters);

		Serializable id = new Serializable() {
			private static final long serialVersionUID = 1L;
		};
		sessionImpl.find(A.class, id);
		LockModeType lockModeType = LockModeType.NONE;
		sessionImpl.find(A.class, id, lockModeType);
		@SuppressWarnings("rawtypes")
		Map properties = new HashMap<>();
		sessionImpl.find(A.class, id, properties);
		sessionImpl.find(A.class, id, lockModeType, properties);

		setTransactionActive(true);
		try {
			sessionImpl.flush();
		} finally {
			setTransactionActive(true);
		}

		sessionImpl.flushBeforeTransactionCompletion();

		Status abstractEntityEntryStatus = Status.MANAGED;
		Object[] abstractEntityLoadedState = new Object[] {};
		Object abstractEntityRowId = new Object();
		Serializable abstractEntityEntryId = new Serializable() {
			private static final long serialVersionUID = 1L;
		};
		Object abstractEntityEntryVersion = new Object();
		LockMode abstractEntityEntryLockMode = LockMode.NONE;
		boolean abstractEntityEntryExistsInDatabase = false;
		EntityMode abstractEntityEntryEntryMode = EntityMode.POJO;
		String abstractEntityIdTenantId = "abba10";
		boolean abstractEntityEntryDisableVersionIncrement = false;
		PersistenceContext persistenceContext = sessionImpl.getPersistenceContext();
		AbstractEntityEntry entityEntry = new DummyAbstractEntityEntry(abstractEntityEntryStatus,
				abstractEntityLoadedState, abstractEntityRowId, abstractEntityEntryId, abstractEntityEntryVersion,
				abstractEntityEntryLockMode, abstractEntityEntryExistsInDatabase, entityPersister,
				abstractEntityEntryEntryMode, abstractEntityIdTenantId, abstractEntityEntryDisableVersionIncrement,
				persistenceContext);

		DummyManagedEntity managedEntity = new DummyManagedEntity();
		managedEntity.$$_hibernate_setEntityEntry(entityEntry);

		sessionImpl.forceFlush(entityEntry);

		Class<?> entityClass = A.class;
		sessionImpl.get(entityClass, id);
		sessionImpl.get("entityName", id);
		LockMode lockMode = LockMode.NONE;
		sessionImpl.get(entityClass, id, lockMode);
		sessionImpl.get("entityName", id, lockMode);
		sessionImpl.get("entityName", id, lockOptions);
		sessionImpl.get(entityClass, id, lockOptions);

		sessionImpl.getActionQueue();

		Object object = new Object();
		sessionImpl.getContextEntityIdentifier(object);

		sessionImpl.getCriteriaBuilder();

		sessionImpl.getCurrentLockMode(managedEntity);

		sessionImpl.getDelegate();

		sessionImpl.getDontFlushFromFind();

		sessionImpl.getEnabledFilter("filterName");

		sessionImpl.getEntityGraph("jpaEntityName");

		sessionImpl.getEntityGraphs(entityClass);

		sessionImpl.getEntityManagerFactory();

		sessionImpl.getEntityName(managedEntity);

		sessionImpl.getEntityPersister("entityName", object);

		EntityKey key = new EntityKey(id, entityPersister);
		sessionImpl.getEntityUsingInterceptor(key);

		sessionImpl.getIdentifier(managedEntity);

		sessionImpl.getLoadQueryInfluencers();

		sessionImpl.getLobHelper();

		sessionImpl.getLockMode(managedEntity);

		sessionImpl.getLockRequest(lockModeType, properties);

		sessionImpl.getMetamodel();

		sessionImpl.getPersistenceContext();

		sessionImpl.getProperties();

		sessionImpl.getReference(entityClass, id);

		sessionImpl.getSession();

		sessionImpl.getSessionFactory();

		sessionImpl.getStatistics();

		sessionImpl.getTypeHelper();

		sessionImpl.guessEntityName(object);

		sessionImpl.immediateLoad("entityName", id);

		DummyPersistentCollection collection = new DummyPersistentCollection();
		boolean writing = false;
		// sessionImpl.initializeCollection(collection, writing);

		// sessionImpl.instantiate(entityPersister, id);
		// sessionImpl.instantiate("entityName", id);

		boolean eager = false;
		boolean nullable = false;
		// sessionImpl.internalLoad("entityName", id, eager, nullable);

		sessionImpl.isAutoCloseSessionEnabled();

		sessionImpl.isDefaultReadOnly();

		// sessionImpl.isDirty();

		sessionImpl.isEventSource();

		// sessionImpl.isFetchProfileEnabled("name");

		sessionImpl.isFlushBeforeCompletionEnabled();

		sessionImpl.isJoinedToTransaction();

		sessionImpl.isOpen();

		sessionImpl.isQueryParametersValidationEnabled();

		Object entityOrProxy = new Object();
		// sessionImpl.isReadOnly(entityOrProxy);

		// sessionImpl.iterate("query", queryParameters);

		// sessionImpl.iterateFilter(collection, "filter", queryParameters);

		// sessionImpl.joinTransaction();

		Criteria criteria = null;
		// sessionImpl.list(criteria);
		// sessionImpl.list("query", queryParameters);

		CustomQuery customQuery = null;
		// sessionImpl.listCustomQuery(customQuery, queryParameters);

		// sessionImpl.listFilter(collection, "filter", queryParameters);

		sessionImpl.load(entityClass, id);
		sessionImpl.load(object, id);
		sessionImpl.load("entityName", id);
		sessionImpl.load(entityClass, id, lockMode);
		sessionImpl.load(entityClass, id, lockOptions);
		sessionImpl.load("entityName", id, lockMode);
		sessionImpl.load("entityName", id, lockOptions);

		// sessionImpl.lock(object, lockMode);
		// sessionImpl.lock(entityOrProxy, lockModeType);
		// sessionImpl.lock(entityOrProxy, lockModeType, properties);
		// sessionImpl.lock("entityName", object, lockMode);

		@SuppressWarnings("rawtypes")
		Map copiedAlready = new HashMap<>();
		// sessionImpl.merge(object);
		// sessionImpl.merge("entityName", object);
		// sessionImpl.merge("entityName", object, copiedAlready);

		// sessionImpl.persistOnFlush(object);
		// sessionImpl.persistOnFlush("entityName", object);
		// sessionImpl.persistOnFlush("entityName", object, copiedAlready);

		Connection conn = null;
		// sessionImpl.reconnect(conn);

		// sessionImpl.refresh(object);
		// sessionImpl.refresh(object, lockMode);
		// sessionImpl.refresh(entityOrProxy, lockModeType);
		// sessionImpl.refresh(object, lockOptions);
		// sessionImpl.refresh(entityOrProxy, properties);
		// sessionImpl.refresh("entityName", object);
		// sessionImpl.refresh(entityOrProxy, lockModeType, properties);
		// sessionImpl.refresh("entityName", object, lockOptions);

		@SuppressWarnings("rawtypes")
		Map refreshedAlready = null;
		// sessionImpl.refresh("entityName", object, refreshedAlready);

		sessionImpl.remove(entityOrProxy);

		Object child = new Object();
		// sessionImpl.removeOrphanBeforeUpdates("entityName", child);

		ReplicationMode replicationMode = ReplicationMode.LATEST_VERSION;
		// sessionImpl.replicate(object, replicationMode);
		// sessionImpl.replicate("entityName", object, replicationMode);

		// sessionImpl.save(object);
		// sessionImpl.save("entityName", object);

		// sessionImpl.saveOrUpdate(object);
		// sessionImpl.saveOrUpdate("entityName", object);

		ScrollMode scrollMode = ScrollMode.FORWARD_ONLY;
		// sessionImpl.scroll(criteria, scrollMode);
		// sessionImpl.scroll(nativeQuerySpecification, queryParameters);

		// sessionImpl.scrollCustomQuery(customQuery, queryParameters);

		// sessionImpl.sessionWithOptions();

		boolean enabled = true;
		sessionImpl.setAutoClear(enabled);

		boolean defaultReadOnly = false;
		sessionImpl.setDefaultReadOnly(defaultReadOnly);

		sessionImpl.setFlushMode(initialSessionFlushMode);

		Object value = new Object();
		sessionImpl.setProperty("propertyName", value);

		boolean readOnly = true;
		// sessionImpl.setReadOnly(entityOrProxy, readOnly);

		sessionImpl.shouldAutoClose();

		sessionImpl.toString();

		Class<?> clazz = A.class;
		// sessionImpl.unwrap(clazz);

		// sessionImpl.update(object);
		// sessionImpl.update("entityName", object);

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

	@Test
	public void persist1() {

		SessionImpl sessionImpl = new SessionImpl(sessionFactoryImpl, sessionCreationOptions);

		try {
			DummyLazyInitializer lazyInitializer = new DummyLazyInitializer();
			lazyInitializer.setUninitialized(true);
			lazyInitializer.setSession(sessionImpl);

			DummyHibernateProxy hibernateProxy = new DummyHibernateProxy();
			hibernateProxy.setLazyInitializer(lazyInitializer);
			sessionImpl.persist(hibernateProxy);
		} finally {
			if (sessionImpl != null) {
				sessionImpl.close();
			}
		}
	}

	@Test()
	public void persist2() {

		SessionImpl sessionImpl = new SessionImpl(sessionFactoryImpl, sessionCreationOptions);

		try {
			DummyLazyInitializer lazyInitializer = new DummyLazyInitializer();
			lazyInitializer.setUninitialized(true);
			lazyInitializer.setSession(null);

			DummyHibernateProxy hibernateProxy = new DummyHibernateProxy();
			hibernateProxy.setLazyInitializer(lazyInitializer);
			expect(PersistenceException.class, new RunnableWhichThrow() {
				@Override
				public void run() throws Exception {
					sessionImpl.persist(hibernateProxy);
				}
			});
		} finally {
			if (sessionImpl != null) {
				sessionImpl.close();
			}
		}
	}

}

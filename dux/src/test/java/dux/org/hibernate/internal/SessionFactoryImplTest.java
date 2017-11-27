package dux.org.hibernate.internal;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Predicate;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.relational.QualifiedName;
import org.hibernate.boot.registry.StandardServiceInitiator;
import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.boot.registry.internal.BootstrapServiceRegistryImpl;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cache.spi.RegionFactory;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.batch.internal.BatchBuilderInitiator;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.engine.jdbc.spi.SqlStatementLogger;
import org.hibernate.engine.jndi.spi.JndiService;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.factory.spi.MutableIdentifierGeneratorFactory;
import org.hibernate.jmx.internal.JmxServiceInitiator;
import org.hibernate.persister.internal.PersisterClassResolverInitiator;
import org.hibernate.persister.internal.PersisterFactoryInitiator;
import org.hibernate.property.access.internal.PropertyAccessStrategyResolverInitiator;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorBuilderImpl;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder;
import org.hibernate.service.internal.ProvidedService;
import org.hibernate.service.internal.SessionFactoryServiceRegistryFactoryInitiator;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TestEvent;

import dum.java.sql.DummyConnection;
import dum.java.sql.DummyPreparedStatement;
import dum.org.hibernate.DummyInterceptor;
import dum.org.hibernate.DummySessionEventListener;
import dum.org.hibernate.boot.cfgxml.spi.DummyCfgXmlAccessService;
import dum.org.hibernate.boot.model.naming.DummyPhysicalNamingStrategy;
import dum.org.hibernate.boot.registry.selector.spi.DummyStrategySelector;
import dum.org.hibernate.cache.spi.DummyRegionFactory;
import dum.org.hibernate.engine.config.spi.DummyConfigurationService;
import dum.org.hibernate.engine.jdbc.connections.spi.DummyConnectionProvider;
import dum.org.hibernate.engine.jdbc.env.spi.DummyExtractedDatabaseMetaData;
import dum.org.hibernate.engine.jdbc.env.spi.DummyIdentifierHelper;
import dum.org.hibernate.engine.jdbc.env.spi.DummyJdbcEnvironment;
import dum.org.hibernate.engine.jdbc.env.spi.DummyQualifiedObjectNameFormatter;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.jndi.spi.DummyJndiService;
import dum.org.hibernate.engine.spi.DummyCacheImplementor;
import dum.org.hibernate.hql.spi.id.DummyMultiTableBulkIdStrategy;
import dum.org.hibernate.id.DummyIdentifierGenerator;
import dum.org.hibernate.id.factory.spi.DummyMutableIdentifierGeneratorFactory;
import dum.org.hibernate.resource.jdbc.spi.DummyStatementInspector;
import dus.hibernate.core.HibernateCoreSummaryTest;
import dux.org.hibernate.query.criteria.internal.DummyIntegratorService;

public class SessionFactoryImplTest extends AbstractTest {

	private DummyIdentifierHelper identifierHelper;
	private Dialect dialect;
	private DummyQualifiedObjectNameFormatter qualifiedObjectNameFormatter;
	private DummyJdbcEnvironment jdbcEnvironment;
	private DummyExtractedDatabaseMetaData extractedMetaDataSupport;
	private DummyJdbcServices jdbcServices;
	private DummyCfgXmlAccessService cfgXmlAccessService;
	private DummyConfigurationService configurationService;
	private DummyIntegratorService integratorService;
	private DummyRegionFactory regionFactory;
	private DummyCacheImplementor cacheImplementor;
	private DummyConnection connection;
	private DummyConnectionProvider connectionProvider;
	// private DummySynchronizationRegistry localSynchronizations;
	// private DummyTransactionDriver transactionDriverControl;
	// private DummyTransactionCoordinator transactionCoordinator;
	private PhysicalConnectionHandlingMode physicalConnectionHandlingMode;
	private JdbcResourceLocalTransactionCoordinatorBuilderImpl transactionCoordinatorBuilder;
	private DummyStrategySelector strategySelector;
	private ClassLoaderService classLoaderService;
	private DummyPhysicalNamingStrategy physicalNamingStrategy;
	private DummyMultiTableBulkIdStrategy multiTableBulkIdStrategy;
	private Long generatedId;
	private DummyIdentifierGenerator identifierGenerator;
	private DummyMutableIdentifierGeneratorFactory mutableIdentifierGeneratorFactory;
	private DummyJndiService jndiService;
	private BootstrapServiceRegistryImpl bootstrapServiceRegistryImpl;
	@SuppressWarnings("rawtypes")
	private List<StandardServiceInitiator> standardServiceInitiators;
	@SuppressWarnings("rawtypes")
	private List<ProvidedService> providedServices;
	private Map<?, ?> standardServiceRegistryConfigurationMap;
	private StandardServiceRegistryImpl standardServiceRegistryImpl;
	private MetadataSources metadataSources;
	private MetadataBuilderImpl metadataBuilderImpl;
	private MetadataImplementor metadataImplementor;
	private SessionFactoryBuilderImpl sessionFactoryBuilderImpl;
	private SessionFactory sessionFactory;
	private Set<String> nullConfigurationSettings;
	private StatementInspector statementInspector;
	private DummyInterceptor interceptor;
	private DummySessionEventListener sessionEventListener;
	private DummyPreparedStatement preparedStatement;

	@Entity
	public static class A {
		@Id
		private Long id;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

	}

	@SuppressWarnings("unchecked")
	@Before
	public void before() {
		requireAllSourcesBut(HibernateCoreSummaryTest.MVNNAME,
				"org.hibernate.jpa.event.internal.jpa.ListenerFactoryBeanManagerDelayedImpl",
				"org.hibernate.jpa.event.internal.jpa.ListenerFactoryBeanManagerExtendedImpl",
				"org.hibernate.jpa.event.internal.jpa.ListenerFactoryBeanManagerStandardImpl",
				"org.hibernate.cfg.beanvalidation.TypeSafeActivator",
				"org.hibernate.jpa.event.spi.jpa.ExtendedBeanManager", "org.hibernate.tool.enhance.EnhancementTask",
				"org.hibernate.tool.instrument.javassist.InstrumentTask",
				"org.hibernate.cfg.beanvalidation.BeanValidationEventListener",
				"org.hibernate.tool.hbm2ddl.SchemaExportTask", "org.hibernate.tool.hbm2ddl.SchemaUpdateTask",
				"org.hibernate.tool.hbm2ddl.SchemaValidatorTask", "org.hibernate.internal.CoreMessageLogger",
				"org.hibernate.internal.log.DeprecationLogger", "org.hibernate.internal.log.UrlMessageBundle",
				"org.hibernate.bytecode.enhance.internal.bytebuddy.FieldReaderAppender",
				"org.hibernate.internal.EntityManagerMessageLogger",
				"org.hibernate.internal.log.ConnectionPoolingLogger",
				"org.hibernate.bytecode.enhance.internal.bytebuddy.FieldWriterAppender",
				"org.hibernate.bytecode.enhance.internal.bytebuddy.BiDirectionalAssociationHandler",
				"org.hibernate.bytecode.enhance.internal.bytebuddy.PersistentAttributeTransformer",
				"org.hibernate.bytecode.enhance.internal.bytebuddy.FieldAccessEnhancer",
				"org.hibernate.bytecode.enhance.internal.bytebuddy.InlineDirtyCheckingHandler",
				"org.hibernate.bytecode.internal.bytebuddy.BytecodeProviderImpl",
				"org.hibernate.cfg.beanvalidation.GroupsPerOperation",
				"org.hibernate.secure.internal.StandardJaccServiceImpl",
				"org.hibernate.cfg.beanvalidation.HibernateTraversableResolver",
				"org.hibernate.internal.log.ConnectionAccessLogger",
				"org.hibernate.bytecode.enhance.internal.bytebuddy.EnhancerImpl",
				"org.hibernate.result.internal.ResultSetOutputImpl",
				"org.hibernate.engine.spi.SessionDelegatorBaseImpl");

		identifierHelper = new DummyIdentifierHelper();
		identifierHelper.setToIdentifierRWA(new RunnableWithArgs<Identifier>() {
			@Override
			public Identifier run(Object... args) {
				String text = (String) args[0];
				if (text == null) {
					return null;
				}
				return new Identifier(text, false);
			}
		});

		dialect = new Dialect() {
		};

		qualifiedObjectNameFormatter = new DummyQualifiedObjectNameFormatter();
		qualifiedObjectNameFormatter.setFormatRWA(new RunnableWithArgs<String>() {
			@Override
			public String run(Object... args) {

				String catalogText = "?";
				String schemaText = "?";
				String objectText = "?";

				QualifiedName q = (QualifiedName) args[0];
				if (q != null) {
					Identifier catalogId = q.getCatalogName();
					if (catalogId != null) {
						catalogText = catalogId.getText();
					}
					Identifier schemaId = q.getSchemaName();
					if (schemaId != null) {
						schemaText = schemaId.getText();
					}
					Identifier objectId = q.getObjectName();
					if (objectId != null) {
						objectText = objectId.getText();
					}
				}
				return catalogText + "/" + schemaText + "/" + objectText;
			}
		});

		jdbcEnvironment = new DummyJdbcEnvironment();
		jdbcEnvironment.setIdentifierHelper(identifierHelper);
		jdbcEnvironment.setDialect(dialect);
		jdbcEnvironment.setQualifiedObjectNameFormatter(qualifiedObjectNameFormatter);

		extractedMetaDataSupport = new DummyExtractedDatabaseMetaData();

		SqlStatementLogger sqlStatementLogger = new SqlStatementLogger();

		SqlExceptionHelper sqlExceptionHelper = new SqlExceptionHelper(false);

		jdbcServices = new DummyJdbcServices();
		jdbcServices.setJdbcEnvironment(jdbcEnvironment);
		jdbcServices.setExtractedMetaDataSupport(extractedMetaDataSupport);
		jdbcServices.setSqlStatementLogger(sqlStatementLogger);
		jdbcServices.setSqlExceptionHelper(sqlExceptionHelper);

		cfgXmlAccessService = new DummyCfgXmlAccessService();

		nullConfigurationSettings = new HashSet<>();

		sessionEventListener = new DummySessionEventListener();

		configurationService = new DummyConfigurationService();
		configurationService.getSettings().put("hibernate.current_session_context_class", "thread");
		configurationService.getSettings().put("hibernate.session.events.log", "true");
		configurationService.getSettings().put("hibernate.session.events.auto", "true");
		configurationService.setGetSettingRWA(new RunnableWithArgs<Object>() {
			@Override
			public Object run(Object... args) {
				String name = (String) args[0];
				Object value = configurationService.getSettings().get(name);
				if (value == null && args.length == 3) {
					value = args[2];
					if (value != null) {
						configurationService.getSettings().put(name, value);
					} else {
						nullConfigurationSettings.add(name);
					}
				}
				return value;
			}
		});

		integratorService = new DummyIntegratorService();

		regionFactory = new DummyRegionFactory();

		cacheImplementor = new DummyCacheImplementor();
		cacheImplementor.setRegionFactory(regionFactory);

		preparedStatement = new DummyPreparedStatement();
		preparedStatement.setExecuteUpdateRWA(new RunnableWithArgs<Integer>() {
			@Override
			public Integer run(Object... args) {
				return 1;
			}
		});

		connection = new DummyConnection();
		connection.setPrepareStatementRWA(new RunnableWithArgs<PreparedStatement>() {
			@Override
			public PreparedStatement run(Object... args) {
				return preparedStatement;
			}
		});

		connectionProvider = new DummyConnectionProvider();
		connectionProvider.setConnection(connection);

		// localSynchronizations = new DummySynchronizationRegistry();

		// transactionDriverControl = new DummyTransactionDriver();

		// transactionCoordinator = new DummyTransactionCoordinator();
		// transactionCoordinator.setLocalSynchronizations(localSynchronizations);
		// transactionCoordinator.setTransactionDriverControl(transactionDriverControl);

		physicalConnectionHandlingMode = PhysicalConnectionHandlingMode.IMMEDIATE_ACQUISITION_AND_HOLD;

		// transactionCoordinatorBuilder = new DummyTransactionCoordinatorBuilder();
		// transactionCoordinatorBuilder.setDefaultConnectionHandlingMode(physicalConnectionHandlingMode);
		// transactionCoordinatorBuilder.setBuildTransactionCoordinatorRWA(new
		// RunnableWithArgs<TransactionCoordinator>() {
		// @Override
		// public TransactionCoordinator run(Object... args) {
		// return transactionCoordinator;
		// }
		// });
		transactionCoordinatorBuilder = new JdbcResourceLocalTransactionCoordinatorBuilderImpl();

		strategySelector = new DummyStrategySelector();
		strategySelector.setResolveDefaultableStrategyRWA(new RunnableWithArgs<Object>() {

			@Override
			public Object run(Object... args) {
				Object def = args[2];
				if (def instanceof Callable) {
					try {
						return ((Callable<?>) def).call();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
				} else {
					return def;
				}
			}
		});

		classLoaderService = new ClassLoaderServiceImpl();

		physicalNamingStrategy = new DummyPhysicalNamingStrategy();
		physicalNamingStrategy.setToPhysicalNameRWA(new RunnableWithArgs<Identifier>() {
			@Override
			public Identifier run(Object... args) {
				return (Identifier) args[0];
			}
		});

		multiTableBulkIdStrategy = new DummyMultiTableBulkIdStrategy();

		generatedId = 1L;

		identifierGenerator = new DummyIdentifierGenerator();
		identifierGenerator.setGenerateRWA(new RunnableWithArgs<Serializable>() {
			@Override
			public Serializable run(Object... args) {
				return generatedId;
			}
		});

		mutableIdentifierGeneratorFactory = new DummyMutableIdentifierGeneratorFactory();
		mutableIdentifierGeneratorFactory.setCreateIdentifierGeneratorRWA(new RunnableWithArgs<IdentifierGenerator>() {
			@Override
			public IdentifierGenerator run(Object... args) {
				return identifierGenerator;
			}
		});

		jndiService = new DummyJndiService();

		bootstrapServiceRegistryImpl = new BootstrapServiceRegistryImpl(classLoaderService, strategySelector,
				integratorService);
		standardServiceInitiators = new ArrayList<>();
		standardServiceInitiators.add(SessionFactoryServiceRegistryFactoryInitiator.INSTANCE);
		standardServiceInitiators.add(PersisterFactoryInitiator.INSTANCE);
		standardServiceInitiators.add(PersisterClassResolverInitiator.INSTANCE);
		standardServiceInitiators.add(PropertyAccessStrategyResolverInitiator.INSTANCE);
		standardServiceInitiators.add(BatchBuilderInitiator.INSTANCE);
		standardServiceInitiators.add(JmxServiceInitiator.INSTANCE);

		providedServices = new ArrayList<>();
		providedServices.add(new ProvidedService<>(ConfigurationService.class, configurationService));
		providedServices.add(new ProvidedService<>(RegionFactory.class, regionFactory));
		providedServices.add(new ProvidedService<>(CfgXmlAccessService.class, cfgXmlAccessService));
		providedServices.add(new ProvidedService<>(JdbcServices.class, jdbcServices));
		providedServices
				.add(new ProvidedService<>(MutableIdentifierGeneratorFactory.class, mutableIdentifierGeneratorFactory));
		providedServices.add(new ProvidedService<>(JdbcEnvironment.class, jdbcEnvironment));
		providedServices.add(new ProvidedService<>(TransactionCoordinatorBuilder.class, transactionCoordinatorBuilder));
		providedServices.add(new ProvidedService<>(JndiService.class, jndiService));
		providedServices.add(new ProvidedService<>(ConnectionProvider.class, connectionProvider));

		standardServiceRegistryConfigurationMap = new HashMap<>();
		standardServiceRegistryImpl = new StandardServiceRegistryImpl(bootstrapServiceRegistryImpl,
				standardServiceInitiators, providedServices, standardServiceRegistryConfigurationMap);

		metadataSources = new MetadataSources(standardServiceRegistryImpl);
		metadataSources.addAnnotatedClass(A.class);
		metadataBuilderImpl = new MetadataBuilderImpl(metadataSources, standardServiceRegistryImpl);
		metadataBuilderImpl.applyPhysicalNamingStrategy(physicalNamingStrategy);

		metadataImplementor = metadataBuilderImpl.build();

		statementInspector = new DummyStatementInspector();

		interceptor = new DummyInterceptor();

		sessionFactoryBuilderImpl = new SessionFactoryBuilderImpl(metadataImplementor);
		sessionFactoryBuilderImpl.applyMultiTableBulkIdStrategy(multiTableBulkIdStrategy);
		sessionFactoryBuilderImpl.applyStatementInspector(statementInspector);
		sessionFactoryBuilderImpl.applyInterceptor(interceptor);

		sessionFactory = sessionFactoryBuilderImpl.build();
	}

	@Test
	public void test() {

		Session s = sessionFactory.getCurrentSession();

		Transaction t = s.getTransaction();

		t.begin();

		// transactionDriverControl.setStatus(TransactionStatus.ACTIVE);

		A a = new A();
		s.persist(a);

		t.commit();

		sessionFactory.close();

		List<TestEvent> testEvents = getAllTestEvents(this);
		dumpTestEvents(testEvents);

		testEvents.stream().filter(new Predicate<TestEvent>() {
			@Override
			public boolean test(TestEvent t) {
				return "inspect".equals(t.getName());
			}
		}).forEachOrdered(new Consumer<TestEvent>() {
			@Override
			public void accept(TestEvent t) {
				System.out.println(t.prop("sql"));
			}
		});

	}
}

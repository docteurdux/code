package dux.org.hibernate.internal;

import java.beans.BeanDescriptor;
import java.io.Serializable;
import java.lang.reflect.AnnotatedType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

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
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.jndi.spi.JndiService;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.factory.spi.MutableIdentifierGeneratorFactory;
import org.hibernate.persister.internal.PersisterClassResolverInitiator;
import org.hibernate.persister.internal.PersisterFactoryInitiator;
import org.hibernate.property.access.internal.PropertyAccessStrategyResolverInitiator;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.transaction.spi.TransactionCoordinator;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.hibernate.service.internal.ProvidedService;
import org.hibernate.service.internal.SessionFactoryServiceRegistryFactoryInitiator;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.java.sql.DummyConnection;
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
import dum.org.hibernate.resource.transaction.spi.DummySynchronizationRegistry;
import dum.org.hibernate.resource.transaction.spi.DummyTransactionCoordinator;
import dum.org.hibernate.resource.transaction.spi.DummyTransactionCoordinatorBuilder;
import dum.org.hibernate.resource.transaction.spi.TransactionCoordinator.DummyTransactionDriver;
import dus.hibernate.core.HibernateCoreSummaryTest;
import dux.org.hibernate.query.criteria.internal.DummyIntegratorService;

public class SessionFactoryImplTest extends AbstractTest {

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
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void test() {

		DummyIdentifierHelper identifierHelper = new DummyIdentifierHelper();
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

		Dialect dialect = new Dialect() {
		};

		DummyQualifiedObjectNameFormatter qualifiedObjectNameFormatter = new DummyQualifiedObjectNameFormatter();
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

		DummyJdbcEnvironment jdbcEnvironment = new DummyJdbcEnvironment();
		jdbcEnvironment.setIdentifierHelper(identifierHelper);
		jdbcEnvironment.setDialect(dialect);
		jdbcEnvironment.setQualifiedObjectNameFormatter(qualifiedObjectNameFormatter);

		DummyExtractedDatabaseMetaData extractedMetaDataSupport = new DummyExtractedDatabaseMetaData();

		DummyJdbcServices jdbcServices = new DummyJdbcServices();
		jdbcServices.setJdbcEnvironment(jdbcEnvironment);
		jdbcServices.setExtractedMetaDataSupport(extractedMetaDataSupport);

		DummyCfgXmlAccessService cfgXmlAccessService = new DummyCfgXmlAccessService();

		DummyConfigurationService configurationService = new DummyConfigurationService();
		configurationService.getSettings().put("hibernate.current_session_context_class", "thread");
		configurationService.setGetSettingRWA(new RunnableWithArgs<Object>() {
			@Override
			public Object run(Object... args) {
				return args[2];
			}
		});

		DummyIntegratorService integratorService = new DummyIntegratorService();

		DummyRegionFactory regionFactory = new DummyRegionFactory();

		DummyCacheImplementor cacheImplementor = new DummyCacheImplementor();
		cacheImplementor.setRegionFactory(regionFactory);

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

		DummyStrategySelector strategySelector = new DummyStrategySelector();
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

		ClassLoaderService classLoaderService = new ClassLoaderServiceImpl();

		DummyPhysicalNamingStrategy physicalNamingStrategy = new DummyPhysicalNamingStrategy();
		physicalNamingStrategy.setToPhysicalNameRWA(new RunnableWithArgs<Identifier>() {
			@Override
			public Identifier run(Object... args) {
				return (Identifier) args[0];
			}
		});

		DummyMultiTableBulkIdStrategy multiTableBulkIdStrategy = new DummyMultiTableBulkIdStrategy();

		Long id = 1L;

		DummyIdentifierGenerator identifierGenerator = new DummyIdentifierGenerator();
		identifierGenerator.setGenerateRWA(new RunnableWithArgs<Serializable>() {
			@Override
			public Serializable run(Object... args) {
				return id;
			}
		});

		DummyMutableIdentifierGeneratorFactory mutableIdentifierGeneratorFactory = new DummyMutableIdentifierGeneratorFactory();
		mutableIdentifierGeneratorFactory.setCreateIdentifierGeneratorRWA(new RunnableWithArgs<IdentifierGenerator>() {
			@Override
			public IdentifierGenerator run(Object... args) {
				return identifierGenerator;
			}
		});

		DummyJndiService jndiService = new DummyJndiService();

		BootstrapServiceRegistryImpl bootstrapServiceRegistry = new BootstrapServiceRegistryImpl(classLoaderService,
				strategySelector, integratorService);
		List<StandardServiceInitiator> serviceInitiators = new ArrayList<>();
		serviceInitiators.add(SessionFactoryServiceRegistryFactoryInitiator.INSTANCE);
		serviceInitiators.add(PersisterFactoryInitiator.INSTANCE);
		serviceInitiators.add(PersisterClassResolverInitiator.INSTANCE);
		serviceInitiators.add(PropertyAccessStrategyResolverInitiator.INSTANCE);

		List<ProvidedService> providedServices = new ArrayList<>();
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

		Map<?, ?> configurationValues = new HashMap<>();
		StandardServiceRegistryImpl standardServiceRegistry = new StandardServiceRegistryImpl(bootstrapServiceRegistry,
				serviceInitiators, providedServices, configurationValues);

		MetadataSources sources = new MetadataSources(standardServiceRegistry);
		sources.addAnnotatedClass(A.class);
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

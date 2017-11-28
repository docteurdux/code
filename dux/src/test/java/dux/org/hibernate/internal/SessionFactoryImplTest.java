package dux.org.hibernate.internal;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.cfgxml.internal.CfgXmlAccessServiceInitiator;
import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.boot.registry.StandardServiceInitiator;
import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.boot.registry.internal.BootstrapServiceRegistryImpl;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.boot.registry.selector.internal.StrategySelectorImpl;
import org.hibernate.boot.registry.selector.spi.StrategySelector;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cache.internal.RegionFactoryInitiator;
import org.hibernate.cache.spi.RegionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.config.internal.ConfigurationServiceImpl;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.batch.internal.BatchBuilderInitiator;
import org.hibernate.engine.jdbc.batch.spi.BatchBuilder;
import org.hibernate.engine.jdbc.connections.internal.ConnectionProviderInitiator;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.engine.jdbc.cursor.spi.RefCursorSupport;
import org.hibernate.engine.jdbc.dialect.internal.DialectFactoryInitiator;
import org.hibernate.engine.jdbc.dialect.internal.DialectResolverInitiator;
import org.hibernate.engine.jdbc.dialect.spi.DialectFactory;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolver;
import org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.internal.JdbcServicesInitiator;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.jndi.internal.JndiServiceInitiator;
import org.hibernate.engine.jndi.spi.JndiService;
import org.hibernate.engine.query.spi.NativeQueryInterpreter;
import org.hibernate.engine.spi.CacheImplementor;
import org.hibernate.engine.transaction.jta.platform.spi.JtaPlatform;
import org.hibernate.engine.transaction.jta.platform.spi.JtaPlatformResolver;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.hql.spi.QueryTranslatorFactory;
import org.hibernate.id.factory.internal.MutableIdentifierGeneratorFactoryInitiator;
import org.hibernate.id.factory.spi.MutableIdentifierGeneratorFactory;
import org.hibernate.integrator.internal.IntegratorServiceImpl;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.integrator.spi.IntegratorService;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.jmx.internal.JmxServiceInitiator;
import org.hibernate.jmx.spi.JmxService;
import org.hibernate.persister.internal.PersisterClassResolverInitiator;
import org.hibernate.persister.internal.PersisterFactoryInitiator;
import org.hibernate.persister.spi.PersisterClassResolver;
import org.hibernate.persister.spi.PersisterFactory;
import org.hibernate.property.access.internal.PropertyAccessStrategyResolverInitiator;
import org.hibernate.property.access.spi.PropertyAccessStrategyResolver;
import org.hibernate.resource.transaction.internal.TransactionCoordinatorBuilderInitiator;
import org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder;
import org.hibernate.secure.spi.JaccService;
import org.hibernate.service.Service;
import org.hibernate.service.internal.AbstractServiceRegistryImpl;
import org.hibernate.service.internal.ProvidedService;
import org.hibernate.service.internal.SessionFactoryServiceRegistryFactoryInitiator;
import org.hibernate.service.spi.ServiceBinding;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.hibernate.service.spi.SessionFactoryServiceRegistryFactory;
import org.hibernate.stat.spi.StatisticsImplementor;
import org.hibernate.tool.hbm2ddl.ImportSqlCommandExtractor;
import org.hibernate.tool.hbm2ddl.ImportSqlCommandExtractorInitiator;
import org.hibernate.tool.schema.internal.SchemaManagementToolInitiator;
import org.hibernate.tool.schema.spi.SchemaManagementTool;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.TestEvent;

import dus.hibernate.core.HibernateCoreSummaryTest;

public class SessionFactoryImplTest extends AbstractTest {

	private ConfigurationServiceImpl configurationService;
	private IntegratorServiceImpl integratorService;
	private StrategySelectorImpl strategySelector;
	private ClassLoaderService classLoaderService;
	private PhysicalNamingStrategyStandardImpl physicalNamingStrategy;
	private BootstrapServiceRegistryImpl bootstrapServiceRegistryImpl;
	@SuppressWarnings("rawtypes")
	private List<StandardServiceInitiator> standardServiceInitiators;
	@SuppressWarnings("rawtypes")
	private List<ProvidedService> providedServices;
	private Map<Object, Object> standardServiceRegistryConfigurationMap;
	private StandardServiceRegistryImpl standardServiceRegistryImpl;
	private MetadataSources metadataSources;
	private MetadataBuilderImpl metadataBuilderImpl;
	private MetadataImplementor metadataImplementor;
	private SessionFactoryBuilderImpl sessionFactoryBuilderImpl;
	private SessionFactory sessionFactory;
	private Map<Object, Object> initialConfigurationSettings;
	private Set<Class<?>> proxiedResults;

	@Entity
	@Table(name = "A")
	public static class A {

		@Id
		private Long id;

		private String name;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	@Before
	public void before() throws Exception {
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

		resetRequireAllSources();

		requireAllSourcesBut("mysql-connector-java-6.0.6", "com.mysql.cj.x.protobuf.Mysqlx",
				"com.mysql.cj.x.io.XProtocol", "com.mysql.cj.api.x.io.MessageConstants",
				"com.mysql.cj.api.x.io.MessageReader", "com.mysql.cj.api.x.io.MessageWriter",
				"com.mysql.cj.x.core.XDevAPIError", "com.mysql.cj.x.io.AsyncMessageReader",
				"com.mysql.cj.x.io.AsyncMessageWriter", "com.mysql.cj.x.io.ResultMessageListener",
				"com.mysql.cj.api.x.io.MessageListener", "com.mysql.cj.x.io.SqlResultMessageListener",
				"com.mysql.cj.x.io.StatementExecuteOkMessageListener", "com.mysql.cj.x.io.SyncMessageReader",
				"com.mysql.cj.x.protobuf.MysqlxConnection", "com.mysql.cj.x.protobuf.MysqlxCrud",
				"com.mysql.cj.x.protobuf.MysqlxDatatypes", "com.mysql.cj.x.protobuf.MysqlxExpect",
				"com.mysql.cj.x.protobuf.MysqlxExpr", "com.mysql.cj.x.protobuf.MysqlxNotice",
				"com.mysql.cj.x.protobuf.MysqlxResultset", "com.mysql.cj.x.protobuf.MysqlxSession",
				"com.mysql.cj.x.protobuf.MysqlxSql", "com.mysql.cj.x.io.SyncMessageWriter",
				"com.mysql.cj.xdevapi.ExprUtil", "com.mysql.cj.x.io.MessageBuilder", "com.mysql.cj.x.io.XProtocolRow",
				"com.mysql.cj.jdbc.integration.c3p0.MysqlConnectionTester", "com.mysql.cj.api.x.io.DecoderFunction",
				"com.mysql.cj.x.io.XProtocolDecoder",
				"com.mysql.cj.jdbc.integration.jboss.ExtendedMysqlExceptionSorter",
				"com.mysql.cj.x.io.StatementExecuteOkBuilder", "com.mysql.cj.x.io.XProtocolDecoder",
				"com.mysql.cj.xdevapi.UpdateSpec", "com.mysql.cj.jdbc.integration.jboss.MysqlValidConnectionChecker",
				"com.mysql.cj.xdevapi.ExprUnparser");

		initialConfigurationSettings = new HashMap<>();
		initialConfigurationSettings.put("hibernate.current_session_context_class", "thread");
		initialConfigurationSettings.put("hibernate.session.events.log", "true");
		// initialConfigurationSettings.put("hibernate.session.events.auto", "true");
		initialConfigurationSettings.put(AvailableSettings.IMPLICIT_NAMING_STRATEGY,
				"org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl");
		initialConfigurationSettings.put(AvailableSettings.HBM2DDL_AUTO, "create");
		configurationService = new ConfigurationServiceImpl(initialConfigurationSettings);

		classLoaderService = new ClassLoaderServiceImpl();

		LinkedHashSet<Integrator> providedIntegrators = new LinkedHashSet<>();
		integratorService = new IntegratorServiceImpl(providedIntegrators, classLoaderService);

		strategySelector = new StrategySelectorImpl(classLoaderService);

		physicalNamingStrategy = new PhysicalNamingStrategyStandardImpl();

		bootstrapServiceRegistryImpl = new BootstrapServiceRegistryImpl(classLoaderService, strategySelector,
				integratorService);
		standardServiceInitiators = new ArrayList<>();
		standardServiceInitiators.add(SessionFactoryServiceRegistryFactoryInitiator.INSTANCE);
		standardServiceInitiators.add(PersisterFactoryInitiator.INSTANCE);
		standardServiceInitiators.add(PersisterClassResolverInitiator.INSTANCE);
		standardServiceInitiators.add(PropertyAccessStrategyResolverInitiator.INSTANCE);
		standardServiceInitiators.add(BatchBuilderInitiator.INSTANCE);
		standardServiceInitiators.add(JmxServiceInitiator.INSTANCE);
		standardServiceInitiators.add(ConnectionProviderInitiator.INSTANCE);
		standardServiceInitiators.add(JdbcEnvironmentInitiator.INSTANCE);
		standardServiceInitiators.add(JdbcServicesInitiator.INSTANCE);
		standardServiceInitiators.add(CfgXmlAccessServiceInitiator.INSTANCE);
		standardServiceInitiators.add(RegionFactoryInitiator.INSTANCE);
		standardServiceInitiators.add(MutableIdentifierGeneratorFactoryInitiator.INSTANCE);
		standardServiceInitiators.add(JndiServiceInitiator.INSTANCE);
		standardServiceInitiators.add(TransactionCoordinatorBuilderInitiator.INSTANCE);
		standardServiceInitiators.add(DialectFactoryInitiator.INSTANCE);
		standardServiceInitiators.add(DialectResolverInitiator.INSTANCE);
		standardServiceInitiators.add(SchemaManagementToolInitiator.INSTANCE);
		standardServiceInitiators.add(ImportSqlCommandExtractorInitiator.INSTANCE);

		providedServices = new ArrayList<>();
		providedServices.add(new ProvidedService<>(ConfigurationService.class, configurationService));

		standardServiceRegistryConfigurationMap = new HashMap<>();
		standardServiceRegistryConfigurationMap.put(AvailableSettings.URL, "jdbc:mysql://localhost:3306/dummydb");
		standardServiceRegistryConfigurationMap.put(AvailableSettings.DRIVER, "com.mysql.jdbc.Driver");
		standardServiceRegistryConfigurationMap.put(AvailableSettings.PASS, "user");
		standardServiceRegistryConfigurationMap.put(AvailableSettings.USER, "user");
		standardServiceRegistryConfigurationMap.put(AvailableSettings.CONNECTION_PREFIX + ".serverTimezone", "UTC");
		standardServiceRegistryConfigurationMap.put(AvailableSettings.DIALECT, "org.hibernate.dialect.MySQL57Dialect");

		standardServiceRegistryImpl = new StandardServiceRegistryImpl(bootstrapServiceRegistryImpl,
				standardServiceInitiators, providedServices, standardServiceRegistryConfigurationMap);

		metadataSources = new MetadataSources(standardServiceRegistryImpl);
		metadataSources.addAnnotatedClass(A.class);
		metadataBuilderImpl = new MetadataBuilderImpl(metadataSources, standardServiceRegistryImpl);
		metadataBuilderImpl.applyPhysicalNamingStrategy(physicalNamingStrategy);

		metadataImplementor = metadataBuilderImpl.build();

		sessionFactoryBuilderImpl = new SessionFactoryBuilderImpl(metadataImplementor);

		sessionFactory = sessionFactoryBuilderImpl.build();

		proxiedResults = new HashSet<>();
		proxiedResults.add(ConnectionProvider.class);
		proxiedResults.add(Connection.class);
		proxiedResults.add(PreparedStatement.class);

		ServiceRegistryImplementor sr = ((SessionFactoryImpl) sessionFactory).getServiceRegistry();

		@SuppressWarnings("unchecked")
		ConcurrentMap<Class<?>, Service> initializedServiceByRole = (ConcurrentMap<Class<?>, Service>) getField(sr,
				"initializedServiceByRole", AbstractServiceRegistryImpl.class);

		Set<Class<?>> ks = new HashSet<>();
		ks.addAll(initializedServiceByRole.keySet());
		for (Class<?> clazz : ks) {
			Service previous = initializedServiceByRole.get(clazz);
			Object proxied = proxy(previous);
			initializedServiceByRole.put(clazz, (Service) proxied);
		}

		@SuppressWarnings("unchecked")
		ConcurrentMap<Class<?>, ServiceBinding> serviceBindingMap = (ConcurrentMap<Class<?>, ServiceBinding>) getField(
				sr, "serviceBindingMap", AbstractServiceRegistryImpl.class);

		Field serviceField = ServiceBinding.class.getDeclaredField("service");
		serviceField.setAccessible(true);

		for (Class<?> clazz : new Class<?>[] { BatchBuilder.class, CacheImplementor.class, CfgXmlAccessService.class,
				ClassLoaderService.class, ConfigurationService.class, ConnectionProvider.class, DialectFactory.class,
				DialectResolver.class, EventListenerRegistry.class, ImportSqlCommandExtractor.class,
				IntegratorService.class, JaccService.class, JdbcEnvironment.class, JdbcServices.class, JmxService.class,
				JndiService.class, JtaPlatform.class, JtaPlatformResolver.class, MultiTenantConnectionProvider.class,
				MutableIdentifierGeneratorFactory.class, NativeQueryInterpreter.class, PersisterClassResolver.class,
				PersisterFactory.class, PropertyAccessStrategyResolver.class, QueryTranslatorFactory.class,
				RefCursorSupport.class, RegionFactory.class, SchemaManagementTool.class,
				SessionFactoryServiceRegistryFactory.class, StatisticsImplementor.class, StrategySelector.class,
				TransactionCoordinatorBuilder.class

		}) {
			ServiceBinding binding = (ServiceBinding) this.invoke(sr, "locateServiceBinding",
					AbstractServiceRegistryImpl.class, new Class<?>[] { Class.class }, clazz);
			if (binding != null) {
				Service service = binding.getService();
				if (service != null) {
					Service proxy = (Service) proxy(service);
					serviceField.set(binding, proxy);
				}
			}
		}

	}

	private Object proxy(Object o) {
		return Proxy.newProxyInstance(this.getClass().getClassLoader(), o.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println(o.getClass().getName() + " : " + method.getName());
						Object result = method.invoke(o, args);
						if (result != null) {
							for (Class<?> clazz : proxiedResults) {
								if (clazz.isAssignableFrom(result.getClass())) {
									if (!Proxy.isProxyClass(result.getClass())) {
										result = proxy(result);
									}
									break;
								}
							}
						}
						return result;
					}
				});
	}

	@Test
	public void test() throws Exception {

		Session s = sessionFactory.getCurrentSession();

		Transaction t = s.getTransaction();

		t.begin();

		A a = new A();
		a.setId(1L);
		a.setName("name");
		s.persist(a);

		t.commit();

		sessionFactory.close();

		List<TestEvent> testEvents = getAllTestEvents(this);
		dumpTestEvents(testEvents);

	}
}

package dux.org.hibernate.internal;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.cfgxml.internal.CfgXmlAccessServiceInitiator;
import org.hibernate.boot.internal.MetadataBuilderImpl;
import org.hibernate.boot.internal.SessionFactoryBuilderImpl;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.boot.registry.StandardServiceInitiator;
import org.hibernate.boot.registry.classloading.internal.ClassLoaderServiceImpl;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.boot.registry.internal.BootstrapServiceRegistryImpl;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.boot.registry.selector.internal.StrategySelectorImpl;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cache.internal.RegionFactoryInitiator;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.engine.config.internal.ConfigurationServiceImpl;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.batch.internal.BatchBuilderInitiator;
import org.hibernate.engine.jdbc.connections.internal.ConnectionProviderInitiator;
import org.hibernate.engine.jdbc.dialect.internal.DialectFactoryInitiator;
import org.hibernate.engine.jdbc.dialect.internal.DialectResolverInitiator;
import org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator;
import org.hibernate.engine.jdbc.internal.JdbcServicesInitiator;
import org.hibernate.engine.jndi.internal.JndiServiceInitiator;
import org.hibernate.id.factory.internal.MutableIdentifierGeneratorFactoryInitiator;
import org.hibernate.integrator.internal.IntegratorServiceImpl;
import org.hibernate.integrator.spi.Integrator;
import org.hibernate.jmx.internal.JmxServiceInitiator;
import org.hibernate.persister.internal.PersisterClassResolverInitiator;
import org.hibernate.persister.internal.PersisterFactoryInitiator;
import org.hibernate.property.access.internal.PropertyAccessStrategyResolverInitiator;
import org.hibernate.resource.transaction.internal.TransactionCoordinatorBuilderInitiator;
import org.hibernate.service.Service;
import org.hibernate.service.internal.ProvidedService;
import org.hibernate.service.internal.SessionFactoryServiceRegistryFactoryInitiator;
import org.hibernate.tool.hbm2ddl.ImportSqlCommandExtractorInitiator;
import org.hibernate.tool.schema.internal.SchemaManagementToolInitiator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import com.github.docteurdux.test.AbstractTest;

import dus.hibernate.core.HibernateCoreSummaryTest;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Loader;
import javassist.NotFoundException;
import javassist.Translator;

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
	private Map<Integer, List<WeakReference<Object>>> proxies;

	private Set<Class<?>> collectedClasses = Collections.newSetFromMap(new WeakHashMap<Class<?>, Boolean>());
	private Class<?>[] targets = new Class<?>[] { Session.class, Transaction.class, Service.class };

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

		/*
		ClassPool pool = ClassPool.getDefault();
		Loader cl = new Loader(pool);
		cl.addTranslator(pool, new Translator() {
			@Override
			public void start(ClassPool pool) throws NotFoundException, CannotCompileException {
			}

			@Override
			public void onLoad(ClassPool pool, String classname) throws NotFoundException, CannotCompileException {
				CtClass ct = pool.get("dux.org.hibernate.internal.SessionFactoryImplTest$A");
				for (CtMethod method : ct.getDeclaredMethods()) {
					method.insertBefore("System.out.println(\"" + method.getName() + "\");");
				}
			}
		});

		Class<?> aClass = cl.loadClass("dux.org.hibernate.internal.SessionFactoryImplTest$A");
		Object o = aClass.newInstance();
		o.getClass().getMethod("getName").invoke(o);
		*/

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
				"com.mysql.cj.xdevapi.ExprUnparser", "com.mysql.cj.api.x.io.ColToFieldTransformer",
				"com.mysql.cj.x.core.CoreWarning", "com.mysql.cj.xdevapi.DocFindParams",
				"com.mysql.cj.xdevapi.ExprParser", "com.mysql.cj.xdevapi.FilterParams",
				"com.mysql.cj.xdevapi.FilterParams", "com.mysql.cj.xdevapi.FindParams",
				"com.mysql.cj.xdevapi.InsertParams", "com.mysql.cj.xdevapi.SqlStatementImpl",
				"com.mysql.cj.xdevapi.TableFindParams", "com.mysql.cj.xdevapi.UpdateParams");

		proxies = new HashMap<>();

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

		proxyFields(sessionFactory);
		sessionFactory = (SessionFactory) proxy(sessionFactory);

	}

	@After
	public void after() throws Exception {

		List<Class<?>> sorted = sortClassesByName(collectedClasses);
		for (Class<?> clazz : sorted) {
			if (clazz != null && clazz.isInterface()) {
				System.out.println(clazz.getName());
			}
		}
	}

	private Object proxy(Object o) {
		if (o == null) {
			return null;
		}

		int h = System.identityHashCode(o);
		if (!proxies.containsKey(h)) {
			proxies.put(h, new ArrayList<>());
		}
		for (WeakReference<Object> wr : proxies.get(h)) {
			if (wr.get() == o) {
				return o;
			}
		}

		Object proxy = Proxy.newProxyInstance(this.getClass().getClassLoader(), o.getClass().getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println(o.getClass().getName() + " : " + method.getName());
						if ("getDialect".equals(method.getName())) {
							f();
						}
						Object result = method.invoke(o, args);
						if (result == null) {
							return result;
						}
						if (isProxied(result)) {
							return result;
						}
						for (Class<?> target : targets) {
							if (target.isAssignableFrom(result.getClass())) {
								proxyFields(result);
								return proxy(result);
							}
						}

						Set<Class<?>> inheritance = collectInheritance(result);
						for (Class<?> clazz : inheritance) {
							collectedClasses.add(clazz);
						}
						return result;
					}

				});
		proxies.get(h).add(new WeakReference<Object>(proxy));
		return proxy;
	}

	private void proxyFields(Object result) {
		Set<Class<?>> inh = this.collectInheritance(result);
		for (Class<?> clazz : inh) {
			for (Field f : clazz.getDeclaredFields()) {
				boolean proxied = false;
				try {
					f.setAccessible(true);
					Object v = f.get(result);
					if (v != null) {
						for (Class<?> target : targets) {
							if (target == null) {
								continue;
							}
							if (target.isAssignableFrom(v.getClass())) {
								if (!isProxied(v)) {
									Object proxyf = proxy(v);
									f.set(result, proxyf);
									proxied = true;
									break;
								}
							}
						}
						if (!proxied) {
							collectedClasses.addAll(collectInheritance(v));
						}
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	private boolean isProxied(Object o) {
		if (o == null) {
			return false;
		}
		int h = System.identityHashCode(o);

		if (!proxies.containsKey(h)) {
			return false;
		}
		for (WeakReference<Object> wr : proxies.get(h)) {
			if (wr.get() == o) {
				return true;
			}
		}
		return false;
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

	}
}

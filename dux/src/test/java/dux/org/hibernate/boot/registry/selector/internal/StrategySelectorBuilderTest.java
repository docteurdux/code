package dux.org.hibernate.boot.registry.selector.internal;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.hibernate.boot.registry.selector.internal.StrategySelectorBuilder;
import org.hibernate.boot.registry.selector.internal.StrategySelectorImpl;
import org.hibernate.boot.registry.selector.spi.StrategySelector;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.boot.registry.classloading.spi.DummyClassLoaderService;

public class StrategySelectorBuilderTest extends AbstractTest {

	private static class Builder {

		Map<String, Map<String, String>> categories = new HashMap<>();
		Map<String, String> temporaryMap = new HashMap<>();
		private String categoryName;

		public Builder setCategoryName(String categoryName) {
			this.categoryName = categoryName;
			return this;
		}

		public Builder register(String name, String className) {
			temporaryMap.put(name, className);
			return this;
		}

		public Builder next() {
			categories.put(categoryName, temporaryMap);
			temporaryMap = new HashMap<>();
			return this;
		}

		public Object get(String strategyClassName, String name) {
			return categories.get(strategyClassName).get(name);
		}

		public Map<String, String> get(String strategyClassName) {
			return categories.get(strategyClassName);
		}

		public Map<String, Map<String, String>> get() {
			return categories;
		}

	}

	@Test
	public void test1()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		DummyClassLoaderService classLoaderService = new DummyClassLoaderService();
		// StrategyRegistration<Object> strategyRegistration = new
		// DummyStrategyRegistration<Object>();

		StrategySelectorBuilder builder = new StrategySelectorBuilder();
		StrategySelector selector = builder.buildSelector(classLoaderService);

		Field field = StrategySelectorImpl.class.getDeclaredField("namedStrategyImplementorByStrategyMap");
		field.setAccessible(true);
		@SuppressWarnings("unchecked")
		ConcurrentHashMap<Class<?>, Map<String, Class<?>>> map = (ConcurrentHashMap<Class<?>, Map<String, Class<?>>>) field
				.get(selector);

		Builder b = new Builder();
		b.setCategoryName("org.hibernate.boot.model.naming.ImplicitNamingStrategy")
				.register("legacy-hbm", "org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyHbmImpl")
				.register("default", "org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl")
				.register("legacy-jpa", "org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl")
				.register("jpa", "org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl")
				.register("component-path", "org.hibernate.boot.model.naming.ImplicitNamingStrategyComponentPathImpl")
				.next();

		b.setCategoryName("org.hibernate.cache.spi.CacheKeysFactory")
				.register("default", "org.hibernate.cache.internal.DefaultCacheKeysFactory")
				.register("simple", "org.hibernate.cache.internal.SimpleCacheKeysFactory").next();

		b.setCategoryName("org.hibernate.resource.transaction.spi.TransactionCoordinatorBuilder")
				.register("jta",
						"org.hibernate.resource.transaction.backend.jta.internal.JtaTransactionCoordinatorBuilderImpl")
				.register("jdbc",
						"org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorBuilderImpl")

				.register("org.hibernate.transaction.CMTTransactionFactory",
						"org.hibernate.resource.transaction.backend.jta.internal.JtaTransactionCoordinatorBuilderImpl")
				.register("org.hibernate.transaction.JTATransactionFactory",
						"org.hibernate.resource.transaction.backend.jta.internal.JtaTransactionCoordinatorBuilderImpl")
				.register("org.hibernate.transaction.JDBCTransactionFactory",
						"org.hibernate.resource.transaction.backend.jdbc.internal.JdbcResourceLocalTransactionCoordinatorBuilderImpl")
				.next();

		b.setCategoryName("org.hibernate.event.spi.EntityCopyObserver")
				.register("allow", "org.hibernate.event.internal.EntityCopyAllowedObserver")
				.register("disallow", "org.hibernate.event.internal.EntityCopyNotAllowedObserver")
				.register("log", "org.hibernate.event.internal.EntityCopyAllowedLoggedObserver").next();

		b.setCategoryName("org.hibernate.hql.spi.id.MultiTableBulkIdStrategy")
				.register("global_temporary", "org.hibernate.hql.spi.id.global.GlobalTemporaryTableBulkIdStrategy")
				.register("persistent", "org.hibernate.hql.spi.id.persistent.PersistentTableBulkIdStrategy")
				.register("local_temporary", "org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy").next();

		b.setCategoryName("org.hibernate.engine.transaction.jta.platform.spi.JtaPlatform")

				.register("JOnAS", "org.hibernate.engine.transaction.jta.platform.internal.JOnASJtaPlatform")
				.register("JRun4", "org.hibernate.engine.transaction.jta.platform.internal.JRun4JtaPlatform")
				.register("OC4J", "org.hibernate.engine.transaction.jta.platform.internal.OC4JJtaPlatform")
				.register("Resin", "org.hibernate.engine.transaction.jta.platform.internal.ResinJtaPlatform")
				.register("Weblogic", "org.hibernate.engine.transaction.jta.platform.internal.WeblogicJtaPlatform")
				.register("WebSphereExtended",
						"org.hibernate.engine.transaction.jta.platform.internal.WebSphereExtendedJtaPlatform")
				.register("WebSphere", "org.hibernate.engine.transaction.jta.platform.internal.WebSphereJtaPlatform")
				.register("Bitronix", "org.hibernate.engine.transaction.jta.platform.internal.BitronixJtaPlatform")
				.register("JOTM", "org.hibernate.engine.transaction.jta.platform.internal.JOTMJtaPlatform")
				.register("SapNetWeaver",
						"org.hibernate.engine.transaction.jta.platform.internal.SapNetWeaverJtaPlatform")
				.register("SunOne", "org.hibernate.engine.transaction.jta.platform.internal.SunOneJtaPlatform")
				.register("JBossTS",
						"org.hibernate.engine.transaction.jta.platform.internal.JBossStandAloneJtaPlatform")
				.register("Orion", "org.hibernate.engine.transaction.jta.platform.internal.OrionJtaPlatform")
				.register("Borland",
						"org.hibernate.engine.transaction.jta.platform.internal.BorlandEnterpriseServerJtaPlatform")
				.register("JBossAS", "org.hibernate.engine.transaction.jta.platform.internal.JBossAppServerJtaPlatform")

				.register("org.hibernate.service.jta.platform.internal.WebSphereExtendedJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.WebSphereExtendedJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.JBossAppServerJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.JBossAppServerJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.OC4JJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.OC4JJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.SapNetWeaverJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.SapNetWeaverJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.OrionJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.OrionJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.BorlandEnterpriseServerJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.BorlandEnterpriseServerJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.ResinJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.ResinJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.JOTMJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.JOTMJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.BitronixJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.BitronixJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.WeblogicJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.WeblogicJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.WebSphereJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.WebSphereJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.JOnASJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.JOnASJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.JRun4JtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.JRun4JtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.JBossStandAloneJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.JBossStandAloneJtaPlatform")
				.register("org.hibernate.service.jta.platform.internal.SunOneJtaPlatform",
						"org.hibernate.engine.transaction.jta.platform.internal.SunOneJtaPlatform")
				.next();

		b.setCategoryName("org.hibernate.dialect.Dialect")

				.register("Oracle9i", "org.hibernate.dialect.Oracle9iDialect")
				.register("TimesTen", "org.hibernate.dialect.TimesTenDialect")
				.register("MySQL5InnoDB", "org.hibernate.dialect.MySQL5InnoDBDialect")
				.register("DB2400", "org.hibernate.dialect.DB2400Dialect")
				.register("HSQL", "org.hibernate.dialect.HSQLDialect")
				.register("DerbyTenSeven", "org.hibernate.dialect.DerbyTenSevenDialect")
				.register("Firebird", "org.hibernate.dialect.FirebirdDialect")
				.register("Ingres", "org.hibernate.dialect.IngresDialect")
				.register("PostgreSQL81", "org.hibernate.dialect.PostgreSQL81Dialect")
				.register("HANAColumnStore", "org.hibernate.dialect.HANAColumnStoreDialect")
				.register("PostgreSQL82", "org.hibernate.dialect.PostgreSQL82Dialect")
				.register("PostgreSQL9", "org.hibernate.dialect.PostgreSQL9Dialect")
				.register("DerbyTenFive", "org.hibernate.dialect.DerbyTenFiveDialect")
				.register("DB2390", "org.hibernate.dialect.DB2390Dialect")
				.register("SQLServer2005", "org.hibernate.dialect.SQLServer2005Dialect")
				.register("SQLServer2008", "org.hibernate.dialect.SQLServer2008Dialect")
				.register("Cache71", "org.hibernate.dialect.Cache71Dialect")
				.register("DB2390V8", "org.hibernate.dialect.DB2390V8Dialect")
				.register("Oracle8i", "org.hibernate.dialect.Oracle8iDialect")
				.register("Ingres10", "org.hibernate.dialect.Ingres10Dialect")
				.register("SybaseASE15", "org.hibernate.dialect.SybaseASE15Dialect")
				.register("Progress", "org.hibernate.dialect.ProgressDialect")
				.register("SybaseASE157", "org.hibernate.dialect.SybaseASE157Dialect")
				.register("Mckoi", "org.hibernate.dialect.MckoiDialect")
				.register("HANARowStore", "org.hibernate.dialect.HANARowStoreDialect")
				.register("MySQL5", "org.hibernate.dialect.MySQL5Dialect")
				.register("Ingres9", "org.hibernate.dialect.Ingres9Dialect")
				.register("Interbase", "org.hibernate.dialect.InterbaseDialect")
				.register("H2", "org.hibernate.dialect.H2Dialect")
				.register("Sybase11", "org.hibernate.dialect.Sybase11Dialect")
				.register("Teradata", "org.hibernate.dialect.TeradataDialect")
				.register("SAPDB", "org.hibernate.dialect.SAPDBDialect")
				.register("PostgresPlus", "org.hibernate.dialect.PostgresPlusDialect")
				.register("MySQL57InnoDB", "org.hibernate.dialect.MySQL57InnoDBDialect")
				.register("DB2", "org.hibernate.dialect.DB2Dialect")
				.register("MySQL57", "org.hibernate.dialect.MySQL57Dialect")
				.register("JDataStore", "org.hibernate.dialect.JDataStoreDialect")
				.register("Pointbase", "org.hibernate.dialect.PointbaseDialect")
				.register("Informix", "org.hibernate.dialect.InformixDialect")
				.register("Oracle10g", "org.hibernate.dialect.Oracle10gDialect")
				.register("CUBRID", "org.hibernate.dialect.CUBRIDDialect")
				.register("DerbyTenSix", "org.hibernate.dialect.DerbyTenSixDialect")
				.register("FrontBase", "org.hibernate.dialect.FrontBaseDialect")
				.register("MimerSQL", "org.hibernate.dialect.MimerSQLDialect")
				.register("SybaseAnywhere", "org.hibernate.dialect.SybaseAnywhereDialect")
				.register("SQLServer", "org.hibernate.dialect.SQLServerDialect").next();

		check(map, b);

	}

	private void check(ConcurrentHashMap<Class<?>, Map<String, Class<?>>> map, Builder b) {

		aeq(b.get().size(), map.size());

		for (Entry<Class<?>, Map<String, Class<?>>> e1 : map.entrySet()) {

			String strategyClassName = e1.getKey().getName();

			aeq(b.get(strategyClassName).size(), e1.getValue().size());

			for (Entry<String, Class<?>> e2 : e1.getValue().entrySet()) {
				String name = e2.getKey();
				String implementationClassName = e2.getValue().getName();
				aeq(b.get(strategyClassName, name), implementationClassName);
			}
		}
	}

	@SuppressWarnings("unused")
	private void generateData(ConcurrentHashMap<Class<?>, Map<String, Class<?>>> map) {
		System.out.println("Builder b = new Builder();b");
		for (Entry<Class<?>, Map<String, Class<?>>> entry : map.entrySet()) {
			System.out.println(".s(\"" + entry.getKey().getName() + "\")");
			for (Entry<String, Class<?>> entry2 : entry.getValue().entrySet()) {
				System.out.println(".s(\"" + entry2.getKey() + "\",\"" + entry2.getValue().getName() + "\")");
			}
			System.out.println(".n()");
		}
		System.out.println(";");
	}
}

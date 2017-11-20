package dum.org.hibernate.boot;

import java.util.Map;

import org.hibernate.ConnectionReleaseMode;
import org.hibernate.CustomEntityDirtinessStrategy;
import org.hibernate.EntityMode;
import org.hibernate.EntityNameResolver;
import org.hibernate.Interceptor;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.NullPrecedence;
import org.hibernate.SessionFactory;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.TempTableDdlTransactionHandling;
import org.hibernate.cache.spi.QueryCacheFactory;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.hql.spi.id.MultiTableBulkIdStrategy;
import org.hibernate.loader.BatchFetchStyle;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.hibernate.tuple.entity.EntityTuplizer;
import org.hibernate.tuple.entity.EntityTuplizerFactory;

public class DummySessionFactoryBuilder implements SessionFactoryBuilder {

	@Override
	public SessionFactoryBuilder applyValidatorFactory(Object validatorFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyBeanManager(Object beanManager) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyName(String sessionFactoryName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyNameAsJndiName(boolean isJndiName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyAutoClosing(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyAutoFlushing(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyStatisticsSupport(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyInterceptor(Interceptor interceptor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyStatelessInterceptor(Class<? extends Interceptor> statelessInterceptorClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyStatementInspector(StatementInspector statementInspector) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder addSessionFactoryObservers(SessionFactoryObserver... observers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyCustomEntityDirtinessStrategy(CustomEntityDirtinessStrategy strategy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder addEntityNameResolver(EntityNameResolver... entityNameResolvers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyEntityNotFoundDelegate(EntityNotFoundDelegate entityNotFoundDelegate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyIdentifierRollbackSupport(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyDefaultEntityMode(EntityMode entityMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyNullabilityChecking(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyLazyInitializationOutsideTransaction(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyEntityTuplizerFactory(EntityTuplizerFactory entityTuplizerFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyEntityTuplizer(EntityMode entityMode,
			Class<? extends EntityTuplizer> tuplizerClass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyMultiTableBulkIdStrategy(MultiTableBulkIdStrategy strategy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyTempTableDdlTransactionHandling(TempTableDdlTransactionHandling handling) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyBatchFetchStyle(BatchFetchStyle style) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyDefaultBatchFetchSize(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyMaximumFetchDepth(int depth) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyDefaultNullPrecedence(NullPrecedence nullPrecedence) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyOrderingOfInserts(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyOrderingOfUpdates(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyMultiTenancyStrategy(MultiTenancyStrategy strategy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyCurrentTenantIdentifierResolver(CurrentTenantIdentifierResolver resolver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyJtaTrackingByThread(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyPreferUserTransactions(boolean preferUserTransactions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyQuerySubstitutions(Map substitutions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyStrictJpaQueryLanguageCompliance(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyNamedQueryCheckingOnStartup(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applySecondLevelCacheSupport(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyQueryCacheSupport(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyQueryCacheFactory(QueryCacheFactory factory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyCacheRegionPrefix(String prefix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyMinimalPutsForCaching(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyStructuredCacheEntries(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyDirectReferenceCaching(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyAutomaticEvictionOfCollectionCaches(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyJdbcBatchSize(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyJdbcBatchingForVersionedEntities(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyScrollableResultsSupport(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyResultSetsWrapping(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyGetGeneratedKeysSupport(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyJdbcFetchSize(int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyConnectionHandlingMode(PhysicalConnectionHandlingMode connectionHandlingMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applyConnectionReleaseMode(ConnectionReleaseMode connectionReleaseMode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applySqlComments(boolean enabled) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder applySqlFunction(String registrationName, SQLFunction sqlFunction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder allowOutOfTransactionUpdateOperations(boolean allow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryBuilder enableReleaseResourcesOnCloseEnabled(boolean enable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends SessionFactoryBuilder> T unwrap(Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactory build() {
		// TODO Auto-generated method stub
		return null;
	}

}

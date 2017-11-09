package dum.org.hibernate.boot.spi;

import java.util.ArrayList;
import java.util.Map;
import java.util.TimeZone;

import org.hibernate.ConnectionReleaseMode;
import org.hibernate.CustomEntityDirtinessStrategy;
import org.hibernate.EntityMode;
import org.hibernate.EntityNameResolver;
import org.hibernate.Interceptor;
import org.hibernate.MultiTenancyStrategy;
import org.hibernate.NullPrecedence;
import org.hibernate.SessionFactoryObserver;
import org.hibernate.boot.SchemaAutoTooling;
import org.hibernate.boot.TempTableDdlTransactionHandling;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cache.spi.QueryCacheFactory;
import org.hibernate.cfg.BaselineSessionEventsListenerBuilder;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.hql.spi.id.MultiTableBulkIdStrategy;
import org.hibernate.loader.BatchFetchStyle;
import org.hibernate.proxy.EntityNotFoundDelegate;
import org.hibernate.resource.jdbc.spi.PhysicalConnectionHandlingMode;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.hibernate.tuple.entity.EntityTuplizerFactory;

public class DummySessionFactoryOptions implements SessionFactoryOptions {

	private StandardServiceRegistry serviceRegistry;
	private ArrayList<SessionFactoryObserver> sessionFactoryObservers = new ArrayList<SessionFactoryObserver>();
	private MultiTableBulkIdStrategy multiTableBulkIdStrategy;

	@Override
	public StandardServiceRegistry getServiceRegistry() {
		// TODO Auto-generated method stub
		return serviceRegistry;
	}

	public void setServiceRegistry(StandardServiceRegistry serviceRegistry) {
		this.serviceRegistry = serviceRegistry;
	}

	@Override
	public Object getBeanManagerReference() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValidatorFactoryReference() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isJpaBootstrap() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isJtaTransactionAccessEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getSessionFactoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSessionFactoryNameAlsoJndiName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFlushBeforeCompletionEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAutoCloseSessionEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStatisticsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Interceptor getInterceptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends Interceptor> getStatelessInterceptorImplementor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatementInspector getStatementInspector() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactoryObserver[] getSessionFactoryObservers() {
		return sessionFactoryObservers.toArray(new SessionFactoryObserver[] {});
	}

	@Override
	public BaselineSessionEventsListenerBuilder getBaselineSessionEventsListenerBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isIdentifierRollbackEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EntityMode getDefaultEntityMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityTuplizerFactory getEntityTuplizerFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCheckNullability() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInitializeLazyStateOutsideTransactionsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MultiTableBulkIdStrategy getMultiTableBulkIdStrategy() {
		return multiTableBulkIdStrategy;
	}
	
	public void setMultiTableBulkIdStrategy(MultiTableBulkIdStrategy multiTableBulkIdStrategy) {
		this.multiTableBulkIdStrategy = multiTableBulkIdStrategy;
	}

	@Override
	public TempTableDdlTransactionHandling getTempTableDdlTransactionHandling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BatchFetchStyle getBatchFetchStyle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDefaultBatchFetchSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer getMaximumFetchDepth() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NullPrecedence getDefaultNullPrecedence() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isOrderUpdatesEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOrderInsertsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MultiTenancyStrategy getMultiTenancyStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CurrentTenantIdentifierResolver getCurrentTenantIdentifierResolver() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isJtaTrackByThread() {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Map getQuerySubstitutions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isStrictJpaQueryLanguageCompliance() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isNamedQueryStartupCheckingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConventionalJavaConstants() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSecondLevelCacheEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isQueryCacheEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public QueryCacheFactory getQueryCacheFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCacheRegionPrefix() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isMinimalPutsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isStructuredCacheEntriesEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDirectReferenceCacheEntriesEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAutoEvictCollectionCache() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SchemaAutoTooling getSchemaAutoTooling() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getJdbcBatchSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isJdbcBatchVersionedData() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isScrollableResultSetsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWrapResultSetsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGetGeneratedKeysEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer getJdbcFetchSize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhysicalConnectionHandlingMode getPhysicalConnectionHandlingMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ConnectionReleaseMode getConnectionReleaseMode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCommentsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CustomEntityDirtinessStrategy getCustomEntityDirtinessStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityNameResolver[] getEntityNameResolvers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityNotFoundDelegate getEntityNotFoundDelegate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, SQLFunction> getCustomSqlFunctionMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCheckNullability(boolean enabled) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPreferUserTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProcedureParameterNullPassingEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCollectionJoinSubqueryRewriteEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAllowOutOfTransactionUpdateOperations() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReleaseResourcesOnCloseEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public TimeZone getJdbcTimeZone() {
		// TODO Auto-generated method stub
		return null;
	}

}

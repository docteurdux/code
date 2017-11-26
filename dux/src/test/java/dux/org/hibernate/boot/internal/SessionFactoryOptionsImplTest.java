package dux.org.hibernate.boot.internal;

import org.hibernate.boot.internal.SessionFactoryOptionsImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.boot.internal.DummySessionFactoryOptionsState;
import dus.hibernate.core.HibernateCoreSummaryTest;

public class SessionFactoryOptionsImplTest extends AbstractTest {
	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, SessionFactoryOptionsImpl.class);
	}

	@Test
	public void test() {
		DummySessionFactoryOptionsState state = new DummySessionFactoryOptionsState();
		SessionFactoryOptionsImpl sfoi = new SessionFactoryOptionsImpl(state);
		/*-
		doesConnectionProviderDisableAutoCommit()
		getBaselineSessionEventsListenerBuilder()
		getBatchFetchStyle()
		getBeanManagerReference()
		getCacheRegionPrefix()
		getConnectionReleaseMode()
		getCriteriaLiteralHandlingMode()
		getCurrentTenantIdentifierResolver()
		getCustomEntityDirtinessStrategy()
		getCustomSqlFunctionMap()
		getDefaultBatchFetchSize()
		getDefaultEntityMode()
		getDefaultNullPrecedence()
		getEntityNameResolvers()
		getEntityNotFoundDelegate()
		getEntityTuplizerFactory()
		getInterceptor()
		getJdbcBatchSize()
		getJdbcFetchSize()
		getJdbcTimeZone()
		getMaximumFetchDepth()
		getMultiTableBulkIdStrategy()
		getMultiTenancyStrategy()
		getPhysicalConnectionHandlingMode()
		getQueryCacheFactory()
		getQuerySubstitutions()
		getSchemaAutoTooling()
		getServiceRegistry()
		getSessionFactoryName()
		getSessionFactoryObservers()
		getStatelessInterceptorImplementor()
		getStatementInspector()
		getTempTableDdlTransactionHandling()
		getValidatorFactoryReference()
		isAllowOutOfTransactionUpdateOperations()
		isAllowRefreshDetachedEntity()
		isAutoCloseSessionEnabled()
		isAutoEvictCollectionCache()
		isCheckNullability()
		isCollectionJoinSubqueryRewriteEnabled()
		isCommentsEnabled()
		isConventionalJavaConstants()
		isDirectReferenceCacheEntriesEnabled()
		isFlushBeforeCompletionEnabled()
		isGetGeneratedKeysEnabled()
		isIdentifierRollbackEnabled()
		isInitializeLazyStateOutsideTransactionsEnabled()
		isJdbcBatchVersionedData()
		isJpaBootstrap()
		isJtaTrackByThread()
		isJtaTransactionAccessEnabled()
		isMinimalPutsEnabled()
		isNamedQueryStartupCheckingEnabled()
		isOrderInsertsEnabled()
		isOrderUpdatesEnabled()
		isPreferUserTransaction()
		isProcedureParameterNullPassingEnabled()
		isQueryCacheEnabled()
		isQueryParametersValidationEnabled()
		isReleaseResourcesOnCloseEnabled()
		isScrollableResultSetsEnabled()
		isSecondLevelCacheEnabled()
		isSessionFactoryNameAlsoJndiName()
		isStatisticsEnabled()
		isStrictJpaQueryLanguageCompliance()
		isStructuredCacheEntriesEnabled()
		isWrapResultSetsEnabled()
		setCheckNullability(boolean)
		*/
	}
}

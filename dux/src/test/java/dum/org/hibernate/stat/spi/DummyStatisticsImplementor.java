package dum.org.hibernate.stat.spi;

import org.hibernate.stat.CollectionStatistics;
import org.hibernate.stat.EntityStatistics;
import org.hibernate.stat.NaturalIdCacheStatistics;
import org.hibernate.stat.QueryStatistics;
import org.hibernate.stat.SecondLevelCacheStatistics;
import org.hibernate.stat.spi.StatisticsImplementor;

public class DummyStatisticsImplementor implements StatisticsImplementor {

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public EntityStatistics getEntityStatistics(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionStatistics getCollectionStatistics(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SecondLevelCacheStatistics getSecondLevelCacheStatistics(String regionName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NaturalIdCacheStatistics getNaturalIdCacheStatistics(String regionName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryStatistics getQueryStatistics(String queryString) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getEntityDeleteCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getEntityInsertCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getEntityLoadCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getEntityFetchCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getEntityUpdateCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getQueryExecutionCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getQueryExecutionMaxTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getQueryExecutionMaxTimeQueryString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getQueryCacheHitCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getQueryCacheMissCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getQueryCachePutCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getNaturalIdQueryExecutionCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getNaturalIdQueryExecutionMaxTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNaturalIdQueryExecutionMaxTimeRegion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNaturalIdCacheHitCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getNaturalIdCacheMissCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getNaturalIdCachePutCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getUpdateTimestampsCacheHitCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getUpdateTimestampsCacheMissCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getUpdateTimestampsCachePutCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getFlushCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getConnectCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getSecondLevelCacheHitCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getSecondLevelCacheMissCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getSecondLevelCachePutCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getSessionCloseCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getSessionOpenCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCollectionLoadCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCollectionFetchCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCollectionUpdateCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCollectionRemoveCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCollectionRecreateCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getStartTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void logSummary() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isStatisticsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setStatisticsEnabled(boolean b) {
		// TODO Auto-generated method stub

	}

	@Override
	public String[] getQueries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getEntityNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getCollectionRoleNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getSecondLevelCacheRegionNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getSuccessfulTransactionCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getTransactionCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getPrepareStatementCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCloseStatementCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getOptimisticFailureCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void openSession() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeSession() {
		// TODO Auto-generated method stub

	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public void connect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void prepareStatement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void closeStatement() {
		// TODO Auto-generated method stub

	}

	@Override
	public void endTransaction(boolean success) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadEntity(String entityName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fetchEntity(String entityName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateEntity(String entityName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertEntity(String entityName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEntity(String entityName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void optimisticFailure(String entityName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadCollection(String role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fetchCollection(String role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCollection(String role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recreateCollection(String role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeCollection(String role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void secondLevelCachePut(String regionName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void secondLevelCacheHit(String regionName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void secondLevelCacheMiss(String regionName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void naturalIdCachePut(String regionName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void naturalIdCacheHit(String regionName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void naturalIdCacheMiss(String regionName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void naturalIdQueryExecuted(String regionName, long time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void queryCachePut(String hql, String regionName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void queryCacheHit(String hql, String regionName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void queryCacheMiss(String hql, String regionName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void queryExecuted(String hql, int rows, long time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTimestampsCacheHit() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTimestampsCacheMiss() {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTimestampsCachePut() {
		// TODO Auto-generated method stub

	}

}

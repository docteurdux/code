package dum.org.hibernate.engine.spi;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cache.spi.QueryCache;
import org.hibernate.cache.spi.RegionFactory;
import org.hibernate.cache.spi.UpdateTimestampsCache;
import org.hibernate.cache.spi.access.CollectionRegionAccessStrategy;
import org.hibernate.cache.spi.access.EntityRegionAccessStrategy;
import org.hibernate.cache.spi.access.NaturalIdRegionAccessStrategy;
import org.hibernate.engine.spi.CacheImplementor;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.PersistentClass;

public class DummyCacheImplementor implements CacheImplementor {

	@Override
	public SessionFactory getSessionFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsEntity(Class entityClass, Serializable identifier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEntity(String entityName, Serializable identifier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void evictEntity(Class entityClass, Serializable identifier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictEntity(String entityName, Serializable identifier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictEntityRegion(Class entityClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictEntityRegion(String entityName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictEntityRegions() {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictNaturalIdRegion(Class naturalIdClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictNaturalIdRegion(String naturalIdName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictNaturalIdRegions() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsCollection(String role, Serializable ownerIdentifier) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void evictCollection(String role, Serializable ownerIdentifier) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictCollectionRegion(String role) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictCollectionRegions() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean containsQuery(String regionName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void evictDefaultQueryRegion() {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictQueryRegion(String regionName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictQueryRegions() {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictAllRegions() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Class arg0, Object arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void evict(Class arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evict(Class arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T unwrap(Class<T> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public QueryCache getQueryCache(String regionName) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryCache getDefaultQueryCache() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateTimestampsCache getUpdateTimestampsCache() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void evictQueries() throws HibernateException {
		// TODO Auto-generated method stub

	}

	@Override
	public RegionFactory getRegionFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String qualifyRegionName(String regionName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getSecondLevelCacheRegionNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityRegionAccessStrategy getEntityRegionAccess(String regionName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionRegionAccessStrategy getCollectionRegionAccess(String regionName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NaturalIdRegionAccessStrategy getNaturalIdCacheRegionAccessStrategy(String regionName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityRegionAccessStrategy determineEntityRegionAccessStrategy(PersistentClass model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NaturalIdRegionAccessStrategy determineNaturalIdRegionAccessStrategy(PersistentClass model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionRegionAccessStrategy determineCollectionRegionAccessStrategy(Collection model) {
		// TODO Auto-generated method stub
		return null;
	}

}

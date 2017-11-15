package dum.org.hibernate.cache.spi.access;

import org.hibernate.cache.CacheException;
import org.hibernate.cache.spi.NaturalIdRegion;
import org.hibernate.cache.spi.access.NaturalIdRegionAccessStrategy;
import org.hibernate.cache.spi.access.SoftLock;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.persister.entity.EntityPersister;

public class DummyNaturalIdRegionAccessStrategy implements NaturalIdRegionAccessStrategy {

	@Override
	public Object get(SharedSessionContractImplementor session, Object key, long txTimestamp) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean putFromLoad(SharedSessionContractImplementor session, Object key, Object value, long txTimestamp,
			Object version) throws CacheException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean putFromLoad(SharedSessionContractImplementor session, Object key, Object value, long txTimestamp,
			Object version, boolean minimalPutOverride) throws CacheException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public SoftLock lockItem(SharedSessionContractImplementor session, Object key, Object version)
			throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SoftLock lockRegion() throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void unlockItem(SharedSessionContractImplementor session, Object key, SoftLock lock) throws CacheException {
		// TODO Auto-generated method stub

	}

	@Override
	public void unlockRegion(SoftLock lock) throws CacheException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(SharedSessionContractImplementor session, Object key) throws CacheException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAll() throws CacheException {
		// TODO Auto-generated method stub

	}

	@Override
	public void evict(Object key) throws CacheException {
		// TODO Auto-generated method stub

	}

	@Override
	public void evictAll() throws CacheException {
		// TODO Auto-generated method stub

	}

	@Override
	public Object generateCacheKey(Object[] naturalIdValues, EntityPersister persister,
			SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getNaturalIdValues(Object cacheKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NaturalIdRegion getRegion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(SharedSessionContractImplementor session, Object key, Object value) throws CacheException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean afterInsert(SharedSessionContractImplementor session, Object key, Object value)
			throws CacheException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(SharedSessionContractImplementor session, Object key, Object value) throws CacheException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean afterUpdate(SharedSessionContractImplementor session, Object key, Object value, SoftLock lock)
			throws CacheException {
		// TODO Auto-generated method stub
		return false;
	}

}

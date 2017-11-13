package dum.org.hibernate.cache.spi;

import java.util.Map;

import org.hibernate.cache.CacheException;
import org.hibernate.cache.spi.QueryResultsRegion;
import org.hibernate.engine.spi.SharedSessionContractImplementor;

public class DummyQueryResultsRegion implements QueryResultsRegion {

	@Override
	public Object get(SharedSessionContractImplementor session, Object key) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void put(SharedSessionContractImplementor session, Object key, Object value) throws CacheException {
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
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() throws CacheException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long getSizeInMemory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getElementCountInMemory() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getElementCountOnDisk() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map toMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long nextTimestamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTimeout() {
		// TODO Auto-generated method stub
		return 0;
	}

}

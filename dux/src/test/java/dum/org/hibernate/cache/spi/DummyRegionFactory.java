package dum.org.hibernate.cache.spi;

import java.util.Properties;

import org.hibernate.boot.spi.SessionFactoryOptions;
import org.hibernate.cache.CacheException;
import org.hibernate.cache.spi.CacheDataDescription;
import org.hibernate.cache.spi.CollectionRegion;
import org.hibernate.cache.spi.EntityRegion;
import org.hibernate.cache.spi.NaturalIdRegion;
import org.hibernate.cache.spi.QueryResultsRegion;
import org.hibernate.cache.spi.RegionFactory;
import org.hibernate.cache.spi.TimestampsRegion;
import org.hibernate.cache.spi.access.AccessType;

public class DummyRegionFactory implements RegionFactory {

	@Override
	public void start(SessionFactoryOptions settings, Properties properties) throws CacheException {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isMinimalPutsEnabledByDefault() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AccessType getDefaultAccessType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long nextTimestamp() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EntityRegion buildEntityRegion(String regionName, Properties properties, CacheDataDescription metadata)
			throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NaturalIdRegion buildNaturalIdRegion(String regionName, Properties properties, CacheDataDescription metadata)
			throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionRegion buildCollectionRegion(String regionName, Properties properties,
			CacheDataDescription metadata) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryResultsRegion buildQueryResultsRegion(String regionName, Properties properties) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TimestampsRegion buildTimestampsRegion(String regionName, Properties properties) throws CacheException {
		// TODO Auto-generated method stub
		return null;
	}

}

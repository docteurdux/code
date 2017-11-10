package dux.org.hibernate.loader.collection;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.loader.collection.BatchingCollectionInitializer;
import org.hibernate.persister.collection.QueryableCollection;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.persister.collection.DummyQueryableCollection;

@Done
public class BatchingCollectionInitializerTest extends AbstractTest {

	private DummyQueryableCollection queryableCollection;

	@Before
	public void before() {
		queryableCollection = new DummyQueryableCollection();
	}

	@Test
	public void test() {

		BatchingCollectionInitializer bci = getInstance(queryableCollection);

		aeqr(queryableCollection, bci.getCollectionPersister());
		aeqr(queryableCollection, bci.collectionPersister());
	}

	private BatchingCollectionInitializer getInstance(QueryableCollection queryableCollection) {

		return new BatchingCollectionInitializer(queryableCollection) {
			@Override
			public void initialize(Serializable id, SharedSessionContractImplementor session)
					throws HibernateException {

			}
		};

	}
}

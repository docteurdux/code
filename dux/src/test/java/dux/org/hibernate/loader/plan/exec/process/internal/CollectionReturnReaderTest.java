package dux.org.hibernate.loader.plan.exec.process.internal;

import org.hibernate.loader.plan.exec.process.internal.CollectionReturnReader;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.java.sql.DummyResultSet;
import dum.org.hibernate.loader.plan.exec.process.spi.DummyResultSetProcessingContext;
import dum.org.hibernate.loader.plan.spi.DummyCollectionReturn;

@Done
public class CollectionReturnReaderTest extends AbstractTest {
	private DummyCollectionReturn collectionReturn;
	private DummyResultSet anyResultSet;
	private DummyResultSetProcessingContext anyResultSetProcessingContext;

	@Before
	public void before() {
		collectionReturn = new DummyCollectionReturn();
		anyResultSet = new DummyResultSet();
		anyResultSetProcessingContext = new DummyResultSetProcessingContext();
	}

	@Test
	public void test() throws Exception {
		CollectionReturnReader collectionReturnReader = new CollectionReturnReader(collectionReturn);
		an(collectionReturnReader.read(anyResultSet, anyResultSetProcessingContext));
	}
}

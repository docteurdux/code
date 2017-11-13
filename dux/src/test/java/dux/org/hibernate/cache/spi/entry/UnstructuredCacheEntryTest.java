package dux.org.hibernate.cache.spi.entry;

import org.hibernate.cache.spi.entry.UnstructuredCacheEntry;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;

@Done
public class UnstructuredCacheEntryTest extends AbstractTest {

	private Object anyItem;
	private Object anyStructured;
	private DummySessionFactoryImplementor anySessionFactoryImplementor;

	public UnstructuredCacheEntryTest() {
		anyItem = new Object();
		anyStructured = new Object();
		anySessionFactoryImplementor = new DummySessionFactoryImplementor();
	}

	@Test
	public void test() {

		UnstructuredCacheEntry instance = UnstructuredCacheEntry.INSTANCE;

		aeqr(anyItem, instance.structure(anyItem));
		aeqr(anyStructured, instance.destructure(anyStructured, anySessionFactoryImplementor));
	}

}

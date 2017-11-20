package dux.org.hibernate.cache.spi.entry;

import org.hibernate.cache.spi.entry.ReferenceCacheEntryImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.persister.entity.DummyEntityPersister;

@Done
public class ReferenceCacheEntryImplTest extends AbstractTest {

	private String entityName;
	private Object reference;
	private DummyEntityPersister entityPersister;

	public ReferenceCacheEntryImplTest() {

		entityName = "entityName";

		reference = new Object();

		entityPersister = new DummyEntityPersister();
		entityPersister.setEntityName(entityName);
	}

	@Test
	public void test() {

		ReferenceCacheEntryImpl referenceCacheEntryImpl = new ReferenceCacheEntryImpl(reference, entityPersister);

		aeqr(reference, referenceCacheEntryImpl.getReference());
		aeqr(entityPersister, referenceCacheEntryImpl.getSubclassPersister());

		aeq(entityName, referenceCacheEntryImpl.getSubclass());

		aeq(true, referenceCacheEntryImpl.isReferenceEntry());
		aeq(null, referenceCacheEntryImpl.getVersion());
		aeq(null, referenceCacheEntryImpl.getDisassembledState());
	}
}

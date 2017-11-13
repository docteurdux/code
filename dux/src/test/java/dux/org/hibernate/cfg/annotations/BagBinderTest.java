package dux.org.hibernate.cfg.annotations;

import org.hibernate.mapping.Bag;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.DummyPersistentClass;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.boot.spi.DummyInFlightMetadataCollector;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.cfg.annotations.DummyBagBinder;

@Done
public class BagBinderTest extends AbstractTest {
	private DummyInFlightMetadataCollector inFlightMetadataCollector;
	private DummyMetadataBuildingContext metadataBuildingContext;
	private DummyPersistentClass persistentClass;

	@Before
	public void before() {

		inFlightMetadataCollector = new DummyInFlightMetadataCollector();

		metadataBuildingContext = new DummyMetadataBuildingContext();
		metadataBuildingContext.setMetadataCollector(inFlightMetadataCollector);

		persistentClass = new DummyPersistentClass(metadataBuildingContext);

	}

	@Test
	public void test() {

		DummyBagBinder bagBinder = new DummyBagBinder();
		bagBinder.setBuildingContext(metadataBuildingContext);

		Collection bag = bagBinder.createCollection(persistentClass);

		aeq(Bag.class, bag.getClass());
		aeqr(persistentClass, bag.getOwner());
		aeqr(inFlightMetadataCollector, bag.getMetadata());

	}
}

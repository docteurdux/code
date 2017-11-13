package dux.org.hibernate.cfg.annotations;

import org.hibernate.mapping.Collection;
import org.hibernate.mapping.DummyPersistentClass;
import org.hibernate.mapping.PersistentClass;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.boot.spi.DummyInFlightMetadataCollector;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.cfg.annotations.DummyArrayBinder;

@Done
public class ArrayBinderTest extends AbstractTest {

	private DummyMetadataBuildingContext metadataBuildingContext;

	private PersistentClass persistentClass;

	private DummyInFlightMetadataCollector inFlightMetadataCollector;

	public ArrayBinderTest() {

		inFlightMetadataCollector = new DummyInFlightMetadataCollector();

		metadataBuildingContext = new DummyMetadataBuildingContext();
		metadataBuildingContext.setMetadataCollector(inFlightMetadataCollector);

		persistentClass = new DummyPersistentClass(metadataBuildingContext);
	}

	@Test
	public void test() {

		DummyArrayBinder arrayBinder = new DummyArrayBinder();
		arrayBinder.setBuildingContext(metadataBuildingContext);

		Collection a = arrayBinder.createCollection(persistentClass);

		aeqr(inFlightMetadataCollector, a.getMetadata());
		aeqr(persistentClass, a.getOwner());

	}
}

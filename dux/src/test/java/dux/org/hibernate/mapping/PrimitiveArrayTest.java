package dux.org.hibernate.mapping;

import org.hibernate.mapping.Array;
import org.hibernate.mapping.DummyPersistentClass;
import org.hibernate.mapping.PrimitiveArray;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.boot.spi.DummyMetadataImplementor;
import dum.org.hibernate.mapping.DummyValueVisitor;

@Done
public class PrimitiveArrayTest extends AbstractTest {

	private DummyMetadataImplementor metadataImplementor;
	private DummyPersistentClass persistentClass;
	private DummyMetadataBuildingContext metadataBuildingContext;
	private DummyValueVisitor valueVisitor;

	@Before
	public void before() {
		metadataBuildingContext = new DummyMetadataBuildingContext();
		persistentClass = new DummyPersistentClass(metadataBuildingContext);
		metadataImplementor = new DummyMetadataImplementor();
		valueVisitor = new DummyValueVisitor();
	}

	@Test
	public void test() {

		aeq(Array.class, PrimitiveArray.class.getSuperclass());

		PrimitiveArray pa = new PrimitiveArray(metadataImplementor, persistentClass);

		at(pa.isPrimitiveArray());

		pa.accept(valueVisitor);
		aeqr(pa, testEvent(valueVisitor, 0, "object"));

	}
}

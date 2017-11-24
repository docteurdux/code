package dux.org.hibernate.boot.internal;

import org.hibernate.boot.internal.InFlightMetadataCollectorImpl;
import org.hibernate.type.TypeResolver;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;

public class InFlightMetadataCollectorImplTest extends AbstractTest {
	@Test
	public void test() {
		DummyMetadataBuildingOptions options = new DummyMetadataBuildingOptions();
		TypeResolver typeResolver = new TypeResolver();
		InFlightMetadataCollectorImpl i = new InFlightMetadataCollectorImpl(options, typeResolver);
	}
}

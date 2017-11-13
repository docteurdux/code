package dux.org.hibernate.cfg.annotations.reflection;

import org.hibernate.cfg.annotations.reflection.ClassLoaderAccessLazyImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;

@Done
public class ClassLoaderAccessLazyImplTest extends AbstractTest {

	private String anyName;
	private DummyMetadataBuildingOptions metadataBuildingOptions;

	@Before
	public void before() {
		anyName = "anyName";
		metadataBuildingOptions = new DummyMetadataBuildingOptions();
	}

	@Test
	public void test() {

		ClassLoaderAccessLazyImpl clali = new ClassLoaderAccessLazyImpl(metadataBuildingOptions);

		an(clali.classForName(anyName));
		an(clali.locateResource(anyName));

	}
}

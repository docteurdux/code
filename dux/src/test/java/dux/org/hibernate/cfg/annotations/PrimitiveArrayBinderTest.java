package dux.org.hibernate.cfg.annotations;

import javax.persistence.OneToMany;

import org.hibernate.cfg.annotations.PrimitiveArrayBinder;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.annotations.common.reflection.DummyReflectionManager;
import dum.org.hibernate.annotations.common.reflection.DummyXProperty;
import dum.org.hibernate.boot.spi.DummyInFlightMetadataCollector;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.cfg.DummyPropertyHolder;

public class PrimitiveArrayBinderTest extends AbstractTest {
	@Test
	public void test() {
		
		DummyReflectionManager reflectionManager = new DummyReflectionManager();
		
		DummyMetadataBuildingOptions buildingOptions = new DummyMetadataBuildingOptions();
		buildingOptions.setReflectionManager(reflectionManager);
		DummyInFlightMetadataCollector metadataCollector = new DummyInFlightMetadataCollector();
		DummyMetadataBuildingContext buildingContext = new DummyMetadataBuildingContext();
		buildingContext.setMetadataCollector(metadataCollector);
		buildingContext.setBuildingOptions(buildingOptions);

		DummyPropertyHolder propertyHolder = new DummyPropertyHolder();
		String path = "path";
		propertyHolder.setPath(path);

		DummyXProperty property = new DummyXProperty();
		property.setAnnotation(OneToMany.class, new OneToManyBuilder().build());

		PrimitiveArrayBinder pab = new PrimitiveArrayBinder();
		pab.setBuildingContext(buildingContext);
		pab.setPropertyHolder(propertyHolder);
		String propertyName = "propertyName";
		pab.setPropertyName(propertyName);
		pab.setProperty(property);
		pab.bind();
	}
}

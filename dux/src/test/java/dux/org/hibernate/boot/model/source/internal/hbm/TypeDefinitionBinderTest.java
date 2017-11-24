package dux.org.hibernate.boot.model.source.internal.hbm;

import java.util.Map;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmTypeDefinitionType;
import org.hibernate.boot.model.TypeDefinition;
import org.hibernate.boot.model.source.internal.hbm.TypeDefinitionBinder;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TEI;

import dum.org.hibernate.boot.model.source.internal.hbm.DummyHbmLocalMetadataBuildingContext;
import dum.org.hibernate.boot.registry.classloading.spi.DummyClassLoaderService;
import dum.org.hibernate.boot.spi.DummyInFlightMetadataCollector;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dux.org.hibernate.query.criteria.internal.DummyStandardServiceRegistry;

@Done
public class TypeDefinitionBinderTest extends AbstractTest {

	private DummyClassLoaderService classLoaderService;
	private DummyStandardServiceRegistry standardServiceRegistry;
	private DummyMetadataBuildingOptions metadataBuildingOptions;
	private DummyHbmLocalMetadataBuildingContext hbmLocalMetadataBuildingContext;
	private DummyInFlightMetadataCollector inFlightMetadataCollector;
	private JaxbHbmTypeDefinitionType jaxbHbmTypeDefinitionType;
	private String typeDefinitionName;

	@Before
	public void before() {

		typeDefinitionName = "typeDefinitionName";

		classLoaderService = new DummyClassLoaderService();
		classLoaderService.setClassForNameRWA(new RunnableWithArgs<Class<?>>() {
			@Override
			public Class<?> run(Object... args) {
				return Object.class;
			}
		});

		standardServiceRegistry = new DummyStandardServiceRegistry();
		standardServiceRegistry.setService(ClassLoaderService.class, classLoaderService);

		metadataBuildingOptions = new DummyMetadataBuildingOptions();
		metadataBuildingOptions.setServiceRegistry(standardServiceRegistry);

		inFlightMetadataCollector = new DummyInFlightMetadataCollector();

		hbmLocalMetadataBuildingContext = new DummyHbmLocalMetadataBuildingContext();
		hbmLocalMetadataBuildingContext.setBuildingOptions(metadataBuildingOptions);
		hbmLocalMetadataBuildingContext.setMetadataCollector(inFlightMetadataCollector);

		jaxbHbmTypeDefinitionType = new JaxbHbmTypeDefinitionType();
		jaxbHbmTypeDefinitionType.setName(typeDefinitionName);

	}

	@Test
	public void test() {

		TypeDefinitionBinder.processTypeDefinition(hbmLocalMetadataBuildingContext, jaxbHbmTypeDefinitionType);

		dumpTestEvents(this);

		ate(inFlightMetadataCollector, new TEI[] { new TEI("addTypeDefinition") {
			@Override
			protected void i(Map<String, Object> props) {
				aeq(typeDefinitionName, get(props, "typeDefinition", TypeDefinition.class).getName());
			}
		} });
	}
}

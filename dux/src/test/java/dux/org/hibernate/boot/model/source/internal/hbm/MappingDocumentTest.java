package dux.org.hibernate.boot.model.source.internal.hbm;

import java.util.Map;

import org.hibernate.boot.jaxb.Origin;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmHibernateMapping;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmTypeDefinitionType;
import org.hibernate.boot.model.TypeDefinition;
import org.hibernate.boot.model.source.internal.OverriddenMappingDefaults;
import org.hibernate.boot.model.source.internal.hbm.MappingDocument;
import org.hibernate.boot.model.source.internal.hbm.TypeDefinitionBinder;
import org.hibernate.boot.model.source.spi.ToolingHintContext;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TEI;

import dum.org.hibernate.boot.jaxb.hbm.spi.DummyEntityInfo;
import dum.org.hibernate.boot.model.naming.DummyObjectNameNormalizer;
import dum.org.hibernate.boot.registry.classloading.spi.DummyClassLoaderService;
import dum.org.hibernate.boot.spi.DummyClassLoaderAccess;
import dum.org.hibernate.boot.spi.DummyInFlightMetadataCollector;
import dum.org.hibernate.boot.spi.DummyMappingDefaults;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dus.hibernate.core.HibernateCoreSummaryTest;
import dux.org.hibernate.query.criteria.internal.DummyStandardServiceRegistry;

public class MappingDocumentTest extends AbstractTest {

	private Boolean jaxbHbmHibernateMapping$lazy;
	private Boolean jaxbHbmHibernateMapping$autoImport;
	private JaxbHbmHibernateMapping jaxbHbmHibernateMapping;
	private Origin origin;
	private DummyMetadataBuildingContext metadataBuildingContext;
	private DummyMetadataBuildingOptions metadataBuildingOptions;
	private DummyInFlightMetadataCollector inFlightMetadataCollector;
	private DummyMappingDefaults mappingDefaults;
	private DummyClassLoaderAccess classLoaderAccess;
	private DummyObjectNameNormalizer objectNameNormalizer;
	private DummyStandardServiceRegistry standardServiceRegistry;
	private DummyClassLoaderService classLoaderService;
	private String typeDefinitionName;

	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, MappingDocument.class, TypeDefinitionBinder.class);

		typeDefinitionName = "typeDefinitionName";

		JaxbHbmTypeDefinitionType jaxbHbmTypeDefinitionType = new JaxbHbmTypeDefinitionType();
		jaxbHbmTypeDefinitionType.setName(typeDefinitionName);

		jaxbHbmHibernateMapping$lazy = true;
		jaxbHbmHibernateMapping$autoImport = true;

		jaxbHbmHibernateMapping = new JaxbHbmHibernateMapping();
		jaxbHbmHibernateMapping.setSchema("schema");
		jaxbHbmHibernateMapping.setCatalog("catalog");
		jaxbHbmHibernateMapping.setPackage("package");
		jaxbHbmHibernateMapping.setDefaultAccess("defaultAccess");
		jaxbHbmHibernateMapping.setDefaultCascade("defaultCascade");
		jaxbHbmHibernateMapping.setDefaultLazy(jaxbHbmHibernateMapping$lazy);
		jaxbHbmHibernateMapping.setAutoImport(jaxbHbmHibernateMapping$autoImport);

		jaxbHbmHibernateMapping.getTypedef().add(jaxbHbmTypeDefinitionType);

		origin = new Origin(SourceType.OTHER, "originName");

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
		mappingDefaults = new DummyMappingDefaults();
		classLoaderAccess = new DummyClassLoaderAccess();
		objectNameNormalizer = new DummyObjectNameNormalizer();

		metadataBuildingContext = new DummyMetadataBuildingContext();
		metadataBuildingContext.setBuildingOptions(metadataBuildingOptions);
		metadataBuildingContext.setMetadataCollector(inFlightMetadataCollector);
		metadataBuildingContext.setMappingDefaults(mappingDefaults);
		metadataBuildingContext.setClassLoaderAccess(classLoaderAccess);
		metadataBuildingContext.setObjectNameNormalizer(objectNameNormalizer);
	}

	@Test
	public void test() {

		MappingDocument md = new MappingDocument(jaxbHbmHibernateMapping, origin, metadataBuildingContext);

		DummyEntityInfo entityElement = new DummyEntityInfo();
		md.determineEntityName(entityElement);
		md.determineEntityName("entityName", "clazz");
		md.qualifyClassName("name");
		// md.findEntityBinding("entityName", "clazz");

		md.processTypeDefinitions();
		ate(getLastTestEvent(inFlightMetadataCollector), new TEI("addTypeDefinition") {
			@Override
			protected void i(Map<String, Object> props) {
				aeq(typeDefinitionName, get(props, "typeDefinition", TypeDefinition.class).getName());
			}
		});
		md.processQueryRenames();
		md.processFilterDefinitions();
		md.processFetchProfiles();
		md.processAuxiliaryDatabaseObjectDefinitions();
		md.processNamedQueries();
		md.processIdentifierGenerators();
		md.processResultSetMappings();

		// the following are getters to the parameters passed to the constructor
		aeqr(jaxbHbmHibernateMapping, md.getDocumentRoot());
		aeqr(origin, md.getOrigin());

		// the mapping defaults are passed on to an overrider
		aeq(OverriddenMappingDefaults.class, md.getMappingDefaults().getClass());

		// the toolingHintContext is derived using
		// org.hibernate.boot.model.source.internal.hbm.Helper.collectToolingHints(ToolingHintContext,
		// ToolingHintContainer)
		aeq(ToolingHintContext.class, md.getToolingHintContext().getClass());

		// the following just delegate to the metadataBuildingContext
		aeqr(inFlightMetadataCollector, md.getMetadataCollector());
		aeqr(classLoaderAccess, md.getClassLoaderAccess());
		aeqr(objectNameNormalizer, md.getObjectNameNormalizer());
		aeqr(metadataBuildingOptions, md.getBuildingOptions());

		// the following do nothing
		md.prepare();
		md.prepareForEntityHierarchyProcessing();
		md.postProcessEntityHierarchies();
		md.postProcessEntityHierarchies();
		md.finishUp();

		dumpTestEvents(this);

	}
}

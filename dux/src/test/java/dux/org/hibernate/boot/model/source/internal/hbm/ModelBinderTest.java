package dux.org.hibernate.boot.model.source.internal.hbm;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.jaxb.Origin;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.boot.jaxb.hbm.spi.EntityInfo;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmHibernateMapping;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmRootEntityType;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.boot.model.source.internal.hbm.EntityHierarchySourceImpl;
import org.hibernate.boot.model.source.internal.hbm.MappingDocument;
import org.hibernate.boot.model.source.internal.hbm.ModelBinder;
import org.hibernate.boot.model.source.internal.hbm.RootEntitySourceImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.org.hibernate.boot.jaxb.hbm.spi.DummyEntityInfo;
import dum.org.hibernate.boot.model.naming.DummyPhysicalNamingStrategy;
import dum.org.hibernate.boot.model.source.internal.hbm.DummyRootEntitySourceImpl;
import dum.org.hibernate.boot.spi.DummyInFlightMetadataCollector;
import dum.org.hibernate.boot.spi.DummyMappingDefaults;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.engine.jdbc.env.spi.DummyIdentifierHelper;
import dum.org.hibernate.engine.jdbc.env.spi.DummyJdbcEnvironment;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dus.hibernate.core.HibernateCoreSummaryTest;
import dux.org.hibernate.query.criteria.internal.DummyStandardServiceRegistry;

public class ModelBinderTest extends AbstractTest {

	private Map<String, Identifier> identifierMap;
	private DummyIdentifierHelper identifierHelper;
	private DummyJdbcEnvironment jdbcEnvironment;
	private DummyJdbcServices jdbcServices;
	private DummyStandardServiceRegistry standardServiceRegistry;
	private DummyMappingDefaults mappingDefaults;
	private DummyPhysicalNamingStrategy physicalNamingStrategy;
	private DummyMetadataBuildingOptions metadataBuildingOptions;
	private Database database;
	private DummyInFlightMetadataCollector inFlightMetadataCollector;
	private DummyMetadataBuildingContext metadataBuildingContext;

	@Before
	public void before() {

		this.requireSources(HibernateCoreSummaryTest.MVNNAME, ModelBinder.class);

		identifierMap = new HashMap<>();

		identifierHelper = new DummyIdentifierHelper();
		identifierHelper.setToIdentifierRWA(new RunnableWithArgs<Identifier>() {
			@Override
			public Identifier run(Object... args) {
				String text = (String) args[0];
				if (!identifierMap.containsKey(text)) {
					identifierMap.put(text, new Identifier(text, false));
				}
				return identifierMap.get(text);
			}
		});

		jdbcEnvironment = new DummyJdbcEnvironment();
		jdbcEnvironment.setIdentifierHelper(identifierHelper);

		jdbcServices = new DummyJdbcServices();

		standardServiceRegistry = new DummyStandardServiceRegistry();
		standardServiceRegistry.setService(JdbcEnvironment.class, jdbcEnvironment);
		standardServiceRegistry.setService(JdbcServices.class, jdbcServices);

		mappingDefaults = new DummyMappingDefaults();
		mappingDefaults.setImplicitCatalogName("implicitCatalogName");
		mappingDefaults.setImplicitSchemaName("implicitSchemaName");

		physicalNamingStrategy = new DummyPhysicalNamingStrategy();

		metadataBuildingOptions = new DummyMetadataBuildingOptions();
		metadataBuildingOptions.setServiceRegistry(standardServiceRegistry);
		metadataBuildingOptions.setMappingDefaults(mappingDefaults);
		metadataBuildingOptions.setPhysicalNamingStrategy(physicalNamingStrategy);

		database = new Database(metadataBuildingOptions);

		inFlightMetadataCollector = new DummyInFlightMetadataCollector();
		inFlightMetadataCollector.setDatabase(database);

		metadataBuildingContext = new DummyMetadataBuildingContext();
		metadataBuildingContext.setMetadataCollector(inFlightMetadataCollector);
		metadataBuildingContext.setBuildingOptions(metadataBuildingOptions);
	}

	@Test
	public void test() {

		ModelBinder modelBinder = ModelBinder.prepare(metadataBuildingContext);

		JaxbHbmHibernateMapping documentRoot = new JaxbHbmHibernateMapping();
		Origin origin = new Origin(SourceType.OTHER, "originName");

		MappingDocument sourceMappingDocument = new MappingDocument(documentRoot, origin, metadataBuildingContext);

		JaxbHbmRootEntityType jaxbHbmRootEntityType = new JaxbHbmRootEntityType();
		DummyRootEntitySourceImpl rootEntitySourceImpl = new DummyRootEntitySourceImpl(sourceMappingDocument,
				jaxbHbmRootEntityType);
		EntityHierarchySourceImpl entityHierarchySourceImpl = new EntityHierarchySourceImpl(rootEntitySourceImpl);
		modelBinder.bindEntityHierarchy(entityHierarchySourceImpl);

		// bindEntityHierarchy(EntityHierarchySourceImpl)
		// bindListOrArrayIndex(MappingDocument, IndexedPluralAttributeSource, List)
		// bindOneToOne(MappingDocument, SingularAttributeSourceOneToOne, OneToOne)
		// finishUp(MetadataBuildingContext)

	}
}

package dux.org.hibernate.cfg;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.boot.model.TypeDefinition;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.ImplicitBasicColumnNameSource;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.cfg.Ejb3Column;
import org.hibernate.cfg.SetSimpleValueTypeSecondPass;
import org.hibernate.cfg.annotations.SimpleValueBinder;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.mapping.Table;
import org.hibernate.type.TypeResolver;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;
import com.github.docteurdux.test.hibernate.BasicColumnNameDeterminer;

import dum.org.hibernate.boot.model.naming.DummyImplicitNamingStrategy;
import dum.org.hibernate.boot.model.naming.DummyObjectNameNormalizer;
import dum.org.hibernate.boot.model.naming.DummyPhysicalNamingStrategy;
import dum.org.hibernate.boot.spi.DummyClassLoaderAccess;
import dum.org.hibernate.boot.spi.DummyInFlightMetadataCollector;
import dum.org.hibernate.boot.spi.DummyMappingDefaults;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.engine.jdbc.env.spi.DummyIdentifierHelper;
import dum.org.hibernate.engine.jdbc.env.spi.DummyJdbcEnvironment;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dux.org.hibernate.query.criteria.internal.DummyStandardServiceRegistry;

@Done("requiers a secon pass")
public class SetSimpleValueTypeSecondPassTest extends AbstractTest {

	private String implicitCatalogName;
	private String implicitSchemaName;
	private String columnName;
	private String explicitType;

	private String[] registrationKeys;

	private Dialect dialect;

	private Map<String, String> parameters;
	private DummyIdentifierHelper identifierHelper;
	private DummyJdbcEnvironment jdbcEnvironment;
	private DummyJdbcServices jdbcServices;
	private DummyStandardServiceRegistry standardServiceRegistry;
	private DummyMappingDefaults mappingDefaults;
	private DummyPhysicalNamingStrategy physicalNamingStrategy;
	private DummyImplicitNamingStrategy implicitNamingStrategy;
	private DummyMetadataBuildingOptions metadataBuildingOptions;
	private Database database;
	private TypeResolver typeResolver;
	private TypeDefinition typeDefinition;
	private DummyInFlightMetadataCollector inFlightMetadataCollector;
	private DummyObjectNameNormalizer objectNameNormalizer;
	private DummyClassLoaderAccess classLoaderAccess;
	private DummyMetadataBuildingContext metadataBuildingContext;
	private Table table;
	private Ejb3Column ejb3Column;
	private Ejb3Column[] ejb3Columns;
	private SimpleValueBinder simpleValueBinder;

	@SuppressWarnings("rawtypes")
	private Map persistentClasses;

	public static class A {

	}

	@Before
	public void before() {

		implicitCatalogName = "implicitCatalogName";
		implicitSchemaName = "implicitSchemaName";
		columnName = "columnName";
		explicitType = "explicityType";

		registrationKeys = new String[] {};

		dialect = new Dialect() {
		};

		parameters = new HashMap<>();

		identifierHelper = new DummyIdentifierHelper();

		jdbcEnvironment = new DummyJdbcEnvironment();
		jdbcEnvironment.setIdentifierHelper(identifierHelper);

		jdbcServices = new DummyJdbcServices();
		jdbcServices.setDialect(dialect);

		standardServiceRegistry = new DummyStandardServiceRegistry();
		standardServiceRegistry.setService(JdbcEnvironment.class, jdbcEnvironment);
		standardServiceRegistry.setService(JdbcServices.class, jdbcServices);

		mappingDefaults = new DummyMappingDefaults();
		mappingDefaults.setImplicitCatalogName(implicitCatalogName);
		mappingDefaults.setImplicitSchemaName(implicitSchemaName);

		physicalNamingStrategy = new DummyPhysicalNamingStrategy();

		implicitNamingStrategy = new DummyImplicitNamingStrategy();
		implicitNamingStrategy.setBasicColumnNameDeterminer(new BasicColumnNameDeterminer() {
			@Override
			public Identifier determineBasicColumnName(ImplicitBasicColumnNameSource source) {
				return new Identifier(columnName, false);
			}
		});

		metadataBuildingOptions = new DummyMetadataBuildingOptions();
		metadataBuildingOptions.setServiceRegistry(standardServiceRegistry);
		metadataBuildingOptions.setMappingDefaults(mappingDefaults);
		metadataBuildingOptions.setPhysicalNamingStrategy(physicalNamingStrategy);
		metadataBuildingOptions.setImplicitNamingStrategy(implicitNamingStrategy);

		database = new Database(metadataBuildingOptions);

		typeResolver = new TypeResolver();

		typeDefinition = new TypeDefinition(explicitType, A.class, registrationKeys, parameters);

		inFlightMetadataCollector = new DummyInFlightMetadataCollector();
		inFlightMetadataCollector.setTypeDefinition(explicitType, typeDefinition);
		inFlightMetadataCollector.setDatabase(database);
		inFlightMetadataCollector.setTypeResolver(typeResolver);

		objectNameNormalizer = new DummyObjectNameNormalizer();

		classLoaderAccess = new DummyClassLoaderAccess();

		metadataBuildingContext = new DummyMetadataBuildingContext();
		metadataBuildingContext.setMetadataCollector(inFlightMetadataCollector);
		metadataBuildingContext.setBuildingOptions(metadataBuildingOptions);
		metadataBuildingContext.setClassLoaderAccess(classLoaderAccess);
		objectNameNormalizer.setMetadataBuildingContext(metadataBuildingContext);
		metadataBuildingContext.setObjectNameNormalizer(objectNameNormalizer);

		table = new Table();

		ejb3Column = new Ejb3Column();
		ejb3Column.setBuildingContext(metadataBuildingContext);
		ejb3Column.setTable(table);
		ejb3Column.bind();
		ejb3Column.getMappingColumn().setName(columnName);

		ejb3Columns = new Ejb3Column[] { ejb3Column };

		simpleValueBinder = new SimpleValueBinder();
		simpleValueBinder.setBuildingContext(metadataBuildingContext);
		simpleValueBinder.setColumns(ejb3Columns);
		simpleValueBinder.make();
		simpleValueBinder.setExplicitType(explicitType);

		persistentClasses = new HashMap<>();
	}

	@Test
	public void test() {

		SetSimpleValueTypeSecondPass setSimpleValueTypeSecondPass = new SetSimpleValueTypeSecondPass(simpleValueBinder);

		setSimpleValueTypeSecondPass.doSecondPass(persistentClasses);

	}
}

package dux.org.hibernate.tool.schema.internal;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.boot.model.relational.Namespace;
import org.hibernate.boot.model.relational.Namespace.Name;
import org.hibernate.boot.model.relational.Sequence;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.mapping.Table;
import org.hibernate.tool.schema.internal.DefaultSchemaFilter;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.boot.model.naming.DummyPhysicalNamingStrategy;
import dum.org.hibernate.boot.spi.DummyMappingDefaults;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.engine.jdbc.env.spi.DummyIdentifierHelper;
import dum.org.hibernate.engine.jdbc.env.spi.DummyJdbcEnvironment;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dux.org.hibernate.query.criteria.internal.DummyStandardServiceRegistry;

@Done
public class DefaultSchemaFilterTest extends AbstractTest {

	private Dialect dialect;
	private DummyIdentifierHelper identifierHelper;
	private DummyJdbcEnvironment jdbcEnvironment;
	private DummyJdbcServices jdbcServices;
	private DummyStandardServiceRegistry serviceRegistry;
	private DummyMappingDefaults mappingDefaults;
	private DummyPhysicalNamingStrategy physicalNamingStrategy;
	private DummyMetadataBuildingOptions buildingOptions;
	private Database database;
	private Namespace anyNamespace;
	private Table anyTable;
	private Sequence anySequence;

	@Before
	public void before() {
		dialect = new Dialect() {
		};

		identifierHelper = new DummyIdentifierHelper();

		jdbcEnvironment = new DummyJdbcEnvironment();
		jdbcEnvironment.setIdentifierHelper(identifierHelper);

		jdbcServices = new DummyJdbcServices();
		jdbcServices.setDialect(dialect);

		serviceRegistry = new DummyStandardServiceRegistry();
		serviceRegistry.setService(JdbcEnvironment.class, jdbcEnvironment);
		serviceRegistry.setService(JdbcServices.class, jdbcServices);

		mappingDefaults = new DummyMappingDefaults();
		mappingDefaults.setImplicitCatalogName("implicitCatalogName");
		mappingDefaults.setImplicitSchemaName("implicitSchemaName");

		physicalNamingStrategy = new DummyPhysicalNamingStrategy();

		buildingOptions = new DummyMetadataBuildingOptions();
		buildingOptions.setServiceRegistry(serviceRegistry);
		buildingOptions.setMappingDefaults(mappingDefaults);
		buildingOptions.setPhysicalNamingStrategy(physicalNamingStrategy);

		database = new Database(buildingOptions);

		anyNamespace = new Namespace(database,
				new Name(new Identifier("catalog", false), new Identifier("schema", false)));

		anyTable = new Table();

		anySequence = new Sequence(new Identifier("catalogName", false), new Identifier("schemaName", false),
				new Identifier("sequenceName", false));
	}

	@Test
	public void test() {

		DefaultSchemaFilter instance = DefaultSchemaFilter.INSTANCE;

		at(instance.includeNamespace(anyNamespace));
		at(instance.includeTable(anyTable));
		at(instance.includeSequence(anySequence));
	}
}

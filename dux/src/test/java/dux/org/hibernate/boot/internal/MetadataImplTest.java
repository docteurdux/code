package dux.org.hibernate.boot.internal;

import java.util.Map;
import java.util.UUID;

import org.hibernate.boot.internal.MetadataImpl;
import org.hibernate.boot.model.IdentifierGeneratorDefinition;
import org.hibernate.boot.model.TypeDefinition;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.boot.spi.MetadataBuildingOptions;
import org.hibernate.cfg.annotations.NamedEntityGraphDefinition;
import org.hibernate.cfg.annotations.NamedProcedureCallDefinition;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.ResultSetMappingDefinition;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.engine.spi.NamedQueryDefinition;
import org.hibernate.engine.spi.NamedSQLQueryDefinition;
import org.hibernate.id.factory.spi.MutableIdentifierGeneratorFactory;
import org.hibernate.mapping.Collection;
import org.hibernate.mapping.FetchProfile;
import org.hibernate.mapping.MappedSuperclass;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.type.TypeResolver;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dus.hibernate.core.HibernateCoreSummaryTest;

public class MetadataImplTest extends AbstractTest {
	@Before
	public void before() {
		requireSources(HibernateCoreSummaryTest.MVNNAME, MetadataImpl.class);
	}

	@Test
	public void test() {
		UUID uuid = null;
		MetadataBuildingOptions metadataBuildingOptions = null;
		TypeResolver typeResolver = null;
		MutableIdentifierGeneratorFactory identifierGeneratorFactory = null;
		Map<String, PersistentClass> entityBindingMap = null;
		Map<Class, MappedSuperclass> mappedSuperclassMap = null;
		Map<String, Collection> collectionBindingMap = null;
		Map<String, TypeDefinition> typeDefinitionMap = null;
		Map<String, FilterDefinition> filterDefinitionMap = null;
		Map<String, FetchProfile> fetchProfileMap = null;
		Map<String, String> imports = null;
		Map<String, IdentifierGeneratorDefinition> idGeneratorDefinitionMap = null;
		Map<String, NamedQueryDefinition> namedQueryMap = null;
		Map<String, NamedSQLQueryDefinition> namedNativeQueryMap = null;
		Map<String, NamedProcedureCallDefinition> namedProcedureCallMap = null;
		Map<String, ResultSetMappingDefinition> sqlResultSetMappingMap = null;
		Map<String, NamedEntityGraphDefinition> namedEntityGraphMap = null;
		Map<String, SQLFunction> sqlFunctionMap = null;
		Database database = null;
		MetadataImpl mi = new MetadataImpl(uuid, metadataBuildingOptions, typeResolver, identifierGeneratorFactory,
				entityBindingMap, mappedSuperclassMap, collectionBindingMap, typeDefinitionMap, filterDefinitionMap,
				fetchProfileMap, imports, idGeneratorDefinitionMap, namedQueryMap, namedNativeQueryMap,
				namedProcedureCallMap, sqlResultSetMappingMap, namedEntityGraphMap, sqlFunctionMap, database);
	}
}

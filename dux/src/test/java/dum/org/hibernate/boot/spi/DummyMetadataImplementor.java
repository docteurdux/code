package dum.org.hibernate.boot.spi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.model.IdentifierGeneratorDefinition;
import org.hibernate.boot.model.TypeDefinition;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.boot.spi.MetadataBuildingOptions;
import org.hibernate.boot.spi.MetadataImplementor;
import org.hibernate.cfg.annotations.NamedEntityGraphDefinition;
import org.hibernate.cfg.annotations.NamedProcedureCallDefinition;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.ResultSetMappingDefinition;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.engine.spi.NamedQueryDefinition;
import org.hibernate.engine.spi.NamedSQLQueryDefinition;
import org.hibernate.id.factory.IdentifierGeneratorFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.mapping.FetchProfile;
import org.hibernate.mapping.MappedSuperclass;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Table;
import org.hibernate.query.spi.NamedQueryRepository;
import org.hibernate.type.Type;
import org.hibernate.type.TypeResolver;

public class DummyMetadataImplementor implements MetadataImplementor {

	private Database database;
	private TypeResolver typeResolver;
	private Map<String, FilterDefinition> filterDefinitions = new HashMap<>();
	private List<PersistentClass> entityBindings = new ArrayList<>();
	private Map<String, String> imports = new HashMap<>();
	private List<org.hibernate.mapping.Collection> collectionBindings = new ArrayList<>();
	private Set<MappedSuperclass> mappedSuperclassMappingsCopy = new HashSet<>();
	private Map<String, NamedEntityGraphDefinition> namedEntityGraphs = new HashMap<>();
	private List<FetchProfile> fetchProfiles = new ArrayList<>();

	@Override
	public SessionFactoryBuilder getSessionFactoryBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionFactory buildSessionFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UUID getUUID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	@Override
	public Collection<PersistentClass> getEntityBindings() {
		return entityBindings;
	}

	@Override
	public PersistentClass getEntityBinding(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<org.hibernate.mapping.Collection> getCollectionBindings() {
		return collectionBindings;
	}

	@Override
	public org.hibernate.mapping.Collection getCollectionBinding(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getImports() {
		return imports;
	}

	@Override
	public NamedQueryDefinition getNamedQueryDefinition(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<NamedQueryDefinition> getNamedQueryDefinitions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamedSQLQueryDefinition getNamedNativeQueryDefinition(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<NamedSQLQueryDefinition> getNamedNativeQueryDefinitions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<NamedProcedureCallDefinition> getNamedProcedureCallDefinitions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultSetMappingDefinition getResultSetMapping(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, ResultSetMappingDefinition> getResultSetMappingDefinitions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeDefinition getTypeDefinition(String typeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, FilterDefinition> getFilterDefinitions() {
		return filterDefinitions;
	}

	@Override
	public FilterDefinition getFilterDefinition(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FetchProfile getFetchProfile(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<FetchProfile> getFetchProfiles() {
		return fetchProfiles;
	}

	@Override
	public NamedEntityGraphDefinition getNamedEntityGraph(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, NamedEntityGraphDefinition> getNamedEntityGraphs() {
		return namedEntityGraphs;
	}

	@Override
	public IdentifierGeneratorDefinition getIdentifierGenerator(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Table> collectTableMappings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, SQLFunction> getSqlFunctionMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IdentifierGeneratorFactory getIdentifierGeneratorFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getIdentifierType(String className) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getIdentifierPropertyName(String className) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getReferencedPropertyType(String className, String propertyName) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MetadataBuildingOptions getMetadataBuildingOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TypeResolver getTypeResolver() {
		return typeResolver;
	}

	public void setTypeResolver(TypeResolver typeResolver) {
		this.typeResolver = typeResolver;
	}

	@Override
	public NamedQueryRepository buildNamedQueryRepository(SessionFactoryImpl sessionFactory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validate() throws MappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<MappedSuperclass> getMappedSuperclassMappingsCopy() {
		return mappedSuperclassMappingsCopy;
	}

}

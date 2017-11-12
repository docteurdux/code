package dum.org.hibernate.boot.spi;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.persistence.AttributeConverter;

import org.hibernate.DuplicateMappingException;
import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.boot.SessionFactoryBuilder;
import org.hibernate.boot.internal.ClassmateContext;
import org.hibernate.boot.model.IdentifierGeneratorDefinition;
import org.hibernate.boot.model.TypeDefinition;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.relational.AuxiliaryDatabaseObject;
import org.hibernate.boot.model.relational.Database;
import org.hibernate.boot.spi.AttributeConverterAutoApplyHandler;
import org.hibernate.boot.spi.InFlightMetadataCollector;
import org.hibernate.boot.spi.MetadataBuildingOptions;
import org.hibernate.boot.spi.NaturalIdUniqueKeyBinder;
import org.hibernate.cfg.AnnotatedClassType;
import org.hibernate.cfg.AttributeConverterDefinition;
import org.hibernate.cfg.JPAIndexHolder;
import org.hibernate.cfg.PropertyData;
import org.hibernate.cfg.SecondPass;
import org.hibernate.cfg.UniqueConstraintHolder;
import org.hibernate.cfg.annotations.NamedEntityGraphDefinition;
import org.hibernate.cfg.annotations.NamedProcedureCallDefinition;
import org.hibernate.dialect.function.SQLFunction;
import org.hibernate.engine.ResultSetMappingDefinition;
import org.hibernate.engine.spi.FilterDefinition;
import org.hibernate.engine.spi.NamedQueryDefinition;
import org.hibernate.engine.spi.NamedSQLQueryDefinition;
import org.hibernate.id.factory.IdentifierGeneratorFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.FetchProfile;
import org.hibernate.mapping.Join;
import org.hibernate.mapping.MappedSuperclass;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.mapping.Table;
import org.hibernate.query.spi.NamedQueryRepository;
import org.hibernate.type.Type;
import org.hibernate.type.TypeResolver;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyInFlightMetadataCollector extends TestEventCollector implements InFlightMetadataCollector {

	private Map<String, TypeDefinition> typeDefinitions = new HashMap<>();
	private Database database;
	private TypeResolver typeResolver;

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
		// TODO Auto-generated method stub
		return null;
	}

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
	public Collection<PersistentClass> getEntityBindings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentClass getEntityBinding(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<org.hibernate.mapping.Collection> getCollectionBindings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public org.hibernate.mapping.Collection getCollectionBinding(String role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, String> getImports() {
		// TODO Auto-generated method stub
		return null;
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
		return typeDefinitions.get(typeName);
	}

	public void setTypeDefinition(String typeName, TypeDefinition typeDefinition) {
		typeDefinitions.put(typeName, typeDefinition);
	}

	@Override
	public Map<String, FilterDefinition> getFilterDefinitions() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NamedEntityGraphDefinition getNamedEntityGraph(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, NamedEntityGraphDefinition> getNamedEntityGraphs() {
		// TODO Auto-generated method stub
		return null;
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
	public void addEntityBinding(PersistentClass persistentClass) throws DuplicateMappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, PersistentClass> getEntityBindingMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addImport(String entityName, String rename) throws DuplicateMappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCollectionBinding(org.hibernate.mapping.Collection collection) throws DuplicateMappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public Table addTable(String schema, String catalog, String name, String subselect, boolean isAbstract) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Table addDenormalizedTable(String schema, String catalog, String name, boolean isAbstract, String subselect,
			Table includedTable) throws DuplicateMappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addNamedQuery(NamedQueryDefinition query) throws DuplicateMappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNamedNativeQuery(NamedSQLQueryDefinition query) throws DuplicateMappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addResultSetMapping(ResultSetMappingDefinition sqlResultSetMapping) throws DuplicateMappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNamedProcedureCallDefinition(NamedProcedureCallDefinition definition)
			throws DuplicateMappingException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNamedEntityGraph(NamedEntityGraphDefinition namedEntityGraphDefinition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTypeDefinition(TypeDefinition typeDefinition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFilterDefinition(FilterDefinition definition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAuxiliaryDatabaseObject(AuxiliaryDatabaseObject auxiliaryDatabaseObject) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addFetchProfile(FetchProfile profile) {
		// TODO Auto-generated method stub

	}

	@Override
	public TypeResolver getTypeResolver() {
		return typeResolver;
	}

	public void setTypeResolver(TypeResolver typeResolver) {
		this.typeResolver = typeResolver;
	}

	@Override
	public Database getDatabase() {
		return database;
	}

	public void setDatabase(Database database) {
		this.database = database;
	}

	@Override
	public void addIdentifierGenerator(IdentifierGeneratorDefinition generatorDefinition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAttributeConverter(AttributeConverterDefinition converter) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAttributeConverter(Class<? extends AttributeConverter> converterClass) {
		// TODO Auto-generated method stub

	}

	@Override
	public AttributeConverterAutoApplyHandler getAttributeConverterAutoApplyHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSecondPass(SecondPass secondPass) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addSecondPass(SecondPass sp, boolean onTopOfTheQueue) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableNameBinding(Identifier logicalName, Table table) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTableNameBinding(String schema, String catalog, String logicalName, String realTableName,
			Table denormalizedSuperTable) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getLogicalTableName(Table ownerTable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPhysicalTableName(Identifier logicalName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPhysicalTableName(String logicalName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addColumnNameBinding(Table table, Identifier logicalColumnName, Column column) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addColumnNameBinding(Table table, String logicalColumnName, Column column) {
		testEvents.add(new TestEvent("addColumnNameBinding").prop("table", table)
				.prop("logicalColumnName", logicalColumnName).prop("column", column));
	}

	@Override
	public String getPhysicalColumnName(Table table, Identifier logicalName) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPhysicalColumnName(Table table, String logicalName) throws MappingException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLogicalColumnName(Table table, Identifier physicalName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLogicalColumnName(Table table, String physicalName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDefaultIdentifierGenerator(IdentifierGeneratorDefinition generatorDefinition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDefaultQuery(NamedQueryDefinition queryDefinition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDefaultNamedNativeQuery(NamedSQLQueryDefinition query) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDefaultResultSetMapping(ResultSetMappingDefinition definition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDefaultNamedProcedureCallDefinition(NamedProcedureCallDefinition procedureCallDefinition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAnyMetaDef(AnyMetaDef defAnn) {
		// TODO Auto-generated method stub

	}

	@Override
	public AnyMetaDef getAnyMetaDef(String anyMetaDefName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnotatedClassType addClassType(XClass clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AnnotatedClassType getClassType(XClass clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMappedSuperclass(Class type, MappedSuperclass mappedSuperclass) {
		// TODO Auto-generated method stub

	}

	@Override
	public MappedSuperclass getMappedSuperclass(Class type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyData getPropertyAnnotatedWithMapsId(XClass persistentXClass, String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPropertyAnnotatedWithMapsId(XClass entity, PropertyData propertyAnnotatedElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPropertyAnnotatedWithMapsIdSpecj(XClass entity, PropertyData specJPropertyData, String s) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addToOneAndIdProperty(XClass entity, PropertyData propertyAnnotatedElement) {
		// TODO Auto-generated method stub

	}

	@Override
	public PropertyData getPropertyAnnotatedWithIdAndToOne(XClass persistentXClass, String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isInSecondPass() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NaturalIdUniqueKeyBinder locateNaturalIdUniqueKeyBinder(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void registerNaturalIdUniqueKeyBinder(String entityName, NaturalIdUniqueKeyBinder ukBinder) {
		// TODO Auto-generated method stub

	}

	@Override
	public ClassmateContext getClassmateContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDelayedPropertyReferenceHandler(DelayedPropertyReferenceHandler handler) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPropertyReference(String entityName, String propertyName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addUniquePropertyReference(String entityName, String propertyName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPropertyReferencedAssociation(String s, String propertyName, String syntheticPropertyName) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getPropertyReferencedAssociation(String entityName, String mappedBy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addMappedBy(String name, String mappedBy, String propertyName) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getFromMappedBy(String ownerEntityName, String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUniqueConstraints(Table table, List uniqueConstraints) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addUniqueConstraintHolders(Table table, List<UniqueConstraintHolder> uniqueConstraints) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addJpaIndexHolders(Table table, List<JPAIndexHolder> jpaIndexHolders) {
		// TODO Auto-generated method stub

	}

	@Override
	public EntityTableXref getEntityTableXref(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityTableXref addEntityTableXref(String entityName, Identifier primaryTableLogicalName, Table primaryTable,
			EntityTableXref superEntityTableXref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Join> getJoins(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

}

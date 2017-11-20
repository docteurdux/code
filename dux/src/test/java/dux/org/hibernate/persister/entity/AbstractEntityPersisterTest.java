package dux.org.hibernate.persister.entity;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.hibernate.CacheMode;
import org.hibernate.cfg.Settings;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.loader.BatchFetchStyle;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.DummyPersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.RootClass;
import org.hibernate.mapping.Selectable;
import org.hibernate.mapping.Subclass;
import org.hibernate.mapping.Table;
import org.hibernate.property.access.spi.PropertyAccess;
import org.hibernate.property.access.spi.PropertyAccessStrategy;
import org.hibernate.property.access.spi.PropertyAccessStrategyResolver;
import org.hibernate.tuple.entity.EntityTuplizerFactory;
import org.hibernate.type.TypeResolver;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;

import dum.java.sql.DummyPreparedStatement;
import dum.java.sql.DummyResultSet;
import dum.org.hibernate.boot.spi.DummyClassLoaderAccess;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.boot.spi.DummySessionFactoryOptions;
import dum.org.hibernate.cache.spi.access.DummyEntityRegionAccessStrategy;
import dum.org.hibernate.cache.spi.access.DummyNaturalIdRegionAccessStrategy;
import dum.org.hibernate.engine.jdbc.env.spi.DummyJdbcEnvironment;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcCoordinator;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.jdbc.spi.DummyResultSetReturn;
import dum.org.hibernate.engine.jdbc.spi.DummyStatementPreparer;
import dum.org.hibernate.engine.spi.DummyEntityEntry;
import dum.org.hibernate.engine.spi.DummyPersistenceContext;
import dum.org.hibernate.engine.spi.DummyPersistentAttributeInterceptable;
import dum.org.hibernate.engine.spi.DummyPersistentAttributeInterceptor;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.engine.spi.DummySharedSessionContractImplementor;
import dum.org.hibernate.id.DummyIdentifierGenerator;
import dum.org.hibernate.mapping.DummyKeyValue;
import dum.org.hibernate.mapping.DummyValue;
import dum.org.hibernate.metamodel.spi.DummyMetamodelImplementor;
import dum.org.hibernate.persister.entity.DummyAbstractEntityPersister;
import dum.org.hibernate.persister.entity.DummyEntityPersister;
import dum.org.hibernate.persister.spi.DummyPersisterCreationContext;
import dum.org.hibernate.property.access.spi.DummyGetter;
import dum.org.hibernate.property.access.spi.DummyPropertyAccess;
import dum.org.hibernate.property.access.spi.DummyPropertyAccessStrategyResolver;
import dum.org.hibernate.property.access.spi.DummySetter;
import dum.org.hibernate.resource.jdbc.DummyResourceRegistry;
import dum.org.hibernate.resource.jdbc.spi.DummyLogicalConnectionImplementor;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;
import dum.org.hibernate.type.DummyType;
import dux.org.hibernate.property.access.internal.DummyPropertyAccessStrategy;
import dux.org.hibernate.query.criteria.internal.DummyStandardServiceRegistry;

@SuppressWarnings("deprecation")
public class AbstractEntityPersisterTest extends AbstractTest {

	public static class A extends DummyPersistentAttributeInterceptable {

		String foo;

		public String getFoo() {
			return foo;
		}

		public void setFoo(String foo) {
			this.foo = foo;
		}

	}

	private DummyMetadataBuildingContext metadataBuildingContext;
	private RootClass rootClass;
	private String entityName;
	private String sublassEntityName;
	private DummyPersistentClass persistentClass;
	private Table table;
	private DummyKeyValue keyValue;
	private DummyEntityRegionAccessStrategy entityRegionAccessStrategy;
	private DummyNaturalIdRegionAccessStrategy naturalIdRegionAccessStrategy;
	private DummyPersisterCreationContext persisterCreationContext;
	private DummySessionFactoryImplementor sessionFactoryImplementor;
	private DummySessionFactoryOptions sessionFactoryOptions;
	private DummyServiceRegistryImplementor serviceRegistryImplementor;
	private DummyJdbcServices jdbcServices;
	private Dialect dialect;
	private DummyJdbcEnvironment jdbcEnvironment;
	private EntityTuplizerFactory entityTuplizerFactory;
	private Settings settings;
	private Column column;
	private ArrayList<Selectable> columns;
	private String rowId;
	private String columnName;
	private ArrayList<Object> propertyClosure;
	private Property property;
	private DummyClassLoaderAccess classLoaderAccess;
	private DummySetter setter;
	private DummyGetter getter;
	private DummyPropertyAccess propertyAccess;
	private DummyPropertyAccessStrategy propertyAccessStrategy;
	private RunnableWithArgs<PropertyAccess> buildPropertyAccessRWA;
	private RunnableWithArgs<PropertyAccessStrategy> resolvePropertyAccessStrategyRWA;
	private DummyPropertyAccessStrategyResolver propertyAccessStrategyResolver;
	private DummyStandardServiceRegistry standardServiceRegistry;
	private DummyMetadataBuildingOptions metadataBuildingOptions;
	private DummyType type;
	private DummyValue value;
	private Subclass subclass;
	private RunnableWithArgs<String[]> getSubclassTableKeyColumnsRWA;
	private RunnableWithArgs<String> getTableNameRWA;
	private DummyPersistentAttributeInterceptor persistentAttributeInterceptor;
	private DummyPersistentAttributeInterceptable persistentAttributeInterceptable;
	private DummyEntityEntry entityEntry;
	private DummyPersistenceContext persistenceContext;
	private DummySharedSessionContractImplementor sharedSessionContractImplementor;
	private RunnableWithArgs<Serializable> getContextEntityIdentifierRWA;
	private CacheMode cacheMode;
	private DummyPreparedStatement preparedStatement;
	private DummyStatementPreparer statementPreparer;
	private RunnableWithArgs<PreparedStatement> prepareStatementRWA;
	private DummyResultSet resultSet;
	private DummyResultSetReturn resultSetReturn;
	private RunnableWithArgs<ResultSet> extractRWA;
	private DummyResourceRegistry resourceRegistry;
	private DummyLogicalConnectionImplementor logicalConnectionImplementor;
	private DummyJdbcCoordinator jdbcCoordinator;
	private DummyEntityPersister entityPersister;
	private DummyMetamodelImplementor metamodelImplementor;
	private TypeResolver typeResolver;
	private DummyIdentifierGenerator identifierGenerator;
	private RunnableWithArgs<IdentifierGenerator> identifierGeneratorRWA;
	private RunnableWithArgs<String[]> getIdentifierAliasesRWA;
	private Serializable id;
	private String tableName;
	private BatchFetchStyle batchFetchStyle;

	@Before
	public void before() {

		entityName = "entityName";
		sublassEntityName = "sublassEntityName";
		rowId = "rowId";
		columnName = "columnName";

		classLoaderAccess = new DummyClassLoaderAccess();
		classLoaderAccess.setClass("className", A.class);

		setter = new DummySetter();
		getter = new DummyGetter();

		propertyAccess = new DummyPropertyAccess();
		propertyAccess.setSetter(setter);
		propertyAccess.setGetter(getter);

		buildPropertyAccessRWA = new RunnableWithArgs<PropertyAccess>() {
			@Override
			public PropertyAccess run(Object... args) {
				return propertyAccess;
			}
		};

		propertyAccessStrategy = new DummyPropertyAccessStrategy();
		propertyAccess.setPropertyAccessStrategy(propertyAccessStrategy);
		propertyAccessStrategy.setBuildPropertyAccessRWA(buildPropertyAccessRWA);

		resolvePropertyAccessStrategyRWA = new RunnableWithArgs<PropertyAccessStrategy>() {
			@Override
			public PropertyAccessStrategy run(Object... args) {
				return propertyAccessStrategy;
			}
		};

		propertyAccessStrategyResolver = new DummyPropertyAccessStrategyResolver();
		propertyAccessStrategyResolver.setResolvePropertyAccessStrategyRWA(resolvePropertyAccessStrategyRWA);

		standardServiceRegistry = new DummyStandardServiceRegistry();
		standardServiceRegistry.setService(PropertyAccessStrategyResolver.class, propertyAccessStrategyResolver);

		metadataBuildingOptions = new DummyMetadataBuildingOptions();
		metadataBuildingOptions.setServiceRegistry(standardServiceRegistry);

		metadataBuildingContext = new DummyMetadataBuildingContext();
		metadataBuildingContext.setClassLoaderAccess(classLoaderAccess);
		metadataBuildingContext.setBuildingOptions(metadataBuildingOptions);

		rootClass = new RootClass(metadataBuildingContext);
		rootClass.setEntityName(entityName);

		table = new Table();
		table.setRowId(rowId);

		column = new Column(columnName);

		columns = new ArrayList<Selectable>();
		columns.add(column);

		type = new DummyType();

		keyValue = new DummyKeyValue();
		keyValue.setColumnIterator(columns.iterator());
		keyValue.setColumnSpan(1);
		keyValue.setType(type);

		value = new DummyValue();
		value.setType(type);
		value.getColumns().add(column);
		value.setTable(table);

		property = new Property();
		property.setValue(value);
		property.setLazy(true);
		property.setName("foo");

		propertyClosure = new ArrayList<>();
		propertyClosure.add(property);

		persistentClass = new DummyPersistentClass(metadataBuildingContext);
		persistentClass.setRootClass(rootClass);
		persistentClass.setRootTable(table);
		persistentClass.setIdentifier(keyValue);
		persistentClass.addProperty(property);
		persistentClass.setClassName("className");
		persistentClass.getServiceRegistry();
		persistentClass.setEntityName(entityName);

		subclass = new Subclass(persistentClass, metadataBuildingContext);
		subclass.setEntityName(sublassEntityName);
		persistentClass.addSubclass(subclass);

		entityRegionAccessStrategy = new DummyEntityRegionAccessStrategy();

		naturalIdRegionAccessStrategy = new DummyNaturalIdRegionAccessStrategy();

		sessionFactoryOptions = new DummySessionFactoryOptions();

		dialect = new Dialect() {
		};

		jdbcEnvironment = new DummyJdbcEnvironment();
		jdbcEnvironment.setDialect(dialect);

		jdbcServices = new DummyJdbcServices();
		jdbcServices.setJdbcEnvironment(jdbcEnvironment);

		serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JdbcServices.class, jdbcServices);

		batchFetchStyle = BatchFetchStyle.PADDED;

		entityTuplizerFactory = new EntityTuplizerFactory();

		sessionFactoryOptions.setEntityTuplizerFactory(entityTuplizerFactory);
		sessionFactoryOptions.setBatchFetchStyle(batchFetchStyle);

		settings = new Settings(sessionFactoryOptions);

		identifierGenerator = new DummyIdentifierGenerator();

		typeResolver = new TypeResolver();

		identifierGeneratorRWA = new RunnableWithArgs<IdentifierGenerator>() {
			@Override
			public IdentifierGenerator run(Object... args) {
				return identifierGenerator;
			}
		};

		getIdentifierAliasesRWA = new RunnableWithArgs<String[]>() {
			@Override
			public String[] run(Object... args) {
				return new String[] {};
			}
		};

		getSubclassTableKeyColumnsRWA = new RunnableWithArgs<String[]>() {
			@Override
			public String[] run(Object... args) {
				return new String[] {};
			}
		};

		tableName = "tableName";

		getTableNameRWA = new RunnableWithArgs<String>() {
			@Override
			public String run(Object... args) {
				return tableName;
			}
		};
		persistentAttributeInterceptor = new DummyPersistentAttributeInterceptor();

		persistentAttributeInterceptable = new DummyPersistentAttributeInterceptable();
		persistentAttributeInterceptable.$$_hibernate_setInterceptor(persistentAttributeInterceptor);

		entityEntry = new DummyEntityEntry();

		persistenceContext = new DummyPersistenceContext();
		persistenceContext.setEntry(persistentAttributeInterceptable, entityEntry);

		id = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		getContextEntityIdentifierRWA = new RunnableWithArgs<Serializable>() {
			@Override
			public Serializable run(Object... args) {
				return id;
			}
		};

		cacheMode = CacheMode.NORMAL;

		preparedStatement = new DummyPreparedStatement();

		prepareStatementRWA = new RunnableWithArgs<PreparedStatement>() {
			@Override
			public PreparedStatement run(Object... args) {

				return preparedStatement;
			}
		};

		statementPreparer = new DummyStatementPreparer();
		statementPreparer.setPrepareStatementRWA(prepareStatementRWA);

		resultSet = new DummyResultSet();
		extractRWA = new RunnableWithArgs<ResultSet>() {
			@Override
			public ResultSet run(Object... args) {
				return resultSet;
			}
		};

		resultSetReturn = new DummyResultSetReturn();
		resultSetReturn.setExtractRWA(extractRWA);

		resourceRegistry = new DummyResourceRegistry();

		logicalConnectionImplementor = new DummyLogicalConnectionImplementor();
		logicalConnectionImplementor.setResourceRegistry(resourceRegistry);

		jdbcCoordinator = new DummyJdbcCoordinator();
		jdbcCoordinator.setStatementPreparer(statementPreparer);
		jdbcCoordinator.setResultSetReturn(resultSetReturn);
		jdbcCoordinator.setLogicalConnectionImplementor(logicalConnectionImplementor);

		sharedSessionContractImplementor = new DummySharedSessionContractImplementor();
		sharedSessionContractImplementor.setJdbcCoordinator(jdbcCoordinator);
		sharedSessionContractImplementor.setPersistenceContext(persistenceContext);
		sharedSessionContractImplementor.setGetContextEntityIdentifierRWA(getContextEntityIdentifierRWA);
		sharedSessionContractImplementor.setCacheMode(cacheMode);

		sessionFactoryImplementor = new DummySessionFactoryImplementor();
		sessionFactoryImplementor.setServiceRegistry(serviceRegistryImplementor);
		sessionFactoryImplementor.setSettings(settings);
		sessionFactoryImplementor.setSessionFactoryOptions(sessionFactoryOptions);

		sessionFactoryImplementor.setIdentifierGeneratorRWA(identifierGeneratorRWA);
		sessionFactoryImplementor.setTypeResolver(typeResolver);

		persisterCreationContext = new DummyPersisterCreationContext();
		persisterCreationContext.setSessionFactory(sessionFactoryImplementor);

		entityPersister = new DummyEntityPersister();
		entityPersister.consumesEntityAlias(true);
		entityPersister.setIdentifierType(type);
		entityPersister.setFactory(sessionFactoryImplementor);
		entityPersister.setGetIdentifierAliasesRWA(getIdentifierAliasesRWA);
		entityPersister.setPropertyNames(new String[] {});

		metamodelImplementor = new DummyMetamodelImplementor();
		metamodelImplementor.entityPersisters().put(entityName, entityPersister);
		sessionFactoryImplementor.setMetamodel(metamodelImplementor);
	}

	@Test
	public void test() {

		DummyAbstractEntityPersister a = new DummyAbstractEntityPersister(persistentClass, entityRegionAccessStrategy,
				naturalIdRegionAccessStrategy, persisterCreationContext);
		a.setGetSubclassTableKeyColumnsRWA(getSubclassTableKeyColumnsRWA);
		a.setSubclassColumnTableNumberClosure(new int[] { 1 });
		a.setGetTableNameRWA(getTableNameRWA);

		aeq("clazz_", a.getDiscriminatorColumnName());
		aeq("clazz_", a.getDiscriminatorColumnReaders());
		aeq("clazz_", a.getDiscriminatorColumnReaderTemplate());

		aeq(true, a.isSubclassEntityName(entityName));
		aeq(true, a.isSubclassEntityName(sublassEntityName));

		aeq(1, a.getRootTableKeyColumnNames().length);
		aeq(columnName, a.getRootTableKeyColumnNames()[0]);

		aeq(true, a.hasRowId());

		a.postInstantiate();

		a.initializeLazyProperty("foo", persistentAttributeInterceptable, sharedSessionContractImplementor);

		aeq(false, a.hasSequentialSelect());
		aeq(false, a.isBatchable());

		aeq(null, a.getQuerySpaces());

		aeq(false, a.isBatchLoadable());

		aeq(1, a.getIdentifierColumnReaders().length);
		aeq("columnName", a.getIdentifierColumnReaders()[0]);

		aeq(1, a.getIdentifierColumnReaderTemplates().length);
		aeq("$PlaceHolder$.columnName", a.getIdentifierColumnReaderTemplates()[0]);

		aeq(null, a.getVersionColumnName());

		aeq(false, a.isCacheInvalidationRequired());

		aeq(1, a.getIdentifierAliases("suffix").length);
		aeq("columnNa0_0_suffix", a.getIdentifierAliases("suffix")[0]);

		aeq(1, a.getPropertyAliases("suffix", 0).length);
		aeq("columnNa0_0_suffix", a.getPropertyAliases("suffix", 0)[0]);

		aeq("clazz_suffix", a.getDiscriminatorAlias("suffix"));

		a.getDatabaseSnapshot(id, sharedSessionContractImplementor);

		a.getIdByUniqueKey(id, "foo", sharedSessionContractImplementor);

		// Object currentVersion = new Object();
		// a.forceVersionIncrement(id, currentVersion,
		// sharedSessionContractImplementor);

//		a.loadByUniqueKey("foo", new Object(), sharedSessionContractImplementor);

	}
}

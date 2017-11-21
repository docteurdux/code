package dux.org.hibernate.cfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.TableGenerator;

import org.hibernate.FetchMode;
import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.boot.model.IdentifierGeneratorDefinition;
import org.hibernate.boot.model.IdentifierGeneratorDefinition.Builder;
import org.hibernate.cfg.AccessType;
import org.hibernate.cfg.AnnotationBinder;
import org.hibernate.cfg.InheritanceState;
import org.hibernate.cfg.annotations.EntityBinder;
import org.hibernate.cfg.annotations.NamedProcedureCallDefinition;
import org.hibernate.cfg.annotations.ResultsetMappingSecondPass;
import org.hibernate.engine.spi.NamedQueryDefinition;
import org.hibernate.engine.spi.NamedSQLQueryDefinition;
import org.hibernate.mapping.DummyPersistentClass;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.RunnableWithArgs;
import com.github.docteurdux.test.TEI;

import dum.org.hibernate.annotations.common.reflection.DummyReflectionManager;
import dum.org.hibernate.annotations.common.reflection.DummyXClass;
import dum.org.hibernate.boot.model.DummyIdGeneratorStrategyInterpreter;
import dum.org.hibernate.boot.spi.DummyInFlightMetadataCollector;
import dum.org.hibernate.boot.spi.DummyMappingDefaults;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.cfg.DummyPropertyData;
import dum.org.hibernate.cfg.DummyPropertyHolder;

public class AnnotationBinderTest extends AbstractTest {

	@Entity
	@SequenceGenerator(name = "sequenceGeneratorName")
	@TableGenerator(name = "tableGenerator")
	@NamedQuery(name = "namedQuery", query = "query")
	@NamedNativeQuery(name = "namedQuery", query = "query")
	@SqlResultSetMapping(name = "sqlResultSetMapping")
	@NamedStoredProcedureQuery(name = "namedStoredProcedureQuery1", procedureName = "procedureName1")
	@NamedStoredProcedureQueries(value = @NamedStoredProcedureQuery(name = "namedStoredProcedureQuery2", procedureName = "procedureName2"))
	@SuppressWarnings("deprecation")
	@org.hibernate.annotations.Entity
	public static class A {

	}

	private DummyXClass xClass;
	private DummyMetadataBuildingContext metadataBuildingContext;
	private String packageName;
	private List<XClass> orderedClasses;
	private DummyPropertyHolder propertyHolder;
	private DummyPropertyData propertyData1;
	private DummyPropertyData propertyData2;
	private boolean isComponentEmbedded;
	private boolean isIdentifierMapper;
	private boolean isNullable;
	private boolean inSecondPass;
	private AccessType accessType;
	private Map<XClass, InheritanceState> inheritanceStatePerClass;
	private Entity entityAnnotation;
	@SuppressWarnings("deprecation")
	private org.hibernate.annotations.Entity entityAnnotationHibernate;
	private DummyPersistentClass persistentClass;
	private EntityBinder entityBinder;
	private DummyMetadataBuildingOptions metadataBuildingOptions;
	private DummyReflectionManager reflectionManager;
	private DummyMappingDefaults mappingDefaults;
	private DummyIdGeneratorStrategyInterpreter idGeneratorStrategyInterpreter;
	private DummyInFlightMetadataCollector inFlightMetadataCollector;
	private SequenceGenerator sequenceGenerator;

	public AnnotationBinderTest() {
		sequenceGenerator = getAnnotation(A.class, SequenceGenerator.class);
	}

	@Before
	@SuppressWarnings({ "deprecation" })
	public void before() {

		reflectionManager = new DummyReflectionManager();

		idGeneratorStrategyInterpreter = new DummyIdGeneratorStrategyInterpreter();
		idGeneratorStrategyInterpreter.setInterpretSequenceGeneratorRWA(new RunnableWithArgs<Void>() {
			@Override
			public Void run(Object... args) {
				((Builder) args[1]).setName(((SequenceGenerator) args[0]).name());
				return null;
			}
		});
		idGeneratorStrategyInterpreter.setInterpretTableGeneratorRWA(new RunnableWithArgs<Void>() {
			@Override
			public Void run(Object... args) {
				((Builder) args[1]).setName(((TableGenerator) args[0]).name());
				return null;
			}
		});

		metadataBuildingOptions = new DummyMetadataBuildingOptions();
		metadataBuildingOptions.setReflectionManager(reflectionManager);
		metadataBuildingOptions.setIdGenerationTypeInterpreter(idGeneratorStrategyInterpreter);

		mappingDefaults = new DummyMappingDefaults();
		mappingDefaults.setImplicitSchemaName("implicitSchemaName");
		mappingDefaults.setImplicitCatalogName("implicitCatalogName");

		inFlightMetadataCollector = new DummyInFlightMetadataCollector();

		metadataBuildingContext = new DummyMetadataBuildingContext();
		metadataBuildingContext.setBuildingOptions(metadataBuildingOptions);
		metadataBuildingContext.setMappingDefaults(mappingDefaults);
		metadataBuildingContext.setMetadataCollector(inFlightMetadataCollector);

		if (t()) {
			return;
		}
		xClass = new DummyXClass();
		packageName = "packageName";
		orderedClasses = new ArrayList<>();
		propertyHolder = new DummyPropertyHolder();
		propertyData1 = new DummyPropertyData();
		propertyData2 = new DummyPropertyData();
		isComponentEmbedded = false;
		isIdentifierMapper = false;
		isNullable = false;
		inSecondPass = false;
		accessType = AccessType.DEFAULT;
		inheritanceStatePerClass = new HashMap<>();
		entityAnnotation = getAnnotation(A.class, Entity.class);
		entityAnnotationHibernate = getAnnotation(A.class, org.hibernate.annotations.Entity.class);
		persistentClass = new DummyPersistentClass(metadataBuildingContext);
		entityBinder = new EntityBinder(entityAnnotation, entityAnnotationHibernate, xClass, persistentClass,
				metadataBuildingContext);
	}

	@Test
	public void test1() {

		aeq(FetchMode.JOIN, AnnotationBinder.getFetchMode(FetchType.EAGER));
		aeq(FetchMode.SELECT, AnnotationBinder.getFetchMode(FetchType.LAZY));
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test2() {

		reflectionManager.getDefaults().put(SequenceGenerator.class,
				Arrays.asList(new SequenceGenerator[] { sequenceGenerator }));

		AnnotationBinder.bindDefaults(metadataBuildingContext);

		ate(idGeneratorStrategyInterpreter, new TEI[] {

				new TEI("interpretSequenceGenerator") {
					@Override
					protected void i(Map<String, Object> p) {
						aeqr(sequenceGenerator, p.get("sequenceGeneratorAnnotation"));
					}
				}

		});

		ate(inFlightMetadataCollector, new TEI[] {

				new TEI("addDefaultIdentifierGenerator") {
					@Override
					protected void i(Map<String, Object> props) {
						IdentifierGeneratorDefinition identifierGeneratorDefinition = (IdentifierGeneratorDefinition) props
								.get("generatorDefinition");
						aeq("sequenceGeneratorName", identifierGeneratorDefinition.getName());
					}
				}

		});

	}

	@Test
	@SuppressWarnings("unchecked")
	public void test3() {

		TableGenerator tableGenerator = getAnnotation(A.class, TableGenerator.class);

		reflectionManager.getDefaults().put(TableGenerator.class,
				Arrays.asList(new TableGenerator[] { tableGenerator }));

		AnnotationBinder.bindDefaults(metadataBuildingContext);

		ate(idGeneratorStrategyInterpreter, new TEI[] { new TEI("interpretTableGenerator") {
			@Override
			protected void i(Map<String, Object> props) {
				aeqr(tableGenerator, props.get("tableGeneratorAnnotation"));
			}
		} });

		ate(inFlightMetadataCollector, new TEI[] { new TEI("addDefaultIdentifierGenerator") {
			@Override
			protected void i(Map<String, Object> props) {
				IdentifierGeneratorDefinition igd = (IdentifierGeneratorDefinition) props.get("generatorDefinition");
				aeq("tableGenerator", igd.getName());
			}
		} });

	}

	@Test
	@SuppressWarnings("unchecked")
	public void test4() {

		NamedQuery namedQuery = getAnnotation(A.class, NamedQuery.class);

		reflectionManager.getDefaults().put(NamedQuery.class, Arrays.asList(new NamedQuery[] { namedQuery }));

		AnnotationBinder.bindDefaults(metadataBuildingContext);

		tesz(idGeneratorStrategyInterpreter, 0);

		ate(inFlightMetadataCollector, new TEI[] { new TEI("addDefaultQuery") {
			@Override
			protected void i(Map<String, Object> props) {
				NamedQueryDefinition actual = (NamedQueryDefinition) props.get("queryDefinition");
				aeq("namedQuery", actual.getName());
			}
		} });
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test5() {

		NamedNativeQuery namedNativeQuery = getAnnotation(A.class, NamedNativeQuery.class);

		reflectionManager.getDefaults().put(NamedNativeQuery.class,
				Arrays.asList(new NamedNativeQuery[] { namedNativeQuery }));

		AnnotationBinder.bindDefaults(metadataBuildingContext);

		tesz(idGeneratorStrategyInterpreter, 0);

		ate(inFlightMetadataCollector, new TEI[] { new TEI("addDefaultNamedNative") {
			@Override
			protected void i(Map<String, Object> props) {
				NamedSQLQueryDefinition actual = (NamedSQLQueryDefinition) props.get("query");
				aeq("namedQuery", actual.getName());
			}
		} });
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test6() {

		SqlResultSetMapping sqlResultSetMapping = getAnnotation(A.class, SqlResultSetMapping.class);

		reflectionManager.getDefaults().put(SqlResultSetMapping.class,
				Arrays.asList(new SqlResultSetMapping[] { sqlResultSetMapping }));

		AnnotationBinder.bindDefaults(metadataBuildingContext);

		tesz(idGeneratorStrategyInterpreter, 0);

		ate(inFlightMetadataCollector, new TEI[] { new TEI("addSecondPass") {
			@Override
			protected void i(Map<String, Object> props) {
				ResultsetMappingSecondPass actual = (ResultsetMappingSecondPass) props.get("secondPass");
				ann(actual); // access to actual annotation data is not available
			}
		} });

		dumpTestEvents(this);
	}

	@Test
	@SuppressWarnings("unchecked")
	public void test7() {

		NamedStoredProcedureQuery namedStoredProcedureQuery = getAnnotation(A.class, NamedStoredProcedureQuery.class);

		reflectionManager.getDefaults().put(NamedStoredProcedureQuery.class,
				Arrays.asList(new NamedStoredProcedureQuery[] { namedStoredProcedureQuery }));

		AnnotationBinder.bindDefaults(metadataBuildingContext);

		tesz(idGeneratorStrategyInterpreter, 0);

		ate(inFlightMetadataCollector, new TEI[] { new TEI("addDefaultNamedProcedureCallDefinition") {
			@Override
			protected void i(Map<String, Object> props) {
				NamedProcedureCallDefinition actual = (NamedProcedureCallDefinition) props
						.get("procedureCallDefinition");
				aeq("procedureName1", actual.getProcedureName());
			}
		} });

	}

	@SuppressWarnings("unchecked")
	@Test
	public void test8() {

		NamedStoredProcedureQueries namedStoredProcedureQueries = getAnnotation(A.class,
				NamedStoredProcedureQueries.class);

		reflectionManager.getDefaults().put(NamedStoredProcedureQueries.class,
				Arrays.asList(new NamedStoredProcedureQueries[] { namedStoredProcedureQueries }));

		AnnotationBinder.bindDefaults(metadataBuildingContext);

		tesz(idGeneratorStrategyInterpreter, 0);

		ate(inFlightMetadataCollector, new TEI[] { new TEI("addDefaultNamedProcedureCallDefinition") {
			@Override
			protected void i(Map<String, Object> props) {
				NamedProcedureCallDefinition actual = (NamedProcedureCallDefinition) props
						.get("procedureCallDefinition");
				aeq("procedureName2", actual.getProcedureName());
			}
		} });

	}

	@Test
	public void test() {

		if (t()) {
			return;
		}

		AnnotationBinder.bindClass(xClass, inheritanceStatePerClass, metadataBuildingContext);
		AnnotationBinder.bindPackage(packageName, metadataBuildingContext);
		AnnotationBinder.buildInheritanceStates(orderedClasses, metadataBuildingContext);
		AnnotationBinder.createComponent(propertyHolder, propertyData1, isComponentEmbedded, isIdentifierMapper,
				metadataBuildingContext);
		AnnotationBinder.fillComponent(propertyHolder, propertyData1, accessType, isNullable, entityBinder,
				isComponentEmbedded, isIdentifierMapper, inSecondPass, metadataBuildingContext,
				inheritanceStatePerClass);
		AnnotationBinder.fillComponent(propertyHolder, propertyData1, propertyData2, accessType, isNullable,
				entityBinder, isComponentEmbedded, isIdentifierMapper, inSecondPass, metadataBuildingContext,
				inheritanceStatePerClass);
		AnnotationBinder.isDefault(xClass, metadataBuildingContext);

	}
}

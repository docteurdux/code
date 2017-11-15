package dux.org.hibernate.persister.walking.internal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.boot.registry.classloading.spi.ClassLoaderService;
import org.hibernate.cfg.Settings;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.spi.JdbcServices;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.mapping.Component;
import org.hibernate.mapping.DummyPersistentClass;
import org.hibernate.mapping.Property;
import org.hibernate.mapping.RootClass;
import org.hibernate.mapping.Selectable;
import org.hibernate.mapping.Table;
import org.hibernate.persister.walking.internal.EntityIdentifierDefinitionHelper;
import org.hibernate.persister.walking.spi.AttributeDefinition;
import org.hibernate.persister.walking.spi.AttributeSource;
import org.hibernate.persister.walking.spi.EncapsulatedEntityIdentifierDefinition;
import org.hibernate.persister.walking.spi.EntityIdentifierDefinition;
import org.hibernate.persister.walking.spi.NonEncapsulatedEntityIdentifierDefinition;
import org.hibernate.tuple.component.ComponentMetamodel;
import org.hibernate.tuple.entity.EntityTuplizerFactory;
import org.hibernate.type.ComponentType;
import org.hibernate.type.TypeResolver;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import dum.org.hibernate.boot.registry.classloading.spi.DummyClassLoaderService;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.boot.spi.DummyMetadataImplementor;
import dum.org.hibernate.boot.spi.DummySessionFactoryOptions;
import dum.org.hibernate.cache.spi.access.DummyEntityRegionAccessStrategy;
import dum.org.hibernate.cache.spi.access.DummyNaturalIdRegionAccessStrategy;
import dum.org.hibernate.engine.config.spi.DummyConfigurationService;
import dum.org.hibernate.engine.jdbc.env.spi.DummyJdbcEnvironment;
import dum.org.hibernate.engine.jdbc.spi.DummyJdbcServices;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.mapping.DummyKeyValue;
import dum.org.hibernate.persister.entity.DummyAbstractEntityPersister;
import dum.org.hibernate.persister.spi.DummyPersisterCreationContext;
import dum.org.hibernate.service.spi.DummyServiceRegistryImplementor;
import dum.org.hibernate.type.TypeFactory.DummyTypeScope;
import dux.org.hibernate.query.criteria.internal.DummyStandardServiceRegistry;

@SuppressWarnings("deprecation")
// dont forget to remove duplicated EntityIdentifierDefinitionHelper.java
public class EntityIdentifierDefinitionHelperTest extends AbstractTest {

	private boolean hasName = true;
	private boolean hasIdentifierMapper = false;
	private DummyAbstractEntityPersister abstractEntityPersister;
	private ComponentType type;
	private String identifierPropertyName;

	public void prepare() {

		identifierPropertyName = "identifierPropertyName";

		DummyPersistentClass persistentClass = getPersistentClass();

		DummyEntityRegionAccessStrategy entityRegionAccessStrategy = new DummyEntityRegionAccessStrategy();

		DummyNaturalIdRegionAccessStrategy naturalIdRegionAccessStrategy = new DummyNaturalIdRegionAccessStrategy();

		DummyPersisterCreationContext persisterCreationContext = getPersisterCreationContext();

		abstractEntityPersister = new DummyAbstractEntityPersister(persistentClass, entityRegionAccessStrategy,
				naturalIdRegionAccessStrategy, persisterCreationContext);
	}

	private DummyPersistentClass getPersistentClass() {

		DummyClassLoaderService classLoaderService = new DummyClassLoaderService();
		DummyConfigurationService configurationService = new DummyConfigurationService();

		DummyStandardServiceRegistry serviceRegistry = new DummyStandardServiceRegistry();
		serviceRegistry.setService(ClassLoaderService.class, classLoaderService);
		serviceRegistry.setService(ConfigurationService.class, configurationService);

		DummyMetadataBuildingOptions metadataBuildingOptions = new DummyMetadataBuildingOptions();
		metadataBuildingOptions.setTempClassLoader(this.getClass().getClassLoader());
		metadataBuildingOptions.setServiceRegistry(serviceRegistry);

		DummyMetadataBuildingContext metadataBuildingContext = new DummyMetadataBuildingContext();

		DummyPersistentClass collection = new DummyPersistentClass(metadataBuildingContext);

		RootClass rootClass = new RootClass(metadataBuildingContext);
		rootClass.setEntityName("entityName");

		TypeResolver typeResolver = new TypeResolver();

		DummyMetadataImplementor metadata = new DummyMetadataImplementor();
		metadata.setMetadataBuildingOptions(metadataBuildingOptions);
		metadata.setTypeResolver(typeResolver);

		Component handle = new Component(metadata, collection);

		DummyTypeScope typeScope = new DummyTypeScope();
		ComponentMetamodel metamodel = new ComponentMetamodel(handle, metadataBuildingOptions);

		type = new ComponentType(typeScope, metamodel);

		Iterator<Selectable> columnIterator = new ArrayList<Selectable>().iterator();

		DummyKeyValue keyValue = new DummyKeyValue();
		keyValue.setColumnIterator(columnIterator);
		keyValue.setType(type);

		Table table = new Table();

		DummyPersistentClass persistentClass = new DummyPersistentClass(metadataBuildingContext);
		persistentClass.setRootClass(rootClass);
		persistentClass.setIdentifier(keyValue);
		persistentClass.setPropertyClosureIterator(new ArrayList<>().iterator());
		persistentClass.setRootTable(table);
		if (hasIdentifierMapper) {
			persistentClass.setIdentifierMapper(handle);
		}

		if (hasName) {
			Property identifierProperty = new Property();

			identifierProperty.setName(identifierPropertyName);
			identifierProperty.setPersistentClass(persistentClass);
			persistentClass.setIdentifierProperty(identifierProperty);
		}

		return persistentClass;
	}

	private DummyPersisterCreationContext getPersisterCreationContext() {

		Serializable id = new Serializable() {
			private static final long serialVersionUID = 1L;
		};

		EntityTuplizerFactory entityTuplizerFactory = new EntityTuplizerFactory();

		DummySessionFactoryOptions sessionFactoryOptions = new DummySessionFactoryOptions();
		sessionFactoryOptions.setEntityTuplizerFactory(entityTuplizerFactory);

		Settings settings = new Settings(sessionFactoryOptions);

		Dialect dialect = new Dialect() {
		};

		DummyJdbcEnvironment jdbcEnvironment = new DummyJdbcEnvironment();
		jdbcEnvironment.setDialect(dialect);

		DummyJdbcServices jdbcServices = new DummyJdbcServices();
		jdbcServices.setJdbcEnvironment(jdbcEnvironment);

		DummyServiceRegistryImplementor serviceRegistryImplementor = new DummyServiceRegistryImplementor();
		serviceRegistryImplementor.setService(JdbcServices.class, jdbcServices);

		DummySessionFactoryImplementor sessionFactoryImplementor = new DummySessionFactoryImplementor();
		sessionFactoryImplementor.setServiceRegistry(serviceRegistryImplementor);
		sessionFactoryImplementor.setSettings(settings);
		sessionFactoryImplementor.setSessionFactoryOptions(sessionFactoryOptions);
		sessionFactoryImplementor.setIdentifierGenerator(new IdentifierGenerator() {
			@Override
			public Serializable generate(SharedSessionContractImplementor session, Object object)
					throws HibernateException {

				return id;
			}
		});

		DummyPersisterCreationContext persisterCreationContext = new DummyPersisterCreationContext();
		persisterCreationContext.setSessionFactory(sessionFactoryImplementor);

		return persisterCreationContext;
	}

	public void nonEncapsulatedTest() throws Exception {

		NonEncapsulatedEntityIdentifierDefinition nonEncapsulatedEntityIdentifierDefinition = (NonEncapsulatedEntityIdentifierDefinition) EntityIdentifierDefinitionHelper
				.buildNonEncapsulatedCompositeIdentifierDefinition(abstractEntityPersister);
		af(nonEncapsulatedEntityIdentifierDefinition.getAttributes().iterator().hasNext());
		if (hasName || !hasIdentifierMapper) {
			an(nonEncapsulatedEntityIdentifierDefinition.getSeparateIdentifierMappingClass());
		} else {
			aeq(Map.class, nonEncapsulatedEntityIdentifierDefinition.getSeparateIdentifierMappingClass());
		}
		aeqr(type, nonEncapsulatedEntityIdentifierDefinition.getCompositeType());
		AttributeSource source = nonEncapsulatedEntityIdentifierDefinition.getSource();
		if (hasName) {
			aeq("<identifier-property:identifierPropertyName>", source.toString());
		} else {
			aeq("<identifier-property:null>", source.toString());

		}
		aeqr(type, invoke(source, "getType"));
		af(source.getAttributes().iterator().hasNext());

		aeq("id", nonEncapsulatedEntityIdentifierDefinition.getName());
		aeqr(type, nonEncapsulatedEntityIdentifierDefinition.getType());
		af(nonEncapsulatedEntityIdentifierDefinition.isNullable());

		common(nonEncapsulatedEntityIdentifierDefinition, false);
	}

	public void simpleTest() {

		EncapsulatedEntityIdentifierDefinition encapsulatedEntityIdentifierDefinition = (EncapsulatedEntityIdentifierDefinition) EntityIdentifierDefinitionHelper
				.buildSimpleEncapsulatedIdentifierDefinition(abstractEntityPersister);

		AttributeDefinition attributeDefinition = encapsulatedEntityIdentifierDefinition.getAttributeDefinition();
		aeqr(abstractEntityPersister, attributeDefinition.getSource());
		if (hasName) {
			aeq("<identifier-property:identifierPropertyName>", attributeDefinition.toString());
		} else {
			aeq("<identifier-property:null>", attributeDefinition.toString());
		}

		common(encapsulatedEntityIdentifierDefinition, true);
	}

	public void compositeTest() {

		EncapsulatedEntityIdentifierDefinition encapsulatedEntityIdentifierDefinition = (EncapsulatedEntityIdentifierDefinition) EntityIdentifierDefinitionHelper
				.buildEncapsulatedCompositeIdentifierDefinition(abstractEntityPersister);
		encapsulatedEntityIdentifierDefinition.getAttributeDefinition();

		common(encapsulatedEntityIdentifierDefinition, true);
	}

	private void common(EntityIdentifierDefinition eid, boolean encapsulated) {
		aeqr(abstractEntityPersister, eid.getEntityDefinition());
		aeq(encapsulated, eid.isEncapsulated());
	}

	@Test
	public void test4() throws Exception {
		for (Boolean hasName : BOOLEANS) {
			for (Boolean hasIdentifierMapper : BOOLEANS) {

				System.out.println("hasName: " + hasName);
				System.out.println("hasIdentifierMapper: " + hasIdentifierMapper);

				this.hasName = hasName;
				this.hasIdentifierMapper = hasIdentifierMapper;

				prepare();

				compositeTest();
				nonEncapsulatedTest();
				simpleTest();

			}
		}
	}
}

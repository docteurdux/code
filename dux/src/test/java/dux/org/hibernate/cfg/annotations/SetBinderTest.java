package dux.org.hibernate.cfg.annotations;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.OneToMany;

import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.common.reflection.XClass;
import org.hibernate.annotations.common.reflection.java.DummyJavaXClass;
import org.hibernate.annotations.common.reflection.java.JavaReflectionManager;
import org.hibernate.annotations.common.reflection.java.generics.TypeEnvironment;
import org.hibernate.cfg.AccessType;
import org.hibernate.cfg.InheritanceState;
import org.hibernate.cfg.annotations.SetBinder;
import org.hibernate.mapping.DummyPersistentClass;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.annotations.common.reflection.DummyReflectionManager;
import dum.org.hibernate.annotations.common.reflection.DummyXProperty;
import dum.org.hibernate.annotations.common.reflection.java.generics.DummyTypeEnvironment;
import dum.org.hibernate.boot.spi.DummyInFlightMetadataCollector;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingOptions;
import dum.org.hibernate.cfg.DummyPropertyHolder;

@Done("needs a second pass ; what's happening behind the scene is quite complicated")
public class SetBinderTest extends AbstractTest {

	private OrderBy orderBy;
	private DummyReflectionManager reflectionManager;
	private DummyMetadataBuildingOptions metadataBuildingOptions;
	private DummyInFlightMetadataCollector inFlightMetadataCollector;
	private DummyMetadataBuildingContext metadataBuildingContext;
	private DummyPersistentClass persistentClass;
	private DummyPropertyHolder propertyHolder;
	private String path;
	private String propertyName;
	private DummyXProperty xProperty;
	private OneToMany oneToMany;
	private TypeEnvironment typeEnvironment;
	private JavaReflectionManager javaReflectionManager;
	private DummyJavaXClass javaXClass;
	private Map<XClass, InheritanceState> inheritanceStatePerClass;
	private AccessType accessType;

	public static class A {
		@OrderBy(clause = "clause")
		@OneToMany
		public void foo() {

		}
	}

	public SetBinderTest() {

		path = "path";
		propertyName = "propertyName";

		accessType = AccessType.DEFAULT;

		orderBy = getAnnotation(A.class, "foo", new Class<?>[] {}, OrderBy.class);
		oneToMany = getAnnotation(A.class, "foo", new Class<?>[] {}, OneToMany.class);

		inheritanceStatePerClass = new HashMap<>();

		reflectionManager = new DummyReflectionManager();

		metadataBuildingOptions = new DummyMetadataBuildingOptions();
		metadataBuildingOptions.setReflectionManager(reflectionManager);

		inFlightMetadataCollector = new DummyInFlightMetadataCollector();

		metadataBuildingContext = new DummyMetadataBuildingContext();
		metadataBuildingContext.setMetadataCollector(inFlightMetadataCollector);
		metadataBuildingContext.setBuildingOptions(metadataBuildingOptions);

		persistentClass = new DummyPersistentClass(metadataBuildingContext);

		propertyHolder = new DummyPropertyHolder();
		propertyHolder.setPersistentClass(persistentClass);
		propertyHolder.setPath(path);

		xProperty = new DummyXProperty();
		xProperty.setAnnotation(OneToMany.class, oneToMany);

		typeEnvironment = new DummyTypeEnvironment();

		javaReflectionManager = reflectionManager.getJavaReflectionManager();
		javaXClass = new DummyJavaXClass(A.class, typeEnvironment, javaReflectionManager);

	}

	@Test
	public void test() {

		SetBinder binder = new SetBinder(false);
		binder.setPropertyHolder(propertyHolder);
		binder.setBuildingContext(metadataBuildingContext);
		binder.setPropertyName(propertyName);
		binder.setProperty(xProperty);
		binder.setTargetEntity(javaXClass.leak());
		binder.setInheritanceStatePerClass(inheritanceStatePerClass);
		binder.setAccessType(accessType);
		binder.setDeclaringClass(javaXClass.leak());

		binder.setSqlOrderBy(orderBy);

		binder.bind();

	}
}

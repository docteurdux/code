package dux.org.hibernate.cfg;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.cfg.SecondaryTableSecondPass;
import org.hibernate.cfg.annotations.EntityBinder;
import org.hibernate.mapping.DummyPersistentClass;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.persistence.DummyEntity;
import dum.org.hibernate.annotations.common.reflection.DummyXAnnotatedElement;
import dum.org.hibernate.annotations.common.reflection.DummyXClass;
import dum.org.hibernate.boot.spi.DummyMetadataBuildingContext;
import dum.org.hibernate.cfg.DummyPropertyHolder;

@Done("needs second pass that actually does something")
public class SecondaryTableSecondPassTest extends AbstractTest {

	private DummyEntity persistenceEntityAnnotation;
	private dum.org.hibernate.annotations.DummyEntity hibernateEntityAnnotation;
	private DummyXClass xClass;
	private DummyMetadataBuildingContext metadataBuildingContext;
	private DummyPersistentClass persistentClass;
	private EntityBinder entityBinder;
	private DummyPropertyHolder propertyHolder;
	private DummyXAnnotatedElement xAnnotatedElement;
	private Map persistentClasses;

	@Before
	public void before() {
		persistenceEntityAnnotation = new DummyEntity() {
		};
		hibernateEntityAnnotation = new dum.org.hibernate.annotations.DummyEntity() {
		};
		xClass = new DummyXClass();
		metadataBuildingContext = new DummyMetadataBuildingContext();
		persistentClass = new DummyPersistentClass(metadataBuildingContext);
		entityBinder = new EntityBinder(persistenceEntityAnnotation, hibernateEntityAnnotation, xClass, persistentClass,
				metadataBuildingContext);
		propertyHolder = new DummyPropertyHolder();
		xAnnotatedElement = new DummyXAnnotatedElement();
		persistentClasses = new HashMap<>();
	}

	@Test
	public void test() {
		new SecondaryTableSecondPass(entityBinder, propertyHolder, xAnnotatedElement).doSecondPass(persistentClasses);
	}
}

package dux.org.hibernate.tuple.entity;

import org.hibernate.FetchMode;
import org.hibernate.tuple.BaselineAttributeInformation;
import org.hibernate.tuple.entity.EntityBasedCompositionAttribute;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummyCascadeStyle;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.persister.entity.DummyEntityPersister;
import dum.org.hibernate.tuple.DummyValueGeneration;
import dum.org.hibernate.type.DummyCompositeType;

@Done
public class EntityBasedCompositionAttributeTest extends AbstractTest {
	private DummyEntityPersister entityPersister;
	private DummySessionFactoryImplementor sessionFactoryImplementor;
	private int attributeNumber;
	private String attributeName;
	private DummyCompositeType compositeType;
	private BaselineAttributeInformation baselineAttributeInformation;

	@Before
	public void before() {
		entityPersister = new DummyEntityPersister();
		sessionFactoryImplementor = new DummySessionFactoryImplementor();
		attributeNumber = 0;
		attributeName = "attributeName";
		compositeType = new DummyCompositeType();
		baselineAttributeInformation = new BaselineAttributeInformation(false, false, false, new DummyValueGeneration(),
				false, false, false, new DummyCascadeStyle(), FetchMode.DEFAULT);
	}

	@Test
	public void test() {

		EntityBasedCompositionAttribute entityBasedCompositionAttribute = new EntityBasedCompositionAttribute(
				entityPersister, sessionFactoryImplementor, attributeNumber, attributeName, compositeType,
				baselineAttributeInformation);

		aeqr(entityPersister, invoke(entityBasedCompositionAttribute, "locateOwningPersister"));
	}
}

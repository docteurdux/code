package dux.org.hibernate.tuple.entity;

import org.hibernate.FetchMode;
import org.hibernate.tuple.BaselineAttributeInformation;
import org.hibernate.tuple.entity.AbstractEntityBasedAttribute;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummyCascadeStyle;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.persister.entity.DummyEntityPersister;
import dum.org.hibernate.tuple.DummyValueGeneration;
import dum.org.hibernate.tuple.entity.DummyAbstractEntityBasedAttribute;
import dum.org.hibernate.type.DummyType;

@Done
public class AbstractEntityBasedAttributeTest extends AbstractTest {
	private DummyEntityPersister entityPersister;
	private DummySessionFactoryImplementor sessionFactoryImplementor;
	private int attributeNumber;
	private String attributeName;
	private DummyType attributeType;
	private boolean lazy;
	private boolean insertable;
	private boolean updateable;
	private boolean nullable;
	private boolean dirtyCheckable;
	private boolean versionable;
	private FetchMode fetchMode;
	private DummyValueGeneration valueGenerationStrategy;
	private DummyCascadeStyle cascadeStyle;
	private BaselineAttributeInformation baselineAttributeInformation;

	@Before
	public void before() {
		entityPersister = new DummyEntityPersister();
		sessionFactoryImplementor = new DummySessionFactoryImplementor();
		attributeNumber = 0;
		attributeName = "attributeName";
		attributeType = new DummyType();
		lazy = false;
		insertable = false;
		updateable = false;
		nullable = false;
		dirtyCheckable = false;
		versionable = false;
		fetchMode = FetchMode.DEFAULT;
		valueGenerationStrategy = new DummyValueGeneration();
		cascadeStyle = new DummyCascadeStyle();
		baselineAttributeInformation = new BaselineAttributeInformation(lazy, insertable, updateable,
				valueGenerationStrategy, nullable, dirtyCheckable, versionable, cascadeStyle, fetchMode);
	}

	@Test
	public void test() {

		AbstractEntityBasedAttribute abstractEntityBasedAttribute = new DummyAbstractEntityBasedAttribute(
				entityPersister, sessionFactoryImplementor, attributeNumber, attributeName, attributeType,
				baselineAttributeInformation);

		aeqr(entityPersister, abstractEntityBasedAttribute.getSource());
		aeq(attributeName, abstractEntityBasedAttribute.getName());
		aeqr(attributeType, abstractEntityBasedAttribute.getType());
		aeq(lazy, abstractEntityBasedAttribute.isLazy());
		aeq(insertable, abstractEntityBasedAttribute.isInsertable());
		aeq(updateable, abstractEntityBasedAttribute.isUpdateable());
		aeq(nullable, abstractEntityBasedAttribute.isNullable());
		aeq(dirtyCheckable, abstractEntityBasedAttribute.isDirtyCheckable());
		aeq(versionable, abstractEntityBasedAttribute.isVersionable());
		aeqr(valueGenerationStrategy, abstractEntityBasedAttribute.getValueGenerationStrategy());
		aeqr(cascadeStyle, abstractEntityBasedAttribute.getCascadeStyle());
		aeq(fetchMode, abstractEntityBasedAttribute.getFetchMode());
	}
}

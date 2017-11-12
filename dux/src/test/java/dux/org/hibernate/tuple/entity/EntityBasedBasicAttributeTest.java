package dux.org.hibernate.tuple.entity;

import org.hibernate.FetchMode;
import org.hibernate.engine.spi.CascadeStyle;
import org.hibernate.tuple.AbstractAttribute;
import org.hibernate.tuple.AbstractNonIdentifierAttribute;
import org.hibernate.tuple.BaselineAttributeInformation;
import org.hibernate.tuple.ValueGeneration;
import org.hibernate.tuple.entity.AbstractEntityBasedAttribute;
import org.hibernate.tuple.entity.EntityBasedBasicAttribute;
import org.hibernate.type.Type;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummyCascadeStyle;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.persister.entity.DummyEntityPersister;
import dum.org.hibernate.tuple.DummyValueGeneration;
import dum.org.hibernate.type.DummyType;

@Done
public class EntityBasedBasicAttributeTest extends AbstractTest {

	private boolean updateable;
	private boolean insertable;
	private boolean lazy;
	private ValueGeneration valueGeneration;
	private boolean nullable;
	private boolean dirtyCheckable;
	private boolean versionable;
	private CascadeStyle cascadeStyle;
	private FetchMode fetchMode;
	private Type type;
	private String attributeName;
	private int attributeNumber;
	private DummyEntityPersister entityPersister;
	private DummySessionFactoryImplementor sessionFactoryImplementor;
	private BaselineAttributeInformation baselineAttributeInformation;

	@Before
	public void before() {
		attributeNumber = 1;
		attributeName = "attributeName";
		type = new DummyType();
		updateable = true;
		insertable = true;
		lazy = true;
		valueGeneration = new DummyValueGeneration();
		nullable = true;
		dirtyCheckable = true;
		versionable = true;
		cascadeStyle = new DummyCascadeStyle();
		fetchMode = FetchMode.DEFAULT;

		entityPersister = new DummyEntityPersister();
		sessionFactoryImplementor = new DummySessionFactoryImplementor();

		baselineAttributeInformation = new BaselineAttributeInformation(lazy, insertable, updateable, valueGeneration,
				nullable, dirtyCheckable, versionable, cascadeStyle, fetchMode);
	}

	@Test
	public void test() throws Exception {

		aeq(AbstractEntityBasedAttribute.class, EntityBasedBasicAttribute.class.getSuperclass());

		EntityBasedBasicAttribute entityBasedBasicAttribute = new EntityBasedBasicAttribute(entityPersister,
				sessionFactoryImplementor, attributeNumber, attributeName, type, baselineAttributeInformation);

		AbstractEntityBasedAttribute abstractEntityBasedAttribute = entityBasedBasicAttribute;
		aeqr(entityPersister, abstractEntityBasedAttribute.getSource());

		AbstractNonIdentifierAttribute abstractNonIdentifierAttribute = abstractEntityBasedAttribute;

		aeqr(entityPersister, abstractNonIdentifierAttribute.getSource());

		aeqr(sessionFactoryImplementor,
				invoke(abstractNonIdentifierAttribute, "sessionFactory", AbstractNonIdentifierAttribute.class));
		aeq(attributeNumber,
				invoke(abstractNonIdentifierAttribute, "attributeNumber", AbstractNonIdentifierAttribute.class));

		aeq(baselineAttributeInformation.isLazy(), abstractNonIdentifierAttribute.isLazy());
		aeq(baselineAttributeInformation.isInsertable(), abstractNonIdentifierAttribute.isInsertable());
		aeq(baselineAttributeInformation.isUpdateable(), abstractNonIdentifierAttribute.isUpdateable());
		aeq(baselineAttributeInformation.isNullable(), abstractNonIdentifierAttribute.isNullable());
		aeq(baselineAttributeInformation.isDirtyCheckable(), abstractNonIdentifierAttribute.isDirtyCheckable());
		aeq(baselineAttributeInformation.isVersionable(), abstractNonIdentifierAttribute.isVersionable());
		aeqr(baselineAttributeInformation.getCascadeStyle(), abstractNonIdentifierAttribute.getCascadeStyle());
		aeq(baselineAttributeInformation.getFetchMode(), abstractNonIdentifierAttribute.getFetchMode());
		aeqr(baselineAttributeInformation.getValueGenerationStrategy(),
				abstractNonIdentifierAttribute.getValueGenerationStrategy());

		AbstractAttribute abstractAttribute = abstractNonIdentifierAttribute;
		aeq(attributeName, abstractAttribute.getName());
		aeqr(type, abstractAttribute.getType());

	}
}

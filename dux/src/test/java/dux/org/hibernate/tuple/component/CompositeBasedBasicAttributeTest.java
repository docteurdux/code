package dux.org.hibernate.tuple.component;

import org.hibernate.FetchMode;
import org.hibernate.tuple.BaselineAttributeInformation;
import org.hibernate.tuple.component.CompositeBasedBasicAttribute;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummyCascadeStyle;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.persister.walking.spi.DummyAttributeSource;
import dum.org.hibernate.tuple.DummyValueGeneration;
import dum.org.hibernate.type.DummyType;

@Done
public class CompositeBasedBasicAttributeTest extends AbstractTest {

	private String attributeName;
	private int attributeNumber;

	private boolean lazy;
	private boolean insertable;
	private boolean updateable;
	private boolean nullable;
	private boolean dirtyCheckable;
	private boolean versionable;
	private FetchMode fetchMode;
	private DummyValueGeneration valueGeneration;
	private DummyCascadeStyle cascadeStyle;
	private BaselineAttributeInformation baselineAttributeInformation;

	private DummyAttributeSource attributeSource;

	private DummySessionFactoryImplementor sessionFactoryImplementor;

	private DummyType type;

	public CompositeBasedBasicAttributeTest() {

		attributeName = "attributeName";
		attributeNumber = 0;

		lazy = false;
		insertable = false;
		updateable = false;
		nullable = false;
		dirtyCheckable = false;
		versionable = false;
		fetchMode = FetchMode.DEFAULT;
		valueGeneration = new DummyValueGeneration();
		cascadeStyle = new DummyCascadeStyle();
		baselineAttributeInformation = new BaselineAttributeInformation(lazy, insertable, updateable, valueGeneration,
				nullable, dirtyCheckable, versionable, cascadeStyle, fetchMode);

		attributeSource = new DummyAttributeSource();

		sessionFactoryImplementor = new DummySessionFactoryImplementor();

		type = new DummyType();

	}

	@Test
	public void test() {

		CompositeBasedBasicAttribute cbba = new CompositeBasedBasicAttribute(attributeSource, sessionFactoryImplementor,
				attributeNumber, attributeName, type, baselineAttributeInformation) {

		};

		aeq(attributeName, cbba.getName());
		aeqr(attributeSource, cbba.getSource());
		aeqr(type, cbba.getType());

		aeqr(cascadeStyle, cbba.getCascadeStyle());
		aeqr(valueGeneration, cbba.getValueGenerationStrategy());
		aeq(fetchMode, cbba.getFetchMode());

		aeq(lazy, cbba.isLazy());
		aeq(insertable, cbba.isInsertable());
		aeq(updateable, cbba.isUpdateable());
		aeq(nullable, cbba.isNullable());
		aeq(dirtyCheckable, cbba.isDirtyCheckable());
		aeq(versionable, cbba.isVersionable());
		aeq(fetchMode, cbba.getFetchMode());

	}
}

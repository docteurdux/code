package dux.org.hibernate.tuple.entity;

import org.hibernate.FetchMode;
import org.hibernate.engine.spi.VersionValue;
import org.hibernate.tuple.BaselineAttributeInformation;
import org.hibernate.tuple.entity.VersionProperty;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.engine.spi.DummyCascadeStyle;
import dum.org.hibernate.engine.spi.DummySessionFactoryImplementor;
import dum.org.hibernate.persister.entity.DummyEntityPersister;
import dum.org.hibernate.tuple.DummyValueGeneration;
import dum.org.hibernate.type.DummyType;

@Done
public class VersionPropertyTest extends AbstractTest {

	@Test
	public void test() {

		VersionValue versionValue = new VersionValue(new Object());

		VersionProperty versionProperty = createVersionProperty(versionValue);

		aeqr(versionValue, versionProperty.getUnsavedValue());
	}

	private VersionProperty createVersionProperty(VersionValue versionValue) {

		BaselineAttributeInformation attributeInformation = new BaselineAttributeInformation(false, false, false,
				new DummyValueGeneration(), false, false, false, new DummyCascadeStyle(), FetchMode.DEFAULT);

		return new VersionProperty(new DummyEntityPersister(), new DummySessionFactoryImplementor(), 0, "attributeName",
				new DummyType(), attributeInformation, versionValue);
	}
}

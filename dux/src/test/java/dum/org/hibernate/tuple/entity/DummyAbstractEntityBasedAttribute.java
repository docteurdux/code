package dum.org.hibernate.tuple.entity;

import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.persister.entity.EntityPersister;
import org.hibernate.tuple.BaselineAttributeInformation;
import org.hibernate.tuple.entity.AbstractEntityBasedAttribute;
import org.hibernate.type.Type;

public class DummyAbstractEntityBasedAttribute extends AbstractEntityBasedAttribute {
	public DummyAbstractEntityBasedAttribute(EntityPersister source, SessionFactoryImplementor sessionFactory,
			int attributeNumber, String attributeName, Type attributeType,
			BaselineAttributeInformation attributeInformation) {
		super(source, sessionFactory, attributeNumber, attributeName, attributeType, attributeInformation);
	}
}

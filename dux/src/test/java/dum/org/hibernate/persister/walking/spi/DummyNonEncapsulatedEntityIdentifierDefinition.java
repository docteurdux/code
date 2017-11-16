package dum.org.hibernate.persister.walking.spi;

import org.hibernate.persister.walking.spi.AttributeDefinition;
import org.hibernate.persister.walking.spi.AttributeSource;
import org.hibernate.persister.walking.spi.EntityDefinition;
import org.hibernate.persister.walking.spi.NonEncapsulatedEntityIdentifierDefinition;
import org.hibernate.type.CompositeType;
import org.hibernate.type.Type;

public class DummyNonEncapsulatedEntityIdentifierDefinition implements NonEncapsulatedEntityIdentifierDefinition {

	@Override
	public boolean isEncapsulated() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EntityDefinition getEntityDefinition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompositeType getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AttributeSource getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNullable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<AttributeDefinition> getAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getCompositeType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class getSeparateIdentifierMappingClass() {
		// TODO Auto-generated method stub
		return null;
	}

}

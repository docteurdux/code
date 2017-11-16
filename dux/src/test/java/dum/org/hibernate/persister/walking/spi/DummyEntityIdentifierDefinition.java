package dum.org.hibernate.persister.walking.spi;

import org.hibernate.persister.walking.spi.EntityDefinition;
import org.hibernate.persister.walking.spi.EntityIdentifierDefinition;

public class DummyEntityIdentifierDefinition implements EntityIdentifierDefinition {

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

}

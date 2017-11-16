package dum.org.hibernate.persister.walking.spi;

import org.hibernate.persister.walking.spi.AnyMappingDefinition;
import org.hibernate.persister.walking.spi.CollectionDefinition;
import org.hibernate.persister.walking.spi.CollectionElementDefinition;
import org.hibernate.persister.walking.spi.CompositeCollectionElementDefinition;
import org.hibernate.persister.walking.spi.EntityDefinition;
import org.hibernate.type.Type;

public class DummyCollectionElementDefinition implements CollectionElementDefinition {

	private CollectionDefinition collectionDefinition;
	private Type type;

	@Override
	public CollectionDefinition getCollectionDefinition() {
		return collectionDefinition;
	}

	public void setCollectionDefinition(CollectionDefinition collectionDefinition) {
		this.collectionDefinition = collectionDefinition;
	}

	@Override
	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public AnyMappingDefinition toAnyMappingDefinition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityDefinition toEntityDefinition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CompositeCollectionElementDefinition toCompositeElementDefinition() {
		// TODO Auto-generated method stub
		return null;
	}

}

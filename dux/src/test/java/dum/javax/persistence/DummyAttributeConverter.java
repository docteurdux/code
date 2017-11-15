package dum.javax.persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeConverter;

public class DummyAttributeConverter<EntityType, DBType> implements AttributeConverter<EntityType, DBType> {

	List<EntityType> entityToDatabaseInputs = new ArrayList<>();
	List<DBType> entityToDatabaseOutputs = new ArrayList<>();

	List<EntityType> databaseToEntityOutputs = new ArrayList<>();
	List<DBType> databaseToEntityInputs = new ArrayList<>();

	@Override
	public DBType convertToDatabaseColumn(EntityType entity) {
		for (int i = 0; i < entityToDatabaseInputs.size(); ++i) {
			if (entityToDatabaseInputs.get(i) == entity) {
				return entityToDatabaseOutputs.get(i);
			}
		}
		return null;
	}

	@Override
	public EntityType convertToEntityAttribute(DBType databaseValue) {
		for (int i = 0; i < databaseToEntityInputs.size(); ++i) {
			if (databaseToEntityInputs.get(i) == databaseValue) {
				return databaseToEntityOutputs.get(i);
			}
		}
		return null;
	}

	public void addEntityToDatabasePair(EntityType input, DBType output) {
		entityToDatabaseInputs.add(input);
		entityToDatabaseOutputs.add(output);
	}

	public void addDatabaseToEntityPair(DBType input, EntityType output) {
		databaseToEntityInputs.add(input);
		databaseToEntityOutputs.add(output);
	}

}

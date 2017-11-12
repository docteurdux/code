package dum.org.hibernate.tuple;

import org.hibernate.tuple.GenerationTiming;
import org.hibernate.tuple.ValueGeneration;
import org.hibernate.tuple.ValueGenerator;

public class DummyValueGeneration implements ValueGeneration {

	@Override
	public GenerationTiming getGenerationTiming() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ValueGenerator<?> getValueGenerator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean referenceColumnInSql() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDatabaseGeneratedReferencedColumnValue() {
		// TODO Auto-generated method stub
		return null;
	}

}

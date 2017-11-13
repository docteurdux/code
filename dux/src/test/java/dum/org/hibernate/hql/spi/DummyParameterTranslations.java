package dum.org.hibernate.hql.spi;

import java.util.Set;

import org.hibernate.hql.spi.ParameterTranslations;
import org.hibernate.type.Type;

public class DummyParameterTranslations implements ParameterTranslations {

	@Override
	public boolean supportsOrdinalParameterMetadata() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getOrdinalParameterCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOrdinalParameterSqlLocation(int ordinalPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Type getOrdinalParameterExpectedType(int ordinalPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set getNamedParameterNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] getNamedParameterSqlLocations(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Type getNamedParameterExpectedType(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

package dum.org.hibernate.query.internal;

import org.hibernate.query.internal.QueryParameterImpl;
import org.hibernate.type.Type;

public class DummyQueryParameterImpl<T> extends QueryParameterImpl<T> {

	public DummyQueryParameterImpl(Type expectedType) {
		super(expectedType);
	}

	@Override
	public boolean isJpaPositionalParameter() {
		return false;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public Integer getPosition() {
		return null;
	}

}

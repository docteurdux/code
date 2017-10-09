package dum.org.springframework.expression;

import org.springframework.expression.EvaluationException;
import org.springframework.expression.TypeLocator;

public class DummyTypeLocator implements TypeLocator {

	private Class<?> type;

	@Override
	public Class<?> findType(String typeName) throws EvaluationException {
		return type;
	}

	public void setType(Class<?> type) {
		this.type = type;
	}

}

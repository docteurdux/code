package dum.org.hibernate.criterion;

import org.hibernate.criterion.NotEmptyExpression;

public class DummyNotEmptyExpression extends NotEmptyExpression {

	private static final long serialVersionUID = 1L;

	public DummyNotEmptyExpression(String propertyName) {
		super(propertyName);
	}

	@Override
	public boolean excludeEmpty() {
		return super.excludeEmpty();
	}

}

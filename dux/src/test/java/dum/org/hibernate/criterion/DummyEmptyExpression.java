package dum.org.hibernate.criterion;

import org.hibernate.criterion.EmptyExpression;

public class DummyEmptyExpression extends EmptyExpression {

	private static final long serialVersionUID = 1L;
	
	public DummyEmptyExpression(String propertyName) {
		super(propertyName);
	}

	@Override
	public boolean excludeEmpty() {
		return super.excludeEmpty();
	}

}

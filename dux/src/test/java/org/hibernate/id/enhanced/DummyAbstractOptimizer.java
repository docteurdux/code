package org.hibernate.id.enhanced;

import java.io.Serializable;

import org.hibernate.id.IntegralDataTypeHolder;

public class DummyAbstractOptimizer extends AbstractOptimizer {

	public DummyAbstractOptimizer(Class returnClass, int incrementSize) {
		super(returnClass, incrementSize);
	}

	@Override
	public Serializable generate(AccessCallback callback) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IntegralDataTypeHolder getLastSourceValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean applyIncrementSizeToSourceValues() {
		// TODO Auto-generated method stub
		return false;
	}

}

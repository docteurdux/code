package dum.javax.persistence.criteria;

import java.util.List;

import javax.persistence.criteria.Selection;

public class DummySelection<T> implements Selection<T> {

	@Override
	public Class<? extends T> getJavaType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAlias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Selection<T> alias(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCompoundSelection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Selection<?>> getCompoundSelectionItems() {
		// TODO Auto-generated method stub
		return null;
	}
}

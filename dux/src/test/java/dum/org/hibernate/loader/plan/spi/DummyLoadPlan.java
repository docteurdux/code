package dum.org.hibernate.loader.plan.spi;

import java.util.List;

import org.hibernate.loader.plan.spi.LoadPlan;
import org.hibernate.loader.plan.spi.QuerySpaces;
import org.hibernate.loader.plan.spi.Return;

public class DummyLoadPlan implements LoadPlan {

	@Override
	public Disposition getDisposition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Return> getReturns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuerySpaces getQuerySpaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean areLazyAttributesForceFetched() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasAnyScalarReturns() {
		// TODO Auto-generated method stub
		return false;
	}

}

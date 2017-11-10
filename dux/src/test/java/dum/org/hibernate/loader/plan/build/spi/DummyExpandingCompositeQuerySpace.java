package dum.org.hibernate.loader.plan.build.spi;

import org.hibernate.loader.plan.build.spi.ExpandingCompositeQuerySpace;
import org.hibernate.loader.plan.build.spi.ExpandingQuerySpaces;
import org.hibernate.loader.plan.spi.Join;
import org.hibernate.loader.plan.spi.QuerySpaces;
import org.hibernate.persister.entity.PropertyMapping;

public class DummyExpandingCompositeQuerySpace implements ExpandingCompositeQuerySpace {

	@Override
	public String getUid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuerySpaces getQuerySpaces() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PropertyMapping getPropertyMapping() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] toAliasedColumns(String alias, String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Disposition getDisposition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Join> getJoins() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canJoinsBeRequired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addJoin(Join join) {
		// TODO Auto-generated method stub

	}

	@Override
	public ExpandingQuerySpaces getExpandingQuerySpaces() {
		// TODO Auto-generated method stub
		return null;
	}

}

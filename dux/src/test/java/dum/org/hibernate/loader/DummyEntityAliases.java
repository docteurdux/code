package dum.org.hibernate.loader;

import org.hibernate.loader.EntityAliases;
import org.hibernate.persister.entity.Loadable;

public class DummyEntityAliases implements EntityAliases {

	@Override
	public String[] getSuffixedKeyAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSuffixedDiscriminatorAlias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getSuffixedVersionAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] getSuffixedPropertyAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[][] getSuffixedPropertyAliases(Loadable persister) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRowIdAlias() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSuffix() {
		// TODO Auto-generated method stub
		return null;
	}

}

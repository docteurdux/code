package dum.org.hibernate.loader;

import java.util.Map;

import org.hibernate.loader.ColumnEntityAliases;
import org.hibernate.persister.entity.Loadable;

public class DummyColumnEntityAliases extends ColumnEntityAliases {

	public DummyColumnEntityAliases(@SuppressWarnings("rawtypes") Map returnProperties, Loadable persister,
			String suffix) {
		super(returnProperties, persister, suffix);
	}

	@Override
	public String getDiscriminatorAlias(Loadable persister, String suffix) {
		return super.getDiscriminatorAlias(persister, suffix);
	}

	@Override
	public String[] getIdentifierAliases(Loadable persister, String suffix) {
		return super.getIdentifierAliases(persister, suffix);
	}

	@Override
	public String[] getPropertyAliases(Loadable persister, int j) {
		return super.getPropertyAliases(persister, j);
	}

}

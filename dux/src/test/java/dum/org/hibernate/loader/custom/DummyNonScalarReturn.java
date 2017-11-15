package dum.org.hibernate.loader.custom;

import org.hibernate.LockMode;
import org.hibernate.loader.custom.NonScalarReturn;

public class DummyNonScalarReturn extends NonScalarReturn {

	public DummyNonScalarReturn(String alias, LockMode lockMode) {
		super(alias, lockMode);
	}

}

package dum.org.hibernate.id.insert;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.insert.Binder;
import org.hibernate.id.insert.IdentifierGeneratingInsert;
import org.hibernate.id.insert.InsertGeneratedIdentifierDelegate;

public class DummyInsertGeneratedIdentifierDelegate implements InsertGeneratedIdentifierDelegate {

	@Override
	public IdentifierGeneratingInsert prepareIdentifierGeneratingInsert() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable performInsert(String insertSQL, SharedSessionContractImplementor session, Binder binder) {
		// TODO Auto-generated method stub
		return null;
	}

}

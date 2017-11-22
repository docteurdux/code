package dum.org.hibernate.procedure;

import java.util.Map;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.procedure.ProcedureCall;
import org.hibernate.procedure.ProcedureCallMemento;

public class DummyProcedureCallMemento implements ProcedureCallMemento {

	@Override
	public ProcedureCall makeProcedureCall(SharedSessionContractImplementor session) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> getHintsMap() {
		// TODO Auto-generated method stub
		return null;
	}

}

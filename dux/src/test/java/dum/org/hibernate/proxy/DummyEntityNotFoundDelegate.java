package dum.org.hibernate.proxy;

import java.io.Serializable;

import org.hibernate.proxy.EntityNotFoundDelegate;

public class DummyEntityNotFoundDelegate implements EntityNotFoundDelegate {

	@Override
	public void handleEntityNotFound(String entityName, Serializable id) {
		// TODO Auto-generated method stub

	}

}

package dux.org.springframework.security.acls.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.ObjectIdentityRetrievalStrategy;

public class DummyObjectIdentityRetrievalStrategy implements ObjectIdentityRetrievalStrategy {

	private List<Object> domainObjects = new ArrayList<>();
	private List<ObjectIdentity> objectIdentities = new ArrayList<>();

	@Override
	public ObjectIdentity getObjectIdentity(Object domainObject) {
		for (int i = 0; i < size(); ++i) {
			if (domainObjects.get(i) == domainObject) {
				return objectIdentities.get(i);
			}
		}
		return null;
	}

	public void setObjectIdentity(Object domainObject, ObjectIdentity identity) {
		for (int i = 0; i < size(); ++i) {
			if (domainObjects.get(i) == domainObject) {
				objectIdentities.set(i, identity);
				return;
			}
		}
		domainObjects.add(domainObject);
		objectIdentities.add(identity);
	}

	private int size() {
		return domainObjects.size();
	}

}

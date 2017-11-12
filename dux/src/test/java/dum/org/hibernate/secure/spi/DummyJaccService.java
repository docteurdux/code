package dum.org.hibernate.secure.spi;

import org.hibernate.secure.spi.GrantedPermission;
import org.hibernate.secure.spi.JaccService;
import org.hibernate.secure.spi.PermissibleAction;
import org.hibernate.secure.spi.PermissionCheckEntityInformation;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyJaccService extends TestEventCollector implements JaccService {

	@Override
	public String getContextId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPermission(GrantedPermission permissionDeclaration) {
		// TODO Auto-generated method stub

	}

	@Override
	public void checkPermission(PermissionCheckEntityInformation entityInformation, PermissibleAction action) {
		testEvents.add(
				new TestEvent("checkPermission").prop("entityInformation", entityInformation).prop("action", action));
	}

}

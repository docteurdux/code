package dux.org.springframework.security.acls.aclEntryVoter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.acls.AclEntryVoter;
import org.springframework.security.acls.model.Acl;
import org.springframework.security.acls.model.AclService;
import org.springframework.security.acls.model.Permission;
import org.springframework.security.core.Authentication;

import dux.org.aopalliance.intercept.DummyMethodInvocation;
import dux.org.springframework.security.access.DummyConfigAttribute;
import dux.org.springframework.security.acls.model.DummyAcl;
import dux.org.springframework.security.acls.model.DummyAclService;
import dux.org.springframework.security.acls.model.DummyPermission;
import dux.org.springframework.security.core.DummyAuthentication;

public class S {

	public static final String INTERNAL_METHOD = "internalMethod";
	public static final String PROCESS_CONFIG_ATTRIBUTE = "processConfigAttribute";

	public enum Attributes {
		NONE, NAME_NOT_SET, NAME_SET

	}

	public static class Id implements Serializable {

		private static final long serialVersionUID = 1L;

	}

	public static class Whatever {
		public Id getId() {
			return new Id();
		}
	}

	public static class DummyProcessObjectClass {
		public Whatever internalMethod() {
			return new Whatever();
		}

		public void internalMethodIT() {
			throw new RuntimeException();
		}

		public Id getId() {
			return new Id();
		}
	}

	public static class Something {
		public void foo(DummyProcessObjectClass poc) {

		}
	}

	public static Acl getAcl(boolean granted, boolean grantedThrow) {
		DummyAcl acl = new DummyAcl();
		acl.setGranted(granted);
		acl.setGrantedThrow(grantedThrow);
		return acl;
	}

	public static AclService getAclService(Acl acl) {
		DummyAclService aclService = new DummyAclService();
		aclService.setAcl(acl);
		return aclService;
	}

	public static Permission[] getPermissions(int i) {
		if (i == 0) {
			return new Permission[] {};
		} else if (i == 1) {
			Permission permission = new DummyPermission();
			return new Permission[] { permission };
		}
		throw new IllegalArgumentException();
	}

	public static AclEntryVoter getVoter(int nbPermissions, Acl acl) {
		AclService aclService = getAclService(acl);
		if (nbPermissions == -1) {
			return new AclEntryVoter(aclService, PROCESS_CONFIG_ATTRIBUTE, null);
		} else {
			Permission[] permissions = getPermissions(nbPermissions);
			return new AclEntryVoter(aclService, PROCESS_CONFIG_ATTRIBUTE, permissions);
		}
	}

	public static Authentication getAuthentication() {
		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setPrincipal(new Object());
		return authentication;
	}

	public static Collection<ConfigAttribute> getAttributes(Attributes kind) {

		ArrayList<ConfigAttribute> attributes = new ArrayList<>();

		switch (kind) {
		case NONE:
			break;
		case NAME_NOT_SET: {
			DummyConfigAttribute attribute = new DummyConfigAttribute();
			attributes.add(attribute);
			break;
		}
		case NAME_SET: {
			DummyConfigAttribute attribute = new DummyConfigAttribute();
			attribute.setAttribute(PROCESS_CONFIG_ATTRIBUTE);
			attributes.add(attribute);
			break;
		}
		default:
		}
		return attributes;
	}

	public static MethodInvocation getMethodInvocation(boolean nullPoc)
			throws NoSuchMethodException, SecurityException {
		DummyMethodInvocation methodInvocation = new DummyMethodInvocation();
		methodInvocation.setMethod(S.Something.class.getMethod("foo", S.DummyProcessObjectClass.class));
		methodInvocation.setArguments(new Object[] { nullPoc ? null : new S.DummyProcessObjectClass() });
		return methodInvocation;
	}
}

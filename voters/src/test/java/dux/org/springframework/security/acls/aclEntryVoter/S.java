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

	public static Acl getAcl(boolean granted) {
		DummyAcl acl = new DummyAcl();
		acl.setGranted(granted);
		return acl;
	}

	public static AclService getAclService(Acl acl) {
		DummyAclService aclService = new DummyAclService();
		aclService.setAcl(acl);
		return aclService;
	}

	public static Permission[] getPermissions() {
		Permission permission = new DummyPermission();
		return new Permission[] { permission };
	}

	public static AclEntryVoter getVoter(Acl acl) {
		AclService aclService = getAclService(acl);
		Permission[] permissions = getPermissions();
		return new AclEntryVoter(aclService, PROCESS_CONFIG_ATTRIBUTE, permissions);
	}

	public static Authentication getAuthentication() {
		DummyAuthentication authentication = new DummyAuthentication();
		authentication.setPrincipal(new Object());
		return authentication;
	}

	public static Collection<ConfigAttribute> getAttributes(String attribute) {

		ArrayList<ConfigAttribute> attributes = new ArrayList<>();

		if (attribute != null) {
			attributes.add(new DummyConfigAttribute(attribute));

		}
		return attributes;
	}

	public static MethodInvocation getMethodInvocation() throws NoSuchMethodException, SecurityException {
		DummyMethodInvocation methodInvocation = new DummyMethodInvocation();
		methodInvocation.setMethod(S.Something.class.getMethod("foo", S.DummyProcessObjectClass.class));
		methodInvocation.setArguments(new Object[] { new S.DummyProcessObjectClass() });
		return methodInvocation;
	}
}

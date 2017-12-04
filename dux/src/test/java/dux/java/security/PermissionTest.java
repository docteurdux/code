package dux.java.security;

import java.security.Permission;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class PermissionTest extends AbstractTest {

	@Test
	public void test() {

		/*
		 * The java.security.Permission class is abstract
		 */

		aeq(true, isAbstract(Permission.class));

		/*
		 * Implementing java.security.Permission requires defining getActions, implies,
		 * hashCode and equals ; here an implementation that is pretty useless
		 */

		Permission perm = new Permission("permissionName") {

			private static final long serialVersionUID = 1L;

			@Override
			public boolean implies(Permission permission) {
				return true;
			}

			@Override
			public boolean equals(Object obj) {
				return obj == this;
			}

			@Override
			public int hashCode() {
				return getName().hashCode();
			}

			@Override
			public String getActions() {
				return "actions";
			}

		};

		/*
		 * The name of the permission is as given by the constructor
		 */

		aeq("permissionName", perm.getName());

		/*
		 * The string rendition outputs the classname, the permission name and the
		 * actions by default
		 */

		aeq("(\"dux.java.security.PermissionTest$1\" \"permissionName\" \"actions\")", perm.toString());

		/*
		 * The newPermissionCollection returns null by default
		 */
		aeq(null, perm.newPermissionCollection());

		/*
		 * Finally, the most mysterious method is checkGuard. By default, it doesn't use
		 * the object which is provided to it, and delegates to the system's
		 * SecurityManager when one is defined. The security manager delegates the check
		 * to java.security.AccessController's checkPermission. The real work is
		 * actually transferred to java.security.AccessControlContext.
		 * 
		 * TODO : continue this paragraph after studying java.security.AccessController
		 * and java.security.AccessControlContext
		 */

		perm.checkGuard(null);

		/*-
		 * checkGuard(Object)
		newPermissionCollection()
		 */

	}

}

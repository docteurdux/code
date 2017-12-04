package dux.java.security;

import java.security.AllPermission;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.ProtectionDomain;
import java.util.Enumeration;

import javax.sound.sampled.LineUnavailableException;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class ProtectionDomainTest extends AbstractTest {
	@Test
	public void test() throws LineUnavailableException {

		/*
		 * Our interest here is java.security.ProtectionDomain
		 */

		/*
		 * There are two ways of instanciating java.security.ProtectionDomain. One
		 * involves providing a java.security.CodeSource and a
		 * java.security.PermissionCollection
		 * 
		 * The other requires additionally supplyng a java.lang.ClassLoader and an array
		 * of java.security.Principal
		 * 
		 * Fortunately, protection domains are already provided by class loaders, so we
		 * can start with java.lang.Object's ProtectionDomain
		 * 
		 */

		ProtectionDomain protectionDomain = Object.class.getProtectionDomain();

		/*
		 * getCodeSource returns null
		 */
		aeq(null, protectionDomain.getCodeSource());

		/*
		 * getPermissions returns a PermissionCollection which contains
		 * java.security.AllPermission
		 */

		PermissionCollection permissions = protectionDomain.getPermissions();
		Enumeration<Permission> it = protectionDomain.getPermissions().elements();
		aeq(true, it.nextElement() instanceof AllPermission);
		aeq(false, it.hasMoreElements());

		/*
		 * The array of java.security.Principal is empty
		 */
		aeq(0, protectionDomain.getPrincipals().length);

		/*
		 * The class loader is null
		 */

		aeq(null, protectionDomain.getClassLoader());

		

		/*-
		getClassLoader()
		getCodeSource()
		getPermissions()
		getPrincipals()
		implies(Permission)
		toString()
		 */
	}
}

package dux.java.lang;

import java.security.Permission;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class SecurityManagerTest extends AbstractTest {

	@Test
	public void test() {
		SecurityManager sm = new SecurityManager();
		Permission perm=null;
		sm.checkPermission(perm);
	}
}

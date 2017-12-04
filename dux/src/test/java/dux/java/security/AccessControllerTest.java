package dux.java.security;

import java.security.AccessController;
import java.security.PrivilegedAction;

import org.junit.Test;

public class AccessControllerTest {

	@Test
	public void test() {
		AccessController.doPrivileged(new PrivilegedAction<Void>() {
			@Override
			public Void run() {
				return null;
			}
		});
	}
}

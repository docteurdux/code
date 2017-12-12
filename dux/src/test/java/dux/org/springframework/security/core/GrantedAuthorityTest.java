package dux.org.springframework.security.core;

import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(GrantedAuthority.class)
public class GrantedAuthorityTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.security.core.GrantedAuthority only defines the
		 * getAuthority() method which returns a String
		 */

		/*
		 * An example is
		 * org.springframework.security.core.authority.SimpleGrantedAuthority
		 */

		SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority("role");
		aeq("role", grantedAuthority.getAuthority());
	}
}

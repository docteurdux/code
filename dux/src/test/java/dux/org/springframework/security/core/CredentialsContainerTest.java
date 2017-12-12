package dux.org.springframework.security.core;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.userdetails.User;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(CredentialsContainer.class)
public class CredentialsContainerTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.security.core.CredentialsContainer define the
		 * eraseCredentials() method
		 */

		/*
		 * As an example, org.springframework.security.core.userdetails.User implements CredentialsContainer and clears the
		 * password field when eraseCredentials() is called
		 */

		User user = new User("username", "password", new ArrayList<>());

		aeq("password", user.getPassword());
		user.eraseCredentials();
		aeq(null, user.getPassword());
	}
}

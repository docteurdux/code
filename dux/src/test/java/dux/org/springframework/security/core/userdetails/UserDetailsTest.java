package dux.org.springframework.security.core.userdetails;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Recorder;
import com.github.docteurdux.test.Topic;

@Topic(UserDetails.class)
public class UserDetailsTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.security.core.userdetails.UserDetails represents a
		 * standard user, which has a username, a password, authorities, and can be
		 * locked, disabled or have expired
		 */

		/*
		 * org.springframework.security.core.userdetails.User is an implementation of
		 * UserDetails
		 */

		GrantedAuthority authority = Recorder.create(GrantedAuthority.class).p();
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(authority);
		User user = new User("username", "password", authorities);

		aeq("username", user.getUsername());
		aeq("password", user.getPassword());
		aeqr(authority, user.getAuthorities().iterator().next());
		aeq(true, user.isAccountNonExpired());
		aeq(true, user.isAccountNonLocked());
		aeq(true, user.isEnabled());
		aeq(true, user.isCredentialsNonExpired());

	}
}

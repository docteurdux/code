package dux.org.springframework.security.core.userdetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.security.core.userdetails.cache.NullUserCacheTest;

@Topic(UserCache.class)
@Related({ NullUserCacheTest.class })
public class UserCacheTest extends AbstractTest {
	@Test
	public void test() {

		/*
		 * org.springframework.security.core.userdetails.UserCache defines method to
		 * add/get/remove instances of
		 * org.springframework.security.core.userdetails.UserDetails according to
		 * username
		 */

		User user = new User("username", "password", new ArrayList<>());

		UserCache cache = new UserCache() {

			private Map<String, UserDetails> users = new HashMap<>();

			@Override
			public void removeUserFromCache(String username) {
				users.remove(username);
			}

			@Override
			public void putUserInCache(UserDetails user) {
				users.put(user.getUsername(), user);
			}

			@Override
			public UserDetails getUserFromCache(String username) {
				return users.get(username);
			}
		};

		cache.putUserInCache(user);
		aeqr(user, cache.getUserFromCache("username"));
		cache.removeUserFromCache("username");

	}
}

package dux.org.springframework.security.core.userdetails.cache;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.cache.NullUserCache;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Related;
import com.github.docteurdux.test.Topic;

import dux.org.springframework.security.core.userdetails.UserCacheTest;

@Topic(NullUserCache.class)
@Related({ UserCacheTest.class })
public class NullUserCacheTest extends AbstractTest {

	@Test
	public void test() {

		/*
		 * org.springframework.security.core.userdetails.cache.NullUserCache is an
		 * implementation of org.springframework.security.core.userdetails.UserCache
		 * that really does nothing
		 */

		User user = new User("username", "password", new ArrayList<>());

		NullUserCache cache = new NullUserCache();

		/* This does nothing */
		cache.putUserInCache(user);

		/* This always returns null */
		aeq(null, cache.getUserFromCache("username"));

		/* Ths does nothing */
		cache.removeUserFromCache("username");

	}

}

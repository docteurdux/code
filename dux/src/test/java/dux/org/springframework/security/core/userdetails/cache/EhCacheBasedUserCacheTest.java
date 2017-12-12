package dux.org.springframework.security.core.userdetails.cache;

import java.util.ArrayList;

import org.junit.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.cache.EhCacheBasedUserCache;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Topic;

@Topic(EhCacheBasedUserCache.class)
public class EhCacheBasedUserCacheTest extends AbstractTest {
	@Test
	public void test() {

		User user = new User("username", "password", new ArrayList<>());

		EhCacheBasedUserCache cache = new EhCacheBasedUserCache();
		cache.putUserInCache(user);
	}
}

package dux.org.springframework.security.web.context;

import java.lang.reflect.Field;

import org.junit.Assert;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContextHolderUtils {

	public static void assertThreadLocalStrategy()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Field field = SecurityContextHolder.class.getDeclaredField("strategy");
		field.setAccessible(true);
		Object strategy = field.get(null);
		Assert.assertEquals("org.springframework.security.core.context.ThreadLocalSecurityContextHolderStrategy",
				strategy.getClass().getName());
	}

}

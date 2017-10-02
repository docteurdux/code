package duu.org.springframework.security.web.context.request.async;

import java.lang.reflect.Field;

import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

public class WebAsyncManagerUtils {

	public static Object getCallableInterceptorKey()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = WebAsyncManagerIntegrationFilter.class.getDeclaredField("CALLABLE_INTERCEPTOR_KEY");
		field.setAccessible(true);
		return field.get(null);
	}

}

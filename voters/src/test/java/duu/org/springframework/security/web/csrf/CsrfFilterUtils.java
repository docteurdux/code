package duu.org.springframework.security.web.csrf;

import java.lang.reflect.Field;

import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;

public class CsrfFilterUtils {

	public static CsrfTokenRepository getTokenRepository(CsrfFilter csrfFilter)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = CsrfFilter.class.getDeclaredField("tokenRepository");
		field.setAccessible(true);
		return (CsrfTokenRepository) field.get(csrfFilter);
	}

}

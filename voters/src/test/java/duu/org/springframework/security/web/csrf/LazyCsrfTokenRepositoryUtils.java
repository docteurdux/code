package duu.org.springframework.security.web.csrf;

import java.lang.reflect.Field;

import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.LazyCsrfTokenRepository;

public class LazyCsrfTokenRepositoryUtils {

	public static CsrfTokenRepository getDelegate(LazyCsrfTokenRepository repository)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = LazyCsrfTokenRepository.class.getDeclaredField("delegate");
		field.setAccessible(true);
		return (CsrfTokenRepository) field.get(repository);

	}

}

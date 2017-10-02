package duu.java.lang.reflect;

import java.lang.reflect.Field;

public class FieldUtils {

	public static Object getFieldValue(Class<?> clazz, String name, Object object) {
		try {
			Field field = clazz.getDeclaredField(name);
			field.setAccessible(true);
			return field.get(object);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

}

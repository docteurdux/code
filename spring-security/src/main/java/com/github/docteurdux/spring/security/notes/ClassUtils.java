package com.github.docteurdux.spring.security.notes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class ClassUtils {

	public static boolean isInterface(Class<?> clazz) {
		return clazz.isInterface();
	}

	private static Partition<Class<?>> filter(Collection<Class<?>> classes, Predicate<Class<?>> predicate) {
		List<Class<?>> match = new ArrayList<>();
		List<Class<?>> nomatch = new ArrayList<>();
		for (Class<?> clazz : classes) {
			if (predicate.match(clazz)) {
				match.add(clazz);
			} else {
				nomatch.add(clazz);
			}
		}
		Partition<Class<?>> p = new Partition<Class<?>>(match, nomatch);
		return p;
	}

	public static void sort(List<Class<?>> list) {
		list.sort(new Comparator<Class<?>>() {
			@Override
			public int compare(Class<?> c1, Class<?> c2) {
				return c1.getName().compareTo(c2.getName());
			}
		});
	}

	public static Partition<Class<?>> filterInterfaces(Collection<Class<?>> classes) {
		return filter(classes, new Predicate<Class<?>>() {
			@Override
			public boolean match(Class<?> clazz) {
				return ClassUtils.isInterface(clazz);
			}

		});
	}

	public static Partition<Class<?>> filterExceptions(Collection<Class<?>> classes) {
		return filter(classes, new Predicate<Class<?>>() {
			@Override
			public boolean match(Class<?> clazz) {

				while (clazz != null) {
					if (clazz == Throwable.class) {
						return true;
					}
					clazz = clazz.getSuperclass();
				}
				return false;
			}

		});
	}

	public static Partition<Class<?>> filterAbstracts(List<Class<?>> classes) {
		return filter(classes, new Predicate<Class<?>>() {
			@Override
			public boolean match(Class<?> clazz) {
				return Modifier.isAbstract(clazz.getModifiers());
			}

		});
	}

	public static Partition<Class<?>> filterStatics(List<Class<?>> classes) {
		return filter(classes, new Predicate<Class<?>>() {
			@Override
			public boolean match(Class<?> clazz) {
				while (clazz != null) {
					for (Method method : clazz.getMethods()) {
						if (Modifier.isStatic(method.getModifiers())) {
							return true;
						}
					}
					clazz = clazz.getSuperclass();
				}
				return false;
			}

		});
	}

	public static Partition<Class<?>> filterDefaultConstructor(List<Class<?>> classes) {
		return filter(classes, new Predicate<Class<?>>() {
			@Override
			public boolean match(Class<?> clazz) {
				for (Constructor<?> c : clazz.getConstructors()) {
					if (c.getParameterCount() == 0) {
						return true;
					}
				}
				return false;
			}

		});
	}

}

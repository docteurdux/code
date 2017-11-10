package com.github.docteurdux.test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.hibernate.stat.internal.CategorizedStatistics;
import org.junit.Assert;

public abstract class AbstractTest {

	protected void at(Boolean b) {
		Assert.assertTrue(b);
	}

	protected void af(Boolean b) {
		Assert.assertFalse(b);
	}

	protected void an(Object o) {
		Assert.assertNull(o);
	}

	protected void ann(Object o) {
		Assert.assertNotNull(o);
	}

	protected void aeq(Object expected, Object actual) {
		Assert.assertEquals(expected, actual);
	}

	protected void aneq(Object expected, Object actual) {
		Assert.assertNotEquals(expected, actual);
	}

	protected void aeqr(Object expected, Object actual) {
		Assert.assertTrue(expected == actual);
	}

	protected TestEvent event(TestEventCollector collector, String name) {
		for (TestEvent event : collector.getTestEvents()) {
			if (name.equals(event.getName())) {
				return event;
			}
		}
		Assert.fail();
		return null;
	}

	protected void noevent(TestEventCollector collector, String name) {
		for (TestEvent event : collector.getTestEvents()) {
			if (name.equals(event.getName())) {
				Assert.fail();
			}
		}
	}

	protected void fail() {
		Assert.fail();
	}

	protected Object getField(Object o, String fieldName) {
		return getField(o, fieldName, o.getClass());
	}

	protected Object getField(Object o, String fieldName, Class<?> clazz) {
		try {
			Field field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(o);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			fail();
			return null;
		}
	}

	protected String str(Object o) {
		if (o == null) {
			return "n$";
		}
		if (o instanceof String) {
			return "s$" + o;
		}
		return "c$" + o.getClass().getName();
	}

	protected void has4(Map<String, ?> map, String key, Class<?> clazz) {
		aeq(clazz.getName(), map.get(key).getClass().getName());
	}

	protected void summary(List<Class<?>> classes) {
		summary(classes, true);
	}

	protected void summary(List<Class<?>> classes, boolean dumpPackageStats) {
		Map<String, Integer> dones = new HashMap<>();
		Map<String, Integer> notDones = new HashMap<>();
		Set<String> packageNames = new HashSet<>();

		for (Class<?> clazz : classes) {
			if (clazz.isInterface()) {
				continue;
			}
			if (clazz.isEnum()) {
				continue;
			}
			if (isException(clazz)) {
				continue;
			}

			String testClassName = "dux." + clazz.getName() + "Test";
			String packageName = clazz.getPackage().getName();
			packageNames.add(packageName);
			try {
				Class<?> testClass = Class.forName(testClassName);

				if (testClass.isAnnotationPresent(Done.class)) {
					dones.put(packageName, get(dones, packageName, 0) + 1);
				} else {
					System.out.println(testClassName + " : not done !");
					notDones.put(packageName, get(notDones, packageName, 0) + 1);
				}
			} catch (ClassNotFoundException e) {
				System.out.println(testClassName + " not found");
				notDones.put(packageName, get(notDones, packageName, 0) + 1);
			}
		}

		int doneTotal = 0;
		int notDoneTotal = 0;

		for (String packageName : packageNames) {
			Integer done = get(dones, packageName, 0);
			Integer notDone = get(notDones, packageName, 0);
			if (dumpPackageStats) {
				System.out.println(packageName + " : " + done + "/" + (done + notDone));
			}
			doneTotal += done;
			notDoneTotal += notDone;
		}

		System.out.println(doneTotal + "/" + (doneTotal + notDoneTotal));

		if (this.getClass().isAnnotationPresent(Done.class) && notDoneTotal > 0) {
			fail();
		}
	}

	protected void summarize(String jarname) throws IOException {

		List<Class<?>> classes = new ArrayList<>();

		Map<String, Long> sizes = new HashMap<>();

		String cp = System.getProperty("java.class.path");
		for (String p : cp.split(";")) {
			if (p.endsWith(".jar") && p.indexOf('\\') > 0) {
				File f = new File(p);
				if (f.getName().matches(".*" + jarname + ".*")) {
					if (f.exists()) {
						ZipFile z = new ZipFile(p);
						Enumeration<? extends ZipEntry> entries = z.entries();
						while (entries.hasMoreElements()) {
							ZipEntry entry = entries.nextElement();
							String name = entry.getName();
							long size = entry.getCompressedSize();
							if (name.endsWith(".class") && !name.contains("$")) {
								name = name.substring(0, name.length() - 6);
								name = name.replaceAll("/", ".");
								try {
									Class<?> clazz = Class.forName(name);
									classes.add(clazz);
									sizes.put(name, size);
								} catch (NoClassDefFoundError e) {
								} catch (ClassNotFoundException e) {
								}
							}
						}
						z.close();
					}
				}
			}
		}

		classes.sort(new Comparator<Class<?>>() {
			@Override
			public int compare(Class<?> c1, Class<?> c2) {
				Long s1 = sizes.get(c1.getName());
				Long s2 = sizes.get(c2.getName());
				if (s1 == null) {
					s1 = 0L;
				}
				if (s2 == null) {
					s2 = 0L;
				}
				return s1 < s2 ? 1 : s1 > s2 ? -1 : 0;
			}

		});

		summary(classes, false);
	}

	private boolean isException(Class<?> clazz) {
		while (clazz != null) {
			if (clazz == Exception.class) {
				return true;
			}
			clazz = clazz.getSuperclass();
		}
		return false;
	}

	private <T, U> U get(Map<T, U> map, T key, U defaultValue) {
		U value = map.get(key);
		if (value == null) {
			return defaultValue;
		}
		return value;
	}

	protected void dumpTestEvents(TestEventCollector tec) {
		for (TestEvent te : tec.getTestEvents()) {
			System.out.println(te.getName());
			for (Entry<String, Object> prop : te.getProps().entrySet()) {
				System.out.println(" - " + prop.getKey() + " : " + str(prop.getValue()));
			}
		}
	}

	@SuppressWarnings("unchecked")
	protected <T> T instantiate(Class<?> clazz, Class<?>[] types, Object... params)
			throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Constructor<?> constructor = clazz.getDeclaredConstructor(types);
		constructor.setAccessible(true);
		return (T) constructor.newInstance(params);
	}

	protected Object invoke(Object o, String name) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = o.getClass().getDeclaredMethod(name);
		m.setAccessible(true);
		return m.invoke(o);
	}

	protected Object invoke(Object o, String name, Object... params) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Class<?>[] parameterTypes = new Class<?>[params.length];
		for (int i = 0; i < params.length; ++i) {
			parameterTypes[i] = params[i].getClass();
		}
		Method m = o.getClass().getDeclaredMethod(name, parameterTypes);
		m.setAccessible(true);
		return m.invoke(o, params);
	}

}

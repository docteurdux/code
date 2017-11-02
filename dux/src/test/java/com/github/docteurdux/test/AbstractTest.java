package com.github.docteurdux.test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
		try {
			Field field = o.getClass().getDeclaredField(fieldName);
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
			System.out.println(packageName + " : " + done + "/" + (done + notDone));
			doneTotal += done;
			notDoneTotal += notDone;
		}

		System.out.println(doneTotal + "/" + (doneTotal + notDoneTotal));

		if (this.getClass().isAnnotationPresent(Done.class) && notDoneTotal > 0) {
			fail();
		}
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
}

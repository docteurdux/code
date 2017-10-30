package com.github.docteurdux.test;

import java.lang.reflect.Field;
import java.util.Map;

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
}

package com.github.docteurdux.test;

import java.util.List;

import org.junit.Assert;

public abstract class DuxTest {

	public void aeq(Object expected, Object actual) {
		Assert.assertEquals(expected, actual);
	}

	public void atrue(boolean condition) {
		Assert.assertTrue(condition);
	}

	public void acclass(List<?> items, Class<?> clazz) {
		for (Object item : items) {
			if (item != null && item.getClass() == clazz) {
				return;
			}
		}
		Assert.fail("Item of class " + clazz.getName() + " not found");
	}

	@SuppressWarnings("unchecked")
	public <T> T got(List<?> items, Class<T> clazz) {
		for (Object item : items) {
			if (item != null && item.getClass() == clazz) {
				return (T) item;
			}
		}
		Assert.fail();
		return null;
	}

	public void foo(Object object) {

	}

}

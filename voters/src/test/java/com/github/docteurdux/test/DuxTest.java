package com.github.docteurdux.test;

import java.util.List;

import javax.servlet.Filter;

import org.junit.Assert;
import org.springframework.security.web.csrf.CsrfFilter;

public abstract class DuxTest {

	public void aeq(String expected, String actual) {
		Assert.assertEquals(expected, actual);
	}

	public void aeq(int expected, int actual) {
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

}

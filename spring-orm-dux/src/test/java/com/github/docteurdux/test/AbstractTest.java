package com.github.docteurdux.test;

import java.util.Collection;
import java.util.Iterator;

import org.junit.Assert;

public abstract class AbstractTest {

	public void aeq(Object a, Object b) {
		Assert.assertEquals(a, b);
	}

	public void at(Boolean b) {
		Assert.assertTrue(b);
	}
	
	public void af(Boolean b) {
		Assert.assertFalse(b);
	}
	
	
	public void an(Object o) {
		Assert.assertNull(o);
	}
	
	public void ann(Object o) {
		Assert.assertNotNull(o);
	}
	
	public void ai(Object o, Class<?> clazz) {
		Assert.assertTrue(clazz.isAssignableFrom(o.getClass()));
	}

	@SuppressWarnings("unchecked")
	public <T> T got(Collection<?> items, Class<T> clazz) {
		if (items == null) {
			Assert.fail();
			return null;
		}
		Iterator<?> it = items.iterator();
		while (it.hasNext()) {
			Object n = it.next();
			if (n != null && clazz.isAssignableFrom(n.getClass())) {
				return (T) n;
			}
		}
		Assert.fail();
		return null;
	}
}

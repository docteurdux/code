package com.github.docteurdux.test;

import org.junit.Assert;

public abstract class AbstractTest {

	public void at(Boolean b) {
		Assert.assertTrue(b);
	}

	public void af(Boolean b) {
		Assert.assertFalse(b);
	}

	public void an(Object o) {
		Assert.assertNull(o);
	}

	public void aeq(Object expected, Object actual) {
		Assert.assertEquals(expected, actual);
	}

	public void event(TestEventCollector collector, String name) {
		for (TestEvent event : collector.getTestEvents()) {
			if (name.equals(event.getName())) {
				return;
			}
		}
		Assert.fail();
	}
}

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

	public void ann(Object o) {
		Assert.assertNotNull(o);
	}

	public void aeq(Object expected, Object actual) {
		Assert.assertEquals(expected, actual);
	}

	public TestEvent event(TestEventCollector collector, String name) {
		for (TestEvent event : collector.getTestEvents()) {
			if (name.equals(event.getName())) {
				return event;
			}
		}
		Assert.fail();
		return null;
	}

	public void noevent(TestEventCollector collector, String name) {
		for (TestEvent event : collector.getTestEvents()) {
			if (name.equals(event.getName())) {
				Assert.fail();
			}
		}
	}

	public void fail() {
		Assert.fail();
	}
}

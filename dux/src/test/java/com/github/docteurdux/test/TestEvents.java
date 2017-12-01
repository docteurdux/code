package com.github.docteurdux.test;

import java.util.ArrayList;
import java.util.List;

public class TestEvents {

	public static class Identity {
		
		private String name;

		public Identity(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

	}

	private static List<TestEvent> testEvents = new ArrayList<>();

	public static TestEvent record(Object source, String name, Object... params) {
		TestEvent testEvent = new TestEvent(getIdentity(source), name, params);
		testEvents.add(testEvent);
		return testEvent;
	}

	public static List<TestEvent> getTestEvents() {
		return testEvents;
	}

	public static String getIdentity(Object o) {
		if (o instanceof Identity) {
			return ((Identity) o).getName();
		}
		return o.getClass().getName() + "@" + System.identityHashCode(o);
	}

}

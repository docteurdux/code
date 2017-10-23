package com.github.docteurdux.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class TestEventCollector {

	protected List<TestEvent> testEvents = new ArrayList<TestEvent>();

	public List<TestEvent> getTestEvents() {
		return Collections.unmodifiableList(testEvents);
	}
	
	
}

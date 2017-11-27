package com.github.docteurdux.test;

import java.util.ArrayList;
import java.util.List;

public abstract class TestEventCollector {

	protected List<TestEvent> testEvents = new ArrayList<>();
	private String testEventSourceName;

	public List<TestEvent> getTestEvents() {
		return testEvents;
	}

	public String getTestEventSourceName() {
		return testEventSourceName;
	}

	public void setTestEventSourceName(String testEventSourceName) {
		this.testEventSourceName = testEventSourceName;

	}

}

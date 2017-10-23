package com.github.docteurdux.test;

import java.util.HashMap;
import java.util.Map;

public class TestEvent {

	private String name;
	private Map<String, Object> props = new HashMap<>();

	public TestEvent(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public TestEvent prop(String name, Object value) {
		props.put(name, value);
		return this;
	}

	public Map<String, Object> getProps() {
		return props;
	}

}

package com.github.docteurdux.test;

import java.util.HashMap;
import java.util.Map;

public class TestEvent {

	private static int nextId = 0;

	private int id;
	private String name;
	private String source;
	private Map<String, Object> props = new HashMap<>();

	public TestEvent(String name) {
		this.id = nextId++;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Object prop(String name) {
		return props.get(name);
	}

	public TestEvent prop(String name, Object value) {
		props.put(name, value);
		return this;
	}

	public Map<String, Object> getProps() {
		return props;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}

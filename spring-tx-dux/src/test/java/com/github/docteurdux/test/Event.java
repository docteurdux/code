package com.github.docteurdux.test;

import java.util.HashMap;
import java.util.Map;

public class Event {

	String name;
	Map<String, Object> props = new HashMap<String, Object>();

	public Event(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Object> getProps() {
		return props;
	}

	public Event prop(String name, Object o) {
		props.put(name, o);
		return this;
	}

}

package com.github.docteurdux.test;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestEvent {

	private static ObjectMapper om = new ObjectMapper();

	private static int nextId = 0;

	private int id;
	private String name;
	private String source;
	private Map<String, Object> props = new HashMap<>();

	private Object result;

	private boolean hasResult;

	public TestEvent(String name) {
		this.id = nextId++;
		this.name = name;
	}

	public TestEvent(String source, String name, Object[] params) {
		this(name);
		this.source = source;
		for (int i = 0; i < params.length; ++i) {
			prop("arg" + i, json(sumup(params[i])));
		}
	}

	private Object json(Object o) {
		try {
			return om.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	private Object sumup(Object o) {
		if (o == null) {
			return o;
		}
		o = Proxyfier.getHandle(o);
		if (o instanceof String) {
			return o;
		}
		Class<? extends Object> clazz = o.getClass();
		if (clazz.isPrimitive()) {
			return o;
		}
		try {
			if (((Class<?>) (clazz.getField("TYPE").get(null))).isPrimitive()) {
				return o;
			}
		} catch (Exception e) {
		}
		if (clazz.isArray() && clazz.getComponentType().isPrimitive()) {
			return o;
		}
		if (o instanceof Delegating) {
			return TestEvents.getIdentity(((Delegating) o).getTestDelegate());
		}
		return TestEvents.getIdentity(o);
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

	public <T> T result(T result) {
		this.result = json(sumup(result));
		hasResult = true;
		return result;
	}

	public boolean hasResult() {
		return hasResult;
	}

	public Object getResult() {
		return result;
	}

}

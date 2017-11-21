package com.github.docteurdux.test;

import java.util.Map;

public abstract class TEI {

	private String name;

	public TEI(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	abstract protected void i(Map<String, Object> props);

}

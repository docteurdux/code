package dum.java.util;

import java.util.Enumeration;

public class DummyEnumeration<T> implements Enumeration<T> {

	boolean called;
	private T element;

	public DummyEnumeration(T element) {
		this.element = element;
	}

	@Override
	public boolean hasMoreElements() {
		return !called;
	}

	@Override
	public T nextElement() {
		called = true;
		return element;
	}

}

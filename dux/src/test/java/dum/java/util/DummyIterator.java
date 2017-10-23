package dum.java.util;

import java.util.Iterator;

public class DummyIterator<T> implements Iterator<Object> {

	public boolean hasNext() {
		return false;
	}

	public Object next() {
		return null;
	}

}

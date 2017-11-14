package dum.java.lang.Iterable;

import java.util.Iterator;

public class DummyIterable<T> implements Iterable<T> {

	private Iterator<T> iterator;

	@Override
	public Iterator<T> iterator() {
		return iterator;
	}

	public void setIterator(Iterator<T> iterator) {
		this.iterator = iterator;
	}

}

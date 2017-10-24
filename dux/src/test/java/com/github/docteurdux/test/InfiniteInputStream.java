package com.github.docteurdux.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class InfiniteInputStream extends InputStream {

	boolean infinite = true;
	Deque<Number> bytes = new ArrayDeque<>();

	private Integer skyLimit;
	private int infiniteCount;

	@Override
	public int read() throws IOException {

		if (bytes.size() == 0) {
			if (infinite && infiniteCount < skyLimit) {
				++infiniteCount;
				return 0;
			} else {
				return -1;
			}
		}
		Number pop = bytes.pop();
		if (pop instanceof Byte) {
			return (Byte) pop;
		} else if (pop instanceof Integer) {
			return (Integer) pop;
		} else {
			throw new IllegalArgumentException();
		}

	}

	public void add(byte[] bytes) {
		for (byte b : bytes) {
			this.bytes.add(b);
		}
	}

	public void add(Collection<Byte> bytes) {
		this.bytes.addAll(bytes);
	}

	@Override
	public int available() throws IOException {
		return bytes.size() + (infinite ? 1 : 0);
	}

	public void setInfinite(boolean infinite) {
		this.infinite = infinite;
	}

	public void setSkyLimit(int skyLimit) {
		this.skyLimit = skyLimit;
	}

	public int getInfiniteCount() {
		return infiniteCount;
	}

	public void addEOF() {
		this.bytes.add(new Integer(-1));
	}

}

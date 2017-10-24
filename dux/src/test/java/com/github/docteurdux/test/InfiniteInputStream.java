package com.github.docteurdux.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;

public class InfiniteInputStream extends InputStream {

	boolean infinite = true;
	Deque<Byte> bytes = new ArrayDeque<>();

	@Override
	public int read() throws IOException {

		if (bytes.size() == 0) {
			return infinite ? 0 : -1;
		}
		return bytes.pop();

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

}

package dum.java.io;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import com.github.docteurdux.test.TestEvent;
import com.github.docteurdux.test.TestEventCollector;

public class DummyReader extends Reader {

	private int pos;
	private char[] chars = new char[] {};
	private boolean looping;
	TestEventCollector testEventCollector = new TestEventCollector() {
	};

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {

		if (chars == null || chars.length == 0) {
			return -1;
		}

		for (int i = off; i < len; ++i) {

			if (pos == chars.length) {
				if (looping) {
					pos = 0;
				} else {
					return -1;
				}
			}

			cbuf[i] = chars[pos];
			++pos;
		}

		return cbuf[off + len-1];
	}

	@Override
	public void close() throws IOException {
		testEventCollector.getTestEvents().add(new TestEvent("close"));
	}

	public void setOutput(char... chars) {
		this.chars = chars;
		pos = 0;
	}

	public void setLooping(boolean looping) {
		this.looping = looping;

	}

	public List<TestEvent> getTestEvents() {
		return testEventCollector.getTestEvents();
	}

}

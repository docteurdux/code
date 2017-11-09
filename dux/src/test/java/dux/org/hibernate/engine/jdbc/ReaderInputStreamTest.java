package dux.org.hibernate.engine.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.hibernate.engine.jdbc.ReaderInputStream;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ReaderInputStreamTest extends AbstractTest {

	private Reader reader;

	@Before
	public void before() {

		reader = new Reader() {

			@Override
			public int read(char[] cbuf, int off, int len) throws IOException {
				cbuf[0] = 7;
				return cbuf[0] = 7;
			}

			@Override
			public void close() throws IOException {
			}
		};
	}

	@Test
	public void test() throws Exception {

		aeq(InputStream.class, ReaderInputStream.class.getSuperclass());

		ReaderInputStream ris = new ReaderInputStream(reader);
		aeq(7, ris.read());
		ris.close();

	}
}

package dux.org.hibernate.lob;

import org.hibernate.lob.ReaderInputStream;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.java.io.DummyReader;

@Done
@SuppressWarnings("deprecation")
public class ReaderInputStreamTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		at(ReaderInputStream.class.isAnnotationPresent(Deprecated.class));

		aeq(org.hibernate.engine.jdbc.ReaderInputStream.class, ReaderInputStream.class.getSuperclass());

		DummyReader reader = new DummyReader();
		reader.setOutput('a');
		ReaderInputStream ris = new ReaderInputStream(reader);
		aeq('a', ris.read());
	}
}

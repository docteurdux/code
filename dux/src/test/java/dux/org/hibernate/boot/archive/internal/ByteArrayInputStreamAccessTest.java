package dux.org.hibernate.boot.archive.internal;

import org.hibernate.boot.archive.internal.ByteArrayInputStreamAccess;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ByteArrayInputStreamAccessTest extends AbstractTest {

	private String name;
	private byte[] bytes;

	@Before
	public void before() {
		name = "name";
		bytes = new byte[] { 7 };
	}

	@Test
	public void test() throws Exception {

		ByteArrayInputStreamAccess baisa = new ByteArrayInputStreamAccess(name, bytes);
		aeq(name, baisa.getStreamName());
		aeq(7, baisa.accessInputStream().read());
	}
}

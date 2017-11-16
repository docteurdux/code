package dux.org.hibernate.engine.jdbc.internal;

import org.hibernate.engine.jdbc.internal.BinaryStreamImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class BinaryStreamImplTest extends AbstractTest {

	private byte[] bytes;

	@Before
	public void before() {
		bytes = new byte[] {};
	}

	@Test
	public void test() {

		BinaryStreamImpl bsi = new BinaryStreamImpl(bytes);

		aeqr(bsi, bsi.getInputStream());
		aeqr(bytes, bsi.getBytes());
		aeq((long) bytes.length, bsi.getLength());

		// actually does nothing
		bsi.release();
	}
}

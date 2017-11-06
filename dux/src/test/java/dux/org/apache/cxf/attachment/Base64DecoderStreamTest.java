package dux.org.apache.cxf.attachment;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.cxf.attachment.Base64DecoderStream;
import org.junit.Test;

public class Base64DecoderStreamTest {
	@Test
	public void test() {
		InputStream bais = new ByteArrayInputStream(new byte[] {});
		Base64DecoderStream bds = new Base64DecoderStream(bais);

	}
}

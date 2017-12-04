package dux.sun.security.provider.certpath;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.cert.CertificateException;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class X509CertPathTest extends AbstractTest {
	@Test
	public void test() throws ClassNotFoundException, CertificateException {
		Class.forName("sun.security.provider.certpath.X509CertPath");
		ByteArrayInputStream bais = new ByteArrayInputStream(new byte[] {});
		sun.security.provider.certpath.X509CertPath cp = new sun.security.provider.certpath.X509CertPath(
				(InputStream) bais);

	}
}

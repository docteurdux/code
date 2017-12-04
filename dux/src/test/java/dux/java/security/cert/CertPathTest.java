package dux.java.security.cert;

import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class CertPathTest extends AbstractTest {
	@Test
	public void test() {
		CertPath cp = new CertPath("certPathType") {

			@Override
			public Iterator<String> getEncodings() {
				return new ArrayList<String>().iterator();
			}

			@Override
			public byte[] getEncoded(String encoding) throws CertificateEncodingException {
				return new byte[] {};
			}

			@Override
			public byte[] getEncoded() throws CertificateEncodingException {
				return new byte[] {};
			}

			@Override
			public List<? extends Certificate> getCertificates() {
				return new ArrayList<Certificate>();
			}
		};
	}
}

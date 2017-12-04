package dux.java.security.cert;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.cert.CertPathBuilder;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class CertPathBuilderTest extends AbstractTest {

	@Test
	public void test() throws NoSuchAlgorithmException {
		CertPathBuilder b = CertPathBuilder.getInstance("PKIX");
		Provider provider = b.getProvider();
		System.out.println(provider.getClass().getName());
		for (Service s : provider.getServices()) {
			System.out.println(s.getAlgorithm());
			System.out.println(s.getType());
		}


	}
}

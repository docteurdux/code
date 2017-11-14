package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmLoaderType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmLoaderTypeTest extends AbstractTest {
	@Test
	public void test() {
		
		JaxbHbmLoaderType jaxbHbmLoaderType = new JaxbHbmLoaderType();
		
		an(jaxbHbmLoaderType.getQueryRef());
		jaxbHbmLoaderType.setQueryRef("queryRef");
		aeq("queryRef", jaxbHbmLoaderType.getQueryRef());

	}
}

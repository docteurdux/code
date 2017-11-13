package dux.org.hibernate.boot.jaxb.hbm.spi;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNaturalIdCacheType;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JaxbHbmNaturalIdCacheTypeTest extends AbstractTest {
	
	@Test
	public void test() {
		JaxbHbmNaturalIdCacheType jaxbHbmNaturalIdCacheType = new JaxbHbmNaturalIdCacheType();

		an(jaxbHbmNaturalIdCacheType.getRegion());
		jaxbHbmNaturalIdCacheType.setRegion("region");
		aeq("region", jaxbHbmNaturalIdCacheType.getRegion());
	}
}

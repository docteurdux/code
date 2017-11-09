package dux.org.hibernate.boot.jaxb.spi;

import org.hibernate.boot.jaxb.Origin;
import org.hibernate.boot.jaxb.SourceType;
import org.hibernate.boot.jaxb.spi.XmlSource;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.boot.jaxb.spi.DummyXmlSource;

@Done
public class XmlSourceTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		Origin origin = new Origin(SourceType.OTHER, "name");
		XmlSource source = new DummyXmlSource(origin);

		aeqr(origin, source.getOrigin());

	}

}

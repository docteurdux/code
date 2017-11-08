package dux.org.apache.cxf.binding.soap;

import java.util.Iterator;

import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.Soap12;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.binding.soap.SoapVersionFactory;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class SoapVersionFactoryTest extends AbstractTest {
	@Test
	public void test() {

		SoapVersionFactory factory = SoapVersionFactory.getInstance();

		Iterator<SoapVersion> versions = factory.getVersions();

		SoapVersion version1 = versions.next();
		SoapVersion version2 = versions.next();

		at(version1 instanceof Soap11 || version1 instanceof Soap12);
		if (version1 instanceof Soap11) {
			at(version2 instanceof Soap12);
		} else {
			at(version2 instanceof Soap11);
		}

		at(factory.getSoapVersion("http://schemas.xmlsoap.org/soap/envelope/") instanceof Soap11);
		at(factory.getSoapVersion("http://www.w3.org/2003/05/soap-envelope") instanceof Soap12);

	}
}

package dux.javax.xml.bind;

import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class JAXBContextTest extends AbstractTest {

	@XmlRootElement
	public static class A {

	}

	@Test
	public void test1() throws Exception {

		JAXBContext context = JAXBContext.newInstance(A.class);

		aeq("com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl", context.getClass().getName());

		Marshaller marshaller = context.createMarshaller();

		aeq("com.sun.xml.internal.bind.v2.runtime.MarshallerImpl", marshaller.getClass().getName());

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		marshaller.marshal(new A(), baos);
		System.out.write(baos.toByteArray());

	}
}

package dux.org.apache.cxf.binding.soap;

import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.message.MessageImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class SoapMessageTest extends AbstractTest {

	@Test
	public void test1() {

		SoapMessage message = new SoapMessage(Soap11.getInstance());

		aeqr(Soap11.getInstance(), message.getVersion());

		af(message.hasHeaders());
		af(message.hasAdditionalEnvNs());

		Object o = new Object();
		QName headerQN = new QName("headerNS", "headerLP");
		QName absentQN = new QName("absentNS", "absentLP");
		Header header = new Header(headerQN, o);
		message.getHeaders().add(header);

		at(message.hasHeaders());
		af(message.hasAdditionalEnvNs());

		at(message.hasHeader(headerQN));
		af(message.hasHeader(absentQN));

		aeqr(o, message.getHeader(headerQN).getObject());
		an(message.getHeader(absentQN));

		an(message.getEnvelopeNs());

		Map<String, String> map = new HashMap<>();
		map.put("a", "b");
		message.put("soap.env.ns.map", map);

		at(message.hasAdditionalEnvNs());

	}

	@Test
	public void test2() {

		SoapMessage message = new SoapMessage(new MessageImpl());
		aeqr(Soap11.getInstance(), message.getVersion());

	}
}

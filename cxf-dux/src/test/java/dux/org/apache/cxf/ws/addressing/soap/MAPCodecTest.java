package dux.org.apache.cxf.ws.addressing.soap;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.headers.Header;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.ExchangeImpl;
import org.apache.cxf.ws.addressing.Names;
import org.apache.cxf.ws.addressing.soap.MAPCodec;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;

public class MAPCodecTest extends AbstractTest {

	private int c;
	private Document document;
	private Exchange exchange;

	@Before
	public void before() throws ParserConfigurationException {
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		exchange = new ExchangeImpl();
	}

	private String dum() {
		return "dum" + (++c);
	}

	@Test
	public void test() {

		SoapMessage message = new SoapMessage(Soap11.getInstance());
		message.setExchange(exchange);
		
		Element element = document.createElementNS(Names.WSA_NAMESPACE_NAME, Names.WSA_MESSAGEID_NAME);
		Header header = new Header(new QName(dum(), dum()), element);
		message.getHeaders().add(header);
		
		element = document.createElementNS(Names.WSA_NAMESPACE_NAME, Names.WSA_TO_NAME);
		header = new Header(new QName(dum(), dum()), element);
		message.getHeaders().add(header);
		
		element = document.createElementNS(Names.WSA_NAMESPACE_NAME, Names.WSA_FROM_NAME);
		header = new Header(new QName(dum(), dum()), element);
		message.getHeaders().add(header);
		
		element = document.createElementNS(Names.WSA_NAMESPACE_NAME, Names.WSA_REPLYTO_NAME);
		header = new Header(new QName(dum(), dum()), element);
		message.getHeaders().add(header);
		
		element = document.createElementNS(Names.WSA_NAMESPACE_NAME, Names.WSA_FAULTTO_NAME);
		header = new Header(new QName(dum(), dum()), element);
		message.getHeaders().add(header);
		
		element = document.createElementNS(Names.WSA_NAMESPACE_NAME, Names.WSA_RELATESTO_NAME);
		header = new Header(new QName(dum(), dum()), element);
		message.getHeaders().add(header);
		
		element = document.createElementNS(Names.WSA_NAMESPACE_NAME, Names.WSA_ACTION_NAME);
		header = new Header(new QName(dum(), dum()), element);
		message.getHeaders().add(header);

		MAPCodec codec = new MAPCodec();
		codec.handleMessage(message);
		// codec.getInstance(bus);
		// codec.decodeAsNative(encodedAs, clz, headerElement, unmarshaller);
		// codec.getUncorrelatedExchanges();
		// codec.getUnderstoodHeaders();
		// codec.handleFault(message);
		// codec.handleMessage(message);
		// codec.unmarshalMAPs(message);
	}
}

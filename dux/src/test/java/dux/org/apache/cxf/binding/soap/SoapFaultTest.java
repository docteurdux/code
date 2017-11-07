package dux.org.apache.cxf.binding.soap;

import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.common.i18n.Message;
import org.apache.cxf.interceptor.Fault;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;

public class SoapFaultTest extends AbstractTest {

	private QName faultCode;
	private String message;
	private Document document;
	private Element detail;

	@Before
	public void before() throws ParserConfigurationException {
		faultCode = new QName("faultCodeNS", "faultCodeLP");
		message = "message";
		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		detail = document.createElementNS("elementNS", "elementLP");
	}

	@Test
	public void test1() {

		Logger logger = Logger.getAnonymousLogger();
		Message msg = new Message(message, logger);
		Fault fault = new Fault(msg, faultCode);
		fault.setDetail(detail);
		SoapFault soapFault = SoapFault.createFault(fault, Soap11.getInstance());

		aeqr(detail, soapFault.getDetail());
		aeq(faultCode, soapFault.getFaultCode());

	}
}

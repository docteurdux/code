package dux.org.apache.cxf.binding.soap;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.cxf.binding.soap.Soap11;
import org.apache.cxf.binding.soap.Soap12;
import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.common.i18n.Message;
import org.apache.cxf.interceptor.Fault;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.java.util.DummyResourceBundle;

@Done
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

	public static enum CF {
		BASE, CLIENT, SERVER, SOAP12_RECEIVER, SOAP12_SENDER, SOAP12_MUSTUNDERSTAND, SOAP12_DATEENCODINGUNKNOWN, SOAP12_VERSIONMISMATCH, SOAP12_OTHER, SOAPFAULT_OTHER, SOAPFAULT_OTHER_SOAP12
	}

	@Test
	public void test1() {

		for (CF cf : CF.values()) {

			System.out.println(cf);

			QName otherQN = new QName("otherNS", "otherLP");

			QName expectedFaultCode = faultCode;
			QName expectedRootFaultCode = null;
			SoapVersion version = Soap11.getInstance();
			boolean createWithSoapFault = false;
			switch (cf) {
			case BASE:
				break;
			case CLIENT:
				faultCode = new QName("http://cxf.apache.org/faultcode", "client");
				expectedFaultCode = new QName("http://schemas.xmlsoap.org/soap/envelope/", "Client");
				break;
			case SERVER:
				faultCode = new QName("http://cxf.apache.org/faultcode", "server");
				expectedFaultCode = new QName("http://schemas.xmlsoap.org/soap/envelope/", "Server");
				break;
			case SOAP12_RECEIVER:
				version = Soap12.getInstance();
				faultCode = new QName("http://www.w3.org/2003/05/soap-envelope", "Receiver");
				expectedFaultCode = faultCode;
				break;
			case SOAP12_SENDER:
				version = Soap12.getInstance();
				faultCode = new QName("http://www.w3.org/2003/05/soap-envelope", "Sender");
				expectedFaultCode = faultCode;
				break;
			case SOAP12_MUSTUNDERSTAND:
				version = Soap12.getInstance();
				faultCode = new QName("http://www.w3.org/2003/05/soap-envelope", "MustUnderstand");
				expectedFaultCode = faultCode;
				break;
			case SOAP12_DATEENCODINGUNKNOWN:
				version = Soap12.getInstance();
				faultCode = new QName("http://www.w3.org/2003/05/soap-envelope", "DataEncodingUnknown");
				expectedFaultCode = faultCode;
				break;
			case SOAP12_VERSIONMISMATCH:
				version = Soap12.getInstance();
				faultCode = new QName("http://www.w3.org/2003/05/soap-envelope", "VersionMismatch");
				expectedFaultCode = faultCode;
				break;
			case SOAP12_OTHER:
				version = Soap12.getInstance();
				faultCode = otherQN;
				expectedFaultCode = new QName("http://www.w3.org/2003/05/soap-envelope", "Receiver");
				expectedRootFaultCode = faultCode;
				break;
			case SOAPFAULT_OTHER:
				createWithSoapFault = true;
			case SOAPFAULT_OTHER_SOAP12:
				version = Soap12.getInstance();
				createWithSoapFault = true;
				faultCode = otherQN;
				expectedFaultCode = new QName("http://www.w3.org/2003/05/soap-envelope", "Receiver");
				expectedRootFaultCode = faultCode;
			}

			Logger logger = Logger.getAnonymousLogger();
			Message msg = new Message(message, logger);
			Fault fault = null;

			if (createWithSoapFault) {
				fault = new SoapFault("message", faultCode);
			} else {
				fault = new Fault(msg, faultCode);
			}

			fault.setDetail(detail);

			SoapFault soapFault = SoapFault.createFault(fault, version);

			aeqr(detail, soapFault.getDetail());
			aeq(expectedFaultCode, soapFault.getFaultCode());
			aeq(expectedRootFaultCode, soapFault.getSubCode());
		}
	}

	@Test
	public void test2() {

		SoapFault fault = new SoapFault("message", faultCode);
		String defaultPrefix = "defaultPrefix";
		aeq("defaultPrefix:faultCodeLP", fault.getCodeString("", defaultPrefix));

		faultCode = new QName("faultCodeNS", "faultCodeLP", "faultCodePrefix");
		fault = new SoapFault("message", faultCode);
		aeq("faultCodePrefix:faultCodeLP", fault.getCodeString("", defaultPrefix));

		aeq("prefix:faultCodeLP", fault.getCodeString("prefix", defaultPrefix));

		fault.setSubCode(new QName("rootSubCodeNS", "rootSubCodeLP"));
		aeq("prefix:rootSubCodeLP", fault.getSubCodeString("prefix", "defaultPrefix"));

	}

	@Test
	public void test3() {
		SoapFault fault = new SoapFault("message", faultCode);

		an(fault.getRole());
		fault.setRole("role");
		aeq("role", fault.getRole());

		an(fault.getNode());
		fault.setNode("node");
		aeq("node", fault.getNode());

		aeq("message", fault.getReason());

		QName subCodeQN = new QName("subCodeNS", "subCodeLP");
		QName subCodeQN2 = new QName("subCodeNS2", "subCodeLP2");
		fault.setSubCode(subCodeQN);
		aeq(subCodeQN, fault.getSubCode());
		aeq(subCodeQN, fault.getSubCodes().get(0));

		fault.addSubCode(subCodeQN2);
		aeq(2, fault.getSubCodes().size());

		aeq(0, fault.getNamespaces().size());
		Map<String, String> namespaces = new HashMap<>();
		fault.setNamespaces(namespaces);
		aeqr(namespaces, fault.getNamespaces());

	}

	@Test
	public void test4() {

		Message i18nMessage = new Message("message", Logger.getAnonymousLogger(), new Object[] {});
		Exception throwable = new Exception();
		ResourceBundle rb = new DummyResourceBundle();

		@SuppressWarnings("unused")
		SoapFault fault = new SoapFault(i18nMessage, throwable, faultCode);
		fault = new SoapFault(i18nMessage, faultCode);
		fault = new SoapFault("message", faultCode);
		fault = new SoapFault("message", rb, faultCode);
		fault = new SoapFault("message", rb, throwable, faultCode);
		fault = new SoapFault("message", rb, faultCode, new Object[] {});
		fault = new SoapFault("message", throwable, faultCode);

	}
}

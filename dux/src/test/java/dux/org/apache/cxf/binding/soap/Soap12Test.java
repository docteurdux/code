package dux.org.apache.cxf.binding.soap;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.Soap12;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class Soap12Test extends AbstractTest {
	@Test
	public void test() {

		aeq("http://www.w3.org/2003/05/soap-envelope", Soap12.SOAP_NAMESPACE);

		Soap12 version = Soap12.getInstance();

		aeq("mustUnderstand", version.getAttrNameMustUnderstand());
		aeq("role", version.getAttrNameRole());
		aeq("false", version.getAttrValueMustUnderstand(false));
		aeq("true", version.getAttrValueMustUnderstand(true));
		aeq("http://schemas.xmlsoap.org/wsdl/soap12/", version.getBindingId());
		aeq(new QName("http://www.w3.org/2003/05/soap-envelope", "Body"), version.getBody());
		aeq("application/soap+xml", version.getContentType());
		aeq(new QName("http://www.w3.org/2003/05/soap-envelope", "DataEncodingUnknown"),
				version.getDateEncodingUnknown());
		aeq(new QName("http://www.w3.org/2003/05/soap-envelope", "Envelope"), version.getEnvelope());
		aeq(new QName("http://www.w3.org/2003/05/soap-envelope", "Fault"), version.getFault());
		aeq(new QName("http://www.w3.org/2003/05/soap-envelope", "Header"), version.getHeader());
		aeq(new QName("http://www.w3.org/2003/05/soap-envelope", "MustUnderstand"), version.getMustUnderstand());
		aeq("http://www.w3.org/2003/05/soap-envelope", version.getNamespace());
		aeq("http://www.w3.org/2003/05/soap-envelope/role/next", version.getNextRole());
		aeq("http://www.w3.org/2003/05/soap-envelope/role/none", version.getNoneRole());
		aeq(new QName("http://www.w3.org/2003/05/soap-envelope", "Receiver"), version.getReceiver());
		aeq(new QName("http://www.w3.org/2003/05/soap-envelope", "Sender"), version.getSender());
		aeq("http://www.w3.org/2003/05/soap-encoding", version.getSoapEncodingStyle());
		aeq("http://www.w3.org/2003/05/soap-envelope/role/ultimateReceiver", version.getUltimateReceiverRole());
		aeq(1.2D, version.getVersion());
		aeq(new QName("http://www.w3.org/2003/05/soap-envelope", "VersionMismatch"), version.getVersionMismatch());
	}
}

package dux.org.apache.cxf.binding.soap;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.Soap11;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class Soap11Test extends AbstractTest {
	@Test
	public void test() {

		aeq(new QName("http://schemas.xmlsoap.org/soap/encoding/", "base64Binary"), Soap11.ENCODED_BASE64);
		aeq(new QName("http://schemas.xmlsoap.org/soap/encoding/", "boolean"), Soap11.ENCODED_BOOLEAN);
		aeq(new QName("http://schemas.xmlsoap.org/soap/encoding/", "char"), Soap11.ENCODED_CHAR);
		aeq(new QName("http://schemas.xmlsoap.org/soap/encoding/", "dateTime"), Soap11.ENCODED_DATETIME);
		aeq(new QName("http://schemas.xmlsoap.org/soap/encoding/", "decimal"), Soap11.ENCODED_DECIMAL);
		aeq(new QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), Soap11.ENCODED_DOUBLE);
		aeq(new QName("http://schemas.xmlsoap.org/soap/encoding/", "float"), Soap11.ENCODED_FLOAT);
		aeq(new QName("http://schemas.xmlsoap.org/soap/encoding/", "int"), Soap11.ENCODED_INT);
		aeq(new QName("http://schemas.xmlsoap.org/soap/encoding/", "integer"), Soap11.ENCODED_INTEGER);
		aeq(new QName("http://schemas.xmlsoap.org/soap/encoding/", "long"), Soap11.ENCODED_LONG);
		aeq(new QName("http://schemas.xmlsoap.org/soap/encoding/", "short"), Soap11.ENCODED_SHORT);
		aeq(new QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), Soap11.ENCODED_STRING);
		aeq("http://schemas.xmlsoap.org/soap/encoding/", Soap11.SOAP_ENCODING_URI);
		aeq("http://schemas.xmlsoap.org/soap/envelope/", Soap11.SOAP_NAMESPACE);

		Soap11 version = Soap11.getInstance();

		aeq("mustUnderstand", version.getAttrNameMustUnderstand());
		aeq("actor", version.getAttrNameRole());
		aeq("0", version.getAttrValueMustUnderstand(false));
		aeq("1", version.getAttrValueMustUnderstand(true));
		aeq("http://schemas.xmlsoap.org/soap/", version.getBindingId());
		aeq(new QName("http://schemas.xmlsoap.org/soap/envelope/", "Body"), version.getBody());
		aeq("text/xml", version.getContentType());
		aeq(null, version.getDateEncodingUnknown());
		aeq(new QName("http://schemas.xmlsoap.org/soap/envelope/", "Envelope"), version.getEnvelope());
		aeq(new QName("http://schemas.xmlsoap.org/soap/envelope/", "Fault"), version.getFault());
		aeq(new QName("http://schemas.xmlsoap.org/soap/envelope/", "Header"), version.getHeader());
		aeq(new QName("http://schemas.xmlsoap.org/soap/envelope/", "MustUnderstand"), version.getMustUnderstand());
		aeq("http://schemas.xmlsoap.org/soap/envelope/", version.getNamespace());
		aeq("http://schemas.xmlsoap.org/soap/actor/next", version.getNextRole());
		aeq("http://schemas.xmlsoap.org/soap/envelope//role/none", version.getNoneRole());
		aeq(new QName("http://schemas.xmlsoap.org/soap/envelope/", "Server"), version.getReceiver());
		aeq(new QName("http://schemas.xmlsoap.org/soap/envelope/", "Client"), version.getSender());
		aeq("http://schemas.xmlsoap.org/soap/encoding/", version.getSoapEncodingStyle());
		aeq("http://schemas.xmlsoap.org/soap/envelope//role/ultimateReceiver", version.getUltimateReceiverRole());
		aeq(1.1D, version.getVersion());
		aeq(new QName("http://schemas.xmlsoap.org/soap/envelope/", "VersionMismatch"), version.getVersionMismatch());
	}

}

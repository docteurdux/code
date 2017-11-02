package dux.org.apache.cxf.ws.addressing.soap;

import java.util.Set;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.cxf.binding.soap.Soap12;
import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.jaxb.JAXBDataBinding;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.addressing.RelatesToType;
import org.apache.cxf.ws.addressing.soap.MAPCodec;
import org.apache.cxf.ws.addressing.soap.VersionTransformer;
import org.apache.cxf.ws.addressing.v200408.AttributedURI;
import org.apache.cxf.ws.addressing.v200408.Relationship;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.xml.bind.DummyJAXBContext;
import dum.javax.xml.bind.DummyUnmarshaller;

@Done
public class VersionTransformerTest extends AbstractTest {

	private MAPCodec codec;
	private Document document;
	private DummyUnmarshaller unmarshaller;
	private Element element;
	private DummyJAXBContext context;

	@Before
	public void before() throws ParserConfigurationException {

		unmarshaller = new DummyUnmarshaller();
		context = new DummyJAXBContext();
		context.setUnmarshaller(unmarshaller);

		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		element = document.createElementNS("namespace", "element");

		codec = new MAPCodec();
	}

	@Test
	public void test001() {
		VersionTransformer transformer = new VersionTransformer(codec);
		ann(transformer);
	}

	@Test
	public void test002() {
		Set<QName> headers = VersionTransformer.HEADERS;

		aeq(18, headers.size());

		String[] namespaces = new String[] { "http://schemas.xmlsoap.org/ws/2004/03/addressing",
				"http://schemas.xmlsoap.org/ws/2004/08/addressing", "http://www.w3.org/2005/08/addressing" };
		String[] names = new String[] { "From", "To", "ReplyTo", "FaultTo", "Action", "MessageID" };

		aeq(18, namespaces.length * names.length);

		for (String ns : namespaces) {
			for (String lp : names) {
				at(headers.contains(new QName(ns, lp)));
			}
		}

	}

	@Test
	public void test003() throws JAXBException {
		VersionTransformer transformer = new VersionTransformer(codec);
		String encodedAs = "http://www.w3.org/2005/08/addressing";

		Object object = new Object();
		unmarshaller.createUnmarshalResult(Object.class, object);

		Object result = transformer.decodeAsNative(encodedAs, Object.class, element, unmarshaller);
		aeqr(object, result);

	}

	@Test
	public void test004() throws JAXBException {
		VersionTransformer transformer = new VersionTransformer(codec);

		org.apache.cxf.ws.addressing.v200408.AttributedURI attributeURI = new org.apache.cxf.ws.addressing.v200408.AttributedURI();
		attributeURI.setValue("http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous");

		unmarshaller.createUnmarshalResult(org.apache.cxf.ws.addressing.v200408.AttributedURI.class, attributeURI);

		String encodedAs = "http://schemas.xmlsoap.org/ws/2004/08/addressing";
		AttributedURIType attributeURIType = transformer.decodeAsNative(encodedAs, AttributedURIType.class, element,
				unmarshaller);

		aeq("http://www.w3.org/2005/08/addressing/anonymous", attributeURIType.getValue());
		aeq(0, attributeURIType.getOtherAttributes().size());

	}

	@Test
	public void test005() throws JAXBException {

		VersionTransformer transformer = new VersionTransformer(codec);

		org.apache.cxf.ws.addressing.v200408.EndpointReferenceType ert48 = new org.apache.cxf.ws.addressing.v200408.EndpointReferenceType();
		ert48.getAddress().setValue("http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous");

		Class<org.apache.cxf.ws.addressing.v200408.EndpointReferenceType> ert48Class = org.apache.cxf.ws.addressing.v200408.EndpointReferenceType.class;
		unmarshaller.createUnmarshalResult(ert48Class, ert48);

		String encodedAs = "http://schemas.xmlsoap.org/ws/2004/08/addressing";
		EndpointReferenceType ert = transformer.decodeAsNative(encodedAs, EndpointReferenceType.class, element,
				unmarshaller);

		aeq("http://www.w3.org/2005/08/addressing/anonymous", ert.getAddress().getValue());

	}

	@Test
	public void test006() throws JAXBException {

		VersionTransformer transformer = new VersionTransformer(codec);

		Relationship relationship = new Relationship();
		relationship.setRelationshipType(new QName("relationshipTypeNS", "reply"));
		unmarshaller.createUnmarshalResult(Relationship.class, relationship);

		String encodedAs = "http://schemas.xmlsoap.org/ws/2004/08/addressing";
		RelatesToType relatesToType = transformer.decodeAsNative(encodedAs, RelatesToType.class, element, unmarshaller);

		aeq("http://www.w3.org/2005/08/addressing/reply", relatesToType.getRelationshipType());

	}

	@Test
	public void test007() throws JAXBException {

		VersionTransformer transformer = new VersionTransformer(codec);

		Object object = new Object();

		unmarshaller.createUnmarshalResult(Object.class, object);

		String encodedAs = "http://schemas.xmlsoap.org/ws/2004/08/addressing";
		Object result = transformer.decodeAsNative(encodedAs, Object.class, element, unmarshaller);

		an(result);

	}

	@Test
	public void test008() throws JAXBException {

		VersionTransformer transformer = new VersionTransformer(codec);

		org.apache.cxf.ws.addressing.v200403.AttributedURI attributeURI = new org.apache.cxf.ws.addressing.v200403.AttributedURI();
		attributeURI.setValue("http://schemas.xmlsoap.org/ws/2004/03/addressing/role/anonymous");

		unmarshaller.createUnmarshalResult(org.apache.cxf.ws.addressing.v200403.AttributedURI.class, attributeURI);

		String encodedAs = "http://schemas.xmlsoap.org/ws/2004/03/addressing";
		AttributedURIType attributeURIType = transformer.decodeAsNative(encodedAs, AttributedURIType.class, element,
				unmarshaller);

		aeq("http://www.w3.org/2005/08/addressing/anonymous", attributeURIType.getValue());
		aeq(0, attributeURIType.getOtherAttributes().size());

	}

	@Test
	public void test009() throws JAXBException {

		VersionTransformer transformer = new VersionTransformer(codec);

		org.apache.cxf.ws.addressing.v200403.EndpointReferenceType ert43 = new org.apache.cxf.ws.addressing.v200403.EndpointReferenceType();
		ert43.getAddress().setValue("http://schemas.xmlsoap.org/ws/2004/03/addressing/role/anonymous");

		Class<org.apache.cxf.ws.addressing.v200403.EndpointReferenceType> ert48Class = org.apache.cxf.ws.addressing.v200403.EndpointReferenceType.class;
		unmarshaller.createUnmarshalResult(ert48Class, ert43);

		String encodedAs = "http://schemas.xmlsoap.org/ws/2004/03/addressing";
		EndpointReferenceType ert = transformer.decodeAsNative(encodedAs, EndpointReferenceType.class, element,
				unmarshaller);

		aeq("http://www.w3.org/2005/08/addressing/anonymous", ert.getAddress().getValue());

	}

	@Test
	public void test010() throws JAXBException {

		VersionTransformer transformer = new VersionTransformer(codec);

		org.apache.cxf.ws.addressing.v200403.Relationship relationship = new org.apache.cxf.ws.addressing.v200403.Relationship();
		relationship.setRelationshipType(new QName("relationshipTypeNS", "reply"));
		unmarshaller.createUnmarshalResult(org.apache.cxf.ws.addressing.v200403.Relationship.class, relationship);

		String encodedAs = "http://schemas.xmlsoap.org/ws/2004/03/addressing";
		RelatesToType relatesToType = transformer.decodeAsNative(encodedAs, RelatesToType.class, element, unmarshaller);

		aeq("http://www.w3.org/2005/08/addressing/reply", relatesToType.getRelationshipType());

	}

	@Test
	public void test011() throws JAXBException {

		VersionTransformer transformer = new VersionTransformer(codec);

		Object object = new Object();

		unmarshaller.createUnmarshalResult(Object.class, object);

		String encodedAs = "http://schemas.xmlsoap.org/ws/2004/03/addressing";
		Object result = transformer.decodeAsNative(encodedAs, Object.class, element, unmarshaller);

		an(result);

	}

	@Test
	public void test012() throws JAXBException {

		VersionTransformer transformer = new VersionTransformer(codec);

		String encodedAs = "encodedAs";
		Object result = transformer.decodeAsNative(encodedAs, Object.class, element, unmarshaller);

		an(result);

	}

	@Test
	public void test013() throws JAXBException {

		VersionTransformer transformer = new VersionTransformer(codec);

		SoapMessage message = new SoapMessage(Soap12.getInstance());
		Object value = new Object();

		transformer.encodeAsExposed(message, "http://www.w3.org/2005/08/addressing", value, "LP", Object.class, context,
				false);

		aeq(1, message.getHeaders().size());

		SoapHeader header = (SoapHeader) message.getHeaders().iterator().next();
		JAXBDataBinding dataBinding = (JAXBDataBinding) header.getDataBinding();
		@SuppressWarnings("unchecked")
		JAXBElement<Object> element = (JAXBElement<Object>) header.getObject();

		aeq(new QName("http://www.w3.org/2005/08/addressing", "LP"), header.getName());
		af(header.isMustUnderstand());
		aeqr(context, dataBinding.getContext());
		aeq(value, element.getValue());

	}

	@Test
	public void test015() throws JAXBException {

		// setup
		VersionTransformer transformer = new VersionTransformer(codec);

		SoapMessage message = new SoapMessage(Soap12.getInstance());
		AttributedURIType value = new AttributedURIType();
		value.setValue("http://www.w3.org/2005/08/addressing/anonymous");

		// call
		transformer.encodeAsExposed(message, "http://schemas.xmlsoap.org/ws/2004/08/addressing", value, "LP",
				AttributedURIType.class, context, false);

		aeq(1, message.getHeaders().size());

		// check setup
		SoapHeader header = (SoapHeader) message.getHeaders().iterator().next();
		JAXBDataBinding dataBinding = (JAXBDataBinding) header.getDataBinding();
		@SuppressWarnings("unchecked")
		JAXBElement<AttributedURI> element = (JAXBElement<AttributedURI>) header.getObject();
		AttributedURI attributeURI = element.getValue();

		// check
		aeq(new QName("http://schemas.xmlsoap.org/ws/2004/08/addressing", "LP"), header.getName());
		af(header.isMustUnderstand());
		aeqr(context, dataBinding.getContext());
		aeq("http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous", attributeURI.getValue());

	}

	@Test
	public void test016() throws JAXBException {

		// setup
		VersionTransformer transformer = new VersionTransformer(codec);

		SoapMessage message = new SoapMessage(Soap12.getInstance());
		EndpointReferenceType ert = new EndpointReferenceType();
		ert.getAddress().setValue("http://www.w3.org/2005/08/addressing/anonymous");

		// call
		transformer.encodeAsExposed(message, "http://schemas.xmlsoap.org/ws/2004/08/addressing", ert, "LP",
				EndpointReferenceType.class, context, false);

		aeq(1, message.getHeaders().size());

		// check setup
		SoapHeader header = (SoapHeader) message.getHeaders().iterator().next();
		JAXBDataBinding dataBinding = (JAXBDataBinding) header.getDataBinding();
		@SuppressWarnings("unchecked")
		JAXBElement<org.apache.cxf.ws.addressing.v200408.EndpointReferenceType> element = (JAXBElement<org.apache.cxf.ws.addressing.v200408.EndpointReferenceType>) header
				.getObject();
		org.apache.cxf.ws.addressing.v200408.EndpointReferenceType ert2 = element.getValue();

		// check
		aeq(new QName("http://schemas.xmlsoap.org/ws/2004/08/addressing", "LP"), header.getName());
		af(header.isMustUnderstand());
		aeqr(context, dataBinding.getContext());
		aeq("http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous", ert2.getAddress().getValue());

	}

	@Test
	public void test017() throws JAXBException {

		// setup
		VersionTransformer transformer = new VersionTransformer(codec);

		SoapMessage message = new SoapMessage(Soap12.getInstance());
		RelatesToType relatesToType = new RelatesToType();
		relatesToType.setRelationshipType("http://www.w3.org/2005/08/addressing/reply");

		// call
		transformer.encodeAsExposed(message, "http://schemas.xmlsoap.org/ws/2004/08/addressing", relatesToType, "LP",
				RelatesToType.class, context, false);

		aeq(1, message.getHeaders().size());

		// check setup
		SoapHeader header = (SoapHeader) message.getHeaders().iterator().next();
		JAXBDataBinding dataBinding = (JAXBDataBinding) header.getDataBinding();
		@SuppressWarnings("unchecked")
		JAXBElement<org.apache.cxf.ws.addressing.v200408.Relationship> element = (JAXBElement<org.apache.cxf.ws.addressing.v200408.Relationship>) header
				.getObject();
		org.apache.cxf.ws.addressing.v200408.Relationship relationship = element.getValue();

		// check
		aeq(new QName("http://schemas.xmlsoap.org/ws/2004/08/addressing", "LP"), header.getName());
		af(header.isMustUnderstand());
		aeqr(context, dataBinding.getContext());
		an(relationship.getRelationshipType());

	}

	@Test
	public void test018() throws JAXBException {

		// setup
		VersionTransformer transformer = new VersionTransformer(codec);

		SoapMessage message = new SoapMessage(Soap12.getInstance());
		Object object = new Object();

		// call
		transformer.encodeAsExposed(message, "http://schemas.xmlsoap.org/ws/2004/08/addressing", object, "LP",
				Object.class, context, false);

		aeq(0, message.getHeaders().size());

	}

	@Test
	public void test019() throws JAXBException {

		// setup
		VersionTransformer transformer = new VersionTransformer(codec);

		SoapMessage message = new SoapMessage(Soap12.getInstance());
		AttributedURIType value = new AttributedURIType();
		value.setValue("http://www.w3.org/2005/08/addressing/anonymous");

		// call
		transformer.encodeAsExposed(message, "http://schemas.xmlsoap.org/ws/2004/03/addressing", value, "LP",
				AttributedURIType.class, context, false);

		aeq(1, message.getHeaders().size());

		// check setup
		SoapHeader header = (SoapHeader) message.getHeaders().iterator().next();
		JAXBDataBinding dataBinding = (JAXBDataBinding) header.getDataBinding();
		@SuppressWarnings("unchecked")
		JAXBElement<org.apache.cxf.ws.addressing.v200403.AttributedURI> element = (JAXBElement<org.apache.cxf.ws.addressing.v200403.AttributedURI>) header
				.getObject();
		org.apache.cxf.ws.addressing.v200403.AttributedURI attributeURI = element.getValue();

		// check
		aeq(new QName("http://schemas.xmlsoap.org/ws/2004/03/addressing", "LP"), header.getName());
		af(header.isMustUnderstand());
		aeqr(context, dataBinding.getContext());
		aeq("http://schemas.xmlsoap.org/ws/2004/03/addressing/role/anonymous", attributeURI.getValue());

	}

	@Test
	public void test020() throws JAXBException {

		// setup
		VersionTransformer transformer = new VersionTransformer(codec);

		SoapMessage message = new SoapMessage(Soap12.getInstance());
		EndpointReferenceType ert = new EndpointReferenceType();
		ert.getAddress().setValue("http://www.w3.org/2005/08/addressing/anonymous");

		// call
		transformer.encodeAsExposed(message, "http://schemas.xmlsoap.org/ws/2004/03/addressing", ert, "LP",
				EndpointReferenceType.class, context, false);

		aeq(1, message.getHeaders().size());

		// check setup
		SoapHeader header = (SoapHeader) message.getHeaders().iterator().next();
		JAXBDataBinding dataBinding = (JAXBDataBinding) header.getDataBinding();
		@SuppressWarnings("unchecked")
		JAXBElement<org.apache.cxf.ws.addressing.v200403.EndpointReferenceType> element = (JAXBElement<org.apache.cxf.ws.addressing.v200403.EndpointReferenceType>) header
				.getObject();
		org.apache.cxf.ws.addressing.v200403.EndpointReferenceType ert2 = element.getValue();

		// check
		aeq(new QName("http://schemas.xmlsoap.org/ws/2004/03/addressing", "LP"), header.getName());
		af(header.isMustUnderstand());
		aeqr(context, dataBinding.getContext());
		aeq("http://schemas.xmlsoap.org/ws/2004/03/addressing/role/anonymous", ert2.getAddress().getValue());

	}

	@Test
	public void test021() throws JAXBException {

		// setup
		VersionTransformer transformer = new VersionTransformer(codec);

		SoapMessage message = new SoapMessage(Soap12.getInstance());
		RelatesToType relatesToType = new RelatesToType();
		relatesToType.setRelationshipType("http://www.w3.org/2005/08/addressing/reply");

		// call
		transformer.encodeAsExposed(message, "http://schemas.xmlsoap.org/ws/2004/03/addressing", relatesToType, "LP",
				RelatesToType.class, context, false);

		aeq(1, message.getHeaders().size());

		// check setup
		SoapHeader header = (SoapHeader) message.getHeaders().iterator().next();
		JAXBDataBinding dataBinding = (JAXBDataBinding) header.getDataBinding();
		@SuppressWarnings("unchecked")
		JAXBElement<org.apache.cxf.ws.addressing.v200403.Relationship> element = (JAXBElement<org.apache.cxf.ws.addressing.v200403.Relationship>) header
				.getObject();
		org.apache.cxf.ws.addressing.v200403.Relationship relationship = element.getValue();

		// check
		aeq(new QName("http://schemas.xmlsoap.org/ws/2004/03/addressing", "LP"), header.getName());
		af(header.isMustUnderstand());
		aeqr(context, dataBinding.getContext());
		an(relationship.getRelationshipType());

	}

	@Test
	public void test022() throws JAXBException {

		// setup
		VersionTransformer transformer = new VersionTransformer(codec);

		SoapMessage message = new SoapMessage(Soap12.getInstance());
		Object object = new Object();

		// call
		transformer.encodeAsExposed(message, "http://schemas.xmlsoap.org/ws/2004/03/addressing", object, "LP",
				Object.class, context, false);

		aeq(0, message.getHeaders().size());

	}

	@Test
	public void test023() throws JAXBException {

		// setup
		VersionTransformer transformer = new VersionTransformer(codec);

		SoapMessage message = new SoapMessage(Soap12.getInstance());

		// call
		transformer.encodeAsExposed(message, "http://schemas.xmlsoap.org/ws/2004/03/addressing", null, "LP",
				Object.class, context, false);

		aeq(0, message.getHeaders().size());

	}

	@Test
	public void test024() throws JAXBException {

		// setup
		VersionTransformer transformer = new VersionTransformer(codec);

		SoapMessage message = new SoapMessage(Soap12.getInstance());
		Object object = new Object();

		// call
		transformer.encodeAsExposed(message, "exposeAs", object, "LP", Object.class, context, false);

		aeq(0, message.getHeaders().size());

	}

}

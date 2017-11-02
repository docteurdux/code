package dux.org.apache.cxf.ws.addressing;

import java.util.Iterator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.ContextUtils;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.apache.cxf.ws.addressing.MetadataType;
import org.apache.cxf.ws.addressing.ReferenceParametersType;
import org.apache.cxf.ws.addressing.RelatesToType;
import org.apache.cxf.ws.addressing.VersionTransformer.Names200403;
import org.apache.cxf.ws.addressing.VersionTransformer.Names200408;
import org.apache.cxf.ws.addressing.soap.VersionTransformer;
import org.apache.cxf.ws.addressing.v200408.AttributedQName;
import org.apache.cxf.ws.addressing.v200408.AttributedURI;
import org.apache.cxf.ws.addressing.v200408.Relationship;
import org.apache.cxf.ws.addressing.wsdl.ServiceNameType;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.javax.xml.bind.DummyJAXBContext;

@Done
public class VersionTransformerTest extends AbstractTest {

	private String anonymous58;
	private String anonymous48;
	private String anonymous43;

	private String none58;
	private String none48;
	private String anyOther;

	private String none43;
	private Document document;

	@Before
	public void before() throws ParserConfigurationException {

		document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

		anonymous58 = "http://www.w3.org/2005/08/addressing/anonymous";
		anonymous48 = "http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous";
		anonymous43 = "http://schemas.xmlsoap.org/ws/2004/03/addressing/role/anonymous";

		none58 = "http://www.w3.org/2005/08/addressing/none";
		none48 = "http://schemas.xmlsoap.org/ws/2004/08/addressing/role/none";
		none43 = "http://schemas.xmlsoap.org/ws/2004/03/addressing/role/none";

		anyOther = "any other";
	}

	@Test
	public void test001() {
		at(VersionTransformer.isSupported("http://www.w3.org/2005/08/addressing"));
		at(VersionTransformer.isSupported("http://schemas.xmlsoap.org/ws/2004/08/addressing"));
		at(VersionTransformer.isSupported("http://schemas.xmlsoap.org/ws/2004/03/addressing"));

		af(VersionTransformer.isSupported("any other namespaces"));
	}

	@Test
	public void test002() {

		String[][] conversions = new String[][] {

				new String[] { anonymous58, anonymous48 },

				new String[] { none58, none48 },

				new String[] { anyOther, anyOther }

		};

		for (String[] conversion : conversions) {
			AttributedURIType attributeURIType = new AttributedURIType();
			attributeURIType.setValue(conversion[0]);
			AttributedURI attributeURI = VersionTransformer.convert(attributeURIType);
			aeq(conversion[1], attributeURI.getValue());
		}

	}

	@Test
	public void test003() {

		String[][] conversions = new String[][] {

				new String[] { anonymous58, anonymous43 },

				new String[] { none58, none43 },

				new String[] { anyOther, anyOther }

		};

		for (String[] conversion : conversions) {
			AttributedURIType attributeURIType = new AttributedURIType();
			attributeURIType.setValue(conversion[0]);
			org.apache.cxf.ws.addressing.v200403.AttributedURI attributeURI = VersionTransformer
					.convertTo200403(attributeURIType);
			aeq(conversion[1], attributeURI.getValue());
		}

	}

	@Test
	public void test004() {

		String[][] conversions = new String[][] {

				new String[] { anonymous48, anonymous58 },

				new String[] { none48, none58 },

				new String[] { anyOther, anyOther }

		};

		for (String[] conversion : conversions) {
			AttributedURI attributeURI = new AttributedURI();
			attributeURI.setValue(conversion[0]);
			AttributedURIType attributeURIType = VersionTransformer.convert(attributeURI);
			aeq(conversion[1], attributeURIType.getValue());

		}

	}

	@Test
	public void test005() {

		String[][] conversions = new String[][] {

				new String[] { anonymous43, anonymous58 },

				new String[] { none43, none58 },

				new String[] { anyOther, anyOther }

		};

		for (String[] conversion : conversions) {
			org.apache.cxf.ws.addressing.v200403.AttributedURI attributeURI = new org.apache.cxf.ws.addressing.v200403.AttributedURI();
			attributeURI.setValue(conversion[0]);
			AttributedURIType attributedURIType = VersionTransformer.convert(attributeURI);
			aeq(conversion[1], attributedURIType.getValue());
		}
	}

	@Test
	public void test006() {
		QName serviceQN = new QName("serviceNS", "serviceLP");

		ServiceNameType serviceNameType = new ServiceNameType();
		serviceNameType.setValue(serviceQN);
		serviceNameType.setEndpointName("endpointName");

		MetadataType metadataType = new MetadataType();
		metadataType.getAny().add(serviceNameType);

		EndpointReferenceType ert58 = new EndpointReferenceType();
		ert58.setMetadata(metadataType);

		org.apache.cxf.ws.addressing.v200408.EndpointReferenceType ert48 = VersionTransformer.convert(ert58);

		aeq(serviceQN, ert48.getServiceName().getValue());
		aeq(new QName("serviceNS", "endpointName"), ert48.getPortType().getValue());

	}

	@Test
	public void test007() {

		ServiceNameType serviceNameType = new ServiceNameType();
		serviceNameType.setEndpointName("endpointName");

		MetadataType metadataType = new MetadataType();
		metadataType.getAny().add(serviceNameType);

		EndpointReferenceType ert58 = new EndpointReferenceType();
		ert58.setMetadata(metadataType);

		org.apache.cxf.ws.addressing.v200408.EndpointReferenceType ert48 = VersionTransformer.convert(ert58);

		an(ert48.getServiceName());
		an(ert48.getPortType());

	}

	@Test
	public void test008() {
		QName serviceQN = new QName("serviceNS", "serviceLP");

		ServiceNameType serviceNameType = new ServiceNameType();
		serviceNameType.setValue(serviceQN);
		serviceNameType.setEndpointName("endpointName");

		MetadataType metadataType = new MetadataType();
		metadataType.getAny().add(serviceNameType);

		EndpointReferenceType ert58 = new EndpointReferenceType();
		ert58.setMetadata(metadataType);

		org.apache.cxf.ws.addressing.v200403.EndpointReferenceType ert43 = VersionTransformer.convertTo200403(ert58);

		aeq(serviceQN, ert43.getServiceName().getValue());
		aeq(new QName("serviceNS", "endpointName"), ert43.getPortType().getValue());

	}

	@Test
	public void test009() {

		ServiceNameType serviceNameType = new ServiceNameType();
		serviceNameType.setEndpointName("endpointName");

		MetadataType metadataType = new MetadataType();
		metadataType.getAny().add(serviceNameType);

		EndpointReferenceType ert58 = new EndpointReferenceType();
		ert58.setMetadata(metadataType);

		org.apache.cxf.ws.addressing.v200403.EndpointReferenceType ert43 = VersionTransformer.convertTo200403(ert58);

		an(ert43.getServiceName());
		an(ert43.getPortType());

	}

	@Test
	public void test010() {
		QName serviceQN = new QName("serviceNS", "serviceLP");
		QName portTypeQN = new QName("portTypeNS", "portTypeLP");

		AttributedQName portType = new AttributedQName();
		portType.setValue(portTypeQN);

		org.apache.cxf.ws.addressing.v200408.ServiceNameType serviceNameType = new org.apache.cxf.ws.addressing.v200408.ServiceNameType();
		serviceNameType.setValue(serviceQN);

		org.apache.cxf.ws.addressing.v200408.EndpointReferenceType ert48 = new org.apache.cxf.ws.addressing.v200408.EndpointReferenceType();
		ert48.setServiceName(serviceNameType);
		ert48.setPortType(portType);

		EndpointReferenceType ert58 = VersionTransformer.convert(ert48);

		aeq(1, ert58.getMetadata().getAny().size());

		@SuppressWarnings("unchecked")
		JAXBElement<ServiceNameType> serviceNameType58 = (JAXBElement<ServiceNameType>) ert58.getMetadata().getAny()
				.iterator().next();

		aeq(serviceQN, serviceNameType58.getValue().getValue());
		aeq("portTypeLP", serviceNameType58.getValue().getEndpointName());

	}

	@Test
	public void test011() {
		QName serviceQN = new QName("serviceNS", "serviceLP");

		org.apache.cxf.ws.addressing.v200408.ServiceNameType serviceNameType = new org.apache.cxf.ws.addressing.v200408.ServiceNameType();
		serviceNameType.setValue(serviceQN);

		org.apache.cxf.ws.addressing.v200408.EndpointReferenceType ert48 = new org.apache.cxf.ws.addressing.v200408.EndpointReferenceType();
		ert48.setServiceName(serviceNameType);

		EndpointReferenceType ert58 = VersionTransformer.convert(ert48);

		an(ert58.getMetadata());

	}

	@Test
	public void test012() {
		QName serviceQN = new QName("serviceNS", "serviceLP");

		org.apache.cxf.ws.addressing.v200408.ServiceNameType serviceNameType = new org.apache.cxf.ws.addressing.v200408.ServiceNameType();
		serviceNameType.setValue(serviceQN);

		org.apache.cxf.ws.addressing.v200408.EndpointReferenceType ert48 = new org.apache.cxf.ws.addressing.v200408.EndpointReferenceType();

		EndpointReferenceType ert58 = VersionTransformer.convert(ert48);

		an(ert58.getMetadata());

	}

	@Test
	public void test013() {
		QName serviceQN = new QName("serviceNS", "serviceLP");
		QName portTypeQN = new QName("portTypeNS", "portTypeLP");

		org.apache.cxf.ws.addressing.v200403.AttributedQName portType = new org.apache.cxf.ws.addressing.v200403.AttributedQName();
		portType.setValue(portTypeQN);

		org.apache.cxf.ws.addressing.v200403.ServiceNameType serviceNameType = new org.apache.cxf.ws.addressing.v200403.ServiceNameType();
		serviceNameType.setValue(serviceQN);

		org.apache.cxf.ws.addressing.v200403.EndpointReferenceType ert43 = new org.apache.cxf.ws.addressing.v200403.EndpointReferenceType();
		ert43.setServiceName(serviceNameType);
		ert43.setPortType(portType);

		EndpointReferenceType ert58 = VersionTransformer.convert(ert43);

		aeq(1, ert58.getMetadata().getAny().size());

		@SuppressWarnings("unchecked")
		JAXBElement<ServiceNameType> serviceNameType58 = (JAXBElement<ServiceNameType>) ert58.getMetadata().getAny()
				.iterator().next();

		aeq(serviceQN, serviceNameType58.getValue().getValue());
		aeq("portTypeLP", serviceNameType58.getValue().getEndpointName());

	}

	@Test
	public void test014() {
		QName serviceQN = new QName("serviceNS", "serviceLP");

		org.apache.cxf.ws.addressing.v200403.ServiceNameType serviceNameType = new org.apache.cxf.ws.addressing.v200403.ServiceNameType();
		serviceNameType.setValue(serviceQN);

		org.apache.cxf.ws.addressing.v200403.EndpointReferenceType ert43 = new org.apache.cxf.ws.addressing.v200403.EndpointReferenceType();
		ert43.setServiceName(serviceNameType);

		EndpointReferenceType ert58 = VersionTransformer.convert(ert43);

		an(ert58.getMetadata());

	}

	@Test
	public void test015() {

		org.apache.cxf.ws.addressing.v200403.EndpointReferenceType ert43 = new org.apache.cxf.ws.addressing.v200403.EndpointReferenceType();

		EndpointReferenceType ert58 = VersionTransformer.convert(ert43);

		an(ert58.getMetadata());

	}

	@Test
	public void test016() {

		Object object = new Object();
		ReferenceParametersType rpt58 = new ReferenceParametersType();
		rpt58.getAny().add(object);
		org.apache.cxf.ws.addressing.v200408.ReferenceParametersType rpt48 = VersionTransformer.convert(rpt58);
		aeqr(object, rpt48.getAny().iterator().next());

	}

	@Test
	public void test017() {

		Object object = new Object();
		org.apache.cxf.ws.addressing.v200408.ReferenceParametersType rpt48 = new org.apache.cxf.ws.addressing.v200408.ReferenceParametersType();
		rpt48.getAny().add(object);
		ReferenceParametersType rpt58 = VersionTransformer.convert(rpt48);
		aeqr(object, rpt58.getAny().iterator().next());

	}

	@Test
	public void test018() {
		RelatesToType relatesToType = new RelatesToType();
		relatesToType.setRelationshipType("http://www.w3.org/2005/08/addressing/reply");
		Relationship relationship = VersionTransformer.convert(relatesToType);
		an(relationship.getRelationshipType());

	}

	@Test
	public void test019() {
		RelatesToType relatesToType = new RelatesToType();
		relatesToType.setRelationshipType("anyOther");
		Relationship relationship = VersionTransformer.convert(relatesToType);
		aeq(new QName("", "anyOther"), relationship.getRelationshipType());

	}

	@Test
	public void test020() {
		Relationship relationship = VersionTransformer.convert((RelatesToType) null);
		an(relationship);
	}

	@Test
	public void test021() {
		RelatesToType relatesToType = new RelatesToType();
		relatesToType.setRelationshipType("http://www.w3.org/2005/08/addressing/reply");
		org.apache.cxf.ws.addressing.v200403.Relationship relationship = VersionTransformer
				.convertTo200403(relatesToType);
		an(relationship.getRelationshipType());

	}

	@Test
	public void test022() {
		RelatesToType relatesToType = new RelatesToType();
		relatesToType.setRelationshipType("anyOther");
		org.apache.cxf.ws.addressing.v200403.Relationship relationship = VersionTransformer
				.convertTo200403(relatesToType);
		aeq("anyOther", relationship.getRelationshipType().getLocalPart());

	}

	@Test
	public void test023() {
		org.apache.cxf.ws.addressing.v200403.Relationship relationship = VersionTransformer
				.convertTo200403((RelatesToType) null);
		an(relationship);
	}

	@Test
	public void test024() {
		Relationship relationship = new Relationship();
		relationship.setRelationshipType(new QName("someNamespace", "reply"));
		RelatesToType relateToType = VersionTransformer.convert(relationship);
		aeq("http://www.w3.org/2005/08/addressing/reply", relateToType.getRelationshipType());

	}

	@Test
	public void test025() {
		Relationship relationship = new Relationship();
		relationship.setRelationshipType(new QName("someNamespace", "anyOther"));
		RelatesToType relateToType = VersionTransformer.convert(relationship);
		aeq("{someNamespace}anyOther", relateToType.getRelationshipType());

	}

	@Test
	public void test026() {
		Relationship relationship = new Relationship();
		an(relationship.getRelationshipType());
		RelatesToType relateToType = VersionTransformer.convert(relationship);
		aeq("http://www.w3.org/2005/08/addressing/reply", relateToType.getRelationshipType());

	}

	@Test
	public void test027() {
		Relationship relationship = null;
		RelatesToType relateToType = VersionTransformer.convert(relationship);
		an(relateToType);
	}

	@Test
	public void test028() {
		org.apache.cxf.ws.addressing.v200403.Relationship relationship = new org.apache.cxf.ws.addressing.v200403.Relationship();
		relationship.setRelationshipType(new QName("someNamespace", "reply"));
		RelatesToType relatesToType = VersionTransformer.convert(relationship);
		aeq("http://www.w3.org/2005/08/addressing/reply", relatesToType.getRelationshipType());
	}

	@Test
	public void test029() {
		org.apache.cxf.ws.addressing.v200403.Relationship relationship = new org.apache.cxf.ws.addressing.v200403.Relationship();
		relationship.setRelationshipType(new QName("someNamespace", "anyOther"));
		RelatesToType relatesToType = VersionTransformer.convert(relationship);
		aeq("{someNamespace}anyOther", relatesToType.getRelationshipType());
	}

	@Test
	public void test030() {
		org.apache.cxf.ws.addressing.v200403.Relationship relationship = new org.apache.cxf.ws.addressing.v200403.Relationship();
		an(relationship.getRelationshipType());
		RelatesToType relatesToType = VersionTransformer.convert(relationship);
		aeq("http://www.w3.org/2005/08/addressing/reply", relatesToType.getRelationshipType());
	}

	@Test
	public void test031() {
		org.apache.cxf.ws.addressing.v200403.Relationship relationship = null;
		RelatesToType relatesToType = VersionTransformer.convert(relationship);
		an(relatesToType);
	}

	@Test
	public void test032() throws JAXBException {
		Element element = document.createElementNS("namespace", "element");
		EndpointReferenceType ert = VersionTransformer.parseEndpointReference(element);
		an(ert);
	}

	@Test
	public void test033() throws JAXBException {
		Element parent = document.createElementNS("parentNS", "parent");

		Element child1 = document.createElementNS("child1NS", "child1");
		parent.appendChild(child1);

		EndpointReferenceType ert = VersionTransformer.parseEndpointReference(parent);
		an(ert);

	}

	@Test
	public void test034() throws JAXBException {
		Element parent = document.createElementNS("parentNS", "parent");

		Element child1 = document.createElementNS("child1NS", "child1");
		parent.appendChild(child1);

		Element child2 = document.createElementNS("http://www.w3.org/2005/08/addressing", "child2");
		parent.appendChild(child2);

		EndpointReferenceType ert = VersionTransformer.parseEndpointReference(parent);
		ann(ert);
		aeq(2, ert.getAny().size());
		Iterator<Object> it = ert.getAny().iterator();
		aeq("child1", ((Element) it.next()).getNodeName());
		aeq("child2", ((Element) it.next()).getNodeName());

	}

	@Test
	public void test035() throws JAXBException {
		Element parent = document.createElementNS("parentNS", "parent");

		Element child2 = document.createElementNS("http://www.w3.org/2005/08/addressing", "child2");
		parent.appendChild(child2);

		Element child1 = document.createElementNS("child1NS", "child1");
		parent.appendChild(child1);

		EndpointReferenceType ert = VersionTransformer.parseEndpointReference(parent);
		ann(ert);
		aeq(2, ert.getAny().size());
		Iterator<Object> it = ert.getAny().iterator();
		aeq("child2", ((Element) it.next()).getNodeName());
		aeq("child1", ((Element) it.next()).getNodeName());

	}

	@Test
	public void test036() {
		EndpointReferenceType ert = new EndpointReferenceType();
		EndpointReferenceType ert2 = VersionTransformer.convertToNative(ert);
		aeqr(ert, ert2);
	}

	@Test
	public void test037() {
		org.apache.cxf.ws.addressing.v200408.EndpointReferenceType ert = new org.apache.cxf.ws.addressing.v200408.EndpointReferenceType();
		EndpointReferenceType ert2 = VersionTransformer.convertToNative(ert);
		ann(ert2);
	}

	@Test
	public void test038() {
		org.apache.cxf.ws.addressing.v200403.EndpointReferenceType ert = new org.apache.cxf.ws.addressing.v200403.EndpointReferenceType();
		EndpointReferenceType ert2 = VersionTransformer.convertToNative(ert);
		ann(ert2);
	}

	@Test
	public void test039() {
		Object ert = new Object();
		EndpointReferenceType ert2 = VersionTransformer.convertToNative(ert);
		an(ert2);
	}

	@Test
	public void test040() {
		Class<?> clazz = VersionTransformer.getExposedReferenceType("http://www.w3.org/2005/08/addressing");
		aeq(EndpointReferenceType.class, clazz);

		clazz = VersionTransformer.getExposedReferenceType("http://schemas.xmlsoap.org/ws/2004/08/addressing");
		aeq(org.apache.cxf.ws.addressing.v200408.EndpointReferenceType.class, clazz);

		clazz = VersionTransformer.getExposedReferenceType("http://schemas.xmlsoap.org/ws/2004/03/addressing");
		aeq(org.apache.cxf.ws.addressing.v200403.EndpointReferenceType.class, clazz);

		clazz = VersionTransformer.getExposedReferenceType("anyOther");
		an(clazz);

	}

	@Test
	public void test041() throws JAXBException {

		JAXBContext dummyContext = new DummyJAXBContext();

		JAXBContext previousContext58 = ContextUtils.getJAXBContext();
		try {
			ContextUtils.setJAXBContext(dummyContext);
			JAXBContext context = VersionTransformer.getExposedJAXBContext("http://www.w3.org/2005/08/addressing");
			aeqr(dummyContext, context);
		} finally {
			ContextUtils.setJAXBContext(previousContext58);
		}

		JAXBContext previousContext48 = Names200408.getJAXBContext();
		try {
			Names200408.setJAXBContext(dummyContext);
			JAXBContext context = VersionTransformer
					.getExposedJAXBContext("http://schemas.xmlsoap.org/ws/2004/08/addressing");
			aeqr(dummyContext, context);
		} finally {
			Names200408.setJAXBContext(previousContext48);
		}

		JAXBContext previousContext43 = Names200403.getJAXBContext();
		try {
			Names200403.setJAXBContext(dummyContext);
			JAXBContext context = VersionTransformer
					.getExposedJAXBContext("http://schemas.xmlsoap.org/ws/2004/03/addressing");
			aeqr(dummyContext, context);
		} finally {
			Names200403.setJAXBContext(previousContext43);
		}

		previousContext58 = ContextUtils.getJAXBContext();
		previousContext48 = Names200408.getJAXBContext();
		previousContext43 = Names200403.getJAXBContext();
		try {
			ContextUtils.setJAXBContext(dummyContext);
			Names200408.setJAXBContext(dummyContext);
			Names200403.setJAXBContext(dummyContext);
			JAXBContext context = VersionTransformer.getExposedJAXBContext("anyOther");
			an(context);
		} finally {
			ContextUtils.setJAXBContext(previousContext58);
			Names200408.setJAXBContext(previousContext48);
			Names200403.setJAXBContext(previousContext43);
		}

	}

	@Test
	public void test042() {

		aeq("http://schemas.xmlsoap.org/ws/2004/08/addressing", Names200408.WSA_NAMESPACE_NAME);
		aeq("http://schemas.xmlsoap.org/ws/2004/08/addressing/role/none", Names200408.WSA_NONE_ADDRESS);
		aeq("http://schemas.xmlsoap.org/ws/2004/08/addressing/role/anonymous", Names200408.WSA_ANONYMOUS_ADDRESS);

		aeq("http://schemas.xmlsoap.org/ws/2004/03/addressing", Names200403.WSA_NAMESPACE_NAME);
		aeq("http://schemas.xmlsoap.org/ws/2004/03/addressing/role/none", Names200403.WSA_NONE_ADDRESS);
		aeq("http://schemas.xmlsoap.org/ws/2004/03/addressing/role/anonymous", Names200403.WSA_ANONYMOUS_ADDRESS);

	}

}

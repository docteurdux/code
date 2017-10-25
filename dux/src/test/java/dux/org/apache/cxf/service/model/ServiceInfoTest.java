package dux.org.apache.cxf.service.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.cxf.common.xmlschema.SchemaCollection;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.DescriptionInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.MessageInfo.Type;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.SchemaInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.service.model.ServiceSchemaInfo;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class ServiceInfoTest extends AbstractTest {

	/** Simple getters and setters **/
	@Test
	public void test1() {

		ServiceInfo si = new ServiceInfo();

		an(si.getDescription());
		an(si.getTopLevelDoc());
		an(si.getTargetNamespace());
		an(si.getName());
		an(si.getInterface());

		DescriptionInfo di = new DescriptionInfo();
		si.setDescription(di);
		aeq(di, si.getDescription());

		String topLevelDoc = "topLevelDoc";
		si.setTopLevelDoc(topLevelDoc);
		aeq(topLevelDoc, si.getTopLevelDoc());

		String targetNamespace = "targetNamespace";
		si.setTargetNamespace(targetNamespace);
		aeq(targetNamespace, si.getTargetNamespace());

		QName siQn = new QName("siQn");
		si.setName(siQn);
		aeq(siQn, si.getName());

		QName iiQn = new QName("iiQn");
		InterfaceInfo ii = new InterfaceInfo(si, iiQn);
		si.setInterface(ii);
		aeq(ii, si.getInterface());

	}

	/** create interface **/
	@Test
	public void test2() {

		ServiceInfo si = new ServiceInfo();

		QName iiQn = new QName("iiQn");
		InterfaceInfo ii = si.createInterface(iiQn);

		at(iiQn.equals(ii.getName()));
		aeq(si, ii.getService());

	}

	/** Bindings **/
	@Test
	public void test3() {

		ServiceInfo si = new ServiceInfo();

		QName biQn = new QName("biQn");

		// binding not found
		an(si.getBinding(biQn));
		aeq(0, si.getBindings().size());

		// add binding => binding found
		String bindingId = "bindingId";
		BindingInfo bi = new BindingInfo(si, bindingId);
		bi.setName(biQn);
		si.addBinding(bi);
		BindingInfo gotBinding = si.getBinding(biQn);
		aeq(bi, gotBinding);
		aeq(bindingId, bi.getBindingId());
		aeq(1, si.getBindings().size());
		aeq(bi, si.getBindings().iterator().next());

		// add same qname => binding replaced
		String bindingId2 = "bindingId2";
		BindingInfo bi2 = new BindingInfo(si, bindingId2);
		bi2.setName(biQn);
		si.addBinding(bi2);
		BindingInfo gotBinding2 = si.getBinding(biQn);
		aeq(bi2, gotBinding2);
		aeq(bindingId2, gotBinding2.getBindingId());
		aeq(1, si.getBindings().size());
		aeq(bi2, si.getBindings().iterator().next());

		// does not find inexisting binding
		an(si.getBinding(new QName("notFound")));

	}

	/** Endpoints are similar to bindings **/
	@Test
	public void test4() {

		ServiceInfo si = new ServiceInfo();

		QName eiQn = new QName("eiQn");

		// binding not found
		an(si.getEndpoint(eiQn));
		aeq(0, si.getEndpoints().size());

		// add binding => binding found
		EndpointInfo ei = new EndpointInfo();
		ei.setName(eiQn);
		si.addEndpoint(ei);
		EndpointInfo gotEndpoint = si.getEndpoint(eiQn);
		aeq(ei, gotEndpoint);
		aeq(1, si.getEndpoints().size());
		aeq(ei, si.getEndpoints().iterator().next());

		// add same qname => binding replaced
		EndpointInfo ei2 = new EndpointInfo();
		ei2.setName(eiQn);
		si.addEndpoint(ei2);
		EndpointInfo gotEndpoint2 = si.getEndpoint(eiQn);
		aeq(ei2, gotEndpoint2);
		aeq(1, si.getEndpoints().size());
		aeq(ei2, si.getEndpoints().iterator().next());

		// does not find inexisting binding
		an(si.getEndpoint(new QName("notFound")));

	}

	/**
	 * getMessages retrieves all the input and output message of all operations of
	 * the interface ; message are cached and are not automatically recomputed when
	 * information changes
	 **/
	@Test
	public void test5() {

		ServiceInfo si = new ServiceInfo();

		QName imi1Qn = new QName("imi1Qn");
		QName imi2Qn = new QName("imi2Qn");
		QName omi1Qn = new QName("omi1Qn");
		QName omi2Qn = new QName("omi2Qn");
		QName oi1Qn = new QName("oi1Qn");
		QName oi2Qn = new QName("oi2Qn");
		QName iiQn = new QName("iiQn");

		InterfaceInfo ii = new InterfaceInfo(si, iiQn);
		ii.setName(iiQn);
		ii.addOperation(oi1Qn);
		ii.addOperation(oi2Qn);

		OperationInfo oi1 = ii.getOperation(oi1Qn);
		OperationInfo oi2 = ii.getOperation(oi2Qn);

		MessageInfo imi1 = new MessageInfo(oi1, Type.INPUT, imi1Qn);
		MessageInfo omi1 = new MessageInfo(oi1, Type.OUTPUT, omi1Qn);
		oi1.setInput("inputName1", imi1);
		oi1.setOutput("outputName1", omi1);

		MessageInfo imi2 = new MessageInfo(oi2, Type.INPUT, imi2Qn);
		MessageInfo omi2 = new MessageInfo(oi2, Type.OUTPUT, omi2Qn);
		oi2.setInput("inputName1", imi2);
		oi2.setOutput("outputName1", omi2);

		si.setInterface(ii);

		Map<QName, MessageInfo> messages = si.getMessages();

		MessageInfo imi1Gotten = si.getMessage(imi1Qn);
		MessageInfo omi1Gotten = si.getMessage(omi1Qn);
		MessageInfo imi2Gotten = si.getMessage(imi2Qn);
		MessageInfo omi2Gotten = si.getMessage(omi2Qn);

		aeq(4, messages.size());
		aeq(imi1, imi1Gotten);
		aeq(omi1, omi1Gotten);
		aeq(imi2, imi2Gotten);
		aeq(omi2, omi2Gotten);

		// message are cached and are not automatically recomputed when information
		// changes

		oi1.setInput(null, null);
		oi1.setOutput(null, null);
		oi2.setInput(null, null);
		oi2.setOutput(null, null);

		aeq(4, messages.size());
		aeq(imi1, si.getMessage(imi1Qn));
		aeq(omi1, si.getMessage(omi1Qn));
		aeq(imi2, si.getMessage(imi2Qn));
		aeq(omi2, si.getMessage(omi2Qn));

		si.setMessages(null); // forces recomputations of messages with getMessages
		messages = si.getMessages();
		aeq(0, messages.size());
		an(si.getMessage(imi1Qn));

		// using refresh is more meaningful
		oi1.setInput("inputName1", imi1);
		si.refresh();
		messages = si.getMessages();
		aeq(1, messages.size());
		aeq(imi1, si.getMessage(imi1Qn));

	}

	/**
	 * This test calls the functions of serviceInfo which are related to schemas.
	 * These calls produces 100% coverage, but are completely meaningless. Almost
	 * nothing is actually tested here.
	 */
	@Test
	public void test6() {

		String namespaceURI = "namespaceURI";
		String namespaceURI2 = "namespaceURI2";

		ServiceInfo si = new ServiceInfo();

		aeq(0, si.getSchemas().size());
		aeq("org.apache.cxf.common.xmlschema.SchemaCollection", si.getXmlSchemaCollection().getClass().getName());

		an(si.getSchema(namespaceURI));

		si.addNewSchema(namespaceURI);

		SchemaInfo schemaInfo = si.getSchema(namespaceURI);

		si.addSchema(schemaInfo);

		si.addNewSchema(null);
		schemaInfo = si.getSchema(null);

		schemaInfo = si.getSchema(namespaceURI2);

		ServiceSchemaInfo serviceSchemaInfo = new ServiceSchemaInfo();
		si.setServiceSchemaInfo(serviceSchemaInfo);

		SchemaCollection cachedXmlSchemaCollection = new SchemaCollection();
		List<SchemaInfo> cachedSchemas = new ArrayList<>();
		si.setSchemas(cachedXmlSchemaCollection, cachedSchemas);
	}
}

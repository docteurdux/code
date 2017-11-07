package dux.org.apache.cxf.ws.policy.attachment;

import javax.xml.namespace.QName;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.model.BindingFaultInfo;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.FaultInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.ws.policy.attachment.ServiceModelPolicyProvider;
import org.apache.neethi.Policy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.apache.cxf.message.DummyMessage;

@Done
public class ServiceModelPolicyProviderTest extends AbstractTest {
	private Bus bus;
	private QName fiQn;
	private QName mQn;
	private QName iiQn;
	private ServiceInfo si;
	private InterfaceInfo ii;
	private BindingInfo bi;
	private OperationInfo oi;
	private BindingOperationInfo boi;
	private BindingFaultInfo bfi;
	private FaultInfo fi;
	private BindingMessageInfo bmi;
	private EndpointInfo ei;
	private QName oiQn;

	@Before
	public void before() {
		bus = BusFactory.getDefaultBus();

		fiQn = new QName("fiNS", "fiLP");
		mQn = new QName("mNS", "mLP");
		iiQn = new QName("iiNS", "iiLP");
		oiQn = new QName("oiNS", "oiLP");

		si = new ServiceInfo();

		ii = new InterfaceInfo(si, iiQn);

		oi = ii.addOperation(oiQn);

		fi = new FaultInfo(fiQn, mQn, oi);

		bi = new BindingInfo(si, "bindingId");

		boi = new BindingOperationInfo(bi, oi);

		bfi = new BindingFaultInfo(fi, boi);

		bmi = new BindingMessageInfo();

		ei = new EndpointInfo(si, "eiNS");

	}

	@After
	public void after() {
		BusFactory.setDefaultBus(null);
	}

	@Test
	public void test() {
		ServiceModelPolicyProvider provider = new ServiceModelPolicyProvider(bus);

		Message m = new DummyMessage();

		Policy bfiPolicy = new Policy();
		bfi.addExtensor(bfiPolicy);

		Policy bmiPolicy = new Policy();
		bmi.addExtensor(bmiPolicy);

		Policy boiPolicy = new Policy();
		boi.addExtensor(boiPolicy);

		Policy eiPolicy = new Policy();
		ei.addExtensor(eiPolicy);

		Policy siPolicy = new Policy();
		si.addExtensor(siPolicy);

		aeqr(bfiPolicy, provider.getEffectivePolicy(bfi, m));
		aeqr(bmiPolicy, provider.getEffectivePolicy(bmi, m));
		aeqr(boiPolicy, provider.getEffectivePolicy(boi, m));
		aeqr(eiPolicy, provider.getEffectivePolicy(ei, m));
		aeqr(siPolicy, provider.getEffectivePolicy(si, m));
	}
}

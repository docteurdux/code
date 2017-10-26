package dux.org.apache.cxf.service.model;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.DescriptionInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class EndpointInfoTest extends AbstractTest {

	@Before
	public void before() {

	}

	@Test
	public void test1() {
		String eiNs = "eiNs";
		String eiNs2 = "eiNs2";
		QName eiQn = new QName("eiQn");
		QName iiQn = new QName("iiQn");
		ServiceInfo si = new ServiceInfo();
		DescriptionInfo di = new DescriptionInfo();
		si.setDescription(di);
		InterfaceInfo ii = new InterfaceInfo(si, iiQn);
		EndpointInfo ei = new EndpointInfo(si, eiNs);

		aeq(eiNs, ei.getTransportId());
		aeq(si, ei.getService());

		aeq(di, ei.getDescription());

		aeq(ii, ei.getInterface());

		ei.setService(null);
		an(ei.getDescription());
		an(ei.getInterface());

		an(ei.getName());
		ei.setName(eiQn);
		aeq(eiQn, ei.getName());

		an(ei.getBinding());
		String bindingId = "bindingId";
		BindingInfo bi = new BindingInfo(si, bindingId);
		ei.setBinding(bi);
		aeq(bi, ei.getBinding());

		ei.setTransportId(eiNs2);
		aeq(eiNs2, ei.getTransportId());
		
		ei = new EndpointInfo();
		an(ei.getTransportId());
		an(ei.getService());

	}
}

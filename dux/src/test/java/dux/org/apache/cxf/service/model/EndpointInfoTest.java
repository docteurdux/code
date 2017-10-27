package dux.org.apache.cxf.service.model;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.DescriptionInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.ws.addressing.AttributedURIType;
import org.apache.cxf.ws.addressing.EndpointReferenceType;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class EndpointInfoTest extends AbstractTest {

	private EndpointInfo ei;
	private ServiceInfo si;
	private DescriptionInfo di;
	private String eiNs;
	private String address;

	@Before
	public void before() {

		eiNs = "eiNs";
		address = "address";

		di = new DescriptionInfo();

		si = new ServiceInfo();
		si.setDescription(di);
		ei = new EndpointInfo(si, eiNs);

	}

	@Test
	public void test1() {
		String eiNs2 = "eiNs2";
		QName eiQn = new QName("eiQn");
		QName iiQn = new QName("iiQn");
		InterfaceInfo ii = new InterfaceInfo(si, iiQn);

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

	}

	@Test
	public void test2() {
		ei = new EndpointInfo();
		an(ei.getTransportId());
		an(ei.getService());
	}

	@Test
	public void test3() {

		an(ei.getAddress());

		EndpointReferenceType ert = new EndpointReferenceType();
		ert.setAddress(null);
		ei.setAddress(ert);

		an(ert.getAddress());
		an(ei.getAddress());

		AttributedURIType aut = new AttributedURIType();
		ert.setAddress(aut);
		an(ert.getAddress().getValue());
		an(ei.getAddress());

		aut.setValue(address);

	}

	@Test
	public void test4() {

		ei.setAddress(address);
		ei.setAddress(address);

	}

	@Test
	public void test5() {

		ei.setAddress(address);
		aeq(address, ei.getTarget().getAddress().getValue());

	}

	public static class A {

		private String name;

		public A(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	@Test
	public void test6() {

		A defaultA = new A("default");

		A a = ei.getTraversedExtensor(defaultA, A.class);
		aeq(a.getName(), defaultA.getName());

	}

	@Test
	public void test7() {

		A defaultA = new A("default");
		A endpointA = new A("endpoint");

		ei.addExtensor(endpointA);
		A a = ei.getTraversedExtensor(defaultA, A.class);
		aeq(a.getName(), endpointA.getName());

	}

	@Test
	public void test8() {

		A defaultA = new A("default");
		A bindingA = new A("binding");

		BindingInfo bi = new BindingInfo(si, "bindingId");
		bi.addExtensor(bindingA);
		ei.setBinding(bi);
		A a = ei.getTraversedExtensor(defaultA, A.class);
		aeq(a.getName(), bindingA.getName());

	}

	@Test
	public void test9() {

		A defaultA = new A("default");
		A serviceA = new A("service");

		si.addExtensor(serviceA);
		A a = ei.getTraversedExtensor(defaultA, A.class);
		aeq(a.getName(), serviceA.getName());

	}

	@Test
	public void test10() {

		A defaultA = new A("default");

		ei.setService(null);
		A a = ei.getTraversedExtensor(defaultA, A.class);
		aeq(a.getName(), defaultA.getName());

	}

	/**
	 * Extensors are search for in the following order : endpoint, binding, service,
	 * then default value
	 **/
	@Test
	public void test11() {

		A defaultA = new A("default");
		A serviceA = new A("service");
		A bindingA = new A("binding");
		A endpointA = new A("endpoint");

		A a = ei.getTraversedExtensor(defaultA, A.class);
		aeq(a.getName(), defaultA.getName());

		si.addExtensor(serviceA);
		a = ei.getTraversedExtensor(defaultA, A.class);
		aeq(a.getName(), serviceA.getName());

		String bindingId = "bindingId";
		BindingInfo bi = new BindingInfo(si, bindingId);
		bi.addExtensor(bindingA);
		ei.setBinding(bi);
		a = ei.getTraversedExtensor(defaultA, A.class);
		aeq(a.getName(), bindingA.getName());

		ei.addExtensor(endpointA);
		a = ei.getTraversedExtensor(defaultA, A.class);
		aeq(a.getName(), endpointA.getName());

	}

	@Test
	public void test12() {

		at(ei.isSameAs(ei));
		af(ei.isSameAs(null));

		EndpointInfo ei2 = new EndpointInfo();

		// different binding names
		QName biQn = new QName("biQn");
		QName biQn2 = new QName("biQn2");
		BindingInfo bi = new BindingInfo(si, "bindingId");
		bi.setName(biQn);

		BindingInfo bi2 = new BindingInfo(si, "bindingId2");
		bi2.setName(biQn2);

		ei.setBinding(bi);
		ei2.setBinding(bi2);
		af(ei.isSameAs(ei2));

		// same binding names, different service names
		bi2.setName(biQn);
		QName siQn = new QName("siQn");
		QName siQn2 = new QName("siQn2");
		ServiceInfo si2 = new ServiceInfo();
		si2.setName(siQn2);
		ei2.setService(si2);
		QName eiQn = new QName("eiQn");
		QName eiQn2 = new QName("eiQn2");
		ei.setName(eiQn);
		ei2.setName(eiQn2);
		ann(ei.getService());
		si.setName(siQn);
		ann(ei.getService().getName());
		ann(ei2.getService());
		ann(ei2.getService().getName());
		ei.isSameAs(ei2);

		si2.setName(siQn);
		ei.isSameAs(ei2);

		ei2.setName(eiQn);
		ei.isSameAs(ei2);
	}

	/**
	 * isSameAs throws if binding is not set, or if sercice is not set, or if name
	 * is not set
	 **/
	@Test(expected = NullPointerException.class)
	public void test13() {
		EndpointInfo ei2 = new EndpointInfo();
		an(ei.getBinding());
		an(ei2.getBinding());
		ei.isSameAs(ei2);
	}

	/**
	 * isSameAs throws if binding is not set, or if sercice is not set, or if name
	 * is not set
	 **/
	@Test
	public void test14() {
		an(ei.getBinding());
		ei.toString();

		BindingInfo bi = new BindingInfo(null, "bindingId");
		ei.setBinding(bi);
		ann(ei.getBinding());
		an(ei.getBinding().getService());
		ei.toString();
		
		bi = new BindingInfo(si, "bindingId");
		ei.setBinding(bi);
		ann(ei.getBinding());
		ann(ei.getBinding().getService());
		ei.toString();
	}

}

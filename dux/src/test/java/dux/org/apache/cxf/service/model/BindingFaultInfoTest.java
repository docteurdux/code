package dux.org.apache.cxf.service.model;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.BindingFaultInfo;
import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.FaultInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class BindingFaultInfoTest extends AbstractTest {

	@Test
	public void test() {

		String bindingId = "bindingId";

		QName iiQn = new QName("iiQn");
		QName fiQn = new QName("fiQn");
		QName mQn = new QName("mQn");
		QName oiQn = new QName("oiQn");

		ServiceInfo si = new ServiceInfo();
		InterfaceInfo ii = new InterfaceInfo(si, iiQn);
		BindingInfo bi = new BindingInfo(si, bindingId);

		OperationInfo oi = ii.addOperation(oiQn);
		FaultInfo fi = new FaultInfo(fiQn, mQn, oi);

		BindingOperationInfo boi = new BindingOperationInfo(bi, oi);
		BindingFaultInfo bfi = new BindingFaultInfo(fi, boi);

		aeq(fi, bfi.getFaultInfo());
		aeq(boi, bfi.getBindingOperation());
	}
}

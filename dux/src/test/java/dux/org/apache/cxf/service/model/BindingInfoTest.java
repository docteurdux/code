package dux.org.apache.cxf.service.model;

import java.lang.reflect.Field;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.DescriptionInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.service.model.MessageInfo.Type;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class BindingInfoTest extends AbstractTest {
	private ServiceInfo si;
	private String bindingId;
	private BindingInfo bi;
	private QName biQn;
	private DescriptionInfo di;
	private QName iiQn;
	private InterfaceInfo ii;
	private QName oiQn;
	private BindingOperationInfo boi;
	private OperationInfo oi;

	@Before
	public void before() {

		bindingId = "bindingId";

		iiQn = new QName("iiQn");
		biQn = new QName("biQn");
		oiQn = new QName("oiQn");

		si = new ServiceInfo();
		ii = new InterfaceInfo(si, iiQn);
		di = new DescriptionInfo();
		bi = new BindingInfo(si, bindingId);

		oi = new OperationInfo();
		oi.setName(oiQn);
		boi = new BindingOperationInfo(bi, oi);

	}

	@Test
	public void test1() {
		aeq(si, bi.getService());
		aeq(bindingId, bi.getBindingId());

		bi.setName(biQn);
		aeq(biQn, bi.getName());

		an(bi.getDescription());
		si.setDescription(di);
		aeq(di, bi.getDescription());

		aeq(ii, bi.getInterface());

	}

	@Test
	public void test2()
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field field = BindingInfo.class.getDeclaredField("service");
		field.setAccessible(true);
		field.set(bi, null);
		an(bi.getDescription());

	}

	@Test
	public void test3() {
		an(bi.getOperation(oiQn));
		at(bi.getOperations().isEmpty());
		bi.addOperation(boi);
		bi.removeOperation(boi);
	}

	@Test(expected = NullPointerException.class)
	public void test4() {
		boi = new BindingOperationInfo(bi, new OperationInfo());
		bi.addOperation(boi);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test5() {
		bi.addOperation(boi);
		bi.addOperation(boi);
	}

	@Test(expected = NullPointerException.class)
	public void test6() {
		boi = new BindingOperationInfo(bi, new OperationInfo());
		bi.removeOperation(boi);
	}

	@Test(expected = NullPointerException.class)
	public void test7() {
		bi.getOperation(oi);
		bi.addOperation(boi);
		bi.getOperation(oi);
	}

	@Test
	public void test8() {

		QName oiQn2 = new QName("oiQn2");
		OperationInfo oi2 = new OperationInfo();
		oi2.setName(oiQn2);

		oi = new OperationInfo();
		oi.setName(oiQn);
		oi.setUnwrappedOperation(oi2);

		boi = new BindingOperationInfo(bi, oi);
		at(boi.isUnwrappedCapable());
		at(boi.getUnwrappedOperation().getOperationInfo() == oi2);
		bi.addOperation(boi);

		aeq(boi.getUnwrappedOperation(), bi.getOperation(oi2));
		aeq(new BindingOperationInfo(bi, oi2), boi.getUnwrappedOperation());
	}

	@Test
	public void test9() {

		QName oiQn2 = new QName("oiQn2");
		OperationInfo oi2 = new OperationInfo();
		oi2.setName(oiQn2);

		QName oiQn3 = new QName("oiQn3");
		OperationInfo oi3 = new OperationInfo();
		oi2.setName(oiQn3);

		oi = new OperationInfo();
		oi.setName(oiQn);
		oi.setUnwrappedOperation(oi2);

		boi = new BindingOperationInfo(bi, oi);
		at(boi.isUnwrappedCapable());
		af(boi.getUnwrappedOperation().getOperationInfo() == oi3);
		bi.addOperation(boi);

		an(bi.getOperation(oi3));
	}

	@Test
	public void test10() {

		QName oiQn2 = new QName("oiQn2");
		OperationInfo oi2 = new OperationInfo();
		oi2.setName(oiQn2);

		oi = new OperationInfo();
		oi.setName(oiQn);

		boi = new BindingOperationInfo(bi, oi);
		af(boi.isUnwrappedCapable());
		bi.addOperation(boi);

		an(bi.getOperation(oi2));
	}

	@Test
	public void test11() {
		aeq("[BindingInfo bindingId]", bi.toString());
	}

	@Test
	public void test12() {
		boi = bi.buildOperation(oiQn, "inputName", "outputName");
		an(boi);
	}

	@Test
	public void test13() {
		oi = bi.getInterface().addOperation(oiQn);
		QName imiQn = new QName("imiQn");
		QName omiQn = new QName("omiQn");
		MessageInfo imi = new MessageInfo(oi, Type.INPUT, imiQn);
		MessageInfo omi = new MessageInfo(oi, Type.OUTPUT, omiQn);
		oi.setInput("inputName", imi);
		oi.setOutput("outputName", omi);
		boi = bi.buildOperation(oiQn, "inputName", "outputName");
		ann(boi);
	}

	@Test
	public void test14() {
		oi = bi.getInterface().addOperation(oiQn);
		QName imiQn = new QName("imiQn");
		QName omiQn = new QName("omiQn");
		MessageInfo imi = new MessageInfo(oi, Type.INPUT, imiQn);
		MessageInfo omi = new MessageInfo(oi, Type.OUTPUT, omiQn);
		oi.setInput("inputName", imi);
		oi.setOutput("outputName", omi);
		boi = bi.buildOperation(new QName("oiQn2"), "inputName", "outputName");
		an(boi);
	}

	@Test
	public void test15() {
		oi = bi.getInterface().addOperation(oiQn);
		QName imiQn = new QName("imiQn");
		QName omiQn = new QName("omiQn");
		MessageInfo imi = new MessageInfo(oi, Type.INPUT, imiQn);
		MessageInfo omi = new MessageInfo(oi, Type.OUTPUT, omiQn);
		oi.setInput("inputNameX", imi);
		oi.setOutput("outputName", omi);
		boi = bi.buildOperation(oiQn, "inputName", "outputName");
		an(boi);
	}
	
	@Test
	public void test16() {
		oi = bi.getInterface().addOperation(oiQn);
		QName imiQn = new QName("imiQn");
		QName omiQn = new QName("omiQn");
		MessageInfo imi = new MessageInfo(oi, Type.INPUT, imiQn);
		MessageInfo omi = new MessageInfo(oi, Type.OUTPUT, omiQn);
		oi.setInput("inputName", imi);
		oi.setOutput("outputNameX", omi);
		boi = bi.buildOperation(oiQn, "inputName", "outputName");
		an(boi);
	}
	
	@Test
	public void test17() {
		oi = bi.getInterface().addOperation(oiQn);
		QName imiQn = new QName("imiQn");
		QName omiQn = new QName("omiQn");
		MessageInfo imi = new MessageInfo(oi, Type.INPUT, imiQn);
		MessageInfo omi = new MessageInfo(oi, Type.OUTPUT, omiQn);
		oi.setInput(null, imi);
		oi.setOutput("outputName", omi);
		boi = bi.buildOperation(oiQn, "inputName", "outputName");
		an(boi);
	}
	
	@Test
	public void test18() {
		oi = bi.getInterface().addOperation(oiQn);
		QName imiQn = new QName("imiQn");
		QName omiQn = new QName("omiQn");
		MessageInfo imi = new MessageInfo(oi, Type.INPUT, imiQn);
		MessageInfo omi = new MessageInfo(oi, Type.OUTPUT, omiQn);
		oi.setInput("inputName", imi);
		oi.setOutput("outputName", omi);
		boi = bi.buildOperation(oiQn, null, "outputName");
		ann(boi);
	}
	
	@Test
	public void test19() {
		oi = bi.getInterface().addOperation(oiQn);
		QName imiQn = new QName("imiQn");
		QName omiQn = new QName("omiQn");
		MessageInfo imi = new MessageInfo(oi, Type.INPUT, imiQn);
		MessageInfo omi = new MessageInfo(oi, Type.OUTPUT, omiQn);
		oi.setInput("inputName", imi);
		oi.setOutput("outputName", omi);
		boi = bi.buildOperation(oiQn, "", "outputName");
		an(boi);
	}
}

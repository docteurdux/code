package dux.org.apache.cxf.service.model;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.FaultInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.service.model.UnwrappedOperationInfo;
import org.apache.cxf.service.model.MessageInfo.Type;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class BindingOperationInfoTest extends AbstractTest {

	private String bindingId;

	private QName iiQn;
	private QName oiQn;
	private ServiceInfo si;
	private InterfaceInfo ii;
	private BindingInfo bi;

	private QName imiQn;
	private QName omiQn;

	private QName fiQn;
	private QName mQn;

	private QName oiQnW;

	@Before
	public void before() {
		bindingId = "bindingId";

		iiQn = new QName("iiQn");
		oiQn = new QName("oiQn");
		oiQnW = new QName("oiQnW");
		imiQn = new QName("imiQn");
		omiQn = new QName("omiQn");
		fiQn = new QName("fiQn");
		mQn = new QName("mQn");

		si = new ServiceInfo();
		ii = new InterfaceInfo(si, iiQn);
		bi = new BindingInfo(si, bindingId);

	}

	@Test
	public void test1() {

		OperationInfo oi = ii.addOperation(oiQn);
		BindingOperationInfo boi = new BindingOperationInfo(bi, oi);

		aeq(bi, boi.getBinding());
		aeq(oi, boi.getOperationInfo());
		an(boi.getInput());
		an(boi.getOutput());
		at(boi.getFaults().isEmpty());
		an(boi.getUnwrappedOperation());
		aeq(oiQn, boi.getName());
		an(boi.getFault(fiQn));
		af(boi.isUnwrappedCapable());
		an(boi.getWrappedOperation());

		af(boi.isUnwrapped());
	}

	/**
	 * The list of faults is never null
	 **/
	@Test
	public void test2() {

		OperationInfo oi = ii.addOperation(oiQn);
		OperationInfo oiw = ii.addOperation(oiQnW);

		MessageInfo imi = new MessageInfo(oi, Type.INPUT, imiQn);
		MessageInfo omi = new MessageInfo(oi, Type.OUTPUT, omiQn);
		FaultInfo fi = oi.addFault(fiQn, mQn);
		oi.setInput("inputName", imi);
		oi.setOutput("ouputName", omi);
		oi.setUnwrappedOperation(oiw);

		BindingOperationInfo boi = new BindingOperationInfo(bi, oi);

		aeq(imi, boi.getInput().getMessageInfo());
		aeq(omi, boi.getOutput().getMessageInfo());
		aeq(fi, boi.getFaults().iterator().next().getFaultInfo());
		aeq(oiw, boi.getUnwrappedOperation().getOperationInfo());
		aeq(fi, boi.getFault(fiQn).getFaultInfo());
		at(boi.isUnwrappedCapable());
		aeq(oiw, boi.getWrappedOperation().getOperationInfo());

		boi.toString();
		boi.hashCode();

		BindingOperationInfo dboi = new BindingOperationInfo(bi, new OperationInfo());
		dboi.toString();
	}

	@Test
	public void test3() {

		OperationInfo oi = ii.addOperation(oiQn);
		UnwrappedOperationInfo uoi = new UnwrappedOperationInfo(oi);
		BindingOperationInfo boi = new BindingOperationInfo(bi, uoi);
		at(boi.isUnwrapped());

	}

	@Test
	public void test4() {

		OperationInfo oi = ii.addOperation(oiQn);
		OperationInfo oiw = ii.addOperation(oiQnW);

		BindingOperationInfo boi = new BindingOperationInfo(bi, oi);
		BindingOperationInfo boiw = new BindingOperationInfo(bi, oiw);
		boi.setUnwrappedOperation(boiw);
		aeq(boiw, boi.getUnwrappedOperation());

	}

	/** The update is not always effective **/
	@Test
	public void test5() {

		OperationInfo oi = ii.addOperation(oiQn);
		OperationInfo oiw = ii.addOperation(oiQnW);
		OperationInfo oiw2 = ii.addOperation(new QName("oiQnW2"));

		BindingOperationInfo boi = new BindingOperationInfo(bi, oi);
		boi.updateUnwrappedOperation();
		an(boi.getUnwrappedOperation());

		oi.setUnwrappedOperation(oiw);
		boi.updateUnwrappedOperation();
		aeq(oiw, boi.getUnwrappedOperation().getOperationInfo());

		oi.setUnwrappedOperation(oiw2);
		boi.updateUnwrappedOperation();
		aeq(oiw, boi.getUnwrappedOperation().getOperationInfo());

	}

	/**
	 * toString throws with default constructor
	 */
	@Test(expected = NullPointerException.class)
	public void test6() {
		new BindingOperationInfo().toString();
	}

	@Test
	public void test7() {
		OperationInfo oi = ii.addOperation(oiQn);
		BindingOperationInfo boi = new BindingOperationInfo(bi, oi);
		boi.equals(boi);
		boi.equals(null);
		BindingOperationInfo boi2 = new BindingOperationInfo(bi, oi);
		boi.equals(boi2);

	}
}

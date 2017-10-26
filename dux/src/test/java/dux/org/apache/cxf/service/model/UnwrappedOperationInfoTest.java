package dux.org.apache.cxf.service.model;

import javax.xml.namespace.QName;

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

public class UnwrappedOperationInfoTest extends AbstractTest {

	private QName iiQn;
	private QName oiQn;
	private ServiceInfo si;
	private InterfaceInfo ii;
	private OperationInfo oi;
	private UnwrappedOperationInfo uoi;
	private QName fiQn;
	private QName mQn;
	private FaultInfo fi;
	private MessageInfo imi;
	private MessageInfo omi;
	private QName imiQn;
	private QName omiQn;
	private String inputName;
	private String outputName;

	@Before
	public void before() {

		inputName = "inputName";
		outputName = "outputName";

		iiQn = new QName("iiQn");
		oiQn = new QName("oiQn");
		fiQn = new QName("fiQn");
		mQn = new QName("mQn");
		imiQn = new QName("imiQn");
		omiQn = new QName("omiQn");

		si = new ServiceInfo();
		ii = new InterfaceInfo(si, iiQn);
		oi = ii.addOperation(oiQn);
		uoi = new UnwrappedOperationInfo(oi);

		imi = new MessageInfo(oi, Type.INPUT, imiQn);
		omi = new MessageInfo(oi, Type.OUTPUT, omiQn);

	}

	@Test
	public void test1() {
		aeq(oiQn, uoi.getName());
		aeq(oi, uoi.getWrappedOperation());
		at(uoi.isUnwrapped());
	}

	@Test
	public void test2() {
		fi = uoi.addFault(fiQn, mQn);
		aeq(fi, oi.getFault(fiQn));
	}

	@Test
	public void test3() {
		fi = oi.addFault(fiQn, mQn);
		aeq(fi, uoi.getFault(fiQn));
		aeq(fi, uoi.getFaults().iterator().next());
	}

	/** TODO : check that delegate has wrapped output **/
	@Test
	public void test4() {

		uoi.setOutput(outputName, omi);
		aeq(omi, uoi.getOutput());
		aeq(outputName, uoi.getOutputName());
		an(oi.getOutput());
		an(oi.getOutputName());

	}

	/** TODO : check that delegate has wrapped output **/
	@Test
	public void test5() {

		uoi.setOutput(outputName, omi);
		aeq(omi, uoi.getOutput());
		aeq(outputName, uoi.getOutputName());
		an(oi.getOutput());
		an(oi.getOutputName());

	}

	/** TODO : check that delegate has wrapped output **/
	@Test
	public void test6() {

		uoi.setInput(inputName, imi);
		aeq(imi, uoi.getInput());
		aeq(inputName, uoi.getInputName());
		an(oi.getInput());
		an(oi.getInputName());

	}
}

package dux.org.apache.cxf.service.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.FaultInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.MessageInfo.Type;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.apache.cxf.service.model.UnwrappedOperationInfo;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class OperationInfoTest extends AbstractTest {

	private OperationInfo oi;
	private QName oiQn;
	private QName imiQn;
	private QName omiQn;
	String inputName;
	String outputName;
	private MessageInfo imi;
	private MessageInfo omi;
	private QName fiQn;
	private QName mQn;
	private QName mQn2;
	private FaultInfo fi;

	@Before
	public void before() {

		inputName = "inputName";
		outputName = "outputName";

		oiQn = new QName("oiQn");
		imiQn = new QName("imiQn");
		omiQn = new QName("omiQn");
		fiQn = new QName("fQn");
		mQn = new QName("mQn");
		mQn2 = new QName("mQn2");

		oi = new OperationInfo();

		imi = new MessageInfo(oi, Type.INPUT, imiQn);
		omi = new MessageInfo(oi, Type.OUTPUT, omiQn);

		fi = new FaultInfo(fiQn, imiQn, oi);
	}

	/** name **/
	@Test
	public void test1() {

		an(oi.getName());

		oi.setName(oiQn);
		aeq(oiQn, oi.getName());

	}

	/** name cannot be set to null **/
	@Test(expected = NullPointerException.class)
	public void test2() {
		ann(oi);
		oi.setName(null);
	}

	/** interface can be set only with constuctor **/
	@Test
	public void test3() {

		an(oi.getInterface());

	}

	/** output and output name work together **/
	@Test
	public void test4() {

		an(oi.getOutput());
		an(oi.getOutputName());
		af(oi.hasOutput());

		oi.setOutput(outputName, omi);

		aeq(outputName, oi.getOutputName());
		aeq(omi, oi.getOutput());
		at(oi.hasOutput());

	}

	/** input and input name work together **/
	@Test
	public void test5() {

		an(oi.getInput());
		an(oi.getInputName());
		af(oi.hasInput());

		oi.setInput(inputName, imi);

		aeq(inputName, oi.getInputName());
		aeq(imi, oi.getInput());
		at(oi.hasInput());

	}

	/** isOneWay iff has input but not has output **/
	@Test
	public void test6() {

		oi.setInput(null, null);
		oi.setOutput(null, null);
		af(oi.isOneWay());

		oi.setInput(null, null);
		oi.setOutput(outputName, omi);
		af(oi.isOneWay());

		oi.setInput(inputName, imi);
		oi.setOutput(null, null);
		at(oi.isOneWay());

		oi.setInput(inputName, imi);
		oi.setOutput(outputName, omi);
		af(oi.isOneWay());

	}

	/** always unwrapped **/
	@Test
	public void test7() {
		af(oi.isUnwrapped());

	}

	/** unwrapped capability **/
	@Test
	public void test8() {
		af(oi.isUnwrappedCapable());
		an(oi.getUnwrappedOperation());
		oi.setUnwrappedOperation(oi);
		at(oi.isUnwrappedCapable());
		aeq(oi, oi.getUnwrappedOperation());
	}

	/**
	 * unwrapped capability and I/O ; dunno how to check that the delegate has been
	 * set, but this achieves 100% coverage
	 **/
	@Test
	public void test9() {
		oi.setUnwrappedOperation(oi);
		oi.setInput(inputName, imi);
		oi.setOutput(outputName, omi);

		oi.setUnwrappedOperation(new OperationInfo());
		oi.setInput(inputName, imi);
		oi.setOutput(outputName, omi);
	}

	/**
	 * unwrapped capability and I/O ; dunno how to check that the delegate has been
	 * set, but this achieves 100% coverage
	 **/
	@Test
	public void test10() {
		an(oi.getParameterOrdering());
		ArrayList<String> ordering = new ArrayList<>();
		oi.setParameterOrdering(ordering);
		aeq(ordering, oi.getParameterOrdering());
	}

	/** createMessage **/
	@Test
	public void test11() {
		MessageInfo cmi = oi.createMessage(imiQn, Type.INPUT);
		aeq(Type.INPUT, cmi.getType());
		aeq(imiQn, cmi.getName());
		aeq(oi, cmi.getOperation());
	}

	/**
	 * Faults ; to achieve 100% coverage, we must handle the cases were the list is
	 * map, and the cases where the map of faults is empty but not null
	 */
	@Test
	public void test12() {

		// At first, there are not faults
		af(oi.hasFaults());

		// The list of faults is empty
		Collection<FaultInfo> faults = oi.getFaults();
		at(faults.isEmpty());

		// Retrieving a fault returns null
		an(oi.getFault(fiQn));

		// Removing a faults does nothing
		oi.removeFault(fiQn);

		// Now we add a fault
		oi.addFault(fi);

		// The fault is found
		aeq(fi, oi.getFault(fiQn));

		// We can remove it
		oi.removeFault(fiQn);

		// Now the fault is not found
		an(oi.getFault(fiQn));

		// Now there are no faults
		af(oi.hasFaults());

		// We can ad it again
		oi.addFault(fi);

		// Then we get the fault
		aeq(fi, oi.getFault(fiQn));

		// There are faults
		at(oi.hasFaults());

		// The list of faults contains the fault
		aeq(fi, oi.getFaults().iterator().next());
	}

	/** Another way of adding faults **/
	@Test
	public void test13() {
		af(oi.hasFaults());
		fi = oi.addFault(fiQn, mQn);
		aeq(fi, oi.getFault(fiQn));
		aeq(fiQn, fi.getFaultName());
		aeq(mQn, fi.getName());
		oi.removeFault(fi.getFaultName());
		fi = oi.addFault(fiQn, mQn);
	}

	/** Fault name must not be null **/
	@Test(expected = NullPointerException.class)
	public void test14() {
		fi = oi.addFault(null, mQn);
	}

	/** Duplicates are not allowed **/
	@Test(expected = IllegalArgumentException.class)
	public void test15() {
		fi = oi.addFault(fiQn, mQn);
		fi = oi.addFault(fiQn, mQn2);
	}

	/** toString and hashCode **/
	@Test
	public void test16() {
		oi.toString();
		oi.hashCode();
		oi.setName(oiQn);
		oi.hashCode();
	}

	/**
	 * equals : 100% coverage here is always difficult to get and rarely meaningful
	 **/
	@Test
	public void test17() {
		oi.equals(null);
		oi.equals(new Object());

		OperationInfo oi2 = new OperationInfo();
		oi2.setName(new QName("oi2Qn"));

		oi.equals(oi2);

		oi2 = new OperationInfo();
		oi2.setInput(inputName, imi);
		oi.equals(oi2);

		oi2 = new OperationInfo();
		oi2.setOutput(outputName, omi);
		oi.equals(oi2);

		oi2 = new OperationInfo();
		oi2.addFault(fiQn, mQn);
		oi.equals(oi2);

		// ServiceInfo si = new ServiceInfo();
		// ServiceInfo si2 = new ServiceInfo();
		//
		// QName iiQn = new QName("iiQn");
		// QName iiQn2 = new QName("iiQn2");
		//
		// InterfaceInfo ii = new InterfaceInfo(si, iiQn);
		// InterfaceInfo ii2 = new InterfaceInfo(si2, iiQn2);
		//
		// oi = ii.addOperation(oiQn);
		// oi2 = ii2.addOperation(oiQn);
		// oi.equals(oi2);
		//
		// ii2.setName(iiQn);
		// oi.equals(oi2);

	}

	/**
	 * The package level constructors can be reached through InterfaceInfo and
	 * UnwrappedOperationInfo
	 */
	@Test
	public void test18() {
		QName iiQn = new QName("iiQn");
		ServiceInfo si = new ServiceInfo();
		InterfaceInfo ii = new InterfaceInfo(si, iiQn);
		oi = ii.addOperation(oiQn);

		aeq(oiQn, oi.getName());
		aeq(ii, oi.getInterface());

		UnwrappedOperationInfo uoi = new UnwrappedOperationInfo(oi);
	}

}

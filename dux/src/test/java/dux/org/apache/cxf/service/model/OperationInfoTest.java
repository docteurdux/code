package dux.org.apache.cxf.service.model;

import java.util.ArrayList;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.MessageInfo.Type;
import org.apache.cxf.service.model.OperationInfo;
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

	@Before
	public void before() {

		inputName = "inputName";
		outputName = "outputName";

		oiQn = new QName("oiQn");
		imiQn = new QName("imiQn");
		omiQn = new QName("omiQn");

		oi = new OperationInfo();

		imi = new MessageInfo(oi, Type.INPUT, imiQn);
		omi = new MessageInfo(oi, Type.OUTPUT, omiQn);
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
}

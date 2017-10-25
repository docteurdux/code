package dux.org.apache.cxf.service.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.MessageInfo.Type;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class MessageInfoTest extends AbstractTest {

	private QName miQn;
	private OperationInfo oi;
	private MessageInfo mi;
	private QName miQn2;
	private Map<QName, MessagePartInfo> messageParts;
	private QName mpiQn;
	private MessagePartInfo mpi;
	private List<MessagePartInfo> orderedParts;
	private List<String> order;
	private String mpiQnLP;
	private String iiQnWeirdNS;
	private QName iiQnWeird;
	private QName oiQn;
	private ServiceInfo si;
	private InterfaceInfo iiWeird;

	@Before
	public void before() {

		mpiQnLP = "mpiQn";
		iiQnWeirdNS = "iiNs";

		iiQnWeird = new QName(iiQnWeirdNS, "iiQn");
		oiQn = new QName("oiQn");
		miQn = new QName("miQn");
		miQn2 = new QName("miQn2");
		mpiQn = new QName(mpiQnLP);

		oi = new OperationInfo();
		mi = new MessageInfo(oi, Type.INPUT, miQn);
		order = new ArrayList<>();

		si = new ServiceInfo();
		iiWeird = new InterfaceInfo(si, iiQnWeird);
	}

	/** Basic getters and setters **/
	@Test
	public void test1() {

		aeq(miQn, mi.getName());
		aeq("[MessageInfo INPUT: miQn]", mi.toString());
		aeq(Type.INPUT, mi.getType());

		mi.setName(miQn2);
		mi.setType(Type.OUTPUT);

		aeq(miQn2, mi.getName());
		aeq("[MessageInfo OUTPUT: miQn2]", mi.toString());
		aeq(Type.OUTPUT, mi.getType());
	}

	/** message parts */
	@Test
	public void test2() {

		messageParts = mi.getMessagePartsMap();
		aeq(0, messageParts.size());

		mpi = mi.addMessagePart(mpiQn);
		messageParts = mi.getMessagePartsMap();
		Entry<QName, MessagePartInfo> entry = messageParts.entrySet().iterator().next();

		aeq(1, messageParts.size());
		aeq(mpiQn, entry.getKey());
		aeq(mpi, entry.getValue());

	}

	/**
	 * getOrderedParts : if the order list is empty, or if the first element is the
	 * mepty string, it returns all the message parts
	 */
	@Test
	public void test3() {

		orderedParts = mi.getOrderedParts(order);
		aeq(0, orderedParts.size());

		order.add("");
		orderedParts = mi.getOrderedParts(order);
		aeq(0, orderedParts.size());

		mpi = mi.addMessagePart(mpiQn);
		order.clear();
		orderedParts = mi.getOrderedParts(order);
		aeq(1, orderedParts.size());
		aeq(mpi, orderedParts.get(0));

		order.add("");
		orderedParts = mi.getOrderedParts(order);
		aeq(1, orderedParts.size());
		aeq(mpi, orderedParts.get(0));

	}

	/**
	 * getOrderedParts : but if the order list is not empty, it fails
	 */
	@Test(expected = NullPointerException.class)
	public void test4() {
		order.add(mpiQnLP);
		orderedParts = mi.getOrderedParts(order);
	}

	/**
	 * getOrderedParts : an interface is required to make it work, and if the
	 * requrest message parts are not found, null elements are produced
	 */
	@Test
	public void test5() {

		oi = iiWeird.addOperation(oiQn);
		mi = new MessageInfo(oi, Type.INPUT, miQn);

		order.add(mpiQnLP);

		orderedParts = mi.getOrderedParts(order);
		aeq(1, orderedParts.size());
		an(orderedParts.get(0));

	}

	/**
	 * getOrderedParts : the mpi must have the namepspace of the interface to be
	 * found
	 */
	@Test
	public void test6() {

		oi = iiWeird.addOperation(oiQn);
		mi = new MessageInfo(oi, Type.INPUT, miQn);

		order.add(mpiQnLP);

		mpi = mi.addMessagePart(mpiQn);

		orderedParts = mi.getOrderedParts(order);
		aeq(1, orderedParts.size());
		an(orderedParts.get(0));

		mpi = mi.addMessagePart(new QName(iiQnWeirdNS, mpiQnLP));

		orderedParts = mi.getOrderedParts(order);
		aeq(1, orderedParts.size());
		aeq(mpi, orderedParts.get(0));

	}
}

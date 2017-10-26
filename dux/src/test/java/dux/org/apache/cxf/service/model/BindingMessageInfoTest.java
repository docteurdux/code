package dux.org.apache.cxf.service.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.BindingInfo;
import org.apache.cxf.service.model.BindingMessageInfo;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.InterfaceInfo;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.MessageInfo.Type;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.cxf.service.model.ServiceInfo;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class BindingMessageInfoTest extends AbstractTest {

	public static class BMI extends BindingMessageInfo {
		public BMI(MessageInfo m, BindingOperationInfo boi) {
			super(m, boi);
		}
	}

	private QName mpiQn;
	private QName miQn;
	private QName iiQn;
	private QName oiQn;
	private ServiceInfo si;
	private InterfaceInfo ii;
	private String bindingId;
	private BindingInfo bi;

	@Before
	public void before() {

		bindingId = "bindingId";

		mpiQn = new QName("mpiQn");
		miQn = new QName("miQn");
		iiQn = new QName("iiQn");
		oiQn = new QName("oiQn");

		si = new ServiceInfo();
		ii = new InterfaceInfo(si, iiQn);
		bi = new BindingInfo(si, bindingId);
	}

	@Test
	public void test1() {

		BindingMessageInfo bmi = new BindingMessageInfo();
		an(bmi.getMessageInfo());
		an(bmi.getBindingOperation());
		an(bmi.getMessageParts());

		OperationInfo oi = ii.addOperation(oiQn);
		MessageInfo mi = new MessageInfo(oi, Type.INPUT, miQn);
		MessagePartInfo mpi = new MessagePartInfo(mpiQn, mi);

		List<MessagePartInfo> mpis = new ArrayList<>();
		mpis.add(mpi);
		bmi.setMessageParts(mpis);

		aeq(mpi, bmi.getMessageParts().iterator().next());

		BindingOperationInfo boi = new BindingOperationInfo(bi, oi);
		mi.addMessagePart(mpi);
		BMI bmi2 = new BMI(mi, boi);
		aeq(boi, bmi2.getBindingOperation());
		aeq(mi, bmi2.getMessageInfo());
		aeq(mpi, bmi2.getMessageParts().iterator().next());
	}

}

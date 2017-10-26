package dux.org.apache.cxf.service.model;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.FaultInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class FaultInfoTest extends AbstractTest {
	private OperationInfo oi;
	private QName fiQn;
	private QName fiQn2;
	private QName mQn;
	private FaultInfo fi;

	@Before
	public void before() {
		oi = new OperationInfo();
		fiQn = new QName("fiQn");
		fiQn2 = new QName("fiQn2");
		mQn = new QName("mQn");
		fi = new FaultInfo(fiQn, mQn, oi);
	}

	@Test
	public void test1() {
		aeq(fiQn, fi.getFaultName());
		aeq(mQn, fi.getName());
		aeq(oi, fi.getOperation());
	}

	@Test
	public void test2() {
		fi.setFaultName(fiQn2);
		aeq(fiQn2, fi.getFaultName());
	}

	@Test
	public void test3() {
		fi.hashCode();
		fi.setFaultName(null);
		fi.hashCode();
	}

	@Test
	public void test4() {
		fi.equals(null);
		fi.equals(fi);

		FaultInfo fi2 = new FaultInfo(fiQn2, mQn, oi);
		fi.equals(fi2);

		fi2 = new FaultInfo(fiQn, mQn, oi);
		fi.equals(fi2);

		fi2 = new FaultInfo(fiQn, new QName("mQn2"), oi);
		fi.equals(fi2);
	}
}

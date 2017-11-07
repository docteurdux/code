package dux.org.apache.cxf.binding.soap;

import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapHeader;
import org.apache.cxf.databinding.DataBinding;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dux.org.apache.cxf.databinding.DummyDataBinding;

@Done
public class SoapHeaderTest extends AbstractTest {

	private Object object;
	private QName headerQN;

	@Before
	public void before() {
		object = new Object();
		headerQN = new QName("headerNS", "headerLP");
	}

	@Test
	public void test1() {

		SoapHeader header = new SoapHeader(headerQN, object);

		an(header.getActor());
		af(header.isMustUnderstand());

		header.setActor("actor");
		header.setMustUnderstand(true);

		aeq("actor", header.getActor());
		at(header.isMustUnderstand());
	}

	@Test
	public void test2() {

		DataBinding db = new DummyDataBinding();

		SoapHeader header = new SoapHeader(headerQN, object, db);

		header = new SoapHeader(headerQN, object, db, true);
		at(header.isMustUnderstand());

		header = new SoapHeader(headerQN, object, db, true, "actor");
		aeq("actor", header.getActor());

	}
}

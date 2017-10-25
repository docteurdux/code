package dux.org.apache.cxf.service.model;

import javax.xml.namespace.QName;

import org.apache.cxf.service.model.AbstractMessageContainer;
import org.apache.cxf.service.model.MessageInfo;
import org.apache.cxf.service.model.MessageInfo.Type;
import org.apache.cxf.service.model.MessagePartInfo;
import org.apache.cxf.service.model.OperationInfo;
import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaAnnotated;
import org.apache.ws.commons.schema.XmlSchemaElement;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.apache.ws.commons.schema.DummyXmlSchemaAnnotated;

@Done
public class MessagePartInfoTest extends AbstractTest {

	public static class A {

	}

	private QName mpiQn;
	private AbstractMessageContainer mi;
	private MessagePartInfo mpi;
	private QName miQn;
	private OperationInfo oi;
	private String mpiQnLP;

	@Before
	public void before() {
		mpiQnLP = "mpiQn";
		mpiQn = new QName(mpiQnLP);
		miQn = new QName("miQn");
		oi = new OperationInfo();
		mi = new MessageInfo(oi, Type.INPUT, miQn);
		mpi = new MessagePartInfo(mpiQn, mi);
	}

	/** Basic getters and setters */
	@Test
	public void test1() {
		aeq(mpiQn, mpi.getName());
		aeq(mi, mpi.getMessageInfo());
		an(mpi.getConcreteName());
		af(mpi.isElement());
		an(mpi.getXmlSchema());
		an(mpi.getTypeClass());
		aeq(0, mpi.getIndex());

		QName mpi2Qn = new QName("mpi2Qn");
		QName mi2Qn = new QName("mi2Qn");
		QName cnQn = new QName("cnQn");
		MessageInfo mi2 = new MessageInfo(oi, Type.INPUT, mi2Qn);
		XmlSchemaAnnotated xmlSchema = new DummyXmlSchemaAnnotated();

		mpi.setName(mpi2Qn);
		mpi.setMessageContainer(mi2);
		mpi.setConcreteName(cnQn);
		mpi.setElement(true);
		mpi.setXmlSchema(xmlSchema);
		mpi.setTypeClass(A.class);
		mpi.setIndex(1);

		aeq(mpi2Qn, mpi.getName());
		aeq(mi2, mpi.getMessageInfo());
		aeq(cnQn, mpi.getConcreteName());
		at(mpi.isElement());
		aeq(xmlSchema, mpi.getXmlSchema());
		aeq(A.class, mpi.getTypeClass());
		aeq(1, mpi.getIndex());

	}

	/**
	 * Setting the element QName sets element mode and sets both element and
	 * concrete QName
	 */
	@Test
	public void test2() {
		af(mpi.isElement());
		an(mpi.getElementQName());
		an(mpi.getConcreteName());

		QName eQn = new QName("eQn");

		mpi.setElementQName(eQn);

		at(mpi.isElement());
		aeq(eQn, mpi.getElementQName());
		aeq(eQn, mpi.getConcreteName());

	}

	/**
	 * Setting the type QName unsets element mode and sets the type Qname and the
	 * concrete to the unqualified message part name if it is undefined
	 */
	@Test
	public void test3() {

		mpi.setElement(true);

		at(mpi.isElement());
		an(mpi.getTypeQName());
		an(mpi.getConcreteName());

		QName tQn = new QName("tQn");
		QName cQn = new QName("cQn");

		mpi.setTypeQName(tQn);

		af(mpi.isElement());
		aeq(tQn, mpi.getTypeQName());
		at(new QName(null, mpiQnLP).equals(mpi.getConcreteName()));

		mpi.setConcreteName(cQn);
		mpi.setTypeQName(tQn);
		af(mpi.isElement());
		aeq(tQn, mpi.getTypeQName());
		aeq(cQn, mpi.getConcreteName());

	}

	/**
	 * In element mode, the type QName is derived from the xmlSchema if it is set
	 */
	@Test
	public void test4() {

		QName eQn = new QName("eQn");
		QName schQn = new QName("schQn");

		mpi.setElementQName(eQn);

		an(mpi.getTypeQName());

		XmlSchema parentSchema = new XmlSchema();
		XmlSchemaElement xmlSchema = new XmlSchemaElement(parentSchema, true);
		xmlSchema.setSchemaTypeName(schQn);

		mpi.setXmlSchema(xmlSchema);

		aeq(schQn, mpi.getTypeQName());

	}

	/**
	 * The hashcode depends only on the name ; this is not easy to test and this
	 * test only achieves 100% coverage and does not check anything
	 */
	@Test
	public void test5() {

		mpi.hashCode();
		mpi.setName(null);
		mpi.hashCode();

	}

	/**
	 * Equality is also quite difficult to test
	 */
	@Test
	public void test6() {

		mpi.equals(mpi);
		mpi.equals(new Object());

		MessagePartInfo mpi2 = new MessagePartInfo(mpi.getName(), mpi.getMessageInfo());
		mpi.equals(mpi2);

		mpi2.setName(null);
		mpi.equals(mpi2);

		mpi2.setName(mpi.getName());
		mpi2.setElement(!mpi.isElement());
		mpi.equals(mpi2);

		mpi2 = new MessagePartInfo(mpi.getName(), mpi.getMessageInfo());
		QName tQn = new QName("tQn");
		mpi2.setTypeQName(tQn);
		mpi.equals(mpi2);

		mpi2 = new MessagePartInfo(mpi.getName(), mpi.getMessageInfo());
		QName eQn = new QName("eQn");
		mpi2.setElementQName(eQn);
		mpi.setElement(true);
		mpi.equals(mpi2);
		mpi.setElement(false);

		mpi2 = new MessagePartInfo(mpi.getName(), mpi.getMessageInfo());
		QName cQn = new QName("cQn");
		mpi2.setConcreteName(cQn);
		mpi.equals(mpi2);

		mpi2 = new MessagePartInfo(mpi.getName(), mpi.getMessageInfo());
		mpi2.setTypeClass(A.class);
		mpi.equals(mpi2);
	}

	/**
	 * toString is quite uninteresting
	 */
	@Test
	public void test7() {
		aeq("[MessagePartInfo name=mpiQn, ConcreteName=null", mpi.toString());
	}
}

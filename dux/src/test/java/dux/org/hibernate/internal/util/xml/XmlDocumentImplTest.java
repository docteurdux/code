package dux.org.hibernate.internal.util.xml;

import org.hibernate.internal.util.xml.OriginImpl;
import org.hibernate.internal.util.xml.XmlDocumentImpl;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.dom4j.DummyDocument;
import dum.org.hibernate.internal.util.xml.DummyOrigin;

@Done
public class XmlDocumentImplTest extends AbstractTest {

	private String originType;
	private String originName;
	private DummyOrigin origin;
	private DummyDocument document;

	@Before
	public void before() {

		originType = "originType";
		originName = "originName";

		origin = new DummyOrigin();

		document = new DummyDocument();
	}

	@Test
	public void test() {

		XmlDocumentImpl xmlDocumentImpl = new XmlDocumentImpl(document, origin);
		aeqr(document, xmlDocumentImpl.getDocumentTree());
		aeqr(origin, xmlDocumentImpl.getOrigin());

		xmlDocumentImpl = new XmlDocumentImpl(document, originType, originName);
		aeqr(document, xmlDocumentImpl.getDocumentTree());
		aeq(OriginImpl.class, xmlDocumentImpl.getOrigin().getClass());
		aeq(originType, xmlDocumentImpl.getOrigin().getType());
		aeq(originName, xmlDocumentImpl.getOrigin().getName());
	}
}

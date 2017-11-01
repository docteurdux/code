package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaAppInfo;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.NodeList;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.w3c.dom.DummyNodeList;

@Done
public class XmlSchemaAppInfoTest extends AbstractTest {

	private NodeList markup;
	private String source;

	@Before
	public void before() {
		source = "source";
		markup = new DummyNodeList();
	}

	@Test
	public void test1() {

		XmlSchemaAppInfo info = new XmlSchemaAppInfo();

		an(info.getSource());
		info.setSource(source);
		aeq(source, info.getSource());

		an(info.getMarkup());
		info.setMarkup(markup);
		aeqr(markup, info.getMarkup());
	}

}

package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaDocumentation;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.NodeList;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.w3c.dom.DummyNodeList;

@Done
public class XmlSchemaDocumentationTest extends AbstractTest {

	private String source;
	private String language;
	private NodeList markup;

	@Before
	public void before() {
		source = "source";
		language = "language";
		markup = new DummyNodeList();
	}

	@Test
	public void test1() {
		XmlSchemaDocumentation documentation = new XmlSchemaDocumentation();

		an(documentation.getSource());
		documentation.setSource(source);
		aeq(source, documentation.getSource());

		an(documentation.getLanguage());
		documentation.setLanguage(language);
		aeq(language, documentation.getLanguage());

		an(documentation.getMarkup());
		documentation.setMarkup(markup);
		aeqr(markup, documentation.getMarkup());
	}

}

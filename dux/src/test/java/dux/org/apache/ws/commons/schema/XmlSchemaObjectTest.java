package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaObject;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaObjectTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaObject xso = new XmlSchemaObject() {
		};

		xso.hashCode();

		aeq(0, xso.getLineNumber());
		xso.setLineNumber(1);
		aeq(1, xso.getLineNumber());

		aeq(0, xso.getLinePosition());
		xso.setLinePosition(2);
		aeq(2, xso.getLinePosition());

		xso.addMetaInfo("key", "value");
		xso.addMetaInfo("key", "value");
		aeq("value", xso.getMetaInfoMap().get("key"));
		xso.setMetaInfoMap(null);
		an(xso.getMetaInfoMap());

		an(xso.getSourceURI());
		xso.setSourceURI("sourceURI");
		aeq("sourceURI", xso.getSourceURI());

	}

	@Test
	public void test2() {
		XmlSchemaObject xso = new XmlSchemaObject() {
		};

		xso.equals(xso);
		xso.equals(null);

		XmlSchemaObject xso2 = new XmlSchemaObject() {
		};
		xso2.setLineNumber(1);
		xso.equals(xso2);

		xso2 = new XmlSchemaObject() {
		};
		xso2.setLinePosition(1);
		xso.equals(xso2);

		xso2 = new XmlSchemaObject() {
		};
		xso.setSourceURI("sourceURI");
		xso2.setSourceURI("sourceURI2");
		xso.equals(xso2);

		xso2 = new XmlSchemaObject() {
		};
		xso.setSourceURI("sourceURI");
		xso2.setSourceURI("sourceURI");
		xso.equals(xso2);

		xso2 = new XmlSchemaObject() {
		};
		xso.setSourceURI(null);
		xso2.setSourceURI("sourceURI");
		xso.equals(xso2);
		
		xso2 = new XmlSchemaObject() {
		};
		xso.setSourceURI(null);
		xso.equals(xso2);

	}

}

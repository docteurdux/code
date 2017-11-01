package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaAny;
import org.apache.ws.commons.schema.XmlSchemaContentProcessing;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaAnyTest extends AbstractTest {

	private String namespace;
	private String targetNamespace;

	@Before
	public void before() {
		namespace = "namespace";
		targetNamespace = "targetNamespace";
	}

	@Test
	public void test1() {
		XmlSchemaAny any = new XmlSchemaAny();

		an(any.getNamespace());
		any.setNamespace(namespace);
		aeq(namespace, any.getNamespace());

		an(any.getTargetNamespace());
		any.setTargetNamespace(targetNamespace);
		aeq(targetNamespace, any.getTargetNamespace());

		aeq(XmlSchemaContentProcessing.NONE, any.getProcessContent());
		any.setProcessContent(XmlSchemaContentProcessing.SKIP);
		aeq(XmlSchemaContentProcessing.SKIP, any.getProcessContent());
	}

}

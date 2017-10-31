package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaAnnotated;
import org.apache.ws.commons.schema.XmlSchemaAnnotation;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Attr;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaAnnotatedTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaAnnotated annotated = new XmlSchemaAnnotated() {
		};

		an(annotated.getId());
		annotated.setId("id");
		aeq("id", annotated.getId());

		an(annotated.getAnnotation());
		XmlSchemaAnnotation annotation = new XmlSchemaAnnotation();
		annotated.setAnnotation(annotation);
		aeqr(annotation, annotated.getAnnotation());

		an(annotated.getUnhandledAttributes());
		Attr[] attrs = new Attr[] {};
		annotated.setUnhandledAttributes(attrs);
		aeqr(attrs, annotated.getUnhandledAttributes());

		annotated.toString();
		annotated.setId(null);
		annotated.toString();

	}

}

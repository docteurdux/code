package dux.org.apache.ws.commons.schema;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.ws.commons.schema.XmlSchemaIdentityConstraint;
import org.apache.ws.commons.schema.XmlSchemaXPath;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaIdentityConstraintTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		XmlSchemaIdentityConstraint constraint = new XmlSchemaIdentityConstraint();
		aeq(0, constraint.getFields().size());

		an(constraint.getName());
		constraint.setName("name");
		aeq("name", constraint.getName());

		XmlSchemaXPath selector = new XmlSchemaXPath();
		an(constraint.getSelector());
		constraint.setSelector(selector);
		aeqr(selector, constraint.getSelector());

		List<XmlSchemaXPath> fields = new ArrayList<>();
		Method setFields = XmlSchemaIdentityConstraint.class.getDeclaredMethod("setFields", List.class);
		setFields.setAccessible(true);
		setFields.invoke(constraint, fields);
		aeqr(fields, constraint.getFields());
	}

}

package dux.org.apache.ws.commons.schema;

import org.apache.ws.commons.schema.XmlSchemaDerivationMethod;
import org.apache.ws.commons.schema.XmlSchemaException;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaDerivationMethodTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaDerivationMethod method = new XmlSchemaDerivationMethod();

		af(method.isEmpty());
		method.setEmpty(true);
		at(method.isEmpty());

		method = new XmlSchemaDerivationMethod();
		af(method.isExtension());
		method.setExtension(true);
		at(method.isExtension());

		method = new XmlSchemaDerivationMethod();
		af(method.isList());
		method.setList(true);
		at(method.isList());

		method = new XmlSchemaDerivationMethod();
		af(method.isRestriction());
		method.setRestriction(true);
		at(method.isRestriction());

		method = new XmlSchemaDerivationMethod();
		af(method.isSubstitution());
		method.setSubstitution(true);
		at(method.isSubstitution());

		method = new XmlSchemaDerivationMethod();
		af(method.isUnion());
		method.setUnion(true);
		at(method.isUnion());
	}

	@Test
	public void test2() {
		XmlSchemaDerivationMethod method = new XmlSchemaDerivationMethod();
		method.setAll(true);
		at(method.isAll());
		method.setAll(false);
		method.setNone(true);
		at(method.isNone());
		method.setUnion(true);
		af(method.isNone());
		method.setSubstitution(true);
		af(method.isNone());
		method.setRestriction(true);
		af(method.isNone());
		method.setList(true);
		af(method.isNone());
		method.setExtension(true);
		af(method.isNone());
		method.setEmpty(true);
		af(method.isNone());
		method.setAll(true);
		af(method.isNone());
		af(method.notAll());
	}

	@Test
	public void test3() {
		XmlSchemaDerivationMethod method = new XmlSchemaDerivationMethod();
		method.setAll(true);
		aeq("#all", method.toString());

		method.setAll(false);
		aeq("", method.toString());

		method.setExtension(true);
		method.setList(true);
		method.setRestriction(true);
		method.setSubstitution(true);
		method.setUnion(true);
		aeq("extension list restriction substitution union", method.toString());
	}

	@Test
	public void test4() {
		XmlSchemaDerivationMethod method = XmlSchemaDerivationMethod.schemaValueOf("");
		at(method.isNone());
	}

	@Test
	public void test5() {
		XmlSchemaDerivationMethod method = XmlSchemaDerivationMethod.schemaValueOf("all");
		at(method.isAll());
	}

	@Test
	public void test6() {
		XmlSchemaDerivationMethod method = XmlSchemaDerivationMethod.schemaValueOf("#all");
		at(method.isAll());
	}

	@Test
	public void test7() {
		XmlSchemaDerivationMethod method = XmlSchemaDerivationMethod.schemaValueOf("extension");
		at(method.isExtension());
	}

	@Test
	public void test8() {
		XmlSchemaDerivationMethod method = XmlSchemaDerivationMethod.schemaValueOf("list");
		at(method.isList());
	}

	@Test
	public void test9() {
		XmlSchemaDerivationMethod method = XmlSchemaDerivationMethod.schemaValueOf("restriction");
		at(method.isRestriction());
	}

	@Test
	public void test10() {
		XmlSchemaDerivationMethod method = XmlSchemaDerivationMethod.schemaValueOf("substitution");
		at(method.isSubstitution());
	}

	@Test
	public void test11() {
		XmlSchemaDerivationMethod method = XmlSchemaDerivationMethod.schemaValueOf("union");
		at(method.isUnion());
	}

	@Test(expected = XmlSchemaException.class)
	public void test12() {
		XmlSchemaDerivationMethod.schemaValueOf("union all");
	}

	@Test(expected = XmlSchemaException.class)
	public void test13() {
		XmlSchemaDerivationMethod.schemaValueOf("all union");
	}

}

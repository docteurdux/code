package dux.org.apache.ws.commons.schema;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchemaSimpleTypeUnion;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class XmlSchemaSimpleTypeUnionTest extends AbstractTest {

	@Before
	public void before() {
	}

	@Test
	public void test1() {
		XmlSchemaSimpleTypeUnion union = new XmlSchemaSimpleTypeUnion();

		aeq(0, union.getBaseTypes().size());

		String memberTypesSources = "memberTypesSources";
		an(union.getMemberTypesSource());
		union.setMemberTypesSource(memberTypesSources);
		aeq(memberTypesSources, union.getMemberTypesSource());

		QName[] memberTypesQNames = new QName[] {};
		an(union.getMemberTypesQNames());
		union.setMemberTypesQNames(memberTypesQNames);
		aeqr(memberTypesQNames, union.getMemberTypesQNames());

	}

}

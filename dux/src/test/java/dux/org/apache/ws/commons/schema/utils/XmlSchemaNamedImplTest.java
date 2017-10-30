package dux.org.apache.ws.commons.schema.utils;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchema;
import org.apache.ws.commons.schema.XmlSchemaCollection;
import org.apache.ws.commons.schema.XmlSchemaException;
import org.apache.ws.commons.schema.utils.XmlSchemaNamedImpl;
import org.apache.ws.commons.schema.utils.XmlSchemaRefBase;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done("equality missing")
public class XmlSchemaNamedImplTest extends AbstractTest {

	private String namespace;
	private String systemId;
	private XmlSchemaCollection parent;
	private XmlSchema schema;
	private boolean topLevel;
	private String name;
	private XmlSchemaRefBase refBase;
	private QName targetQName;

	@Before
	public void before() {
		namespace = "namespace";
		systemId = "systemId";
		name = "name";
		targetQName = new QName("targetQName");
		parent = new XmlSchemaCollection();
		schema = new XmlSchema(namespace, systemId, parent);
		topLevel = true;

		refBase = new XmlSchemaRefBase() {
			@Override
			protected void forgetTargetObject() {

			}
		};
		refBase.setTargetQName(targetQName);
	}

	@Test
	public void test1() {
		XmlSchemaNamedImpl named = new XmlSchemaNamedImpl(schema, topLevel);

		aeqr(schema, named.getParent());
		aeq(topLevel, named.isTopLevel());

		an(named.getName());
		an(named.getQName());
		at(named.isAnonymous());

		named.setName(name);

		aeq(name, named.getName());
		aeq(new QName(namespace, name), named.getQName());
		af(named.isAnonymous());

		named.setName(null);
		an(named.getName());
		an(named.getQName());
		at(named.isAnonymous());

	}

	@Test(expected = XmlSchemaException.class)
	public void test2() {
		XmlSchemaNamedImpl named = new XmlSchemaNamedImpl(schema, topLevel);
		named.setName("");
	}

	@Test(expected = XmlSchemaException.class)
	public void test3() {
		XmlSchemaNamedImpl named = new XmlSchemaNamedImpl(schema, topLevel);
		named.setRefObject(refBase);
		named.setName(name);
	}

	@Test
	public void test4() {
		refBase.setTargetQName(null);
		XmlSchemaNamedImpl named = new XmlSchemaNamedImpl(schema, topLevel);
		named.setRefObject(refBase);
		named.setName(name);
		aeq(name, named.getName());
	}

	@Test
	public void test5() {
		XmlSchemaNamedImpl named = new XmlSchemaNamedImpl(schema, true);
		int hashCode1 = named.hashCode();
		named = new XmlSchemaNamedImpl(schema, false);
		int hashCode2 = named.hashCode();
		aneq(hashCode1, hashCode2);
	}

}

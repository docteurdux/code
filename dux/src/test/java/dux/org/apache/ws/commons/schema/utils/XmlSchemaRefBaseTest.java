package dux.org.apache.ws.commons.schema.utils;

import javax.xml.namespace.QName;

import org.apache.ws.commons.schema.XmlSchemaException;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.apache.ws.commons.schema.utils.DummyXmlSchemaNamed;
import dum.org.apache.ws.commons.schema.utils.DummyXmlSchemaRefBase;

@Done("need better story telling")
public class XmlSchemaRefBaseTest extends AbstractTest {
	private DummyXmlSchemaRefBase base;
	private DummyXmlSchemaNamed named;
	private QName targetQName;
	private QName targetQName2;

	@Before
	public void before() {
		targetQName = new QName("targetQName");
		targetQName2 = new QName("targetQName2");
		named = new DummyXmlSchemaNamed();
		base = new DummyXmlSchemaRefBase();
	}

	/** It's possible to set target qname and then named object **/
	@Test
	public void test1() {
		an(base.getTargetQName());
		base.setTargetQName(targetQName);
		base.setNamedObject(named);
	}

	/** Setting target name implies call to forget object **/
	@Test
	public void test2() {
		base.setTargetQName(targetQName);
		aeq(1, base.getForgetCount());
	}

	/**
	 * Target name not null and named object not null and not anonymous => exception
	 **/
	@Test(expected = XmlSchemaException.class)
	public void test3() {
		base.setTargetQName(targetQName);
		base.setNamedObject(named);
		named.setAnonymous(false);

		base.setTargetQName(targetQName2);
	}

	/**
	 * Target name not null and named object not null and anonymous => no exception
	 **/
	@Test
	public void test4() {
		base.setTargetQName(targetQName);
		base.setNamedObject(named);
		named.setAnonymous(true);
		base.setTargetQName(targetQName2);
		aeq(targetQName2, base.getTargetQName());
		aeq(2, base.getForgetCount());
	}

	/**
	 * Target name not null and named object null => no exception
	 **/
	@Test
	public void test5() {
		base.setTargetQName(targetQName);
		base.setTargetQName(targetQName2);
		aeq(targetQName2, base.getTargetQName());
		aeq(2, base.getForgetCount());
	}

	/**
	 * Target name null => no exception
	 **/
	@Test
	public void test6() {
		base.setTargetQName(targetQName);
		base.setTargetQName(null);
		an(base.getTargetQName());
		aeq(2, base.getForgetCount());
	}

}

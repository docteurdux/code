package dux.org.powermock.reflect.internal;

import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.internal.TypeUtils;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class TypeUtilsTest extends AbstractTest {
	@Before
	public void before() {
		requireSources("powermock-reflect-1.6.4", TypeUtils.class);
	}

	@Test
	public void test1() {
		aeq("", TypeUtils.getDefaultValue((String) null));
		aeq((byte) 0, TypeUtils.getDefaultValue("byte"));
		aeq(0, TypeUtils.getDefaultValue("int"));
		aeq((short) 0, TypeUtils.getDefaultValue("short"));
		aeq(0L, TypeUtils.getDefaultValue("long"));
		aeq(0F, TypeUtils.getDefaultValue("float"));
		aeq(0D, TypeUtils.getDefaultValue("double"));
		aeq(false, TypeUtils.getDefaultValue("boolean"));
		aeq(' ', TypeUtils.getDefaultValue("char"));
		aeq(null, TypeUtils.getDefaultValue("anything"));
	}

	@Test
	public void test2() {
		aeq("", TypeUtils.getDefaultValueAsString((String) null));
		aeq("(byte) 0", TypeUtils.getDefaultValueAsString("byte"));
		aeq("0", TypeUtils.getDefaultValueAsString("int"));
		aeq("(short) 0", TypeUtils.getDefaultValueAsString("short"));
		aeq("0L", TypeUtils.getDefaultValueAsString("long"));
		aeq("0.0F", TypeUtils.getDefaultValueAsString("float"));
		aeq("0.0D", TypeUtils.getDefaultValueAsString("double"));
		aeq("false", TypeUtils.getDefaultValueAsString("boolean"));
		aeq("' '", TypeUtils.getDefaultValueAsString("char"));
		aeq("null", TypeUtils.getDefaultValueAsString("anything"));
	}

	@Test
	public void test4() {
		aeq(TypeUtils.getDefaultValue("int"), TypeUtils.getDefaultValue(int.class));
	}
}

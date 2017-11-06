package dux;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

public class MiscTest extends AbstractTest {

	public static enum MyEnum {
		A, B
	};

	@Test(expected = NullPointerException.class)
	public void test1() {
		an(MyEnum.valueOf(null));
	}

	@Test(expected = NullPointerException.class)
	public void test2() {
		String output = null;
		MyEnum foo = null;
		switch (foo) {
		case A:
			output = "A";
			break;
		case B:
			output = "B";
			break;
		default:
			output = "default";
		}
		aeq("default", output);
	}

	@Test
	public void test3() {
		aeq("null", null + "");
	}

}

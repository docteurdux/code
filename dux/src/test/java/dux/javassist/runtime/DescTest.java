package dux.javassist.runtime;

import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;

import javassist.runtime.Desc;

public class DescTest extends AbstractTest {

	@Before
	public void before() {
		requireSources("javassist-3.20.0-GA.jar", Desc.class);
	}

	@Test
	public void test() {

		@SuppressWarnings("rawtypes")
		Class[] result = null;

		result = Desc.getParams("(Z");
		aeq(1, result.length);
		aeq(boolean.class, result[0]);

		result = Desc.getParams("(C");
		aeq(1, result.length);
		aeq(char.class, result[0]);

		result = Desc.getParams("(B");
		aeq(1, result.length);
		aeq(byte.class, result[0]);

		result = Desc.getParams("(S");
		aeq(1, result.length);
		aeq(short.class, result[0]);

		result = Desc.getParams("(I");
		aeq(1, result.length);
		aeq(int.class, result[0]);

		result = Desc.getParams("(J");
		aeq(1, result.length);
		aeq(long.class, result[0]);

		result = Desc.getParams("(F");
		aeq(1, result.length);
		aeq(float.class, result[0]);

		result = Desc.getParams("(D");
		aeq(1, result.length);
		aeq(double.class, result[0]);

		result = Desc.getParams("(V");
		aeq(1, result.length);
		aeq(void.class, result[0]);

		result = Desc.getParams("(VV");
		aeq(2, result.length);
		aeq(void.class, result[0]);
		aeq(void.class, result[1]);

		result = Desc.getParams("(Ljava.lang.String;");
		aeq(1, result.length);
		aeq(String.class, result[0]);

		result = Desc.getParams("([I");
		aeq(1, result.length);
		aeq(int[].class, result[0]);

		result = Desc.getParams("([[I");
		aeq(1, result.length);
		aeq(int[][].class, result[0]);

		result = Desc.getParams("([[Ljava.lang.String;");
		aeq(1, result.length);
		aeq(String[][].class, result[0]);

		result = Desc.getParams("(?");
		aeq(0, result.length);

		aeq(void.class, Desc.getType("V"));
		aeq(String.class, Desc.getType("Ljava.lang.String;"));
		aeq(String[].class, Desc.getType("[Ljava.lang.String;"));

		aeq(String.class, Desc.getClazz("java.lang.String"));

	}
}

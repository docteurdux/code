package dux.org.hibernate.result.internal;

import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class UpdateCountOutputImplTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		Class<?> clazz = Class.forName("org.hibernate.result.internal.UpdateCountOutputImpl");

		Object instance = instantiate(clazz, new Class<?>[] { int.class }, 7);

		aeq(7, invoke(instance, "getUpdateCount"));

		af((Boolean) invoke(instance, "isResultSet"));

	}
}

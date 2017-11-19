package dux.org.hibernate.procedure.internal;

import java.lang.reflect.Constructor;

import org.hibernate.procedure.internal.ParameterBindImpl;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ParameterBindImplTest extends AbstractTest {
	@Test
	public void test() {
		for (Constructor<?> constructor : ParameterBindImpl.class.getDeclaredConstructors()) {
			at(isPackage(constructor));
		}
	}
}

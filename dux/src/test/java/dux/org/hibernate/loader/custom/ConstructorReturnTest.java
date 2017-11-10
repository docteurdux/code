package dux.org.hibernate.loader.custom;

import org.hibernate.loader.custom.ConstructorReturn;
import org.hibernate.loader.custom.ScalarReturn;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class ConstructorReturnTest extends AbstractTest {

	@Test
	public void test() {

		Class<?> targetClass = Object.class;
		ScalarReturn[] scalars = new ScalarReturn[] {};

		ConstructorReturn cr = new ConstructorReturn(targetClass, scalars);

		aeqr(targetClass, cr.getTargetClass());
		aeqr(scalars, cr.getScalars());
	}
}

package dux.org.hibernate.loader.plan.build.internal.returns;

import org.hibernate.loader.plan.build.internal.returns.ScalarReturnImpl;
import org.hibernate.type.Type;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

import dum.org.hibernate.type.DummyType;

@Done
public class ScalarReturnImplTest extends AbstractTest {
	@Test
	public void test() {

		String name = "name";
		Type type = new DummyType();

		ScalarReturnImpl sri = new ScalarReturnImpl(name, type);

		aeq(name, sri.getName());
		aeqr(type, sri.getType());

	}
}

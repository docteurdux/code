package dux.org.hibernate.dialect;

import org.hibernate.dialect.DerbyTenFiveDialect;
import org.hibernate.dialect.DerbyTenSixDialect;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class DerbyTenSixDialectTest extends AbstractTest {
	@Test
	public void test() {

		aeq(DerbyTenFiveDialect.class, DerbyTenSixDialect.class.getSuperclass());

		af(new DerbyTenFiveDialect().supportsSequences());
		at(new DerbyTenSixDialect().supportsSequences());

	}
}

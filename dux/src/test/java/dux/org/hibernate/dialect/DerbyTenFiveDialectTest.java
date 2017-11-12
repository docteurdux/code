package dux.org.hibernate.dialect;

import org.hibernate.dialect.DerbyDialect;
import org.hibernate.dialect.DerbyTenFiveDialect;
import org.hibernate.dialect.function.AnsiTrimFunction;
import org.hibernate.dialect.function.DerbyConcatFunction;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
@SuppressWarnings("deprecation")
public class DerbyTenFiveDialectTest extends AbstractTest {
	@Test
	public void test() {

		aeq(DerbyDialect.class, DerbyTenFiveDialect.class.getSuperclass());

		DerbyTenFiveDialect dialect = new DerbyTenFiveDialect();

		aeq(false, dialect.supportsSequences());
		aeq(true, dialect.supportsLimit());
		aeq(true, dialect.supportsLimitOffset());

		aeq(86, dialect.getFunctions().size());
		aeq(DerbyConcatFunction.class, dialect.getFunctions().get("concat").getClass());
		aeq(AnsiTrimFunction.class, dialect.getFunctions().get("trim").getClass());
	}
}

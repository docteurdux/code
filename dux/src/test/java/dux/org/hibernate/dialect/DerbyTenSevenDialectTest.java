package dux.org.hibernate.dialect;

import org.hibernate.dialect.DerbyTenSevenDialect;
import org.hibernate.dialect.DerbyTenSixDialect;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class DerbyTenSevenDialectTest extends AbstractTest {

	@Test
	public void test() {

		aeq(DerbyTenSixDialect.class, DerbyTenSevenDialect.class.getSuperclass());

		DerbyTenSixDialect dialect_10_6 = new DerbyTenSixDialect();

		af(dialect_10_6.isTypeNameRegistered("boolean"));
		aeq("1", dialect_10_6.toBooleanValueString(true));
		aeq("0", dialect_10_6.toBooleanValueString(false));

		DerbyTenSevenDialect dialect_10_7 = new DerbyTenSevenDialect();
		at(dialect_10_7.isTypeNameRegistered("boolean"));
		aeq("true", dialect_10_7.toBooleanValueString(true));
		aeq("false", dialect_10_7.toBooleanValueString(false));
	}

}

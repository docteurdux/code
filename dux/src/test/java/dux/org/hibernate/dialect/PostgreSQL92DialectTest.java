package dux.org.hibernate.dialect;

import org.hibernate.dialect.PostgreSQL91Dialect;
import org.hibernate.dialect.PostgreSQL92Dialect;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PostgreSQL92DialectTest extends AbstractTest {
	@Test
	public void test() {
		aeq(PostgreSQL91Dialect.class, PostgreSQL92Dialect.class.getSuperclass());

		PostgreSQL91Dialect dialect91 = new PostgreSQL91Dialect();
		af(dialect91.supportsIfExistsAfterAlterTable());
		af(dialect91.isTypeNameRegistered("json"));

		PostgreSQL92Dialect dialect92 = new PostgreSQL92Dialect();
		at(dialect92.supportsIfExistsAfterAlterTable());
		at(dialect92.isTypeNameRegistered("json"));

	}
}

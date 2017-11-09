package dux.org.hibernate.dialect;

import org.hibernate.dialect.PostgreSQL91Dialect;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PostgreSQL91DialectTest extends AbstractTest {
	@Test
	public void test() {

		aeq(PostgreSQL9Dialect.class, PostgreSQL91Dialect.class.getSuperclass());

		PostgreSQL91Dialect dialect91 = new PostgreSQL91Dialect();
		at(dialect91.supportsPartitionBy());
		at(dialect91.supportsNonQueryWithCTE());

		PostgreSQL9Dialect dialect9 = new PostgreSQL9Dialect();
		af(dialect9.supportsPartitionBy());
		af(dialect9.supportsNonQueryWithCTE());
	}
}

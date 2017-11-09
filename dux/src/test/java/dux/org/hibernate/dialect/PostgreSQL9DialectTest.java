package dux.org.hibernate.dialect;

import org.hibernate.dialect.PostgreSQL82Dialect;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class PostgreSQL9DialectTest extends AbstractTest {
	@Test
	public void test() {

		aeq(PostgreSQL82Dialect.class, PostgreSQL9Dialect.class.getSuperclass());

		af(new PostgreSQL82Dialect().supportsIfExistsBeforeConstraintName());
		at(new PostgreSQL9Dialect().supportsIfExistsBeforeConstraintName());

	}
}

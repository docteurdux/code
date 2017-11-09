package dux.org.hibernate.dialect;

import org.hibernate.dialect.PostgreSQL82Dialect;
import org.hibernate.dialect.PostgreSQLDialect;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@SuppressWarnings("deprecation")
@Done
public class PostgreSQLDialectTest extends AbstractTest {

	@Test
	public void test() {

		aeq(PostgreSQL82Dialect.class, PostgreSQLDialect.class.getSuperclass());

		at(PostgreSQLDialect.class.isAnnotationPresent(Deprecated.class));

	}
}

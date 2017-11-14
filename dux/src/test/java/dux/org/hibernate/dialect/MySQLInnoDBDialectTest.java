package dux.org.hibernate.dialect;

import org.hibernate.dialect.InnoDBStorageEngine;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.MySQLInnoDBDialect;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
@SuppressWarnings("deprecation")
public class MySQLInnoDBDialectTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		at(MySQLInnoDBDialect.class.isAnnotationPresent(Deprecated.class));

		aeq(MySQLDialect.class, MySQLInnoDBDialect.class.getSuperclass());

		aeqr(InnoDBStorageEngine.INSTANCE, invoke(new MySQLInnoDBDialect(), "getDefaultMySQLStorageEngine"));
	}
}

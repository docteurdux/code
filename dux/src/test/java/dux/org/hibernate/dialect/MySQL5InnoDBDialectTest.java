package dux.org.hibernate.dialect;

import org.hibernate.dialect.InnoDBStorageEngine;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.MySQL5InnoDBDialect;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
@SuppressWarnings("deprecation")
public class MySQL5InnoDBDialectTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		at(MySQL5InnoDBDialect.class.isAnnotationPresent(Deprecated.class));

		aeq(MySQL5Dialect.class, MySQL5InnoDBDialect.class.getSuperclass());

		aeq(InnoDBStorageEngine.INSTANCE, invoke(new MySQL5InnoDBDialect(), "getDefaultMySQLStorageEngine"));
	}
}

package dux.org.hibernate.dialect;

import org.hibernate.dialect.InnoDBStorageEngine;
import org.hibernate.dialect.MySQL55Dialect;
import org.hibernate.dialect.MySQL5Dialect;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class MySQL55DialectTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		aeq(MySQL5Dialect.class, MySQL55Dialect.class.getSuperclass());

		aeqr(InnoDBStorageEngine.INSTANCE, invoke(new MySQL55Dialect(), "getDefaultMySQLStorageEngine"));
	}
}

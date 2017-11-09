package dux.org.hibernate.dialect.unique;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.unique.DefaultUniqueDelegate;
import org.hibernate.dialect.unique.MySQLUniqueDelegate;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class MySQLUniqueDelegateTest extends AbstractTest {
	@Test
	public void test() throws Exception {

		aeq(DefaultUniqueDelegate.class, MySQLUniqueDelegate.class.getSuperclass());

		Dialect dialect = new Dialect() {
		};
		MySQLUniqueDelegate mud = new MySQLUniqueDelegate(dialect);
		aeq(" drop index ", invoke(mud, "getDropUnique"));

	}
}

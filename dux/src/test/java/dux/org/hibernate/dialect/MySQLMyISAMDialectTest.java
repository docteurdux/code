package dux.org.hibernate.dialect;

import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.MySQLMyISAMDialect;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
@SuppressWarnings("deprecation")
public class MySQLMyISAMDialectTest extends AbstractTest {
	@Test
	public void test() {

		at(MySQLMyISAMDialect.class.isAnnotationPresent(Deprecated.class));

		aeq(MySQLDialect.class, MySQLMyISAMDialect.class.getSuperclass());

		MySQLMyISAMDialect dialect = new MySQLMyISAMDialect();
		aeq(" type=MyISAM", dialect.getTableTypeString());
		af(dialect.dropConstraints());

	}

}

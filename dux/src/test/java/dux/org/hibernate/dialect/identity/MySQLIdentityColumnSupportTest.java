
package dux.org.hibernate.dialect.identity;

import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.dialect.identity.MySQLIdentityColumnSupport;
import org.junit.Before;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class MySQLIdentityColumnSupportTest extends AbstractTest {

	private String anyTable;
	private String anyColumn;
	private int anyType;

	@Before
	public void before() {
		anyTable = "anyTable";
		anyColumn = "anyColumn";
		anyType = 0;
	}

	@Test
	public void test() {

		aeq(IdentityColumnSupportImpl.class, MySQLIdentityColumnSupport.class.getSuperclass());

		MySQLIdentityColumnSupport ics = new MySQLIdentityColumnSupport();

		at(ics.supportsIdentityColumns());
		aeq("select last_insert_id()", ics.getIdentitySelectString(anyTable, anyColumn, anyType));
		aeq("not null auto_increment", ics.getIdentityColumnString(anyType));

	}
}

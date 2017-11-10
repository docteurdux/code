package dux.org.hibernate.dialect.identity;

import org.hibernate.dialect.identity.AbstractTransactSQLIdentityColumnSupport;
import org.hibernate.dialect.identity.SQLServerIdentityColumnSupport;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class SQLServerIdentityColumnSupportTest extends AbstractTest {

	@Test
	public void test() {

		aeq(AbstractTransactSQLIdentityColumnSupport.class, SQLServerIdentityColumnSupport.class.getSuperclass());

		SQLServerIdentityColumnSupport ics = new SQLServerIdentityColumnSupport();

		aeq("insert select scope_identity()", ics.appendIdentitySelectToInsert("insert"));

	}
}

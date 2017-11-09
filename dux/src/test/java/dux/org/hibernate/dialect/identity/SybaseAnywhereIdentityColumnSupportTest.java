package dux.org.hibernate.dialect.identity;

import org.hibernate.dialect.identity.AbstractTransactSQLIdentityColumnSupport;
import org.hibernate.dialect.identity.SybaseAnywhereIdentityColumnSupport;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class SybaseAnywhereIdentityColumnSupportTest extends AbstractTest {
	@Test
	public void test() {
		aeq(AbstractTransactSQLIdentityColumnSupport.class, SybaseAnywhereIdentityColumnSupport.class.getSuperclass());

		af(new SybaseAnywhereIdentityColumnSupport().supportsInsertSelectIdentity());

		at(new AbstractTransactSQLIdentityColumnSupport() {
		}.supportsInsertSelectIdentity());
	}
}

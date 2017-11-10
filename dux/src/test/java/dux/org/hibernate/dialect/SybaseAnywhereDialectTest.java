package dux.org.hibernate.dialect;

import org.hibernate.dialect.SybaseAnywhereDialect;
import org.hibernate.dialect.SybaseDialect;
import org.hibernate.dialect.identity.AbstractTransactSQLIdentityColumnSupport;
import org.hibernate.dialect.identity.SybaseAnywhereIdentityColumnSupport;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class SybaseAnywhereDialectTest extends AbstractTest {

	@Test
	public void test() {

		aeq(SybaseDialect.class, SybaseAnywhereDialect.class.getSuperclass());

		SybaseDialect sybaseDialect = new SybaseDialect();
		SybaseAnywhereDialect sybaseAnywhereDialect = new SybaseAnywhereDialect();

		at(sybaseDialect.dropConstraints());
		af(sybaseAnywhereDialect.dropConstraints());

		aeq("values ( )", sybaseDialect.getNoColumnsInsertString());
		aeq("values (default)", sybaseAnywhereDialect.getNoColumnsInsertString());

		aeq(AbstractTransactSQLIdentityColumnSupport.class, sybaseDialect.getIdentityColumnSupport().getClass());
		aeq(SybaseAnywhereIdentityColumnSupport.class, sybaseAnywhereDialect.getIdentityColumnSupport().getClass());

	}
}

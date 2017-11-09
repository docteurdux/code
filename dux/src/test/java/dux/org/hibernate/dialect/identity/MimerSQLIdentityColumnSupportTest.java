package dux.org.hibernate.dialect.identity;

import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.dialect.identity.MimerSQLIdentityColumnSupport;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class MimerSQLIdentityColumnSupportTest extends AbstractTest {

	@Test
	public void test() {

		aeq(IdentityColumnSupportImpl.class, MimerSQLIdentityColumnSupport.class.getSuperclass());

		af(new IdentityColumnSupportImpl().supportsIdentityColumns());
		af(new MimerSQLIdentityColumnSupport().supportsIdentityColumns());

	}
}

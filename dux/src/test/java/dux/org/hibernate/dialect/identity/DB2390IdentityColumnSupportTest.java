package dux.org.hibernate.dialect.identity;

import org.hibernate.dialect.identity.DB2390IdentityColumnSupport;
import org.hibernate.dialect.identity.DB2IdentityColumnSupport;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class DB2390IdentityColumnSupportTest extends AbstractTest {
	@Test
	public void test() {

		aeq(DB2IdentityColumnSupport.class, DB2390IdentityColumnSupport.class.getSuperclass());

		String anyTable = "";
		String anyColumn = "";
		int anyType = 0;
		aeq("select identity_val_local() from sysibm.sysdummy1",
				new DB2390IdentityColumnSupport().getIdentitySelectString(anyTable, anyColumn, anyType));

	}
}

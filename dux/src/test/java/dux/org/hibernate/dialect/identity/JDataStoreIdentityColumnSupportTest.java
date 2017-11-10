package dux.org.hibernate.dialect.identity;

import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.dialect.identity.JDataStoreIdentityColumnSupport;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class JDataStoreIdentityColumnSupportTest extends AbstractTest {

	private String anyTable = "anyTable";
	private String anyColumn = "anyColumn";
	private int anyType = 0;

	@Test
	public void test() {

		aeq(IdentityColumnSupportImpl.class, JDataStoreIdentityColumnSupport.class.getSuperclass());

		JDataStoreIdentityColumnSupport ics = new JDataStoreIdentityColumnSupport();

		at(ics.supportsIdentityColumns());
		an(ics.getIdentitySelectString(anyTable, anyColumn, anyType));
		aeq("autoincrement", ics.getIdentityColumnString(anyType));

	}
}

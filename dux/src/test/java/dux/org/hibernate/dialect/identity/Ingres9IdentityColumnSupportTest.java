package dux.org.hibernate.dialect.identity;

import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.dialect.identity.Ingres9IdentityColumnSupport;
import org.junit.Test;

import com.github.docteurdux.test.AbstractTest;
import com.github.docteurdux.test.Done;

@Done
public class Ingres9IdentityColumnSupportTest extends AbstractTest {

	@Test
	public void test() throws Exception {

		aeq(IdentityColumnSupportImpl.class, Ingres9IdentityColumnSupport.class.getSuperclass());

		String anyTable = "";
		String anyColumn = "";
		int anyType = 0;

		Ingres9IdentityColumnSupport support = new Ingres9IdentityColumnSupport();

		aeq("select last_identity()", support.getIdentitySelectString(anyTable, anyColumn, anyType));

	}

}
